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
        blackShowSelect: true,
        singleShowSelect: false,
        spaceShowSelect: true,
        timeShowSelect: true,

        showDialogLoading: false,

        basicData: {
            analysisObj: ['交叉口', '路段'],
            accidentalSev: ['仅财损', '轻伤', '重伤', '死亡'],
            area: {
                gruppeId: [],
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
            carCollisionType: ['null', '追尾碰撞', '正面碰撞', '侧面碰撞', '直角碰撞', '刮擦', '其它'],
            weather: ['null', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'],
            workZone: {
                flag: ['null', '是', '否'],
                controlMode: ['单向车道关闭', '单向车道压缩'],
                worker: ['是', '否'],
                lawEnfor: ['无', '有']
            },
            intersectionType: ['null', '非交叉口', '十字', 'T形', 'Y形', '环岛', '多路交叉口' ,'立交'],
            vehicleType: ['null', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车辆', '摩托车', '非机动车', '畜力车'],
            hitAndRun: ['null', '是', '否'],

            bali: []
        },

        detailDialog: false,

        selectData: {
            analysisObj: '交叉口', //'交叉口',
            area: {
                type: 'administrative', //'gruppe',
                gruppeVal: [],
                adminiVal: ''
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
                flag: 'null',
                controlMode: '',
                worker: '',
                lawEnfor: ''
            },
            intersectionType: 'null', //'非交叉口',
            vehicleType: 'null', //'小客车',
            hitAndRun: 'null', //'是'
        },

        timeDownShow: false,

        isChartShow: false,
        chartPrintShow: false,
        preChartShowData: null,
        singleShowData: {
            accTable: {
                key: ['', '仅财损', '轻伤', '重伤', '死亡', '未知', '总数'],
                value: ['数量（起）', 0, 0, 0, 0, 0, 0]
            },
            accTypeTable: {
                key: ['', '碰撞非固定物', '碰撞固定物', '非碰撞', '总数'],
                value: ['数量（起）', 0, 0, 0, 0]
            },
            weaTable: {
                key: ['', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风', '总数'],
                value: ['数量（起）', 0, 0, 0, 0, 0, 0, 0, 0]
            },
            carTable: {
                key: ['', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车', '摩托车', '非机动车', '畜力车', '总数'],
                value: ['数量（起）', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            }
        },

        loginInfor: {
            userName: '',
            password: ''
        },
        userInfor: null,
        oldUserInfor: null,
        userObj: {
            name: '',
            password: '',
            repassword: '',
            gruppe: '',
            isSupper: ''
        },
        isSupper: false,
        //用户管理
        userPage: {
            num: 1,
            size: 5,
            title: ['ID', '用户名', '密码', '所属大队', '管理员'],
            list: null
        },
        userPageBefore: true,
        userPageNext: true,
        addUserDialog: false,
        deleteUserDialog: false,
        courseUser: {
            index: -1,
            obj: null
        },
        updateUserDialog: false,

        gruppeObj: {
            teamName: ''
        },
        courseGruppe: {
            index: -1,
            obj: null
        },
        gruppePage: {
            num: 1,
            size: 5,
            title: ['ID', '大队名称'],
            list: null
        },
        gruppePageBefore: true,
        gruppePageNext: true,
        addGruppeDialog: false,
        updateGruppeDialog: false,

        isFirstLoad: true,
        isShowItems: true,

        loginDialog: false,
        isLogin: true,

        nowFuc: 'black-point',

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
            axios.get(url).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    var data = allData.data;
                    var teamIds = [];
                    var teams = [];
                    data.forEach(function (item, index, array) {
                        teamIds.push(item.id);
                        teams.push(item.teamName);
                    });
                    that.$set(that.basicData.area, 'gruppeId', teamIds);
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
            axios.get(url).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    allData.data.unshift('全市');
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
            axios.get(url).then(function (response) {
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
            axios.get(url).then(function (response) {
                var allData = response.data;
                if(allData.code == 200){
                    that.$set(that.basicData.area, 'crossing', allData.data);
                }
                else{
                    console.log(allData.message);
                }
            }).catch(function (error) {
                console.log(error);
            });
        },

        getPageUser: function (pageNum, pageSize) {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/admin';
            axios.get(url, {
                params: {
                    pageNum : pageNum,
                    pageSize: pageSize
                }
            }).then(function (response) {
                var allData = response.data;
                that.showDialogLoading = false;
                if(allData.code == 200){
                    if(that.userPage.size * that.userPage.num >= allData.data.total){
                        that.userPageNext = true;
                    }
                    else{
                        that.userPageNext = false;
                    }
                    if(that.userPage.num = 1){
                        that.userPageBefore = true;
                    }
                    else{
                        that.userPageBefore = false;
                    }
                    that.$set(that.userPage, 'list', allData.data.rows);
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '系统错误！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);
            });
        },
        resetUserObj: function () {
            this.userObj = {
                name: '',
                password: '',
                repassword: '',
                gruppe: '',
                isSupper: ''
            };
        },
        checkUserObj: function () {
            if(this.userObj.name == ''){
                this.messageTop = "用户名不可为空！";
                this.textFlag = false;
                this.showMessageTop = true;
                return false;
            }
            if(this.userObj.password == '' || this.userObj.password != this.userObj.repassword){
                this.messageTop = "密码不可为空或两次密码输入不一致！";
                this.textFlag = false;
                this.showMessageTop = true;
                return false;
            }
            if(this.userObj.gruppe == ''){
                this.messageTop = "所属大队不可为空！";
                this.textFlag = false;
                this.showMessageTop = true;
                return false;
            }
            if(this.userObj.isSupper == ''){
                this.messageTop = "用户类型不可为空！";
                this.textFlag = false;
                this.showMessageTop = true;
                return false;
            }
            return true;
        },
        addUserDialogClick: function () {
            this.resetUserObj();
            this.addUserDialog = true;
        },
        addUserClose: function () {
            this.addUserDialog = false;
        },
        addUserConfirm: function () {
            if(this.checkUserObj()){
                this.addUser();
            }
        },
        addUser: function () {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/admin';
            var obj = {
                name: this.userObj.name,
                password: this.userObj.password,
                teamId : '',
                issuper : this.userObj.isSupper
            };
            this.basicData.area.gruppe.forEach(function (item, index, arr) {
                if(that.userObj.gruppe == item){
                    obj.teamId = that.basicData.area.gruppeId[index];
                }
            });
            console.log(obj);
            axios.post(url, obj).then(function (response) {
                var allData = response.data;
                console.log(allData);
                that.showDialogLoading = false;
                if(allData.code == 200){
                    that.addUserDialog = false;
                    that.messageTop = '用户添加成功！';
                    that.textFlag = true;
                    that.showMessageTop = true;
                    that.getPageUser(that.userPage.num, that.userPage.size);
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '用户添加失败！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);
            });
        },
        deleteUserClose: function () {
            this.deleteUserDialog = false;
            this.courseUser.index = -1;
            this.courseUser.obj = null;
        },
        deleteUserConfirm: function () {
            this.deleteUserDialog = false;
            this.deleteUser();
        },
        deleteUser: function () {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/admin';
            axios.delete(url, {
                data: {
                    ids: [this.courseUser.obj.adminId]
                }
            }).then(function (response) {
                var allData = response.data;
                that.showDialogLoading = false;
                if(allData.code == 200){
                    that.addUserDialog = false;
                    that.messageTop = '用户删除成功！';
                    that.textFlag = true;
                    that.showMessageTop = true;
                    that.getPageUser(that.userPage.num, that.userPage.size);
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
                that.courseUser.index = -1;
                that.courseUser.obj = null;
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '用户删除失败！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);

                that.courseUser.index = -1;
                that.courseUser.obj = null;
            });
        },
        updateUserClose: function () {
            this.updateUserDialog = false;
        },
        updateUserConfirm: function () {
            this.updateUserDialog = false;
            this.updateUser();
        },
        updateUser: function () {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/admin';
            var obj = {
                adminId: this.courseUser.obj.adminId,
                name: this.userObj.name,
                password: this.userObj.password,
                teamId : '',
                issuper : this.userObj.isSupper
            };
            this.basicData.area.gruppe.forEach(function (item, index, arr) {
                if(that.userObj.gruppe == item){
                    obj.teamId = that.basicData.area.gruppeId[index];
                }
            });
            console.log(obj);
            axios.patch(url, obj).then(function (response) {
                var allData = response.data;
                console.log(allData);
                that.showDialogLoading = false;
                if(allData.code == 200){
                    that.updateUserDialog = false;
                    that.messageTop = '用户修改成功！';
                    that.textFlag = true;
                    that.showMessageTop = true;
                    that.userPage.list[that.courseUser.index].name = that.userObj.name;
                    that.userPage.list[that.courseUser.index].password = that.userObj.password;
                    that.userPage.list[that.courseUser.index].issuper = that.userObj.isSupper;
                    that.userPage.list[that.courseUser.index].teamName = that.userObj.gruppe;
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
                that.courseUser.index = -1;
                that.courseUser.obj = null;
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '用户修改失败！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);

                that.courseUser.index = -1;
                that.courseUser.obj = null;
            });
        },

        getPageGruppe: function (pageNum, pageSize) {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/teams';
            axios.get(url, {
                params: {
                    pageNum : pageNum,
                    pageSize: pageSize
                }
            }).then(function (response) {
                var allData = response.data;
                that.showDialogLoading = false;
                if(allData.code == 200){
                    if(that.gruppePage.size * that.gruppePage.num >= that.basicData.area.gruppe.length){
                        that.gruppePageNext = true;
                    }
                    else{
                        that.gruppePageNext = false;
                    }
                    if(that.gruppePage.num = 1){
                        that.gruupePageBefore = true;
                    }
                    else{
                        that.gruupePageBefore = false;
                    }
                    that.$set(that.gruppePage, 'list', allData.data);
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '系统错误！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);
            });
        },
        resetGruppeObj: function () {
            this.gruppeObj = {
                teamName: ''
            };
        },
        checkGruppeObj: function () {
            if(this.gruppeObj.teamName == ''){
                this.messageTop = "大队名称不可为空！";
                this.textFlag = false;
                this.showMessageTop = true;
                return false;
            }
            return true;
        },
        addGruppeDialogClick: function () {
            this.resetGruppeObj();
            this.addGruppeDialog = true;
        },
        addGruppeClose: function () {
            this.addGruppeDialog = false;
        },
        addGruppeConfirm: function () {
            if(this.checkGruppeObj()){
                this.addGruppe();
            }
        },
        addGruppe: function () {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/teams';
            var obj = {
                teamName: this.gruppeObj.teamName
            };
            axios.post(url, obj).then(function (response) {
                var allData = response.data;
                console.log(allData);
                that.showDialogLoading = false;
                if(allData.code == 200){
                    that.addGruppeDialog = false;
                    that.messageTop = '大队添加成功！';
                    that.textFlag = true;
                    that.showMessageTop = true;
                    that.basicData.area.gruppe.length++;
                    that.getTeams();
                    that.getPageGruppe(that.gruppePage.num, that.gruppePage.size);
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '大队添加失败！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);
            });
        },
        updateGruppeClose: function () {
            this.updateGruppeDialog = false;
        },
        updateGruppeConfirm: function () {
            this.updateGruppeDialog = false;
            this.updateGruppe();
        },
        updateGruppe: function () {
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/teams';
            var obj = {
                id: this.courseGruppe.obj.id,
                teamName: this.gruppeObj.teamName
            };
            axios.patch(url, obj).then(function (response) {
                var allData = response.data;
                console.log(allData);
                that.showDialogLoading = false;
                if(allData.code == 200){
                    that.updateGruppeDialog = false;
                    that.messageTop = '大队修改成功！';
                    that.textFlag = true;
                    that.showMessageTop = true;
                    that.gruppePage.list[that.courseGruppe.index].teamName = that.gruppeObj.teamName;
                    that.getTeams();
                }
                else{
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                }

                that.courseGruppe.index = -1;
                that.courseGruppe.obj = null;
            }).catch(function (error) {
                that.showDialogLoading = false;

                that.messageTop = '用户修改失败！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);

                that.courseGruppe.index = -1;
                that.courseGruppe.obj = null;
            });
        },

        userPageBeforeClick: function () {
            this.userPage.num++;
            this.getPageUser(this.userPage.num, this.userPage.size);
        },
        userPageNextClick: function () {
            this.userPage.num--;
            this.getPageUser(this.userPage.num, this.userPage.size);
        },
        gruppePageBeforeClick: function () {
            this.gruppePage.num++;
            this.getPageGruppe(this.gruppePage.num, this.gruppePage.size);
        },
        gruppePageNextClick: function () {
            this.gruppePage.num--;
            this.getPageGruppe(this.gruppePage.num, this.gruppePage.size);
        },

        cellUserClick: function (rowIndex, columnName, td, tr) {
            var user = this.userPage.list[rowIndex];
            if(columnName == 'delete'){
                this.courseUser.index = rowIndex;
                this.courseUser.obj = user;
                this.deleteUserDialog = true;
            }
            if(columnName == 'update'){
                this.courseUser.index = rowIndex;
                this.courseUser.obj = user;
                this.userObj.name = user.name;
                this.userObj.password = user.password;
                this.userObj.gruppe = user.teamName;
                this.userObj.isSupper = user.issuper + '';
                this.updateUserDialog = true;
            }
        },
        cellGruppeClick: function (rowIndex, columnName, td, tr) {
            var gruppe = this.gruppePage.list[rowIndex];
            console.log(gruppe);
            if(columnName == 'update'){
                this.courseGruppe.index = rowIndex;
                this.courseGruppe.obj = gruppe;
                this.gruppeObj.teamName = gruppe.teamName;
                this.updateGruppeDialog = true;
            }
        },

        checkLogin: function () {
            if(this.userInfor == null){
                this.isLogin = false;
                this.loginDialog = true;
            }
        },
        login: function () {
            this.loginDialog = true;
        },
        logout: function () {
            this.oldUserInfor = {
                userName: this.loginInfor.userName,
                password: this.loginInfor.password
            };
            // this.userInfor = null;
            // this.isLogin = false;
            this.loginDialog = true;
        },
        loginConfirm: function () {
            //loginInfor.userName, loginInfor.password
            this.showDialogLoading = true;
            var that = this;
            var url = webBase + '/admin/login';
            axios.post(url, {
                name: that.loginInfor.userName,
                password: that.loginInfor.password
            }).then(function (response) {
                that.showDialogLoading = false;
                if(response.data.code != 200){
                    that.messageTop = allData.message;
                    that.textFlag = false;
                    that.showMessageTop = true;
                    this.isSupper = false;
                    that.isLogin = false;
                }
                else{
                    that.userInfor = response.data.data;
                    that.isSupper = that.userInfor.issuper == 1 ? true : false;
                    that.nowFuc = 'black-point';
                    that.loginDialog = false;
                    that.isLogin = true;
                    that.messageTop = "登录成功！";
                    that.textFlag = true;
                    that.showMessageTop = true;
                }
            }).catch(function (error) {
                that.showDialogLoading = false;
                this.isSupper = false;

                that.isLogin = false;
                that.messageTop = '系统错误！';
                that.textFlag = false;
                that.showMessageTop = true;
                console.log(error);
            });
        },
        loginCancel: function () {
            this.loginDialog = false;
            this.loginInfor = this.oldUserInfor;
        },
        details: function () {
            this.detailDialog = true;
        },
        detailConfirm: function () {
            this.detailDialog = false;
        },
        detailClose: function () {
            this.selectData.roadGrade = null;
            this.selectData.carCollisionType = null;
            this.selectData.weather = null;
            this.selectData.workZone.flag = '否'
            this.selectData.intersectionType = null;
            this.selectData.vehicleType = null;
            this.selectData.hitAndRun = '否';
            this.detailDialog = false;
        },
        information: function () {
            console.log('information');
        },
        userAdmin: function () {
            if(this.nowFuc != 'supper-user'){
                this.nowFuc = 'supper-user';
                this.getPageUser(1, this.userPage.size);
            }
        },
        gruppeInfor: function () {
            if(this.nowFuc != 'gruppe-infor'){
                this.nowFuc = 'gruppe-infor';
                this.getPageGruppe(1, this.gruppePage.size);
            }
        },
        blackPointDiagnose: function () {
            if(this.nowFuc != 'black-point'){
                this.nowFuc = 'black-point';
                this.chartPrintShow = this.chartPrintShow ? true : false;
                this.timeDownShow = this.timeDownShow ? true : false;
            }
            this.resetObj();
        },
        singleAnalysis: function () {
            if(this.nowFuc != 'single-point'){
                this.nowFuc = 'single-point';
                this.chartPrintShow = this.chartPrintShow ? true : false;
                this.timeDownShow = this.timeDownShow ? true : false;
            }
            this.resetObj();
        },
        singleTabChange: function (val) {
            this.singleShowSelect = false;
            this.chartPrintShow = false;
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
        closeBlackShow: function () {
            this.blackShowSelect = false;
        },
        closeSingleShow: function () {
            this.singleShowSelect = false;
        },
        closeSpaceShow: function () {
            this.spaceShowSelect = false;
        },
        closeTimeShow: function () {
            this.timeShowSelect = false;
        },
        openBlackShow: function () {
            this.blackShowSelect = true;
        },
        openSingleShow: function () {
            this.singleShowSelect = true;
        },
        openSpaceShow: function () {
            this.spaceShowSelect = true;
        },
        openTimeShow: function () {
            this.timeShowSelect = true;
        },
        spaceAnalysis: function () {
            if(this.nowFuc != 'space'){
                this.nowFuc = 'space';
                this.chartPrintShow = this.chartPrintShow ? true : false;
                this.timeDownShow = this.timeDownShow ? true : false;
            }
            this.resetObj();
        },
        timeAnalysis: function () {
            if(this.nowFuc != 'time'){
                this.nowFuc = 'time';
                this.chartPrintShow = this.chartPrintShow ? true : false;
                this.timeDownShow = this.timeDownShow ? true : false;
            }
            this.resetObj();
        },
        highStatistics: function () {
            this.nowFuc = 'statistics';
        },
        workDayChange: function (val) {
            this.selectData.workDay = val;
        },
        areaRadioChange: function (val) {
            if(this.selectData.area.type == 'gruppe'){
                this.selectData.area.gruppeVal = [];
            }
            else{
                this.selectData.area.adminiVal = '';
            }
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
                    type: 'administrative', //'gruppe',
                    gruppeVal: [],
                    adminiVal: ''
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
                    flag: 'null',
                    controlMode: '',
                    worker: '',
                    lawEnfor: ''
                },
                intersectionType: 'null', //'非交叉口',
                vehicleType: 'null', //'小客车',
                hitAndRun: 'null' //'是'
            };
        },
        checkInput: function (json) {
            if(this.nowFuc == 'black-point' || this.nowFuc == 'space' || this.nowFuc == 'time'){
                json.roadType = this.selectData.analysisObj;
                if(this.selectData.area.type == 'gruppe'){
                    if(this.selectData.area.gruppeVal != []){
                        json.teamName = this.selectData.area.gruppeVal;
                    }
                    else{
                        this.messageTop = "大队尚未选取！";
                        this.textFlag = false;
                        this.showMessageTop = true;
                        return false;
                    }
                }
                else if(this.selectData.area.type == 'administrative'){
                    if(this.selectData.area.adminiVal != ''){
                        json.areaName = this.selectData.area.adminiVal;
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
                switch(this.singleTab){
                    case 'gruppe': {
                        if(this.selectData.area.adminiVal == ''){
                            this.messageTop = "大队管辖区尚未选取！";
                            this.textFlag = false;
                            this.showMessageTop = true;
                            return false;
                        }
                        json.teamName = [this.selectData.area.adminiVal];
                        break;
                    }
                    case 'administrative': {
                        if(this.selectData.area.adminiVal == '') {
                            this.messageTop = "行政区尚未选取！";
                            this.textFlag = false;
                            this.showMessageTop = true;
                            return false;
                        }
                        json.areaName = this.selectData.area.adminiVal;
                        break;
                    }
                    case 'intersection': {
                        if(this.selectData.area.adminiVal == '') {
                            this.messageTop = "交叉口尚未选取！";
                            this.textFlag = false;
                            this.showMessageTop = true;
                            return false;
                        }
                        json.roadType = this.selectData.area.adminiVal;
                        break;
                    }
                    case 'crossing': {
                        if(this.selectData.area.adminiVal == '') {
                            this.messageTop = "路段尚未选取！";
                            this.textFlag = false;
                            this.showMessageTop = true;
                            return false;
                        }
                        json.roadType = this.selectData.area.adminiVal;
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

            console.log(json);
            return true;
        },
        resetSingleShowData: function () {
            this.singleShowData = {
                accTable: {
                    key: ['', '仅财损', '轻伤', '重伤', '死亡', '未知', '总数'],
                    value: ['数量（起）', 0, 0, 0, 0, 0, 0]
                },
                accTypeTable: {
                    key: ['', '碰撞非固定物', '碰撞固定物', '非碰撞', '总数'],
                    value: ['数量（起）', 0, 0, 0, 0]
                },
                weaTable: {
                    key: ['', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风', '总数'],
                    value: ['数量（起）', 0, 0, 0, 0, 0, 0, 0, 0]
                },
                carTable: {
                    key: ['', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车', '摩托车', '非机动车', '畜力车', '总数'],
                    value: ['数量（起）', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
                }
            };
            this.isChartShow = false;
        },
        getAccObj: function (data) {
            var obj = ['数量（起）'];
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
                name: '事故严重程度类型',
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
            var obj = ['数量（起）'];
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
                name: '事故类型',
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
                        temp = ['碰撞非固定物'];
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
            var obj = ['数量（起）'];
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
                name: '天气类型',
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
            var obj = ['数量（起）'];
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
                name: '车辆类型',
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
                        temp = ['特种车'];
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
            if(data.totalNum == 0){
                this.messageTop = "未查找到相应数据项！";
                this.textFlag = false;
                this.showMessageTop = true;
                return;
            }
            //事故数、事故严重程度汇总
            this.$set(this.singleShowData.accTable, 'value', this.getAccObj(data));
            //事故数、事故严重程度柱状图
            var xAxis = ['总数', '仅财损', '轻伤', '重伤', '死亡', '未知'];
            this.getHistogram('accHistogram', '各严重程度类型事故柱状图', '严重程度类型', xAxis, [this.getAccHObj(data)]);
            //事故数、事故严重程度扇形图
            this.getPie('accPie', '各严重程度类型事故扇形图', {
                title: '事故严重程度',
                value: ['仅财损', '轻伤', '重伤', '死亡', '未知']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '所属严重程度类型事故数占比',
                data: this.getAccPObj(data)
            }]);

            //事故类型汇总
            this.$set(this.singleShowData.accTypeTable, 'value', this.getAccTObj(data));
            //事故类型柱状图
            xAxis = ['总数', '碰撞非固定物', '碰撞固定物', '非碰撞'];
            this.getHistogram('accTypeHistogram', '各事故类型事故柱状图', '事故类型', xAxis, [this.getAccTHObj(data)]);
            //事故类型扇形图
            this.getPie('accTypePie', '各事故类型事故扇形图', {
                title: '事故类型',
                value: ['碰撞非固定物', '碰撞固定物', '非碰撞']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '所属事故类型事故数占比',
                data: this.getAccTPObj(data)
            }]);

            //天气情况事故汇总
            this.$set(this.singleShowData.weaTable, 'value', this.getWeaObj(data));
            //天气情况事故柱状图
            xAxis = ['总数', '晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风'];
            this.getHistogram('weaHistogram', '各天气类型事故柱状图', '天气类型', xAxis, [this.getWeaHObj(data)]);
            //天气情况事故扇形图
            this.getPie('weaPie', '各天气类型事故扇形图', {
                title: '事故类型',
                value: ['晴天', '阴天', '雨', '雾', '雪', '冰雹', '台风']
            }, {
                title: '事故数（起）'
            }, [{
                type: 'pie',
                name: '所属天气事故数占比',
                data: this.getWeaPObj(data)
            }]);

            //车辆事故汇总
            this.$set(this.singleShowData.carTable, 'value', this.getCarObj(data));
            //车辆事故柱状图
            xAxis = ['总数', '小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车', '摩托车', '非机动车', '畜力车'];
            this.getHistogram('carHistogram', '各车辆类型事故柱状图','车辆类型', xAxis, [this.getCarHObj(data)]);
            //车辆事故扇形图
            this.getPie('carPie', '各车辆类型事故扇形图', {
                title: '事故类型',
                value: ['小客车', '中客车', '大客车', '公交', '校车', '小货车', '中货车', '大货车', '拖挂车', '特种车', '摩托车', '非机动车', '畜力车']
            }, {
                title: '事故数'
            }, [{
                type: 'pie',
                name: '该车辆事故数占比',
                data: this.getCarPObj(data)
            }]);

            this.isChartShow = true;
            this.singleShowSelect = false;
            this.chartPrintShow = true;
            this.deleteChartLogo();
        },
        getHistogram: function (id, title, xText, xAxis, series) {
            return new Highcharts.Chart(id, {
                chart: {
                    type: 'column'
                },
                title: {
                    style: {
                        fontSize: '24px'
                    },
                    text: title
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    useHTML: true,
                    headerFormat: '<div style="font-size: 14px; font-weight: 600;">{point.key}</div>',
                    pointFormat: '事故数: ' + '<b>{point.y} 起</b>'
                },
                xAxis: {
                    lineColor: 'gray',
                    lineWidth: 2,
                    tickLength: 10,
                    tickColor: 'gray',
                    labels: {
                        style: {
                            color: 'black',
                            fontSize: '16px',
                        }
                    },
                    title: {
                        style: {
                            color: 'black',
                            fontSize: '18px',
                            fontWeight: 600
                        },
                        text: xText
                    },
                    categories: xAxis
                },
                yAxis: {
                    lineColor: 'gray',
                    lineWidth: 2,
                    labels: {
                        style: {
                            color: 'black',
                            fontSize: '16px',
                            fontFamily: "Times New Roman"
                        }
                    },
                    min: 0,
                    title: {
                        style: {
                            color: 'black',
                            fontSize: '18px',
                            fontWeight: 600
                        },
                        text: '事故数 (起)'
                    }
                },
                credites: {
                    enabled: true
                },
                plotOptions:{
                    column:{
                        dataLabels:{
                            enabled: true,
                            inside: false,
                            style: {
                                fontSize: '16px',
                                fontFamily: "Times New Roman",
                                fontWeight: 600
                            }
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
                    style: {
                        fontSize: '24px'
                    },
                    text: title
                },
                tooltip: {
                    useHTML: true,
                    headerFormat: '<div style="font-size: 14px; font-weight: 400;">{series.name}</div>',
                    pointFormat: '<b>{point.name}</b>: 事故数占<b style="font-size: 14px;">{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black',
                                fontSize: '16px'
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
        showLine: function(data, type, yStr, sDate, eDate){ //展示折线图
            var xAxis = [];
            var series = [];
            var obj = {
                static:{
                    name: '事故总数',
                    data: []
                }
            };
            yStr.forEach(function (item, index, arr) {
                var o = {
                    name: '',
                    data: []
                };
                switch (item){
                    case 'propertyLoss':{
                        o.name = '仅财损';
                        break;
                    }
                    case 'slightInjury':{
                        o.name = '轻伤';
                        break;
                    }
                    case 'severInjury':{
                        o.name = '重伤';
                        break;
                    }
                    case 'dead':{
                        o.name = '死亡';
                        break;
                    }
                    default :
                        break;
                }
                obj[item] = o;
            });
            var unit;
            type = parseInt(type);
            switch (type){
                case 1: {
                    unit = '(年)';
                    data.forEach(function (item, index, arr) {
                        xAxis.push(item.year + '年');
                        obj.static.data.push(item.value);
                        yStr.forEach(function (value, key) {
                            obj[value].data.push(item[value]);
                        });
                    });
                    break;
                }
                case 2: {
                    unit = '(月)';
                    data.forEach(function (item, index, arr) {
                        if(index == 0){
                            xAxis.push(item.year + ' | ' + item.month + '月');
                        }
                        else{
                            if(item.month == 1){
                                xAxis.push(item.year + ' | ' + item.month + '月');
                            }
                            else {
                                xAxis.push(item.month + '月');
                            }
                        }
                        obj.static.data.push(item.value);
                        yStr.forEach(function (value, key) {
                            obj[value].data.push(item[value]);
                        });
                    });
                    break;
                }
                case 3: {
                    unit = '(日)';
                    data.forEach(function (item, index, arr) {
                        if(index == 0){
                            xAxis.push(item.year + '-' + item.month + ' | ' + item.day + '日');
                        }
                        else{
                            if(item.day == 1){
                                xAxis.push(item.year + '-' + item.month + ' | ' + item.day + '日');
                            }
                            else{
                                xAxis.push(item.day + '日');
                            }
                        }
                        obj.static.data.push(item.value);
                        yStr.forEach(function (value, key) {
                            obj[value].data.push(item[value]);
                        });
                    });
                    break;
                }
                default:
                    break;
            }

            series.push(obj.static);
            yStr.forEach(function (value, key, arr) {
                series.push(obj[value]);
            });

            //  var xAxis = ['总数', '仅财损', '轻伤', '重伤', '死亡', '未知'];
            this.getLine('timeLine', '各条件下事故数趋势图', xAxis, series);

            this.timeShowSelect = false;
            this.timeDownShow = true;
            this.deleteChartLogo();
        },
        getLine: function (id, title, xAxis, series) {
            return new Highcharts.Chart(id, {
                chart: {
                    type: 'line'
                },
                title: {
                    style: {
                        fontSize: '24px'
                    },
                    text: title
                },
                legend: {
                    itemStyle: {
                        fontSize: '18px'
                    }
                },
                xAxis: {
                    lineColor: 'gray',
                    lineWidth: 2,
                    tickLength: 10,
                    tickColor: 'gray',
                    labels: {
                        style: {
                            color: 'black',
                            fontSize: '16px'
                        }
                    },
                    categories: xAxis
                },
                yAxis: {
                    lineColor: 'gray',
                    lineWidth: 2,
                    labels: {
                        style: {
                            color: 'black',
                            fontSize: '16px',
                            fontFamily: "Times New Roman"
                        }
                    },
                    min: 0,
                    title: {
                        style: {
                            color: 'black',
                            fontSize: '18px',
                            fontWeight: 600
                        },
                        text: '事故数 (起)'
                    }
                },
                tooltip: {
                    crosshairs: true,
                    shared: true,
                    useHTML: true,
                    headerFormat: '<div style="font-size: 14px; font-weight: 600;">{point.key}</div><table>',
                    pointFormat: '<tr></t><td><span style="color:{point.color}">\u25CF</span>{series.name}:</td><td><b>{point.y}起</b></td></tr>',
                    footerFormat: '</table>'
                },
                plotOptions: {
                    line: {
                    }
                },
                series: series
            });
        },
        getBlackMarkers: function (acc, anObj, allnum, data) {
            var anObjType = (anObj == '路段') ? 1 : 0;
            var that = this;
            var yMax = 0;
            var yMin = 111111111;
            data.forEach(function (item, index, arr) {
                if (item.number < yMin) {
                    yMin = item.number;
                }
                if (item.number > yMax) {
                    yMax = item.number;
                }
            });
            //console.log(yMin+" ymax:"+yMax)
            data.forEach(function (item, index, arr) {
                var obj = {
                    map: blackPointMap,
                    type: anObjType,
                    name: item.blackPointName,
                    lat: item.lat,
                    lng: item.lng,
                    accidentAllNumbers: allnum,
                    accidentNumbers: item.number
                };
                setMarker(obj,yMin,yMax);
            });
        },
        getSpaceMarkers: function (acc, anObj, allnum, data) {
            var anObjType = (anObj == '路段') ? 1 : 0;
            var that = this;
            var yMax = 0;
            var yMin = 111111111;
            data.forEach(function (item, index, arr) {
                if (item.num <= yMin) {
                    yMin = item.num;
                }
                if (item.num >= yMax) {
                    yMax = item.num;
                }
            });
            // console.log(yMin+" ymax:"+yMax)
            data.forEach(function (item, index, arr) {
                var obj = {
                    map: spaceMap,
                    type: anObjType,
                    name: item.diMingBeiZhu,
                    lat: item.lat,
                    lng: item.lng,
                    accidentAllNumbers: allnum,
                    accidentNumbers: item.num
                };
                if(acc == 'accidentCount'){
                    obj.isChenDu = false;
                }
                else{
                    obj.isChenDu = true;
                    obj.showType = that.selectData.accidentalSev.toString();
                    that.selectData.accidentalSev.forEach(function (t) {
                        switch (t){
                            case '仅财损':{
                                obj.wealthLoss = item.propertyLoss;
                                if (yMin > obj.wealthLoss) {
                                    yMin = obj.wealthLoss;
                                }
                                if (yMax < obj.wealthLoss) {
                                    yMax = obj.wealthLoss
                                }
                                break;
                            }
                            case '轻伤':{
                                obj.slightInjury = item.slightInjury;
                                if (yMin > obj.slightInjury) {
                                    yMin = obj.slightInjury;
                                }
                                if (yMax < obj.slightInjury) {
                                    yMax = obj.slightInjury
                                }
                                break;
                            }
                            case '重伤':{
                                obj.seriousInjury = item.severInjury;
                                if (yMin > obj.severInjury) {
                                    yMin = obj.severInjury;
                                }
                                if (yMax < obj.seriousInjury) {
                                    yMax = obj.seriousInjury
                                }
                                break;
                            }
                            case '死亡':{
                                obj.death = item.dead;
                                if (yMin > obj.death) {
                                    yMin = obj.death;
                                }
                                if (yMax < obj.death) {
                                    yMax = obj.death
                                }
                                break;
                            }
                            default:
                                break;
                        }
                    });

                }
                // console.log(yMax+"ym:"+yMin)
                setMarker(obj,yMin,yMax);
            });
        },
        blackPointDown: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/exportaion';
            var json = {};
            var flag = this.checkInput(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        var a = document.createElement('a');
                        a.download = 'excel' + '.xls';
                        a.href = allData.data;
                        document.body.appendChild(a);
                        a.click();
                        document.body.removeChild(a);

                        that.showDialogLoading = false;

                        that.messageTop = "下载请求成功！";
                        that.textFlag = true;
                        that.showMessageTop = true;
                        // that.blackShowSelect = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        singleChartPrint: function () {
            var printDiv = document.getElementById('singlePrintId');
            localStorage.title = this.getNowTime() + '单点分析报告';
            localStorage.obj = printDiv.innerHTML;
            localStorage.width = printDiv.offsetWidth;
            window.open('http://' + location.host + "/roadCheck/print.jsp", "_blank");
        },
        spaceDown: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/areaAnalyseDataExport';
            var json = {};
            var flag = this.checkInput(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        var a = document.createElement('a');
                        a.download = 'excel' + '.xls';
                        a.href = allData.data;
                        document.body.appendChild(a);
                        a.click();
                        document.body.removeChild(a);

                        that.showDialogLoading = false;

                        that.messageTop = "下载请求成功！";
                        that.textFlag = true;
                        that.showMessageTop = true;
                        // that.spaceShowSelect = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        timeChartPrint: function () {
            var printDiv = document.getElementById('timePrintId');
            localStorage.title = this.getNowTime() + '时间分析报告';
            localStorage.obj = printDiv.innerHTML;
            localStorage.width = printDiv.offsetWidth;
            window.open('http://' + location.host + "/roadCheck/print.jsp", "_blank");
        },
        blackPointGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/blackPointDiagnosis/results';
            var json = {};
            var flag = this.checkInput(json);
            console.log(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        // console.log(allData.data);
                        if(allData.data.arr.length == 0){
                            that.showDialogLoading = false;

                            that.messageTop = "未查找到相应数据项！";
                            that.textFlag = false;
                            that.showMessageTop = true;
                            return;
                        }
                        clearMarker(blackPointMap);
                        that.getBlackMarkers(that.selectData.yType, that.selectData.analysisObj, allData.data.allnum, allData.data.arr);
                        that.blackShowSelect = false;

                        that.showDialogLoading = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        singlePointGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/singlePointAnalyseDataQuery';
            var json = {};
            var flag = this.checkInput(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        that.preChartShowData = allData.data;
                        that.singleShow(allData.data);

                        that.showDialogLoading = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        spaceGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/areaMultiConditionQuery';
            var json = {};
            var flag = this.checkInput(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        // console.log(allData.data);
                        if(allData.data.arr.length == 0){
                            that.showDialogLoading = false;

                            that.messageTop = "未查找到相应数据项！";
                            that.textFlag = false;
                            that.showMessageTop = true;
                            return;
                        }
                        clearMarker(spaceMap);
                        that.getSpaceMarkers(that.selectData.yType, that.selectData.analysisObj, allData.data.allnum, allData.data.arr);
                        that.spaceShowSelect = false;

                        that.showDialogLoading = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        timeGet: function () {
            var that = this;
            var url = webBase + '/accidentDatas/analyseData/timeMultiConditionQuery';
            var json = {};
            var flag = this.checkInput(json);
            if(flag){
                this.showDialogLoading = true;
                axios.post(url, json).then(function (response) {
                    var allData = response.data;
                    if(allData.code == 200){
                        // console.log(allData.data.arr);
                        if(allData.data.arr.length == 0){
                            that.showDialogLoading = false;

                            that.messageTop = "未查找到相应数据项！";
                            that.textFlag = false;
                            that.showMessageTop = true;
                            return;
                        }
                        /*
                         * 统计年、月、日中人数
                         *
                         * */
                        //获取时间跨度
                        var eDate = json.endTime.split("-");
                        var sDate = json.startTime.split("-");
                        var xYears = eDate[0] - sDate[0] + 1;
                        var xMonths = (xYears - 1) * 12 + (eDate[1] - sDate[1]) + 1;
                        var eD = new Date(eDate[1] + "-" + eDate[2] + "-" + eDate[0]);
                        var sD = new Date(sDate[1] + "-" + sDate[2] + "-" + sDate[0]);
                        var xDays = parseInt(Math.abs(eD - sD) / 1000 / 60 / 60 / 24) + 1;

                        var yStr = [];
                        if(!json.yType){
                            if(json.propertyLoss){
                                yStr.push('propertyLoss');
                            }
                            if(json.slightInjury){
                                yStr.push('slightInjury');
                            }
                            if(json.severInjury){
                                yStr.push('severInjury');
                            }
                            if(json.dead){
                                yStr.push('dead');
                            }
                        }

                        /*展示方式
                         * */
                        var data = allData.data.arr;
                        var basicDay, basicMonth, basicYear;
                        if (json.timePrecision == 1) {
                            //按年展示
                            var yearNumbers = new Array(xYears);
                            basicYear = sDate[0] - 1;
                            for (var i = 0 ; i < xYears;i++) {
                                basicYear++;
                                yearNumbers[i] = {};
                                yearNumbers[i].year = basicYear;
                                yearNumbers[i].value = 0;
                                yStr.forEach(function (value, key, arr) {
                                    yearNumbers[i][value] = 0;
                                });
                            }
                            data.forEach(function (item, index, arr) {
                                var yN = item.yearRes - sDate[0];
                                yearNumbers[yN].value += item.num;

                                yStr.forEach(function (value, key) {
                                    yearNumbers[yN][value] += item[value];
                                });
                            })

                            that.showLine(yearNumbers, json.timePrecision, yStr, json.startTime, json.endTime);
                        }
                        if (json.timePrecision == 2) {
                            //按月展示
                            var monthNumbers = new Array(xMonths);
                            basicMonth = sDate[1] - 1;
                            basicYear = sDate[0];
                            for (var i = 0, m = basicMonth; i < xMonths; i++) {
                                m++;
                                if(m == 13){
                                    basicYear++;
                                    m = 1;
                                }
                                monthNumbers[i] = {};
                                monthNumbers[i].year = basicYear;
                                monthNumbers[i].month = m;
                                monthNumbers[i].value = 0;

                                yStr.forEach(function (value, key, arr) {
                                    monthNumbers[i][value] = 0;
                                });
                            }
                            data.forEach(function (item, index, arr) {
                                var mN = (item.yearRes - sDate[0]) * 12 + (item.monthRes - sDate[1]);
                                monthNumbers[mN].value += item.num;

                                yStr.forEach(function (value, key) {
                                    monthNumbers[mN][value] += item[value];
                                });
                            });

                            that.showLine(monthNumbers, json.timePrecision, yStr, json.startTime, json.endTime);
                        }
                        if (json.timePrecision == 3) {
                            //按日展示
                            var dayNumbers = new Array(xDays);
                            basicDay = sDate[2] - 1;
                            basicMonth = sDate[1];
                            basicYear = sDate[0];
                            for (var i = 0 ; i < xDays;i++) {
                                basicDay++;
                                if(basicMonth == 1 || basicMonth == 3 || basicMonth == 5 || basicMonth == 7 || basicMonth == 8 || basicMonth == 10 || basicMonth == 12){
                                    if(basicDay == 32){
                                        basicDay = 1;
                                        basicMonth++;
                                        if(basicMonth == 13){
                                            basicMonth = 1;
                                            basicYear++;
                                        }
                                    }
                                }
                                else if(basicMonth == 2){
                                    if(basicYear % 400 == 0 || (basicYear % 100 != 0 && basicYear % 4 == 0)){
                                        if(basicDay == 30){
                                            basicDay = 1;
                                            basicMonth++;
                                        }
                                    }
                                    else {
                                        if(basicDay == 29){
                                            basicDay = 1;
                                            basicMonth++;
                                        }
                                    }
                                }
                                else{
                                    if(basicDay == 31){
                                        basicDay = 1;
                                        basicMonth++;
                                    }
                                }
                                dayNumbers[i] = {};
                                dayNumbers[i].year = basicYear;
                                dayNumbers[i].month = basicMonth;
                                dayNumbers[i].day = basicDay;
                                dayNumbers[i].value = 0;

                                yStr.forEach(function (value, key, arr) {
                                    dayNumbers[i][value] = 0;
                                });
                            }
                            data.forEach(function (item, index, arr) {
                                var nowD = new Date(item.monthRes + "-" + item.dayRes + "-" + item.yearRes);
                                sD = new Date(sDate[1] + "-" + sDate[2] + "-" + sDate[0]);
                                var dN = parseInt(Math.abs(nowD - sD) / 1000 / 60 / 60 / 24);
                                dayNumbers[dN].value += item.num;

                                yStr.forEach(function (value, key) {
                                    dayNumbers[dN][value] += item[value];
                                });
                            });

                            that.showLine(dayNumbers, json.timePrecision, yStr, json.startTime, json.endTime);
                        }

                        that.showDialogLoading = false;
                    }
                    else{
                        that.showDialogLoading = false;

                        that.messageTop = allData.message;
                        that.textFlag = false;
                        that.showMessageTop = true;
                    }
                }).catch(function (error) {
                    that.showDialogLoading = false;

                    that.messageTop = '系统错误！';
                    that.textFlag = false;
                    that.showMessageTop = true;
                    console.log(error);
                });
            }
        },
        deleteChartLogo: function () {
            var text = document.getElementsByTagName('text');
            var size = text.length;
            for(var i = 0; i < size; i++){
                if(text[i].innerHTML == 'Highcharts.com'){
                    text[i].parentNode.removeChild(text[i]);
                    i--;
                    size--;
                }
            }
        },
        getNowTime: function () {
            var nowDate = new Date();
            var str =  nowDate.getFullYear() + '年' + (nowDate.getMonth() + 1) + '月' + nowDate.getDate() + '日';
            str += nowDate.getHours() + '时' + nowDate.getMinutes() + '分' + nowDate.getSeconds() + '秒';
            return str;
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
            this.userPage.size = parseInt((this.wrapHeight - 15 - 20 - 50 - 57 - 50) / 48);
            this.gruppePage.size = this.userPage.size;
            return {
                'width': this.wrapWidth - 30 - (this.isShowItems ? 256 : 8) + 'px',
                'height': this.wrapHeight - 15 + 'px'
            }
        },
        singleRightStyle: function () {
            return {
                'width': this.wrapWidth - 30 - (this.isShowItems ? 256 : 8) + 'px'
            }
        },
        chartStyle: function () {
            return {
                'width': this.wrapWidth - 30 - 4 - 20 - (this.isShowItems ? 256 : 8) + 'px'
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
        this.getTeams();
        this.getRegions();
        this.getIntersections();
        this.initPage();
        this.checkLogin();
        this.getCorssings();
        var that = this;
        addEventListener('resize', function () {
            that.initPage();
        });
    }
});