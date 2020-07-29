<%@page import="com.pharmacy.pojo.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include>
   
    <div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">Contact List</strong>
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
                       <th>Contact Id</th>
                       <th>First Name</th>
                       <th>Last Name </th>
                       <th>Email Id</th>
                       <th>Subject </th>
                       <th>Message</th>
                     </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="con" items="${contactlist}" >
                       <tr>
                         <td>
                           <h2 class="h5 text-black">${con.contactId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${con.firstName}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${con.lastName}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${con.emailId}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${con.subject}</h2>
                         </td>
                         <td>
                           <h2 class="h5 text-black">${con.message}</h2>
                         </td>
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
