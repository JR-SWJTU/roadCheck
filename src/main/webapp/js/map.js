var blackPointMap = new AMap.Map('blackPointMap', {
    resizeEnable: true,
    zoom:11,
    city:'成都',
});

var spaceMap = new AMap.Map('spaceMap', {
    resizeEnable: true,
    zoom:11,
    city:'成都',
});

var timeMap = new AMap.Map('timeMap', {
    resizeEnable: true,
    zoom:11,
    city:'成都',
    center:[104.082584,30.682064]
});

/*
* 地图操作
* */


/*
* 设置marker
* 传入参数为，地图，标志名称，位置（经纬度），类型（0交叉口还是1路段），数量
* */
addMarker(timeMap,"XXX交叉口1",[104.042584,30.582064],1,3)
addMarker(timeMap,"XXX交叉口2",[104.072584,30.472064],1,100)
addMarker(timeMap,"XXX交叉口3",[104.092584,30.692064],1,50)
var mapMarkers = [];
if (mapMarkers == null || mapMarkers.length == 0) {
    mapMarkers = [];
}

/*
* 设置交叉口事故数大小
*传入参数为数量,全部事故数量
* */
function setIntersectionContent(number,allNumbers) {
    var content = "<div style=\"height: 150px;width: 100px\">\n" +
        "    <div id=\"bar\" style=\"width: 20px;height: 100px;background: "+getColor(number,allNumbers)+"; margin: auto\"></div>\n" +
        "    <p style=\"width:100%;margin: auto;text-align: center\">事故数："+number+"</p>\n" +
        "</div>";
    return content;
}

function setRoadContent (number,allNumbers) {
    var content = "<div style=\"height: 150px;width: 100px\">\n" +
        "    <div id=\"bar\" style=\"width: 20px;height: 100px;background: "+getColor(number,allNumbers)+"; margin: auto\"></div>\n" +
        "    <p style=\"width:100%;margin: auto;text-align: center;color: "+getColor(number,allNumbers)+"\">事故数："+number+"</p>\n" +
        "</div>";
    return content;
};
function addMarker(amap,markerName,position,type,number){
    var Markers = [];

    if (mapMarkers == null || mapMarkers.length == 0) {
        mapMarkers = [];
    }
    //添加点标记，并使用自己的icon
    var testNumbers = 10;//测试数据，不是则设置为1
    for (var i =0;i<testNumbers;i++) {
        var position2 = position;
        position[0] += 0.005;
        position[1]  += 0.005;
        //var numbers = "事故数："+number;
        number +=10;
        var content;
        if (type == 0) {
            content = setIntersectionContent(number,200);
        }else {
            content = setRoadContent(number,200);
        }

        var marker = new AMap.Marker({
            map: amap,
            position: position,
            icon: new AMap.Icon({
                size: new AMap.Size(40, 50),  //图标大小
            }),
            label:{
                offset: new AMap.Pixel(15, 120),//修改label相对于maker的位置
                content: markerName
            },
            content:content
        });
        Markers.push(marker);//添加marker
        mapMarkers.push(marker);
    }
 //   showChart();

}
/*
    * 返回颜色，红黄蓝绿
    * */
function getColor(number,allNumbers) {
    var lev = (number/allNumbers)*10;
    console.log("lev:---"+lev);
    if (lev > 6) {
        return "red";
    }else if(lev > 3){
        return "yellow";
    }else if(lev > 1){
        return "blue"
    }else {
        return "green"
    }
}
function getHeight() {
    var lev = (number/allNumbers)*100;
    return lev;
}
//清除marker
//clearMarker(timeMap)
function clearMarker(amap) {
    console.log("mapmarker:"+mapMarkers.length)
    amap.remove(mapMarkers);
    mapMarkers = [];
    // mapMarkers.clear();
}

