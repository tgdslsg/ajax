<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <button id="btn">sendrequest</button>
</head>
<body>
<script>//创建XMLHttpRequest对象，即创建ajax engine。
    (function(){
        function creatXmlHttp() {
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp= new ActiveXObject("Microsoft.XMLHTTP")
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#btn").onclick=function () {
            //1获取ajax引擎
             var  xmlHttp = creatXmlHttp();
            //2指定请求的方式和地址
            xmlHttp.open("get","/ajax");
            //3发出请求
            xmlHttp.send();
        }
    })();
</script>
</body>
</html>
