package com.example.htl.myapplacation;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by htl on 2018/5/7.
 */

public class SlideDelete extends ViewGroup {

	private View mContentView;
	private View mDeleteView;
	private ViewDragHelper mViewDragHelper;
	private int mContentWidth, mDeleteWidth;
	private int height;
	private boolean isShow;
	private boolean isSwip;
	private OnShowDeleteViewListener mViewListener;

	public void setViewListener(OnShowDeleteViewListener viewListener) {
		mViewListener = viewListener;
	}

	public SlideDelete(Context context) {
		this(context, null);
	}

	public SlideDelete(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public SlideDelete(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mViewDragHelper = ViewDragHelper.create(this, new MyDrawHelper());
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return mViewDragHelper.shouldInterceptTouchEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		mViewDragHelper.processTouchEvent(event);
		return true;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


		int width = 0;
		int viewHieght = 0;
		View childView = null;

		if (getChildCount() > 0) {
			childView = getChildAt(0);
			measureChild(childView, widthMeasureSpec, heightMeasureSpec);
			viewHieght = getChildAt(0).getMeasuredHeight();
			measureChild(getChildAt(1), widthMeasureSpec, MeasureSpec.makeMeasureSpec(viewHieght, MeasureSpec.EXACTLY));
		}

		for (int i = 0; i < getChildCount(); i++) {
			View view = getChildAt(i);
			width += view.getMeasuredWidth();
		}

		setMeasuredDimension(MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY), resolveSize(viewHieght, heightMeasureSpec));

		Log.d("htl", "onMeasure:- " + getMeasuredWidth());

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		mContentWidth = mContentView.getMeasuredWidth();
		mDeleteWidth = mDeleteView.getMeasuredWidth();
		height = mContentView.getMeasuredHeight();
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;
		for (int i = 0; i < getChildCount(); i++) {
			View view = getChildAt(i);
			left = right;
			right += view.getMeasuredWidth();
			bottom = view.getMeasuredHeight();
			view.layout(left, top, right, bottom);
		}
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();

		mContentView = getChildAt(0);
		mDeleteView = getChildAt(1);

	}

	public boolean isSwip() {
		return isSwip;
	}

	public void setSwip(boolean swip) {
		isSwip = swip;
	}

	class MyDrawHelper extends ViewDragHelper.Callback {
		@Override
		public boolean tryCaptureView(View child, int pointerId) {
			return (mContentView == child || mDeleteView == child) && isSwip;
		}

		@Override
		public int clampViewPositionHorizontal(View child, int left, int dx) {
			if (child == mContentView) {
				if (left > 0) {
					return 0;
				} else if (-left > mDeleteWidth) {
					return -mDeleteWidth;
				}
			} else {
				if (left > mContentWidth) {
					return mContentWidth;
				} else if (left < (mContentWidth - mDeleteWidth)) {
					return mContentWidth - mDeleteWidth;
				}
			}
			return left;
		}

		@Override
		public int getViewHorizontalDragRange(View child) {
			return getMeasuredWidth() - child.getMeasuredWidth();
		}

		@Override
		public int getViewVerticalDragRange(View child) {
			return getMeasuredHeight() - child.getMeasuredHeight();
		}

		@Override
		public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
			invalidate();
			int mContentHeight = mContentView.getMeasuredHeight();
			int mDeleteHeight = mDeleteView.getMeasuredHeight();
//			super.onViewPositionChanged(changedView, left, top, dx, dy);
			if (changedView == mContentView) { // 如果移动的是mContent
				//我们移动mContent的实惠要相应的联动改变mDelete的位置
				// 怎么改变mDelete的位置，当然是mDelete的layput方法啦
				int tempDeleteLeft = mContentWidth + left;
				int tempDeleteRight = mContentWidth + left + mDeleteWidth;
				mDeleteView.layout(tempDeleteLeft, 0, tempDeleteRight, mDeleteHeight);
			} else { // touch的是mDelete
				int tempContentLeft = left - mContentWidth;
				int tempContentRight = left;
				mContentView.layout(tempContentLeft, 0, tempContentRight, mContentHeight);
			}
		}

		@Override
		public void onViewReleased(View releasedChild, float xvel, float yvel) {
			Log.d("htl", "onViewReleased: ---" + xvel + "---" + yvel);
			super.onViewReleased(releasedChild, xvel, yvel);
			int left = mContentView.getLeft();


			if (!isShow) {
				if (-left > mDeleteWidth / 3) {//展示
					Log.d("htl", "onViewReleased: 展示");
					if (mViewListener != null) {
						mViewListener.openDeleteView(SlideDelete.this);
					} else {
						showDeleteView();
					}

//				ViewCompat.offsetLeftAndRight(mContentView, -(mDeleteWidth+left));
//				ViewCompat.offsetLeftAndRight(mDeleteView, -(mDeleteWidth+left));
//				mContentView.layout(-mDeleteWidth, 0, mContentWidth - mDeleteWidth, height);
//				mDeleteView.layout(mContentWidth - mDeleteWidth, 0, mContentWidth, height);
				} else {//回弹

					Log.d("htl", "onViewReleased:回弹 ");
					disDeleteView();
//
// if (mViewListener != null) {
//						mViewListener.closeDeleteView(SlideDelete.this);
//					}

//				mContentView.layout(0, 0, mContentWidth, getMeasuredHeight());
//				mDeleteView.layout(mContentWidth, 0, mContentWidth + mDeleteWidth, height);
//				ViewCompat.offsetLeftAndRight(mContentView, -left);
//				ViewCompat.offsetLeftAndRight(mDeleteView, -left);
				}
			} else {
				if (-left > mDeleteWidth * 2 / 3) {//展示
					Log.d("htl", "onViewReleased2: 展示");
					showDeleteView();
//				ViewCompat.offsetLeftAndRight(mContentView, -(mDeleteWidth+left));
//				ViewCompat.offsetLeftAndRight(mDeleteView, -(mDeleteWidth+left));
//				mContentView.layout(-mDeleteWidth, 0, mContentWidth - mDeleteWidth, height);
//				mDeleteView.layout(mContentWidth - mDeleteWidth, 0, mContentWidth, height);
				} else {//回弹
					Log.d("htl", "onViewReleased2:回弹 ");

					if (mViewListener != null) {
						mViewListener.closeDeleteView(SlideDelete.this);
					}
//				mContentView.layout(0, 0, mContentWidth, getMeasuredHeight());
//				mDeleteView.layout(mContentWidth, 0, mContentWidth + mDeleteWidth, height);
//				ViewCompat.offsetLeftAndRight(mContentView, -left);
//				ViewCompat.offsetLeftAndRight(mDeleteView, -left);
				}
			}


		}


	}


	interface OnShowDeleteViewListener {
		void openDeleteView(SlideDelete slideDelete);

		void closeDeleteView(SlideDelete slideDelete);
	}


	public void disDeleteView() {
		isShow = false;
		mViewDragHelper.smoothSlideViewTo(mDeleteView, mContentWidth, 0);
		mViewDragHelper.smoothSlideViewTo(mContentView, 0, 0);
		invalidate();
	}

	public void showDeleteView() {
		isShow = true;
		mViewDragHelper.smoothSlideViewTo(mDeleteView, mContentWidth - mDeleteWidth, 0);
		mViewDragHelper.smoothSlideViewTo(mContentView, -mDeleteWidth, 0);
		invalidate();
	}


	@Override
	public void computeScroll() {
		super.computeScroll();

		if (mViewDragHelper.continueSettling(true)) {
			invalidate();
		}
	}


	public int getContentWidth() {
		return mContentWidth;
	}


	public int getDeleteWidth() {
		return mDeleteWidth;
	}

}
