package com.kk.portal.client.app.ui.module;


@SuppressWarnings("rawtypes")
public interface ModuleView<T extends ModulePresenter> {

	void setPresenter(T presenter);
}
