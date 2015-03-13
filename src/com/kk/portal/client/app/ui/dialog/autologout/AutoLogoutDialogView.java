package com.kk.portal.client.app.ui.dialog.autologout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.kk.portal.client.app.ui.dialog.DialogView;

public class AutoLogoutDialogView implements DialogView<AutoLogoutPresenter> {

	private static AutoLogoutDialogViewUiBinder uiBinder = GWT.create(AutoLogoutDialogViewUiBinder.class);

	interface AutoLogoutDialogViewUiBinder extends UiBinder<DialogBox, AutoLogoutDialogView> {
	}

	@UiField
	DialogBox dialog;

	@UiField
	Button button;

	private AutoLogoutPresenter presenter;

	public AutoLogoutDialogView() {
		uiBinder.createAndBindUi(this);
	}

	@UiHandler("button")
	void onClick(final ClickEvent e) {
		dialog.hide();
	}

	@Override
	public void setPresenter(final AutoLogoutPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public PopupPanel getDialog() {
		return dialog;
	}
}
//ds-dniepr@i.ua
