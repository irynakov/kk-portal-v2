package com.kk.portal.client.app.ui.frame.playroom;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.kk.portal.client.app.ui.frame.FrameView;
import com.kk.portal.client.app.ui.frame.cardtable.CardTableView;
import com.kk.portal.client.app.ui.frame.decksholder.DecksHolderView;

public class PlayRoomView extends Composite implements FrameView<PlayRoomPresenter> {

	interface WorkspaceViewUiBinder extends UiBinder<Widget, PlayRoomView> {}

	private static final WorkspaceViewUiBinder uiBinder = GWT.create(WorkspaceViewUiBinder.class);

	@UiField(provided = true)
	DecksHolderView deckManager;

	@UiField(provided = true)
	CardTableView cardTable;

	private PlayRoomPresenter presenter;

	@Override
	public void setPresenter(PlayRoomPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void initLayout() {

		deckManager = presenter.getDeckManager();
		cardTable = presenter.getCardTable();

		initWidget(uiBinder.createAndBindUi(this));
		
		presenter.requestDeckManagerState();
	}
}
