<%@page import="com.pharmacy.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

<jsp:include page="Header.jsp"></jsp:include>
<%
   String status=(String)request.getAttribute("status");
   if(status != null)
   {
	   out.print("<b style='color:red'> Your Order has "+status+" !!!</b>");   
   }
   String admin = (String)session.getAttribute("admin");
%>
<div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">Orders</strong>
          </div>
        </div>
      </div>
     </div>
     <br>
     <br>
     <div class="site-section">
     <div class="container">
        <div class="row mb-5">
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr id="b">
                       <th>Order Id</th>
                       <th>Customer Email Id</th>
                       <th>Order Status</th>
                       <th>Total Bill</th>
                       <th>Order Date </th>
                       <th colspan="1">Action</th>
                     </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="od" items="${odlist}" >
                       <tr>
                         <td>
                           <h2 class="h5 text-black">${od.orderId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${od.customerEmailId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${od.orderStatus}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${od.totalBill}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${od.orderDate}</h2>
                         </td>
                           <td><a href="OrderServlet?action=cancel&odid=${od.orderId}">Cancel Order</a></td>
                       </tr>
                    </c:forEach>
                  </tbody>
                </table>
                </div>
             </div>
        </div>
      </div>
 
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>