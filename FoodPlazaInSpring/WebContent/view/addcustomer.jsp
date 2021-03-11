<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#addcustomer").addClass('active'); 
			});
		$(document).ready(function(){
			$("#customer").validate({
				 
				rules:
	    			 {
	    			    customerName:{ required:true},
	    			    customerEmailId:{required:true,
	    			    	email:true},
	    			    customerPassword:{
	    			    	required:true,
			    	        maxlength:16,
			    	        minlength:8},
	    			    customerMobileNo:{
		    	            required:true,
		    	            maxlength:10,
		    	            minlength:10},
		    	        customerAddress:{
		    	        	required:true,
		    	        }
	    			 }
	    	 });
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
		  	<form action="savecustomer" method="post" enctype="multipart/form-data" id="customer">
		  </core:if>	
		  <core:if test="${action!=null}">
		  	<form action="updatecustomer" method="post" enctype="multipart/form-data" id="customer">
		  </core:if>
		   	
		   	<table class="table" style="color:white;background-color:black">
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
	   			<td><label class="font-weight-bold">Customer ID</label>
	   			<input readonly="readonly" class="form-control" type="text" name="customerId" value="${customer.customerId}"/></td>
	   		</tr>
	   		</core:if>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Name</label>
	   			<input class="form-control" type="text" name="customerName" value="${customer.customerName}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Email Id</label>
	   			<input readonly="readonly" class="form-control" type="text" name="customerEmailId" value="${customer.customerEmailId}"/></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Password</label>
	   			<input class="form-control" type="password" name="customerPassword" value="${customer.customerPassword}"/></td>
	        </tr>
	        <tr>    
	            <td><label class="font-weight-bold">Mobile Number</label>
	   			<input class="form-control" type="number" name="customerMobileNo" value="${customer.customerMobileNo}"/></td>   		
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Customer Address</label>
	   			<textarea  cols=30 rows=3 class="form-control" type="text" name="customerAddress">${customer.customerAddress}</textarea></td>
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