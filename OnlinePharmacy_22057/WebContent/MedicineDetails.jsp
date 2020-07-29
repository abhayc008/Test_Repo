<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medicine Details</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>  
    <c:if test="${med != null}">
    <div class="bg-light py-3">
       <div>
          <div class="row">
             <div class="col-md-12 mb-0">
               <a href="index.jsp">Home</a><span class="mx-2 mb-0"></span>
               <strong class="text-black">Medicine Details</strong>
             </div>
          </div>
       </div>
    </div>
    <br>
    <br>
    <div class="site-section">
    <div class="container">
        <div class="row mb-5">
             <form class="col-md-12" method="post">             
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr>
                       <th>Medicine name</th>
                       <td>
                          <h2 class="h5 text-black">${med.medicineName}</h2>           
                       </td>
                     </tr>
                     <tr>
                       <th>Medicine Type </th>
                       <td>
                          <h2 class="h5 text-black">${med.medicineType}</h2>
                       </td>
                     </tr>
                     <tr>
                        <th>Medicine Brand</th>
                        <td>
                           <h2 class="h5 text-black">${med.medicineBrand}</h2>
                        </td>
                     </tr>
                     
                     <tr>
                        <th>Discription</th>
                        <td>
                           <h2 class="h5 text-black">${med.medicineDiscription}</h2>
                        </td>
                     </tr>
                     
                     <tr>
                        <th>Medicine Quantity</th>
                        <td>
                           <h2 class="h5 text-black">${med.medicineQty}</h2>
                        </td>
                     </tr>
                  
                     <tr>
                        <th>Manufacture Date</th>
                        <td>
                           <h2 class="h5 text-black">${med.mfgDate}</h2>
                        </td>
                     </tr>
                     <tr>
                        <th>Expiry Date</th>
                        <td>
                           <h2 class="h5 text-black">${med.expiryDate}</h2>
                        </td>
                     </tr>
                   
                     <tr>
                        <th>Price</th>
                        <td>
                           <h2 class="h5 text-black">${med.medicinePrice}</h2>
                        </td>
                     </tr>
                     <tr>
                        <th>Image</th>
                        <td>
                           <h2 class="h5 text-black" > <img src="${med.medicineImage}" alt="Image" width="70 px" height="100 px"></a></h2>
                        </td>
                     </tr>
                     <tr>
                        <c:if test="${admin != null && user == null }">
                           <td><a href="MedicineServlet?action=delete&medId=${med.medicineId}"> Delete</a></td>
                           <td><a href="MedicineServlet?action=update&medId=${med.medicineId}"> Update</a></td>
                        </c:if>
                        <c:if test="${admin == null && user != null }">
                           <c:choose>
                              <c:when test="${med.medicineQty <= 0}">
                                <td><a href="CartServlet?action=addtocart&medId=${med.medicineId}" onclick="return false;"><del>Add to Cart</del>
                                <br><b style="color:red">Out of Stock</b></a></td>    
                               </c:when>
                               <c:otherwise>
                                  <td><a href="CartServlet?action=addtocart&medId=${med.medicineId}">Add to Cart</a>
                               </c:otherwise>
                           </c:choose>
                        </c:if>
                     </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
                </c:if>
                <c:if test="${med == null}">
                   <h2 class="h5 text-black">Something happen wrong!!!</h2>
                </c:if>
             </div>
            </form>
        </div>
     </div>
   </div>
     <jsp:include page="Footer.jsp"></jsp:include>  
</body>
</html>