package org.iskconsv.client.command;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;

public class HistoryCommand implements Command
{
	private String anchor;
	
	public HistoryCommand(String anchor)
	{
		this.anchor = anchor;
	}
	
	public void setAnchor(String anchor)
	{
		this.anchor = anchor;
	}
	
	@Override
	public void execute()
	{
		History.newItem(anchor);
	}
}