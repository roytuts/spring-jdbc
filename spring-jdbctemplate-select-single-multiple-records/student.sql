CREATE DATABASE IF NOT EXISTS `roytuts`;
USE `roytuts`;

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int unsigned NOT NULL AUTO_INCREMENT,
  `student_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_dob` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_address` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `student` (`student_id`, `student_name`, `student_dob`, `student_email`, `student_address`) VALUES
	(1, 'Sumit', '01-01-1980', 'sumit@email.com', 'Garifa'),
	(2, 'Sumit', '01-01-1980', 'sumit@email.com', 'Garifa'),
	(3, 'Anjisnu', '01-01-1982', 'gourab@email.com', 'Garia'),
	(4, 'Debina', '01-01-1982', 'debina@email.com', 'Salt Lake'),
	(5, 'Souvik', '01-01-1992', 'souvik@email.com', 'Alipore'),
	(6, 'Liton', '01-01-1990', 'liton@email.com', 'Salt Lake');
  
