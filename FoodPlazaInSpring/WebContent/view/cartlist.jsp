<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>  
    
<jsp:include page="header.jsp"/>
<script type="text/javascript">
   $(function()
	{
		 $('li.nav-item').removeClass('active'); 
		 $("#cartlist").addClass('active');
	   function calcTotalAmount()
	   {
		   var qtylist = $(".qty");
		   var pricelist =  $(".price");
		   
		   var totalAmount = 0;
		   $.each(qtylist,function(index,qtyElement)
		   {
			  totalAmount += qtyElement.value*pricelist[index].value; 
			  console.log(pricelist[index].value);
			  console.log(qtyElement.value);
			  
		   });
		   //$("#totalPrice").text(totalAmount);
		   $("#totalPrice").val(totalAmount);
	   }
	   //handle click event on qty change
	   $(".qty").click(function()
	   {
		   //it should be called for qty change
		   calcTotalAmount();
		   
		   cartQty = this.value;//$(this).val()
		   cartId = this.nextElementSibling.value;//$(this).next().val();
		   
		   console.log(cartQty);
		   console.log(cartId);
		   //to update changes on databases
		   //$.post(url,data,takeresponsecallbackfunction);
		   
		   $.post("updateCartQty",{"cartId":cartId, "cartQty":cartQty},function(response){
               
			   alert(response);
		   });
	   });
	//it  should call at time of page reloading or refresh
	calcTotalAmount();
	   
    function CheckMax(e){
    	var num = $(e).val();
    	var maxNum = $(e).attr('max');
    	
    	console.log(num);
    	console.log(maxNum);
    	
    	if (+num == +maxNum)	{
    		alert('no more quantity available');
    	}
    	
    	if (+num > +maxNum)	{
    		$(e).val(maxNum);
    	}
    }

    }); 
</script>

<!-- Page Content -->
	<section class="py-5">
	  <div class="container">
	    <h1>Cart List</h1>
	  </div>
	  <div class="container">
	  <core:if test="${!cartlist.isEmpty()}">
	  <form action="placeorder" metohod="post">
	  <table class="table table-bordered table-hover">
	  <thead class="thead-dark">
	  	<core:if test="${msg!=null or emsg!=null}">
	  	<tr>
	  		<td colspan="6">
	  			<span class="success">${msg}</span>
	  			<span class="error">${emsg}</span>
	  		</td>
	  	</tr> 
	  	</core:if>
	  	<tr>
	  		<th>Id</th>
	  		<th>Food Image</th>
	  		<core:if test="${admin != null }">
	  		  <th>Customer Email Id</th>
	  		</core:if>
	  		<th>Food Name</th>
	  		<th>Food Quantity</th>
	  		<th>Food Price</th>
	  		<th colspan="2">Action</th>
	  	</tr>
	  </thead>	
	  	<core:forEach var="cart" items="${cartlist}">
	  	<tr>
	  		<td><a href="foodDetails?foodId=${cart.foodId}">${cart.cartId}</a></td>
	  		<td><img src="foodimage?foodId=${cart.foodId}"  width="100" height="100"/></td>
	  		<core:if test="${admin != null }">
	  		  <td>${cart.cartCustEmailId}</td>
	  		</core:if>
	  		<td>${cart.foodName}</td>
	  		<td>
	  		<input type="number" class="qty" name="cartFoodQuantity" value="${cart.cartFoodQuantity}"/>
	  		<input type="hidden"  name="cartId" value="${cart.cartId}" readonly="readonly"/></td>
	  		<td><input type="number" class="price" name="foodPrice" value="${cart.foodPrice}" readonly="readonly"/></td>
	  		<!-- URL Rewriting -->
	  		<td><a onclick="return confirm('do you really want to delete this food?');" class="btn btn-danger" href="deletecart?cartId=${cart.cartId}">Delete</a></td>
	  	</tr>	
	  	</core:forEach>
	  	<tfoot>
	  	  <tr> 
	  	     <td colspan="2">Total Price</td>
	  	     <td colspan="2">&#8377</td>
	  	     <td><input type="text" name="totalPrice"  id="totalPrice" readonly/></td>
	  	     <td colspan="2"><input type="submit" value="Place Order"  class="btn btn-warning"/></td>
	  	  </tr>
	  	</tfoot>
	  </table>
	  </core:if>
	  <core:if test="${cartlist.isEmpty()}">
	  	<img src="resources/images/empty_cart_800x600_dribbble.png" height="500px" ></a>
	  </core:if>
	  </form>
	  </div>
	  </section>
<jsp:include page="footer.jsp"/> 