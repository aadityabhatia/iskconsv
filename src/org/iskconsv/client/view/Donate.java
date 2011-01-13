package org.iskconsv.client.view;

import java.util.ArrayList;
import java.util.List;

import org.iskconsv.client.command.CommandClickHandler;
import org.iskconsv.client.command.InfoPopupCommand;
import org.iskconsv.client.model.DonationType;
import org.iskconsv.client.resources.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.TabBar;

public class Donate extends Composite
{
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<DockLayoutPanel, Donate>
	{
	}

	interface Style extends CssResource
	{
		String donateButton();

		String amountButton();
	}

	@UiField
	Button donateOnceButton, donateMonthlyButton, m10, m1, p1, p10;
	
	@UiField Anchor donateDetailsElectronic, donateDetailsInPerson;

	@UiField
	Style style;

	@UiField
	InputElement donationItemNameInputElement, donationAmountInputElement, donationTypeInputElement, destinationAccountInputElement;

	@UiField
	DivElement selectionSpecificContent, category;
	
	@UiField
	FormElement donationForm;
	
	@UiField TabBar tabBar;
	
	List<DonationType> donationTypes = new ArrayList<DonationType>();
	
	private DonationType donationType;
	
	TextResource errorMessage;

	public Donate(Resources resources)
	{
		initWidget(uiBinder.createAndBindUi(this));
		
		errorMessage = resources.errorMessage();

		tabBar.addTab("New Temple");
		donationTypes.add(new DonationType("New Temple", resources.newTemple(), null, "isvnewtemple@gmail.com", "nirakuladd@gmail.com"));
		tabBar.addTab("Temple Operations");
		donationTypes.add(new DonationType("Temple Operations", resources.templeOpsDonation(), null, "nirakuladd@gmail.com"));
		tabBar.addTab("Sankirtan");
		donationTypes.add(new DonationType("Sankirtan", resources.sankirtanDonation(), null, "teamisv@gmail.com"));
		tabBar.addSelectionHandler(new DonationTypeSelectionHandler());
		
		m10.addStyleName(style.amountButton());
		m1.addStyleName(style.amountButton());
		p1.addStyleName(style.amountButton());
		p10.addStyleName(style.amountButton());

		donateOnceButton.addStyleName(style.donateButton());
		donateMonthlyButton.addStyleName(style.donateButton());

		AmountChangeClickHandler amountChangeClickHandler = new AmountChangeClickHandler();
		m10.addClickHandler(amountChangeClickHandler);
		m1.addClickHandler(amountChangeClickHandler);
		p1.addClickHandler(amountChangeClickHandler);
		p10.addClickHandler(amountChangeClickHandler);
		
		donateDetailsElectronic.addClickHandler(new CommandClickHandler(new InfoPopupCommand(resources.donateElectronicInstructions())));
		donateDetailsInPerson.addClickHandler(new CommandClickHandler(new InfoPopupCommand(resources.donateInPersonInstructions())));
	}

	@UiHandler("donateOnceButton")
	void donateOnce(ClickEvent event)
	{
		donationTypeInputElement.setValue("_donations");
		donationAmountInputElement.setName("amount");

		// TODO: Validation
		if (donationItemNameInputElement.getValue().isEmpty())
		{
			Window.alert("Please select one of the categories.");
			return;
		}
		destinationAccountInputElement.setValue(donationType.getDestinationAccountOneTime());

		donationForm.submit();
	}

	@UiHandler("donateMonthlyButton")
	void donateMonthly(ClickEvent event)
	{
		donationTypeInputElement.setValue("_xclick-subscriptions");
		donationAmountInputElement.setName("a3");

		// TODO: Validation
		if (donationItemNameInputElement.getValue().isEmpty())
		{
			Window.alert("Please select one of the categories above.");
			return;
		}
		destinationAccountInputElement.setValue(donationType.getDestinationAccountMonthly());

		donationForm.submit();
	}

	class AmountChangeClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event)
		{
			String delta = ((Button) event.getSource()).getText();

			Float amount;

			try
			{
				amount = Float.parseFloat(donationAmountInputElement.getValue());
			}
			catch (NumberFormatException e)
			{
				amount = 0f;
			}

			if (delta.equals("-10"))
				amount -= 10;
			else if (delta.equals("-1"))
				amount -= 1;
			else if (delta.equals("+1"))
				amount += 1;
			else if (delta.equals("+10"))
				amount += 10;

			if (amount < 0)
				amount = 0f;

			donationAmountInputElement.setValue(String.valueOf(amount));
		}
	}
	
	class DonationTypeSelectionHandler implements SelectionHandler<Integer>
	{
		@Override
		public void onSelection(SelectionEvent<Integer> event)
		{
			donationType = donationTypes.get(event.getSelectedItem());
			donationItemNameInputElement.setValue(donationType.getName());
			category.setInnerHTML(donationType.getName());
			
			try
			{
				donationType.getInfo().getText(new ResourceCallback<TextResource>()
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