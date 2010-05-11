package org.iskconsv.client.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class SubscribePopup extends PopupPanel implements ClickHandler
{
	public static final SubscribePopup instance = new SubscribePopup();
	
	private TextBox emailTextBox;
	
	public SubscribePopup()
	{
		FlowPanel container = new FlowPanel();
		FlowPanel buttonBar = new FlowPanel();
		
		Button cancelButton = new Button("Cancel", this);
		Button continueButton = new Button("Subscribe...", this);
		emailTextBox = new TextBox();
		
		container.add(new HTML("Email address:"));
		container.add(emailTextBox);
		buttonBar.add(cancelButton);
		buttonBar.add(continueButton);
		container.add(buttonBar);
		
		buttonBar.addStyleName("buttonBar");
		container.getElement().getStyle().setProperty("textAlign", "center");
		
		this.add(container);
		this.setAnimationEnabled(true);
		this.setGlassEnabled(true);
		this.setAutoHideEnabled(false);
	}
	
	@Override
	public void onClick(ClickEvent event)
	{
		Button button = (Button) event.getSource();
		if(button.getText().equals("Cancel"))
			this.hide();
		else
		{
			Window.open("http://groups.google.com/group/iskconsv-announcements/boxsubscribe?email=" + URL.encodeComponent(emailTextBox.getText()), "_blank", null);
		}
	}
}