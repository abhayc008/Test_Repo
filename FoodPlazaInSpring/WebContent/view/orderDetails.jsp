<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>

<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>Order Details</h1>
	  </div>
	  <div class="container">
	  <core:if test="${!orderDetails.isEmpty()}">
	  <table class="table table-bordered table-hover">
	  <thead class="thead-dark">
	  	<tr>
	  		<th>Id</th>
	  		<th>Food Id</th>
	  		<th>Food Name</th>
	  		<th>Food Qty</th>
	  		<th>Food Price</th>
	  	</tr>
	  </thead>	
	  	<core:forEach var="order" items="${orderDetails}">
	  	<tr>
	  		<td>${order.id}</td>
	  		<td>${order.foodId}</td>
	  		<td>${order.foodName}</td>
	  		<td>${order.qty}</td>
	  		<td>${order.price}</td>
	  	</tr>	
	  	</core:forEach>
	  </table>
	  </core:if>
	  </div>
	  </section>
<jsp:include page="footer.jsp"/>