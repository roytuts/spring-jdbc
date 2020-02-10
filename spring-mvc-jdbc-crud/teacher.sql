CREATE TABLE `teacher` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `expertise` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

insert  into `teacher`(`id`,`name`,`expertise`)
values (16,'Bibhas Chandra Dhara','Statistics'),
(18,'UKR','System Programming'),(19,'New','Expert');