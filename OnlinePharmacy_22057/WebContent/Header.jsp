<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Pharma &mdash; Colorlib Template</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
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

   <%
      String admin = (String)session.getAttribute("admin");
      String user = (String)session.getAttribute("user");
   %>

  <div class="site-wrap">

    <div class="site-navbar py-2">

      <div class="search-wrap">
        <div class="container">
          <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
          <form action="#" method="post">
            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
          </form>
        </div>
      </div>

      <div class="container1" style="background-color:#51EAEA">
        <div class="d-flex align-items-center justify-content-between">
          <div class="logo">
            <div class="site-logo">
              <a href="index.html" class="js-logo-clone">Pharma</a>
            </div>
          </div>
          <div class="main-nav d-none d-lg-block">
            <nav class="site-navigation text-right text-md-center" role="navigation">
            
              <% if(user==null && admin == null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
                <li><a href="AddCustomer.jsp">Sign Up</a></li>
                <li><a href="Login.jsp">Sign In</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
              </ul>
              
              <% } %>
              
              <% if(user == null && admin != null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
                <li><a href="AddMedicine.jsp">Add Medicine</a></li>
                <li><a href="CustomerServlet">Customer List</a></li>
                <li><a href="FeedbackServlet">Feedback List</a></li>
                <li><a href="OrderServlet">Order List</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
                <li><a href="LoginServlet">Log Out</a></li>
              </ul>
              
              <% } %>
              
              <% if(user != null && admin == null){ %>
              
              <ul class="site-menu js-clone-nav d-none d-lg-block">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="MedicineServlet">Store</a></li>
                <li><a href="CustomerServlet?action=edit&custemailid=<%=user%>">Edit Profile</a></li>
                <li><a href="about.html">About</a></li>
                <li><a href="contact.html">Contact</a></li>
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
            <a href="CartServlet" class="icons-btn d-inline-block bag">
              <span class="icon-shopping-bag"></span>
              <span class="number">2</span>
            </a>
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