package com.noklin.client;
 
 
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.noklin.client.component.ComponentFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Dion implements EntryPoint {
	
	public void onModuleLoad() {
		App.debug("" + detectResourceName());
		RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, detectResourceName()); 
		try {
			rb.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					ComponentFactory fsctory = new ComponentFactory();
					App.debug("" + response.getStatusCode());
					App.debug("" + response.getText());
					long tb = System.currentTimeMillis();
					RootPanel.get().add(fsctory.create(response.getText()).asWidget());
					long ta = System.currentTimeMillis();
					App.debug("time: " + (ta-tb) + " ms");
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
				}
				
			});
			
		} catch (RequestException e) { 
			e.printStackTrace();
		} 
	}
	private String detectResourceName() {
		String resName = Window.Location.getPath();
		if("/".equals(resName)) {
			return "http://localhost/root.json";
		}
		return "http://localhost" + resName;
	}
	
	
	
 	
}