package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.htl.myapplacation.utils.Utils;

/**
 * Created by htl on 2018/4/19.
 */

public class MyView extends ViewGroup {


	private Paint mLinePaint;
	private Paint mTextPaint;
	private int width;
	private int sectionLength;//每段的长度
	private int marginTop, textMarginTop;//线距离顶部、下面文字距离线的距离
	private MyViewTwo mMyView;
	private MyViewTwo mMyView2;
	private int textWidth;
	private int lineLength;
	private ViewDragHelper mViewDragHelper;

	public MyView(Context context) {
		this(context, null);
	}

	public MyView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);


		marginTop = Utils.dp2px(context, 100);
		textMarginTop = Utils.dp2px(context, 120);
		initPaint();
		mMyView = new MyViewTwo(context);
		mMyView2 = new MyViewTwo(context);
		addView(mMyView);
		addView(mMyView2);
		setWillNotDraw(false);
		mViewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
			@Override
			public boolean tryCaptureView(View child, int pointerId) {
				return false;
			}
		});
	}

	private void initPaint() {
		mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mLinePaint.setStyle(Paint.Style.FILL);
		mLinePaint.setStrokeWidth(Utils.dp2px(getContext(), 4));
		mLinePaint.setColor(Color.RED);

		mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mTextPaint.setStyle(Paint.Style.FILL);
		mTextPaint.setTextSize(Utils.sp2px(getContext(), 16));


	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		width = getMeasuredWidth();
		textWidth = (int) mTextPaint.measureText("不限");
		lineLength = width - textWidth;
		sectionLength = lineLength / 7;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		measureChildren(widthMeasureSpec, heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}


	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {

		if (changed) {
		}
		int left = textWidth / 2;
		int top = marginTop - mMyView.getMeasuredHeight() / 2;
		int rignt = left + mMyView.getMeasuredWidth();
		int bottom = marginTop + mMyView.getMeasuredHeight() / 2;
		mMyView.layout(left, top, rignt, bottom);
		Log.d("htl", "onLayout: " + mMyView.getMeasuredHeight() + "---" + mMyView.getMeasuredWidth() + "--" + left + "--" + top + "--" + rignt + "--" + bottom);

		int rignt1 = getMeasuredWidth() - textWidth / 2;
		int left1 = rignt1 - getPaddingRight() - mMyView2.getMeasuredWidth();
		int top1 = marginTop - mMyView2.getMeasuredHeight() / 2;
		int bottom1 = marginTop + mMyView2.getMeasuredHeight() / 2;
		mMyView2.layout(left1, top1, rignt1, bottom1);

		Log.d("htl", "onLayout: " + r + "----" + getMeasuredWidth() + "---" + mMyView2.getMeasuredHeight() + "---" + mMyView2.getMeasuredWidth() + "--" + left1 + "--" + top1 + "--" + rignt1 + "--" + bottom1);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		;

		canvas.drawLine(textWidth / 2, marginTop, width - textWidth / 2, marginTop, mLinePaint);

		for (int i = 0; i < 7; i++) {
			String text = i * 2 + "";
			Rect rect = new Rect();

			mTextPaint.getTextBounds(text, 0, text.length(), rect);
			canvas.drawText(text, textWidth / 2 + (i * sectionLength) - rect.width() / 2, textMarginTop, mTextPaint);
		}


		canvas.drawText("不限", width - textWidth, textMarginTop, mTextPaint);
	}


}
