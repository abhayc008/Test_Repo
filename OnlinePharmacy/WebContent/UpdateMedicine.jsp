<%@page import="com.pharmacy.pojo.Medicine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Medicine</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<script type="text/javascript">
     $(document).ready(function()
     {
    	 $("#update_medicine").validate({
    		 rules:
    			 {
    			    medid:{ required:true},
    			    medname:{ required:true},
    			    medtype:{ required:true},
    			    medbrand:{ required:true},
    			    meddiscription:{required:true},
    			    medqty:{
    			    	required:true,
    			    	digits:true
    			    },
    			    medmfgdate:{required:true},
    			    medexpdate:{required:true},
    			    medprice:{
    			    	required:true,
    			    	rexp: '^[1-9]\d*(\.\d+)?$'
    			    	}		    
    			 },
    	    messages: {
    	    	medname:{
    	    		required:"Enter Medicine Name"
    	    		},
    	    	medbrand:{
    	    		required:"Enter Medicine Brand "
    	    		},
    	    	meddiscription:{
    	    		required:"Enter Medicine Discription"
    	    			},
    	        medqty:{
    	        	required:"Enter Medicine Quantity"
    	        }
    	    	medprice: {
                      required: "Enter Medicine Price",
                      rexp:"Decimal Numbers Only"
                },  
    	    }
    	
    	 });
    	 
     });
</script>
</head>
<body >
<% Medicine medicine = (Medicine)session.getAttribute("med"); %>
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Update Medicine</h2>
          </div>
          <div class="col-md-12">
            <form action="MedicineServlet" method="post" id="update_medicine" enctype="multipart/form-data">
            <input type="hidden" name="action" value="update">
            <div class="p-3 p-lg-5 border">
                
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_id" class="text-black">Existing Medicine ID<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medid" value="<%= medicine.getMedicineId() %>" readonly>
                  </div>
                  <div class="col-md-6">
                    <label for="medicine_name" class="text-black">Medicine Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="medname" name="medname" value="<%= medicine.getMedicineName() %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_type" class="text-black">Medicine Type:<span class="text-danger">*</span></label>
                    <input  type="text"  class="form-control" id="medtype" name ="medtype" value="<%=medicine.getMedicineType() %>" readonly>
                  </div>
                  <div class="col-md-6">
                    <label for="brand" class="text-black">Brand<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medbrand" value="<%= medicine.getMedicineBrand() %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="discription" class="text-black">Medicine Discription:<span class="text-danger">*</span></label>
                    <textarea cols="22" rows="5" name="meddiscription" id="meddiscription" class="form-control"><%=medicine.getMedicineDiscription()%></textarea>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="manufacture_date" class="text-black">Medicine Manufacture Date:<span class="text-danger">*</span></label>
                    <input type="date" class="form-control" name="medmfgdate" id="medmfgdate" value="<%=medicine.getMfgDate()%>">
                  </div>
                  <div class="col-md-6">
                    <label for="expiry_date" class="text-black">Medicine Expiry Date<span class="text-danger">*</span></label>
                    <input type="date" class="form-control" name="medexpdate" id="medexpdate" value="<%=medicine.getExpiryDate() %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_price" class="text-black">Medicine Price:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medprice" value="<%=medicine.getMedicinePrice() %>">
                  </div>
                  <div class="col-md-6">
                    <label for="medicine_quantity" class="text-black">Medicine Quantity<span class="text-danger">*</span></label>
                    <input type="number" class="form-control" id="medqty" name="medqty" value="<%=medicine.getMedicineQty() %>">
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_image" class="text-black">Medicine Image:<span class="text-danger">*</span></label>
                    <input type="file" class="form-control" name="medimage">
                  </div>
                  <div class="col-md-6">
                    <img src="ImageController?medid=<%=medicine.getMedicineId()%>" alt="Image" width="270 px" height="370 px" >
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