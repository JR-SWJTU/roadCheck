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
                administrative: []
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
        },
        singleAnalysis: function () {
            this.nowFuc = 'single-point';
        },
        singleTabChange: function (val) {
            console.log(val);
            this.singleTab = val;
        },
        closeSingleShow: function () {
            this.singleShowSelect = false;
        },
        openSingleShow: function () {
            this.singleShowSelect = true;
        },
        spaceAnalysis: function () {
            this.nowFuc = 'space';
        },
        timeAnalysis: function () {
            this.nowFuc = 'time';
        },
        highStatistics: function () {
            this.nowFuc = 'statistics';
        },
        workDayChange: function (val) {
            this.selectData.workDay = val;
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
            console.log('resetObj');
        },
        checkInput: function (json) {
            if(this.nowFuc == 'black-point' || this.nowFuc == 'single-point' || this.nowFuc == 'space' || this.nowFuc == 'time'){
                json.roadType = this.selectData.analysisObj;
                if(this.selectData.area.type == 'gruppe'){
                    if(this.selectData.area.value != ''){
                        json.teamName = this.selectData.area.value;
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
            console.log('single-point-get');
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
        var that = this;
        addEventListener('resize', function () {
            that.initPage();
        });
    }
});

