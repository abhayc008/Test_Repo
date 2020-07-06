<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include>
   <form action="OrderServlet" method="post">
   <input type="hidden" name="action" value="placeorder">
   <%
      List<Cart> lstCart = (List<Cart>)session.getAttribute("list_Cart");
    %>
    <div class="bg-light py-3">
      <div>
        <div class= "row">
          <div class="col-md-12 mb-0">
            <a href="index.html">Home</a><span class="mx-2 mb-0"></span>
            <strong class="text-black">Medicines</strong>
          </div>
        </div>
      </div>
     </div>
     <br>
     <br>
     <%
        String status = (String)request.getAttribute("status");
        if(status != null)
        {
        	out.print("<h3 id='a'>Your item has "+status+" !!!</h3>");
        }
     %>
     <div>
        <div class="row mb-5">
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr id="b">
                       <th>Cart Id</th>
                       <th>Medicine Id</th>
                       <th>Medicine Name</th>
                       <th>Medicine Quantity</th>
                       <th>Medicine Price</th>
                       <th>Action</th>
                     </tr>
                  </thead>
                  <tbody>
                    <% for(Cart cart:lstCart){ %>
                       <tr>
                          <td>
                             <h2 class="h5 text-black"><%= cart.getCartId() %></h2>
                          </td>
                          <td>
                             <h2 class="h5 text-black"><%= cart.getMedicineId() %></h2>
                          </td>
                          <td>
                             <h2 class="h5 text-black"><%= cart.getMedicineName() %></h2>
                          </td>
                           <td>
                               <input type="text" class="form-control" name="medprice" value="<%= cart.getMedicinePrice() %>">
                           </td>
                            <td>
                                <input type="number" class="form-control" name="medqty" value="<%= cart.getMedicineQty()%>">
                           </td>
                            <td>
                                <a href="CartServlet?action=delete&cartid=<%=cart.getCartId()%>" class="h5 text-black">delete</a>
                           </td>
                       </tr>
                     <% } %>
                  </tbody>
                </table>
                <div class="container">
                   <div class="form-group row">
                      <input type="submit" class="btn btn-primary btn-lg btn-block" value="Place Order">
                   </div>
                </div>
             </div>
        </div>
     </div>
     </form>
        <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>