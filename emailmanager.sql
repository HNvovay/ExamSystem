/*
Navicat MySQL Data Transfer

Source Server         : hyh
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : emailmanager

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-11-12 13:20:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `emailtype` varchar(45) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `birthday` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `magazine` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_email_1` (`emailtype`),
  CONSTRAINT `FK_email_1` FOREIGN KEY (`emailtype`) REFERENCES `emailtype` (`type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES ('1', 'sadf', 'yahoo', 's', 's', '男', '汽车,', '');
INSERT INTO `email` VALUES ('2', 'sss', 'yahoo', 's', 's', '男', '旅游,', 's');

-- ----------------------------
-- Table structure for emailtype
-- ----------------------------
DROP TABLE IF EXISTS `emailtype`;
CREATE TABLE `emailtype` (
  `type` varchar(45) NOT NULL,
  `typename` varchar(45) NOT NULL,
  PRIMARY KEY (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emailtype
-- ----------------------------
INSERT INTO `emailtype` VALUES ('163', '163.com');
INSERT INTO `emailtype` VALUES ('yahoo', 'yahoo.cn');

-- ----------------------------
-- Table structure for userlogin
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin` (
  `userName` varchar(45) CHARACTER SET utf8 NOT NULL,
  `userPassword` varchar(45) CHARACTER SET utf8 NOT NULL,
  `userRole` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userlogin
-- ----------------------------
INSERT INTO `userlogin` VALUES ('admin', 'admin', 'admin');
INSERT INTO `userlogin` VALUES ('user', 'user', 'user');
