<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>
<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#addcustomer").addClass('active'); 
			});
	</script>
<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	  <core:choose>
	  	<core:when test="${action!=null}">
	  		<h1>Update customer</h1>
	  	</core:when>
	  	<core:otherwise>
	    	<h1>New customer</h1>
	    </core:otherwise>
	   </core:choose>
	  </div>
	  <div class="container">
		  
		  <core:if test="${action==null}">
		  	<form action="savecustomer" method="post" enctype="multipart/form-data">
		  </core:if>
		  <core:if test="${action!=null}">
		  	<form action="updatecustomer" method="post" enctype="multipart/form-data">
		  </core:if>
		   	
		   	<table class="table ">
	   		<tr>
	   			<td colspan="2">
	   				<core:if test="${msg!=null}">
	   					<span class="success">${msg}<br/>
	   					customer Id is ${customerId}</span>
	   				</core:if>
	   			</td>
	   		</tr>
	   		<core:if test="${action!=null}">
	   		<tr>
	   			<td><label class="font-weight-bold">Customer ID</label></td>
	   			<td><input readonly="readonly" class="form-control" type="text" name="customerId" value="${customer.customerId}"/></td>
	   		</tr>
	   		</core:if>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Name</label></td>
	   			<td><input class="form-control" type="text" name="customerName" value="${customer.customerName}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Email Id</label></td>
	   			<td><input class="form-control" type="text" name="customerEmailId" value="${customer.customerEmailId}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Password</label></td>
	   			<td><input class="form-control" type="password" name="customerPassword" value="${customer.customerPassword}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Address</label></td>
	   			<td><input class="form-control" type="text" name="customerAddress" value="${customer.customerAddress}"/></td>
	   		</tr>
	   		<tr>
	   			<td colspan="2" align="right">
			   		<core:choose>
				  		<core:when test="${action!=null}">
				  			<input class="btn btn-outline-success btn-lg" type="submit" value="Update customer">
				  		</core:when>
				  		<core:otherwise>
				    		<input class="btn btn-outline-warning btn-lg" type="submit" value="Register">
				    	</core:otherwise>
			   		</core:choose>	   				
	   			</td>
	   		</tr>
	   	</table>
	   	</form>
	  </div>
	 </section> 

<jsp:include page="footer.jsp"/>