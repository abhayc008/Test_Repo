<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Medicines</title>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include>
   <form action="OrderServlet" method="post">
   <input type="hidden" name="action" value="placeorder">
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
    <div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">Medicines</strong>
          </div>
        </div>
      </div>
     </div>
     <br>
     <br>
     
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
                 <a href="MedicineServlet?action=details&medId=<%= med.getMedicineId()%>"> <img src="ImageController?medid=<%=med.getMedicineId() %>" alt="Image" 
                 width="270 px" height="370 px"></a>
                 <h3 class="text-dark"><a href="MedicineServlet?action=details&medId=<%= med.getMedicineId()%>"><%=med.getMedicineName() %></a></h3>
                 <h2  class="h5 text-black"><%= med.getMedicineType() %></h2>
                 <p class="price">Rs.<%= med.getMedicinePrice() %></p>
                   <% if(admin != null && user == null) { %>
                       <a href="MedicineServlet?action=update&medId=<%= med.getMedicineId() %>">Update</a>
                       <a href="MedicineServlet?action=delete&medId=<%= med.getMedicineId() %>">Delete</a>
                   <% } %>
                   <% if(admin == null && user != null) 
                        {
                	       if(med.getMedicineQty()<=0)
                	       {
                	%>
                        <a href="CartServlet?action=addtocart&medId=<%= med.getMedicineId() %>" onclick="return false;"><del>Add to cart</del>
                        <br><b style="color:red">Out of Stock</b></a>
                   <% } else { %>
                        <a href="CartServlet?action=addtocart&medId=<%= med.getMedicineId() %>">Add to cart</a>
                   <% } %>
                   <% } %>
             </div>
             <% } %>
        </div>
     </div>
   </div>
 </form>
  <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
