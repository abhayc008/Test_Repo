<%@page import="com.pharmacy.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Place Order</title>
<style type="text/css">
  #b,th,tr
  {
     color:#33F9FF
  }
</style>
</head>
<body>
    <c:if test="${placeorder != null}">
    <div class="bg-light py-3">
       <div>
          <div class="row">
             <div class="col-md-12 mb-0">
               <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
               <strong class="text-black">Order Receipt</strong>
             </div>
          </div>
       </div>
    </div>
    <br>
    <br>
    
    <div>
        <div class="row mb-5">
             <form class="col-md-12" method="post">             
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr>
                       <th>Order Id</th>
                       <td>
                          <h2 class="h5 text-black">${placeorder.orderId}</h2>           
                       </td>
                     </tr>
                     <tr>
                       <th>Customer Email Id</th>
                       <td>
                          <h2 class="h5 text-black">${placeorder.customerEmailId}</h2>
                       </td>
                     </tr>
                     <tr>
                        <th>Order Status</th>
                        <td>
                           <h2 class="h5 text-black">${placeorder.orderStatus}</h2>
                        </td>
                     </tr>
                     <tr>
                        <th>Total Bill</th>
                        <td>
                           <h2 class="h5 text-black">${placeorder.totalBill}</h2>
                        </td>
                     </tr>
                     
                     <tr>
                        <th>Order Date</th>
                        <td>
                           <h2 class="h5 text-black">${placeorder.orderDate}</h2>
                        </td>
                     </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
                </c:if>
                <c:if test="${placeorder == null}">
                   <h2 class="h5 text-black">No order placed</h2>
                </c:if>
             </div>
            </form>
        </div>
     </div>
     <jsp:include page="Footer.jsp"></jsp:include>  
 </body>
</html>