<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>泸州市交通事故数据分析系统</title>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1, keyword2, keyword3">
    <meta http-equiv="description" content="交科地图可视化">

    <link rel="stylesheet" href="libs/muse-ui-2.1.0/fonts.css" />
    <link rel="stylesheet" href="libs/muse-ui-2.1.0/muse-ui.css" />
    <link rel="stylesheet" href="libs/muse-ui-2.1.0/theme-light.css" />
    <link rel="stylesheet" href="css/index.css" />

    <script src="http://webapi.amap.com/maps?v=1.4.0&key=9a1af9cca90cfaf160d5a8d7c0af9187"></script>
</head>
<body>
<div id="app">
    <div class="items-class" :class="{'items-class-open': isFirstLoad && isShowItems, 'items-class-close': isFirstLoad && !isShowItems}">
        <mu-appbar title="功能列表">
        </mu-appbar>
        <mu-list class="list-class">
            <mu-list-item title="事故黑点诊断" @click="blackPointDiagnose">
                <mu-icon slot="left" value="send"></mu-icon>
            </mu-list-item>
            <mu-list-item title="事故数据分析" :toggle-nested="true">
                <mu-icon slot="left" value="send"></mu-icon>
                <mu-list-item slot="nested" title="单点分析" @click="singleAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
                <mu-list-item slot="nested" title="空间分析" @click="spaceAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
                <mu-list-item slot="nested" title="时间分析" @click="timeAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
            </mu-list-item>
            <mu-list-item title="高级统计分析" @click="highStatistics">
                <mu-icon slot="left" value="send"></mu-icon>
            </mu-list-item>
        </mu-list>
    </div>
    <mu-appbar title="泸州市交通事故数据分析系统" class="main-header" :class="{'header-class-open': isFirstLoad && isShowItems, 'header-class-close': isFirstLoad && !isShowItems}">
        <mu-icon-button icon="view_list" slot="left" href="javascript: void(0);" @click="toggleFuc"></mu-icon-button>
        <mu-flat-button v-show="!isLogin" label="登录" slot="right" @click="login"></mu-flat-button>
        <mu-flat-button v-show="isLogin" label="个人信息" slot="right" @click="information"></mu-flat-button>
        <mu-flat-button v-show="isLogin" label="退出登录" slot="right" @click="logout"></mu-flat-button>
    </mu-appbar>
    <div class="main-body" :class="{'header-class-open': isFirstLoad && isShowItems, 'header-class-close': isFirstLoad && !isShowItems}">
        <div v-show="nowFuc == 'main-page'" :style="bodyContent">

        </div>
        <div v-show="nowFuc == 'black-point'" :style="bodyContent">
            <div class="body-left body-left-float" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段黑点诊断">
                    <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class">选择分析的区域</div>
                <mu-radio label="大队" name="area1" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type"></mu-radio>
                <mu-radio label="行政区" name="area1" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;"></mu-radio>
                <mu-select-field v-show="selectData.area.type == 'gruppe'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <mu-select-field v-show="selectData.area.type == 'administrative'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                <mu-date-picker auto-ok hint-text="开始监测日期" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-date-picker auto-ok hint-text="至截止监测日期" :underline-class="{'underline-class': true}"></mu-date-picker>
            </div>
            <div class="body-right" :style="mapStyle">
                <div id="blackPointMap" class="map">

                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'single-point'" :style="bodyContent">
            <div class="body-left">
                <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段">
                    <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class">选择分析的区域</div>
                <mu-radio label="大队" name="area2" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type"></mu-radio>
                <mu-radio label="行政区" name="area2" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;"></mu-radio>
                <mu-select-field v-show="selectData.area.type == 'gruppe'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}"  label="大队管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <mu-select-field v-show="selectData.area.type == 'administrative'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                <mu-date-picker auto-ok hint-text="开始监测日期" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-date-picker auto-ok hint-text="至截止监测日期" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-select-field v-model="selectData.bali" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}"  label="具体地点">
                    <mu-menu-item v-for="text,index in basicData.bali" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
            </div>
            <div class="body-right">
            </div>
        </div>
        <div v-show="nowFuc == 'space'" :style="bodyContent">
            <div class="body-left body-left-float" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段黑点诊断">
                    <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class">选择分析的区域</div>
                <mu-radio label="大队" name="area3" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type"></mu-radio>
                <mu-radio label="行政区" name="area3" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;"></mu-radio>
                <mu-select-field v-show="selectData.area.type == 'gruppe'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <mu-select-field v-show="selectData.area.type == 'administrative'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                <mu-date-picker auto-ok hint-text="开始监测日期" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-date-picker auto-ok hint-text="至截止监测日期" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-select-field v-model="selectData.accidentalSev" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="事故严重程度">
                    <mu-menu-item v-for="text,index in basicData.accidentalSev" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <mu-raised-button label="细节筛选" icon="widgets" label-position="before" primary style="width: 256px" @click="details"></mu-raised-button>
            </div>
            <div class="body-right" :style="mapStyle">
                <div id="spaceMap" class="map">

                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'time'" :style="bodyContent">
            <div class="body-left body-left-float" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段黑点诊断">
                    <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class">选择分析的区域</div>
                <mu-radio label="大队" name="area4" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type"></mu-radio>
                <mu-radio label="行政区" name="area4" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;"></mu-radio>
                <mu-select-field v-show="selectData.area.type == 'gruppe'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <mu-select-field v-show="selectData.area.type == 'administrative'" v-model="selectData.area.value" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                    <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="index" :title="text" ></mu-menu-item>
                </mu-select-field>
                <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                <mu-date-picker auto-ok hint-text="开始监测日期" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-date-picker auto-ok hint-text="至截止监测日期" :underline-class="{'underline-class': true}"></mu-date-picker>
                <mu-raised-button label="细节筛选" icon="widgets" label-position="before" primary style="width: 256px" @click="details"></mu-raised-button>
            </div>
            <div class="body-right" :style="mapStyle">
                <div id="timeMap" class="map">

                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'statistics'" class="statistics" :style="bodyContent">
            <span>此功能尚未开通！</span>
        </div>
    </div>

    <mu-dialog :open="loginDialog" title="泸州市交通事故数据分析系统" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" >
        <mu-text-field label="请输入您的用户名|警号" :full-width="true" label-float></mu-text-field>
        <mu-text-field label="请输入您的密码" :full-width="true" label-float></mu-text-field>
        <mu-flat-button slot="actions" primary @click="loginConfirm" label="登录"></mu-flat-button>
    </mu-dialog>

    <mu-dialog :open="detailDialog" title="交通事故细节筛选" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="detailClose">
        <mu-select-field v-model="selectData.roadGrade" :full-width="true" label="道路等级">
            <mu-menu-item v-for="text,index in basicData.roadGrade" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.accident.type" :full-width="true" label="事故类型">
            <mu-menu-item v-for="text,index in basicData.accident.type" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.weather" :full-width="true" label="天气">
            <mu-menu-item v-for="text,index in basicData.weather" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.workZone.flag" :full-width="true" label="作业区">
            <mu-menu-item v-for="text,index in basicData.workZone.flag" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.intersectionType" :full-width="true" label="交叉口类型">
            <mu-menu-item v-for="text,index in basicData.intersectionType" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.vehicleType" :full-width="true" label="车辆类型">
            <mu-menu-item v-for="text,index in basicData.vehicleType" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.hitAndRun" :full-width="true" label="肇事逃逸">
            <mu-menu-item v-for="text,index in basicData.hitAndRun" :key="index" :value="index" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-flat-button slot="actions" primary @click="detailConfirm" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="detailClose" label="确认"></mu-flat-button>
    </mu-dialog>
</div>

<script src="libs/vue/vue.js"></script>
<script src="libs/muse-ui-2.1.0/muse-ui.js"></script>
<script src="js/index.js"></script>
</body>
</html>