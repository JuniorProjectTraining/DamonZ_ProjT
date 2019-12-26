<%--
  Created by IntelliJ IDEA.
  Classes.User: ScarletZhou
  Date: 2019/6/30
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <title>test</title>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.4.7&key=d7f2b4b63af01d373c090ec6f73b50be"></script>

    <style>
        #addressBox {
            height: 20px;
            width: 600px;
        }

        #mapBox {
            height: 400px;
            width: 600px
        }

        #pointBox {
            height: 20px;
            width: 600px;
        }
    </style>
<body>
<div id="iControlbox">
    <ul>
        <li>
            <input type="text" id="key_11" value="116.51413"/>
            <input type="text" id="key_12" value="39.912896"/>
            <button onclick="javascript:geocoder2();">逆地址解析</button>
        </li>
        <li>
            <input type="text" id="key_2" value="北京市朝阳区大屯路304号"/>
            <button onclick="javascript:geocoder();">地址解析</button>
        </li>
    </ul>
</div>
<div id="result"></div>

<div id='pointBox'>&nbsp;</div>
<div id='mapBox'></div>
<script>
    var mapObj = new AMap.Map("mapBox", {
        resizeEnable: true,
        //center: [106.16, 29.18],
        zoom: 8,
        zoomEnable: true

    });
</script>

<script type="text/javascript">

    var $addressBox = document.getElementById('addressBox');
    var $pointBox = document.getElementById("pointBox");
    var result;
    var marker = [];
    var windowsArr = [];
    var MGeocoder;
    var key_11;
    var key_12;
    var key_2;

    function geocoder2() {  //POI搜索，关键字查询
        key_11 = document.getElementById("key_11").value;
        key_12 = document.getElementById("key_12").value;
        var lnglatXY = new AMap.LngLat(key_11, key_12);
        //document.getElementById('result').innerHTML = "您输入的是：" + key_1;
        //加载地理编码插件
        mapObj.plugin(["AMap.Geocoder"], function () {
            MGeocoder = new AMap.Geocoder({
                radius: 1000,
                extensions: "all"
            });
            //返回地理编码结果
            AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack2);
            //逆地理编码
            MGeocoder.getAddress(lnglatXY);
        });
        //加点
        var marker = new AMap.Marker({
            map: mapObj,
            icon: new AMap.Icon({
                image: "http://api.amap.com/Public/images/js/mark.png",
                size: new AMap.Size(58, 30),
                imageOffset: new AMap.Pixel(-32, -0)
            }),
            position: lnglatXY,
            offset: new AMap.Pixel(-5, -30)
        });
        mapObj.setFitView();
    }

    //鼠标划过显示相应点
    var marker2;

    function onMouseOver(e) {
        var coor = e.split(','),
            lnglat = new AMap.LngLat(coor[0], coor[1]);
        if (!marker2) {
            marker2 = new AMap.Marker({
                map: mapObj,
                icon: "http://webapi.amap.com/images/0.png",
                position: lnglat,
                offset: new AMap.Pixel(-10, -34)
            });
        } else {
            marker2.setPosition(lnglat);
        }
        mapObj.setFitView();
    }

    function geocoder_CallBack2(data) { //回调函数
        var resultStr = "";
        var roadinfo = "";
        var poiinfo = "";
        var address;
        //返回地址描述
        address = data.regeocode.formattedAddress;
        //返回周边道路信息
        roadinfo += "<table style='width:600px'>";
        for (var i = 0; i < data.regeocode.roads.length; i++) {
            var color = (i % 2 === 0 ? '#fff' : '#eee');
            roadinfo += "<tr style='background-color:" + color + "; margin:0; padding:0;'><td>道路：" + data.regeocode.roads[i].name + "</td><td>方向：" + data.regeocode.roads[i].direction + "</td><td>距离：" + data.regeocode.roads[i].distance + "米</td></tr>";
        }
        roadinfo += "</table>"
        //返回周边兴趣点信息
        poiinfo += "<table style='width:600px;cursor:pointer;'>";
        for (var j = 0; j < data.regeocode.pois.length; j++) {
            var color = j % 2 === 0 ? '#fff' : '#eee';
            poiinfo += "<tr onmouseover='onMouseOver(\"" + data.regeocode.pois[j].location.toString() + "\")' style='background-color:" + color + "; margin:0; padding:0;'><td>兴趣点：" + data.regeocode.pois[j].name + "</td><td>类型：" + data.regeocode.pois[j].type + "</td><td>距离：" + data.regeocode.pois[j].distance + "米</td></tr>";
        }
        poiinfo += "</table>";
        //返回结果拼接输出
        resultStr = "<div style=\"font-size: 12px;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\">" + "<b>地址</b>：" + address + "<hr/><b>周边道路信息</b>：<br/>" + roadinfo + "<hr/><b>周边兴趣点信息</b>：<br/>" + poiinfo + "</div>";
        document.getElementById("result").innerHTML = resultStr;
    }

    function geocoder() {  //地理编码返回结果展示
        key_2 = document.getElementById("key_2").value;
        mapObj.plugin(["AMap.Geocoder"], function () {     //加载地理编码插件
            MGeocoder = new AMap.Geocoder();
            //返回地理编码结果
            AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack);
            MGeocoder.getLocation(key_2);  //地理编码
        });
    }

    //地理编码返回结果展示
    function geocoder_CallBack(data) {
        var resultStr = "";
        //地理编码结果数组
        var geocode = new Array();
        geocode = data.geocodes;
        for (var i = 0; i < geocode.length; i++) {
            //拼接输出html
            resultStr += "<span style=\"font-size: 12px;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\">" + "<b>地址</b>：" + geocode[i].formattedAddress + "" + "<b>    坐标</b>：" + geocode[i].location.getLng() + ", " + geocode[i].location.getLat() + "" + "<b>    匹配级别</b>：" + geocode[i].level + "</span>";
            addmarker(i, geocode[i]);
        }
        mapObj.setFitView();
        document.getElementById("result").innerHTML = resultStr;
    }

    function addmarker(i, d) {
        var lngX = d.location.getLng();
        var latY = d.location.getLat();
        var markerOption = {
            map: mapObj,
            icon: "http://webapi.amap.com/images/" + (i + 1) + ".png",
            position: new AMap.LngLat(lngX, latY)
        };
        var mar = new AMap.Marker(markerOption);
        marker.push(new AMap.LngLat(lngX, latY));

        var infoWindow = new AMap.InfoWindow({
            content: d.formattedAddress,
            autoMove: true,
            size: new AMap.Size(150, 0),
            offset: {x: 0, y: -30}
        });
        windowsArr.push(infoWindow);

        var aa = function (e) {
            infoWindow.open(mapObj, mar.getPosition());
        };
        AMap.event.addListener(mar, "click", aa);
    }
</script>
</body>
</html>