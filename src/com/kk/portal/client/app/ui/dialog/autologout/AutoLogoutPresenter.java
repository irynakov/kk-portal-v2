package com.kk.portal.client.app.ui.dialog.autologout;

import com.google.inject.Inject;
import com.kk.portal.client.app.ui.ApplicationEventBus;
import com.kk.portal.client.app.ui.dialog.DialogPresenter;

public class AutoLogoutPresenter extends DialogPresenter<AutoLogoutDialogView> {

	private final ApplicationEventBus appBus;

	@Inject
	public AutoLogoutPresenter(final AutoLogoutDialogView view, final ApplicationEventBus appBus) {
		super(view);
		this.appBus = appBus;
	}

}
