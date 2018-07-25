package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.htl.myapplacation.utils.Utils;

/**
 * Created by htl on 2018/7/11.
 */

public class MyViewTwo extends View {
	private Paint mLinePaint;
	private float lastX;
	public MyViewTwo(Context context) {
		this(context, null);
	}

	public MyViewTwo(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyViewTwo(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mLinePaint.setStrokeWidth(Utils.dp2px(getContext(), 4));
		mLinePaint.setColor(Color.RED);
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(resolveSize(50, widthMeasureSpec), resolveSize(50, heightMeasureSpec));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.d("htl", "onDraw: " + getWidth() + "---" + getHeight() + "--" + getMeasuredWidth() + "--" + getMeasuredHeight());
		canvas.drawRect(0, 0, getWidth(), getHeight(), mLinePaint);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		float currentX = event.getX();
		switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				lastX = event.getX();
				break;
			case MotionEvent.ACTION_MOVE:
				currentX = event.getX();
				float moveX = lastX - currentX;
				lastX = currentX;
				layout((int) (getLeft()-moveX),getTop(), (int) (getRight()-moveX),getBottom());
				break;
			case MotionEvent.ACTION_UP:
				lastX = 0;
				break;
		}


		return true;
	}
}
