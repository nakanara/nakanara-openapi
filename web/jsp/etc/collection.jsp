<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.nakanara.util.DateUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<%
    String yymm = DateUtil.getYYMM(0);
    List list = (List)request.getAttribute("list");
    Logger logger = LoggerFactory.getLogger(request.getRequestURI());
    logger.debug("{}", list);
%>
<head>
    <%@ include file="/include/html_begin.jspf"%>
</head>

<body id="page-top" class="index">
<div id="skipnav"><a href="#maincontent">Skip to main content</a></div>

<!-- Navigation -->
<nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="#page-top"><%= web_title%></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li class="page-scroll">
                    <a href="#portfolio">Portfolio</a>
                </li>
                <li class="page-scroll">
                    <a href="#about">About</a>
                </li>
                <li class="page-scroll">
                    <a href="#contact">Contact</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<!-- Portfolio Grid Section -->
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2>APT Info</h2>
                <hr class="star-primary">
            </div>
        </div>
        <div class="row">
            <table class="table">
                <thead><tr>
                    <th>수집년도</th>
                    <th>수집월</th>
                    <th>수집건수</th>
                </tr></thead>
                <tbody>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.yy}</td>
                        <td>${item.mm}</td>
                        <td>
                        ${item.cnt}
                            <button type="button" class="btn btn-primary" onclick="fnCollection('${item.yy}','${item.mm}')">재수집</button>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</section>
<form id="f" name="f" action="/collectionApt.do">
    <input type="text" name="coll_yymm" id="coll_yymm" value="<%= yymm %>"/>
</form>
<button id="btnCollection">Collection</button>

<%@ include file="/include/html_end.jspf"%>
<script type="text/javascript">
    $(document).ready(function(){

        $('#btnCollection').click(function(){
            var yymm = $('#coll_yymm').val();

            if(yymm == undefined || yymm.length != 6) {
                alert('수집할 YYYYMM을 입력하세요.['+yymm+']');
                return false ;
            }

            if(confirm("["+yymm+"] 데이터 수집을 실행하시겠습니까?")) {
                $('#f').submit();
            }

        })
    });

    function fnCollection(yy, mm) {
        if(mm < 10) mm = ("0" + mm);
        $('#coll_yymm').val(yy+mm);
        $('#btnCollection').click();
    }
</script>
</body>

</html>