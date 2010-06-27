package org.iskconsv.client.command;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopupCommand implements Command
{
	private PopupPanel popupPanel = null;

	private Class<PopupPanel> className;

	@SuppressWarnings("unchecked")
	public PopupCommand(Class<?> className)
	{
		this.className = (Class<PopupPanel>) className;
	}
	
	public PopupCommand(PopupPanel popupPanel)
	{
		this.popupPanel = popupPanel;
	}

	@Override
	public void execute()
	{
		if (popupPanel == null)
			popupPanel = GWT.create(className);
		popupPanel.center();
	}
}