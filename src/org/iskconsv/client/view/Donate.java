package org.iskconsv.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Donate extends Composite
{

	private static DonateUiBinder uiBinder = GWT.create(DonateUiBinder.class);

	interface DonateUiBinder extends UiBinder<HTMLPanel, Donate>
	{
	}

	interface Style extends CssResource
	{
		String selected();

		String button();

		String donateButton();

		String amountButton();
	}

	@UiField
	Button newTempleButton, operationsButton, sankirtanButton, donateOnceButton,
			donateMonthlyButton, m10, m1, p1, p10;

	@UiField
	Style style;

	@UiField
	InputElement donationItemName, donationAmount, donationType;

	@UiField
	FormElement donationForm;

	public Donate()
	{
		initWidget(uiBinder.createAndBindUi(this));

		newTempleButton.addStyleName(style.button());
		operationsButton.addStyleName(style.button());
		sankirtanButton.addStyleName(style.button());

		donateOnceButton.addStyleName(style.donateButton());
		donateMonthlyButton.addStyleName(style.donateButton());

		m10.addStyleName(style.amountButton());
		m1.addStyleName(style.amountButton());
		p1.addStyleName(style.amountButton());
		p10.addStyleName(style.amountButton());

		DonationTypeClickHandler donationTypeClickHandler = new DonationTypeClickHandler();
		newTempleButton.addClickHandler(donationTypeClickHandler);
		operationsButton.addClickHandler(donationTypeClickHandler);
		sankirtanButton.addClickHandler(donationTypeClickHandler);

		AmountChangeClickHandler amountChangeClickHandler = new AmountChangeClickHandler();
		m10.addClickHandler(amountChangeClickHandler);
		m1.addClickHandler(amountChangeClickHandler);
		p1.addClickHandler(amountChangeClickHandler);
		p10.addClickHandler(amountChangeClickHandler);
	}

	@UiHandler("donateOnceButton")
	void donateOnce(ClickEvent event)
	{
		donationType.setValue("_donations");
		donationAmount.setName("amount");

		// TODO: Validation
		if (donationItemName.getValue().isEmpty())
		{
			Window.alert("Please select one of the categories above.");
			return;
		}

		donationForm.submit();
	}

	@UiHandler("donateMonthlyButton")
	void donateMonthly(ClickEvent event)
	{
		donationType.setValue("_xclick-subscriptions");
		donationAmount.setName("a3");

		// TODO: Validation
		if (donationItemName.getValue().isEmpty())
		{
			Window.alert("Please select one of the categories above.");
			return;
		}

		donationForm.submit();
	}

	class DonationTypeClickHandler implements ClickHandler
	{
		@Override
		public void onClick(ClickEvent event)
		{
			Button[] buttons = { newTempleButton, operationsButton, sankirtanButton };
			for (Button button : buttons)
				button.getElement().removeClassName(style.selected());

			Button button = (Button) event.getSource();

			button.getElement().addClassName(style.selected());
			button.setFocus(false);

			donationItemName.setValue(button.getText());
		}
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
				amount = Float.parseFloat(donationAmount.getValue());
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

			donationAmount.setValue(String.valueOf(amount));
		}
	}
}