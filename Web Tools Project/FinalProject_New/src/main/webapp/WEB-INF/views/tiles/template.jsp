<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
</head>  
<body>  
        <div><tiles:insertAttribute name="DashboardHeader" /></div>  
        <div style="float:left;width:20%;"><tiles:insertAttribute name="menu" /></div>  
        <div style="float:left;margin-top:10%;padding:10px;width:80%;margin-right: 30%;margin-left: 20%;">  
        <tiles:insertAttribute name="body" /></div>  
        <div class="footer" style="clear:left;margin-bottom:10%;"><tiles:insertAttribute name="DashboardFooter" /></div>  
</body>  
</html>