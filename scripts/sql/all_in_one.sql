CREATE DATABASE `bidding`  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'bidding'@'localhost' IDENTIFIED BY 'mypwd';

GRANT USAGE ON *.* TO 'bidding'@'localhost' WITH MAX_QUERIES_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_USER_CONNECTIONS 0;

GRANT SELECT, INSERT, UPDATE, REFERENCES, DELETE, CREATE, DROP, ALTER, INDEX, TRIGGER, CREATE VIEW, SHOW VIEW, EXECUTE, ALTER ROUTINE, CREATE ROUTINE, CREATE TEMPORARY TABLES, LOCK TABLES, EVENT ON `bidding`.* TO 'bidding'@'localhost';

GRANT GRANT OPTION ON `bidding`.* TO 'bidding'@'localhost';

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