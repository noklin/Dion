package com.noklin.client.http;

import java.util.function.Consumer;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.noklin.client.component.Component;
import com.noklin.client.component.ComponentFactory;

public class ComponentRequest implements RequestCallback{
	
	private final Consumer<Component> componentConsumer;
	ComponentRequest(Consumer<Component> componentConsumer){
		this.componentConsumer = componentConsumer;
	}
	
	@Override
	public void onResponseReceived(Request request, Response response) {
		switch(response.getStatusCode()) {
		case 200:
			ComponentFactory factory = new ComponentFactory();
			componentConsumer.accept(factory.create(response.getText()));
			break;
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
	}
	
}
