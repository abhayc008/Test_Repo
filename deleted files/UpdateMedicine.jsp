<%@page import="com.pharmacy.dao.MedicineDaoImpl"%>
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
    			    medbrand:{required:true},
    			    meddiscription:{required:true},
    			    medqty:{required:true},
    			    medmfgdate:{required:true},
    			    medexpdate:{required:true},
    			    medprice:{required:true}		    
    			 }
    			 
    	 })
    	 
     })
</script>
</head>
<body >
<% Medicine medicine = (Medicine)session.getAttribute("med"); %>
<jsp:include page="Header.jsp"></jsp:include>
<center>
    <form action="MedicineServlet" method="post" id="update_medicine">
    <input type="hidden" name="action" value="update">
    <fieldset>
       <legend style="font-size:30px;font-weight: bold">Update Medicine</legend>
        <table>
            <tr>
                <td>Existing Medicine Id:</td>
                <td><input type="number" name="medid" value="<%= medicine.getMedicineId() %>" readonly></td>
            </tr>
            <tr>
                <td>Medicine Name:</td>
                <td><input type="text" name="medname" value="<%= medicine.getMedicineName() %>"></td>
            </tr>
            <tr>
                <td>Medicine Type: </td>
                <td><input type="text" name ="medtype" value="<%=medicine.getMedicineType() %>" readonly></td>
                
            </tr>
            <tr>
                <td> Medicine Brand: </td>
                <td><input type="text" name="medbrand" value="<%= medicine.getMedicineBrand() %>"></td>
            </tr>
            <tr>
                <td>Medicine Description:</td>
                <td><textarea cols="22" rows="5" name="meddiscription"> value="<%=medicine.getMedicineDiscription()%>"</textarea></td>
            </tr>
            <tr>
                <td>Medicine Quantity:</td>
                <td><input type="number" name="medqty" value="<%=medicine.getMedicineQty() %>"></td>
            </tr>
            <tr>
                <td>Medicine Manufacture Date:</td>
                <td><input type="date" name="medmfgdate" value="<%=medicine.getMfgDate()%>"></td>
             </tr>     
            <tr>
                <td>Medicine Expiry Date:</td>
                <td><input type="date" name="medexpdate" value="<%=medicine.getExpiryDate() %>"></td>
            </tr>
            <tr>
                <td>Medicine Price </td>
                <td><input type="text" name="medprice" value="<%=medicine.getMedicinePrice() %>"></td>
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