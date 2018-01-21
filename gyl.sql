-- MySQL dump 10.10
--
-- Host: localhost    Database: gyl
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `did` int(11) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL,
  `description` varchar(100) collate utf8_bin default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `department`
--


/*!40000 ALTER TABLE `department` DISABLE KEYS */;
LOCK TABLES `department` WRITE;
INSERT INTO `department` VALUES (1,'开发部','asaaaaa'),(2,'事业部','bbbb'),(3,'销售部','cccc');
UNLOCK TABLES;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

--
-- Table structure for table `privilege`
--

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

--
-- Dumping data for table `privilege`
--


/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
LOCK TABLES `privilege` WRITE;
INSERT INTO `privilege` VALUES (1,NULL,'供应链管理系统',0,'','1','images/003.gif',NULL,NULL),(2,NULL,'基础数据',1,'','1','images/003.gif',NULL,NULL),(3,NULL,'部门',2,'','1','images/003.gif',NULL,NULL),(4,NULL,'部门增加',3,'\0','2','images/002.gif',NULL,NULL),(5,NULL,'部门修改',3,'\0','2','images/002.gif',NULL,NULL),(6,NULL,'部门增加',3,'\0','2','images/002.gif',NULL,NULL),(7,NULL,'部门删除',3,'\0','2','images/002.gif',NULL,NULL),(8,NULL,'用户',2,'','1','images/003.gif',NULL,NULL),(9,NULL,'用户增加',8,'\0','2','images/002.gif',NULL,NULL),(10,NULL,'用户修改',8,'\0','2','images/002.gif',NULL,NULL),(11,NULL,'用户删除',8,'\0','2','images/002.gif',NULL,NULL),(12,NULL,'用户查询',8,'\0','2','images/002.gif',NULL,NULL),(13,NULL,'角色',2,'\0','1','images/003.gif',NULL,NULL),(14,NULL,'角色增加',13,'\0','2','images/002.gif',NULL,NULL),(15,NULL,'角色修改',13,'\0','2','images/002.gif',NULL,NULL),(16,NULL,'角色增加',13,'\0','2','images/002.gif',NULL,NULL),(17,NULL,'角色删除',13,'\0','2','images/002.gif',NULL,NULL),(18,NULL,'商品',2,'','1','images/003.gif',NULL,NULL),(19,NULL,'商品增加',18,'\0','2','images/002.gif',NULL,NULL),(20,NULL,'商品增加',18,'\0','2','images/002.gif',NULL,NULL),(21,NULL,'商品查询',18,'\0','2','images/002.gif',NULL,NULL),(22,NULL,'商品删除',18,'\0','2','images/002.gif',NULL,NULL),(23,NULL,'仓库',2,'\0','1','images/003.gif',NULL,NULL),(24,NULL,'仓库增加',23,'\0','2','images/002.gif',NULL,NULL),(25,NULL,'仓库修改',23,'\0','2','images/002.gif',NULL,NULL),(26,NULL,'仓库查询',23,'\0','2','images/002.gif',NULL,NULL),(27,NULL,'仓库删除',23,'\0','2','images/002.gif',NULL,NULL),(28,NULL,'客户',2,'\0','1','images/003.gif',NULL,NULL),(29,NULL,'客户增加',28,'\0','2','images/002.gif',NULL,NULL),(30,NULL,'客户修改',28,'\0','2','images/002.gif',NULL,NULL),(31,NULL,'客户查询',28,'\0','2','images/002.gif',NULL,NULL),(32,NULL,'客户删除',28,'\0','2','images/002.gif',NULL,NULL),(33,NULL,'供应商',2,'\0','1','images/003.gif',NULL,NULL),(34,NULL,'供应商增加',33,'\0','2','images/002.gif',NULL,NULL),(35,NULL,'供应商修改',33,'\0','2','images/002.gif',NULL,NULL),(36,NULL,'供应商查询',33,'\0','2','images/002.gif',NULL,NULL),(37,NULL,'供应商删除',33,'\0','2','images/002.gif',NULL,NULL),(38,NULL,'权限管理',1,'','1','images/003.gif',NULL,NULL),(39,NULL,'角色配置',38,'','1','images/003.gif',NULL,NULL),(40,NULL,'用户匹配角色',39,'\0','2','images/002.gif',NULL,NULL),(41,NULL,'权限配置',38,'\0','1','images/002.gif',NULL,NULL),(42,NULL,'角色匹配权限',41,'\0','2','images/002.gif',NULL,NULL),(43,NULL,'业务',1,'','1','images/003.gif',NULL,NULL),(44,NULL,'采购管理',43,'','1','images/003.gif',NULL,NULL),(45,NULL,'请购单管理',44,'','1','images/003.gif',NULL,NULL),(46,NULL,'增加',45,'\0','1','images/003.gif',NULL,NULL),(47,NULL,'修改',45,'\0','1','images/003.gif',NULL,NULL),(48,NULL,'查询',45,'\0','1','images/003.gif',NULL,NULL),(49,NULL,'审批',45,'\0','1','images/003.gif',NULL,NULL),(50,NULL,'请购单管理',44,'','1','images/003.gif',NULL,NULL),(51,NULL,'增加',50,'\0','1','images/003.gif',NULL,NULL),(52,NULL,'修改',50,'\0','1','images/003.gif',NULL,NULL),(53,NULL,'查询',50,'\0','1','images/003.gif',NULL,NULL),(54,NULL,'审批',50,'\0','1','images/003.gif',NULL,NULL),(55,NULL,'采购入库单管理',44,'','1','images/003.gif',NULL,NULL),(56,NULL,'增加',55,'\0','1','images/003.gif',NULL,NULL),(57,NULL,'修改',55,'\0','1','images/003.gif',NULL,NULL),(58,NULL,'查询',55,'\0','1','images/003.gif',NULL,NULL),(59,NULL,'审批',55,'\0','1','images/003.gif',NULL,NULL),(60,NULL,'采购发票管理',44,'','1','images/003.gif',NULL,NULL),(61,NULL,'增加',60,'\0','1','images/003.gif',NULL,NULL),(62,NULL,'修改',60,'\0','1','images/003.gif',NULL,NULL),(63,NULL,'查询',60,'\0','1','images/003.gif',NULL,NULL),(64,NULL,'审批',60,'\0','1','images/003.gif',NULL,NULL),(65,NULL,'销售管理',43,'','1','images/003.gif',NULL,NULL),(66,NULL,'销售预订单管理',65,'','1','images/003.gif',NULL,NULL),(67,NULL,'增加',66,'\0','1','images/003.gif','xsyddAction_saveUI.action','right'),(68,NULL,'修改',66,'\0','1','images/003.gif',NULL,NULL),(69,NULL,'查询',66,'\0','1','images/003.gif','xsyddAction_showAllXsydd.action','right'),(70,NULL,'审批',66,'\0','1','images/003.gif',NULL,NULL),(71,NULL,'销售订单管理',65,'','1','images/003.gif',NULL,NULL),(72,NULL,'增加',71,'\0','1','images/003.gif','xsddAction_saveUI.action','right'),(73,NULL,'修改',71,'\0','1','images/003.gif',NULL,NULL),(74,NULL,'查询',71,'\0','1','images/003.gif','xsddAction_showAllXsdd.action','right'),(75,NULL,'审批',71,'\0','1','images/003.gif',NULL,NULL),(76,NULL,'发货单管理',65,'','1','images/003.gif',NULL,NULL),(77,NULL,'增加',76,'\0','1','images/003.gif',NULL,NULL),(78,NULL,'修改',76,'\0','1','images/003.gif',NULL,NULL),(79,NULL,'查询',76,'\0','1','images/003.gif',NULL,NULL),(80,NULL,'审批',76,'\0','1','images/003.gif',NULL,NULL),(81,NULL,'销售出库单管理',65,'','1','images/003.gif',NULL,NULL),(82,NULL,'增加',81,'\0','1','images/003.gif',NULL,NULL),(83,NULL,'修改',81,'\0','1','images/003.gif',NULL,NULL),(84,NULL,'查询',81,'\0','1','images/003.gif',NULL,NULL),(85,NULL,'审批',81,'\0','1','images/003.gif',NULL,NULL),(86,NULL,'销售开票管理',65,'','1','images/003.gif',NULL,NULL),(87,NULL,'增加',86,'\0','1','images/003.gif',NULL,NULL),(88,NULL,'修改',86,'\0','1','images/003.gif',NULL,NULL),(89,NULL,'查询',86,'\0','1','images/003.gif',NULL,NULL),(90,NULL,'审批',86,'\0','1','images/003.gif',NULL,NULL),(91,NULL,'应收应付管理',43,'','1','images/003.gif',NULL,NULL),(92,NULL,'销售应收管理',91,'','1','images/003.gif',NULL,NULL),(93,NULL,'增加',92,'\0','1','images/003.gif',NULL,NULL),(94,NULL,'修改',92,'\0','1','images/003.gif',NULL,NULL),(95,NULL,'查询',92,'\0','1','images/003.gif',NULL,NULL),(96,NULL,'审批',92,'\0','1','images/003.gif',NULL,NULL),(97,NULL,'采购应付单管理',91,'','1','images/003.gif',NULL,NULL),(98,NULL,'增加',97,'\0','1','images/003.gif',NULL,NULL),(99,NULL,'修改',97,'\0','1','images/003.gif',NULL,NULL),(100,NULL,'查询',97,'\0','1','images/003.gif',NULL,NULL),(101,NULL,'审批',97,'\0','1','images/003.gif',NULL,NULL),(102,NULL,'预警管理',43,'','1','images/003.gif',NULL,NULL),(103,NULL,'采购入库时间预警',102,'\0',NULL,'images/003.gif',NULL,NULL),(104,NULL,'销售发货预警',102,'\0','1','images/003.gif',NULL,NULL),(105,NULL,'销售出库预警',102,'\0','1','images/003.gif',NULL,NULL),(106,NULL,'仓库管理',43,'','1',NULL,NULL,NULL),(107,NULL,'期初',106,'','1','images/003.gif',NULL,NULL),(108,NULL,'增加',107,'\0','1','images/003.gif',NULL,NULL),(109,NULL,'修改',107,'\0','1','images/003.gif',NULL,NULL),(110,NULL,'查询',107,'\0','1','images/003.gif',NULL,NULL),(111,NULL,'审批',107,'\0','1','images/003.gif',NULL,NULL),(112,NULL,'盘点',106,'','1','images/003.gif',NULL,NULL),(113,NULL,'增加',112,'\0','1','images/003.gif',NULL,NULL),(114,NULL,'修改',112,'\0','1','images/003.gif',NULL,NULL),(115,NULL,'查询',112,'\0','1','images/003.gif',NULL,NULL),(116,NULL,'审批',112,'\0','1','images/003.gif',NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL auto_increment,
  `spbm` varchar(20) collate utf8_bin default NULL,
  `dw` varchar(50) collate utf8_bin default NULL,
  `spmc` varchar(100) collate utf8_bin default NULL,
  `xh` varchar(100) collate utf8_bin default NULL,
  `shulv` double default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `product`
--


/*!40000 ALTER TABLE `product` DISABLE KEYS */;
LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'10087','台','ThinkPad T440 14英寸超薄本','20B6S00M00',0.1),(3,'10086','台','iPad mini','MD531CH/A',0.2),(4,'10088','台','西门子BCD-610W冰箱','BCD-610W',0.1),(5,'10089','台','海尔KFR-35GW/05KDP22A','KFR-35GW/05KDP22A',0.2),(6,'10090','台','松下洗衣机','XQB65-Q76201',0.1),(7,'12312','台','小天鹅TB55-V1068','TB55-V1068',0.1),(8,'32405','台','老板CXW-200-8307','CXW-200-8307N+9B13N',0.1),(9,'42787','个','海尔EC6002-D电热水器','EC6002-D',0.1),(10,'100890','台','飞利浦WP3864/00饮水机','WP3864',0.1),(11,'200089','个','公牛GN-110插座','GN-110',0.1),(12,'4370089','个','美的FS40-13ER电风扇','FS40-13ER',0.1),(13,'749896','台','志高FSG-12N空调扇','FSG-12N',0.1),(14,'4074849','个','浪琴男表L4.774.4.12.6','L4.774.4.12.6',0.2),(15,'10023759','件','雅戈尔2014新款纯白色男士短袖衬衫','WX550',0.1),(16,'9230078','个','苹果4S','ipone4s',0.1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` int(11) NOT NULL auto_increment,
  `pid` int(11) default NULL,
  `name` varchar(20) collate utf8_bin default NULL,
  `isParent` bit(1) default NULL,
  `checked` bit(1) default NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `role`
--


/*!40000 ALTER TABLE `role` DISABLE KEYS */;
LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,0,'CEO','',NULL),(2,1,'会计','\0',NULL),(3,1,'管理员','\0',NULL),(4,1,'区域经理','\0',NULL),(5,1,'项目经理','\0',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

--
-- Table structure for table `role_privilege`
--

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

--
-- Dumping data for table `role_privilege`
--


/*!40000 ALTER TABLE `role_privilege` DISABLE KEYS */;
LOCK TABLES `role_privilege` WRITE;
INSERT INTO `role_privilege` VALUES (1,2),(43,2),(44,2),(45,2),(46,2),(47,2),(48,2),(49,2),(50,2),(51,2),(52,2),(53,2),(54,2),(55,2),(56,2),(57,2),(58,2),(59,2),(60,2),(61,2),(62,2),(63,2),(64,2),(65,2),(66,2),(67,2),(68,2),(69,2),(70,2),(71,2),(72,2),(73,2),(74,2),(75,2),(76,2),(77,2),(78,2),(79,2),(80,2),(81,2),(82,2),(83,2),(84,2),(85,2),(86,2),(87,2),(88,2),(89,2),(90,2),(91,2),(92,2),(93,2),(94,2),(95,2),(96,2),(97,2),(98,2),(99,2),(100,2),(101,2),(102,2),(103,2),(104,2),(105,2),(106,2),(107,2),(108,2),(109,2),(110,2),(111,2),(112,2),(113,2),(114,2),(115,2),(116,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(41,3),(42,3),(43,3),(44,3),(45,3),(46,3),(47,3),(48,3),(49,3),(50,3),(51,3),(52,3),(53,3),(54,3),(55,3),(56,3),(57,3),(58,3),(59,3),(60,3),(61,3),(62,3),(63,3),(64,3),(65,3),(66,3),(67,3),(68,3),(69,3),(70,3),(71,3),(72,3),(73,3),(74,3),(75,3),(76,3),(77,3),(78,3),(79,3),(80,3),(81,3),(82,3),(83,3),(84,3),(85,3),(86,3),(87,3),(88,3),(89,3),(90,3),(91,3),(92,3),(93,3),(94,3),(95,3),(96,3),(97,3),(98,3),(99,3),(100,3),(101,3),(102,3),(103,3),(104,3),(105,3),(106,3),(107,3),(108,3),(109,3),(110,3),(111,3),(112,3),(113,3),(114,3),(115,3),(116,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `role_privilege` ENABLE KEYS */;

--
-- Table structure for table `user`
--

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

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'admin','admin','男','admin@sina.com','13035688207',1),(2,'aaa','123','女','bbb@sina.com','13035688207',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

--
-- Table structure for table `user_role`
--

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

--
-- Dumping data for table `user_role`
--


/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
LOCK TABLES `user_role` WRITE;
INSERT INTO `user_role` VALUES (1,1),(1,3),(2,1),(2,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

--
-- Table structure for table `xsckdzhib`
--

DROP TABLE IF EXISTS `xsckdzhib`;
CREATE TABLE `xsckdzhib` (
  `xsckdzhibid` int(11) NOT NULL auto_increment,
  `spbm` varchar(50) default NULL,
  `spmc` varchar(50) default NULL,
  `ckrq` datetime default NULL,
  `dj` float default NULL,
  `dw` varchar(20) default NULL,
  `hh` int(11) default NULL,
  `isckgb` bit(1) default NULL,
  `je` float default NULL,
  `ljcksl` int(11) default NULL,
  `scrq` datetime default NULL,
  `sfsl` int(11) default NULL,
  `sxrq` datetime default NULL,
  `xh` varchar(255) default NULL,
  `yfsl` int(11) default NULL,
  `ytdjh` varchar(100) default NULL,
  `ythh` int(11) default NULL,
  `lydjh` varchar(100) default NULL,
  `lyhh` int(11) default NULL,
  `zp` varchar(50) default NULL,
  `xsckdzhubid` int(11) default NULL,
  PRIMARY KEY  (`xsckdzhibid`),
  KEY `FKD306FC48AD8B6F00` (`xsckdzhubid`),
  CONSTRAINT `FKD306FC48AD8B6F00` FOREIGN KEY (`xsckdzhubid`) REFERENCES `xsckdzhub` (`xsckdzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsckdzhib`
--


/*!40000 ALTER TABLE `xsckdzhib` DISABLE KEYS */;
LOCK TABLES `xsckdzhib` WRITE;
INSERT INTO `xsckdzhib` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,10,NULL,10,NULL,NULL,NULL,'2018011000001',1,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,20,NULL,10,NULL,NULL,NULL,'2018011000001',1,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsckdzhib` ENABLE KEYS */;

--
-- Table structure for table `xsckdzhub`
--

DROP TABLE IF EXISTS `xsckdzhub`;
CREATE TABLE `xsckdzhub` (
  `xsckdzhubid` int(11) NOT NULL auto_increment,
  `bm` varchar(50) default NULL,
  `ck` varchar(20) default NULL,
  `ddh` varchar(100) default NULL,
  `djrq` datetime default NULL,
  `isth` bit(1) default NULL,
  `kgy` varchar(20) default NULL,
  `kh` varchar(50) default NULL,
  `qzr` varchar(20) default NULL,
  `shr` varchar(20) default NULL,
  `shrq` datetime default NULL,
  `status` varchar(20) default NULL,
  `xgrq` datetime default NULL,
  `xgr` varchar(255) default NULL,
  `zdr` varchar(20) default NULL,
  `zdrq` datetime default NULL,
  PRIMARY KEY  (`xsckdzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsckdzhub`
--


/*!40000 ALTER TABLE `xsckdzhub` DISABLE KEYS */;
LOCK TABLES `xsckdzhub` WRITE;
INSERT INTO `xsckdzhub` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsckdzhub` ENABLE KEYS */;

--
-- Table structure for table `xsddzhib`
--

DROP TABLE IF EXISTS `xsddzhib`;
CREATE TABLE `xsddzhib` (
  `xsddzhibid` int(11) NOT NULL auto_increment,
  `spbm` varchar(100) default NULL,
  `spmc` varchar(100) default NULL,
  `dpkl` float default NULL,
  `lyhh` int(11) default NULL,
  `fhck` varchar(20) default NULL,
  `hh` int(11) default NULL,
  `hsdj` float default NULL,
  `hsje` float default NULL,
  `hstatus` varchar(255) default NULL,
  `isckgb` bit(1) default NULL,
  `isfhgb` bit(1) default NULL,
  `iskpgb` bit(1) default NULL,
  `isskjs` bit(1) default NULL,
  `jhfhrq` datetime default NULL,
  `jldw` varchar(255) default NULL,
  `ljcksl` int(11) default NULL,
  `ljfhsl` int(11) default NULL,
  `ljkpsl` int(11) default NULL,
  `ljyssl` int(11) default NULL,
  `se` float default NULL,
  `shdw` varchar(255) default NULL,
  `shulv` float default NULL,
  `sl` int(11) default NULL,
  `wsdj` float default NULL,
  `wsje` float default NULL,
  `xh` varchar(255) default NULL,
  `yfwcksl` int(11) default NULL,
  `yqshrq` datetime default NULL,
  `zke` float default NULL,
  `zp` varchar(255) default NULL,
  `xsddzhubid` int(11) default NULL,
  PRIMARY KEY  (`xsddzhibid`),
  KEY `FK2932E02214FBBA` (`xsddzhubid`),
  CONSTRAINT `FK2932E02214FBBA` FOREIGN KEY (`xsddzhubid`) REFERENCES `xsddzhub` (`xsddzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsddzhib`
--


/*!40000 ALTER TABLE `xsddzhib` DISABLE KEYS */;
LOCK TABLES `xsddzhib` WRITE;
INSERT INTO `xsddzhib` VALUES (1,'10086',NULL,0.1,NULL,'',1,2400,48000,'2','','','','\0',NULL,NULL,20,20,20,0,8000,'',0.2,20,2000,40000,'MD531CH/A',NULL,NULL,4800,'1',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsddzhib` ENABLE KEYS */;

--
-- Table structure for table `xsddzhub`
--

DROP TABLE IF EXISTS `xsddzhub`;
CREATE TABLE `xsddzhub` (
  `xsddzhubid` int(11) NOT NULL auto_increment,
  `ckjsbz` varchar(10) default NULL,
  `ddh` varchar(100) default NULL,
  `dhrq` date default NULL,
  `fhjsbz` varchar(10) default NULL,
  `khmc` varchar(100) default NULL,
  `kpdw` varchar(100) default NULL,
  `kpjsbz` varchar(10) default NULL,
  `shdq` varchar(100) default NULL,
  `shdz` varchar(100) default NULL,
  `spr` varchar(20) default NULL,
  `sprq` datetime default NULL,
  `state` varchar(255) default NULL,
  `sxbm` varchar(20) default NULL,
  `lydjh` varchar(20) default NULL,
  `sxkje` float default NULL,
  `sxrq` datetime default NULL,
  `thbz` varchar(10) default NULL,
  `xgr` varchar(20) default NULL,
  `xgrq` datetime default NULL,
  `zdjshj` float default NULL,
  `ywy` varchar(20) default NULL,
  `zdkl` float default NULL,
  `zdr` varchar(255) default NULL,
  `zdrq` datetime default NULL,
  PRIMARY KEY  (`xsddzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsddzhub`
--


/*!40000 ALTER TABLE `xsddzhub` DISABLE KEYS */;
LOCK TABLES `xsddzhub` WRITE;
INSERT INTO `xsddzhub` VALUES (1,'2','2018011000001',NULL,'2','','','2','四川绵阳','西南科技大学','',NULL,NULL,NULL,NULL,0,NULL,'2','',NULL,0,'',0,'aaa',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsddzhub` ENABLE KEYS */;

--
-- Table structure for table `xsfhdzhib`
--

DROP TABLE IF EXISTS `xsfhdzhib`;
CREATE TABLE `xsfhdzhib` (
  `xsfhdzhibid` int(11) NOT NULL auto_increment,
  `spbm` varchar(50) default NULL,
  `spmc` varchar(50) default NULL,
  `fhrq` datetime default NULL,
  `dj` float default NULL,
  `dw` varchar(20) default NULL,
  `hh` int(11) default NULL,
  `isfhgb` bit(1) default NULL,
  `je` float default NULL,
  `ljfhsl` int(11) default NULL,
  `scrq` datetime default NULL,
  `sfsl` int(11) default NULL,
  `sxrq` datetime default NULL,
  `xh` varchar(255) default NULL,
  `yfsl` int(11) default NULL,
  `lydjh` varchar(255) default NULL,
  `lyhh` int(11) default NULL,
  `ytdjh` varchar(100) default NULL,
  `ythh` int(11) default NULL,
  `zp` varchar(50) default NULL,
  `xsfhdzhubid` int(11) default NULL,
  PRIMARY KEY  (`xsfhdzhibid`),
  KEY `FK6C9B242ECC495D4C` (`xsfhdzhubid`),
  CONSTRAINT `FK6C9B242ECC495D4C` FOREIGN KEY (`xsfhdzhubid`) REFERENCES `xsfhdzhub` (`xsfhdzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsfhdzhib`
--


/*!40000 ALTER TABLE `xsfhdzhib` DISABLE KEYS */;
LOCK TABLES `xsfhdzhib` WRITE;
INSERT INTO `xsfhdzhib` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,10,NULL,10,NULL,NULL,NULL,NULL,NULL,'2018011000001',1,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,20,NULL,10,NULL,NULL,NULL,NULL,NULL,'2018011000001',1,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsfhdzhib` ENABLE KEYS */;

--
-- Table structure for table `xsfhdzhub`
--

DROP TABLE IF EXISTS `xsfhdzhub`;
CREATE TABLE `xsfhdzhub` (
  `xsfhdzhubid` int(11) NOT NULL auto_increment,
  `bm` varchar(50) default NULL,
  `ck` varchar(20) default NULL,
  `ddh` varchar(100) default NULL,
  `djrq` datetime default NULL,
  `isth` bit(1) default NULL,
  `kgy` varchar(20) default NULL,
  `kh` varchar(50) default NULL,
  `qzr` varchar(20) default NULL,
  `shr` varchar(20) default NULL,
  `shrq` datetime default NULL,
  `status` varchar(20) default NULL,
  `xgrq` datetime default NULL,
  `zdr` varchar(20) default NULL,
  `zdrq` datetime default NULL,
  PRIMARY KEY  (`xsfhdzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsfhdzhub`
--


/*!40000 ALTER TABLE `xsfhdzhub` DISABLE KEYS */;
LOCK TABLES `xsfhdzhub` WRITE;
INSERT INTO `xsfhdzhub` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsfhdzhub` ENABLE KEYS */;

--
-- Table structure for table `xskpzhib`
--

DROP TABLE IF EXISTS `xskpzhib`;
CREATE TABLE `xskpzhib` (
  `xskpzhibid` int(11) NOT NULL auto_increment,
  `ljkpsl` int(11) default NULL,
  `ck` varchar(20) default NULL,
  `dpkl` float default NULL,
  `dw` varchar(20) default NULL,
  `hh` int(11) default NULL,
  `hsdj` float default NULL,
  `hsje` float default NULL,
  `iskpjs` bit(1) default NULL,
  `lydjh` varchar(50) default NULL,
  `lyhh` varchar(5) default NULL,
  `shdw` varchar(100) default NULL,
  `shulv` float default NULL,
  `sl` int(11) default NULL,
  `spbm` varchar(100) default NULL,
  `spmc` varchar(100) default NULL,
  `wsdj` float default NULL,
  `wsje` float default NULL,
  `xh` varchar(50) default NULL,
  `ytdjh` varchar(100) default NULL,
  `ythh` int(11) default NULL,
  `zke` float default NULL,
  `zp` varchar(255) default NULL,
  `xskpzhubid` int(11) default NULL,
  PRIMARY KEY  (`xskpzhibid`),
  KEY `FK35CDE6875EA30344` (`xskpzhubid`),
  CONSTRAINT `FK35CDE6875EA30344` FOREIGN KEY (`xskpzhubid`) REFERENCES `xskpzhub` (`xskpzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xskpzhib`
--


/*!40000 ALTER TABLE `xskpzhib` DISABLE KEYS */;
LOCK TABLES `xskpzhib` WRITE;
INSERT INTO `xskpzhib` VALUES (1,10,NULL,NULL,NULL,NULL,NULL,2000,'\0',NULL,NULL,NULL,NULL,10,NULL,NULL,NULL,NULL,NULL,'2018011000001',1,NULL,NULL,NULL),(2,20,NULL,NULL,NULL,NULL,NULL,2000,'',NULL,NULL,NULL,NULL,10,NULL,NULL,NULL,NULL,NULL,'2018011000001',1,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xskpzhib` ENABLE KEYS */;

--
-- Table structure for table `xskpzhub`
--

DROP TABLE IF EXISTS `xskpzhub`;
CREATE TABLE `xskpzhub` (
  `xskpzhubid` int(11) NOT NULL auto_increment,
  `bm` varchar(50) default NULL,
  `fph` varchar(100) default NULL,
  `fplx` varchar(50) default NULL,
  `fpzje` float default NULL,
  `gs` varchar(50) default NULL,
  `kh` varchar(255) default NULL,
  `khdymc` varchar(255) default NULL,
  `kjnd` datetime default NULL,
  `kprq` datetime default NULL,
  `shdw` varchar(200) default NULL,
  `shdz` varchar(200) default NULL,
  `spr` varchar(20) default NULL,
  `spsj` datetime default NULL,
  `status` varchar(20) default NULL,
  `xgr` varchar(20) default NULL,
  `xgsj` datetime default NULL,
  `ywy` varchar(20) default NULL,
  `zdr` varchar(20) default NULL,
  `zdsj` datetime default NULL,
  `zdzk` float default NULL,
  PRIMARY KEY  (`xskpzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xskpzhub`
--


/*!40000 ALTER TABLE `xskpzhub` DISABLE KEYS */;
LOCK TABLES `xskpzhub` WRITE;
INSERT INTO `xskpzhub` VALUES (1,NULL,NULL,NULL,2000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,2000,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xskpzhub` ENABLE KEYS */;

--
-- Table structure for table `xsyddzhib`
--

DROP TABLE IF EXISTS `xsyddzhib`;
CREATE TABLE `xsyddzhib` (
  `xsyddzhibid` int(11) NOT NULL auto_increment,
  `spbm` varchar(255) collate utf8_bin default NULL,
  `spmc` varchar(255) collate utf8_bin default NULL,
  `dpkl` float default NULL,
  `hh` int(11) default NULL,
  `hsdj` float default NULL,
  `hsje` float default NULL,
  `jldw` varchar(255) collate utf8_bin default NULL,
  `se` float default NULL,
  `shdw` varchar(255) collate utf8_bin default NULL,
  `shulv` float default NULL,
  `sl` int(11) default NULL,
  `wsdj` float default NULL,
  `wsje` float default NULL,
  `xh` varchar(255) collate utf8_bin default NULL,
  `zke` float default NULL,
  `xsyddzhubid` int(11) default NULL,
  PRIMARY KEY  (`xsyddzhibid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `xsyddzhib`
--


/*!40000 ALTER TABLE `xsyddzhib` DISABLE KEYS */;
LOCK TABLES `xsyddzhib` WRITE;
INSERT INTO `xsyddzhib` VALUES (1,NULL,'松子',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(2,NULL,'碧根果',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(3,NULL,'腰果',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(4,NULL,'牛板筋',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2),(5,NULL,'夏威夷果',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsyddzhib` ENABLE KEYS */;

--
-- Table structure for table `xsyddzhub`
--

DROP TABLE IF EXISTS `xsyddzhub`;
CREATE TABLE `xsyddzhub` (
  `xsyddzhubid` bigint(20) NOT NULL auto_increment,
  `ddh` varchar(100) default NULL,
  `dhrq` date default NULL,
  `khmc` varchar(100) default NULL,
  `spr` varchar(20) default NULL,
  `sprq` datetime default NULL,
  `state` varchar(255) default NULL,
  `sxbm` varchar(20) default NULL,
  `xgr` varchar(20) default NULL,
  `xgrq` datetime default NULL,
  `ywy` varchar(20) default NULL,
  `zdr` varchar(255) default NULL,
  `zdrq` datetime default NULL,
  PRIMARY KEY  (`xsyddzhubid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `xsyddzhub`
--


/*!40000 ALTER TABLE `xsyddzhub` DISABLE KEYS */;
LOCK TABLES `xsyddzhub` WRITE;
INSERT INTO `xsyddzhub` VALUES (1,NULL,NULL,'李白',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,'杜甫',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,NULL,'白居易',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `xsyddzhub` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

