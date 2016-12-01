-- MySQL Script generated by MySQL Workbench
-- jeu. 01 déc. 2016 22:35:35 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`manager` (
  `idmanager` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmanager`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `telephone_UNIQUE` (`telephone` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`adress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adress` (
  `idadress` INT NOT NULL,
  `voie` VARCHAR(45) NULL,
  `zipcode` INT NULL,
  PRIMARY KEY (`idadress`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buisness_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`buisness_type` (
  `idtype` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtype`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buisness`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`buisness` (
  `idbuisness` INT NOT NULL,
  `idmanager` INT NULL,
  `idadress` INT NULL,
  `name` VARCHAR(45) NOT NULL,
  `confirmation` TINYINT(1) NOT NULL,
  `description` VARCHAR(5000) NULL,
  `buisness_type_idtype` INT NOT NULL,
  PRIMARY KEY (`idbuisness`),
  INDEX `fk_salon_manager_idx` (`idmanager` ASC),
  INDEX `fk_salon_adress1_idx` (`idadress` ASC),
  INDEX `fk_buisness_buisness_type1_idx` (`buisness_type_idtype` ASC),
  CONSTRAINT `fk_salon_manager`
    FOREIGN KEY (`idmanager`)
    REFERENCES `mydb`.`manager` (`idmanager`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salon_adress1`
    FOREIGN KEY (`idadress`)
    REFERENCES `mydb`.`adress` (`idadress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buisness_buisness_type1`
    FOREIGN KEY (`buisness_type_idtype`)
    REFERENCES `mydb`.`buisness_type` (`idtype`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`client` (
  `idclient` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `idhome_address` INT NULL,
  `idwork_address` INT NULL,
  PRIMARY KEY (`idclient`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `telephone_UNIQUE` (`telephone` ASC),
  INDEX `fk_client_adress1_idx` (`idhome_address` ASC),
  INDEX `fk_client_adress2_idx` (`idwork_address` ASC),
  CONSTRAINT `fk_client_adress1`
    FOREIGN KEY (`idhome_address`)
    REFERENCES `mydb`.`adress` (`idadress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_adress2`
    FOREIGN KEY (`idwork_address`)
    REFERENCES `mydb`.`adress` (`idadress`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tag` (
  `idtag` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idtag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`salon_has_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`salon_has_tag` (
  `idsalon` INT NOT NULL,
  `idtag` INT NOT NULL,
  PRIMARY KEY (`idsalon`, `idtag`),
  INDEX `fk_salon_has_tag_tag1_idx` (`idtag` ASC),
  INDEX `fk_salon_has_tag_salon1_idx` (`idsalon` ASC),
  CONSTRAINT `fk_salon_has_tag_salon1`
    FOREIGN KEY (`idsalon`)
    REFERENCES `mydb`.`buisness` (`idbuisness`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salon_has_tag_tag1`
    FOREIGN KEY (`idtag`)
    REFERENCES `mydb`.`tag` (`idtag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`service` (
  `idservice` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idservice`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`attachment` (
  `idattachment` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `url` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idattachment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`avis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`avis` (
  `idavis` INT NOT NULL,
  `idclient` INT NOT NULL,
  `salon_idsalon` INT NOT NULL,
  `rating` INT NOT NULL,
  `comment` VARCHAR(45) NULL,
  PRIMARY KEY (`idavis`),
  INDEX `fk_avis_client1_idx` (`idclient` ASC),
  INDEX `fk_avis_salon2_idx` (`salon_idsalon` ASC),
  CONSTRAINT `fk_avis_client1`
    FOREIGN KEY (`idclient`)
    REFERENCES `mydb`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avis_salon2`
    FOREIGN KEY (`salon_idsalon`)
    REFERENCES `mydb`.`buisness` (`idbuisness`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservation_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservation_client` (
  `idreservation_client` INT NOT NULL,
  `idclient` INT NOT NULL,
  `date` DATETIME NOT NULL,
  `create_datetime` DATETIME NOT NULL,
  `confirm_datetime` DATETIME NULL,
  `annulation_datetime` DATETIME NULL,
  `note` VARCHAR(2000) NULL,
  PRIMARY KEY (`idreservation_client`),
  INDEX `fk_reservation_client1_idx` (`idclient` ASC),
  CONSTRAINT `fk_reservation_client1`
    FOREIGN KEY (`idclient`)
    REFERENCES `mydb`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buisness_has_attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`buisness_has_attachment` (
  `idbuisness` INT NOT NULL,
  `idattachment` INT NOT NULL,
  PRIMARY KEY (`idbuisness`, `idattachment`),
  INDEX `fk_salon_has_attachment_attachment1_idx` (`idattachment` ASC),
  INDEX `fk_salon_has_attachment_salon1_idx` (`idbuisness` ASC),
  CONSTRAINT `fk_salon_has_attachment_salon1`
    FOREIGN KEY (`idbuisness`)
    REFERENCES `mydb`.`buisness` (`idbuisness`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_salon_has_attachment_attachment1`
    FOREIGN KEY (`idattachment`)
    REFERENCES `mydb`.`attachment` (`idattachment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`client_has_attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`client_has_attachment` (
  `client_idclient` INT NOT NULL,
  `attachment_idattachment` INT NOT NULL,
  PRIMARY KEY (`client_idclient`, `attachment_idattachment`),
  INDEX `fk_client_has_attachment_attachment1_idx` (`attachment_idattachment` ASC),
  INDEX `fk_client_has_attachment_client1_idx` (`client_idclient` ASC),
  CONSTRAINT `fk_client_has_attachment_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `mydb`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_attachment_attachment1`
    FOREIGN KEY (`attachment_idattachment`)
    REFERENCES `mydb`.`attachment` (`idattachment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`notification` (
  `idnotification` INT NOT NULL,
  `not_read` TINYINT(1) NOT NULL,
  `action` VARCHAR(45) NOT NULL,
  `idreservation` INT NOT NULL,
  `client_idclient` INT NOT NULL,
  PRIMARY KEY (`idnotification`),
  INDEX `fk_notification_reservation1_idx` (`idreservation` ASC),
  INDEX `fk_notification_client1_idx` (`client_idclient` ASC),
  CONSTRAINT `fk_notification_reservation1`
    FOREIGN KEY (`idreservation`)
    REFERENCES `mydb`.`reservation_client` (`idreservation_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_client1`
    FOREIGN KEY (`client_idclient`)
    REFERENCES `mydb`.`client` (`idclient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`hairdresser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hairdresser` (
  `idhairdresser` INT NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `profile_picture` INT NULL,
  `idbuisness` INT NOT NULL,
  PRIMARY KEY (`idhairdresser`),
  INDEX `fk_hairdresser_attachment1_idx` (`profile_picture` ASC),
  INDEX `fk_hairdresser_salon1_idx` (`idbuisness` ASC),
  CONSTRAINT `fk_hairdresser_attachment1`
    FOREIGN KEY (`profile_picture`)
    REFERENCES `mydb`.`attachment` (`idattachment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hairdresser_salon1`
    FOREIGN KEY (`idbuisness`)
    REFERENCES `mydb`.`buisness` (`idbuisness`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservation_pro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservation_pro` (
  `idreservation_pro` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `startdate` DATETIME NOT NULL,
  `enddate` DATETIME NOT NULL,
  `numero` VARCHAR(45) NULL,
  `note` VARCHAR(2000) NULL,
  `hairdresser_idhairdresser` INT NOT NULL,
  PRIMARY KEY (`idreservation_pro`),
  INDEX `fk_reservation_pro_hairdresser1_idx` (`hairdresser_idhairdresser` ASC),
  CONSTRAINT `fk_reservation_pro_hairdresser1`
    FOREIGN KEY (`hairdresser_idhairdresser`)
    REFERENCES `mydb`.`hairdresser` (`idhairdresser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedule` (
  `idschedule` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NOT NULL,
  `hairdresser_idhairdresser` INT NOT NULL,
  PRIMARY KEY (`idschedule`),
  INDEX `fk_schedule_hairdresser1_idx` (`hairdresser_idhairdresser` ASC),
  CONSTRAINT `fk_schedule_hairdresser1`
    FOREIGN KEY (`hairdresser_idhairdresser`)
    REFERENCES `mydb`.`hairdresser` (`idhairdresser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule_day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedule_day` (
  `idday` INT NOT NULL,
  `day` INT NOT NULL,
  `schedule_idschedule` INT NOT NULL,
  PRIMARY KEY (`idday`),
  INDEX `fk_schedule_day_schedule1_idx` (`schedule_idschedule` ASC),
  CONSTRAINT `fk_schedule_day_schedule1`
    FOREIGN KEY (`schedule_idschedule`)
    REFERENCES `mydb`.`schedule` (`idschedule`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`schedule_time`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`schedule_time` (
  `idschedule_time` INT NOT NULL,
  `start` TIME NOT NULL,
  `end` TIME NOT NULL,
  `schedule_day_idday` INT NOT NULL,
  PRIMARY KEY (`idschedule_time`),
  INDEX `fk_schedule_time_schedule_day1_idx` (`schedule_day_idday` ASC),
  CONSTRAINT `fk_schedule_time_schedule_day1`
    FOREIGN KEY (`schedule_day_idday`)
    REFERENCES `mydb`.`schedule_day` (`idday`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`break`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`break` (
  `idbreak` INT NOT NULL,
  `startdate` DATETIME NOT NULL,
  `enddate` DATETIME NOT NULL,
  `note` VARCHAR(45) NULL,
  `hairdresser_idhairdresser` INT NOT NULL,
  PRIMARY KEY (`idbreak`),
  INDEX `fk_break_hairdresser1_idx` (`hairdresser_idhairdresser` ASC),
  CONSTRAINT `fk_break_hairdresser1`
    FOREIGN KEY (`hairdresser_idhairdresser`)
    REFERENCES `mydb`.`hairdresser` (`idhairdresser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buisness_has_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`buisness_has_service` (
  `buisness_idbuisness` INT NOT NULL,
  `service_idservice` INT NOT NULL,
  `duration_minutes` INT NOT NULL,
  `price` INT NOT NULL,
  `note` VARCHAR(2000) NULL,
  PRIMARY KEY (`buisness_idbuisness`, `service_idservice`),
  INDEX `fk_buisness_has_service_service1_idx` (`service_idservice` ASC),
  INDEX `fk_buisness_has_service_buisness1_idx` (`buisness_idbuisness` ASC),
  CONSTRAINT `fk_buisness_has_service_buisness1`
    FOREIGN KEY (`buisness_idbuisness`)
    REFERENCES `mydb`.`buisness` (`idbuisness`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buisness_has_service_service1`
    FOREIGN KEY (`service_idservice`)
    REFERENCES `mydb`.`service` (`idservice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`buisness_has_service_has_attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`buisness_has_service_has_attachment` (
  `buisness_has_service_buisness_idbuisness` INT NOT NULL,
  `buisness_has_service_service_idservice` INT NOT NULL,
  `attachment_idattachment` INT NOT NULL,
  PRIMARY KEY (`buisness_has_service_buisness_idbuisness`, `buisness_has_service_service_idservice`, `attachment_idattachment`),
  INDEX `fk_buisness_has_service_has_attachment_attachment1_idx` (`attachment_idattachment` ASC),
  INDEX `fk_buisness_has_service_has_attachment_buisness_has_service_idx` (`buisness_has_service_buisness_idbuisness` ASC, `buisness_has_service_service_idservice` ASC),
  CONSTRAINT `fk_buisness_has_service_has_attachment_buisness_has_service1`
    FOREIGN KEY (`buisness_has_service_buisness_idbuisness` , `buisness_has_service_service_idservice`)
    REFERENCES `mydb`.`buisness_has_service` (`buisness_idbuisness` , `service_idservice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buisness_has_service_has_attachment_attachment1`
    FOREIGN KEY (`attachment_idattachment`)
    REFERENCES `mydb`.`attachment` (`idattachment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`hairdresser_has_buisness_has_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hairdresser_has_buisness_has_service` (
  `idhairdresser` INT NOT NULL,
  `idbuisness` INT NOT NULL,
  `idservice` INT NOT NULL,
  PRIMARY KEY (`idhairdresser`, `idbuisness`, `idservice`),
  INDEX `fk_hairdresser_has_buisness_has_service_buisness_has_servic_idx` (`idbuisness` ASC, `idservice` ASC),
  INDEX `fk_hairdresser_has_buisness_has_service_hairdresser1_idx` (`idhairdresser` ASC),
  CONSTRAINT `fk_hairdresser_has_buisness_has_service_hairdresser1`
    FOREIGN KEY (`idhairdresser`)
    REFERENCES `mydb`.`hairdresser` (`idhairdresser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hairdresser_has_buisness_has_service_buisness_has_service1`
    FOREIGN KEY (`idbuisness` , `idservice`)
    REFERENCES `mydb`.`buisness_has_service` (`buisness_idbuisness` , `service_idservice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reservation_client_has_hairdresser_has_buisness_has_service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reservation_client_has_hairdresser_has_buisness_has_service` (
  `idreservation_client` INT NOT NULL,
  `idhairdresser` INT NOT NULL,
  `idbuisness` INT NOT NULL,
  `idservice` INT NOT NULL,
  PRIMARY KEY (`idreservation_client`, `idhairdresser`, `idbuisness`, `idservice`),
  INDEX `fk_reservation_client_has_hairdresser_has_buisness_has_serv_idx` (`idhairdresser` ASC, `idbuisness` ASC, `idservice` ASC),
  INDEX `fk_reservation_client_has_hairdresser_has_buisness_has_serv_idx1` (`idreservation_client` ASC),
  CONSTRAINT `fk_reservation_client_has_hairdresser_has_buisness_has_servic1`
    FOREIGN KEY (`idreservation_client`)
    REFERENCES `mydb`.`reservation_client` (`idreservation_client`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservation_client_has_hairdresser_has_buisness_has_servic2`
    FOREIGN KEY (`idhairdresser` , `idbuisness` , `idservice`)
    REFERENCES `mydb`.`hairdresser_has_buisness_has_service` (`idhairdresser` , `idbuisness` , `idservice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
