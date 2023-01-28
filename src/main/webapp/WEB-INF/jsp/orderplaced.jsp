<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">
<head>
<title>Home || Orderplaced</title>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/css/bootstrap.min.css"
	integrity="sha512-F7WyTLiiiPqvu2pGumDR15med0MDkUIo5VTVyyfECR5DZmCnDhti9q5VID02ItWjq6fvDfMaBaDl2J3WdL1uxA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.0/js/bootstrap.bundle.min.js"
	integrity="sha512-PqRelaJGXVuQ81N6wjUrRQelCDR7z8RvKGiR9SbSxKHPIt15eJDmIVv9EJgwq0XvgylszsjzvQ0+VyI2WtIshQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
<script>
document.getElementById('name').innerHTML = 'hello';
</script>
</head>


<body>
 <div >
  <header>
 
  </header>
  <div> 
   <h3> Welcome <h3>
  <table class="table table-striped">
  <tbody>
       <tr >	
			<td>Name</td>
			<td>${user.name}</td>
       </tr>
	   <tr >	
			<td>Email Id</td>
			<td>${user.loginId}</td>
       </tr>
	    <tr >	
			<td>Current Balance</td>
			<td>${user.balance}</td>
       </tr>
	    
	    
 
  </tbody>
</table>
	<h5>LIST OF ORDERS</h5>
   <table class="table table-striped">
  <thead>
    <tr>
      <th>share</th>
      <th>Quantity</th>
      <th>price</th>
	  <th>Total Purchase</th>
    </tr>
  </thead>
  <tbody>
      <c:forEach var="o" items="${order}" >
        <tr >
			
			<td>${o.share}</td>
			<td>${o.quantity}</td>
			<td>${o.price}</td>
			<td>${o.totalPurchase}</td>
       </tr>
      </c:forEach>
  </tbody>
</table>
  </div>

 </div>
 
 <div class="d-grid" style="margin-top:10px;">
							<button class="btn btn-primary btn-login text-uppercase fw-bold"
								type="submit" onclick="moveBack();">Continue purchasing
	</button>
	
<div class="d-grid" style="margin-top:10px;">
							<button class="btn btn-primary btn-login text-uppercase fw-bold"
								type="submit" onclick="signOut();">sign Out
	</button>
</div>


</body>
<script>
function moveBack(){
			window.location.href ="/home/"+"${user.loginId}";
		}
function signOut(){
			window.location.href = "/";
		}
</script>

</html>
