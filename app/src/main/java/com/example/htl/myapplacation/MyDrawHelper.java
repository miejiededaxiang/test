package com.example.htl.myapplacation;

import android.support.v4.widget.ViewDragHelper;
import android.view.View;

/**
 * Created by htl on 2018/5/8.
 */

public class MyDrawHelper extends ViewDragHelper.Callback{
	@Override
	public boolean tryCaptureView(View child, int pointerId) {
		return false;
	}

	@Override
	public int clampViewPositionHorizontal(View child, int left, int dx) {
		return super.clampViewPositionHorizontal(child, left, dx);
	}

	@Override
	public int clampViewPositionVertical(View child, int top, int dy) {
		return super.clampViewPositionVertical(child, top, dy);
	}

	@Override
	public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
		super.onViewPositionChanged(changedView, left, top, dx, dy);
	}

	@Override
	public void onViewReleased(View releasedChild, float xvel, float yvel) {
		super.onViewReleased(releasedChild, xvel, yvel);
	}
}
