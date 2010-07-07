package org.iskconsv.client.command;

import org.iskconsv.client.resources.Resources;
import org.iskconsv.client.widget.InfoPopup;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Command;

public class InfoPopupCommand implements Command
{
	private Object content;

	public InfoPopupCommand(Object content)
	{
		this.content = content;
	}

	@Override
	public void execute()
	{
		if (content instanceof ExternalTextResource)
		{
			ExternalTextResource resource = (ExternalTextResource) content;
			
			try
			{
				resource.getText(new ResourceCallback<TextResource>()
				{
					@Override
					public void onSuccess(TextResource resource)
					{
						InfoPopup.center(resource.getText());
					}

					@Override
					public void onError(ResourceException e)
					{
						InfoPopup.center(Resources.INSTANCE.errorMessage().getText());
					}
				});
			}
			catch (ResourceException e)
			{
				InfoPopup.center(Resources.INSTANCE.errorMessage().getText());
			}
		}
		else
		{
			InfoPopup.center(content.toString());
		}
	}
}