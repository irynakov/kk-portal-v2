package com.kk.portal.client.app.ui.view;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.view.header.HeaderPresenter;
import com.kk.portal.client.app.ui.view.header.HeaderView;
import com.kk.portal.client.app.ui.view.login.LoginPresenter;
import com.kk.portal.client.app.ui.view.login.LoginView;
import com.kk.portal.client.app.ui.view.stage.StagePresenter;
import com.kk.portal.client.app.ui.view.stage.StageView;

@Singleton
public class ViewProvider {

	@Inject
	LoginPresenter loginPresenter;

	@Inject
	StagePresenter stagePresenter;

	@Inject
	HeaderPresenter headerPresenter;

	private boolean builded = false;

	@SuppressWarnings("unchecked")
	public <T extends ApplicationView<?> & IsWidget> T view(Class<T> viewType) {

		if (StageView.class.equals(viewType)) {
			return (T) stagePresenter.view;
		} else if (LoginView.class.equals(viewType)) {
			return (T) loginPresenter.view;
		} else if (HeaderView.class.equals(viewType)) {
			return (T) headerPresenter.view;
		}

		throw new IllegalArgumentException();
	};

	public void build() {
		if (!builded) {
			build(loginPresenter);
			build(stagePresenter);
			build(headerPresenter);
		}
	}

	private void build(ApplicationPresenter<?, ?> presenter) {
		presenter.init();
	}
}
