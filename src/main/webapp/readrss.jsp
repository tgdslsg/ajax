<%--
  Created by IntelliJ IDEA.
  User: tgdsl
  Date: 2016/12/6
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">readrss</button>
<script>
    (function () {
        document.querySelector().onclick=function () {
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("get","/rss.xml")
            xmlHttp.send();
        }
    })();
</script>
</body>
</html>
