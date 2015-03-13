package com.kk.portal.client.app.ui.module.parkoverview.ui;

import java.util.ArrayList;
import java.util.List;

public class TreeTableData<T> {

	private final List<TreeTableNode<T>> rootNodes = new ArrayList<TreeTableNode<T>>();

	public void addRootNode(TreeTableNode<T> node) {
		rootNodes.add(node);
	}

	public void removeRootNode(int index) {
		rootNodes.remove(index);
	}

	public void clearRootNodes() {
		rootNodes.clear();
	}

	public TreeTableNode<T> getRootNode(int index) {
		return rootNodes.get(index);
	}

	public List<TreeTableNode<T>> getRootNodes() {
		return rootNodes;
	}

}
