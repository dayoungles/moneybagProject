SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `moneybag` ;
CREATE SCHEMA IF NOT EXISTS `moneybag` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `moneybag` ;

-- -----------------------------------------------------
-- Table `moneybag`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`user` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(45) NULL ,
  `pw` VARCHAR(45) NULL ,
  `name` VARCHAR(45) NULL, 
  PRIMARY KEY (`idUser`) )
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `moneybag`.`moneybag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`moneybag` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`moneybag` (
  `idmoneybag` INT NOT NULL AUTO_INCREMENT ,
  `admin` INT NOT NULL ,
  `createdDate` TIMESTAMP NOT NULL ,
  `account` VARCHAR(45) NOT NULL ,
  `info` BLOB NULL ,
  `picture` BLOB NULL ,
  PRIMARY KEY (`idmoneybag`) ,
  INDEX `fk_moneybag_user1_idx` (`admin` ASC) ,
  CONSTRAINT `fk_moneybag_user1`
    FOREIGN KEY (`admin` )
    REFERENCES `moneybag`.`user` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`round`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`round` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`round` (
  `idRound` INT NOT NULL AUTO_INCREMENT ,
  `moneybag_idmoneybag` INT NOT NULL ,
  `createdDate` TIMESTAMP NOT NULL ,
  `total` INT NULL ,
  `info` BLOB NULL ,
  `nBang` INT NULL ,
  PRIMARY KEY (`idRound`, `moneybag_idmoneybag`) ,
  INDEX `fk_round_moneybag1_idx` (`moneybag_idmoneybag` ASC) ,
  CONSTRAINT `fk_round_moneybag1`
    FOREIGN KEY (`moneybag_idmoneybag` )
    REFERENCES `moneybag`.`moneybag` (`idmoneybag` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`enrollment` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`enrollment` (
  `moneybag_idmoneybag` INT NOT NULL ,
  `user_idUser` INT NOT NULL ,
  PRIMARY KEY (`moneybag_idmoneybag`, `user_idUser`) ,
  INDEX `fk_moneybag_has_user_user1_idx` (`user_idUser` ASC) ,
  INDEX `fk_moneybag_has_user_moneybag1_idx` (`moneybag_idmoneybag` ASC) ,
  CONSTRAINT `fk_moneybag_has_user_moneybag1`
    FOREIGN KEY (`moneybag_idmoneybag` )
    REFERENCES `moneybag`.`moneybag` (`idmoneybag` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_moneybag_has_user_user1`
    FOREIGN KEY (`user_idUser` )
    REFERENCES `moneybag`.`user` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moneybag`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `moneybag`.`team` ;

CREATE  TABLE IF NOT EXISTS `moneybag`.`team` (
  `user_idUser` INT NOT NULL ,
  `check` INT NOT NULL ,
  `amount` INT NOT NULL ,
  `round_idRound` INT NOT NULL ,
  `round_moneybag_idmoneybag` INT NOT NULL ,
  PRIMARY KEY (`user_idUser`, `round_idRound`, `round_moneybag_idmoneybag`) ,
  INDEX `fk_user_has_team_user1_idx` (`user_idUser` ASC) ,
  INDEX `fk_user_has_team_round1_idx` (`round_idRound` ASC, `round_moneybag_idmoneybag` ASC) ,
  CONSTRAINT `fk_user_has_team_user1`
    FOREIGN KEY (`user_idUser` )
    REFERENCES `moneybag`.`user` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_team_round1`
    FOREIGN KEY (`round_idRound` , `round_moneybag_idmoneybag` )
    REFERENCES `moneybag`.`round` (`idRound` , `moneybag_idmoneybag` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `moneybag` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into user (email, pw, name) values( "test@test", "dfd", "dayg");
