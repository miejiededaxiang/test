package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.htl.myapplacation.utils.Utils;

/**
 * Created by htl on 2018/4/18.
 */

public class CaseQueryStatusView extends View {

	private Paint mLinePaint, mPaint;
	private int radio;
	private Bitmap mBitmap;

	public CaseQueryStatusView(Context context) {
		this(context, null);
	}

	public CaseQueryStatusView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CaseQueryStatusView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initPaint();
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_case_status_no);
		resetwhBitmap();
	}

	private void initPaint() {
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setStyle(Paint.Style.FILL);

		mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mLinePaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mLinePaint.setStrokeWidth(5);
		mLinePaint.setColor(Color.parseColor("#ECECEC"));
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int widthSize = resolveSize(radio * 2, widthMeasureSpec);
		int heightSize = resolveSize(Utils.dp2px(getContext(),58), heightMeasureSpec);
		setMeasuredDimension(widthSize, heightSize);
	}

	public void setCurrentStatus() {
		mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.icon_case_status_no);
		resetwhBitmap();
		invalidate();
	}

	private void resetwhBitmap() {
		int bitWidth = mBitmap.getWidth();
		int bitHeight = mBitmap.getHeight();
		int newWidth = Utils.dp2px(getContext(),24);
		int newHeight = Utils.dp2px(getContext(),24);
		radio = newWidth / 2;
		// 计算缩放比例
		float scaleWidth = ((float) newWidth) / bitWidth;
		float scaleHeight = ((float) newHeight) / bitHeight;
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		/**缩放图片*/
		mBitmap = Bitmap.createBitmap(mBitmap, 0, 0, bitWidth, bitHeight, matrix, true);
	}


	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawLine(radio, 0, radio, getHeight() / 2 - radio, mLinePaint);
		canvas.drawLine(radio, getHeight() / 2 + radio, radio, getHeight(), mLinePaint);
		canvas.drawBitmap(mBitmap, 0f, (float) (getHeight() / 2 - radio), mPaint);
	}
}
