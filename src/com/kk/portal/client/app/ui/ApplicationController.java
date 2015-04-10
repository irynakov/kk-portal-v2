package com.kk.portal.client.app.ui;

import java.util.logging.Logger;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent.LoginSuccessEventHandler;
import com.kk.portal.client.app.ui.event.LogoutEvent.LogoutEventHandler;
import com.kk.portal.client.app.ui.event.LogoutResetEvent.LogoutResetEventHandler;
import com.kk.portal.client.app.ui.support.AutoLogoutScheduler;
import com.kk.portal.client.app.ui.view.ViewProvider;
import com.kk.portal.client.app.ui.view.login.LoginView;
import com.kk.portal.client.app.ui.view.stage.StageView;

@Singleton
public class ApplicationController implements LoginSuccessEventHandler, LogoutEventHandler, LogoutResetEventHandler {

	private static final Logger LOG = Logger.getLogger(ApplicationController.class.getName());

	@Inject
	ApplicationEventBus appBus;

	@Inject
	AutoLogoutScheduler autoLogout;

	@Inject
	ViewProvider views;

	private LayoutPanel root;

	public void initApplication(final RootLayoutPanel root) {
		LOG.info("Application initialization.");

		this.root = root;

		views.build();

		appBus.addLoginSuccessHandler(this);
		appBus.addLogoutHandler(this);
		appBus.addResetLogoutHandler(this);
	}

	public void startApplication() {
		LOG.info("Application start.");

		if (Cookies.getCookie("active_user") != null) {
			buildStage();
		} else {
			this.root.add(views.view(LoginView.class));
		}
	}

	@Override
	public void onLoginSuccess(final LoginSuccessEvent event) {
		LOG.info("User successfuly signed in.");

		if (event.isStay()) {
			Cookies.setCookie("active_user", "user");
		} else {
			autoLogout.start();
		}

		this.root.clear();
		buildStage();
	}

	@Override
	public void onLogout() {
		LOG.info("User signed out.");

		Cookies.removeCookie("active_user");
		autoLogout.stop();

		this.root.clear();
		this.root.add(views.view(LoginView.class));
	}

	@Override
	public void onResetLogout() {
		LOG.info("User reset auto logout scheduler.");

		autoLogout.start();
	}

	private void buildStage() {
		this.root.add(views.view(StageView.class));
	}
}
