document.ready = function (callback) {
    ///兼容FF,Google
    if (document.addEventListener) {
        document.addEventListener('DOMContentLoaded', function () {
            document.removeEventListener('DOMContentLoaded', arguments.callee, false);
            callback();
        }, false)
    }
    //兼容IE
    else if (document.attachEvent) {
        document.attachEvent('onreadystatechange', function () {
            if (document.readyState == "complete") {
                document.detachEvent("onreadystatechange", arguments.callee);
                callback();
            }
        })
    }
    else if (document.lastChild == document.body) {
        callback();
    }
}
document.ready(function () {
    console.log(localStorage.obj);
    if(localStorage.obj){
        document.title = localStorage.title;
        document.getElementById('printDiv').innerHTML = localStorage.obj;
        var xDPI = new Array;
        if (window.screen.deviceXDPI) {
            xDPI = window.screen.deviceXDPI;
        }
        else {
            var tmpNode = document.createElement("div");
            tmpNode.style.cssText = "width:1in;height:1in;position:absolute;left:0px;top:0px;z-index:99;visibility:hidden";
            document.body.appendChild(tmpNode);
            xDPI = parseInt(tmpNode.offsetWidth);
            tmpNode.parentNode.removeChild(tmpNode);
        }
        var zoom = localStorage.width * 25.4 / (210 - 30) / xDPI; // A4纸像素宽度 = 210 * xDPI / 25.4;
        document.getElementsByTagName('body')[0].style.zoom = 1 / zoom;
        setTimeout(function () {
            window.print();
            window.close();
        }, 10);
    }
})