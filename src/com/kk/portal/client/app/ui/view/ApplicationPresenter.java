package com.kk.portal.client.app.ui.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class ApplicationPresenter<T extends ApplicationView & IsWidget, H> {

	@Inject
	protected H service;

	@Inject
	protected T view;

	protected abstract void initEventSubscriptions();

	public void init() {

		initEventSubscriptions();

		view.setPresenter(this);
		view.initLayout();
	}

	public T getView() {
		return view;
	}
}
