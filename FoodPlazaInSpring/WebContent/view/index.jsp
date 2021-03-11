<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
	<jsp:include page="header.jsp"/>
	<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#home").addClass('active'); 
			});
	</script>	
	<!-- Page Content -->
	<section class="py-5">
	  <core:if test="${msg!=null or emsg!=null}">
	  	  <span class="success">${msg}</span> 	  
	  	  <span class="success">${emsg}</span>
	  	</core:if>
	  	<b>${param.msg}</b>
	  <div class="container">
	    <h1>Food Menu</h1>
	    <h2><u>Veg</u></h2>
	  </div>
	  <div class="foodcontainer">
	     <core:forEach var="food" items="${foodlist}">
	     <core:if test="${food.foodCategory=='Veg'}">
	  	<div class="food-card">
		<div class="food-header foodimage" style="background-image: url('foodimage?foodId=${food.foodId}');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--food-header-->
		<div class="food-content">
			<div class="food-content-header">
				<a href="#">
					<h3 class="food-title">${food.foodName}</h3>
				</a>
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Category</label>
					<span>${food.foodCategory }</span>
				</div><!--Type-->
				<div class="info-section">
					<label>Price</label>
					<span>&#8377; ${food.foodPrice}</span>
				</div><!--Price-->
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Description</label>
					<span>${food.foodDescription}</span>
				</div><!--description-->
			</div>
			<div  class="food-info">
				<div  class="info-section" style="text-align:right;" >
				    <core:if test="${admin==null}">
				       <a class="btn btn-primary ml-auto" href="addtocart?foodId=${food.foodId}" role="button">Add to Cart</a>
				    </core:if>
				   <core:if test="${admin !=null}">
				     <td><a onclick="return confirm('do you really want to delete this food?');" class="btn btn-danger" href="deletefood?foodId=${food.foodId}">Delete</a></td>
	  		         <td><a onclick="return confirm('do you really want to edit this food?');" class="btn btn-warning" href="editfood?foodId=${food.foodId}">Edit</a></td>
				</core:if>
				</div>
			</div>
		</div><!--food-content-->
	</div>
	  </core:if>
	  </core:forEach>
	  </div>
	  
	  
	  <div class="container">
	    <h2><u>Non-Veg</u></h2>
	  </div>
	  
	  <div class="foodcontainer">
	     <core:forEach var="food" items="${foodlist}">
	     <core:if test="${food.foodCategory=='Non-Veg'}">
	  	<div class="food-card">
		<div class="food-header foodimage" style="background-image: url('foodimage?foodId=${food.foodId}');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--food-header-->
		<div class="food-content">
			<div class="food-content-header">
				<a href="#">
					<h3 class="food-title">${food.foodName}</h3>
				</a>
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Category</label>
					<span>${food.foodCategory }</span>
				</div><!--Type-->
				<div class="info-section">
					<label>Price</label>
					<span>&#8377; ${food.foodPrice}</span>
				</div><!--Price-->
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Description</label>
					<span>${food.foodDescription}</span>
				</div><!--description-->
			</div>
			<div  class="food-info">
				<div  class="info-section" style="text-align:right;" >
				    <core:if test="${admin==null}">
				       <a class="btn btn-primary ml-auto" href="addtocart?foodId=${food.foodId}" role="button">Add to Cart</a>
				    </core:if>
				   <core:if test="${admin !=null}">
				     <td><a onclick="return confirm('do you really want to delete this food?');" class="btn btn-danger" href="deletefood?foodId=${food.foodId}">Delete</a></td>
	  		         <td><a onclick="return confirm('do you really want to edit this food?');" class="btn btn-warning" href="editfood?foodId=${food.foodId}">Edit</a></td>
				</core:if>
				</div>
			</div>
		</div><!--food-content-->
	</div>
	  </core:if>
	  </core:forEach>
	  </div>
	</section>
	
	<jsp:include page="footer.jsp"/>
