<%@include file="init.jsp" %>

<portlet:defineObjects />

<%
List<Empleado> empleadosObj = (List) renderRequest.getAttribute("listaEmpleados");
//String responseEmpleados = "";
if(Validator.isNotNull(empleadosObj)){
	//responseEmpleados = empleadosObj.toString();
	pageContext.setAttribute("listaEmpleados", empleadosObj);
}
%>


<portlet:resourceURL var="altaEmpleado">
</portlet:resourceURL>

<div id="tabla_clientes">
<table class="table table-hover">
<thead>
	<tr>
		<th> <c:out value="Id"/> </th>
		<th> <c:out value="Name"/> </th>
		<th> <c:out value="Email"/> </th>
	</tr>
</thead>
<tbody>
<c:forEach var="empleado" items="${listaEmpleados}">
	<tr>
		<th> <c:out value="${empleado.id}"/> </th>
		<th> <c:out value="${empleado.nombre}"/> </th>
		<th> <c:out value="${empleado.email}"/> </th>
	</tr>
</c:forEach>
</tbody>
</table>
</div>
