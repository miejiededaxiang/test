package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by htl on 2018/4/18.
 */

public class ProgressView extends LinearLayout {


	private LayoutInflater mLayoutInflater;

	public ProgressView(Context context) {
		this(context, null);
	}

	public ProgressView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ProgressView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setWillNotDraw(false);
		setOrientation(HORIZONTAL);
		mLayoutInflater = LayoutInflater.from(context);
		addView(new leftView(context), LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	}

	public void setView(View view) {
		addView(view, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		LayoutParams layoutParams = new LayoutParams(view.getLayoutParams());
		layoutParams.leftMargin = 200;
		view.setLayoutParams(layoutParams);
		setGravity(Gravity.CENTER_VERTICAL);
	}


	class leftView extends View {
		private Paint mLinePaint, mPaint;
		private int lineColor, circleColor;
		private int radio = 10;

		public leftView(Context context) {
			this(context, null);
		}

		public leftView(Context context, AttributeSet attrs) {
			this(context, attrs, 0);
		}

		public leftView(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);

			mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			mPaint.setColor(circleColor);

			mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
			mLinePaint.setColor(lineColor);
			mLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
			mLinePaint.setStrokeWidth(2);
		}


		public void setCircleColor(int circleColor) {
			mPaint.setColor(circleColor);
			invalidate();
		}


		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

			int widthSize = resolveSize(radio * 2, widthMeasureSpec);
			setMeasuredDimension(widthSize, heightMeasureSpec);
		}

		@Override
		protected void onDraw(Canvas canvas) {

			canvas.drawLine(radio, 0, radio, getHeight() / 2 - radio, mLinePaint);
			canvas.drawCircle(radio, getHeight() / 2, radio, mPaint);
			canvas.drawLine(radio, getHeight() / 2 + radio, radio, getHeight(), mLinePaint);

		}
	}
}
