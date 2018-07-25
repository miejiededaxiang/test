package com.example.htl.myapplacation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by htl on 2018/5/25.
 */

public class TreeHelper {

	/**
	 * 传入我们的普通bean，转化为我们排序后的Node
	 *
	 * @param datas
	 * @param defaultExpandLevel
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> List<Node> getSortedNodes(List<Node> datas,
												int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException

	{
		List<Node> result = new ArrayList<Node>();
		//将用户数据转化为List<Node>以及设置Node间关系
//		List<Node> nodes = convetData2Node(datas);
		//拿到根节点
		List<Node> rootNodes = getRootNodes(datas);
		//排序
		for (Node node : rootNodes) {
			addNode(result, node, defaultExpandLevel, 1);
		}
		return result;
	}

	private static List<Node> getRootNodes(List<Node> datas) {
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).isRoot()) {
				list.add(datas.get(i));
			}
		}

		return list;
	}

	private static void addNode(List<Node> result, Node node, int defaultExpandLevel, int i) {
		result.add(node);
		if (defaultExpandLevel >= i) {
			node.setExpand(true);
		}

		for (int j = 0; j < node.getChildren().size(); j++) {
			Node childNode = node.getChildren().get(j);
			addNode(result, childNode, defaultExpandLevel, childNode.getLevel());
		}
	}

	private static <T> List<Node> convetData2Node(List<T> datas) {


		return null;
	}
}
