<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Medicine</title>
<link rel="stylesheet" type="text/css" href="site.css">
<script>
    function validate()
    {
    	medicineName = document.getElementById("medname").value;//semi-colon not required
    	medicineType= document.getElementById("medtype").value;
    	medicineBrand = document.getElementById("medbrand").value;
    	medicineDiscription = document.getElementById("meddiscription").value;
    	medicineQty = document.getElementById("medqty").value;
    	medicineMfg = document.getElementById("medmfgdate").value;
    	medicineExp = document.getElementById("medexpdate").value;
    	medicinePrice = document.getElementById("medprice").value;
    	
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
     	       	
      	if(medicineQty == "")
      	{
      	   document.getElementById("medqtyerror").innerHTML = "  * Required Field";
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
    
       	if(isNaN(medicinePrice))
       	{
          
       	   document.getElementById("medpriceerror").innerHTML = " No characters are allowed!!!";
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
    <form id="form" action="MedicineServlet" onsubmit="return validate()" method="post">
     <input type="hidden" name="action" value="add">
    <fieldset>
       <legend style="font-size:30px;font-weight: bold">Add Medicine</legend>
        <table>
            <tr>
                <td>Medicine Name:</td>
                <td><input type="text" name="medname" id="medname" onblur="clearup(this)">
                <b id ="mednameerror"></b>
                </td>
                <!--<td> <input type="text" name="medname" required></td> -->
            </tr>
            <tr>
                <td>Medicine Type: </td>
                <td><select name ="medtype" id="medtype" onblur="clearup(this)">
                           <option selected disabled>--select--</option>
                           <option>Tablet</option>
                           <option>Ointment</option>
                           <option>Inhaler</option>
                           <option>Syrup</option>
                    </select>
                    <b id ="medtypeerror"></b></td>
            </tr>
            <tr>
                <td> Medicine Brand: </td>
                <td><input type="text" name="medbrand" id="medbrand" onblur="clearup(this)">
                <b id ="medbranderror"></b></td>
            </tr>
            <tr>
                <td>Medicine Description:</td>
                <td><textarea cols="22" rows="5" name="meddiscription" id="meddiscription" onblur="clearup(this)"></textarea>
                <b id ="meddiserror"></b></td>
            </tr>
            <tr>
                <td>Medicine Quantity:</td>
                <td><input type="number" name="medqty" id="medqty" onblur="clearup(this)">
                <b id ="medqtyerror"></b></td>
            </tr>
            <tr>
                <td>Medicine Manufacture Date:</td>
                <td><input type="date" name="medmfgdate" id="medmfgdate" onblur="clearup(this)">
                <b id ="medmfgerror"></b></td>
            </tr>
            <tr>
                <td>Medicine Expiry Date:</td>
                <td><input type="date" name="medexpdate" id="medexpdate" onblur="clearup(this)">
                <b id ="medexperror"></b></td>
            </tr>
            <tr>
                <td>Medicine Price </td>
                <td><input type="text" name="medprice" id="medprice" onblur="clearup(this)">
                <b id ="medpriceerror"></b></td>
            </tr>
            <tr>
                <td> <input type="submit" value="Add"></td>
                <td><input type="reset"></td>
            </tr>
        </table>
    </fieldset>      
    </form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>