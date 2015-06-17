SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `moneybag` ;
CREATE SCHEMA IF NOT EXISTS `moneybag` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `moneybag` ;

-- -----------------------------------------------------
-- Table `moneybag`.`s`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`s` ;

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
    REFERENCES `moneybag`.`s` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`round`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`round` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`round` (
  `roundId` INT NOT NULL AUTO_INCREMENT ,
  `moneybagId` INT NOT NULL ,
  `roundAdminId` INT NOT NULL ,
  `createdDate` TIMESTAMP NOT NULL ,
  `total` INT NOT NULL ,
  `info` BLOB NOT NULL ,
  `nBang` INT NOT NULL ,
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
-- Table `moneybag`.`enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`enrollment` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`enrollment` (
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
    REFERENCES `moneybag`.`s` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`team` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`team` (
  `userId` INT NOT NULL ,
  `roundId` INT NOT NULL ,
  `check` INT NOT NULL ,
  `amount` INT NOT NULL ,
  PRIMARY KEY (`userId`, `roundId`) ,
  INDEX `fk_user_has_team_user1_idx` (`userId` ASC) ,
  INDEX `fk_user_has_team_round1_idx` (`roundId` ASC) ,
  CONSTRAINT `fk_user_has_team_user1`
    FOREIGN KEY (`userId` )
    REFERENCES `moneybag`.`s` (`userId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_team_round1`
    FOREIGN KEY (`roundId` )
    REFERENCES `moneybag`.`round` (`roundId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `moneybag` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
