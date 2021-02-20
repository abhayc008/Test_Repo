<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:include page="header.jsp"></jsp:include>
    
    <!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	  <h1>Login</h1>
	  </div>
	  <div class="container">
		  	<form action="dologin" method="post">
		   	<table class="table ">
	   		<tr>
	   			<td colspan="2">
	   				<core:if test="${msg!=null}">
	   					<span class="success">${msg}<br/>
	   				</core:if>
	   			</td>
	   		</tr>
	   		
	   		<tr>
	   			<td><label class="font-weight-bold">User Type</label></td>
	   			<td>
	   			    <select class="form-control" type="text" name="usertype" >
	   			       <option value="" selected="selected">Select</option>
	   			       <option value="admin">Admin</option>
	   			       <option value="customer">Customer</option>
	   			    </select>
	   			</td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Email Id</label></td>
	   			<td><input class="form-control" type="text" name="emailId" /></td>
	   		</tr>
	   		<tr>
	   			<td><label class="font-weight-bold">Password</label></td>
	   			<td><input class="form-control" type="password" name="password" /></td>
	   		</tr>
	   		<tr>
	   		   <td><a class="nav-link" id="addcustomer" href="custform">If you not register Register here</a></td>
	   		</tr>
	   		<tr>
	   			<td colspan="2" align="right">
				  			<input class="btn btn-outline-success btn-lg" type="submit" value="Login">
				    		<input class="btn btn-outline-warning btn-lg" type="reset" value="Reset">
				</td>
	   		</tr>
	   	</table>
	   	</form>
	  </div>
	 </section> 

<jsp:include page="footer.jsp"/>