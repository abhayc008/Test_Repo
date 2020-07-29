<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<script type="text/javascript">
    $(document).ready(function()
     {
    	 $("change_password").validate({
    		 rules:
    			 {
    			    loginid:{required:true},
	    	        newpassword:
                     {
	    	        	required:true,
		    	        maxlength:16,
		    	        minlength:8
		    	     },
		    	    password:
    				{
    				    required:true,
    				    equalTo:"#pass"
    				}
    			 }
    	 });
    	 
     });
</script>
</head>
<body >
<jsp:include page="Header.jsp"></jsp:include>
<center>
    <form id="change_password" action="LoginServlet" method="post">
    <input type="hidden" name="action" value="change">
    
    <fieldSet>
       <legend style="font-size:30px;font-weight: bold">Change Password</legend>
        <table>
            
            <tr>
                <td>Type:</td>
                <td><input type="radio" name="selecttype" value="User">Customer
                <input type="radio" name="selecttype" value="Admin">Admin</td>
            </tr>
            <tr>
               <td>Login Id:</td>
                <td><input type="text" name="loginid"></td>
            </tr>
            <tr>
                <td>New Password:</td>
                <td><input type="password" id="pass" name="newpassword"></td>
            </tr>
            <tr>
                <td>Confirm New Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
               <td><input type="submit" name="login" value="login"></td>
               <td><input type="reset" value="Cancel"></td>
            </tr>
        </table>
     </fieldSet>
     </form>
</center>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>