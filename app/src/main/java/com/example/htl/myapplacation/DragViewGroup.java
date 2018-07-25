package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;

/**
 * Created by htl on 2018/5/22.
 */

public class DragViewGroup extends RelativeLayout {
	private static final String TAG = "htl";
	private int mSlip;
	private float mLastPointX, mLastPointY;
	private View mDragView;
	private State mCurSta = State.IDLE;
	private float originX, originY;
	private ViewDragHelper mViewDragHelper;

	enum State {
		IDLE,
		DRAGING
	}


	public DragViewGroup(Context context) {
		this(context, null);
	}

	public DragViewGroup(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DragViewGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		mSlip = ViewConfiguration.get(context).getScaledTouchSlop();
		mViewDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
			@Override
			public boolean tryCaptureView(View child, int pointerId) {
				return true;
			}

			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx) {
				return left;
			}

			@Override
			public int clampViewPositionVertical(View child, int top, int dy) {
				return top;
			}

			@Override
			public void onViewReleased(View releasedChild, float xvel, float yvel) {
				super.onViewReleased(releasedChild, xvel, yvel);
//				mViewDragHelper.settleCapturedViewAt((int) originX, (int) originY);
//				invalidate();

//				removeView(releasedChild);
//				addView(releasedChild,0);
			}


			@Override
			public int getViewHorizontalDragRange(View child) {
				return 1;
			}

			@Override
			public int getViewVerticalDragRange(View child) {
				return 1;
			}


		});
	}

	@Override
	public void computeScroll() {
		super.computeScroll();

		if(mViewDragHelper != null && mViewDragHelper.continueSettling(true)){
			invalidate();
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {

		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.d(TAG, "onInterceptTouchEvent: ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d(TAG, "onInterceptTouchEvent: ACTION_MOVE");

				break;
			case MotionEvent.ACTION_UP:
				Log.d(TAG, "onInterceptTouchEvent: ACTION_UP");

				break;
		}

		boolean result = mViewDragHelper.shouldInterceptTouchEvent(ev);
		Log.d(TAG, "onInterceptTouchEvent: " + result);
		return mViewDragHelper.shouldInterceptTouchEvent(ev);

	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.d(TAG, "onTouchEvent: ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d(TAG, "onTouchEvent: ACTION_MOVE");

				break;
			case MotionEvent.ACTION_UP:
				Log.d(TAG, "onTouchEvent: ACTION_UP");

				break;
		}


//		int action = event.getAction();
//		switch (action) {
//			case MotionEvent.ACTION_DOWN:
//
//				if (isPointOnViews(event)) {
//					mCurSta = State.DRAGING;
//					mLastPointX = event.getX();
//					mLastPointY = event.getY();
//				}
//				break;
//
//			case MotionEvent.ACTION_MOVE:
//				int deletX = (int) (event.getX() - mLastPointX);
//				int deletY = (int) (event.getY() - mLastPointY);
//
//				if (mCurSta == State.DRAGING && mDragView != null && (Math.abs(deletX) >= mSlip || Math.abs(deletY) >= mSlip)) {
//					ViewCompat.offsetLeftAndRight(mDragView, deletX);
//					ViewCompat.offsetTopAndBottom(mDragView, deletY);
//				}
//
//				mLastPointX = event.getX();
//				mLastPointY = event.getY();
//				break;
//			case MotionEvent.ACTION_UP:
//
//
//				if (mCurSta == State.DRAGING) {
//					if (mDragView != null) {
//						ValueAnimator valueAnimatorX = ValueAnimator.ofFloat(mDragView.getX(), originX);
//						valueAnimatorX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//							@Override
//							public void onAnimationUpdate(ValueAnimator animation) {
//								mDragView.setX((Float) animation.getAnimatedValue());
//							}
//						});
//
//						ValueAnimator valueAnimatorY = ValueAnimator.ofFloat(mDragView.getY(), originY);
//						valueAnimatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//							@Override
//							public void onAnimationUpdate(ValueAnimator animation) {
//								mDragView.setY((Float) animation.getAnimatedValue());
//							}
//						});
//
//						AnimatorSet set = new AnimatorSet();
//						set.play(valueAnimatorX).with(valueAnimatorY);
//						set.start();
//
//
//					} else {
//						mDragView = null;
//					}
//
//					mCurSta = State.IDLE;
//				}
//				break;
//		}

		mViewDragHelper.processTouchEvent(event);
		return true;

	}


	private boolean isPointOnViews(MotionEvent ev) {

		boolean isViewDraw = false;
		Rect rect = new Rect();
		for (int i = getChildCount() - 1; i >= 0; i--) {
			View childView = getChildAt(i);
			int left = (int) childView.getX();
			int top = (int) childView.getY();
			int right = left + childView.getMeasuredWidth();
			int bottom = top + childView.getMeasuredHeight();


			childView.getX();
			rect.set(left, top, right, bottom);

			int x = (int) ev.getX();
			int y = (int) ev.getY();
			if (rect.contains(x, y)) {
				originX = childView.getX();
				originY = childView.getY();
				mDragView = childView;
				isViewDraw = true;
				break;
			}
		}

		return isViewDraw && mCurSta == State.IDLE;
	}
}
