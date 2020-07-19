<%@page import="com.pharmacy.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<script type="text/javascript">
     $(document).ready(function()
     {
    	 $("#update_form").validate({
    		 rules:
    			 {
    			    custid:{ required:true},
    			    custname:{ required:true},
    			    custemailid:{ required:true},
    			    custpassword:{
    			    	required:true,
    			    	maxlength:16,
    			    	minlength:8},
    			    custcontactno:{
	    	            required:true,
	    	            maxlength:10,
	    	            minlength:10},
	    	        custaddress:{
	    	        	required:true,
	    	        }
    			 }
    	 });
     });
</script>
</head>
<body>
<% Customer customer = (Customer)session.getAttribute("cust"); %>
<jsp:include page="Header.jsp"></jsp:include>
<center>
    <form  action="CustomerServlet" method="post" id="update_form">
    <input type="hidden" name="action" value="update">
    <fieldset>
       <legend style="font-size:30px;font-weight: bold">Update Customer</legend>
        <table cellspacing="1px" cellpadding="1px">
           <tr>
                <td>Enter Existing Customer Id:</td>
                <td><input type="number" name="custid" value="<%=customer.getCustomerId()%>" readonly ></td>
            </tr>
            <tr>
                <td>Customer Name:</td>
                <td><input type="text" name="custname" value="<%= customer.getCustomerName() %>"></td>
            </tr>
            <tr>
                <td> Customer Email ID: </td>
                <td><input type="email" name="custemailid" id="custemailid" value="<%=customer.getCustomerEmailId() %>"  readonly></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="custpassword" value="<%= customer.getCustomerPassword()%>"></td>
            </tr>
            <tr>
                <td>Customer Contact No:</td>
                <td><input type="number" name="custcontactno" value="<%= customer.getCustomerContactNo()%>"></td>
            </tr>
            <tr>
                <td>Customer Address</td>
                <td><textarea cols="22" rows="5" name="custaddress"><%= customer.getCustomerAddress() %></textarea></td>
            </tr>
            <tr>
                <td> <input type="submit"></td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </fieldset>      
    </form>
</center>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>