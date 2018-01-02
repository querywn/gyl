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
INSERT INTO `privilege` VALUES (1,NULL,'供应链管理系统',0,'','1','images/003.gif',NULL,NULL),(2,NULL,'基础数据',1,'','1','images/003.gif',NULL,NULL),(3,NULL,'部门',2,'','1','images/003.gif',NULL,NULL),(4,NULL,'部门查询',3,'\0','2','images/002.gif',NULL,NULL),(5,NULL,'部门修改',3,'\0','2','images/002.gif',NULL,NULL),(6,NULL,'部门增加',3,'\0','2','images/002.gif',NULL,NULL),(7,NULL,'部门删除',3,'\0','2','images/002.gif',NULL,NULL),(8,NULL,'用户',2,'','1','images/003.gif',NULL,NULL),(9,NULL,'用户增加',8,'\0','2','images/002.gif',NULL,NULL),(10,NULL,'用户修改',8,'\0','2','images/002.gif',NULL,NULL),(11,NULL,'用户删除',8,'\0','2','images/002.gif',NULL,NULL),(12,NULL,'用户查询',8,'\0','2','images/002.gif',NULL,NULL),(13,NULL,'角色',2,'\0','1','images/003.gif',NULL,NULL),(14,NULL,'角色增加',13,'\0','2','images/002.gif',NULL,NULL),(15,NULL,'角色修改',13,'\0','2','images/002.gif',NULL,NULL),(16,NULL,'角色增加',13,'\0','2','images/002.gif',NULL,NULL),(17,NULL,'角色删除',13,'\0','2','images/002.gif',NULL,NULL),(18,NULL,'商品',2,'','1','images/003.gif',NULL,NULL),(19,NULL,'商品增加',18,'\0','2','images/002.gif',NULL,NULL),(20,NULL,'商品增加',18,'\0','2','images/002.gif',NULL,NULL),(21,NULL,'商品查询',18,'\0','2','images/002.gif',NULL,NULL),(22,NULL,'商品删除',18,'\0','2','images/002.gif',NULL,NULL),(23,NULL,'仓库',2,'\0','1','images/003.gif',NULL,NULL),(24,NULL,'仓库增加',23,'\0','2','images/002.gif',NULL,NULL),(25,NULL,'仓库修改',23,'\0','2','images/002.gif',NULL,NULL),(26,NULL,'仓库查询',23,'\0','2','images/002.gif',NULL,NULL),(27,NULL,'仓库删除',23,'\0','2','images/002.gif',NULL,NULL),(28,NULL,'客户',2,'\0','1','images/003.gif',NULL,NULL),(29,NULL,'客户增加',28,'\0','2','images/002.gif',NULL,NULL),(30,NULL,'客户修改',28,'\0','2','images/002.gif',NULL,NULL),(31,NULL,'客户查询',28,'\0','2','images/002.gif',NULL,NULL),(32,NULL,'客户删除',28,'\0','2','images/002.gif',NULL,NULL),(33,NULL,'供应商',2,'\0','1','images/003.gif',NULL,NULL),(34,NULL,'供应商增加',33,'\0','2','images/002.gif',NULL,NULL),(35,NULL,'供应商修改',33,'\0','2','images/002.gif',NULL,NULL),(36,NULL,'供应商查询',33,'\0','2','images/002.gif',NULL,NULL),(37,NULL,'供应商删除',33,'\0','2','images/002.gif',NULL,NULL),(38,NULL,'权限管理',1,'','1','images/003.gif',NULL,NULL),(39,NULL,'角色配置',38,'','1','images/003.gif',NULL,NULL),(40,NULL,'用户匹配角色',39,'\0','2','images/002.gif',NULL,NULL),(41,NULL,'权限配置',38,'\0','1','images/002.gif',NULL,NULL),(42,NULL,'角色匹配权限',41,'\0','2','images/002.gif',NULL,NULL),(43,NULL,'业务',1,'','1','images/003.gif',NULL,NULL),(44,NULL,'采购管理',43,'','1','images/003.gif',NULL,NULL),(45,NULL,'请购单管理',44,'','1','images/003.gif',NULL,NULL),(46,NULL,'增加',45,'\0','1','images/003.gif',NULL,NULL),(47,NULL,'修改',45,'\0','1','images/003.gif',NULL,NULL),(48,NULL,'查询',45,'\0','1','images/003.gif',NULL,NULL),(49,NULL,'审批',45,'\0','1','images/003.gif',NULL,NULL),(50,NULL,'请购单管理',44,'','1','images/003.gif',NULL,NULL),(51,NULL,'增加',50,'\0','1','images/003.gif',NULL,NULL),(52,NULL,'修改',50,'\0','1','images/003.gif',NULL,NULL),(53,NULL,'查询',50,'\0','1','images/003.gif',NULL,NULL),(54,NULL,'审批',50,'\0','1','images/003.gif',NULL,NULL),(55,NULL,'采购入库单管理',44,'','1','images/003.gif',NULL,NULL),(56,NULL,'增加',55,'\0','1','images/003.gif',NULL,NULL),(57,NULL,'修改',55,'\0','1','images/003.gif',NULL,NULL),(58,NULL,'查询',55,'\0','1','images/003.gif',NULL,NULL),(59,NULL,'审批',55,'\0','1','images/003.gif',NULL,NULL),(60,NULL,'采购发票管理',44,'','1','images/003.gif',NULL,NULL),(61,NULL,'增加',60,'\0','1','images/003.gif',NULL,NULL),(62,NULL,'修改',60,'\0','1','images/003.gif',NULL,NULL),(63,NULL,'查询',60,'\0','1','images/003.gif',NULL,NULL),(64,NULL,'审批',60,'\0','1','images/003.gif',NULL,NULL),(65,NULL,'销售管理',43,'','1','images/003.gif',NULL,NULL),(66,NULL,'销售预订单管理',65,'','1','images/003.gif',NULL,NULL),(67,NULL,'增加',66,'\0','1','images/003.gif',NULL,NULL),(68,NULL,'修改',66,'\0','1','images/003.gif',NULL,NULL),(69,NULL,'查询',66,'\0','1','images/003.gif',NULL,NULL),(70,NULL,'审批',66,'\0','1','images/003.gif',NULL,NULL),(71,NULL,'销售订单管理',65,'','1','images/003.gif',NULL,NULL),(72,NULL,'增加',71,'\0','1','images/003.gif',NULL,NULL),(73,NULL,'增加',71,'\0','1','images/003.gif',NULL,NULL),(74,NULL,'查询',71,'\0','1','images/003.gif',NULL,NULL),(75,NULL,'审批',71,'\0','1','images/003.gif',NULL,NULL),(76,NULL,'发货单管理',65,'','1','images/003.gif',NULL,NULL),(77,NULL,'增加',76,'\0','1','images/003.gif',NULL,NULL),(78,NULL,'修改',76,'\0','1','images/003.gif',NULL,NULL),(79,NULL,'查询',76,'\0','1','images/003.gif',NULL,NULL),(80,NULL,'审批',76,'\0','1','images/003.gif',NULL,NULL),(81,NULL,'销售出库单管理',65,'','1','images/003.gif',NULL,NULL),(82,NULL,'增加',81,'\0','1','images/003.gif',NULL,NULL),(83,NULL,'修改',81,'\0','1','images/003.gif',NULL,NULL),(84,NULL,'查询',81,'\0','1','images/003.gif',NULL,NULL),(85,NULL,'审批',81,'\0','1','images/003.gif',NULL,NULL),(86,NULL,'销售开票管理',65,'','1','images/003.gif',NULL,NULL),(87,NULL,'增加',86,'\0','1','images/003.gif',NULL,NULL),(88,NULL,'修改',86,'\0','1','images/003.gif',NULL,NULL),(89,NULL,'查询',86,'\0','1','images/003.gif',NULL,NULL),(90,NULL,'审批',86,'\0','1','images/003.gif',NULL,NULL),(91,NULL,'应收应付管理',43,'','1','images/003.gif',NULL,NULL),(92,NULL,'销售应收管理',91,'','1','images/003.gif',NULL,NULL),(93,NULL,'增加',92,'\0','1','images/003.gif',NULL,NULL),(94,NULL,'修改',92,'\0','1','images/003.gif',NULL,NULL),(95,NULL,'查询',92,'\0','1','images/003.gif',NULL,NULL),(96,NULL,'审批',92,'\0','1','images/003.gif',NULL,NULL),(97,NULL,'采购应付单管理',91,'','1','images/003.gif',NULL,NULL),(98,NULL,'增加',97,'\0','1','images/003.gif',NULL,NULL),(99,NULL,'修改',97,'\0','1','images/003.gif',NULL,NULL),(100,NULL,'查询',97,'\0','1','images/003.gif',NULL,NULL),(101,NULL,'审批',97,'\0','1','images/003.gif',NULL,NULL),(102,NULL,'预警管理',43,'','1','images/003.gif',NULL,NULL),(103,NULL,'采购入库时间预警',102,'\0',NULL,'images/003.gif',NULL,NULL),(104,NULL,'销售发货预警',102,'\0','1','images/003.gif',NULL,NULL),(105,NULL,'销售出库预警',102,'\0','1','images/003.gif',NULL,NULL),(106,NULL,'仓库管理',43,'','1',NULL,NULL,NULL),(107,NULL,'期初',106,'','1','images/003.gif',NULL,NULL),(108,NULL,'增加',107,'\0','1','images/003.gif',NULL,NULL),(109,NULL,'修改',107,'\0','1','images/003.gif',NULL,NULL),(110,NULL,'查询',107,'\0','1','images/003.gif',NULL,NULL),(111,NULL,'审批',107,'\0','1','images/003.gif',NULL,NULL),(112,NULL,'盘点',106,'','1','images/003.gif',NULL,NULL),(113,NULL,'增加',112,'\0','1','images/003.gif',NULL,NULL),(114,NULL,'修改',112,'\0','1','images/003.gif',NULL,NULL),(115,NULL,'查询',112,'\0','1','images/003.gif',NULL,NULL),(116,NULL,'审批',112,'\0','1','images/003.gif',NULL,NULL),(117,NULL,'供应链管理系统',0,'','1','images/003.gif',NULL,NULL),(118,NULL,'基础数据',117,'','1','images/003.gif',NULL,NULL),(119,NULL,'部门',118,'','1','images/003.gif',NULL,NULL),(120,NULL,'部门增加',119,'\0','2','images/002.gif',NULL,NULL),(121,NULL,'部门修改',119,'\0','2','images/002.gif',NULL,NULL),(122,NULL,'部门增加',119,'\0','2','images/002.gif',NULL,NULL),(123,NULL,'部门删除',119,'\0','2','images/002.gif',NULL,NULL),(124,NULL,'用户',118,'','1','images/003.gif',NULL,NULL),(125,NULL,'用户增加',124,'\0','2','images/002.gif',NULL,NULL),(126,NULL,'用户修改',124,'\0','2','images/002.gif',NULL,NULL),(127,NULL,'用户删除',124,'\0','2','images/002.gif',NULL,NULL),(128,NULL,'用户查询',124,'\0','2','images/002.gif',NULL,NULL),(129,NULL,'角色',118,'\0','1','images/003.gif',NULL,NULL),(130,NULL,'角色增加',129,'\0','2','images/002.gif',NULL,NULL),(131,NULL,'角色修改',129,'\0','2','images/002.gif',NULL,NULL),(132,NULL,'角色增加',129,'\0','2','images/002.gif',NULL,NULL),(133,NULL,'角色删除',129,'\0','2','images/002.gif',NULL,NULL),(134,NULL,'商品',118,'','1','images/003.gif',NULL,NULL),(135,NULL,'商品增加',134,'\0','2','images/002.gif',NULL,NULL),(136,NULL,'商品增加',134,'\0','2','images/002.gif',NULL,NULL),(137,NULL,'商品查询',134,'\0','2','images/002.gif',NULL,NULL),(138,NULL,'商品删除',134,'\0','2','images/002.gif',NULL,NULL),(139,NULL,'仓库',118,'\0','1','images/003.gif',NULL,NULL),(140,NULL,'仓库增加',139,'\0','2','images/002.gif',NULL,NULL),(141,NULL,'仓库修改',139,'\0','2','images/002.gif',NULL,NULL),(142,NULL,'仓库查询',139,'\0','2','images/002.gif',NULL,NULL),(143,NULL,'仓库删除',139,'\0','2','images/002.gif',NULL,NULL),(144,NULL,'客户',118,'\0','1','images/003.gif',NULL,NULL),(145,NULL,'客户增加',144,'\0','2','images/002.gif',NULL,NULL),(146,NULL,'客户修改',144,'\0','2','images/002.gif',NULL,NULL),(147,NULL,'客户查询',144,'\0','2','images/002.gif',NULL,NULL),(148,NULL,'客户删除',144,'\0','2','images/002.gif',NULL,NULL),(149,NULL,'供应商',118,'\0','1','images/003.gif',NULL,NULL),(150,NULL,'供应商增加',149,'\0','2','images/002.gif',NULL,NULL),(151,NULL,'供应商修改',149,'\0','2','images/002.gif',NULL,NULL),(152,NULL,'供应商查询',149,'\0','2','images/002.gif',NULL,NULL),(153,NULL,'供应商删除',149,'\0','2','images/002.gif',NULL,NULL),(154,NULL,'权限管理',117,'','1','images/003.gif',NULL,NULL),(155,NULL,'角色配置',154,'','1','images/003.gif',NULL,NULL),(156,NULL,'用户匹配角色',155,'\0','2','images/002.gif',NULL,NULL),(157,NULL,'权限配置',154,'\0','1','images/002.gif',NULL,NULL),(158,NULL,'角色匹配权限',157,'\0','2','images/002.gif',NULL,NULL),(159,NULL,'业务',117,'','1','images/003.gif',NULL,NULL),(160,NULL,'采购管理',159,'','1','images/003.gif',NULL,NULL),(161,NULL,'请购单管理',160,'','1','images/003.gif',NULL,NULL),(162,NULL,'增加',161,'\0','1','images/003.gif',NULL,NULL),(163,NULL,'修改',161,'\0','1','images/003.gif',NULL,NULL),(164,NULL,'查询',161,'\0','1','images/003.gif',NULL,NULL),(165,NULL,'审批',161,'\0','1','images/003.gif',NULL,NULL),(166,NULL,'请购单管理',160,'','1','images/003.gif',NULL,NULL),(167,NULL,'增加',166,'\0','1','images/003.gif',NULL,NULL),(168,NULL,'修改',166,'\0','1','images/003.gif',NULL,NULL),(169,NULL,'查询',166,'\0','1','images/003.gif',NULL,NULL),(170,NULL,'审批',166,'\0','1','images/003.gif',NULL,NULL),(171,NULL,'采购入库单管理',160,'','1','images/003.gif',NULL,NULL),(172,NULL,'增加',171,'\0','1','images/003.gif',NULL,NULL),(173,NULL,'修改',171,'\0','1','images/003.gif',NULL,NULL),(174,NULL,'查询',171,'\0','1','images/003.gif',NULL,NULL),(175,NULL,'审批',171,'\0','1','images/003.gif',NULL,NULL),(176,NULL,'采购发票管理',160,'','1','images/003.gif',NULL,NULL),(177,NULL,'增加',176,'\0','1','images/003.gif',NULL,NULL),(178,NULL,'修改',176,'\0','1','images/003.gif',NULL,NULL),(179,NULL,'查询',176,'\0','1','images/003.gif',NULL,NULL),(180,NULL,'审批',176,'\0','1','images/003.gif',NULL,NULL),(181,NULL,'销售管理',159,'','1','images/003.gif',NULL,NULL),(182,NULL,'销售预订单管理',181,'','1','images/003.gif',NULL,NULL),(183,NULL,'增加',182,'\0','1','images/003.gif',NULL,NULL),(184,NULL,'修改',182,'\0','1','images/003.gif',NULL,NULL),(185,NULL,'查询',182,'\0','1','images/003.gif',NULL,NULL),(186,NULL,'审批',182,'\0','1','images/003.gif',NULL,NULL),(187,NULL,'销售订单管理',181,'','1','images/003.gif',NULL,NULL),(188,NULL,'增加',187,'\0','1','images/003.gif',NULL,NULL),(189,NULL,'增加',187,'\0','1','images/003.gif',NULL,NULL),(190,NULL,'查询',187,'\0','1','images/003.gif',NULL,NULL),(191,NULL,'审批',187,'\0','1','images/003.gif',NULL,NULL),(192,NULL,'发货单管理',181,'','1','images/003.gif',NULL,NULL),(193,NULL,'增加',192,'\0','1','images/003.gif',NULL,NULL),(194,NULL,'修改',192,'\0','1','images/003.gif',NULL,NULL),(195,NULL,'查询',192,'\0','1','images/003.gif',NULL,NULL),(196,NULL,'审批',192,'\0','1','images/003.gif',NULL,NULL),(197,NULL,'销售出库单管理',181,'','1','images/003.gif',NULL,NULL),(198,NULL,'增加',197,'\0','1','images/003.gif',NULL,NULL),(199,NULL,'修改',197,'\0','1','images/003.gif',NULL,NULL),(200,NULL,'查询',197,'\0','1','images/003.gif',NULL,NULL),(201,NULL,'审批',197,'\0','1','images/003.gif',NULL,NULL),(202,NULL,'销售开票管理',181,'','1','images/003.gif',NULL,NULL),(203,NULL,'增加',202,'\0','1','images/003.gif',NULL,NULL),(204,NULL,'修改',202,'\0','1','images/003.gif',NULL,NULL),(205,NULL,'查询',202,'\0','1','images/003.gif',NULL,NULL),(206,NULL,'审批',202,'\0','1','images/003.gif',NULL,NULL),(207,NULL,'应收应付管理',159,'','1','images/003.gif',NULL,NULL),(208,NULL,'销售应收管理',207,'','1','images/003.gif',NULL,NULL),(209,NULL,'增加',208,'\0','1','images/003.gif',NULL,NULL),(210,NULL,'修改',208,'\0','1','images/003.gif',NULL,NULL),(211,NULL,'查询',208,'\0','1','images/003.gif',NULL,NULL),(212,NULL,'审批',208,'\0','1','images/003.gif',NULL,NULL),(213,NULL,'采购应付单管理',207,'','1','images/003.gif',NULL,NULL),(214,NULL,'增加',213,'\0','1','images/003.gif',NULL,NULL),(215,NULL,'修改',213,'\0','1','images/003.gif',NULL,NULL),(216,NULL,'查询',213,'\0','1','images/003.gif',NULL,NULL),(217,NULL,'审批',213,'\0','1','images/003.gif',NULL,NULL),(218,NULL,'预警管理',159,'','1','images/003.gif',NULL,NULL),(219,NULL,'采购入库时间预警',218,'\0',NULL,'images/003.gif',NULL,NULL),(220,NULL,'销售发货预警',218,'\0','1','images/003.gif',NULL,NULL),(221,NULL,'销售出库预警',218,'\0','1','images/003.gif',NULL,NULL),(222,NULL,'仓库管理',159,'','1',NULL,NULL,NULL),(223,NULL,'期初',222,'','1','images/003.gif',NULL,NULL),(224,NULL,'增加',223,'\0','1','images/003.gif',NULL,NULL),(225,NULL,'修改',223,'\0','1','images/003.gif',NULL,NULL),(226,NULL,'查询',223,'\0','1','images/003.gif',NULL,NULL),(227,NULL,'审批',223,'\0','1','images/003.gif',NULL,NULL),(228,NULL,'盘点',222,'','1','images/003.gif',NULL,NULL),(229,NULL,'增加',228,'\0','1','images/003.gif',NULL,NULL),(230,NULL,'修改',228,'\0','1','images/003.gif',NULL,NULL),(231,NULL,'查询',228,'\0','1','images/003.gif',NULL,NULL),(232,NULL,'审批',228,'\0','1','images/003.gif',NULL,NULL);
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
INSERT INTO `role_privilege` VALUES (1,2),(43,2),(44,2),(45,2),(46,2),(47,2),(48,2),(49,2),(55,2),(60,2),(65,2),(66,2),(71,2),(76,2),(81,2),(86,2),(91,2),(92,2),(97,2),(102,2),(103,2),(104,2),(105,2),(106,2),(107,2),(112,2),(1,3),(2,3),(3,3),(4,3),(5,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(17,3),(18,3),(19,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(41,3),(42,3),(43,3),(44,3),(45,3),(46,3),(47,3),(48,3),(49,3),(55,3),(60,3),(65,3),(66,3),(71,3),(76,3),(81,3),(86,3),(91,3),(92,3),(97,3),(102,3),(103,3),(104,3),(105,3),(106,3),(107,3),(112,3),(1,5),(2,5),(3,5),(4,5),(5,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(17,5),(18,5),(19,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5),(28,5),(29,5),(30,5),(31,5),(32,5),(33,5),(34,5),(35,5),(36,5),(37,5);
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

