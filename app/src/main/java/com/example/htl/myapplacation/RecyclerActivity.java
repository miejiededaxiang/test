package com.example.htl.myapplacation;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RecyclerActivity extends AppCompatActivity {

	private static final String TAG = "htl";
	private RecyclerView mRecyclerView;
	private List<String> mStrings;
	private MyAdapter mMyAdapter;
	private List<SlideDelete> mSlideDeletes = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler);

		mRecyclerView = findViewById(R.id.recycler_view);

		mStrings = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			mStrings.add(i + "");
		}

		mMyAdapter = new MyAdapter();
		final LinearLayoutManager manager = new LinearLayoutManager(this);
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(manager);
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		mRecyclerView.setAdapter(mMyAdapter);

		mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
			@Override
			public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

				if (e.getAction() == MotionEvent.ACTION_DOWN && mSlideDeletes.size() > 0) {
					Rect rect = new Rect();
					ListIterator<SlideDelete> iterator = mSlideDeletes.listIterator();
					while (iterator.hasNext()) {
						SlideDelete delete = iterator.next();

						int left = delete.getContentWidth() - delete.getDeleteWidth();
						int top = (int) delete.getY();
						int right = delete.getContentWidth();
						int bottom = top + delete.getMeasuredHeight();
						rect.set(left, top, right, bottom);
						if (!rect.contains((int) e.getX(), (int) e.getY())) {
							delete.disDeleteView();
							mSlideDeletes.clear();
							return true;
						}
					}
				}
				return false;
			}

			@Override
			public void onTouchEvent(RecyclerView rv, MotionEvent e) {
			}

			@Override
			public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
			}
		});

	}


	public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

		@Override
		public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item, parent, false);

			return new MyHolder(view);
		}

		@Override
		public void onBindViewHolder(final MyHolder holder, final int position) {

			if(position % 2 == 0){
				holder.mSlideDelete.setSwip(true);
			}else{
				holder.mSlideDelete.setSwip(false);
			}

			holder.text.setText(mStrings.get(position));
			holder.mSlideDelete.setViewListener(new SlideDelete.OnShowDeleteViewListener() {
				@Override
				public void openDeleteView(SlideDelete slideDelete) {
					slideDelete.showDeleteView();
					mSlideDeletes.add(slideDelete);
				}

				@Override
				public void closeDeleteView(SlideDelete slideDelete) {
					slideDelete.disDeleteView();
				}
			});

			holder.text.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(RecyclerActivity.this, "----", Toast.LENGTH_SHORT).show();
				}
			});


			holder.btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
//					Log.d("htlll", "onClick: " + holder.getAdapterPosition() + "--" + position);
					mStrings.remove(holder.getAdapterPosition());
					mMyAdapter.notifyItemRemoved(holder.getAdapterPosition());

					Toast.makeText(RecyclerActivity.this, "2222", Toast.LENGTH_SHORT).show();
				}
			});
		}

		@Override
		public int getItemCount() {
			return mStrings.size();
		}
	}

	public class MyHolder extends RecyclerView.ViewHolder {

		TextView text, btn;
		SlideDelete mSlideDelete;

		public MyHolder(View itemView) {
			super(itemView);

			text = itemView.findViewById(R.id.text);
			btn = itemView.findViewById(R.id.btn);
			mSlideDelete = itemView.findViewById(R.id.delete_view);


		}
	}
}
