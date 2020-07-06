<%@page import="com.pharmacy.pojo.Customer"%>
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
<%
   List<Customer> custList = (List<Customer>)session.getAttribute("custList");
   String custStatus=(String)request.getAttribute("status");
   if(custStatus != null)
   {
	   out.print("<b style='color:red'>Customer has "+custStatus+" !!!</b>");   
   }
%>
<table border="1px">
   <caption>Customers</caption>
   <tr>
      <th>Customer Id</th>
      <th>Customer Name</th>
      <th>Customer Email Id</th>
      <th>Customer Password</th>
      <th>Customer Contact No</th>
      <th>Customer Address</th>
      <th colspan=2>Action</th>
   </tr>
   <tr>
    <%
      for(Customer cust:custList)
      {
    %>
      <tr>
         <td><%= cust.getCustomerId() %></td>
         <td><%= cust.getCustomerName() %></td>
         <td><%= cust.getCustomerEmailId() %></td>
         <td><%= cust.getCustomerPassword() %></td>
         <td><%= cust.getCustomerContactNo() %></td>
         <td><%= cust.getCustomerAddress() %></td>
         <td><a href="CustomerServlet?action=delete&custId=<%=cust.getCustomerId()%>">Delete</a></td>
         <td><a href="CustomerServlet?action=update&custId=<%=cust.getCustomerId()%>">Update</a></td>
      </tr>
   <%
      }
   %>
</table>
</body>
</html>