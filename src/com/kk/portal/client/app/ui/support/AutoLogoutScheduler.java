package com.kk.portal.client.app.ui.support;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.dialog.autologout.AutoLogoutPresenter;
import com.kk.portal.client.app.ui.resource.constants.AppSettings;

@Singleton
public class AutoLogoutScheduler {

	private static AppSettings cnst = GWT.create(AppSettings.class);

	@Inject
	ApplicationEventBus appBus;

	@Inject
	AutoLogoutPresenter autoLogout;

	private Timer scheduler = new Timer() {

		@Override
		public void run() {
			autoLogout.startCountDown();
		}
	};;

	public void start() {
		scheduler.schedule(cnst.AutoLogout_delay() * 60000);
	}

	public void stop() {
		scheduler.cancel();
	}

}
