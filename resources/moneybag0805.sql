-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema moneybag
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moneybag
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moneybag` DEFAULT CHARACTER SET utf8 ;
USE `moneybag` ;

-- -----------------------------------------------------
-- Table `moneybag`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`user` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `email` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `pw` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `account` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `fileName` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`userId`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`moneybag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`moneybag` (
  `moneybagId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `admin` INT(11) NOT NULL COMMENT '',
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '',
  `account` VARCHAR(20) NOT NULL COMMENT '',
  `info` varchar(45) NULL DEFAULT NULL COMMENT '',
  `fileName` BLOB NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`moneybagId`)  COMMENT '',
  INDEX `fk_moneybag_user1_idx` (`admin` ASC)  COMMENT '',
  CONSTRAINT `fk_moneybag_user1`
    FOREIGN KEY (`admin`)
    REFERENCES `moneybag`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`bill` (
  `bill_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `moneybagId` INT(11) NOT NULL COMMENT '',
  `billName` VARCHAR(45) NOT NULL COMMENT '',
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '',
  `info` TEXT NULL DEFAULT NULL COMMENT '',
  `fileName` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `usedMoney` INT(11) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`bill_id`, `moneybagId`)  COMMENT '',
  INDEX `fk_round_moneybag1_idx` (`moneybagId` ASC)  COMMENT '',
  CONSTRAINT `fk_round_moneybag1`
    FOREIGN KEY (`moneybagId`)
    REFERENCES `moneybag`.`moneybag` (`moneybagId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`payment` (
  `payId` INT(11) NOT NULL COMMENT '',
  `moneybagId` INT(11) NOT NULL COMMENT '',
  `moneyPerUser` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`payId`)  COMMENT '',
  INDEX `fk_payment_moneybag1_idx` (`moneybagId` ASC)  COMMENT '',
  CONSTRAINT `fk_payment_moneybag1`
    FOREIGN KEY (`moneybagId`)
    REFERENCES `moneybag`.`moneybag` (`moneybagId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`payment_has_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`payment_has_user` (
  `payment_payId` INT(11) NOT NULL COMMENT '',
  `user_userId` INT(11) NOT NULL COMMENT '',
  `is_payed` TINYINT(4) NOT NULL COMMENT '',
  PRIMARY KEY (`payment_payId`, `user_userId`)  COMMENT '',
  INDEX `fk_payment_has_user_user1_idx` (`user_userId` ASC)  COMMENT '',
  INDEX `fk_payment_has_user_payment1_idx` (`payment_payId` ASC)  COMMENT '',
  CONSTRAINT `fk_payment_has_user_payment1`
    FOREIGN KEY (`payment_payId`)
    REFERENCES `moneybag`.`payment` (`payId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_has_user_user1`
    FOREIGN KEY (`user_userId`)
    REFERENCES `moneybag`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`user_moneybag_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`user_moneybag_mapping` (
  `moneybagId` INT(11) NOT NULL COMMENT '',
  `userId` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`moneybagId`, `userId`)  COMMENT '',
  INDEX `fk_moneybag_has_user_user1_idx` (`userId` ASC)  COMMENT '',
  INDEX `fk_moneybag_has_user_moneybag1_idx` (`moneybagId` ASC)  COMMENT '',
  CONSTRAINT `fk_moneybag_has_user_moneybag1`
    FOREIGN KEY (`moneybagId`)
    REFERENCES `moneybag`.`moneybag` (`moneybagId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_moneybag_has_user_user1`
    FOREIGN KEY (`userId`)
    REFERENCES `moneybag`.`user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `moneybag`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moneybag`.`board` (
  `boardId` INT NOT NULL AUTO_INCREMENT COMMENT '' ,
  `writer` VARCHAR(45) NOT NULL COMMENT '',
  `title` VARCHAR(45) NOT NULL COMMENT '',
  `content` BLOB NULL COMMENT '',
  `hits` INT NULL COMMENT '',
  `time` TIMESTAMP NOT NULL COMMENT '',
  `moneybagId` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`boardId`, `moneybagId`)  COMMENT '',
  INDEX `fk_board_moneybag1_idx` (`moneybagId` ASC)  COMMENT '',
  CONSTRAINT `fk_board_moneybag1`
    FOREIGN KEY (`moneybagId`)
    REFERENCES `moneybag`.`moneybag` (`moneybagId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
