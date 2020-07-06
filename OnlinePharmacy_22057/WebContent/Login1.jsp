<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
<body>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Login 1</h2>
          </div>
          <div class="col-md-12">
            <form id="form" class="justify-content-center"  >
            
            <div class="p-3 p-lg-5 border ">
                <div class="form-group row">
                  <div class="col-md-4">
                    <label for="l_type" class="text-black">Type:<span class="text-danger">*</span></label>
                    <select class="form-control" name ="selecttype">
                           <option selected disabled>--select--</option>
                           <option>Admin</option>
                           <option>User</option>
                    </select>
                    <b id =""></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-4">
                    <label for="l_loginid" class="text-black">Login Id:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="loginid"><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-4">
                    <label for="l_password" class="text-black">Password:<span class="text-danger">*</span></label>
                    <input type="number" class="form-control" id="password" name="password"><b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-2">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="login">
                  </div>
                  <div class="col-lg-2">
                    <input type="reset" class="btn btn-primary btn-lg btn-block" value="Reset">
                  </div>
                </div>
               </div>
               <div class="form-group row">
                  <div class="col-lg-2">
                      <a>New User Click <a href="AddCustomer.html">here</a>
                  </div>
                  <div class="col-lg-2">
                     <a href="ChangePassword.html">Forgot password ?</a>
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