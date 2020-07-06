<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script>
   function validate()
   {
	   //Regular  Expression 
	   pattern1= /[0-9]/
	   pattern2 = /[a-z]/
	   pattern3 = /[A-Z]/
	   pattern4 = /[! @ # $ % ^ & *]/
	   
	   data = document.getElementsByClassName("demo");	   
	   count=0;
	   
	   for(i=0;i<data.length;i++)
	   {
		 
		  if(data[i].value =="")
		  {
			 data[i].nextElementSibling.innerHTML=" *Required Field";
			 data[i].nextElementSibling.style.color = "red";
			 count++;
		  }
		  
		  if(data[3].value.length != 10)
		  {
			  data[3].nextElementSibling.innerHTML=" *Please Enter Correct Contact Number";
			  data[3].nextElementSibling.style.color = "red";
			  count++;  
		  }
		  if(data[2].value.length < 8)
		  {
			  data[2].nextElementSibling.innerHTML=" *Passsword length should be 8 or greater than 8";
			  data[2].nextElementSibling.style.color = "red";
			  count++;  
		  }
		 
		  if(!pattern1.test(data[2].value)||!pattern2.test(data[2].value)||!pattern3.test(data[2].value)||!pattern4.test(data[2].value))
		   {
			  data[2].nextElementSibling.innerHTML=" *Password should contain the combination of lower,upper,digit and special character";
			  data[2].nextElementSibling.style.color = "red";
			  count++;
		   }
	   }
	   if(count>0)// if count is 
	   {
		   return false;
	   }
	   else
	   {
		   return true;
	   }
   }

   function clearup(data)
    {
    	if(data.value != "")
    	{
    		data.nextElementSibling.innerHTML = "";
    	}
    }
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<center>
    <form id="form" action="CustomerServlet" onsubmit="return validate()" method="post">
    <input type="hidden" name="action" value="add">
    <fieldset>
       <legend style="font-size:30px;font-weight: bold">Add Customer</legend>
        <table cellspacing="1px" cellpadding="1px">
            <tr>
                <td>Customer Name:</td>
                <td><input type="text" name="custName" class="demo" onblur="clearup(this)"><b></b></td>
            </tr>
            <tr>
                <td> Customer Email ID: </td>
                <td><input type="email" name="custEmailId" class="demo" onblur="clearup(this)"><b></b></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="custPassword" class="demo" onblur="clearup(this)"><b></b></td>
            </tr>
            <tr>
                <td>Customer Contact No:</td>
                <td><input type="number" name="custContactNo" class="demo" onblur="clearup(this)"><b></b></td>
            </tr>
            <tr>
                <td>Customer Address</td>
                <td><textarea cols="22" rows="5" name="custAddress" class="demo" onblur="clearup(this)"></textarea><b></b></td>
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