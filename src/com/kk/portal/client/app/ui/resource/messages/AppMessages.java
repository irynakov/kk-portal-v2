package com.kk.portal.client.app.ui.resource.messages;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {
	
	@Key("AutoLogoutDialogView.header")
	String AutoLogoutDialogView_header();
	
	@Key("AutoLogoutDialogView.login_trminated")
	String AutoLogoutDialogView_login_trminated(int count);
}
