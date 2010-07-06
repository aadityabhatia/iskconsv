package org.iskconsv.client.command;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;

/**
 * Adds a token to the browser history and executes the given command
 */
public class HistoryCommand implements Command
{
	private String token;
	
	public HistoryCommand(String token)
	{
		this.token = token;
	}
	
	public HistoryCommand(Enum<?> token)
	{
		this.token = token.name();
	}
	
	public void setToken(String token)
	{
		this.token = token;
	}
	
	@Override
	public void execute()
	{
		if (token != null)
			History.newItem(token);
	}
}