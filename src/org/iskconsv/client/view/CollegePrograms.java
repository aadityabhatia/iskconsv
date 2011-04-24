package org.iskconsv.client.view;

import java.util.ArrayList;

import org.iskconsv.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TabBar;

public class CollegePrograms extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<HTMLPanel, CollegePrograms>
	{
	}

	@UiField
	DivElement selectionSpecificContent;
	
	@UiField TabBar tabBar;
	
	@UiField HTML commonContent;
	
	ArrayList<ExternalTextResource> tabContent = new ArrayList<ExternalTextResource>();
	
	TextResource errorMessage;

	public CollegePrograms(Resources resources)
	{
		initWidget(uiBinder.createAndBindUi(this));
		commonContent.setHTML(resources.collegePrograms().getText());
		
		tabBar.addTab("San José State University");
		tabContent.add(resources.collegeProgramsSJSU());
		tabBar.addTab("Stanford University");
		tabContent.add(resources.collegeProgramsStanford());
		tabBar.addTab("Santa Clara University");
		tabContent.add(resources.collegeProgramsSCU());
		
		tabBar.addSelectionHandler(new TabSelectionHandler());
		
		tabBar.selectTab(0);
		
	}
	
	class TabSelectionHandler implements SelectionHandler<Integer>
	{
		@Override
		public void onSelection(SelectionEvent<Integer> event)
		{
			ExternalTextResource textResource = tabContent.get(event.getSelectedItem());
			try
			{
				textResource.getText(new ResourceCallback<TextResource>()
				{
					@Override
					public void onSuccess(TextResource resource)
					{
						selectionSpecificContent.setInnerHTML(resource.getText());					
					}
					
					@Override
					public void onError(ResourceException e)
					{
						selectionSpecificContent.setInnerHTML(errorMessage.getText());
					}
				});
			}
			catch (ResourceException e)
			{
				selectionSpecificContent.setInnerHTML("errorMessage.getText()");
			}
		}
	}
}