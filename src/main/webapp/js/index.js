/**
 * Created by Leo on 2017/10/19.
 */
var webBase = '/roadCheck'

var app = new Vue({
    el: '#app',
    data: {
        wrapWidth: 0,
        wrapHeight: 0,

        singleTab: 'gruppe',
        singleShowSelect: false,

        basicData: {
            analysisObj: ['交叉口', '路段'],
            accidentalSev: ['仅财损', '轻伤', '重伤', '死亡'],
            area: {
                gruppe: [],
                administrative: [],
                intersection: [],
                crossing: []
            },

            roadGrade: ['null', '主干道', '快速路', '次干道', '支路', '高速公路', '国道', '省道', '县道', '乡村公路'],
            accident: {
                type: ['非碰撞', '撞人、撞机动车或其他非固定物', '碰撞固定物'],
                detail: {
                    nonCollision: ['翻车', '坠落', '火灾', '爆炸	', '淹没', '其它非碰撞'],
                    collision: ['机动车', '行人', '摩托车', '电动车', '自行车', '动物', '其它非固定物'],
                    solidCollision: ['防撞墩/桶', '护栏', '桥梁栏杆', '路缘石', '隔离墩', '信号灯杆', '路灯杆', '标志牌柱', '树木', '其它固定物']
                }
            },
            carCollisionType: ['null', '追尾碰撞', '正面碰撞	', '侧面碰撞', '直角碰撞', '刮擦', '其它'],
            weather: ['null', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'],
            workZone: {
                flag: ['是', '否'],
                controlMode: ['单向车道关闭', '单向车道压缩'],
                worker: ['是', '否'],
                lawEnfor: ['无', '有']
            },
            intersectionType: ['null', '非交叉口', '十字', 'T形', 'Y形', '环岛', '多路交叉口' ,'立交'],
            vehicleType: ['null', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'],
            hitAndRun: ['是', '否'],

            bali: []
        },

        detailDialog: false,

        selectData: {
            analysisObj: '交叉口', //'交叉口',
            area: {
                type: 'gruppe', //'gruppe',
                value: ''
            },
            accidentalSev: [], //'仅财损',
            workDay: false,
            dateTime: {
                start: '',
                end: ''
            },
            yType: 'accidentCount',
            timePrecision: 1,

            roadGrade: 'null', //'主干道',
            accident: {
                type: '',
                value: ''
            },
            carCollisionType: 'null', //'追尾碰撞',
            weather: 'null', //'晴天',
            workZone: {
                flag: '否',
                controlMode: '',
                worker: '',
                lawEnfor: ''
            },
            intersectionType: 'null', //'非交叉口',
            vehicleType: 'null', //'小客车',
            hitAndRun: '否', //'是'
        },

        isChartShow: false,
        singleShowData: {
            accTable: {
                key: ['', '仅财损', '轻伤', '重伤', '死亡', '未知', '总数'],
                value: ['数量', 0, 0, 0, 0, 0, 0]
            },
            accTypeTable: {
                key: ['', '撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞', '总数'],
                value: ['数量', 0, 0, 0, 0]
            },
            weaTable: {
                key: ['', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风', '总数'],
                value: ['数量', 0, 0, 0, 0, 0, 0, 0, 0]
            },
            carTable: {
                key: ['', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车', '总数'],
                value: ['数量', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            }
        },

        loginInfor: {
            userName: '',
            password: ''
        },

        isFirstLoad: false,
        isShowItems: false,

        loginDialog: false,
        isLogin: true,

        nowFuc: 'main-page',

        textFlag: true,
        showMessageTop: false,
        messageTop: ''
    },
    methods: {
        initPage: function () {
            this.wrapWidth = window.innerWidth;
            this.wrapHeight = window.innerHeight - 64;
        },
        toggleFuc: function () {
            if(!this.isFirstLoad){
                this.isFirstLoad = true;
            }
            this.isShowItems = !this.isShowItems;
        },

        getTeams: function () {
            var that = this;
            var url = webBase + '/teams';
            axios.get(url, {
            }).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    var data = allData.data;
                    var teams = [];
                    data.forEach(function (item, index, array) {
                        teams.push(item.teamName);
                    })
                    that.$set(that.basicData.area, 'gruppe', teams);
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        getRegions: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/regions';
            axios.get(url, {
            }).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    that.$set(that.basicData.area, 'administrative', allData.data);
                    // that.basicData.area.administrative = allData.data;
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        getIntersections: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/crossings';
            axios.get(url, {
            }).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    that.$set(that.basicData.area, 'intersection', allData.data);
                    // that.basicData.area.administrative = allData.data;
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        getCorssings: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/ordinaryRoads';
            axios.get(url, {
            }).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    that.$set(that.basicData.area, 'crossing', allData.data);
                    // that.basicData.area.administrative = allData.data;
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        checkLogin: function () {
            // this.isLogin = false;
            // this.loginDialog = true;
        },
        login: function () {
            this.loginDialog = true;
        },
        logout: function () {
            this.isLogin = false;
            this.loginDialog = true;
        },
        loginConfirm: function () {
            //loginInfor.userName, loginInfor.password
            var that = this;
            var url = webBase + '/admin/login';
            axios.post(url, {
                name: that.loginInfor.userName,
                password: that.loginInfor.password
            }).then(function (response) {
                if(response.data == ''){
                    that.messageTop = "账号或密码输入错误，请重新登录！";
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
                else{
                    that.loginDialog = false;
                    that.isLogin = true;
                    that.messageTop = "登录成功！";
                    that.textFlag = true;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        loginCancel: function () {
            this.loginDialog = false;
        },
        details: function () {
            this.detailDialog = true;
        },
        detailConfirm: function () {
            this.detailDialog = false;
        },
        detailClose: function () {
            this.detailDialog = false;
        },
        information: function () {
            console.log('information');
        },
        blackPointDiagnose: function () {
            this.nowFuc = 'black-point';
            this.resetObj();
        },
        singleAnalysis: function () {
            this.nowFuc = 'single-point';
            this.resetObj();
        },
        singleTabChange: function (val) {
            this.singleShowSelect = false;
            this.singleTab = val;
            this.resetSingleShowData();
            this.resetObj();
            switch(val){
                case 'gruppe': {
                    this.getTeams();
                    break;
                }
                case 'administrative': {
                    this.getRegions();
                    break;
                }
                case 'intersection': {
                    this.getIntersections();
                    break;
                }
                case 'crossing': {
                    this.getCorssings();
                    break;
                }
                default:
                    break;
            }
        },
        closeSingleShow: function () {
            this.singleShowSelect = false;
        },
        openSingleShow: function () {
            this.singleShowSelect = true;
        },
        spaceAnalysis: function () {
            this.nowFuc = 'space';
            this.resetObj();
        },
        timeAnalysis: function () {
            this.nowFuc = 'time';
            this.resetObj();
        },
        highStatistics: function () {
            this.nowFuc = 'statistics';
        },
        workDayChange: function (val) {
            this.selectData.workDay = val;
        },
        areaRadioChange: function (val) {
            this.selectData.area.value = '';
        },
        accidentLChange: function () {
            this.selectData.accidentalSev = [];
        },
        disableWeekends: function (date) {
            if(this.selectData.workDay){
                return date.getDay() === 0 || date.getDay() === 6;
            }
            else{
                return null;
            }
        },
        resetObj: function () {
            this.selectData = {
                analysisObj: '交叉口', //'交叉口',
                    area: {
                    type: 'gruppe', //'gruppe',
                        value: ''
                },
                accidentalSev: [], //'仅财损',
                    workDay: false,
                    dateTime: {
                    start: '',
                        end: ''
                },
                yType: 'accidentCount',
                    timePrecision: 1,

                    roadGrade: 'null', //'主干道',
                    accident: {
                    type: '',
                        value: ''
                },
                carCollisionType: 'null', //'追尾碰撞',
                    weather: 'null', //'晴天',
                    workZone: {
                    flag: '否',
                        controlMode: '',
                        worker: '',
                        lawEnfor: ''
                },
                intersectionType: 'null', //'非交叉口',
                    vehicleType: 'null', //'小客车',
                    hitAndRun: '否', //'是'
            };
        },
        checkInput: function (json) {
            if(this.nowFuc == 'black-point' || this.nowFuc == 'space' || this.nowFuc == 'time'){
                json.roadType = this.selectData.analysisObj;
                if(this.selectData.area.type == 'gruppe'){
                    if(this.selectData.area.value != ''){
                        json.teamName = [];
                        json.teamName.push(this.selectData.area.value);
                    }
                    else{
                        this.messageTop = "大队尚未选取！";
                        this.textFlag = false;
                        this.showMessageTop = true;
                        return false;
                    }
                }
                else if(this.selectData.area.type == 'administrative'){
                    if(this.selectData.area.value != ''){
                        json.areaName = this.selectData.area.value;
                    }
                    else{
                        this.messageTop = "行政区尚未选取！";
                        this.textFlag = false;
                        this.showMessageTop = true;
                        return false;
                    }
                }
            }

            if(this.nowFuc == 'single-point'){
                if(this.selectData.area.value == ''){
                    switch(this.singleTab){
                        case 'gruppe': {
                            this.messageTop = "大队管辖区尚未选取！";
                            break;
                        }
                        case 'administrative': {
                            this.messageTop = "行政区尚未选取！";
                            break;
                        }
                        case 'intersection': {
                            this.messageTop = "交叉口尚未选取！";
                            break;
                        }
                        case 'crossing': {
                            this.messageTop = "路段尚未选取！";
                            break;
                        }
                        default:
                            break;
                    }
                    this.textFlag = false;
                    this.showMessageTop = true;
                    return false;
                }
                switch(this.singleTab){
                    case 'gruppe': {
                        json.teamName = [];
                        json.teamName.push(this.selectData.area.value);
                        break;
                    }
                    case 'administrative': {
                        json.areaName = this.selectData.area.value;
                        break;
                    }
                    case 'intersection': {
                        json.roadType = this.selectData.area.value;
                        break;
                    }
                    case 'crossing': {
                        json.roadType = this.selectData.area.value;
                        break;
                    }
                    default:
                        break;
                }
            }

            if(this.nowFuc == 'black-point' || this.nowFuc == 'single-point' || this.nowFuc == 'space' || this.nowFuc == 'time'){
                if(this.selectData.dateTime.start != ''){
                    json.startTime = this.selectData.dateTime.start;
                }
                else{
                    this.messageTop = "起始监测日期尚未选取！";
                    this.textFlag = false;
                    this.showMessageTop = true;
                    return false;
                }
                if(this.selectData.dateTime.end != ''){
                    json.endTime = this.selectData.dateTime.end;
                }
                else{
                    this.messageTop = "截止监测日期尚未选取！";
                    this.textFlag = false;
                    this.showMessageTop = true;
                    return false;
                }
            }

            if(this.nowFuc == 'space' || this.nowFuc == 'time'){
                if(this.selectData.roadGrade != 'null'){
                    json.roadLevel = this.selectData.roadGrade;
                }
                if(this.selectData.carCollisionType != 'null'){
                    json.carCollisionType = this.selectData.carCollisionType;
                }
                if(this.selectData.weather != 'null'){
                    json.weather = this.selectData.weather;
                }
                if(this.selectData.workZone.flag != 'null'){
                    json.workPlaceRel = this.selectData.workZone.flag;
                }
                if(this.selectData.intersectionType != 'null'){
                    json.intersectionType = this.selectData.intersectionType;
                }
                if(this.selectData.vehicleType != 'null'){
                    json.carType = this.selectData.vehicleType;
                }
                if(this.selectData.hitAndRun != 'null'){
                    json.troEscape = this.selectData.hitAndRun;
                }
            }

            if(this.nowFuc == 'space'){
                if(this.selectData.workDay){
                    json.isWorkDay = 1;
                }
                if(this.selectData.yType == 'accidentCount'){
                    json.yType = true;
                }
                else{
                    json.yType = false;
                }
            }

            if(this.nowFuc == 'time' || this.nowFuc == 'space'){
                if(this.selectData.yType == 'accidentCount'){
                    json.yType = true;
                }
                else{
                    if(this.selectData.accidentalSev.length > 0){
                        json.yType = false;
                        this.selectData.accidentalSev.forEach(function (item, index, array) {
                            switch(item){
                                case '仅财损': {
                                    json.propertyLoss = 1;
                                    break;
                                }
                                case '轻伤': {
                                    json.slightInjury = 1;
                                    break;
                                }
                                case '重伤': {
                                    json.severInjury = 1;
                                    break;
                                }
                                case '死亡': {
                                    json.dead = 1;
                                    break;
                                }
                                default:
                                    break;
                            }
                        })
                    }
                    else{
                        this.messageTop = "纵坐标为‘事故严重程度’，其不可为空！";
                        this.textFlag = false;
                        this.showMessageTop = true;
                        return false;
                    }
                }
            }

            if(this.nowFuc == 'time'){
                json.timePrecision = this.selectData.timePrecision;
            }
            return true;
        },
        resetSingleShowData: function () {
            this.singleShowData = {
                accTable: {
                    key: ['', '仅财损', '轻伤', '重伤', '死亡', '未知', '总数'],
                        value: ['数量', 0, 0, 0, 0, 0, 0]
                },
                accTypeTable: {
                    key: ['', '撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞', '总数'],
                        value: ['数量', 0, 0, 0, 0]
                },
                weaTable: {
                    key: ['', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风', '总数'],
                        value: ['数量', 0, 0, 0, 0, 0, 0, 0, 0]
                },
                carTable: {
                    key: ['', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车', '总数'],
                        value: ['数量', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                }
            };
            this.isChartShow = false;
        },
        getAccObj: function (data) {
            var obj = ['数量'];
            data.severity.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '仅财损':{
                        obj[1] = item.num;
                        break;
                    }
                    case '轻伤':{
                        obj[2] = item.num;
                        break;
                    }
                    case '重伤':{
                        obj[3] = item.num;
                        break;
                    }
                    case '死亡':{
                        obj[4] = item.num;
                        break;
                    }
                    case '未知':{
                        obj[5] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            obj.push(data.totalNum);
            return obj;
        },
        getAccHObj: function (data) {
            var obj = {
                name: '',
                data: []
            };
            obj.data.push(data.totalNum);
            data.severity.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '仅财损':{
                        obj.data[1] = item.num;
                        break;
                    }
                    case '轻伤':{
                        obj.data[2] = item.num;
                        break;
                    }
                    case '重伤':{
                        obj.data[3] = item.num;
                        break;
                    }
                    case '死亡':{
                        obj.data[4] = item.num;
                        break;
                    }
                    case '未知':{
                        obj.data[5] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getAccPObj: function (data) {
            var obj = [];
            data.severity.forEach(function (item, index, arr) {
                var temp;
                switch (item.keyRes){
                    case '仅财损':{
                        temp = ['仅财损'];
                        temp.push(item.num / data.totalNum);
                        obj[0] = temp;
                        break;
                    }
                    case '轻伤':{
                        temp = ['轻伤'];
                        temp.push(item.num / data.totalNum);
                        obj[1] = temp;
                        break;
                    }
                    case '重伤':{
                        temp = ['重伤'];
                        temp.push(item.num / data.totalNum);
                        obj[2] = temp;
                        break;
                    }
                    case '死亡':{
                        temp = ['死亡'];
                        temp.push(item.num / data.totalNum);
                        obj[3] = temp;
                        break;
                    }
                    case '未知':{
                        temp = ['未知'];
                        temp.push(item.num / data.totalNum);
                        obj[4] = temp;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getAccTObj: function (data) {
            var obj = ['数量'];
            //'撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞'
            data.accidentType.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '撞人、撞机动车或其他非固定物':{
                        obj[1] = item.num;
                        break;
                    }
                    case '碰撞固定物':{
                        obj[2] = item.num;
                        break;
                    }
                    case '非碰撞':{
                        obj[3] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            obj.push(data.totalNum);
            return obj;
        },
        getAccTHObj: function (data) {
            var obj = {
                name: '',
                data: []
            };
            obj.data.push(data.totalNum);
            //'撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞'
            data.accidentType.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '撞人、撞机动车或其他非固定物':{
                        obj.data[1] = item.num;
                        break;
                    }
                    case '碰撞固定物':{
                        obj.data[2] = item.num;
                        break;
                    }
                    case '非碰撞':{
                        obj.data[3] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getAccTPObj: function (data) {
            var obj = [];
            //'撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞'
            data.accidentType.forEach(function (item, index, arr) {
                var temp;
                switch (item.keyRes){
                    case '撞人、撞机动车或其他非固定物':{
                        temp = ['撞人、撞机动车或其他非固定物'];
                        temp.push(item.num / data.totalNum);
                        obj[0] = temp;
                        break;
                    }
                    case '碰撞固定物':{
                        temp = ['碰撞固定物'];
                        temp.push(item.num / data.totalNum);
                        obj[1] = temp;
                        break;
                    }
                    case '非碰撞':{
                        temp = ['非碰撞'];
                        temp.push(item.num / data.totalNum);
                        obj[2] = temp;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getWeaObj: function (data) {
            var obj = ['数量'];
            //'晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'
            data.weather.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '晴天':{
                        obj[1] = item.num;
                        break;
                    }
                    case '阴天':{
                        obj[2] = item.num;
                        break;
                    }
                    case '雨':{
                        obj[3] = item.num;
                        break;
                    }
                    case '雾':{
                        obj[4] = item.num;
                        break;
                    }
                    case '雪':{
                        obj[5] = item.num;
                        break;
                    }
                    case '冰雹':{
                        obj[6] = item.num;
                        break;
                    }
                    case '台风':{
                        obj[7] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            obj.push(data.totalNum);
            return obj;
        },
        getWeaHObj: function (data) {
            var obj = {
                name: '',
                data: []
            };
            obj.data.push(data.totalNum);
            //'晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'
            data.weather.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '晴天':{
                        obj.data[1] = item.num;
                        break;
                    }
                    case '阴天':{
                        obj.data[2] = item.num;
                        break;
                    }
                    case '雨':{
                        obj.data[3] = item.num;
                        break;
                    }
                    case '雾':{
                        obj.data[4] = item.num;
                        break;
                    }
                    case '雪':{
                        obj.data[5] = item.num;
                        break;
                    }
                    case '冰雹':{
                        obj.data[6] = item.num;
                        break;
                    }
                    case '台风':{
                        obj.data[7] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getWeaPObj: function (data) {
            var obj = [];
            //'晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'
            data.weather.forEach(function (item, index, arr) {
                var temp;
                switch (item.keyRes){
                    case '晴天':{
                        temp = ['晴天'];
                        temp.push(item.num / data.totalNum);
                        obj[0] = temp;
                        break;
                    }
                    case '阴天':{
                        temp = ['阴天'];
                        temp.push(item.num / data.totalNum);
                        obj[1] = temp;
                        break;
                    }
                    case '雨':{
                        temp = ['雨'];
                        temp.push(item.num / data.totalNum);
                        obj[2] = temp;
                        break;
                    }
                    case '雾':{
                        temp = ['雾'];
                        temp.push(item.num / data.totalNum);
                        obj[3] = temp;
                        break;
                    }
                    case '雪':{
                        temp = ['雪'];
                        temp.push(item.num / data.totalNum);
                        obj[4] = temp;
                        break;
                    }
                    case '冰雹':{
                        temp = ['冰雹'];
                        temp.push(item.num / data.totalNum);
                        obj[5] = temp;
                        break;
                    }
                    case '台风':{
                        temp = ['台风'];
                        temp.push(item.num / data.totalNum);
                        obj[6] = temp;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getCarObj: function (data) {
            var obj = ['数量'];
            //'小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'
            data.carType.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '小客车':{
                        obj[1] = item.num;
                        break;
                    }
                    case '中客车':{
                        obj[2] = item.num;
                        break;
                    }
                    case '大客车':{
                        obj[3] = item.num;
                        break;
                    }
                    case '公交':{
                        obj[4] = item.num;
                        break;
                    }
                    case '校车':{
                        obj[5] = item.num;
                        break;
                    }
                    case '小货车':{
                        obj[6] = item.num;
                        break;
                    }
                    case '中货车':{
                        obj[7] = item.num;
                        break;
                    }
                    case '大货车':{
                        obj[8] = item.num;
                        break;
                    }
                    case '拖挂车':{
                        obj[9] = item.num;
                        break;
                    }
                    case '特种车辆':{
                        obj[10] = item.num;
                        break;
                    }
                    case '摩托车':{
                        obj[11] = item.num;
                        break;
                    }
                    case '非机动车':{
                        obj[12] = item.num;
                        break;
                    }
                    case '畜力车':{
                        obj[13] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            obj.push(data.totalNum);
            return obj;
        },
        getCarHObj: function (data) {
            var obj = {
                name: '',
                data: []
            };
            obj.data.push(data.totalNum);
            //'小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'
            data.carType.forEach(function (item, index, arr) {
                switch (item.keyRes){
                    case '小客车':{
                        obj.data[1] = item.num;
                        break;
                    }
                    case '中客车':{
                        obj.data[2] = item.num;
                        break;
                    }
                    case '大客车':{
                        obj.data[3] = item.num;
                        break;
                    }
                    case '公交':{
                        obj.data[4] = item.num;
                        break;
                    }
                    case '校车':{
                        obj.data[5] = item.num;
                        break;
                    }
                    case '小货车':{
                        obj.data[6] = item.num;
                        break;
                    }
                    case '中货车':{
                        obj.data[7] = item.num;
                        break;
                    }
                    case '大货车':{
                        obj.data[8] = item.num;
                        break;
                    }
                    case '拖挂车':{
                        obj.data[9] = item.num;
                        break;
                    }
                    case '特种车辆':{
                        obj.data[10] = item.num;
                        break;
                    }
                    case '摩托车':{
                        obj.data[11] = item.num;
                        break;
                    }
                    case '非机动车':{
                        obj.data[12] = item.num;
                        break;
                    }
                    case '畜力车':{
                        obj.data[13] = item.num;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        getCarPObj: function (data) {
            var obj = [];
            //'小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'
            data.carType.forEach(function (item, index, arr) {
                var temp;
                switch (item.keyRes){
                    case '小客车':{
                        temp = ['小客车'];
                        temp.push(item.num / data.totalNum);
                        obj[0] = temp;
                        break;
                    }
                    case '中客车':{
                        temp = ['中客车'];
                        temp.push(item.num / data.totalNum);
                        obj[1] = temp;
                        break;
                    }
                    case '大客车':{
                        temp = ['大客车'];
                        temp.push(item.num / data.totalNum);
                        obj[2] = temp;
                        break;
                    }
                    case '公交':{
                        temp = ['公交'];
                        temp.push(item.num / data.totalNum);
                        obj[3] = temp;
                        break;
                    }
                    case '校车':{
                        temp = ['校车'];
                        temp.push(item.num / data.totalNum);
                        obj[4] = temp;
                        break;
                    }
                    case '小货车':{
                        temp = ['小货车'];
                        temp.push(item.num / data.totalNum);
                        obj[5] = temp;
                        break;
                    }
                    case '中货车':{
                        temp = ['中货车'];
                        temp.push(item.num / data.totalNum);
                        obj[6] = temp;
                        break;
                    }
                    case '大货车':{
                        temp = ['大货车'];
                        temp.push(item.num / data.totalNum);
                        obj[7] = temp;
                        break;
                    }
                    case '拖挂车':{
                        temp = ['拖挂车'];
                        temp.push(item.num / data.totalNum);
                        obj[8] = temp;
                        break;
                    }
                    case '特种车辆':{
                        temp = ['特种车辆'];
                        temp.push(item.num / data.totalNum);
                        obj[9] = temp;
                        break;
                    }
                    case '摩托车':{
                        temp = ['摩托车'];
                        temp.push(item.num / data.totalNum);
                        obj[10] = temp;
                        break;
                    }
                    case '非机动车':{
                        temp = ['非机动车'];
                        temp.push(item.num / data.totalNum);
                        obj[11] = temp;
                        break;
                    }
                    case '畜力车':{
                        temp = ['畜力车'];
                        temp.push(item.num / data.totalNum);
                        obj[12] = temp;
                        break;
                    }
                    default:
                        break;
                }
            });
            return obj;
        },
        singleShow: function (data) {
            //事故数、事故严重程度汇总
            this.$set(this.singleShowData.accTable, 'value', this.getAccObj(data));
            //事故数、事故严重程度柱状图
            var xAxis = ['总数', '仅损财', '轻伤', '重伤', '死亡', '未知'];
            this.getHistogram('accHistogram', '事故数、事故严重程度柱状图', xAxis, [this.getAccHObj(data)]);
            //事故数、事故严重程度扇形图
            this.getPie('accPie', '事故数、事故严重程度扇形图', {
                title: '事故严重程度',
                value: ['仅财损', '轻伤', '重伤', '死亡', '未知']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '所属严重程度事故数占比',
                data: this.getAccPObj(data)
            }]);

            //事故类型汇总
            this.$set(this.singleShowData.accTypeTable, 'value', this.getAccTObj(data));
            //事故类型柱状图
            xAxis = ['总数', '撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞'];
            this.getHistogram('accTypeHistogram', '事故类型柱状图', xAxis, [this.getAccTHObj(data)]);
            //事故类型扇形图
            this.getPie('accTypePie', '事故类型扇形图', {
                title: '事故类型',
                value: ['撞人、撞机动车或其他非固定物', '碰撞固定物', '非碰撞']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '所属事故类型事故数占比',
                data: this.getAccPObj(data)
            }]);

            //天气情况事故汇总
            this.$set(this.singleShowData.weaTable, 'value', this.getWeaObj(data));
            //天气情况事故柱状图
            xAxis = ['总数', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'];
            this.getHistogram('weaHistogram', '天气情况事故柱状图', xAxis, [this.getWeaHObj(data)]);
            //天气情况事故扇形图
            this.getPie('weaPie', '天气情况事故扇形图', {
                title: '事故类型',
                value: ['晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '所属天气事故数占比',
                data: this.getWeaPObj(data)
            }]);

            //车辆事故汇总
            this.$set(this.singleShowData.carTable, 'value', this.getCarObj(data));
            //车辆事故柱状图
            xAxis = ['总数', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'];
            this.getHistogram('carHistogram', '车辆事故柱状图', xAxis, [this.getCarHObj(data)]);
            //车辆事故扇形图
            this.getPie('carPie', '车辆事故扇形图', {
                title: '事故类型',
                value: ['小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '该车辆事故数占比',
                data: this.getCarPObj(data)
            }]);

            this.isChartShow = true;
            this.singleShowSelect = false;
        },
        getHistogram: function (id, title, xAxis, series) {
            return new Highcharts.Chart(id, {
                chart: {
                    type: 'column'
                },
                title: {
                    text: title
                },
                xAxis: {
                    categories: xAxis
                },
                credites: {
                    enabled: true
                },
                plotOptions:{
                    column:{
                        dataLabel:{
                            enabled: true,
                            inside: true
                        }
                    }
                },
                series: series
            });
        },
        getPie: function (id, title, xAxis, yAxis, series) {
            return new Highcharts.Chart(id, {
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: title
                },
                tooltip: {
                    headerFormat: '{series.name}<br>',
                    pointFormat: '{point.name}: 事故数占<b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                            }
                        },
                        states: {
                            hover: {
                                enabled: false
                            }
                        },
                        slicedOffset: 20,
                        point: {
                            events: {
                                mouseOver: function() {
                                    this.slice();
                                },
                                mouseOut: function() {
                                    this.slice();
                                },
                                click: function() {
                                    return false;
                                }
                            }
                        }
                    }
                },
                xAxis: {
                    title: {
                        text: xAxis.title
                    },
                    categories: xAxis.value
                },
                yAxis: {
                    title: {
                        text: yAxis.title
                    }
                },
                series: series
            });
        },
        blackPointGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/results';
            var json = {};
            var flag = this.checkInput(json);
            console.log(json);
            if(flag){
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        console.log(allData.data);
                    }
                    else{
                        console.log(allData.message);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        singlePointGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/singlePointAnalyseDataQuery';
            var json = {};
            var flag = this.checkInput(json);
            console.log(json);
            if(flag){
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        console.log(allData.data);
                        that.singleShow(allData.data);
                    }
                    else{
                        console.log(allData.message);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        spaceGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/areaMultiConditionQuery';
            var json = {};
            var flag = this.checkInput(json);
            console.log(json);
            if(flag){
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        console.log(allData.data);
                    }
                    else{
                        console.log(allData.message);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        },
        timeGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/timeMultiConditionQuery';
            var json = {};
            var flag = this.checkInput(json);
            console.log(json);
            if(flag){
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        console.log(allData.data);
                    }
                    else{
                        console.log(allData.message);
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    },
    computed: {
        bodyContent: function () {
            return {
                'height': this.wrapHeight + 'px',
                'overflow': 'auto'
            };
        },
        rightStyle: function () {
            return {
                'width': this.wrapWidth - 30 - (this.isShowItems ? 256 : 8) + 'px',
                'height': this.wrapHeight - 15 + 'px'
            }
        },
        singleRightStyle: function () {
            return {
                'width': this.wrapWidth - 30 - (this.isShowItems ? 256 : 8) + 'px',
            }
        },
        chartStyle: function () {
            return {
                'width': this.wrapWidth - 30 - 2 - 20 - (this.isShowItems ? 256 : 8) + 'px'
            }
        },
        singleContent: function () {
            return {
                'min-height': this.wrapHeight - 63 + 'px'
            }
        }
    },
    watch: {
        showMessageTop: function (val, oldVal) {
            if (val)
            {
                var that = this;
                setTimeout(function () {
                    that.showMessageTop = false;
                }, 1500);
            }
        }
    },
    mounted: function () {
        this.initPage();
        this.checkLogin();
        this.getTeams();
        this.getRegions();
        this.getIntersections();
        this.getCorssings();
        var that = this;
        addEventListener('resize', function () {
            that.initPage();
        });
    }
});

