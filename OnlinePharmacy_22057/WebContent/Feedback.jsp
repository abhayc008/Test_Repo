<%@page import="com.pharmacy.dao.CustomerDaoImpl"%>
<%@page import="com.pharmacy.pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback Form</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  
  <!--  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">-->
  <link rel="stylesheet" href="fonts/icomoon/style.css">

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/magnific-popup.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">
<!-- <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link> -->


  <link rel="stylesheet" href="css/aos.css">

  <link rel="stylesheet" href="css/style.css">
  <script src="jquery-3.5.1.js"></script>
   <!-- <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
   <script src="jquery.validate.min.js"></script>
 <style>
    .rating-header {
    margin-top: -10px;
    margin-bottom: 10px;
}
    .btn-warning {
    color: #212529;
    background-color: #51EAEA;
    border-color: #51EAEA;
}

 .btn-warning:hover {
    color: #212529;
    background-color: #51EAEA;
    border-color: #51EAEA;
}
 </style>
 <script>
	$(document).ready(function($){
	    
		$(".btnrating").on('click',(function(e) {
		
		var previous_value = $("#selected_rating").val();
		
		var selected_value = $(this).attr("data-attr");
		$("#selected_rating").val(selected_value);
		
		$(".selected-rating").empty();
		$(".selected-rating").html(selected_value);
		
		for (i = 1; i <= selected_value; ++i) {
		$("#rating-star-"+i).toggleClass('btn-warning');
		$("#rating-star-"+i).toggleClass('btn-default');
		}
		
		for (ix = 1; ix <= previous_value; ++ix) {
		$("#rating-star-"+ix).toggleClass('btn-warning');
		$("#rating-star-"+ix).toggleClass('btn-default');
		}
		
		}));
		
			
	});

 </script>  
  <script type="text/javascript">
     $(document).ready(function()
     {
    	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
   		  return arg !== value;
   		 }, "Value must not equal arg.");
    	 	 
   	 
    	 $("#feedback_form").validate({
    		 rules:
    			 {
    			    custname:{ required:true},
    			    custemailid:{required:true,
    			    	email:true},
    			    medname:{
    			    	required:true},
    			    custcontactno:{
	    	            required:true,
	    	            maxlength:10,
	    	            minlength:10},
	    	        selected_rating:{
	    	        	required:true,
			    	    number:true},
			    	rateus:{
		    	         required:true,
				    	 valueNotEquals:"---select---"},
	    	        suggestion:{
	    	        	required:true,
	    	        }
    			 },
    		 messages: {
    			     ratemedicine: "Please select any number ",
    			     rateus: "Please select any number "
       	           }
    	 });
    	 
     });
</script>
</head>
<body>
<%
   String user=(String)session.getAttribute("user");
   Customer customer;
   CustomerDaoImpl cdao = new CustomerDaoImpl();
   customer = cdao.searchCustomerByEmailId(user); 
%>
  <jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Feedback Form</h2>
          </div>
          <div class="col-md-12">
            <form id="feedback_form" action="FeedbackServlet" method="post" >
            <input type="hidden" name="action" value="add">
            
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="customer_name" class="text-black">Customer Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control abc" id="custName" name="custname" value="<%=customer.getCustomerName()%>" ><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="customer_email_id" class="text-black">Customer Email Id:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control abc" id="custemailid" name="custemailid" value="<%=user %>" readonly><b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="suggestion" class="text-black">Suggestion:<span class="text-danger">*</span></label>
                    <textarea cols="30" rows="7" id="suggestion" name="suggestion"   class="form-control " ></textarea><b></b>
                  </div>
                </div>
                <div class="form-group row">
                  
                  <div class="col-md-12">
                    
                    
                    <div class="form-group" id="rating-ability-wrapper">
	                    <label class="control-label" for="rating">
	                    <span class="field-label-header">Rate our service:<span class="text-danger">*</span></label></span><br>
	                    <span class="field-label-info"></span>
	                    <input type="hidden" id="selected_rating" name="selected_rating" value="" required="required">
	                    </label>
	                    <h2 class="bold rating-header" style="">
	                        <span class="selected-rating">0</span><small> / 5</small>
	                     </h2>
	                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="1" id="rating-star-1">
	                         <i class="fa fa-star" aria-hidden="true"></i>
	                    </button>
	                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="2" id="rating-star-2">
	                       <i class="fa fa-star" aria-hidden="true"></i>
	                    </button>
	                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="3" id="rating-star-3">
	                         <i class="fa fa-star" aria-hidden="true"></i>
	                    </button>
	                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="4" id="rating-star-4">
	                         <i class="fa fa-star" aria-hidden="true"></i>
	                    </button>
	                    <button type="button" class="btnrating btn btn-default btn-lg" data-attr="5" id="rating-star-5">
	                        <i class="fa fa-star" aria-hidden="true"></i>
	                    </button>
	                    </div>
                    
                    <b></b>
                  </div>
                </div>
                
                <div class="form-group row">
                  <div class="col-lg-12">
                    <input type="submit" class="btn btn-primary btn-lg btn-block" value="Submit">
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