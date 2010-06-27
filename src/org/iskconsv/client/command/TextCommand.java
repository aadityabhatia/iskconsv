package org.iskconsv.client.command;

import org.iskconsv.client.Controller;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.user.client.Command;

public class TextCommand implements Command
{
	private ExternalTextResource resource;
	private String historyToken;
	
	public TextCommand(ExternalTextResource resource, String historyToken)
	{
		this.resource = resource;
		this.historyToken = historyToken;
	}
	
	@Override
	public void execute()
	{
		Controller.INSTANCE.updateContent(resource, historyToken);
	}
}