<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sunny</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<c:redirect url = "/admin"/>
	<h1>Test API</h1>

	<script>
		function addNew() {

			$
					.ajax({
						url : "https://jsonplaceholder.typicode.com/posts",
						type : 'GET',
						contentType : 'application/json',
						// data: JSON.stringify(data),
						// dataType: 'json',
						success : function(result) {
							alert('success with https://jsonplaceholder.typicode.com/posts')
							console.log(result)
						},
						error : function(error) {
							alert('fail https://jsonplaceholder.typicode.com/posts')
						}
					});
			$.ajax({
				url : "http://localhost:8082/User",
				type : 'GET',
				contentType : 'application/json',

				success : function(result) {
					alert('success with http://localhost:8082/User ')
					console.log(result)
				},
				error : function(error) {
					alert('fail with http://localhost:8082/User')
				}
			});
		}

		addNew();
	</script>
</body>
</html>