<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>
<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>Food Details</h1>
	  </div>
	  <div class="container">
	  <core:if test="${food != null}">
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
	  		<th>Category</th>
	  		<th>Price</th>
	  		<th>Food Image</th>
	  		<th colspan="2">Action</th>
	  	</tr>
	  </thead>	
	  	<tr>
	  		<td>${food.foodId}</td>
	  		<td>${food.foodName}</td>
	  		<td>${food.foodCategory}</td>
	  		<td>${food.foodPrice}</td>
	  		<td><img src="foodimage?foodId=${food.foodId}" height="100" width="100"></td>
	  		<td><a class="btn btn-primary ml-auto" href="addtocart?foodId=${food.foodId}" role="button">Add to Cart</a></td>
	  	</tr>	
	  </table>
	  </core:if>
	  <core:if test="${foodlist.isEmpty()}">
	  	<h3>No Food found</h3>
	  </core:if>
	  </div>
	  </section>
	  
<jsp:include page="footer.jsp"/> 