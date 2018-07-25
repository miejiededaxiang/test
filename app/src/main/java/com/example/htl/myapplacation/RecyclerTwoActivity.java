package com.example.htl.myapplacation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.htl.myapplacation.utils.TestBean;
import com.google.gson.internal.LinkedHashTreeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerTwoActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private MyAdapter mMyAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycler_two);

		mRecyclerView = findViewById(R.id.recycler_view);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mRecyclerView.setLayoutManager(linearLayoutManager);

		TestBean bean = new TestBean();

		TestBean.OneBean oneBean = bean.new OneBean();
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> map = new LinkedHashTreeMap<>();
			map.put("进件信息", i + "0000");
			list.add(map);
		}
		oneBean.setOntStr("进件信息");
		oneBean.setOneList(list);
		bean.setOneBean(oneBean);

		TestBean.OneBean1 oneBean1 = bean.new OneBean1();
		List<Map<String, Object>> list1 = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> map = new LinkedHashTreeMap<>();
			map.put("个人信息", i + "0000");
			list1.add(map);
		}
		oneBean1.setOntStr("个人信息");
		oneBean1.setOneList(list1);
		bean.setOneBean1(oneBean1);

		TestBean.OneBean2 oneBean2 = bean.new OneBean2();
		List<Map<String, Object>> list2 = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Map<String, Object> map = new LinkedHashTreeMap<>();
			map.put("家庭信息", i + "0000");
			list2.add(map);
		}
		oneBean2.setOntStr("家庭信息");
		oneBean2.setOneList(list2);
		bean.setOneBean2(oneBean2);

		mMyAdapter = new MyAdapter();
		mRecyclerView.setAdapter(mMyAdapter);

		List<Node> lists = new ArrayList<>();
		Node node = new Node(0, 0, "家庭信息");
		Node node1 = new Node(0, 1, "家庭信息");
		Node node2 = new Node(0, 2, "家庭信息");
		Node node3 = new Node(0, 3, "家庭信息");

		List<Node> childNodes = new ArrayList<>();
		childNodes.add(node1);
		childNodes.add(node2);
		childNodes.add(node3);
		node.setExpand(false);
		node.setChildren(childNodes);
		node.setLevel(1);

		node1.setParent(node);
		node2.setParent(node);
		node3.setParent(node);

		Node node4 = new Node(0, 1, "家庭信息0");
		Node node5 = new Node(1, 1, "家庭信息1");
		Node node6 = new Node(2, 1, "家庭信息2");

		node4.setParent(node1);
		node5.setParent(node1);
		node6.setParent(node1);
		List<Node> lll = new ArrayList<>();
		lll.add(node4);
		lll.add(node5);
		lll.add(node6);
		node1.setChildren(lll);

		lists.add(node);
		lists.add(node1);
		lists.add(node2);
		lists.add(node3);
		lists.add(node4);
		lists.add(node5);
		lists.add(node6);


		mMyAdapter.setData(lists);

	}


	public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

		private List<Node> mNodes;
		private List<Node> mAllNodes;

		public MyAdapter() {

		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			if (viewType == ItemStatus.VIEW_TYPE_GROUPITEM) {
				View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_two_item2, parent, false);
				return new MyHeadHolder(view1);
			} else if (viewType == ItemStatus.VIEW_TYPE_SUBITEM) {
				View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_two_item, parent, false);
				return new MyHolder(view);
			}

			return null;
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

			Node node = mNodes.get(position);

			if (holder instanceof MyHolder) {
				((MyHolder) holder).mTvText.setText(node.getName());

			}

			if (holder instanceof MyHeadHolder) {
				((MyHeadHolder) holder).mTvText.setText(node.getName());
			}

		}

		@Override
		public int getItemViewType(int position) {


			return getItemStatus(position).getViewType();
		}

		@Override
		public int getItemCount() {
			return mNodes.size();
		}


		public ItemStatus getItemStatus(int pos) {

			ItemStatus statu = new ItemStatus();

			Node node = mNodes.get(pos);
			if (node.getParent() == null) {
				statu.setViewType(ItemStatus.VIEW_TYPE_GROUPITEM);
			} else {
				statu.setViewType(ItemStatus.VIEW_TYPE_SUBITEM);
			}
			return statu;
		}

		public void setData(List<Node> data) {
			try {
				mAllNodes = TreeHelper.getSortedNodes(data, 0);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			addNode(data);
		}

		private void addNode(List<Node> data) {
			mNodes = new ArrayList<>();
			for (int i = 0; i < data.size(); i++) {
				Node node = data.get(i);
				if (node.isRoot() || node.isParentExpand()) {
					mNodes.add(node);
				}
			}
		}

		class MyHolder extends RecyclerView.ViewHolder {

			TextView mTvText;

			public MyHolder(View itemView) {
				super(itemView);

				mTvText = itemView.findViewById(R.id.text);
				mTvText.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						int pos = getAdapterPosition();
						Node node = mNodes.get(pos);
						node.setExpand(!node.isExpand());
						addNode(mAllNodes);
						notifyDataSetChanged();
					}
				});
			}

		}

		class MyHeadHolder extends RecyclerView.ViewHolder {

			TextView mTvText;

			public MyHeadHolder(View itemView) {
				super(itemView);

				mTvText = itemView.findViewById(R.id.text);
				mTvText.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						int pos = getAdapterPosition();
						Node node = mNodes.get(pos);
						node.setExpand(!node.isExpand());
						addNode(mAllNodes);
						notifyDataSetChanged();
					}
				});
			}

		}


	}
}
