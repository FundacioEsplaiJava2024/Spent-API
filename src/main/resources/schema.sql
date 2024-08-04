-- DROP SCHEMA IF EXISTS `spent` ;

CREATE SCHEMA IF NOT EXISTS `spent` DEFAULT CHARACTER SET utf8mb4;
USE `spent` ;

-- Table structure for table `event`
DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `date` DATE NOT NULL,
    `start_time` TIME NOT NULL,
    `end_time` TIME,
    `num_participants` INT,
    `address` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Table structure for table `sport`
DROP TABLE IF EXISTS `sport`;
CREATE TABLE IF NOT EXISTS sport (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) UNIQUE NOT NULL,
  `description` TEXT NOT NULL,
   PRIMARY KEY (`id`)
);