<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<HTML>
    <head>
    	<link href="webjars\bootstrap\5.2.0\css\bootstrap.min.css" rel="stylesheet" >
        <title>ToDos Page</title>
    </head>
    <body>
			<div class="container">
			   <H1>Enter Todo Details</H1>
			   <form:form method="post" modelAttribute="todo">
					Description: <form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
					<form:input type="hidden" path="id"/>
					<form:input type="hidden" path="done"/>
					<input type="submit" class="btn btn-success">
			   </form:form>
           </div>
           <script src="webjars\bootstrap\5.2.0\js\bootstrap.min.js"></script>
           <script src="webjars\jquery\3.6.1\jquery.min.js"></script>
    </body>
</HTML>