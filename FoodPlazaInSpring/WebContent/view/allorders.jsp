<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>

<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>Order List</h1>
	  </div>
	  <div class="container">
	  <core:if test="${!orderlist.isEmpty()}">
	  <table class="table table-bordered table-hover">
	  <thead class="thead-dark">
	  	<tr>
	  		<th>Order Id</th>
	  		<th>Customer EmailId</th>
	  		<th>Order Date</th>
	  		<th>Total Amount</th>
	  		<th>Order Status</th>
	  		<th colspan="2">Action</th>
	  	</tr>
	  </thead>	
	  	<core:forEach var="order" items="${orderlist}">
	  	<tr>
	  		<td><a  href="orderDetails?orderId=${order.orderId}">${order.orderId}</a></td>
	  		<td>${order.custEmailId}</td>
	  		<td>${order.orderDateTime}</td>
	  		<td>${order.totalAmount}</td>
	  		<td>${order.orderStatus}</td>
	  		<!-- URL Rewriting -->
	  		<td><a onclick="return confirm('do you really want to delete this food?');" class="btn btn-danger" href="">Delete</a></td>
	  	</tr>	
	  	</core:forEach>
	  </table>
	  </core:if>
	  </div>
	  </section>
<jsp:include page="footer.jsp"/>