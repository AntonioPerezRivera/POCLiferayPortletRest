<%@include file="init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="com.test.model.WeatherObject" %>

<portlet:defineObjects />

<% 
WeatherObject wObject = (WeatherObject) renderRequest.getAttribute("weather");
%>

<portlet:resourceURL var="altaEmpleado">
</portlet:resourceURL>

<portlet:defineObjects />

<div id="tabla_tiempo">
<table class="table table-hover">
<thead>
	<tr>
		<th> <c:out value="Status"/> </th>
		<th> <c:out value="Info"/> </th>
		<th> <c:out value="Temperature"/> </th>
		<th> <c:out value="Max Temp."/> </th>
		<th> <c:out value="Min Temp."/> </th>
	</tr>
</thead>
<tbody>
	<tr>
		<th> <c:out value="${weather.currentStatus}"/> </th>
		<th> <c:out value="${weather.currentStatusInfo}"/> </th>
		<th> <c:out value="${weather.currentTemp}"/> </th>
		<th> <c:out value="${weather.maxTemp}"/> </th>
		<th> <c:out value="${weather.minTemp}"/> </th>
	</tr>
</tbody>
</table>
</div>
