<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
    <form id="form" action="LoginServlet">
    <fieldSet>
       <legend style="font-size:30px;font-weight: bold">Login</legend>
        <table>
            <tr>
                <td>Login Id:</td>
                <td><input type="text" name="t1"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="t2"></td>
            </tr>
            <tr>
               <td><input type="submit" name="login" value="Login"></td>
               <td><input type="reset" value="Reset"></td>
            </tr>
        </table>
     </fieldSet>
     </form>
  </center>
</body>
</html>