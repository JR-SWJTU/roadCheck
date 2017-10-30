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
        document.getElementById('printDiv').innerHTML = localStorage.obj;
        // setTimeout(function () {
        //     window.print();
        //     window.close();
        // }, 10);
    }
})