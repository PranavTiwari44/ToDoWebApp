<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<HTML>
    <head>
    	<link href="webjars\bootstrap\5.2.0\css\bootstrap.min.css" rel="stylesheet" >
        <title>ToDos Page</title>
    </head>
    <body>
			<div class="container">
			   <H1>Enter Todo Details</H1>
			   <form method="post">
					Description: <input type="text" name="description"/>
					<input type="submit" class="btn btn-success">
			   </form>
           </div>
           <script src="webjars\bootstrap\5.2.0\js\bootstrap.min.js"></script>
           <script src="webjars\jquery\3.6.1\jquery.min.js"></script>
    </body>
</HTML>