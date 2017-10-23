/**
 * Created by Leo on 2017/10/19.
 */
var app = new Vue({
    el: '#app',
    data: {
        wrapWidth: 0,
        wrapHeight: 0,
        basicData: {
            analysisObj: ['交叉口', '路段'],
            accidentalSev: ['仅财损', '轻伤', '重伤', '死亡'],
            area: {
                gruppe: ['大队1', '大队2'],
                administrative: ['行政区域1', '行政区域2']
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
            analysisObj: '',
            area: {
                type: '',
                value: ''
            },
            accidentalSev: '',

            roadGrade: '',
            accident: {
                type: '',
                value: ''
            },
            weather: '',
            workZone: {
                flag: '',
                controlMode: '',
                worker: '',
                lawEnfor: ''
            },
            intersectionType: '',
            vehicleType: '',
            hitAndRun: ''
        },

        isFirstLoad: false,
        isShowItems: false,

        loginDialog: false,
        isLogin: true,

        nowFuc: 'main-page'
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
        login: function () {
            this.loginDialog = true;
        },
        logout: function () {
            this.isLogin = false;
            this.loginDialog = true;
        },
        loginConfirm: function () {
            this.isLogin = true;
            this.loginDialog = false;
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
        resetObj: function () {
            console.log('resetObj');
        },
        blackPointGet: function () {
            console.log('blackPointGet');
        },
        spaceGet: function () {
            console.log('spaceGet');
        },
        timeGet: function () {
            console.log('timeGet');
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

    },
    mounted: function () {
        this.initPage();
        var that = this;
        addEventListener('resize', function () {
            that.initPage();
        });
    }
});

var blackPointMap = new AMap.Map('blackPointMap', {
    resizeEnable: true,
    zoom:11,
    center: [116.40, 39.91]
});

var spaceMap = new AMap.Map('spaceMap', {
    resizeEnable: true,
    zoom:11,
    center: [116.40, 39.91]
});

var timeMap = new AMap.Map('timeMap', {
    resizeEnable: true,
    zoom:11,
    center: [116.40, 39.91]
});