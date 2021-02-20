<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<jsp:include page="header.jsp"/>
<script type="text/javascript">

   function loadImg(){
     $('#frame').attr('src', URL.createObjectURL(event.target.files[0]));
   };
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#addfood").addClass('active'); 
			});
	</script>
<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	  <core:choose>
	  	<core:when test="${action!=null}">
	  		<h1>Update Food</h1>
	  	</core:when>
	  	<core:otherwise>
	    	<h1>New Food</h1>
	    </core:otherwise>
	   </core:choose>
	  </div>
	  <div class="container">
		  
		  <core:if test="${action==null}">
		  	<form action="savefood" method="post" enctype="multipart/form-data">
		  </core:if>
		  <core:if test="${action!=null}">
		  	<form action="updatefood" method="post" enctype="multipart/form-data">
		  </core:if>
		   	
		   	<table class="table ">
	   		<tr>
	   			<td colspan="2">
	   				<core:if test="${msg!=null}">
	   					<span class="success">${msg}<br/>
	   					Food Id is ${foodId}</span>
	   				</core:if>
	   			</td>
	   		</tr>
	   		<core:if test="${action!=null}">
	   		<tr>
	   			<td><label class="font-weight-bold">Food ID</label></td>
	   			<td><input readonly="readonly" class="form-control" type="text" name="foodId" value="${food.foodId}"/></td>
	   		</tr>
	   		</core:if>
	   		<tr>
	   			<td><label class="font-weight-bold">Food Name</label></td>
	   			<td><input class="form-control" type="text" name="foodName" value="${food.foodName}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Food Category</label></td>
	   			<td><input class="form-control" type="text" name="foodCategory" value="${food.foodCategory}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Food Price</label></td>
	   			<td><input class="form-control" type="text" name="foodPrice" value="${food.foodPrice}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Food Description</label></td>
	   			<td><input class="form-control" type="text" name="foodDescription" value="${food.foodDescription}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Food Image</label></td>
	   			<td><input class="form-control" id="foodimage" type="file" name="file"  onchange="loadImg()"/></td>
	   		</tr>
	   		<tr>
	   		   <td></td>
	   		   <td>
	   		   <core:choose>
				  		<core:when test="${action!=null}">
				  		<img id="frame" src="foodimage?foodId=${food.foodId}" height="100" width="100">   		   
	   		            </core:when>
				  		<core:otherwise>
				  		<img id="frame" width="100px" height="100px"/>
				  		</core:otherwise>
			   		</core:choose>
			 </td>
	   		</tr>
	   		<tr>
	   			<td colspan="2" align="right">
			   		<core:choose>
				  		<core:when test="${action!=null}">  		
				  			<input class="btn btn-outline-success btn-lg" type="submit" value="Update food">
				  		</core:when>
				  		<core:otherwise>
				    		<input class="btn btn-outline-warning btn-lg" type="submit" value="Add food">
				    	</core:otherwise>
			   		</core:choose>	   				
	   			</td>
	   		</tr>
	   	</table>
	   	</form>
	  </div>
	 </section> 

<jsp:include page="footer.jsp"/>
