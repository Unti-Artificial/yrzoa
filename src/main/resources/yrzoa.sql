/*
Navicat MySQL Data Transfer

Source Server         : yrz
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : yrzoa

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-12-21 17:30:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oa_clock
-- ----------------------------
DROP TABLE IF EXISTS `oa_clock`;
CREATE TABLE `oa_clock` (
  `ClockUser` varchar(255) DEFAULT NULL,
  `ClockCreateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_clock
-- ----------------------------

-- ----------------------------
-- Table structure for oa_clock_time
-- ----------------------------
DROP TABLE IF EXISTS `oa_clock_time`;
CREATE TABLE `oa_clock_time` (
  `ClockUser` varchar(255) DEFAULT NULL,
  `ClockInDegree` varchar(255) DEFAULT NULL,
  `ClockInCreateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_clock_time
-- ----------------------------

-- ----------------------------
-- Table structure for oa_inform
-- ----------------------------
DROP TABLE IF EXISTS `oa_inform`;
CREATE TABLE `oa_inform` (
  `informContent` varchar(255) DEFAULT NULL,
  `informCreateTime` varchar(255) DEFAULT NULL,
  `informPublisher` varchar(255) NOT NULL,
  `informId` int(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`informId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_inform
-- ----------------------------

-- ----------------------------
-- Table structure for oa_user
-- ----------------------------
DROP TABLE IF EXISTS `oa_user`;
CREATE TABLE `oa_user` (
  `userState` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userPhone` varchar(255) NOT NULL,
  `userDepartment` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_user
-- ----------------------------
INSERT INTO `oa_user` VALUES ('1', '1', '123', '123', 'admin', '张三', '545484763@qq.com', '17786419044', 'IT部');
INSERT INTO `oa_user` VALUES ('1', '2', '123456', '123456', 'user', '11111', '33333@qq.com', '19999999999', '编辑部');
