<%@page import="com.pharmacy.pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback List</title>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include>
   <form>
    <div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">Feedbacks</strong>
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
                       <th>Feedback Id</th>
                       <th>Medicine Rating</th>
                       <th>Service Rating </th>
                       <th>Customer Email Id</th>
                       <th>Feedback </th>
                       <th>Feedback Date</th>
                     </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="fed" items="${fedlist}" >
                       <tr>
                         <td>
                           <h2 class="h5 text-black">${fed.feedbackId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${fed.customerName}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${fed.rateUs}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${fed.customerEmailId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${fed.suggestion}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${fed.feedbackDate}</h2>
                         </td>
                       </tr>
                        
                    </c:forEach>
                  </tbody>
                </table>
                </div>
             </div>
        </div>
     </div>
     </form>
        <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
