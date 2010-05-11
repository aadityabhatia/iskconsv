package org.iskconsv.client.command;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopupCommand implements Command
{
	private PopupPanel popupPanel;
	
	public PopupCommand(PopupPanel popupPanel)
	{
		this.popupPanel = popupPanel;
	}
	
	@Override
	public void execute()
	{
		popupPanel.center();
	}
}