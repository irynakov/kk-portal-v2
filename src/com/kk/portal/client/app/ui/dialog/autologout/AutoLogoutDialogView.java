package com.kk.portal.client.app.ui.dialog.autologout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.kk.portal.client.app.ui.dialog.DialogView;
import com.kk.portal.client.app.ui.resource.messages.AppMessages;

public class AutoLogoutDialogView extends DialogBox implements DialogView<AutoLogoutPresenter> {

	private static AppMessages msgs = GWT.create(AppMessages.class);

	private static AutoLogoutDialogViewUiBinder uiBinder = GWT.create(AutoLogoutDialogViewUiBinder.class);

	interface AutoLogoutDialogViewUiBinder extends UiBinder<HTMLPanel, AutoLogoutDialogView> {
	}

	@UiField
	InlineLabel counter;

	@UiField
	Button stay;

	private AutoLogoutPresenter presenter;

	public AutoLogoutDialogView() {

		getCaption().setText(msgs.AutoLogoutDialogView_header());
		setModal(true);
		setGlassEnabled(true);

		setWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("stay")
	void onClick(final ClickEvent e) {
		presenter.stay();
	}

	@Override
	public void setPresenter(final AutoLogoutPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public PopupPanel getDialog() {
		return this;
	}

	public void setCounter(final int count) {
		counter.setText(msgs.AutoLogoutDialogView_login_trminated(count));
	}
}