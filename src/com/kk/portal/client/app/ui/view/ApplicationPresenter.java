package com.kk.portal.client.app.ui.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
public abstract class ApplicationPresenter<T extends ApplicationView & IsWidget, H> {

	@Inject
	private H service;

	protected T view;

	public ApplicationPresenter(T view) {
		this.view = view;

		this.view.setPresenter(this);
	}

	public T getView() {
		return view;
	}
}
