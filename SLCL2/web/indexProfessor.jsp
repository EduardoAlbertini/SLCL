<%@ taglib uri = "http://java.sun.com/jstl/core" prefix = "c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/PageCSS.css" rel="stylesheet" media="screen">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <c:import url="cabecalho.jsp" ></c:import>
            </div>

            <div id="content">
                main content here...main content here...main content here...main content here...main content here...
                main content here...main content here...main content here...main content here...main content here...
                main content here...main content here...main content here...main content here...main content here...
                main content here...main content here...main content here...main content here...main content here...
                main content here...main content here...main content here...main content here...main content here...
            </div>

            <div id="sidebar">
                sidebar content here...sidebar content here...sidebar content here...sidebar content here...
                sidebar content here...sidebar content here...sidebar content here...sidebar content here...
                sidebar content here...sidebar content here...sidebar content here...sidebar content here...
                sidebar content here...sidebar content here...sidebar content here...sidebar content here...
                sidebar content here...sidebar content here...sidebar content here...sidebar content here...
            </div>

            <div id="footer">
                footer content here
            </div>
        </div>
        
    </body>
</html>
