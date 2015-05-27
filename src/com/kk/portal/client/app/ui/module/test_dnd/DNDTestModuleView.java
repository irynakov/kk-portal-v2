package com.kk.portal.client.app.ui.module.test_dnd;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class DNDTestModuleView extends Composite implements ModuleView<DNDTestModulePresenter> {

	private static DNDTestModuleViewUiBinder uiBinder = GWT.create(DNDTestModuleViewUiBinder.class);

	interface DNDTestModuleViewUiBinder extends UiBinder<Widget, DNDTestModuleView> {}

	public DNDTestModuleView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(DNDTestModulePresenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		
	}

}
