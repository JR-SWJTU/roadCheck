var blackPointMap = new AMap.Map('blackPointMap', {
    resizeEnable: true,
    zoom:15,
    city:'成都',
});

var spaceMap = new AMap.Map('spaceMap', {
    resizeEnable: true,
    zoom:15,
    city:'成都',
});

var timeMap = new AMap.Map('timeMap', {
    resizeEnable: true,
    zoom:15,
    city:'成都',
    center:[104.082584,30.682064]
});
//路段参数
var markerOptions = {
    tyep:0,//类型0路段，1交叉口
    name:"",//名称
    lat:0.0,//经纬度
    lng:0.0,//经纬度
    accidentNumbers:0,//事故总数
    wealthLoss:0,//财损数量
    slightInjury:0,//轻伤数量
    seriousInjury:0,//重伤数量
    death:0,//死亡数量
}

/*
* 地图操作
* */
//spaceMap.setMapStyle('amap://styles/'+"dark");
spaceMap.setMapStyle('amap://styles/'+"dark");
blackPointMap.setMapStyle('amap://styles/'+"dark");
timeMap.setMapStyle('amap://styles/'+"dark");

var features = ['road'];
spaceMap.setFeatures(features);
/*
*  value='dark'>幻影
 value='light'>月
 value='fresh'>草
 value='grey'>雅士
 value='graffiti
 value='whitesmo
 value='macaron'
 value='blue'>靛青
 value='darkblue
' value='wine'>酱
* */
/*
* 设置marker
* 传入参数为，地图，标志名称，位置（经纬度），类型（0交叉口还是1路段），当前路段|交叉口事故数量
* */

/*
* 设置交叉口事故数大小
*传入参数为数量,全部事故数量
*
* amap,tyep,name,lat,lng,accidentNumbers,accidentAllNumbers,wealthLoss,slightInjury,seriousInjury,death
* */
var markerOptions = {
    map                  : spaceMap,            //地图
    type                 : 1           ,   //类型1路段，0交叉口
    name                 : "交叉口1"           ,   //名称
    lat                  : 104.072584            ,   //经纬度
    lng                  : 30.472064            ,   //经纬度
    isChenDu            : true,                   //是否为严重程度展示
    showType            : "财损,重伤,死亡"     ,   //严重程度需要的展示内容
    accidentAllNumbers : 200,  //所有事故总数
    accidentNumbers     : 100 ,  //当前路段/交叉口事故总数
    wealthLoss          : 30     ,   //财损数量
    slightInjury        : 40    ,  //轻伤数量
    seriousInjury       : 20   ,  //重伤数量
    death                : 10              //死亡数量
};

var mapMarkers = [];

// setMarker(markerOptions);
function setMarker(options) {

    if (mapMarkers == null || mapMarkers.length == 0) {
        mapMarkers = [];
    }
    //获取展示内容
    var content;
    if (options.type == 0) {
        content = setIntersectionContent(options);
    }else {
        content = setRoadContent(options);
    }
    var marker = new AMap.Marker({
        map: options.map,
        position: [options.lat,options.lng],
        icon: new AMap.Icon({
            size: new AMap.Size(40, 50),  //图标大小
        }),
        content:content
    });
    mapMarkers.push(marker);
}

function addMarker(amap,markerName,position,type,number){
    var Markers = [];

    if (mapMarkers == null || mapMarkers.length == 0) {
        mapMarkers = [];
    }

    //添加点标记，并使用自己的icon
    var testNumbers = 10;//测试数据，不是则设置为1
    for (var i =0;i<testNumbers;i++) {
        var position2 = position;
        var mx = Math.random()*2;
        if (mx>1) {
            mx  = -1;
        }else {
            mx  =  1;
        }
        var my = Math.random()*2;
        if (my>1) {
            my  = -1;
        }else {
            my  =  1;
        }
        position[0] += mx*0.005*(Math.random()*5+1);
        position[1] += my*0.005*(Math.random()*3+1);
        //var numbers = "事故数："+number;
        number +=10;
        var content;
        if (type == 0) {
            content = setIntersectionContent(number,200,markerName);
        }else {
            content = setRoadContent(number,200,markerName);
        }
        content = testContent();
        var marker = new AMap.Marker({
            map: amap,
            position: position,
            icon: new AMap.Icon({
                size: new AMap.Size(40, 50),  //图标大小
            }),
            // label:{
            //     offset: new AMap.Pixel(15, 120),//修改label相对于maker的位置
            //     content: markerName
            // },
            content:content
        });
        Markers.push(marker);//添加marker
        mapMarkers.push(marker);
    }
 //   showChart();

}

function setIntersectionContent(options) {

    var content = "<div style=\"height: 150px;width: 100px\">\n" +
        "<div  style=\"margin: auto;width: "+getHeight(options.accidentNumbers,options.accidentAllNumbers)/2+"px;height: "+
        getHeight(options.accidentNumbers,options.accidentAllNumbers)/2+"px;background: red"+
       ";border-radius:50%\"></div>" +
        "    <p style=\"width:100%;margin: auto;text-align: center;color:white;\">事故数："+options.accidentNumbers+"</p>\n" +
        "    <p style=\"width:100%;margin: auto;background:white;text-align: center;\">"+options.name+"</p>\n" +
        "</div>";

    if (options.isChenDu) {
        return getContent(options);
    }
    return content;
}

function setRoadContent (options) {
    var content = "<div style=\"height: 200px;width: 100px\">\n" +
        "    <div id=\"bar\" style=\"width: 20px;height: "+getHeight(options.accidentNumbers,options.accidentAllNumbers)+"px;background: red"+
             "; margin: auto\"></div>\n" +
        "    <p style=\"width:100%;margin: auto;text-align: center;color: "+"white"+"\">事故数："+options.accidentNumbers+"</p>\n" +
        "    <p style=\"width:100%;margin: auto;background:white;text-align: center;\">"+options.name+"</p>\n" +
        "</div>";
    if (options.isChenDu) {
        return getContent(options);
    }
    return content;
};
function getContent(options) {
    var indexs = [0, 0, 0, 0];
    var marginLeft = [-1, 0, 0, 0];
    if (options.showType.indexOf("财损") >= 0) {
        indexs[0] = 1;
    }
    if (options.showType.indexOf("轻伤") >= 0) {
        indexs[1] = 1;
    }
    if (options.showType.indexOf("重伤") >= 0) {
        indexs[2] = 1;
    }
    if (options.showType.indexOf("死亡") >= 0) {
        indexs[3] = 1;
    }
    marginLeft[0] += indexs[0];
    for (var i = 1; i < 4; i++) {
        marginLeft[i] += marginLeft[i - 1] + indexs[i];
    }
    var dis = [];
    for (var i = 0; i < 4; i++) {
        if (indexs[i] == 0) {
            dis[i] = "none";
        } else {
            dis[i] = "block";
        }
    }
    // console.log("marginLeft:" + marginLeft);
    // console.log(indexs);
    var content2 = "<div style=\"height: 200px;width: 100px;\">\n" +
        "         <div class=\"barcontain\">\n" +
        "            <div class=\"barchild\" style=\"left:" + marginLeft[0] * 20 + "px;display: " + dis[0] + ";\">\n" +
        "               <p style=\"margin:auto;text-align: center;color: white;\">" + options.wealthLoss + "</p>\n" +
        "               <div style=\"margin:auto;width:20px;height:" + getHeight(options.wealthLoss, options.accidentNumbers) + "px;background: green;\"></div>\n" +
        "            </div>\n" +
        "            <div class=\"barchild\" style=\"left: " + marginLeft[1] * 20 + "px;display: " + dis[1] + ";\">\n" +
        "               <p style=\"margin:auto;text-align: center;color: white;\">" + options.slightInjury + "</p>\n" +
        "               <div style=\"margin:auto;width:20px;height:" + getHeight(options.slightInjury, options.accidentNumbers) + "px;background: blue;\"></div>\n" +
        "            </div>\n" +
        "            <div class=\"barchild\" style=\"left: " + marginLeft[2] * 20 + "px;display: " + dis[2] + "\">\n" +
        "               <p style=\"margin:auto;text-align: center;color: white;\">" + options.seriousInjury + "</p>\n" +
        "               <div style=\"margin:auto;width:20px;height:" + getHeight(options.seriousInjury, options.accidentNumbers) + "px;background: yellow;\"></div>\n" +
        "            </div>\n" +
        "            <div class=\"barchild\" style=\"left: " + marginLeft[3] * 20 + "px;display: " + dis[3] + "\">\n" +
        "               <p style=\"margin:auto;text-align: center;color: white;\">" + options.death + "</p>\n" +
        "               <div style=\"margin:auto;width:20px;height:" + getHeight(options.death, options.accidentNumbers) + "px;background: olive;\"></div>\n" +
        "            </div>\n" +
        "         </div>\n" +
        "         <p style=\"text-align: center;margin: auto;color: white;\">" + options.name + "</p>\n" +
        "      </div>"
    return content2;
}

/*
    * 返回颜色，红黄蓝绿
    * */
function getColor(number,allNumbers) {
    var lev = (number/allNumbers)*10;
   // console.log("lev:---"+lev);
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
function getHeight(number,allNumbers) {
    var lev = (number/allNumbers)*100;
    return lev;
}
//清除marker
//clearMarker(timeMap)
function clearMarker(amap) {
    console.log("mapmarker:"+mapMarkers.length);
    amap.remove(mapMarkers);
    mapMarkers = [];
    // mapMarkers.clear();
}

