package com.kk.portal.client.app.ui.view.tabbar;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.view.ApplicationView;

public class TabBarView extends Composite implements ApplicationView<TabBarPresenter> {

	interface TabBarViewUiBinder extends UiBinder<Widget, TabBarView> {}

	private static final TabBarViewUiBinder uiBinder = GWT.create(TabBarViewUiBinder.class);

	@UiField
	TabBar tabBar;

	private TabBarPresenter presenter;

	public TabBarView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("tabBar")
	public void onSelection(SelectionEvent<Integer> event) {
		presenter.handleTabSelection(event.getSelectedItem());
	}

	@Override
	public void setPresenter(TabBarPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {
	}

	public void addTabs(List<String> tabs) {
		for (String tab : tabs) {
			tabBar.addTab(tab);
		}
	}

	public void selectTab(int selectedIndex) {
		tabBar.selectTab(selectedIndex);
	}
}
