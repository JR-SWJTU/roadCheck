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

// function markerOptions(tyep,name,lat,lng,accidentNumbers,wealthLoss,slightInjury,seriousInjury,death) {
//         this.tyep              = tyep                //类型0路段，1交叉口
//         this.name              = name                //名称
//         this.lat               = lat                 //经纬度
//         this.lng               = lng                 //经纬度
//         this.accidentNumbers  = accidentNumbers     //事故总数
//         this.wealthLoss       =  wealthLoss          //财损数量
//         this.slightInjury     = slightInjury        //轻伤数量
//         this.seriousInjury    = seriousInjury       //重伤数量
//         this.death             = death               //死亡数量
// }

// var m1 = new markerOptions();
//
// var m2 = new Object();
// m2.tyep = 0;
// m2.name = "";
// m2.lat = 0.0;
// m2.lng = 0.0;
// m2.accidentNumbers = "";
// m2.wealthLoss = "";
// m2.slightInjury = "";
// m2.seriousInjury = "";
// m2.death = "";
//
// console.log(m2.tyep)
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

// addMarker(spaceMap,"XXX路段1",[104.042584,30.582064],1,3)
// addMarker(spaceMap,"XXX交叉口2",[104.072584,30.472064],0,100)
// addMarker(spaceMap,"XXX路段3",[104.092584,30.692064],1,50)
//
// addMarker(blackPointMap,"XXX路段",[104.072584,30.472064],0,100)
// addMarker(blackPointMap,"XXX交叉口3",[104.092584,30.692064],1,50)
var mapMarkers = [];
if (mapMarkers == null || mapMarkers.length == 0) {
    mapMarkers = [];
}

/*
* 设置交叉口事故数大小
*传入参数为数量,全部事故数量
*
* amap,tyep,name,lat,lng,accidentNumbers,accidentAllNumbers,wealthLoss,slightInjury,seriousInjury,death
* */
var markerOptions = {
    map                  : spaceMap,            //地图
    type                 : 0           ,   //类型1路段，0交叉口
    name                 : "交叉口1"           ,   //名称
    lat                  : 104.072584            ,   //经纬度
    lng                  : 30.472064            ,   //经纬度
    isChenDu            : false,                   //是否为严重程度展示
    showType            : "财损,轻伤"     ,   //严重程度需要的展示内容
    accidentAllNumbers : 200,  //所有事故总数
    accidentNumbers     : 100 ,  //当前路段/交叉口事故总数
    wealthLoss          : 30     ,   //财损数量
    slightInjury        : 40    ,  //轻伤数量
    seriousInjury       : 20   ,  //重伤数量
    death                : 10              //死亡数量
};

setMarker(markerOptions);
function setMarker(options) {

    if (mapMarkers == null || mapMarkers.length == 0) {
        mapMarkers = [];
    }
    //获取展示内容
    var content;
    console.log("ok-----setMarker:type"+options.type);
    if (options.type == 0) {
        content = setIntersectionContent(options.accidentNumbers,options.accidentAllNumbers,options.name,options.isChenDu,options.showType);
    }else {
        content = setRoadContent(options.accidentNumbers,options.accidentAllNumbers,options.name);
    }
    console.log("ok-----setMarker")
    var marker = new AMap.Marker({
        map: options.map,
        position: [options.lat,options.lng],
        icon: new AMap.Icon({
            size: new AMap.Size(40, 50),  //图标大小
        }),
        content:content
    });
    console.log("ok-----push")
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

function setIntersectionContent(number,allNumbers,name,isChenDu,showType) {

    var content = "<div style=\"height: 150px;width: 100px\">\n" +
        "<div  style=\"margin: auto;width: "+getHeight(number,allNumbers)/2+"px;height: "+getHeight(number,allNumbers)/2+"px;background: "+getColor(number,allNumbers)+";border-radius:50%\"></div>" +
        "    <p style=\"width:100%;margin: auto;text-align: center;color:white;\">事故数："+number+"</p>\n" +
        "    <p style=\"width:100%;margin: auto;background:white;text-align: center;\">"+name+"</p>\n" +
        "</div>";
    //alert("ok");
    console.log("ok-----setIntersectionContent")
    if (isChenDu) {
        var indexs = [0,0,0,0] ;
        var content2 ="<div class=\"barcontain\">\n" +
            "         <div class=\"barchild\">\n" +
            "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
            "            <div style=\"margin:auto;width:30px;height:100px;background: red;\"></div>\n" +
            "            <p style=\"margin:auto;text-align: center;\">总数</p>\n" +
            "         </div>\n" +
            "         <div class=\"barchild\" style=\"left: 40px;\">\n" +
            "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
            "            <div style=\"margin:auto;width:30px;height:50px;background: green;\"></div>\n" +
            "            <p style=\"margin:auto;text-align: center;\">财损</p>\n" +
            "         </div>\n" +
            "         <div class=\"barchild\" style=\"left: 80px;\">\n" +
            "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
            "            <div style=\"margin:auto;width:30px;height:70px;background: blue;\"></div>\n" +
            "            <p style=\"margin:auto;text-align: center;\">轻伤</p>\n" +
            "         </div>\n" +
            "         <div class=\"barchild\" style=\"left: 120px;\">\n" +
            "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
            "            <div style=\"margin:auto;width:30px;height:50px;background: yellow;\"></div>\n" +
            "            <p style=\"margin:auto;text-align: center;\">重伤</p>\n" +
            "         </div>\n" +
            "         <div class=\"barchild\" style=\"left: 160px;\">\n" +
            "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
            "            <div style=\"margin:auto;width:30px;height:80px;background: olive;\"></div>\n" +
            "            <p style=\"margin:auto;text-align: center;\">死亡</p>\n" +
            "         </div>\n" +
            "      </div>"
        return content2;
    }
    return content;
}

function setRoadContent (number,allNumbers,name) {
    var content = "<div style=\"height: 200px;width: 100px\">\n" +
        "    <div id=\"bar\" style=\"width: 20px;height: "+getHeight(number,allNumbers)+"px;background: "+getColor(number,allNumbers)+"; margin: auto\"></div>\n" +
        "    <p style=\"width:100%;margin: auto;text-align: center;color: "+"white"+"\">事故数："+number+"</p>\n" +
        "    <p style=\"width:100%;margin: auto;background:white;text-align: center;\">"+name+"</p>\n" +
        "</div>";
    return content;
};

function testContent() {
    var content ="<div class=\"barcontain\">\n" +
        "         <div class=\"barchild\">\n" +
        "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
        "            <div style=\"margin:auto;width:30px;height:100px;background: red;\"></div>\n" +
        "            <p style=\"margin:auto;text-align: center;\">总数</p>\n" +
        "         </div>\n" +
        "         <div class=\"barchild\" style=\"left: 40px;\">\n" +
        "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
        "            <div style=\"margin:auto;width:30px;height:50px;background: green;\"></div>\n" +
        "            <p style=\"margin:auto;text-align: center;\">财损</p>\n" +
        "         </div>\n" +
        "         <div class=\"barchild\" style=\"left: 80px;\">\n" +
        "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
        "            <div style=\"margin:auto;width:30px;height:70px;background: blue;\"></div>\n" +
        "            <p style=\"margin:auto;text-align: center;\">轻伤</p>\n" +
        "         </div>\n" +
        "         <div class=\"barchild\" style=\"left: 120px;\">\n" +
        "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
        "            <div style=\"margin:auto;width:30px;height:50px;background: yellow;\"></div>\n" +
        "            <p style=\"margin:auto;text-align: center;\">重伤</p>\n" +
        "         </div>\n" +
        "         <div class=\"barchild\" style=\"left: 160px;\">\n" +
        "            <p style=\"margin:auto;text-align: center;\">111</p>\n" +
        "            <div style=\"margin:auto;width:30px;height:80px;background: olive;\"></div>\n" +
        "            <p style=\"margin:auto;text-align: center;\">死亡</p>\n" +
        "         </div>\n" +
        "      </div>"
    return content;
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
    console.log("mapmarker:"+mapMarkers.length)
    amap.remove(mapMarkers);
    mapMarkers = [];
    // mapMarkers.clear();
}

