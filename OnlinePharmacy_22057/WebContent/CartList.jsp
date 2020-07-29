<%@page import="com.pharmacy.pojo.Medicine"%>
<%@page import="com.pharmacy.pojo.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="jquery-3.5.1.js"></script>
<script src="jquery.validate.min.js"></script>

<title>Cart List</title>

<script>
   function totalBill()
   {
	   var medQuantity = $(".qty");
	   var medPrice =  $(".price");
	   
	   var tbill = 0;
	   
	   for(var i=0; i < medQuantity.length ;i++)
	   {
		   tbill = tbill + (medQuantity[i].value *medPrice[i].value );
	   }
	   $("#tbill").text("Rs. " +tbill);
   }
   $(function()
	{
	    $(".qty").click(function(){
	    	
	    	var  medqty = $(".qty");
	    	
	    	for(var i=0; i < medqty.length; i++)
	    	{
	    		if(medqty[i].value <= 0)
	    		{
	    			$(".qty").val(1);
	    		}
	    		else
	    		{
	    			totalBill();
	    		}
	    	}
	    });
	    totalBill();
    });
   
    $(function()
      {
    	$(".placeorder").click(function()
    	  {
    		 var medicineQuantity = $(".qty").val();
    		 var cartId = $(".cartid").html();
    		 
    		 $.ajax
    		 ({
    			 type:'POST',
    			 data:{action:'updatequantity', medicineQuantity:medicineQuantity,cartId:cartId},
    			 url:'CartServlet',
    			 success:function(result)
    			 {
    				 alert(result);
    			 }
    		 });
    	  });
      });
  
</script>
</head>
<body>
   <jsp:include page="Header.jsp"></jsp:include>
   <form action="OrderServlet" method="post">
   <input type="hidden" name="action" value="placeorder">
   <%
      List<Cart> lstCart = (List<Cart>)session.getAttribute("list_Cart");
      List<Medicine> lstList = (List<Medicine>)session.getAttribute("medList");
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
     <% if(!lstCart.isEmpty()){ %>
     <div class="site-section">
     <div class="container">
        <div class="row mb-5">
             <div class="site-blocks-table">
                <table class="table table-bordered">
                  <thead>
                     <tr id="b">
                       <th>Cart Id</th>
                       <th>Medicine Id</th>
                       <th>Medicine Name</th>
                       <th>Medicine Price</th>
                       <th>Medicine Quantity</th>
                       <th>Action</th>
                     </tr>
                  </thead>
                  <tbody>
                    <% for(Cart cart:lstCart){%>
                       <tr>
                          <td>
                             <h2 class="h5 text-black cartid" ><%= cart.getCartId() %></h2>
                          </td>
                          <td>
                             <h2 class="h5 text-black" name="medid" value="<%= cart.getMedicineId() %>"><%= cart.getMedicineId() %></h2>
                          </td>
                          <td>
                             <h2 class="h5 text-black"><%= cart.getMedicineName() %></h2>
                          </td>
                           <td>
                               <input type="text" class="form-control price" name="medprice" value="<%= cart.getMedicinePrice() %>" readonly>
                           </td>
                            <td>
                                
                              <% for(int i=0 ; i < lstList.size() ; i++){ %>
                                   <% if(lstList.get(i).getMedicineId() == cart.getMedicineId()) {%> 
                                        <input type="number" class="form-control qty" min="1" name="medqty" 
                                        max="<%= lstList.get(i).getMedicineQty()  %>"
                                           value="<%= cart.getMedicineQty()%>">
                                           
                               <% }} %>
                           </td>
                            <td>
                                <a href="CartServlet?action=delete&cartid=<%=cart.getCartId()%>" class="h5 text-black">
                                <span class="glyphicon glyphicon-trash"></span>delete</a>
                                
  
                           </td>
                       </tr>
                       
                     <% } %>
                     <tr>
                       <td colspan="4">
                          <h2 class="h5 text-black">Total:</h2>
                       </td>
                       <td colspan="2" class="h5 text-black" id="tbill"></td>
                     </tr>
                  </tbody>
                </table>
                <div class="container">
                   <div class="form-group row">
                      <input type="submit" class="btn btn-primary btn-lg btn-block placeorder" value="Place Order">
                   </div>
                </div>
             </div>
        </div>
     </div>
   </div>
     <% }else {  %>
     <p><b>No item added yet...</b></p>
     <img alt="empty_cart" src="images/empty_cart_800x600_dribbble.png">
     <% } %>
     </form>
        <jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>