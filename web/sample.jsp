<%--
  Created by IntelliJ IDEA.
  User: steg
  Date: 2017-06-14
  Time: 오전 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="UTF-8">
    <script type="text/javascript" src="jquery-3.2.1.min.js"></script>
</head>
<body>

addr : <input type="text" id="addr"><input id='btn' type="button" value="Get Data">
<br/>
<textarea id='result' style='width:99%; height:200px;'></textarea>

<script type="text/javascript">

    var domain = "http://openapi.ccourt.go.kr/openapi/services/PrecedentInfoSvc/";//PrecedentInfoSvc=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D&eventNm=국선대리인선임
    var serviceKey="serviceKey=QgX6nsZoNT8G5bftv6CNm3HWssSJfvoYKsYZir6wR5sLAg1AgJ4POz8pE7JYyotFJHpE3hNSNc%2F2uVrfiMGmKQ%3D%3D";
    var serviceId="getRealmMainPrcdntSearchInfo";//"getIncdntTotalInfo";


    $(document).ready(function(){


        $('#btn').click(function(){
            alert(domain + serviceId + "?" + serviceKey);

            $.ajax({
                url: domain + serviceId + "?" + serviceKey,
                type:"post",
                success: function(msg){
                    alert(msg);
                    $('#result').val(msg);
                },
                error: function(xhr, status){
                    alert(status);
                }

            })
        });
    });
</script>
</body>
</html>
