package com.example.htl.myapplacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class JsonActivity extends AppCompatActivity {

	private static final String TAG = "JsonActivity";
	private RecyclerView mRecyclerView;
	private MyAdapter1 adapter1;
	private LinearLayoutManager manager;
	private boolean isAll;
	private List<JsonBean> mList;
	private EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);

		mRecyclerView = findViewById(R.id.recycler_view);
		mEditText = findViewById(R.id.et);
		mEditText.addTextChangedListener(new MyWatcher());
		mList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			mList.add(new JsonBean(i + "", false));
		}

		adapter1 = new MyAdapter1(mList);
		manager = new LinearLayoutManager(this);
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(manager);
		mRecyclerView.setAdapter(adapter1);

	}

	public void onClick(View view) {
	}


	class MyWatcher implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {

		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			adapter1.getFilter().filter(s.toString().trim());
		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	}


	public void click(View view) {

		isAll = !isAll;

		for (int i = 0; i < adapter1.getItemCount(); i++) {
			mList.get(i).isSelect = isAll;
		}

		adapter1.notifyDataSetChanged();
	}

	public void click1(View view) {
		for (int i = 0; i < mList.size(); i++) {
			if (mList.get(i).isSelect) {
				Log.d(TAG, "click1: " + mList.get(i).mString);
			}
		}
	}
}
