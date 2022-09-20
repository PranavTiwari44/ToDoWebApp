<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
    <head>
        <title>ToDos Page</title>
    </head>
    <body>
           <div>Welcome ${name}</div>
           <hr>
           <H1>Your Todos</H1>
           <table>
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
           				</tr>
           			</c:forEach>
           		</tbody>
           </table>
    </body>
</HTML>