package com.kk.portal.client.app.ui;

import com.google.gwt.user.client.ui.IsWidget;
import com.kk.portal.client.app.ui.view.ApplicationPresenter;
import com.kk.portal.client.app.ui.view.ApplicationView;

public abstract class ViewFactory {

	public abstract <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType);

	protected ApplicationPresenter<?, ?> build(ApplicationPresenter<?, ?> presenter) {
		if (!presenter.isInitialized()) {
			presenter.init();
		}
		return presenter;
	}
	
}
