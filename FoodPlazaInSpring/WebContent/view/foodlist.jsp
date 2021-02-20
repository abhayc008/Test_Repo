<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>
<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#foodlist").addClass('active'); 
			});
	</script>
<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>Food Menu</h1>
	  </div>
	  <div class="container">
	  <core:if test="${!foodlist.isEmpty()}">
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
	  	<core:forEach var="food" items="${foodlist}">
	  	<tr>
	  		<td>${food.foodId}</td>
	  		<td>${food.foodName}</td>
	  		<td>${food.foodCategory}</td>
	  		<td>${food.foodPrice}</td>
	  		<td><img src="foodimage?foodId=${food.foodId}" height="100" width="100"></td>
	  		<!-- URL Rewriting -->
	  		<td><a onclick="return confirm('do you really want to delete this food?');" class="btn btn-danger" href="deletefood?foodId=${food.foodId}">Delete</a></td>
	  		<td><a onclick="return confirm('do you really want to edit this food?');" class="btn btn-warning" href="editfood?foodId=${food.foodId}">Edit</a></td>
	  	</tr>	
	  	</core:forEach>
	  </table>
	  </core:if>
	  <core:if test="${foodlist.isEmpty()}">
	  	<h3>No Food found</h3>
	  </core:if>
	  </div>
	  </section>
	  
<jsp:include page="footer.jsp"/> 