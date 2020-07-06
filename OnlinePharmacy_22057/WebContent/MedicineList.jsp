<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all medicine</title>
</head>
<body>
<%
   List<Medicine> medicineList = (List<Medicine>)session.getAttribute("medList");
   String status=(String)request.getAttribute("status");
   if(status != null)
   {
	   out.print("<b style='color:red'>Your Medicine has "+status+" !!!</b>");   
   }
   String admin = (String)session.getAttribute("admin");
   String user = (String)session.getAttribute("user");
%>
<table border="1px">
   <caption>Medicines</caption>
      <tr>           
         <th>Medicine Id</th>
         <th>Medicine Name</th>
         <th>Medicine Type</th>
         <th>Medicine Brand</th>
         <th>Medicine Description</th>
         <th>Medicine Quantity</th>
         <th>Medicine Manufacture Date</th>
         <th>Medicine Expiry Date</th>
         <th>Medicine Price</th>
         <% if(admin != null && user == null) {%>
         <th colspan=2>Action</th>
         <% } %>
         
         <% if(admin == null && user != null) { %>
         <th>Action</th>
         <% } %>
         
      </tr>
      <% 
         for(Medicine med: medicineList)  
         {
      %>
        <tr>
           <td><%= med.getMedicineId() %></td>
           <td><%= med.getMedicineName() %></td>
           <td><%= med.getMedicineType() %></td>
           <td><%= med.getMedicineBrand() %></td>
           <td><%= med.getMedicineDiscription() %></td>
           <td><%= med.getMedicineQty() %></td>
           <td><%= med.getMfgDate()%></td>
           <td><%= med.getExpiryDate()%></td>
           <td><%= med.getMedicinePrice() %></td>
           <% if(admin != null && user == null) {%>
           <td><a href="MedicineServlet?action=delete&medId=<%= med.getMedicineId() %>">Delete</a></td>
           <td><a href="MedicineServlet?action=update&medId=<%= med.getMedicineId() %>">Update</a></td>
           <% } %>
           <% if(admin == null && user != null) { %>
           <td><a href="CartServlet?action=addtocart&medId=<%= med.getMedicineId() %>">Add To Cart</a></td>
           <% } %>
        </tr>
      <%
         }
      %>
</table>
</body>
</html>