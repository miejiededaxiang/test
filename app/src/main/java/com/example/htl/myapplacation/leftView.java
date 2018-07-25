package com.example.htl.myapplacation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by htl on 2018/4/18.
 */

public class leftView extends View {
	private int width;
	private Paint mPaint;

	public leftView(Context context) {
		this(context, null);
	}

	public leftView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public leftView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.leftView);
		width = typedArray.getDimensionPixelOffset(R.styleable.leftView_width, 0);
		typedArray.recycle();


		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.RED);
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		if (width != 0) {
			widthSize = resolveSize(widthSize,widthMeasureSpec);
		}

		setMeasuredDimension(widthSize, heightMeasureSpec);
	}


	@Override
	protected void onDraw(Canvas canvas) {

		canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mPaint);
	}
}
