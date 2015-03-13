package com.kk.portal.client.app.ui.module.parkoverview.ui;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;

public class TreeTable extends Composite {

	private Grid grid = new Grid();

	@UiConstructor
	public TreeTable() {
		initWidget(grid);
	}

}
