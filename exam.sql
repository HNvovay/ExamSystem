/*
Navicat MySQL Data Transfer

Source Server         : hyh
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-11-12 13:21:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for exam_judge
-- ----------------------------
DROP TABLE IF EXISTS `exam_judge`;
CREATE TABLE `exam_judge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionText` varchar(50) NOT NULL,
  `answer` int(11) NOT NULL,
  `score` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_judge
-- ----------------------------
INSERT INTO `exam_judge` VALUES ('3', '你是帅哥吗', '0', '2');
INSERT INTO `exam_judge` VALUES ('4', 'Test', '0', '2');
INSERT INTO `exam_judge` VALUES ('5', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('6', '我是帅哥吗', '1', '2');
INSERT INTO `exam_judge` VALUES ('7', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('8', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('9', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('10', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('11', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('12', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('13', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('14', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('15', 'Test', '0', '2');
INSERT INTO `exam_judge` VALUES ('16', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('17', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('18', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('19', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('20', 'Test', '1', '2');
INSERT INTO `exam_judge` VALUES ('21', 'fsadfasdfssdf', '1', '3');
INSERT INTO `exam_judge` VALUES ('22', '我是帅哥吗', '1', '2');
INSERT INTO `exam_judge` VALUES ('23', '我是帅哥吗', '1', '2');

-- ----------------------------
-- Table structure for exam_mchoose
-- ----------------------------
DROP TABLE IF EXISTS `exam_mchoose`;
CREATE TABLE `exam_mchoose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionText` varchar(50) NOT NULL,
  `answer` varchar(10) NOT NULL,
  `optionA` varchar(10) NOT NULL,
  `optionB` varchar(10) NOT NULL,
  `optionC` varchar(10) NOT NULL,
  `optionD` varchar(10) NOT NULL,
  `score` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_mchoose
-- ----------------------------
INSERT INTO `exam_mchoose` VALUES ('2', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('3', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('4', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('5', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('6', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('7', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('8', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('9', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('10', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('11', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('12', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('13', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('14', 'Test', 'AB', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_mchoose` VALUES ('15', '234234', 'AC', '2312', '123', '3123', '1231', '2');
INSERT INTO `exam_mchoose` VALUES ('16', '23123', 'A', '123', '123', '123', '123', '2');
INSERT INTO `exam_mchoose` VALUES ('17', '2', 'AB', '2', '2', '2', '2', '2');
INSERT INTO `exam_mchoose` VALUES ('18', '2', 'AB', '2', '2', '2', '2', '2');

-- ----------------------------
-- Table structure for exam_schoose
-- ----------------------------
DROP TABLE IF EXISTS `exam_schoose`;
CREATE TABLE `exam_schoose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionText` varchar(50) NOT NULL,
  `answer` varchar(10) NOT NULL,
  `optionA` varchar(10) NOT NULL,
  `optionB` varchar(10) NOT NULL,
  `optionC` varchar(10) NOT NULL,
  `optionD` varchar(10) NOT NULL,
  `score` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_schoose
-- ----------------------------
INSERT INTO `exam_schoose` VALUES ('24', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('25', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('26', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('27', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('28', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('29', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('30', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('35', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('36', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('37', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('38', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('39', 'Test', 'A', 'Test', 'Test', 'Test', 'Test', '2');
INSERT INTO `exam_schoose` VALUES ('40', '我是帅哥吗', 'D', '是的', '不是', '有可能', '一定是', '2');
INSERT INTO `exam_schoose` VALUES ('41', '我是帅哥吗', 'D', '是的', '不是', '有可能', '一定是', '2');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `paper_id` int(11) DEFAULT NULL,
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`),
  KEY `paper_id` (`paper_id`),
  CONSTRAINT `mark_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mark_ibfk_2` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('8', 'student', '16', '14');
INSERT INTO `mark` VALUES ('9', 'student', '17', '12');
INSERT INTO `mark` VALUES ('10', 'student', '22', '14');
INSERT INTO `mark` VALUES ('11', 'student', '24', '8');
INSERT INTO `mark` VALUES ('12', 'student', '25', '10');
INSERT INTO `mark` VALUES ('13', 'student', '13', '6');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperName` varchar(255) NOT NULL,
  `schoose_id` varchar(255) DEFAULT NULL,
  `judge_id` varchar(255) DEFAULT NULL,
  `mchoose_id` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('13', 'NormalPaper', '18,19,20,23,25', '1,5,7,1,3,6', '1,5,8', '已发布');
INSERT INTO `paper` VALUES ('15', 'R_PaperB', '36,28,20,37,30,22,19,27,23,29', '15,5,20,7,3,1,4,10,12,14', '5,7,10,3,2,6,12,13,4,9', '已发布');
INSERT INTO `paper` VALUES ('16', 'R_PaperC', '24,23,35,18,36', '4,15,7,20,6', '9,13,4,7,1', '已发布');
INSERT INTO `paper` VALUES ('17', 'TestMark', '18,19', '1,2', '1,2', '已发布');
INSERT INTO `paper` VALUES ('21', 'R_C', '21,35,30,22,36', '5,15,21,11,4', '1,2,3,12,6', '未发布');
INSERT INTO `paper` VALUES ('22', 'Test_SHI', '21,22,23', '1,2,3', '1,2,3', '已发布');
INSERT INTO `paper` VALUES ('24', 'Test_1', '22,24,25', '2,3', '2,3', '已发布');
INSERT INTO `paper` VALUES ('25', 'Test_23', '22,24', '4,5', '4,5', '已发布');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  KEY `role` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'student');
INSERT INTO `role` VALUES ('2', 'teacher');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `role` (`role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role`) REFERENCES `role` (`role`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('student', '1', '1');
INSERT INTO `user` VALUES ('student2', '1', '1');
INSERT INTO `user` VALUES ('student3', '1', '1');
INSERT INTO `user` VALUES ('student4', '1', '1');
INSERT INTO `user` VALUES ('student5', '1', '1');
INSERT INTO `user` VALUES ('teacher', '1', '2');
