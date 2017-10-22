/*
Navicat MySQL Data Transfer

Source Server         : Exp
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : road_accident

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-10-21 17:08:41
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
  `riqi` datetime NOT NULL,
  `accidencenumber` text NOT NULL,
  `environmentnumber` text NOT NULL,
  `carnumber` text NOT NULL,
  `peopelnumber` text NOT NULL COMMENT '没用的字段',
  `isUpload` int(11) NOT NULL,
  `admin_id` int(11) DEFAULT NULL COMMENT '事故记录人员id',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accidencecollectiondata
-- ----------------------------
INSERT INTO `accidencecollectiondata` VALUES ('1', 'SG20171009015141', '成都市郫都区安靖方安路118号5号楼', '2017-10-03 17:05:37', 'SG20171009015141', 'SG20171009015141', 'SG20171009015141', 'SG20171009015141', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('2', 'SG20171009120145', '成都市郫都区安靖', '2017-10-03 17:05:46', 'SG20171009120145', 'SG20171009120145', 'SG20171009120145', 'SG20171009120145', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('3', 'SG20171009022400', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '2017-10-05 17:05:50', 'SG20171009022400', 'SG20171009022400', 'SG20171009022400', 'SG20171009022400', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('4', 'SG20171009022540', '成都市郫都区安靖正义路', '2017-10-10 17:05:57', 'SG20171009022540', 'SG20171009022540', 'SG20171009022540', 'SG20171009022540', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('5', 'SG20171009023307', '成都市金牛区天回万石路与天歌路交叉口', '2017-10-02 17:05:54', 'SG20171009023307', 'SG20171009023307', 'SG20171009023307', 'SG20171009023307', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('6', 'SG20171009121524', '成都市郫都区安靖', '2017-10-02 17:06:22', 'SG20171009121524', 'SG20171009121524', 'SG20171009121524', 'SG20171009121524', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('7', 'SG20171009023611', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '2017-10-06 17:06:30', 'SG20171009023611', 'SG20171009023611', 'SG20171009023611', 'SG20171009023611', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('8', 'SG20171009025345', '成都市金牛区长庆路4号5幢', '2017-10-11 17:06:33', 'SG20171009025345', 'SG20171009025345', 'SG20171009025345', 'SG20171009025345', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('9', 'SG20171009031528', '成都市金牛区天回万石路与大天路交叉口', '2017-10-23 17:06:36', 'SG20171009031528', 'SG20171009031528', 'SG20171009031528', 'SG20171009031528', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('10', 'SG20171009033410', '成都市郫都区安靖', '2017-11-22 17:06:25', 'SG20171009033410', 'SG20171009033410', 'SG20171009033410', 'SG20171009033410', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('11', '1', '222', '2017-10-18 17:06:39', 'null', 'null', 'null', 'null', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('12', 'SG20171016015322', '成都市金牛区盛发街与盛金路交叉口', '2017-10-21 17:06:42', 'SG20171016015322', 'SG20171016015322', 'SG20171016015322', 'SG20171016015322', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('13', 'SG20171016015600', '成都市郫都区安靖犀湖(西南交大犀浦校区)', '2017-10-19 17:06:45', 'SG20171016015600', 'SG20171016015600', 'SG20171016015600', 'SG20171016015600', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('14', 'SG20171016014844', '成都市武侯区武兴路与金江路交叉口', '2017-10-09 17:06:48', 'SG20171016014844', 'SG20171016014844', 'SG20171016014844', 'SG20171016014844', '1', null);
INSERT INTO `accidencecollectiondata` VALUES ('15', 'SG20171016020015', '成都市郫都区犀浦天朗路与西区大道交叉口', '2017-10-19 17:06:52', 'SG20171016020015', 'SG20171016020015', 'SG20171016020015', 'SG20171016020015', '1', null);

-- ----------------------------
-- Table structure for accidentdata
-- ----------------------------
DROP TABLE IF EXISTS `accidentdata`;
CREATE TABLE `accidentdata` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `accidencnumber` text NOT NULL,
  `riQI` datetime DEFAULT NULL,
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
INSERT INTO `accidentdata` VALUES ('1', '222', '2017-10-03 17:05:37', '222', '222', '222', '11', '22', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', '222', null);
INSERT INTO `accidentdata` VALUES ('2', 'SG20171009025345', '2017-10-03 17:05:46', '成都市', '金牛区', '', '90', '30.7044', '长庆路4号5幢', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('3', 'SG20171009031433', '2017-10-05 17:05:50', '成都市', '金牛区', '', '90', '30.718', '过境国道与韦家碾三路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('4', 'SG20171009031528', '2017-10-10 17:05:57', '成都市', '金牛区', '天回', '90', '30.753', '万石路与大天路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('5', 'SG20171009033410', '2017-10-02 17:05:54', '成都市', '郫都区', '安靖', '90', '30.6938', '', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  致命伤（K）', '1辆', '', '', '', '', '01  非巴士', '否，没有离开现场', '是', '无', '01 菱形或方形框中间的4位危险有害物识别码', '否', null);
INSERT INTO `accidentdata` VALUES ('6', 'SG20171016015322', '2017-10-02 17:06:22', '成都市', '金牛区', '', '90', '30.7244', '盛发街与盛金路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('7', 'SG20171016015600', '2017-10-06 17:06:30', '成都市', '郫都区', '安靖', '90', '30.7709', '犀湖(西南交大犀浦校区)', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '1辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('8', 'SG20171016014844', '2017-10-11 17:06:33', '成都市', '武侯区', '', '90', '30.6138', '武兴路与金江路交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);
INSERT INTO `accidentdata` VALUES ('9', 'SG20171016020015', '2017-10-23 17:06:36', '成都市', '郫都区', '犀浦', '90', '30.7414', '天朗路与西区大道交叉口', '01  非碰撞', '01  翻车', '01  非碰撞', '01  翻车', '01  仅财产损失（O）', '2辆', '', '', '', '', '01  非公交', '否', '是', '无', '', '否', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'jisir', '123456', '1');
INSERT INTO `admin` VALUES ('2', 'wgx', '123456', '2');

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
  `xingshifangxing` text COMMENT '行驶方向',
  `Xingwei` text,
  `Jiechudian` text,
  `sunhuaibuwei` text,
  `sunhuaschengdu` text COMMENT '损坏程度',
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
  `sgfsszhuangtai` varchar(255) DEFAULT NULL COMMENT '事故发生时状态',
  `shenfentype` varchar(255) DEFAULT NULL,
  `sschengdu` varchar(255) DEFAULT NULL COMMENT '受损程度',
  `tuokuishiyong` varchar(255) DEFAULT NULL COMMENT '头盔使用',
  `xingbie` varchar(255) DEFAULT NULL,
  `yinjiu` varchar(255) DEFAULT NULL,
  `ysxitong` varchar(255) DEFAULT NULL COMMENT '约束系统',
  `shigunumber` text COMMENT 'accidentCollectiondata中的shigunumber',
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
  `aqqnzt` varchar(255) DEFAULT NULL COMMENT '安状态全气囊',
  `ceshiresult` varchar(255) DEFAULT NULL,
  `ceshitype` varchar(255) DEFAULT NULL,
  `ceshizhuangtai` varchar(255) DEFAULT NULL,
  `chaosuxunwen` varchar(255) DEFAULT NULL COMMENT '超速询问',
  `cheliangxunhao` varchar(255) DEFAULT NULL COMMENT '车辆序号',
  `dengji` varchar(255) DEFAULT NULL,
  `du_ping_lei_xing` varchar(255) DEFAULT NULL COMMENT '毒品类型',
  `fenxinjiashi` varchar(255) DEFAULT NULL COMMENT '分心驾驶',
  `guanxiaqu` varchar(255) DEFAULT NULL COMMENT '管辖区',
  `jiazhao` varchar(255) DEFAULT NULL,
  `jiazhaoxianzhi` varchar(255) DEFAULT NULL,
  `jtwfxingwei` varchar(255) DEFAULT NULL COMMENT '交通违法行为',
  `name` varchar(255) DEFAULT NULL,
  `paochuzhuangta` varchar(255) DEFAULT NULL COMMENT '抛出状态',
  `phonenum` varchar(255) DEFAULT NULL,
  `qianzhu` varchar(255) DEFAULT NULL COMMENT '驾照签注',
  `renyuantype` varchar(255) DEFAULT NULL,
  `sgfssxingwie` varchar(255) DEFAULT NULL COMMENT '事故发生时行为',
  `sgfsszhuangt` varchar(255) DEFAULT NULL COMMENT '事故发生前状态',
  `sgfsszhuangtai` varchar(255) DEFAULT NULL COMMENT ' 事故发生后状态',
  `shangyejiazhao` varchar(255) DEFAULT NULL,
  `shenfentype` varchar(255) DEFAULT NULL,
  `sschengdu` varchar(255) DEFAULT NULL,
  `tuokuishiyong` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yinjiu` varchar(255) DEFAULT NULL,
  `ysxitong` varchar(255) DEFAULT NULL,
  `shigunumber` text COMMENT 'accidentCollectiondata中的shigunumber',
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
  `liJiaoQuYu` text COMMENT '立交区域',
  `Jcktype` text COMMENT '交叉类型',
  `Teshuposition` text,
  `Tianqicondition` text,
  `zhaomingcondition` text,
  `luMianCondition` text,
  `luMianLev` text,
  `limitSpeed` text,
  `chedaowidth` text,
  `luJianWidth` text,
  `bianYuanXianle` text COMMENT '边缘线类型',
  `zhongyanwidht` text COMMENT '中央宽度',
  `zhongXinXian` text,
  `chedaoxianbj` text COMMENT '车道线标记',
  `jiaotongkzlx` text COMMENT '交通控制类型',
  `zhuchedaoshu` text COMMENT '主车道数',
  `jiaochajiedaoshu` text,
  `workPlaceRel` char(4) DEFAULT NULL COMMENT '工作区相关',
  `worktype` text COMMENT '工作类型',
  `havepeople` text,
  `xianChangZhifa` text COMMENT '现场执法',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emdata
-- ----------------------------
INSERT INTO `emdata` VALUES ('1', 'SG20171009031528', '01  在路中', '未知', '01  否', '01  非交叉口', '01  进/出口匝道', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('2', 'SG20171009033410', '01  在路中', '未知', '01  否', '01  非交叉口', '01  进/出口匝道', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('3', 'SG20171016015322', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('4', 'SG20171016015600', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('5', 'SG20171016014844', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');
INSERT INTO `emdata` VALUES ('6', 'SG20171016020015', '01  在路中', '未知', '01  否', '01  非交叉口', '01  未知', '01  晴朗', '01  白天', '01  干燥', '01 高速公路', '', '', '', '01  无标记边缘线', '', '01  无标记中心线', '01  无车道线', '01  无控制', '01  单车道', '01  单车道', '0', '01  车道关闭', '01  否', '01  无');

-- ----------------------------
-- Table structure for qita_peopel_data
-- ----------------------------
DROP TABLE IF EXISTS `qita_peopel_data`;
CREATE TABLE `qita_peopel_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aqsbsyzhuangtai` varchar(255) DEFAULT NULL COMMENT '安全设备使用状态',
  `ceshiresult` varchar(255) DEFAULT NULL,
  `ceshitype` varchar(255) DEFAULT NULL,
  `ceshizhuangtai` varchar(255) DEFAULT NULL,
  `cheliangxunhao` varchar(255) DEFAULT NULL COMMENT '车辆序号',
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
  `shigunumber` text COMMENT 'accidentCollectiondata中的shigunumber',
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(50) NOT NULL COMMENT '大队名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '大队A');
INSERT INTO `team` VALUES ('2', '大队B');
INSERT INTO `team` VALUES ('3', '大队C');
INSERT INTO `team` VALUES ('4', '大队D');
INSERT INTO `team` VALUES ('5', '大队E');
INSERT INTO `team` VALUES ('6', '大队F');
