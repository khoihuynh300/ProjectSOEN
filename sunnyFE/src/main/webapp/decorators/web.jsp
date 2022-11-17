<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="/common/taglib.jsp" %>
	<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>Thousand Sunny</title>
    <!-- CSS -->
    <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://unpkg.com/boxicons@2.1.3/css/boxicons.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />

  <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
  />
    <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://unpkg.com/boxicons@2.1.3/css/boxicons.min.css"
      rel="stylesheet"
    />
    
    <!--  -->
    <link
      href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <link
      href="https://unpkg.com/boxicons@2.1.3/css/boxicons.min.css"
      rel="stylesheet"
    />

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.1/css/bootstrap.css"
    />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
    />
    <link
      href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://unpkg.com/boxicons@2.1.3/css/boxicons.min.css"
      rel="stylesheet"
    />
    
    
    <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="<c:url value='/views/web/js/home.js'/>"></script>
<%@ include file="/common/web/header.jsp"%>
	
	<dec:body/>
<%@ include file="/common/web/footer.jsp"%>

    
    <script
      src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      type="text/javascript"
    ></script>
    <script
      src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      type="text/javascript"
    ></script>
    
    
    <script type="text/javascript">

		function LoadNumberItemOfCart() {
	    	
	    	
	    	$.get('/sunnyFE/account/getsession', function(ketqua) {
				if('cus' in ketqua){
					//console.log(ketqua.cus.cusId)
					
					var status;	
					let url = "http://localhost:8083/cart/get-by-customer-id?id=" + ketqua.cus.cusId;
					
					fetch(url, {
					  method: 'GET', 
					  headers: {
					    'Content-Type': 'application/json',
					  },
					})
					  .then((response) =>{ 
						status = response.status
						return response.json()
						})
					  .then((data) => {
					    
					    if(status==200){
							$('.btn .badge').html(data.amountUniqueItem)
						}
					   	
					  })
					  .catch((error) => {
					    console.error('Error:', error);
					    alert(error)
					  });
				}
			});
		}
		LoadNumberItemOfCart();
	</script>
</body>
</html>