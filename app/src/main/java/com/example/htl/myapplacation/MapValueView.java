package com.example.htl.myapplacation;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.htl.myapplacation.utils.Utils;


/**
 * Created by htl on 2018/5/9.
 */

public class MapValueView extends LinearLayout {

	private Context mContext;
	private int top;
	private MyClickListener mListener;

	public void setListener(MyClickListener listener) {
		mListener = listener;
	}

	public MapValueView(Context context) {
		this(context, null);
	}

	public MapValueView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MapValueView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		mContext = context;
		setOrientation(VERTICAL);

		top = Utils.dp2px(context, 10);
		setStringListData();
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}


	public void setStringListData() {


		RelativeLayout linearLayout = new RelativeLayout(mContext);

		TextView leftTv = new TextView(mContext);
		leftTv.setTextSize(12);
		leftTv.setTextColor(Color.parseColor("#827E7C"));
		leftTv.setText("left");
		leftTv.setId(1);
		RelativeLayout.LayoutParams leftParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		leftTv.setLayoutParams(leftParams);
		linearLayout.addView(leftTv);


		View cliclTv = LayoutInflater.from(getContext()).inflate(R.layout.text,null);
		cliclTv.setId(2);
		RelativeLayout.LayoutParams rightParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		rightParams1.rightMargin = Utils.dp2px(getContext(), 33);
		cliclTv.setLayoutParams(rightParams1);
		linearLayout.addView(cliclTv);


		TextView rightTv = new TextView(mContext);
		rightTv.setTextSize(12);
		rightTv.setTextColor(Color.parseColor("#373737"));
		rightTv.setText("right");
		RelativeLayout.LayoutParams rightParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.LEFT_OF, cliclTv.getId());

		rightParams.rightMargin = Utils.dp2px(getContext(), 33);
		rightTv.setLayoutParams(rightParams);
		linearLayout.addView(rightTv);


		LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		params.bottomMargin = Utils.dp2px(getContext(), 15);
		params.topMargin = Utils.dp2px(getContext(), 15);
		linearLayout.setLayoutParams(params);
		addView(linearLayout);

		linearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mListener != null){
					mListener.OnClickListener();
				}
			}
		});

	}


	interface MyClickListener{
		void OnClickListener();
	}

}
