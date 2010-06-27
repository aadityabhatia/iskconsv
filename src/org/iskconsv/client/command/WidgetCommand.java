package org.iskconsv.client.command;

import org.iskconsv.client.Controller;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;

public class WidgetCommand implements Command
{
	private Widget widget;
	private String historyToken;
	
	
	public WidgetCommand(Widget widget, String historyToken)
	{
		this.widget = widget;
		this.historyToken = historyToken;
	}
	
	@Override
	public void execute()
	{
		Controller.INSTANCE.updateContent(widget, historyToken);
	}
}