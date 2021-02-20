<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>

<script type="text/javascript">

function loadImg(){
    $('#frame').attr('src', URL.createObjectURL(event.target.files[0]));
 };

</script>
<input type="file"  onchange="loadImg()"><br/>
    <img id="frame"  width="100px" height="100px"/>
<jsp:include page="footer.jsp"/>
