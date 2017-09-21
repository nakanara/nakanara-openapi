<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.nakanara.util.DateUtil" %>
<!DOCTYPE html>
<html lang="ko">
<%
    String yymm = DateUtil.getYYMM(0);
%>
<head>
    <%@ include file="/include/html_begin.jspf"%>
</head>
<body>

<form id="f" name="f" action="/collectionApt.do">
    <input type="text" name="coll_yymm" id="coll_yymm" value="<%= yymm %>"/>

</form>
<div>
    <table>
        <thead><tr>
            <th>수집년도</th>
            <th>수집월</th>
            <th>수집건수</th>
        </tr></thead>
        <tbody>
        </tbody>
    </table>
</div>
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
</script>
</body>

</html>