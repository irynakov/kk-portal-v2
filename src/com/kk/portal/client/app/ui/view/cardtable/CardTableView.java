package com.kk.portal.client.app.ui.view.cardtable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.view.ApplicationView;

public class CardTableView extends Composite implements ApplicationView<CardTablePresenter> {

	interface CardTableViewUiBinder extends UiBinder<Widget, CardTableView> {}

	private static CardTableViewUiBinder uiBinder = GWT.create(CardTableViewUiBinder.class);

	@UiField
	HTMLPanel container;

	private CardTablePresenter presenter;

	public CardTableView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(CardTablePresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {

	}

	public void clean() {
		container.clear();
	}

	public void deal(String text) {
	}
}
