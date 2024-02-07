-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema budget_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema budget_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budget_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP);

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
AUTO_INCREMENT = 8
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
  `total_expense` DECIMAL(10,0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `budget_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
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
  `total` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `budget_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `budget_id_idx` (`budget_id` ASC) VISIBLE,
  CONSTRAINT `budget_id`
    FOREIGN KEY (`budget_id`)
    REFERENCES `budget_db`.`budget` (`id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `budget_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
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
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
