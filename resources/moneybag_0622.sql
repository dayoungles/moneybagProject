SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


CREATE SCHEMA IF NOT EXISTS `moneybag` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `moneybag` ;

-- -----------------------------------------------------
-- Table `moneybag`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`user` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(45) NULL ,
  `pw` VARCHAR(45) NULL ,
  `name` VARCHAR(45) NULL ,
  `account` VARCHAR(45) NULL ,
  `fileName` VARCHAR(45) NULL ,
  PRIMARY KEY (`userId`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`moneybag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`moneybag` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`moneybag` (
  `moneybagId` INT NOT NULL AUTO_INCREMENT ,
  `admin` INT NOT NULL ,
  `createdDate` TIMESTAMP NOT NULL ,
  `account` VARCHAR(20) NOT NULL ,
  `info` BLOB NULL ,
  `fileName` BLOB NULL ,
  PRIMARY KEY (`moneybagId`) ,
  INDEX `fk_moneybag_user1_idx` (`admin` ASC) ,
  CONSTRAINT `fk_moneybag_user1`
    FOREIGN KEY (`admin` )
    REFERENCES `moneybag`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`bill` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`bill` (
  `roundId` INT NOT NULL AUTO_INCREMENT ,
  `moneybagId` INT NOT NULL ,
  `roundName` VARCHAR(45) NOT NULL ,
  `createdDate` TIMESTAMP NOT NULL ,
  `info` TEXT NULL ,
  `fileName` VARCHAR(20) NULL ,
  PRIMARY KEY (`roundId`, `moneybagId`) ,
  INDEX `fk_round_moneybag1_idx` (`moneybagId` ASC) ,
  CONSTRAINT `fk_round_moneybag1`
    FOREIGN KEY (`moneybagId` )
    REFERENCES `moneybag`.`moneybag` (`moneybagId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`user_moneybag_mapping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`user_moneybag_mapping` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`user_moneybag_mapping` (
  `moneybagId` INT NOT NULL ,
  `userId` INT NOT NULL ,
  PRIMARY KEY (`moneybagId`, `userId`) ,
  INDEX `fk_moneybag_has_user_user1_idx` (`userId` ASC) ,
  INDEX `fk_moneybag_has_user_moneybag1_idx` (`moneybagId` ASC) ,
  CONSTRAINT `fk_moneybag_has_user_moneybag1`
    FOREIGN KEY (`moneybagId` )
    REFERENCES `moneybag`.`moneybag` (`moneybagId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_moneybag_has_user_user1`
    FOREIGN KEY (`userId` )
    REFERENCES `moneybag`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`payment` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`payment` (
  `payId` INT NOT NULL ,
  `moneybagId` INT NOT NULL ,
  `moneyPerUser` INT NOT NULL ,
  PRIMARY KEY (`payId`) ,
  INDEX `fk_payment_moneybag1_idx` (`moneybagId` ASC) ,
  CONSTRAINT `fk_payment_moneybag1`
    FOREIGN KEY (`moneybagId` )
    REFERENCES `moneybag`.`moneybag` (`moneybagId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`payment_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`payment_has_user` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`payment_has_user` (
  `payment_payId` INT NOT NULL ,
  `user_userId` INT NOT NULL ,
  `is_payed` TINYINT NOT NULL ,
  PRIMARY KEY (`payment_payId`, `user_userId`) ,
  INDEX `fk_payment_has_user_user1_idx` (`user_userId` ASC) ,
  INDEX `fk_payment_has_user_payment1_idx` (`payment_payId` ASC) ,
  CONSTRAINT `fk_payment_has_user_payment1`
    FOREIGN KEY (`payment_payId` )
    REFERENCES `moneybag`.`payment` (`payId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_payment_has_user_user1`
    FOREIGN KEY (`user_userId` )
    REFERENCES `moneybag`.`user` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `moneybag` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
