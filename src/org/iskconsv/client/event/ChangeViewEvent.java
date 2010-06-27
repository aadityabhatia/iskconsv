package org.iskconsv.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ChangeViewEvent extends GwtEvent<ChangeViewEventHandler>
{
	public static final Type<ChangeViewEventHandler> TYPE = new Type<ChangeViewEventHandler>();
	
	@Override
	protected void dispatch(ChangeViewEventHandler handler)
	{
		handler.onChangeView(this);
	}

	@Override
	public Type<ChangeViewEventHandler> getAssociatedType()
	{
		return TYPE;
	}
}