-- Server version	9.0.0

-- DROP SCHEMA IF EXISTS `spent` ;

CREATE SCHEMA IF NOT EXISTS `spent` DEFAULT CHARACTER SET utf8mb4;
USE `spent` ;

-- Table structure for table `sport`
DROP TABLE IF EXISTS `sport`;
CREATE TABLE IF NOT EXISTS sport (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) UNIQUE NOT NULL,
  `description` TEXT NOT NULL,
   PRIMARY KEY (`id`)
);
