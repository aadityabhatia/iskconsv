package org.iskconsv.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class InfoPopup extends PopupPanel implements ClickHandler
{
	private final static String DEFAULT_BUTTON_TEXT = "OK";
	
	private final FlexTable container = new FlexTable();
	private final HTML message = new HTML();
	private final Button okButton = new Button(DEFAULT_BUTTON_TEXT);

	public InfoPopup()
	{
		container.setWidget(0, 0, message);
		container.setWidget(1, 0, okButton);
		container.getFlexCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_CENTER);
		container.setCellPadding(10);
		okButton.addClickHandler(this);
		this.add(container);
		this.setAnimationEnabled(true);
		this.setGlassEnabled(true);
		this.setAutoHideEnabled(true);
	}
	
	public InfoPopup(Widget widget)
	{
		this();
		container.setWidget(0, 0, widget);
	}
	
	public static void center(String messageHTML)
	{
		InfoPopup instance = new InfoPopup();
		instance.message.setHTML(messageHTML);
		instance.setButtonText(DEFAULT_BUTTON_TEXT);
		instance.container.setWidget(0, 0, instance.message);
		instance.center();
	}
	
	public static void center(Widget widget)
	{
		InfoPopup instance = new InfoPopup();
		instance.container.setWidget(0, 0, widget);
		instance.center();
	}
	
	public void setButtonText(String text)
	{
		okButton.setText(text);
	}
	
	@Override
	public void onClick(ClickEvent event)
	{
		this.hide();
	}
}