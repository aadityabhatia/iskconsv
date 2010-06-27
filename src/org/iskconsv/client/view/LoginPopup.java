package org.iskconsv.client.view;

import org.iskconsv.client.resources.Resources;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class LoginPopup extends PopupPanel implements ClickHandler
{
	public LoginPopup()
	{
		FlowPanel container = new FlowPanel();
		FlowPanel buttonBar = new FlowPanel();
		
		Button cancelButton = new Button("Cancel");
		Button continueButton = new Button("Continue...");
		container.add(getContentHTML());
		buttonBar.add(cancelButton);
		buttonBar.add(continueButton);
		container.add(buttonBar);
		
		buttonBar.addStyleName(Resources.INSTANCE.style().buttonBar());
		container.getElement().getStyle().setProperty("textAlign", "center");
		
		cancelButton.addClickHandler(this);
		continueButton.addClickHandler(this);
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
			Window.open("/auth/login/", "_self", null);
	}
	
	public Widget getContentHTML()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("<h1>Welcome to ISKCON of Silicon Valley</h1>");
		buffer.append("<h3>Signing in with your Google Account will enhance your experience at this site.</h3>");
		buffer.append("<h3>Please *hit* continue to be redirected to a google.com login page.</h3>");
		return new HTML(buffer.toString());
	}
}