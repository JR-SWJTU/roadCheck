<%--
  Created by IntelliJ IDEA.
  User: TR
  Date: 2017/10/25
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地图测试</title>
    <link rel="stylesheet" href="../libs/muse-ui-2.1.0/fonts.css" />
    <link rel="stylesheet" href="../libs/muse-ui-2.1.0/muse-ui.css" />
    <link rel="stylesheet" href="../libs/muse-ui-2.1.0/theme-light.css" />
    <link rel="stylesheet" href="../css/index.css" />

    <!--   <script src="http://webapi.amap.com/maps?v=1.4.0&key=9a1af9cca90cfaf160d5a8d7c0af9187"></script>          -->
    <!-- 地图key -->
    <script src="http://webapi.amap.com/maps?v=1.4.0&key=396befe7016bef31b674c361915d082e"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main"></div>
<div id="timeMap" style="width: 100%;height: 100%">

</div>

<script src="../js/map.js"></script></body>
</html>
