package com.kk.portal.client.app.ui.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Widget;

public class DeckBox extends Composite implements HasName {

	interface DeckBoxUiBinder extends UiBinder<Widget, DeckBox> {}

	private static DeckBoxUiBinder uiBinder = GWT.create(DeckBoxUiBinder.class);

	@UiField
	InlineLabel name;

	public DeckBox(String name) {
		super.initWidget(uiBinder.createAndBindUi(this));
		this.name.setText(name);
	}

	@Override
	public void setName(String name) {
		this.name.setText(name);
	}

	@Override
	public String getName() {
		return name.getText();
	}

	public Widget getDragHandle() {
		return name;
	}

}
