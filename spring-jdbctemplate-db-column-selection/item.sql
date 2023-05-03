CREATE DATABASE IF NOT EXISTS `roytuts`;
USE `roytuts`;

CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `item_price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `item` (`item_id`, `item_name`, `item_desc`, `item_price`) VALUES
	(1, 'CD', 'CD is a compact disk', 100),
	(2, 'DVD', 'DVD is larger than CD in size', 150),
	(3, 'ABC', 'ABC test description', 24),
	(4, 'XYZ', 'XYZ test description', 25.32),
	(5, 'CD Player', 'CD player is used to play CD', 30.02);
