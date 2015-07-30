package com.kk.portal.client.app.ui.module.test_map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.module.ModuleView;

public class MapTestModuleView extends Composite implements ModuleView<MapTestModulePresenter> {

	private static MapTestModuleViewUiBinder uiBinder = GWT
			.create(MapTestModuleViewUiBinder.class);

	interface MapTestModuleViewUiBinder extends
			UiBinder<Widget, MapTestModuleView> {
	}

	public MapTestModuleView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public MapTestModuleView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public void setPresenter(MapTestModulePresenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getModuleTitle() {
		return MapTestModuleView.class.getSimpleName();
	}

}
