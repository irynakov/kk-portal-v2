package com.kk.portal.client.app.ui.module.parkoverview.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TreeTableNode<T> {

	private final T data;

	private TreeTableNode<T> parent = null;
	private List<TreeTableNode<T>> childrens = null;

	public TreeTableNode(final T data) {
		this.data = data;
		this.childrens = new ArrayList<TreeTableNode<T>>();
	}

	public T getData() {
		return data;
	}

	public TreeTableNode<T> getParent() {
		return parent;
	}

	public void setParent(final TreeTableNode<T> parent) {
		this.parent = parent;
	}

	public boolean hasChildrens() {
		return !childrens.isEmpty();
	}

	public void resetChicldrens(final Collection<TreeTableNode<T>> childrens) {
		this.childrens.clear();
		addChildrens(childrens);
	}

	public void addChildrens(final Collection<TreeTableNode<T>> childrens) {
		for (final TreeTableNode<T> child : childrens) {
			addChildren(child);
		}
	}

	public void addChildren(final TreeTableNode<T> child) {
		if (child != null) {
			child.setParent(this);
			childrens.add(child);
		}
	}

	@Override
	public String toString() {
		return "TreeTableNode [data=" + data + ", parent=" + parent + ", childrens=" + childrens + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		@SuppressWarnings("unchecked")
		TreeTableNode<T> other = (TreeTableNode<T>) obj;

		if (parent == null && other.parent != null)
			return false;
		else if (!parent.equals(other.parent))
			return false;

		if (data == null && other.data != null)
			return false;
		else if (!data.equals(other.data))
			return false;

		return true;
	}

}
