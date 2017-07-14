package com.test;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.model.WeatherObject;
import com.test.rest.ApiCommunication;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class RestConsumingPortlet
 */
public class RestConsumingPortlet extends MVCPortlet {

	private static ApiCommunication comm = new ApiCommunication();

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		WeatherObject wObject = null;

		try {
			wObject = comm.doCommunication();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (wObject != null)
			renderRequest.setAttribute("weather", wObject);

		include(viewTemplate, renderRequest, renderResponse);
	}

}
