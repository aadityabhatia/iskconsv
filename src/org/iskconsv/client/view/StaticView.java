package org.iskconsv.client.view;

import org.iskconsv.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.Widget;

public class StaticView extends LazyPanel
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<HTMLPanel, StaticView>
	{
	}

	@UiField DivElement content;
	
	ExternalTextResource resource;

	public StaticView(ExternalTextResource resource)
	{
		this.resource = resource;
	}

	@Override
	protected Widget createWidget()
	{
		Widget widget = uiBinder.createAndBindUi(this);

		// TODO: Move the following mechanism to a utility class
		try
		{
			resource.getText(new ResourceCallback<TextResource>()
			{
				@Override
				public void onSuccess(TextResource resource)
				{
					content.setInnerHTML(resource.getText());
				}
				
				@Override
				public void onError(ResourceException e)
				{
					content.setInnerHTML(Resources.INSTANCE.errorMessage().getText());
				}
			});
		}
		catch (ResourceException e)
		{
			content.setInnerHTML(Resources.INSTANCE.errorMessage().getText());
		}
		return widget;
	}
}