CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int unsigned COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT,
  `student_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_dob` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_email` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `student_address` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;