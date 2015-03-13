package com.kk.portal.client.app.ui.support;

import com.google.gwt.core.client.Scheduler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.dialog.autologout.AutoLogoutPresenter;

@Singleton
public class AutoLogoutScheduler {

	@Inject
	ApplicationEventBus appBus;

	@Inject
	AutoLogoutPresenter autoLogout;

	public void start() {
		Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {

			@Override
			public boolean execute() {
				autoLogout.getDialog().center();
				return false;
			}
		}, 2000);
	}

}
