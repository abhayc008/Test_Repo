<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="Site.css">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!--  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">-->
  <link rel="stylesheet" href="fonts/icomoon/style.css">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/magnific-popup.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">


  <link rel="stylesheet" href="css/aos.css">

  <link rel="stylesheet" href="css/style.css">
<script>

function validate1()
	{
	//Regular  Expression 
	   pattern1= /[0-9]/
	   pattern2 = /[a-z]/
	   pattern3 = /[A-Z]/
	   pattern4 = /[! @ # $ % ^ & *]/
	   
	   data = document.getElementsByClassName("abc");	   
	   count=0;
	   
	   for(i=0 ; i < data.length ; i++)
	   {
		 //var abc = data[i].innerText;
		   console.log(abc);
	   }
	
		return false;
	}
   function validate()
   {
	   //Regular  Expression 
	   pattern1= /[0-9]/
	   pattern2 = /[a-z]/
	   pattern3 = /[A-Z]/
	   pattern4 = /[! @ # $ % ^ & *]/
	   
	   data = document.getElementsByClassName("form-control");	   
	   count=0;
	   
	   for(i=1 ; i <= data.length ; i++)
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
    		//data.nextElementSibling.innerHTML = "";
    	}
    }
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Add Customer 1</h2>
          </div>
          <div class="col-md-12">
            <form id="form"  onsubmit="return validate1()"  >
            
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="customer_name" class="text-black">Customer Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control abc" id="custName" name="custName"  onblur="clearup(this)"><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="customer_email_id" class="text-black">Customer Email ID:<span class="text-danger">*</span></label>
                    <input type="email" class="form-control abc" id="custEmailId" name="custEmailId" onblur="clearup(this)"><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="password" class="text-black">Password:<span class="text-danger">*</span></label>
                    <input type="password" class="form-control abc" id="custPassword" name="custPassword"  onblur="clearup(this)"><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="contact_no" class="text-black">Customer Contact No:<span class="text-danger">*</span></label>
                    <input type="number" class="form-control abc" id="custContactNo" name="custContactNo"  onblur="clearup(this)"><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="address" class="text-black">Address:<span class="text-danger">*</span></label>
                    <textarea cols="30" rows="7" id="custAddress" name="custAddress"  onblur="clearup(this)" class="form-control abc" ></textarea><b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Add">
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