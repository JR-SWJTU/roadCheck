/**
 * Created by Leo on 2017/10/19.
 */
var webBase = '/roadCheck'

var app = new Vue({
    el: '#app',
    data: {
        wrapWidth: 0,
        wrapHeight: 0,
        basicData: {
            analysisObj: ['交叉口', '路段'],
            accidentalSev: ['仅财损', '轻伤', '重伤', '死亡'],
            area: {
                gruppe: [],
                administrative: []
            },

            roadGrade: ['主干道', '快速路', '次干道', '支路', '高速公路', '国道', '省道', '县道', '乡村公路'],
            accident: {
                type: ['非碰撞', '撞人、撞机动车或其他非固定物', '碰撞固定物'],
                detail: {
                    nonCollision: ['翻车', '坠落', '火灾', '爆炸	', '淹没', '其它非碰撞'],
                    collision: ['机动车', '行人', '摩托车', '电动车', '自行车', '动物', '其它非固定物'],
                    solidCollision: ['防撞墩/桶', '护栏', '桥梁栏杆', '路缘石', '隔离墩', '信号灯杆', '路灯杆', '标志牌柱', '树木', '其它固定物']
                }
            },
            carCollisionType: ['追尾碰撞', '正面碰撞	', '侧面碰撞', '直角碰撞', '刮擦', '其它'],
            weather: ['晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'],
            workZone: {
                flag: ['是', '否'],
                controlMode: ['单向车道关闭', '单向车道压缩'],
                worker: ['是', '否'],
                lawEnfor: ['无', '有']
            },
            intersectionType: ['非交叉口', '十字', 'T形', 'Y形', '环岛', '多路交叉口' ,'立交'],
            vehicleType: ['小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'],
            hitAndRun: ['是', '否'],

            bali: ['地点1', '地点2', '地点3', '地点4']
        },

        detailDialog: false,

        selectData: {
            analysisObj: '', //'交叉口',
            area: {
                type: '', //'gruppe',
                value: ''
            },
            accidentalSev: '', //'仅财损',
            workDay: false,
            dateTime: {
                start: '',
                end: ''
            },

            roadGrade: '', //'主干道',
            accident: {
                type: '',
                value: ''
            },
            carCollisionType: '', //'追尾碰撞',
            weather: '', //'晴天',
            workZone: {
                flag: '是',
                controlMode: '',
                worker: '',
                lawEnfor: ''
            },
            intersectionType: '', //'非交叉口',
            vehicleType: '', //'小客车',
            hitAndRun: '', //'是'
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
                    that.basicData.area.gruppe = teams;
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
                    that.basicData.area.administrative = allData.data;
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        checkLogin: function () {
            this.isLogin = false;
            this.loginDialog = true;
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
        blackPointGet: function () {
            console.log('blackPointGet');
            console.log(this.selectData);
        },
        spaceGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/areaMultiConditionQuery';
            axios.post(url, {
                teamName: that.selectData.area.type == 'gruppe'? that.selectData.area.value: null,
                //areaName: that.selectData.area.type == 'administrative'? that.selectData.area.value: null,
                roadType: that.selectData.intersectionType,
                startTime: that.selectData.dateTime.start,
                // endTime: that.selectData.dateTime.end,
                yType: true
                // roadLevel: that.selectData.roadGrade,
                // carCollisionType: that.selectData.carCollisionType,
                // weather: that.selectData.weather,
                // workPlaceRel: that.selectData.workZone.flag,
                // carType: that.selectData.vehicleType,
                // troEscape: that.selectData.hitAndRun,
                // isWorkDay: that.selectData.workDay ? 1 : 0
            }).then(function (response) {
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
        },
        timeGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/timeMultiConditionQuery';
            axios.post(url, {
                teamName: that.selectData.area.type == 'gruppe'? that.selectData.area.value: null,
                areaName: that.selectData.area.type == 'administrative'? that.selectData.area.value: null,
                roadType: that.selectData.intersectionType,
                startTime: that.selectData.dateTime.start,
                endTime: that.selectData.dateTime.end,
                yType: false,
                roadLevel: that.selectData.roadGrade,
                weather: that.selectData.weather,
                workPlaceRel: that.selectData.workZone.flag,
                carType: that.selectData.vehicleType,
                timePrecision: 1,
                troEscape: that.selectData.hitAndRun,
                propertyLoss: 1
            }).then(function (response) {
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
    computed: {
        bodyContent: function () {
            return {
                'height': this.wrapHeight + 'px',
                'overflow': 'auto'
            };
        },
        mapStyle: function () {
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

