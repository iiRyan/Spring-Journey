-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema budget_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema budget_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budget_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `budget_db` ;

-- -----------------------------------------------------
-- Table `budget_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `budget_db`.`budget`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget_db`.`budget` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `income` DECIMAL(10,0) NULL DEFAULT NULL,
  `month` VARCHAR(12) NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `budget_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `budget_db`.`expense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget_db`.`expense` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NULL DEFAULT NULL,
  `description` VARCHAR(50) NULL DEFAULT NULL,
  `bank_account` VARCHAR(45) NULL DEFAULT NULL,
  `paid` TINYINT NULL DEFAULT NULL,
  `budget_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `budget_id_idx` (`budget_id` ASC) VISIBLE,
  CONSTRAINT `budget_id`
    FOREIGN KEY (`budget_id`)
    REFERENCES `budget_db`.`budget` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `budget_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `expense_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `expense_id_idx` (`expense_id` ASC) VISIBLE,
  CONSTRAINT `expense_id`
    FOREIGN KEY (`expense_id`)
    REFERENCES `budget_db`.`expense` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `budget_db` ;

-- -----------------------------------------------------
-- Placeholder table for view `budget_db`.`userexpenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budget_db`.`userexpenses` (`id` INT, `amount` INT, `description` INT, `bank_account` INT, `paid` INT, `budget_id` INT);

-- -----------------------------------------------------
-- View `budget_db`.`userexpenses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `budget_db`.`userexpenses`;
USE `budget_db`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `budget_db`.`userexpenses` AS select `e`.`id` AS `id`,`e`.`amount` AS `amount`,`e`.`description` AS `description`,`e`.`bank_account` AS `bank_account`,`e`.`paid` AS `paid`,`e`.`budget_id` AS `budget_id` from (`budget_db`.`expense` `e` join `budget_db`.`budget` `b` on((`e`.`budget_id` = `b`.`id`))) where (`b`.`user_id` = 1);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
