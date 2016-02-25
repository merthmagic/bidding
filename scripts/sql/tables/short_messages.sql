/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : bidding

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-02-23 20:45:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for short_messages
-- ----------------------------
DROP TABLE IF EXISTS `short_messages`;
CREATE TABLE `short_messages` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cellphone_number` varchar(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  `sms_verndor_id` int(11) NOT NULL,
  `sent_on` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
