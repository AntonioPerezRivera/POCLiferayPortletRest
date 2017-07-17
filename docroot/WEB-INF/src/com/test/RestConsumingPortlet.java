package com.test;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.test.model.Empleado;
import com.test.rest.ApiCommunication;

import java.io.IOException;
import java.util.ArrayList;

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

		ArrayList<Empleado> listaEmpleados = null;

		try {
			listaEmpleados = comm.doCommunication();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaEmpleados.size() > 0)
			renderRequest.setAttribute("listaEmpleados", listaEmpleados);

		include(viewTemplate, renderRequest, renderResponse);
	}

}
