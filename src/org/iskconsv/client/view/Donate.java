package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Donate extends Composite
{

	private static DonateUiBinder uiBinder = GWT.create(DonateUiBinder.class);

	interface DonateUiBinder extends UiBinder<HTMLPanel, Donate>
	{
	}

	@UiField
	Button newTempleButton, operationsButton, sankirtanButton;

	public Donate()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("newTempleButton")
	void onNewTempleClick(ClickEvent e)
	{
		Window.alert("Hello 1");
	}

	@UiHandler("operationsButton")
	void onOperationsButtonClick(ClickEvent e)
	{
		Window.alert("Hello 2");
	}

	@UiHandler("sankirtanButton")
	void onSankirtanButtonClick(ClickEvent e)
	{
		Window.alert("Hello 3");
	}
}
