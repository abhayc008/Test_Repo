<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
<jsp:include page="header.jsp"/>
<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#customerlist").addClass('active'); 
			});
	</script>
<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>customer Menu</h1>
	  </div>
	  <div class="container">
	  <core:if test="${!customerlist.isEmpty()}">
	  <table class="table table-bordered table-hover">
	  <thead class="thead-dark">
	  	<core:if test="${msg!=null or emsg!=null}">
	  	<tr>
	  		<td colspan="6">
	  			<span class="success">${msg}</span>
	  			<span class="error">${emsg}</span>
	  		</td>
	  	</tr>
	  	</core:if>
	  	<tr>
	  		<th>Id</th>
	  		<th>Name</th>
	  		<th>Email Id</th>
	  		<th>Address</th>
	  		<th colspan="2">Action</th>
	  	</tr>
	  </thead>	
	  	<core:forEach var="customer" items="${customerlist}">
	  	<tr>
	  		<td>${customer.customerId}</td>
	  		<td>${customer.customerName}</td>
	  		<td>${customer.customerEmailId}</td>
	  		<td>${customer.customerAddress}</td>
	  		<!-- URL Rewriting -->
	  		<td><a onclick="return confirm('do you really want to delete this customer?');" class="btn btn-danger" href="deletecustomer?customerId=${customer.customerId}">Delete</a></td>
	  		<td><a onclick="return confirm('do you really want to edit this customer?');" class="btn btn-warning" href="editcustomer?customerId=${customer.customerId}">Edit</a></td>
	  	</tr>	
	  	</core:forEach>
	  </table>
	  </core:if>
	  <core:if test="${customerlist.isEmpty()}">
	  	<h3>No customer found</h3>
	  </core:if>
	  </div>
	  </section>
	  
<jsp:include page="footer.jsp"/> 