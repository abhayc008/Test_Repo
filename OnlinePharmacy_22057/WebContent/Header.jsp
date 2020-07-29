<%@page import="com.pharmacy.dao.CartDao"%>
<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.pharmacy.dao.CartDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Pharma &mdash;A Medicine Company</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet"> -->
  <link rel="stylesheet" href="fonts/icomoon/style.css">
  
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/magnific-popup.css">
  <link rel="stylesheet" href="css/jquery-ui.css">
  <link rel="stylesheet" href="css/owl.carousel.min.css">
  <link rel="stylesheet" href="css/owl.theme.default.min.css">


  <link rel="stylesheet" href="css/aos.css">

  <link rel="stylesheet" href="css/style.css">

  <link rel="stylesheet" type="text/css" href="site.css">

  <link rel="stylesheet" href="fonts/icomoon/style.css">

  <script src="jquery-3.5.1.js"></script>
  <script src="jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function()
{
	setNavigation();
	
	function setNavigation() {
	    var path = window.location.pathname;
	    path = path.replace(/\/$/, "");
	    path = decodeURIComponent(path);

	    $(".common_class a").each(function () {
	        var href = $(this).attr('href');
	        
	        var arr = href.split('?');
	        href = arr[0];
	        
	        if(href == 'MedicineServlet' )
	        	href = 'MedicineList.jsp';
	        
	        if(href == 'CustomerServlet')
	        	href = 'CustomerList.jsp';
	        
	        if(href == 'FeedbackServlet')
	        	href = 'FeedbackList.jsp';
	        
	        if(href == 'OrderServlet')
	        	href = 'OrderList.jsp';
	        
	        if((href == 'CustomerServlet' ||  href == 'FeedbackServlet')&& arr.length == 1 )
	        	href = 'index.jsp';
	        
	        if(href == 'OrderServlet' && arr.length >1)
	        	href = 'MyOrderList.jsp';
	        
	        
	        if (path.indexOf(href) != -1) {
	            $(this).closest('li').addClass('active');
	        }
	    });
	}
   
   
});
</script>
</head>

<body>

   <%
      String admin = (String)session.getAttribute("admin");
      String user = (String)session.getAttribute("user");

      CartDaoImpl cartObj =new CartDaoImpl();
      List<Cart> cartList= cartObj.showCart(user);
      int length = cartList.size();
   %>

  <div class="site-wrap">

    <div class="site-navbar py-2">

      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="MedicineServlet">
            <input type="text" class="form-control" name="medname" placeholder="Search keyword and hit enter...">
            <input type="hidden" name="action" value="search">
          </form>
        </div>
      </div>

      <div class="container1" style="background-color:#51EAEA">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="index.jsp" class="js-logo-clone">Pharma</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
            
              <% if(user==null && admin == null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="common_class"><a href="index.jsp">Home</a></li>
                <li  class="common_class"><a href="MedicineServlet">Store</a></li>
                <li class="common_class"><a href="AddCustomer.jsp" >Sign Up</a></li>
                <li class="common_class"><a href="Login.jsp" >Sign In</a></li>
                <li  class="common_class"><a href="about.jsp">About</a></li>
                <li class="common_class"><a href="Contact.jsp">Contact</a></li>
              </ul>
              
              <% } %>
              
              <% if(user == null && admin != null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="common_class"><a href="index.jsp">Home</a></li>
                <li  class="common_class"><a href="MedicineServlet">Store</a></li>
                <li  class="common_class"><a href="AddMedicine.jsp" >Add Medicine</a></li>
                <li  class="common_class"><a href="CustomerServlet">Customer List</a></li>
                <li  class="common_class"><a href="FeedbackServlet">Feedback List</a></li>
                <li  class="common_class"><a href="OrderServlet" >Order List</a></li>
                <li  class="common_class"><a href="about.jsp" >About</a></li>
                <li class="common_class"><a href="ContactServlet">Contact List</a></li>
                <li><a href="LoginServlet">Log Out</a></li>
              </ul>
              
              <% } %>
              
              <% if(user != null && admin == null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class=" common_class"><a href="index.jsp">Home</a></li>
                <li  class="common_class"><a href="MedicineServlet" class="common_class">Store</a></li>
                <li  class="common_class"><a href="CustomerServlet?action=update&custemailid=<%=user%>" class="common_class">Edit Profile</a></li>
                <li  class="common_class"><a href="FeedbackServlet?action=add&custemailid=<%=user%>" class="common_class">Give Feedback </a></li>
                <li  class="common_class"><a href="OrderServlet?action=myorders&custemailid=<%=user%>" class="common_class">My Orders</a></li>
                <li  class="common_class"><a href="about.jsp" class="common_class">About</a></li>
                <li class="common_class"> <a href="Contact.jsp">Contact</a></li>
                <li><a href="LoginServlet">Log Out</a></li>
              </ul>
              
              <% } %>
              
              <% if(user != null && admin != null){ %>
              
                 <ul>
                    <li><a href="LoginServlet">Log Out</a></li>
                 </ul>
                 
              <% } %>
            </nav>
          </div>
          <div class="icons">
            <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>
            
            <% if(user != null && admin == null){ %>
            <a href="CartServlet" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number"><%= length %></span>
            </a>
            
            <% } %>
            <a href="#" class="site-menu-toggle js-menu-toggle ml-3 d-inline-block d-lg-none"><span
                class="icon-menu"></span></a>
          </div>
        </div>
     </div>
    </div>
  </div>
</body>


                <!--  <li class="has-children">
                  <a href="#">Dropdown</a>
                  <ul class="dropdown">
                    <li><a href="#">Supplements</a></li>
                    <li class="has-children">
                      <a href="#">Vitamins</a>
                      <ul class="dropdown">
                        <li><a href="#">Supplements</a></li>
                        <li><a href="#">Vitamins</a></li>
                        <li><a href="#">Diet &amp; Nutrition</a></li>
                        <li><a href="#">Tea &amp; Coffee</a></li>
                      </ul>
                    </li> 
                    
                  </ul>
                </li>
                    <li><a href="#">Diet &amp; Nutrition</a></li>
                    <li><a href="#">Tea &amp; Coffee</a></li>
                    -->