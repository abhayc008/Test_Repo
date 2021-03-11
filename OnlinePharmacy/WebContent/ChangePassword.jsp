<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login</title>
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg !== value;
		 }, "Value must not equal arg.");
	 
    	 $("#change_password").validate({
    		 rules:
    			 {
  			        selecttype: { 
  			    	     required:true,
  			    	     valueNotEquals:"---select---"},
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
    			 },
    	    messages: {
	           selecttype: "Please select a type!"
            }
    	 });
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
     });
     
</script>

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Change Password</h2>
          </div>
          <div class="col-md-12">
             <form id="change_password" action="LoginServlet" method="post" class="justify-content-center" >
             <input type="hidden" name="action" value="change">
            <div class="p-3 p-lg-5 border ">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="l_type" class="text-black">Type:<span class="text-danger">*</span></label>
                    <select class="form-control" name ="selecttype">
                           <option selected disabled>---select---</option>
                           <option>Admin</option>
                           <option>User</option>
                    </select>
                    <span class="text-danger font-weight-bold"></span>
                  </div>          
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="l_loginid" class="text-black" >Login Id:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control"id="custemailid" name="loginid">
                    <span class="text-danger font-weight-bold red" id="custemailiderr"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="l_password" class="text-black">Password:<span class="text-danger">*</span></label>
                    <input type="password" class="form-control" id="pass" name="newpassword">
                    <span class="text-danger font-weight-bold"></span>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="c_password" class="text-black">Confirm Password:<span class="text-danger">*</span></label>
                    <input type="password" class="form-control"  name="password">
                    <span class="text-danger font-weight-bold"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-lg-6">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="login">
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