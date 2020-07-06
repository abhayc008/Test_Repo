<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<script type="text/javascript">
     
     $(document).ready(function()
     {
    	 
    	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
    		  return arg !== value;
    		 }, "Value must not equal arg.");
    	 
    	 $("form").validate
    	 ({
    		 rules:
    			 {
    			    selecttype: { valueNotEquals: "---select---" },
    				loginid:{required:true},
    			    loginpassword:
    			    {
    			    	  required:true,
    			    	  maxlength:16,
    			    	  minlength:8
    			    }
    			 },
    			 
    	    messages: {
   		         selecttype: { valueNotEquals: "Please select a type!" }
   	           }
    			 
    	 });
    	 
     });
     
</script>
</head>
<body >
<jsp:include page="Header.jsp"></jsp:include>
<center>
    <form id="form" action="LoginServlet" method="post">
    <input type="hidden" name="action" value="login">
    <fieldSet>
       <legend style="font-size:30px;font-weight: bold">Login</legend>
        <table>
           <tr>
                <td>Type:</td>
                <td>
                    <select name="selecttype">
		            <option selected disabled">---select---</option>
		            <option>Admin</option>
			        <option>User</option>
		            </select><br>
                </td>
            </tr>
            <tr>
                <td>Login Id:</td>
                <td><input type="text" name="loginid"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
               <td><input type="submit" name="login" value="Login"></td>
               <td><input type="reset" value="Reset"></td>
            </tr>
            <tr>
               <td>New User Click <a href="AddCustomer.html">here</a> &nbsp&nbsp&nbsp&nbsp</td>
               <td><a href="ChangePassword.html">Forgot password ?</a></td>
            </tr>
        </table>
     </fieldSet>
     </form>
</center>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>