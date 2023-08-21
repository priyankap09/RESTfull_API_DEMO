

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>

	<img src="/images/${userimage }" height="100px" width="100px">

	<style>
		table, td, th {
			border: 1px solid cyan;
		}
		
		table {
			margin: auto;
		}
		
		th, td {
			padding: 10px;
		}
	</style>
	<table>
		<tr>
			<th>username</th>
			<th>mobno</th>
			<th>emailid</th>
			<th>image</th>
		</tr>

		<c:forEach var="user" items="${usersfromdb }">
			<tr>
				<td>${user.username }</td>
				<td>${user.mobno }</td>
				<td>${user.emailid }</td>
				<td><img src="/images/${user.imagepath }" height="100px" width="100px"></td>
			</tr>
		</c:forEach>

	</table>

</body>