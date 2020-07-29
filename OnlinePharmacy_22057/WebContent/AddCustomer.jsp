<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>

<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<script>
      $(document).ready(function(){
    	  $("#custemailid").change(function()
    		  {
    		    var custemailid = $("#custemailid").val();

    		    $.ajax({
    			    type:'GET',
    			    data:{name:'checkcustemailid',custemailid:custemailid},
    			    url:'CustomerServlet',
    			    success:function(result)
    			     {
    				   $("#custemailiderr").html(result);
    			     },
    			    error:function(result)
    			     {
    			       alert(result);
    			     }
    			         
    		     });
    		 });
    	     
    	  $("#custpassword").change(function()
        		  {
        		    var custpassword = $("#custpassword").val();
        		    //alert("hello");
        		    	  
        		    $.ajax({
        			    type:'GET',
        			    data:{name:'checkcustpassword',custpassword:custpassword},
        			    url:'CustomerServlet',
        			    success:function(result)
        			     {
        				   $("#custpassworderr").html(result);
        			     },
        			    error:function(result)
        			     {
        			       alert(result);
        			     }
        			         
        		     });
        		 });
    	  $("#custcontactno").change(function()
        		  {
        		    var custcontactno = $("#custcontactno").val();
        		    //alert("hello");
        		    	  
        		    $.ajax({
        			    type:'GET',
        			    data:{name:'checkcustcontactno',custcontactno:custcontactno},
        			    url:'CustomerServlet',
        			    success:function(result)
        			     {
        				   $("#custcontactnoerr").html(result);
        			     },
        			    error:function(result)
        			     {
        			       alert(result);
        			     }
        			         
        		     });
        		 });
      });
      
</script>
<script>
   function validate()
   {
	   //Regular  Expression 
	   pattern1= /[0-9]/
	   pattern2 = /[a-z]/
	   pattern3 = /[A-Z]/
	   pattern4 = /[! @ # $ % ^ & *]/
	   
	   data = document.getElementsByClassName("customer_form");	   
	   count=0;
	   
	   for(i=0; i < data.length ; i++)
	   {
		 
		  if(data[i].value =="")
		  {
			 data[i].nextElementSibling.innerHTML=" *Required Field";
			 //data[i].nextElementSibling.style.color = "red";
			 count++;
		  }
		  
		  if(data[3].value.length != 10)
		  {
			  data[3].nextElementSibling.innerHTML=" *Please Enter Correct Contact Number";
			  //data[3].nextElementSibling.style.color = "red";
			  count++;  
		  }
		  if(data[2].value.length < 8)
		  {
			  data[2].nextElementSibling.innerHTML=" *Passsword length should be 8 or greater than 8";
			  //data[2].nextElementSibling.style.color = "red";
			  count++;  
		  }
		 
		  if(!pattern1.test(data[2].value)||!pattern2.test(data[2].value)||!pattern3.test(data[2].value)||!pattern4.test(data[2].value))
		   {
			  data[2].nextElementSibling.innerHTML=" *Password should contain the combination of lower,upper,digit and special character";
			  //data[2].nextElementSibling.style.color = "red";
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
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Add Customer</h2>
          </div>
          <div class="col-md-12">
            <form action="CustomerServlet" onsubmit="return validate();" method="post"  >
            <input type="hidden" name="action" value="add">
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="customer_name" class="text-black">Customer Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control customer_form" id="custName" name="custName"  onblur="clearup(this)">
                    <span class="text-danger font-weight-bold"></span>
                  </div>
                
                  <div class="col-md-6">
                    <label for="customer_email_id" class="text-black">Customer Email ID:<span class="text-danger">*</span></label>
                    <input type="email" class="form-control customer_form" id="custemailid" name="custEmailId" onblur="clearup(this)">
                    <span class="rext-danger font-weight-bold" id="custemailiderr"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="password" class="text-black">Password:<span class="text-danger">*</span></label>
                    <input type="password" class="form-control customer_form" id="custpassword" name="custPassword"  onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id="custpassworderr"></span>
                  </div>
                
                  <div class="col-md-6">
                    <label for="contact_no" class="text-black">Customer Contact No:<span class="text-danger">*</span></label>
                    <input type="number" class="form-control customer_form" id="custcontactno" name="custContactNo"  onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id="custcontactnoerr"></span>
                  </div>
                  
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="address" class="text-black">Address:<span class="text-danger">*</span></label>
                    <textarea cols="30" rows="3" id="custAddress" name="custAddress"  onblur="clearup(this)" class="form-control customer_form" ></textarea>
                    <span class="text-danger font-weight-bold"></span>
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