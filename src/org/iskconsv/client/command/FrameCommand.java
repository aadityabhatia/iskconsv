package org.iskconsv.client.command;

import org.iskconsv.client.widget.IFrame;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.CaptionPanel;

public class FrameCommand implements Command
{
	private String url;
	private CaptionPanel targetPanel;
	
	public FrameCommand(String url, CaptionPanel target)
	{
		this.url = url;
		this.targetPanel = target;
	}
	
	@Override
	public void execute()
	{
		targetPanel.setContentWidget(new IFrame(url));
	}
}