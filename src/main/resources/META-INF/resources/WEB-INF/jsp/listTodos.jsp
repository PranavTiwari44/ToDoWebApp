<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
    <head>
    	<link href="webjars\bootstrap\5.2.0\css\bootstrap.min.css" rel="stylesheet" >
        <title>ToDos Page</title>
    </head>
    <body>
		<div class="container">
			   <H1>Your Todos</H1>
			   <table class="table">
					<thead>
						<tr>
							<th>id</th>
							<th>Description</th>
							<th>Target Date</th>
							<th>Is Done?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.id}</td>
								<td>${todo.description}</td>
								<td>${todo.targetDate}</td>
								<td>${todo.done}</td>
								<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
			   </table>
			   <a href="add-todos" class="btn btn-success">Add Todo</a>
           </div>
           <script src="webjars\bootstrap\5.2.0\js\bootstrap.min.js"></script>
           <script src="webjars\jquery\3.6.1\jquery.min.js"></script>
    </body>
</HTML>