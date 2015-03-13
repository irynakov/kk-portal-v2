package com.kk.portal.client.app.ui;

import java.util.logging.Logger;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.inject.Inject;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent;
import com.kk.portal.client.app.ui.event.LoginSuccessEvent.LoginSuccessEventHandler;
import com.kk.portal.client.app.ui.event.LogoutEvent.LogoutEventHandler;
import com.kk.portal.client.app.ui.support.AutoLogoutScheduler;
import com.kk.portal.client.app.ui.view.login.LoginPresenter;
import com.kk.portal.client.app.ui.view.stage.StagePresenter;

public class ApplicationController implements LoginSuccessEventHandler, LogoutEventHandler {

	private static final Logger LOG = Logger.getLogger(ApplicationController.class.getName());

	@Inject
	ApplicationEventBus appBus;
	
	@Inject
	AutoLogoutScheduler autoLogout;

	@Inject
	LoginPresenter login;

	@Inject
	StagePresenter stage;

	private LayoutPanel root;

	public void initApplication(final RootLayoutPanel root) {
		LOG.info("Application initialization.");

		this.root = root;

		appBus.addLoginSuccessHandler(this);
		appBus.addLogoutHandler(this);
	}

	public void startApplication() {
		LOG.info("Application start.");

		if (Cookies.getCookie("active_user") != null) {
			this.root.add(stage.getView());
		} else {
			this.root.add(login.getView());
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
		this.root.add(stage.getView());
	}

	@Override
	public void onLogout() {
		LOG.info("User signed out.");

		Cookies.removeCookie("active_user");

		this.root.clear();
		this.root.add(login.getView());
	}
}
