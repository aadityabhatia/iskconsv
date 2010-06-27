package org.iskconsv.client.command;

import org.iskconsv.client.Controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;

public class WidgetCommand implements Command
{
	private Widget widget;
	private String historyToken;
	
	private Class<Widget> className;

	@SuppressWarnings("unchecked")
	public WidgetCommand(Class<?> className, String historyToken)
	{
		this.className = (Class<Widget>) className;
	}
	
	public WidgetCommand(Widget widget, String historyToken)
	{
		this.widget = widget;
		this.historyToken = historyToken;
	}
	
	@Override
	public void execute()
	{
		if (widget == null)
			widget = GWT.create(className);
		Controller.INSTANCE.updateContent(widget, historyToken);
	}
}