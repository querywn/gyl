/*
MySQL Data Transfer
Source Host: localhost
Source Database: gyl
Target Host: localhost
Target Database: gyl
Date: 2017/12/22 16:47:00
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL,
  `description` varchar(100) collate utf8_bin default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(20) collate utf8_bin default NULL,
  `name` varchar(20) collate utf8_bin default NULL,
  `pid` bigint(20) default NULL,
  `isParent` bit(1) default NULL,
  `type` varchar(255) collate utf8_bin default NULL,
  `icon` varchar(100) collate utf8_bin default NULL,
  `url` varchar(100) collate utf8_bin default NULL,
  `target` varchar(100) collate utf8_bin default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL auto_increment,
  `pid` int(11) default NULL,
  `name` varchar(20) collate utf8_bin default NULL,
  `isParent` bit(1) default NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `pid` bigint(20) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY  (`rid`,`pid`),
  KEY `FK45FBD628DB06804C` (`pid`),
  KEY `FK45FBD628874A9773` (`rid`),
  CONSTRAINT `FK45FBD628874A9773` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `FK45FBD628DB06804C` FOREIGN KEY (`pid`) REFERENCES `privilege` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(20) collate utf8_bin default NULL,
  `password` varchar(20) collate utf8_bin default NULL,
  `sex` varchar(10) collate utf8_bin default NULL,
  `email` varchar(20) collate utf8_bin default NULL,
  `phone` varchar(100) collate utf8_bin default NULL,
  `did` int(11) default NULL,
  PRIMARY KEY  (`uid`),
  KEY `FK36EBCBBD48F8F1` (`did`),
  CONSTRAINT `FK36EBCBBD48F8F1` FOREIGN KEY (`did`) REFERENCES `department` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY  (`rid`,`uid`),
  KEY `FK143BF46A9575393B` (`uid`),
  KEY `FK143BF46A874A9773` (`rid`),
  CONSTRAINT `FK143BF46A874A9773` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `FK143BF46A9575393B` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `privilege` VALUES ('1', null, '供应链管理系统', '0', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('2', null, '基础数据', '1', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('3', null, '部门', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('4', null, '部门增加', '3', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('5', null, '部门修改', '3', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('6', null, '部门增加', '3', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('7', null, '部门删除', '3', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('8', null, '用户', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('9', null, '用户增加', '8', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('10', null, '用户修改', '8', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('11', null, '用户删除', '8', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('12', null, '用户查询', '8', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('13', null, '角色', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('14', null, '角色增加', '13', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('15', null, '角色修改', '13', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('16', null, '角色增加', '13', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('17', null, '角色删除', '13', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('18', null, '商品', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('19', null, '商品增加', '18', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('20', null, '商品增加', '18', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('21', null, '商品查询', '18', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('22', null, '商品删除', '18', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('23', null, '仓库', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('24', null, '仓库增加', '23', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('25', null, '仓库修改', '23', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('26', null, '仓库查询', '23', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('27', null, '仓库删除', '23', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('28', null, '客户', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('29', null, '客户增加', '28', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('30', null, '客户修改', '28', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('31', null, '客户查询', '28', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('32', null, '客户删除', '28', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('33', null, '供应商', '2', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('34', null, '供应商增加', '33', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('35', null, '供应商修改', '33', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('36', null, '供应商查询', '33', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('37', null, '供应商删除', '33', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('38', null, '权限管理', '1', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('39', null, '角色配置', '38', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('40', null, '用户匹配角色', '39', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('41', null, '权限配置', '38', '', '1', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('42', null, '角色匹配权限', '41', '', '2', 'images/002.gif', null, null);
INSERT INTO `privilege` VALUES ('43', null, '业务', '1', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('44', null, '采购管理', '43', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('45', null, '请购单管理', '44', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('46', null, '增加', '45', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('47', null, '修改', '45', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('48', null, '查询', '45', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('49', null, '审批', '45', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('50', null, '请购单管理', '44', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('51', null, '增加', '50', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('52', null, '修改', '50', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('53', null, '查询', '50', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('54', null, '审批', '50', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('55', null, '采购入库单管理', '44', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('56', null, '增加', '55', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('57', null, '修改', '55', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('58', null, '查询', '55', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('59', null, '审批', '55', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('60', null, '采购发票管理', '44', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('61', null, '增加', '60', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('62', null, '修改', '60', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('63', null, '查询', '60', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('64', null, '审批', '60', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('65', null, '销售管理', '43', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('66', null, '销售预订单管理', '65', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('67', null, '增加', '66', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('68', null, '修改', '66', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('69', null, '查询', '66', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('70', null, '审批', '66', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('71', null, '销售订单管理', '65', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('72', null, '增加', '71', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('73', null, '增加', '71', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('74', null, '查询', '71', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('75', null, '审批', '71', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('76', null, '发货单管理', '65', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('77', null, '增加', '76', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('78', null, '修改', '76', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('79', null, '查询', '76', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('80', null, '审批', '76', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('81', null, '销售出库单管理', '65', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('82', null, '增加', '81', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('83', null, '修改', '81', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('84', null, '查询', '81', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('85', null, '审批', '81', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('86', null, '销售开票管理', '65', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('87', null, '增加', '86', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('88', null, '修改', '86', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('89', null, '查询', '86', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('90', null, '审批', '86', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('91', null, '应收应付管理', '43', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('92', null, '销售应收管理', '91', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('93', null, '增加', '92', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('94', null, '修改', '92', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('95', null, '查询', '92', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('96', null, '审批', '92', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('97', null, '采购应付单管理', '91', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('98', null, '增加', '97', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('99', null, '修改', '97', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('100', null, '查询', '97', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('101', null, '审批', '97', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('102', null, '预警管理', '43', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('103', null, '采购入库时间预警', '102', '', null, 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('104', null, '销售发货预警', '102', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('105', null, '销售出库预警', '102', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('106', null, '仓库管理', '43', '', '1', null, null, null);
INSERT INTO `privilege` VALUES ('107', null, '期初', '106', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('108', null, '增加', '107', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('109', null, '修改', '107', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('110', null, '查询', '107', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('111', null, '审批', '107', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('112', null, '盘点', '106', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('113', null, '增加', '112', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('114', null, '修改', '112', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('115', null, '查询', '112', '', '1', 'images/003.gif', null, null);
INSERT INTO `privilege` VALUES ('116', null, '审批', '112', '', '1', 'images/003.gif', null, null);
INSERT INTO `role` VALUES ('1', '0', 'CEO', '');
INSERT INTO `role` VALUES ('2', '1', '会计', '');
INSERT INTO `role` VALUES ('3', '1', '管理员', '');
INSERT INTO `role` VALUES ('4', '1', '区域经理', '');
INSERT INTO `role` VALUES ('5', '1', '项目经理', '');
INSERT INTO `role_privilege` VALUES ('1', '1');
INSERT INTO `role_privilege` VALUES ('2', '1');
INSERT INTO `role_privilege` VALUES ('3', '1');
INSERT INTO `role_privilege` VALUES ('4', '1');
INSERT INTO `role_privilege` VALUES ('5', '1');
INSERT INTO `role_privilege` VALUES ('7', '1');
INSERT INTO `role_privilege` VALUES ('8', '1');
INSERT INTO `role_privilege` VALUES ('9', '1');
INSERT INTO `role_privilege` VALUES ('10', '1');
INSERT INTO `role_privilege` VALUES ('11', '1');
INSERT INTO `role_privilege` VALUES ('12', '1');
INSERT INTO `role_privilege` VALUES ('13', '1');
INSERT INTO `role_privilege` VALUES ('14', '1');
INSERT INTO `role_privilege` VALUES ('15', '1');
INSERT INTO `role_privilege` VALUES ('17', '1');
INSERT INTO `role_privilege` VALUES ('18', '1');
INSERT INTO `role_privilege` VALUES ('19', '1');
INSERT INTO `role_privilege` VALUES ('21', '1');
INSERT INTO `role_privilege` VALUES ('22', '1');
INSERT INTO `role_privilege` VALUES ('23', '1');
INSERT INTO `role_privilege` VALUES ('24', '1');
INSERT INTO `role_privilege` VALUES ('25', '1');
INSERT INTO `role_privilege` VALUES ('26', '1');
INSERT INTO `role_privilege` VALUES ('27', '1');
INSERT INTO `role_privilege` VALUES ('28', '1');
INSERT INTO `role_privilege` VALUES ('29', '1');
INSERT INTO `role_privilege` VALUES ('30', '1');
INSERT INTO `role_privilege` VALUES ('31', '1');
INSERT INTO `role_privilege` VALUES ('32', '1');
INSERT INTO `role_privilege` VALUES ('33', '1');
INSERT INTO `role_privilege` VALUES ('34', '1');
INSERT INTO `role_privilege` VALUES ('35', '1');
INSERT INTO `role_privilege` VALUES ('36', '1');
INSERT INTO `role_privilege` VALUES ('37', '1');
INSERT INTO `role_privilege` VALUES ('38', '1');
INSERT INTO `role_privilege` VALUES ('39', '1');
INSERT INTO `role_privilege` VALUES ('40', '1');
INSERT INTO `role_privilege` VALUES ('41', '1');
INSERT INTO `role_privilege` VALUES ('42', '1');
INSERT INTO `role_privilege` VALUES ('43', '1');
INSERT INTO `role_privilege` VALUES ('44', '1');
INSERT INTO `role_privilege` VALUES ('45', '1');
INSERT INTO `role_privilege` VALUES ('46', '1');
INSERT INTO `role_privilege` VALUES ('47', '1');
INSERT INTO `role_privilege` VALUES ('48', '1');
INSERT INTO `role_privilege` VALUES ('49', '1');
INSERT INTO `role_privilege` VALUES ('55', '1');
INSERT INTO `role_privilege` VALUES ('60', '1');
INSERT INTO `role_privilege` VALUES ('65', '1');
INSERT INTO `role_privilege` VALUES ('66', '1');
INSERT INTO `role_privilege` VALUES ('71', '1');
INSERT INTO `role_privilege` VALUES ('76', '1');
INSERT INTO `role_privilege` VALUES ('81', '1');
INSERT INTO `role_privilege` VALUES ('86', '1');
INSERT INTO `role_privilege` VALUES ('91', '1');
INSERT INTO `role_privilege` VALUES ('92', '1');
INSERT INTO `role_privilege` VALUES ('97', '1');
INSERT INTO `role_privilege` VALUES ('102', '1');
INSERT INTO `role_privilege` VALUES ('103', '1');
INSERT INTO `role_privilege` VALUES ('104', '1');
INSERT INTO `role_privilege` VALUES ('105', '1');
INSERT INTO `role_privilege` VALUES ('106', '1');
INSERT INTO `role_privilege` VALUES ('107', '1');
INSERT INTO `role_privilege` VALUES ('112', '1');
INSERT INTO `role_privilege` VALUES ('1', '2');
INSERT INTO `role_privilege` VALUES ('43', '2');
INSERT INTO `role_privilege` VALUES ('44', '2');
INSERT INTO `role_privilege` VALUES ('45', '2');
INSERT INTO `role_privilege` VALUES ('46', '2');
INSERT INTO `role_privilege` VALUES ('47', '2');
INSERT INTO `role_privilege` VALUES ('48', '2');
INSERT INTO `role_privilege` VALUES ('49', '2');
INSERT INTO `role_privilege` VALUES ('55', '2');
INSERT INTO `role_privilege` VALUES ('60', '2');
INSERT INTO `role_privilege` VALUES ('65', '2');
INSERT INTO `role_privilege` VALUES ('66', '2');
INSERT INTO `role_privilege` VALUES ('71', '2');
INSERT INTO `role_privilege` VALUES ('76', '2');
INSERT INTO `role_privilege` VALUES ('81', '2');
INSERT INTO `role_privilege` VALUES ('86', '2');
INSERT INTO `role_privilege` VALUES ('91', '2');
INSERT INTO `role_privilege` VALUES ('92', '2');
INSERT INTO `role_privilege` VALUES ('97', '2');
INSERT INTO `role_privilege` VALUES ('102', '2');
INSERT INTO `role_privilege` VALUES ('103', '2');
INSERT INTO `role_privilege` VALUES ('104', '2');
INSERT INTO `role_privilege` VALUES ('105', '2');
INSERT INTO `role_privilege` VALUES ('106', '2');
INSERT INTO `role_privilege` VALUES ('107', '2');
INSERT INTO `role_privilege` VALUES ('112', '2');
INSERT INTO `role_privilege` VALUES ('1', '5');
INSERT INTO `role_privilege` VALUES ('2', '5');
INSERT INTO `role_privilege` VALUES ('3', '5');
INSERT INTO `role_privilege` VALUES ('4', '5');
INSERT INTO `role_privilege` VALUES ('5', '5');
INSERT INTO `role_privilege` VALUES ('7', '5');
INSERT INTO `role_privilege` VALUES ('8', '5');
INSERT INTO `role_privilege` VALUES ('9', '5');
INSERT INTO `role_privilege` VALUES ('10', '5');
INSERT INTO `role_privilege` VALUES ('11', '5');
INSERT INTO `role_privilege` VALUES ('12', '5');
INSERT INTO `role_privilege` VALUES ('13', '5');
INSERT INTO `role_privilege` VALUES ('14', '5');
INSERT INTO `role_privilege` VALUES ('15', '5');
INSERT INTO `role_privilege` VALUES ('17', '5');
INSERT INTO `role_privilege` VALUES ('18', '5');
INSERT INTO `role_privilege` VALUES ('19', '5');
INSERT INTO `role_privilege` VALUES ('21', '5');
INSERT INTO `role_privilege` VALUES ('22', '5');
INSERT INTO `role_privilege` VALUES ('23', '5');
INSERT INTO `role_privilege` VALUES ('24', '5');
INSERT INTO `role_privilege` VALUES ('25', '5');
INSERT INTO `role_privilege` VALUES ('26', '5');
INSERT INTO `role_privilege` VALUES ('27', '5');
INSERT INTO `role_privilege` VALUES ('28', '5');
INSERT INTO `role_privilege` VALUES ('29', '5');
INSERT INTO `role_privilege` VALUES ('30', '5');
INSERT INTO `role_privilege` VALUES ('31', '5');
INSERT INTO `role_privilege` VALUES ('32', '5');
INSERT INTO `role_privilege` VALUES ('33', '5');
INSERT INTO `role_privilege` VALUES ('34', '5');
INSERT INTO `role_privilege` VALUES ('35', '5');
INSERT INTO `role_privilege` VALUES ('36', '5');
INSERT INTO `role_privilege` VALUES ('37', '5');
