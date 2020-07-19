<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all Order</title>
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
<jsp:include page="Header.jsp"></jsp:include>
  
<div class="site-section">
      <div class="container">
        <div class="row">
          <div class="title-section text-center col-12">
            <h2 class="text-uppercase">Medicines</h2>
          </div>
        </div>
 <div class="row">
     <% for(Medicine med: medicineList)  {%>
     
          <div class="col-sm-6 col-lg-4 text-center item mb-4">
            <span class="tag">Sale</span>
            <a href="shop-single.html"> <img src="" alt="Image"></a>
            <p class="price"><%= med.getMedicineName() %></p>
            <h3 class="text-dark"><a href=""><%=med.getMedicinePrice() %></a></h3>
            <p class="price"><%= med.getMedicineType() %></p>
            <a href="CartServlet?action=addtocart&medid=<%= med.getMedicineId() %>">Add to cart</a>
          </div>
          
      <% } %>
        </div>
     </div>
  </div>
  
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
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>