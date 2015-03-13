package com.kk.portal.client.app.ui.module;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public abstract class ModulePresenter<T extends ModuleView & IsWidget, H> {

	@Inject
	private H service;

	protected T view;

	public ModulePresenter(T view) {
		this.view = view;

		this.view.setPresenter(this);
	}

	public T getView() {
		return view;
	}
}
