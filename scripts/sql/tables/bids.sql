/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : bidding

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-02-23 20:45:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bids
-- ----------------------------
DROP TABLE IF EXISTS `bids`;
CREATE TABLE `bids` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bid_number` varchar(40) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `amount` decimal(10,0) NOT NULL,
  `draft` tinyint(4) NOT NULL,
  `created_on` datetime NOT NULL,
  `modifed_on` datetime NOT NULL,
  `published_on` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `sort_order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique_bid_number` (`bid_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
