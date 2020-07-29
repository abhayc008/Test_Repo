<%@page import="com.pharmacy.pojo.Feedback"%>
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
   List<Feedback> feedbackList = (List<Feedback>)session.getAttribute("fedlist");
   String status=(String)request.getAttribute("status");
if(status != null)
{
	   out.print("<b style='color:red'>Your Feedback has "+status+" !!!</b>");   
}
%>
<jsp:include page="Header.jsp"></jsp:include>
<table border="1px">
   <caption>Feedbacks</caption>
      <tr>           
         <th>Feedback Id</th>
         <th>Customer Name</th>
         <th>Medicine Name</th>
         <th>Medicine Rating</th>
         <th>Service Rating</th>
         <th>Email</th>
         <th>Feedback </th>
         <th>Date</th>
         <th>Action</th>   
      </tr>
      <% 
         for(Feedback fed: feedbackList)  
         {
      %>
        <tr>
           <td><%= fed.getFeedbackId() %></td>
           <td><%= fed.getCustomerName()%></td>
           <td><%= fed.getMedicineName() %></td>
           <td><%= fed.getRateMedicine() %></td>
           <td><%= fed.getRateUs() %></td>
           <td><%= fed.getCustomerEmailId() %></td>
           <td><%= fed.getSuggestion()%></td>
           <td><%= fed.getFeedbackDate() %></td>
           <td><a href="">Reply</a></td>
        </tr>
        <% } %>
</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</body>
</html>

<!--  -->