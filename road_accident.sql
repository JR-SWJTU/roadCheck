/*
Navicat MySQL Data Transfer

Source Server         : Exp
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : road_accident

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-10-20 10:21:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accidencecollectiondata
-- ----------------------------
DROP TABLE IF EXISTS `accidencecollectiondata`;
CREATE TABLE `accidencecollectiondata` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `shigunumber` text NOT NULL,
  `place` text NOT NULL,
  `riqi` text NOT NULL,
  `accidencenumber` text NOT NULL,
  `environmentnumber` text NOT NULL,
  `carnumber` text NOT NULL,
  `peopelnumber` text NOT NULL,
  `isUpload` int(11) NOT NULL,
  `admin_id` int(11) DEFAULT NULL COMMENT '事故记录人员id',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accidencecollectiondata
-- ----------------------------
INSERT INTO `accidencecollectiondata` VALUES ('1', 'SG20171009015141', '成都市郫都区安靖方安路118号5号楼', '1507528301413', 'SG20171009015141', 'SG20171009015141', 'SG20171009015141', 'SG20171009015141', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('2', 'SG20171009120145', '成都市郫都区安靖', '1507521706223', 'SG20171009120145', 'SG20171009120145', 'SG20171009120145', 'SG20171009120145', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('3', 'SG20171009022400', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '1507530247021', 'SG20171009022400', 'SG20171009022400', 'SG20171009022400', 'SG20171009022400', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('4', 'SG20171009022540', '成都市郫都区安靖正义路', '1507530340982', 'SG20171009022540', 'SG20171009022540', 'SG20171009022540', 'SG20171009022540', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('5', 'SG20171009023307', '成都市金牛区天回万石路与天歌路交叉口', '1507530787577', 'SG20171009023307', 'SG20171009023307', 'SG20171009023307', 'SG20171009023307', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('6', 'SG20171009121524', '成都市郫都区安靖', '1507522524634', 'SG20171009121524', 'SG20171009121524', 'SG20171009121524', 'SG20171009121524', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('7', 'SG20171009023611', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '1507530971714', 'SG20171009023611', 'SG20171009023611', 'SG20171009023611', 'SG20171009023611', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('8', 'SG20171009025345', '成都市金牛区长庆路4号5幢', '1507532025824', 'SG20171009025345', 'SG20171009025345', 'SG20171009025345', 'SG20171009025345', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('9', 'SG20171009031528', '成都市金牛区天回万石路与大天路交叉口', '1507533329163', 'SG20171009031528', 'SG20171009031528', 'SG20171009031528', 'SG20171009031528', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('10', 'SG20171009033410', '成都市郫都区安靖', '1507534451204', 'SG20171009033410', 'SG20171009033410', 'SG20171009033410', 'SG20171009033410', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('11', '1', '222', '1507641636969', 'null', 'null', 'null', 'null', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('12', 'SG20171016015322', '成都市金牛区盛发街与盛金路交叉口', '1508133203193', 'SG20171016015322', 'SG20171016015322', 'SG20171016015322', 'SG20171016015322', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('13', 'SG20171016015600', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '1508133361228', 'SG20171016015600', 'SG20171016015600', 'SG20171016015600', 'SG20171016015600', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('14', 'SG20171016014844', '成都市武侯区武兴路与金江路交叉口', '1508132924218', 'SG20171016014844', 'SG20171016014844', 'SG20171016014844', 'SG20171016014844', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('15', 'SG20171016020015', '成都市郫都区犀浦天朗路与西区大道交叉口', '1508133615300', 'SG20171016020015', 'SG20171016020015', 'SG20171016020015', 'SG20171016020015', '1', null);

-- ----------------------------
-- Table structure for accidentdata
-- ----------------------------
DROP TABLE IF EXISTS `accidentdata`;
CREATE TABLE `accidentdata` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `accidencnumber` text NOT NULL,
  `riQI` text,
  `city` text,
  `xianQu` text,
  `shangQuan` text,
  `lat` double NOT NULL,
  `lng` double NOT NULL,
  `diMingBeiZhu` text,
  `shigu` text,
  `shiguType` text,
  `shigu2` text,
  `shiguType2` text,
  `yanZhongCd` text,
  `carnum` text,
  `driverNums` text,
  `feidriverNums` text,
  `ssNums` text,
  `dieNums` text,
  `gongjiao` text,
  `taoYi` text,
  `Weixianche` text,
  `Weixianbz` text,
  `fromWeixianbz` text,
  `youHaiWuZhi` text,
  `is_workday` tinyint(1) DEFAULT NULL COMMENT '是否工作日标识',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accidentdata
-- ----------------------------
INSERT INTO `accidentdata` VALUES ('1', '222', '154444', '222', '222', '222', '11', '22', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', null);
INSERT INTO `accidentdata` VALUES ('2', 'SG20171009025345', '1507532025824', '成都市', '金牛区', '', '90', '30.7044', '长庆路4号5幢', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('3', 'SG20171009031433', '1507533274147', '成都市', '金牛区', '', '90', '30.718', '过境国道与韦家碾三路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('4', 'SG20171009031528', '1507533329163', '成都市', '金牛区', '天回', '90', '30.753', '万石路与大天路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('5', 'SG20171009033410', '1507534451204', '成都市', '郫都区', '安靖', '90', '30.6938', '', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('6', 'SG20171016015322', '1508133203193', '成都市', '金牛区', '', '90', '30.7244', '盛发街与盛金路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('7', 'SG20171016015600', '1508133361228', '成都市', '郫都区', '安靖', '90', '30.7709', '犀湖(西南交大犀浦校区)', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '1辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('8', 'SG20171016014844', '1508132924218', '成都市', '武侯区', '', '90', '30.6138', '武兴路与金江路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('9', 'SG20171016020015', '1508133615300', '成都市', '郫都区', '犀浦', '90', '30.7414', '天朗路与西区大道交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(50) DEFAULT NULL COMMENT '管理员登录密码（密文）',
  `team_id` int(20) DEFAULT NULL COMMENT '大队编号',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'jisir', '123456', null);

-- ----------------------------
-- Table structure for cardata
-- ----------------------------
DROP TABLE IF EXISTS `cardata`;
CREATE TABLE `cardata` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `carnumber` text,
  `xunhao` int(11) DEFAULT NULL,
  `vin` text,
  `chepaihao` text,
  `guobie` text,
  `nianfen` text,
  `pingpai` text,
  `carType` text,
  `Leixing` text,
  `cheneinum` text,
  `tesuzuoyong` text,
  `xingshifangxing` text,
  `Xingwei` text,
  `Jiechudian` text,
  `sunhuaibuwei` text,
  `sunhuaschengdu` text,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cardata
-- ----------------------------
INSERT INTO `cardata` VALUES ('1', 'SG20171009033410', '1', '', '', '中国', '2017', '', '', '01  驾驶大型客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');
INSERT INTO `cardata` VALUES ('2', 'SG20171016015600', '1', '', '', '中国', '2017', '', '', '01  小客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');
INSERT INTO `cardata` VALUES ('3', 'SG20171016015322', '1', '', '44', '中国', '2017', '', '', '01  小客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');
INSERT INTO `cardata` VALUES ('4', 'SG20171016014844', '1', '', '0001', '中国', '2017', '', '', '01  小客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');
INSERT INTO `cardata` VALUES ('5', 'SG20171016020015', '3', '', '999', '中国', '2017', '', '', '01  小客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');
INSERT INTO `cardata` VALUES ('6', 'SG20171016020015', '1', '', '888', '中国', '2017', '', '', '01  小客车', '0', '01  无特殊作用', '01  向北', '01  几乎直行', '01  无碰撞', '01  未知', '01  无损坏');

-- ----------------------------
-- Table structure for chenzuo_peopel_data
-- ----------------------------
DROP TABLE IF EXISTS `chenzuo_peopel_data`;
CREATE TABLE `chenzuo_peopel_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aqqnzt` varchar(255) DEFAULT NULL,
  `ceshiresult` varchar(255) DEFAULT NULL,
  `ceshitype` varchar(255) DEFAULT NULL,
  `ceshizhuangtai` varchar(255) DEFAULT NULL,
  `cheliangxunhao` varchar(255) DEFAULT NULL,
  `du_ping_lei_xing` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paochuzhuangta` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `renyuantype` varchar(255) DEFAULT NULL,
  `sgfsszhuangtai` varchar(255) DEFAULT NULL,
  `shenfentype` varchar(255) DEFAULT NULL,
  `sschengdu` varchar(255) DEFAULT NULL,
  `tuokuishiyong` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yinjiu` varchar(255) DEFAULT NULL,
  `ysxitong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chenzuo_peopel_data
-- ----------------------------

-- ----------------------------
-- Table structure for driver_peo_pel_data
-- ----------------------------
DROP TABLE IF EXISTS `driver_peo_pel_data`;
CREATE TABLE `driver_peo_pel_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aqqnzt` varchar(255) DEFAULT NULL,
  `ceshiresult` varchar(255) DEFAULT NULL,
  `ceshitype` varchar(255) DEFAULT NULL,
  `ceshizhuangtai` varchar(255) DEFAULT NULL,
  `chaosuxunwen` varchar(255) DEFAULT NULL,
  `cheliangxunhao` varchar(255) DEFAULT NULL,
  `dengji` varchar(255) DEFAULT NULL,
  `du_ping_lei_xing` varchar(255) DEFAULT NULL,
  `fenxinjiashi` varchar(255) DEFAULT NULL,
  `guanxiaqu` varchar(255) DEFAULT NULL,
  `jiazhao` varchar(255) DEFAULT NULL,
  `jiazhaoxianzhi` varchar(255) DEFAULT NULL,
  `jtwfxingwei` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `paochuzhuangta` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `qianzhu` varchar(255) DEFAULT NULL,
  `renyuantype` varchar(255) DEFAULT NULL,
  `sgfssxingwie` varchar(255) DEFAULT NULL,
  `sgfsszhuangt` varchar(255) DEFAULT NULL,
  `sgfsszhuangtai` varchar(255) DEFAULT NULL,
  `shangyejiazhao` varchar(255) DEFAULT NULL,
  `shenfentype` varchar(255) DEFAULT NULL,
  `sschengdu` varchar(255) DEFAULT NULL,
  `tuokuishiyong` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yinjiu` varchar(255) DEFAULT NULL,
  `ysxitong` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of driver_peo_pel_data
-- ----------------------------

-- ----------------------------
-- Table structure for emdata
-- ----------------------------
DROP TABLE IF EXISTS `emdata`;
CREATE TABLE `emdata` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `emnumber` text NOT NULL,
  `Routeposition` text,
  `pengzhuangleixing` text,
  `liJiaoQuYu` text,
  `Jcktype` text,
  `Teshuposition` text,
  `Tianqicondition` text,
  `zhaomingcondition` text,
  `luMianCondition` text,
  `luMianLev` text,
  `limitSpeed` text,
  `chedaowidth` text,
  `luJianWidth` text,
  `bianYuanXianle` text,
  `zhongyanwidht` text,
  `zhongXinXian` text,
  `chedaoxianbj` text,
  `jiaotongkzlx` text,
  `zhuchedaoshu` text,
  `jiaochajiedaoshu` text,
  `WorkPlaceR` text,
  `Worktype` text,
  `havepeople` text,
  `xianChangZhifa` text,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emdata
-- ----------------------------
INSERT INTO `emdata` VALUES ('1', 'SG20171009031528', '01  在路中', '未知', '01  否', '01  非交叉口', '01  进/出口匝道', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('2', 'SG20171009033410', '01  在路中', '未知', '01  否', '01  非交叉口', '01  进/出口匝道', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('3', 'SG20171016015322', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('4', 'SG20171016015600', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('5', 'SG20171016014844', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('6', 'SG20171016020015', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', 'no', '01  车道关闭', '01  否', '01  无');

-- ----------------------------
-- Table structure for qita_peopel_data
-- ----------------------------
DROP TABLE IF EXISTS `qita_peopel_data`;
CREATE TABLE `qita_peopel_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aqsbsyzhuangtai` varchar(255) DEFAULT NULL,
  `ceshiresult` varchar(255) DEFAULT NULL,
  `ceshitype` varchar(255) DEFAULT NULL,
  `ceshizhuangtai` varchar(255) DEFAULT NULL,
  `cheliangxunhao` varchar(255) DEFAULT NULL,
  `du_ping_lei_xing` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phonenum` varchar(255) DEFAULT NULL,
  `renyuantype` varchar(255) DEFAULT NULL,
  `sgfsosition` varchar(255) DEFAULT NULL,
  `sgfsqxingwei` varchar(255) DEFAULT NULL,
  `sgfssxingwei` varchar(255) DEFAULT NULL,
  `sgfsszhuangtai` varchar(255) DEFAULT NULL,
  `shenfentype` varchar(255) DEFAULT NULL,
  `sschengdu` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yinjiu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qita_peopel_data
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `team_name` varchar(50) DEFAULT NULL COMMENT '大队名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
