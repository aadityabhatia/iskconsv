package org.iskconsv.client.command;

import org.iskconsv.client.Controller;
import org.iskconsv.client.widget.IFrame;

import com.google.gwt.user.client.Command;

public class FrameCommand implements Command
{
	private String url;
	
	public FrameCommand(String url)
	{
		this.url = url;
	}
	
	@Override
	public void execute()
	{
		Controller.INSTANCE.updateContent(IFrame.getFrame(url), null);
	}
}