package com.example.htl.myapplacation;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htl on 2018/5/15.
 */

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyHolder> implements Filterable {

	private List<JsonBean> mStrings;
	private MyFilter mMyFilter;
	private List<JsonBean> mOriginList;
	private CharSequence mConstraint;

	public MyAdapter1(List<JsonBean> strings) {
		mStrings = new ArrayList<>();
		mStrings.addAll(strings);
	}

	@Override
	public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item1, parent, false);
		return new MyHolder(view);
	}

	@Override
	public void onBindViewHolder(MyHolder holder, int position) {

		JsonBean bean = mStrings.get(position);
		holder.mTextView.setText(bean.mString);
		holder.mImageView.setSelected(bean.isSelect);

		if (mConstraint != null && mConstraint.length() > 0) {

			SpannableString spannableString = new SpannableString(bean.mString);
			spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, mConstraint.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
			holder.mTextView.setText(spannableString);
		}

	}

	@Override
	public int getItemCount() {
		return mStrings.size();
	}

	@Override
	public Filter getFilter() {

		if (mMyFilter == null) {
			mMyFilter = new MyFilter();
		}
		return mMyFilter;
	}

	public class MyHolder extends RecyclerView.ViewHolder {

		ImageView mImageView;
		TextView mTextView;

		public MyHolder(View itemView) {
			super(itemView);

			mImageView = itemView.findViewById(R.id.img);
			mTextView = itemView.findViewById(R.id.text);
			mImageView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					JsonBean bean = mStrings.get(getAdapterPosition());
					boolean isSelect = !bean.isSelect;
					bean.isSelect = isSelect;

					mImageView.setSelected(isSelect);
				}
			});
		}
	}

	class MyFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {


			FilterResults results = new FilterResults();
			if (mOriginList == null) {
				mOriginList = new ArrayList<>(mStrings);
			}

			if (constraint == null || constraint.length() == 0) {
				results.count = mOriginList.size();
				results.values = mOriginList;
			} else {

				List<JsonBean> jsonBeans = new ArrayList<>();

				for (int i = 0; i < mOriginList.size(); i++) {

					JsonBean bean = mOriginList.get(i);
					if (bean.mString.startsWith(constraint.toString())) {
						jsonBeans.add(bean);
					}
				}

				results.count = jsonBeans.size();
				results.values = jsonBeans;

			}

			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {

			mStrings = (List<JsonBean>) results.values;
			mConstraint = constraint;
			notifyDataSetChanged();


		}
	}
}
