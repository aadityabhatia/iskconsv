package org.iskconsv.client.command;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Widget;

public class WidgetCommand implements Command
{
	private Widget widget;
	private CaptionPanel targetPanel;
	
	public WidgetCommand(Widget widget, CaptionPanel target)
	{
		this.widget = widget;
		this.targetPanel = target;
	}
	
	@Override
	public void execute()
	{
		targetPanel.setContentWidget(widget);
	}
}