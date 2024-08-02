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
