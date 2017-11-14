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

    <link rel="shortcut icon" type="image/ico" href="source/favicon.ico"/>
    <link rel="stylesheet" href="libs/muse-ui-2.1.0/fonts.css" />
    <link rel="stylesheet" href="libs/muse-ui-2.1.0/muse-ui.css" />
    <link rel="stylesheet" href="libs/muse-ui-2.1.0/theme-light.css" />
    <link rel="stylesheet" href="css/index.css" />
</head>
<body>
<div id="app">
    <div class="items-class no-print" :class="{'items-class-open': isFirstLoad && isShowItems, 'items-class-close': isFirstLoad && !isShowItems}">
        <mu-appbar title="功能列表">
        </mu-appbar>
        <mu-list class="list-class">
            <mu-list-item v-if="isSupper" v-cloak title="信息管理" :class="{'items-active': nowFuc=='supper-user' || nowFuc == 'gruppe-infor'}" :toggle-nested="true">
                <mu-icon slot="left" value="send"></mu-icon>
                <mu-list-item slot="nested" title="用户信息" :class="{'item-active': nowFuc=='supper-user'}" @click="userAdmin">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
                <mu-list-item slot="nested" title="大队信息" :class="{'item-active': nowFuc=='gruppe-infor'}" @click="gruppeInfor">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
            </mu-list-item>
            <mu-list-item title="事故黑点诊断" :class="{'item-active': nowFuc=='black-point'}" @click="blackPointDiagnose">
                <mu-icon slot="left" value="send"></mu-icon>
            </mu-list-item>
            <mu-list-item title="事故数据分析" :class="{'items-active': nowFuc=='single-point' || nowFuc == 'space' || nowFuc == 'time'}" :toggle-nested="true">
                <mu-icon slot="left" value="send"></mu-icon>
                <mu-list-item slot="nested" title="单点分析" :class="{'item-active': nowFuc=='single-point'}" @click="singleAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
                <mu-list-item slot="nested" title="空间分析" :class="{'item-active': nowFuc=='space'}" @click="spaceAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
                <mu-list-item slot="nested" title="时间分析" :class="{'item-active': nowFuc=='time'}" @click="timeAnalysis">
                    <mu-icon slot="left" value="grade"></mu-icon>
                </mu-list-item>
            </mu-list-item>
            <mu-list-item v-if="false" title="高级统计分析" @click="highStatistics">
                <mu-icon slot="left" value="send"></mu-icon>
            </mu-list-item>
        </mu-list>
    </div>
    <mu-appbar title="泸州市交通事故数据分析系统" class="main-header no-print" :class="{'header-class-open': isFirstLoad && isShowItems, 'header-class-close': isFirstLoad && !isShowItems}">
        <mu-icon-button icon="view_list" slot="left" href="javascript: void(0);" @click="toggleFuc"></mu-icon-button>
        <mu-flat-button v-if="!isLogin" label="登录" slot="right" @click="login"></mu-flat-button>
        <%--<mu-flat-button v-if="isLogin" label="个人信息" slot="right" @click="information"></mu-flat-button>--%>
        <mu-flat-button v-if="isLogin" label="账号切换" slot="right" @click="logout"></mu-flat-button>
    </mu-appbar>
    <div class="no-print" style="height: 64px"></div>
    <div class="main-body" :class="{'header-class-open': isFirstLoad && isShowItems, 'header-class-close': isFirstLoad && !isShowItems}">
        <div v-if="nowFuc == 'supper-user'" v-cloak :style="bodyContent">
            <div class="body-right" :style="rightStyle">
                <div class="table-class supper-user-class">
                    <div class="title-class">用户信息管理</div>
                    <hr/>
                    <mu-table :selectable="false" :show-checkbox="false" :fixed-header="true" @cell-click="cellUserClick">
                        <mu-thead slot="header">
                            <mu-tr>
                                <mu-th v-for="item, index in userPage.title" :key="index">{{item}}</mu-th>
                                <mu-th class="icon-td">修改</mu-th>
                                <mu-th class="icon-td">删除</mu-th>
                            </mu-tr>
                        </mu-thead>
                        <mu-tbody>
                            <mu-tr v-for="item, index in userPage.list" :key="index">
                                <mu-td>{{item.adminId}}</mu-td>
                                <mu-td>{{item.name}}</mu-td>
                                <mu-td>{{item.password}}</mu-td>
                                <mu-td>{{item.teamName}}</mu-td>
                                <mu-td>{{item.issuper == 1 ? '是' : '否'}}</mu-td>
                                <mu-td name="update" class="icon-td">
                                    <mu-icon-button icon="mode_edit" class="user-page-btn"></mu-icon-button>
                                </mu-td>
                                <mu-td name="delete" class="icon-td">
                                    <mu-icon-button icon="delete" class="user-page-btn"></mu-icon-button>
                                </mu-td>
                            </mu-tr>
                        </mu-tbody>
                    </mu-table>
                    <div class="page-loading">
                        <div class="page-left">
                            <mu-icon-button icon="add" class="user-page-btn" @click="addUserDialogClick"></mu-icon-button>
                        </div>
                        <div class="page-right">
                            <mu-icon-button v-cloak icon="navigate_before" :disabled="userPageBefore" class="user-page-btn" @click="userPageBeforeClick"></mu-icon-button>
                            <mu-icon-button v-cloak icon="navigate_next" :disabled="userPageNext" class="user-page-btn" @click="userPageNextClick"></mu-icon-button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="nowFuc == 'gruppe-infor'" v-cloak :style="bodyContent">
            <div class="body-right" :style="rightStyle">
                <div class="table-class supper-user-class">
                    <div class="title-class">大队信息管理</div>
                    <hr/>
                    <mu-table :selectable="false" :show-checkbox="false" :fixed-header="true" @cell-click="cellGruppeClick">
                        <mu-thead slot="header">
                            <mu-tr>
                                <mu-th v-for="item, index in gruppePage.title" :key="index">{{item}}</mu-th>
                                <mu-th class="icon-td">修改</mu-th>
                            </mu-tr>
                        </mu-thead>
                        <mu-tbody>
                            <mu-tr v-for="item, index in gruppePage.list" :key="index">
                                <mu-td>{{item.id}}</mu-td>
                                <mu-td>{{item.teamName}}</mu-td>
                                <mu-td name="update" class="icon-td">
                                    <mu-icon-button icon="mode_edit" class="user-page-btn"></mu-icon-button>
                                </mu-td>
                            </mu-tr>
                        </mu-tbody>
                    </mu-table>
                    <div class="page-loading" >
                        <div class="page-left">
                            <mu-icon-button icon="add" class="user-page-btn" @click="addGruppeDialogClick"></mu-icon-button>
                        </div>
                        <div class="page-right">
                            <mu-icon-button v-cloak icon="navigate_before" :disabled="gruppePageBefore" class="user-page-btn" @click="gruppePageBeforeClick"></mu-icon-button>
                            <mu-icon-button v-cloak icon="navigate_next" :disabled="gruppePageNext" class="user-page-btn" @click="gruppePageNextClick"></mu-icon-button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'black-point'"  v-cloak :style="bodyContent">
            <div class="time-body-left time-body-left-float no-print" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <div v-show="!blackShowSelect" v-cloak>
                    <mu-icon-button v-cloak icon="navigate_next" tooltip-position="bottom-right" tooltip="筛选条件" class="single-open-btn" @click="openBlackShow"></mu-icon-button>
                </div>
                <div v-show="blackShowSelect" v-cloak class="single-select-left">
                    <mu-icon-button v-cloak icon="navigate_before" tooltip-position="bottom-right" tooltip="收起" class="single-close-btn" @click="closeBlackShow"></mu-icon-button>
                    <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段">
                        <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class">选择分析的区域</div>
                    <mu-radio label="行政区" name="area1" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 20px;" @change="areaRadioChange"></mu-radio>
                    <mu-radio label="大队" max-height="10px" scroller name="area1" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;" @change="areaRadioChange"></mu-radio>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'gruppe'" max-height="300" scroller hint-text="null" v-model="selectData.area.gruppeVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区" multiple>
                        <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'administrative'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                        <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                    <mu-date-picker auto-ok hint-text="开始监测日期" v-model="selectData.dateTime.start" container="inline" mode="landscape" min-date="2016-09-01" :underline-class="{'underline-class': true, 'end-time-line': true}" style="width: 205px;"></mu-date-picker>
                    <mu-icon-button tooltip="下载excel报告" tooltip-position="bottom-right" icon="file_download" class="right-btn" @click="blackPointDown"></mu-icon-button>
                    <mu-date-picker auto-ok hint-text="至截止监测日期" v-model="selectData.dateTime.end" container="inline" mode="landscape" :underline-class="{'underline-class': true, 'end-time-line': true}" style="width: 205px;"></mu-date-picker>
                    <mu-icon-button tooltip="筛选结果" tooltip-position="bottom-right" icon="call_merge" class="right-btn" @click="blackPointGet"></mu-icon-button>
                    <%--<mu-icon-button tooltip="筛选数据重置" tooltip-position="bottom-right" icon="grade" class="right-btn" @click="resetObj"></mu-icon-button>--%>
                </div>
            </div>
            <div class="body-right" :style="rightStyle">
                <div id="blackPointMap" class="map">

                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'single-point'" v-cloak :style="bodyContent">
            <div class="single-body-left single-body-left-float no-print" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <div v-show="!singleShowSelect" v-cloak>
                    <mu-icon-button v-cloak icon="navigate_next" tooltip-position="bottom-right" tooltip="筛选条件" class="single-open-btn" @click="openSingleShow"></mu-icon-button>
                    <mu-icon-button v-cloak v-show="chartPrintShow" tooltip="导出当前pdf报告" tooltip-position="bottom-right" icon="print" class="single-open-btn" class="right-btn" @click="singleChartPrint" style="margin-left: 10px;"></mu-icon-button>
                </div>
                <div v-cloak v-show="singleShowSelect" class="single-select-left">
                    <mu-icon-button v-cloak icon="navigate_before" tooltip-position="bottom-right" tooltip="收起" class="single-close-btn" @click="closeSingleShow"></mu-icon-button>
                    <mu-select-field v-cloak v-show="singleTab == 'gruppe'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区">
                        <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="singleTab == 'administrative'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政区">
                        <mu-menu-item v-cloak v-show="index != 0" v-for="text,index in basicData.area.administrative" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="singleTab == 'intersection'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="交叉口">
                        <mu-menu-item v-for="text,index in basicData.area.intersection" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="singleTab == 'crossing'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="路段">
                        <mu-menu-item v-for="text,index in basicData.area.crossing" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                    <mu-date-picker auto-ok hint-text="开始监测日期" v-model="selectData.dateTime.start" container="inline" mode="landscape" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                    <mu-date-picker auto-ok hint-text="至截止监测日期" v-model="selectData.dateTime.end" container="inline" mode="landscape" :underline-class="{'underline-class': true, 'end-time-line': true}" style="width: 205px;"></mu-date-picker>
                    <mu-icon-button tooltip="筛选结果" tooltip-position="bottom-right" icon="call_merge" class="right-btn" @click="singlePointGet"></mu-icon-button>
                </div>
            </div>
            <div class="single-tabs-fixed no-print" :style="singleRightStyle">
                <div class="single-tabs-div">
                    <mu-tabs :value="singleTab" class="single-tabs" line-class="single-tabs-line" @change="singleTabChange">
                        <mu-tab value="gruppe" title="大队管辖区" :title-class="{'single-tab-title': singleTab != 'gruppe'}" :class="{'single-tab-active': singleTab == 'gruppe'}"></mu-tab>
                        <mu-tab value="administrative" title="行政区" :title-class="{'single-tab-title': singleTab != 'administrative'}" class="left-split-line" :class="{'single-tab-active': singleTab == 'administrative'}"></mu-tab>
                        <mu-tab value="intersection" title="交叉口" :title-class="{'single-tab-title': singleTab != 'intersection'}" class="left-split-line" :class="{'single-tab-active': singleTab == 'intersection'}"></mu-tab>
                        <mu-tab value="crossing" title="路段" :title-class="{'single-tab-title': singleTab != 'crossing'}" class="left-split-line" :class="{'single-tab-active': singleTab == 'crossing'}"></mu-tab>
                    </mu-tabs>
                </div>
            </div>
            <div class="no-print" style="height: 48px"></div>
            <div class="body-right print-scroll border-none" :style="singleRightStyle" style="background-color: inherit;">
                <div id="singlePrintId" class="single-content page-next" :style="singleContent">
                    <%--事故数、事故严重程度--%>
                        <div class="chart-type-class" :style="chartStyle">
                            <div class="table-class">
                                <div class="title-class">各严重程度类型事故汇总</div>
                                <hr/>
                                <mu-table :fixed-header="true" :selectable="false" :show-checkbox="false">
                                    <mu-thead slot="header">
                                        <mu-tr>
                                            <mu-th v-for="item, index in singleShowData.accTable.key" :key="index">{{item}}</mu-th>
                                        </mu-tr>
                                    </mu-thead>
                                    <mu-tbody>
                                        <mu-tr>
                                            <mu-td v-for="item, index in singleShowData.accTable.value" :key="index">{{item}}</mu-td>
                                        </mu-tr>
                                    </mu-tbody>
                                </mu-table>
                            </div>
                            <div v-cloak v-show="isChartShow" id="accHistogram" class="chart-class"></div>
                            <div v-cloak v-show="isChartShow" id="accPie" class="chart-class"></div>
                        </div>
                    <%--事故类型--%>
                        <div class="chart-type-class page-next" :style="chartStyle">
                            <div class="table-class">
                                <div class="title-class">各事故类型事故汇总</div>
                                <hr/>
                                <mu-table :fixed-header="true" :selectable="false" :show-checkbox="false">
                                    <mu-thead slot="header">
                                        <mu-tr>
                                            <mu-th v-for="item, index in singleShowData.accTypeTable.key" :key="index">{{item}}</mu-th>
                                        </mu-tr>
                                    </mu-thead>
                                    <mu-tbody>
                                        <mu-tr>
                                            <mu-td v-for="item, index in singleShowData.accTypeTable.value" :key="index">{{item}}</mu-td>
                                        </mu-tr>
                                    </mu-tbody>
                                </mu-table>
                            </div>
                            <div v-cloak v-show="isChartShow" id="accTypeHistogram" class="chart-class"></div>
                            <div v-cloak v-show="isChartShow" id="accTypePie" class="chart-class"></div>
                        </div>
                    <%--天气--%>
                        <div class="chart-type-class page-next" :style="chartStyle">
                            <div class="table-class">
                                <div class="title-class">各天气类型事故汇总</div>
                                <hr/>
                                <mu-table :fixed-header="true" :selectable="false" :show-checkbox="false">
                                    <mu-thead slot="header">
                                        <mu-tr>
                                            <mu-th v-for="item, index in singleShowData.weaTable.key" :key="index">{{item}}</mu-th>
                                        </mu-tr>
                                    </mu-thead>
                                    <mu-tbody>
                                        <mu-tr>
                                            <mu-td v-for="item, index in singleShowData.weaTable.value" :key="index">{{item}}</mu-td>
                                        </mu-tr>
                                    </mu-tbody>
                                </mu-table>
                            </div>
                            <div v-cloak v-show="isChartShow" id="weaHistogram" class="chart-class"></div>
                            <div v-cloak v-show="isChartShow" id="weaPie" class="chart-class"></div>
                        </div>
                    <%--车辆类型--%>
                        <div class="chart-type-class page-next" :style="chartStyle">
                            <div class="table-class">
                                <div class="title-class">各车辆类型事故汇总</div>
                                <hr/>
                                <mu-table :fixed-header="true" :selectable="false" :show-checkbox="false">
                                    <mu-thead slot="header">
                                        <mu-tr>
                                            <mu-th v-for="item, index in singleShowData.carTable.key" :key="index">{{item}}</mu-th>
                                        </mu-tr>
                                    </mu-thead>
                                    <mu-tbody>
                                        <mu-tr>
                                            <mu-td v-for="item, index in singleShowData.carTable.value" :key="index">{{item}}</mu-td>
                                        </mu-tr>
                                    </mu-tbody>
                                </mu-table>
                            </div>
                            <div v-cloak v-show="isChartShow" id="carHistogram" class="chart-class"></div>
                            <div v-cloak v-show="isChartShow" id="carPie" class="chart-class"></div>
                        </div>
                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'space'" v-cloak :style="bodyContent">
            <div class="time-body-left time-body-left-float no-print" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <div v-cloak v-show="!spaceShowSelect">
                    <mu-icon-button v-cloak icon="navigate_next" tooltip-position="bottom-right" tooltip="筛选条件" class="single-open-btn" @click="openSpaceShow"></mu-icon-button>
                </div>
                <div v-cloak v-show="spaceShowSelect" class="single-select-left">
                    <mu-icon-button v-cloak icon="navigate_before" tooltip-position="bottom-right" tooltip="收起" class="single-close-btn" @click="closeSpaceShow"></mu-icon-button>
                    <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段">
                        <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class">选择分析的区域</div>
                    <mu-radio label="行政区" name="area3" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 20px;" @change="areaRadioChange"></mu-radio>
                    <mu-radio label="大队" name="area3" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;" @change="areaRadioChange"></mu-radio>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'gruppe'" max-height="300" scroller hint-text="null" v-model="selectData.area.gruppeVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区" multiple>
                        <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'administrative'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                        <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class" style="padding-top: 12px; display: inline-block">选择分析的时间段</div>
                    <mu-checkbox label="工作日" class="work-checkbox" :icon-class="{'icon-class': true}" label-left @change="workDayChange"></mu-checkbox>
                    <mu-date-picker auto-ok hint-text="开始监测日期" :should-disable-date="disableWeekends" v-model="selectData.dateTime.start" container="inline" mode="landscape" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                    <mu-date-picker auto-ok hint-text="至截止监测日期" :should-disable-date="disableWeekends" v-model="selectData.dateTime.end" container="inline" mode="landscape" :underline-class="{'underline-class': true}"></mu-date-picker>
                    <div class="mu-text-field-label label-class">图形纵坐标选择</div>
                    <mu-radio label="事故数" name="ordinate1" native-value="accidentCount" :icon-class="{'icon-class': true}" v-model="selectData.yType"></mu-radio>
                    <mu-radio label="事故严重程度" name="ordinate1" native-value="accidentLevel" :icon-class="{'icon-class': true}" v-model="selectData.yType" style="margin-left: 20px;" @change="accidentLChange"></mu-radio>
                    <mu-select-field v-cloak v-show="selectData.yType == 'accidentLevel'" v-model="selectData.accidentalSev" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="事故严重程度" hint-text="null" multiple>
                        <mu-menu-item v-for="text,index in basicData.accidentalSev" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div v-cloak v-show="selectData.yType == 'accidentCount'" style="height: 10px;"></div>
                    <mu-raised-button label="细节筛选" icon="widgets" label-position="before" primary class="detail-two-btn" @click="details"></mu-raised-button>
                    <mu-icon-button tooltip="筛选结果" tooltip-position="bottom-right" icon="call_merge" class="right-btn" @click="spaceGet"></mu-icon-button>
                    <mu-icon-button tooltip="下载excel报告" tooltip-position="bottom-right" icon="file_download" class="right-btn" @click="spaceDown" style="margin-right: 13px;"></mu-icon-button>
                    <%--<mu-icon-button tooltip="筛选数据重置" tooltip-position="bottom-right" icon="grade" class="right-btn" @click="spaceGet"></mu-icon-button>--%>
                </div>
            </div>
            <div class="body-right" :style="rightStyle">
                <div id="spaceMap" class="map">

                </div>
                <div v-cloak v-show="selectData.yType == 'accidentLevel'" style="position: absolute; left: 60px; top: 50px; height: 50px;">
                    <div class="mapbarchild">
                        <div style="margin: auto; width: 30px; height: 20px; background: red;"></div>
                        <p style="margin: auto; text-align: center; color: white;">总数</p>
                    </div>
                    <div class="mapbarchild" style="left: 50px;">
                        <div style="margin: auto; width: 30px; height: 20px; background: lightgreen;"></div>
                        <p style="margin: auto; text-align: center; color: white;">财损</p>
                    </div>
                    <div class="mapbarchild" style="left: 90px;">
                        <div style="margin: auto; width: 30px; height: 20px; background: rgb(255,0,255);"></div>
                        <p style="margin: auto; text-align: center; color: white;">轻伤</p>
                    </div>
                    <div class="mapbarchild" style="left: 130px;">
                        <div style="margin: auto; width: 30px; height: 20px; background: yellow;"></div>
                        <p style="margin: auto; text-align: center; color: white;">重伤</p>
                    </div>
                    <div class="mapbarchild" style="left: 170px;">
                        <div style="margin: auto; width: 30px; height: 20px; background: lightcoral;"></div>
                        <p style="margin: auto; text-align: center; color: white;">死亡</p>
                    </div>
                </div>
            </div>
        </div>
        <div v-show="nowFuc == 'time'" v-cloak :style="bodyContent">
            <div class="time-body-left time-body-left-float no-print" :class="{'left-float-open': isFirstLoad && isShowItems, 'left-float-close': isFirstLoad && !isShowItems}">
                <div v-cloak v-show="!timeShowSelect">
                    <mu-icon-button v-cloak icon="navigate_next" tooltip-position="bottom-right" tooltip="筛选条件" class="single-open-btn" @click="openTimeShow"></mu-icon-button>
                    <mu-icon-button v-cloak v-show="timeDownShow" tooltip="导出当前pdf报告" tooltip-position="bottom-right" icon="print" class="single-open-btn" class="right-btn" @click="timeChartPrint" style="margin-left: 10px;"></mu-icon-button>
                </div>
                <div v-cloak v-show="timeShowSelect" class="single-select-left">
                    <mu-icon-button v-cloak icon="navigate_before" tooltip-position="bottom-right" tooltip="收起" class="single-close-btn" @click="closeTimeShow"></mu-icon-button>
                    <mu-select-field v-model="selectData.analysisObj" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="选择交叉口或路段">
                        <mu-menu-item v-for="text,index in basicData.analysisObj" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class">选择分析的区域</div>
                    <mu-radio label="行政区" name="area4" native-value="administrative" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 20px;" @change="areaRadioChange"></mu-radio>
                    <mu-radio label="大队" name="area4" native-value="gruppe" :icon-class="{'icon-class': true}" v-model="selectData.area.type" style="margin-left: 50px;" @change="areaRadioChange"></mu-radio>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'gruppe'" max-height="300" scroller hint-text="null" v-model="selectData.area.gruppeVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="大队管辖区" multiple>
                        <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <mu-select-field v-cloak v-show="selectData.area.type == 'administrative'" max-height="300" scroller hint-text="null" v-model="selectData.area.adminiVal" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="行政管辖区">
                        <mu-menu-item v-for="text,index in basicData.area.administrative" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div class="mu-text-field-label label-class" style="padding-top: 12px;">选择分析的时间段</div>
                    <mu-date-picker auto-ok hint-text="开始监测日期" v-model="selectData.dateTime.start" container="inline" mode="landscape" min-date="2016-09-01" :underline-class="{'underline-class': true}"></mu-date-picker>
                    <mu-date-picker auto-ok hint-text="至截止监测日期" v-model="selectData.dateTime.end" container="inline" mode="landscape" :underline-class="{'underline-class': true}"></mu-date-picker>
                    <div class="mu-text-field-label label-class">图形分析纵坐标选择</div>
                    <mu-radio label="事故数" name="ordinate2" native-value="accidentCount" :icon-class="{'icon-class': true}" v-model="selectData.yType"></mu-radio>
                    <mu-radio label="事故严重程度" name="ordinate2" native-value="accidentLevel" :icon-class="{'icon-class': true}" v-model="selectData.yType" style="margin-left: 20px;" @change="accidentLChange"></mu-radio>
                    <mu-select-field v-cloak v-show="selectData.yType == 'accidentLevel'" v-model="selectData.accidentalSev" :label-class="{'label-class': true}" :underline-class="{'underline-class': true}" :drop-down-icon-class="{'drop-down-icon-class': true}" label="事故严重程度" hint-text="null" multiple>
                        <mu-menu-item v-for="text,index in basicData.accidentalSev" :key="index" :value="text" :title="text" ></mu-menu-item>
                    </mu-select-field>
                    <div v-cloak v-show="selectData.yType == 'accidentCount'" style="height: 10px;"></div>
                    <div class="mu-text-field-label label-class">图形分析时间精度选取</div>
                    <mu-radio label="年" name="timePre" native-value="1" :icon-class="{'icon-class': true}" v-model="selectData.timePrecision"></mu-radio>
                    <mu-radio label="月" name="timePre" native-value="2" :icon-class="{'icon-class': true}" v-model="selectData.timePrecision" style="margin-left: 35px;"></mu-radio>
                    <mu-radio label="日" name="timePre" native-value="3" :icon-class="{'icon-class': true}" v-model="selectData.timePrecision" style="margin-left: 35px;"></mu-radio>
                    <div style="height: 10px;"></div>
                    <mu-raised-button label="细节筛选" icon="widgets" label-position="before" primary class="detail-one-btn" @click="details"></mu-raised-button>
                    <mu-icon-button tooltip="筛选结果" tooltip-position="bottom-right" icon="call_merge" class="right-btn" @click="timeGet"></mu-icon-button>
                    <%--<mu-icon-button tooltip="筛选数据重置" tooltip-position="bottom-right" icon="grade" class="right-btn" @click="timeGet"></mu-icon-button>--%>
                </div>
            </div>

            <div class="body-right time-body-right" :style="rightStyle">
               <!-- <div id="timeMap" class="map">
                </div>-->
                <div id="timePrintId" :style="chartStyle">
                    <div id="timeLine" class="time-chart-class" :style="singleContent">
                    </div>
                </div>
            </div>
        </div>
        <div v-if="nowFuc == 'statistics'" v-cloak class="statistics" :style="bodyContent">
            <span>此功能尚未开通！</span>
        </div>
    </div>

    <mu-dialog v-cloak :open="loginDialog" title="泸州市交通事故数据分析系统" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" >
        <mu-text-field label="请输入您的用户名|警号" :full-width="true" label-float v-model="loginInfor.userName"></mu-text-field>
        <mu-text-field label="请输入您的密码" type="password" :full-width="true" label-float v-model="loginInfor.password"></mu-text-field>
        <mu-flat-button v-show="isLogin" v-cloak slot="actions" primary @click="loginCancel" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="loginConfirm" label="登录"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="detailDialog" title="交通事故细节筛选" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="detailClose">
        <mu-select-field v-model="selectData.roadGrade" :full-width="true" label="道路等级">
            <mu-menu-item v-for="text,index in basicData.roadGrade" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <%--<mu-select-field v-model="selectData.accident.type" :full-width="true" label="事故类型">--%>
            <%--<mu-menu-item v-for="text,index in basicData.accident.type" :key="index" :value="text" :title="text" ></mu-menu-item>--%>
        <%--</mu-select-field>--%>
        <mu-select-field v-model="selectData.carCollisionType" :full-width="true" label="车辆碰撞类型">
            <mu-menu-item v-for="text,index in basicData.carCollisionType" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.weather" :full-width="true" label="天气">
            <mu-menu-item v-for="text,index in basicData.weather" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.workZone.flag" :full-width="true" label="作业区">
            <mu-menu-item v-for="text,index in basicData.workZone.flag" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.intersectionType" :full-width="true" label="交叉口类型">
            <mu-menu-item v-for="text,index in basicData.intersectionType" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.vehicleType" :full-width="true" label="车辆类型">
            <mu-menu-item v-for="text,index in basicData.vehicleType" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="selectData.hitAndRun" :full-width="true" label="肇事逃逸">
            <mu-menu-item v-for="text,index in basicData.hitAndRun" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-flat-button slot="actions" primary @click="detailClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="detailConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="updateUserDialog" title="修改用户信息" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="updateUserClose">
        <mu-text-field v-model="userObj.name" label="用户名" :full-width="true" hint-text="null"></mu-text-field>
        <mu-text-field v-model="userObj.password" label="密码" :full-width="true" hint-text="null"></mu-text-field>
        <mu-select-field max-height="300" scroller hint-text="null" v-model="userObj.gruppe" :full-width="true" label="所属大队">
            <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="userObj.isSupper" :full-width="true" hint-text="null" label="用户类型">
            <mu-menu-item value="0" title="普通用户" ></mu-menu-item>
            <mu-menu-item value="1" title="管理员" ></mu-menu-item>
        </mu-select-field>
        <mu-flat-button slot="actions" primary @click="updateUserClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="updateUserConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="updateGruppeDialog" title="修改大队信息" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="updateGruppeClose">
        <mu-text-field v-model="gruppeObj.teamName" label="用户名" :full-width="true" hint-text="null"></mu-text-field>
        <mu-flat-button slot="actions" primary @click="updateGruppeClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="updateGruppeConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="addUserDialog" title="添加用户" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="addUserClose">
        <mu-text-field v-model="userObj.name" label="用户名" :full-width="true" hint-text="null"></mu-text-field>
        <mu-text-field v-model="userObj.password" type="password" label="密码" :full-width="true" hint-text="null"></mu-text-field>
        <mu-text-field v-model="userObj.repassword" type="password" label="密码确认" :full-width="true" hint-text="null"></mu-text-field>
        <mu-select-field max-height="300" scroller hint-text="null" v-model="userObj.gruppe" :full-width="true" label="所属大队">
            <mu-menu-item v-for="text,index in basicData.area.gruppe" :key="index" :value="text" :title="text" ></mu-menu-item>
        </mu-select-field>
        <mu-select-field v-model="userObj.isSupper" :full-width="true" hint-text="null" label="用户类型">
            <mu-menu-item value="0" title="普通用户" ></mu-menu-item>
            <mu-menu-item value="1" title="管理员" ></mu-menu-item>
        </mu-select-field>
        <mu-flat-button slot="actions" primary @click="addUserClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="addUserConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="addGruppeDialog" title="添加大队" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="addGruppeClose">
        <mu-text-field v-model="gruppeObj.teamName" label="用户名" :full-width="true" hint-text="null"></mu-text-field>
        <mu-flat-button slot="actions" primary @click="addGruppeClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="addGruppeConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-dialog v-cloak :open="deleteUserDialog" title="确定删除该用户" class="no-print" dialog-class="dialog" title-class="dialog-title" body-class="dialog-body" @close="deleteUserClose">
        <mu-flat-button slot="actions" primary @click="deleteUserClose" label="取消"></mu-flat-button>
        <mu-flat-button slot="actions" primary @click="deleteUserConfirm" label="确认"></mu-flat-button>
    </mu-dialog>

    <mu-popup position="top" v-cloak :overlay="false" :open="showMessageTop" class="no-print" popup-class="popup-top">
        <span :class="{'succeed-text': textFlag, 'failure-text': !textFlag}">{{ messageTop }}</span>
    </mu-popup>

    <div v-if="showDialogLoading" v-cloak class="dialog-loading ">
        <table style="width: 100%; height: 100%;">
            <tr>
                <td>
                    <div class="sk-cube-grid">
                        <div class="sk-cube sk-cube1"></div>
                        <div class="sk-cube sk-cube2"></div>
                        <div class="sk-cube sk-cube3"></div>
                        <div class="sk-cube sk-cube4"></div>
                        <div class="sk-cube sk-cube5"></div>
                        <div class="sk-cube sk-cube6"></div>
                        <div class="sk-cube sk-cube7"></div>
                        <div class="sk-cube sk-cube8"></div>
                        <div class="sk-cube sk-cube9"></div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>

<script src="libs/vue/vue.min.js"></script>
<script src="libs/muse-ui-2.1.0/muse-ui.js"></script>

<script src="libs/Highcharts-6.0.1/highcharts.src.js"></script>
<script src="libs/Highcharts-6.0.1/themes/sand-signika.src.js"></script>
<script src="libs/Highcharts-6.0.1/modules/exporting.src.js"></script>

<script src="libs/axios-0.17.0/axios.min.js"></script>

<script src="http://webapi.amap.com/maps?v=1.4.1&key=396befe7016bef31b674c361915d082e"></script>

<script src="js/index.js"></script>
<script src="js/map.js"></script>
</body>
</html>