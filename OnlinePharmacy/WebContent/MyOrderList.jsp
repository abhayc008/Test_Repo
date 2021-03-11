<%@page import="com.pharmacy.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
<style type="text/css">
  #b,th,tr
  {
     color:#
  }
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form >
    <div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">My Orders</strong>
          </div>
        </div>
      </div>
     </div>
     <br>
     <br>

<c:if test="${myorders != null && myorders.size() > 0}">
     
     <div class="site-section">
     <div class="container">
        <div class="row mb-5">
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr id="b">
                       <th>Order Id</th>
                       <th>Customer Email ID</th>
                       <th>Order Status</th>
                       <th>Total Bill</th>
                       <th>Order Date</th>
                     </tr>
                  </thead>
                  <tbody>
                   <c:forEach var="od" items="${myorders}">
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
                                <h2 class="h5 text-black">${od.orderDate }</h2>
                           </td>
                       </tr>
                     </c:forEach>
                  </tbody>
                </table>
                </div>
             </div>
        </div>
     </div>
        </c:if>
     <c:if test="${myorders == null || myorders.size() == 0 }">
        <h2 class="h5 text-black">No order placed !!!</h2>
        
     </c:if>
    
     </form>
     
     <jsp:include page="Footer.jsp"></jsp:include>  
 </body>
</html>