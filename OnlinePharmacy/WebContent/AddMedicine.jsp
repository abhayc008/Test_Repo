<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Medicine</title>  
<script>
    function validate()
    {
    	medicineName = document.getElementById("medname").value;//semi-colon not required
    	medicineType= document.getElementById("medtype").value;
    	medicineBrand = document.getElementById("medbrand").value;
    	medicineDiscription = document.getElementById("meddiscription").value;
    	medicineMfg = document.getElementById("medmfgdate").value;
    	medicineExp = document.getElementById("medexpdate").value;
    	medicinePrice = document.getElementById("medprice").value;
    	medicineQty = document.getElementById("medqty").value;
    	
    	if(medicineName == "")
    	{
    	   document.getElementById("mednameerror").innerHTML = "  * Required Field";
    	   return false;
    	}
    	
    	if(medicineType == "--select--")
    	{
    	   document.getElementById("medtypeerror").innerHTML = "  * Please Select something";
    	   return false;
    	}        
        
       	if(medicineBrand == "")
    	{
    	   document.getElementById("medbranderror").innerHTML = "  * Required Field";
    	   return false;
    	}
          	
     	if(medicineDiscription == "")
     	{
     	   document.getElementById("meddiserror").innerHTML = "  * Required Field";
     	   return false;
     	}   	
     	 
       	if(medicineMfg == "")
       	{
       	   document.getElementById("medmfgerror").innerHTML = "  * Required Field";
       	   return false;
       	}
      	
      	if(medicineExp == "")
      	{
      	   document.getElementById("medexperror").innerHTML = "  * Required Field";
      	   return false;
      	}
        
      	if(new Date(medicineMfg) > new Date(medicineExp))
      	{
      	   document.getElementById("medexperror").innerHTML = "  * Incorrect Exipry Date";
      	   return false;
      	}
      	
       	if(medicinePrice=="")
       	{
          
       	   document.getElementById("medpriceerror").innerHTML = " * Required Field";
       	   return false;
       	}
       	if(isNaN(medicinePrice))
       	{
        	 document.getElementById("medpriceerror").innerHTML = " No characters are allowed!!!";
        	 return false;
       	}
       	
      	if(medicineQty == "")
      	{
      	   document.getElementById("medqtyerror").innerHTML = "  * Required Field";
      	   return false;
      	}
      	if(medimage == "")
      	{
      	   document.getElementById("medimageerror").innerHTML = "  * Required Field";
      	   return false;
      	}
    	return true;
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
<body >
<jsp:include page="Header.jsp"></jsp:include>
 <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="h3 mb-5 text-black">Add Medicine</h2>
          </div>
          <div class="col-md-12">
            <form id="form"action="MedicineServlet" onsubmit="return validate()" method="post" enctype="multipart/form-data" >
            <input type="hidden" name="action" value="add">
            <div class="p-3 p-lg-5 border">
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="medicine_name" class="text-black">Medicine Name:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medname" id="medname" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="mednameerror"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_type" class="text-black">Medicine Type:<span class="text-danger">*</span></label>
                    <select class="form-control" name ="medtype" id="medtype" onblur="clearup(this)">
                           <option selected disabled>--select--</option>
                           <option>Tablet</option>
                           <option>Ointment</option>
                           <option>Inhaler</option>
                           <option>Syrup</option>
                    </select>
                    <span class="text-danger font-weight-bold" id ="medtypeerror"></span>
                  </div>
                  <div class="col-md-6">
                    <label for="brand" class="text-black">Brand<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medbrand" id="medbrand" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medbranderror"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-12">
                    <label for="discription" class="text-black">Medicine Discription:<span class="text-danger">*</span></label>
                    <textarea cols="22" rows="5" name="meddiscription" id="meddiscription" onblur="clearup(this)" class="form-control"></textarea>
                    <span class="text-danger font-weight-bold" id ="meddiserror"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="manufacture_date" class="text-black">Medicine Manufacture Date:<span class="text-danger">*</span></label>
                    <input type="date" class="form-control" name="medmfgdate" id="medmfgdate" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medmfgerror"></span>
                  </div>
                  <div class="col-md-6">
                    <label for="expiry_date" class="text-black">Medicine Expiry Date<span class="text-danger">*</span></label>
                    <input type="date" class="form-control" name="medexpdate" id="medexpdate" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medexperror"></span>
                  </div>
                </div>
                <div class="form-group row">
                  <div class="col-md-6">
                    <label for="medicine_price" class="text-black">Medicine Price:<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" name="medprice" id="medprice" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medpriceerror"></span>
                  </div>
                  <div class="col-md-6">
                    <label for="medicine_quantity" class="text-black">Medicine Quantity<span class="text-danger">*</span></label>
                    <input type="number" class="form-control" id="medqty" name="medqty" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medqtyerror"></span>
                  </div>
                  
                  <div class="col-md-6">
                    <label for="medicine_image" class="text-black">Medicine Image<span class="text-danger">*</span></label>
                    <input type="file" class="form-control" id="medimage" name="medimage" onblur="clearup(this)">
                    <span class="text-danger font-weight-bold" id ="medimageerror"></span>
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