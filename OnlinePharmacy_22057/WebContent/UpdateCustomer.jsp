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
    			    custemailid:{required:true,
    			    	email:true},
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
<body >
<% Customer customer = (Customer)session.getAttribute("cust"); %>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Update Customer</h2>
          </div>
          <div class="col-md-12">
            <form  action="CustomerServlet" method="post" id="update_form">
            <input type="hidden" name="action" value="update">
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                     <label for="medicine_id" class="text-black">Customer ID:<span class="text-danger">*</span></label>
                     <input type="text" class="form-control" name="custid" value="<%=customer.getCustomerId()%>" readonly>
                  </div>
                  <div class="col-md-6">
                    <label for="customer_name" class="text-black">Customer Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="custname" name="custname" value="<%=customer.getCustomerName()%>" >
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="customer_email_id" class="text-black">Customer Email ID:<span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="custemailid" name="custemailid"  value="<%=customer.getCustomerEmailId()%>" readonly>
                  </div>
                  <div class="col-md-6">
                    <label for="contact_no" class="text-black">Customer Contact No:<span class="text-danger">*</span></label>
                    <input type="number" class="form-control" id="custcontactno" name="custcontactno" value="<%= customer.getCustomerContactNo()%>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="address" class="text-black">Address:<span class="text-danger">*</span></label>
                    <textarea cols="30" rows="3" class="form-control"  id="custaddress" name="custaddress" ><%= customer.getCustomerAddress() %></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update">
                  </div>
                  <div class="col-lg-6">
                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Reset">
                  </div>
                </div>
               </div>  
          </form>
         </div>
       </div>
     </div>
  </div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>