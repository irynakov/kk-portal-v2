package com.kk.portal.client.app.ui.view;

@SuppressWarnings("rawtypes")
public interface ApplicationView<T extends ApplicationPresenter> {

	void setPresenter(T presenter);
}
