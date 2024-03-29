-- MySQL Script generated by MySQL Workbench
-- Thu Jan  5 21:01:04 2023
-- Model: New Model    Version: 1.0
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
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cities` (
  `id_city` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_city`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`states`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`states` (
  `id_state` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NULL,
  PRIMARY KEY (`id_state`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ziplocations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ziplocations` (
  `zipcode` INT NOT NULL,
  `id_city` INT NULL,
  `id_state` INT NULL,
  PRIMARY KEY (`zipcode`),
  INDEX `idCities_idx` (`id_city` ASC) VISIBLE,
  INDEX `idStates_idx` (`id_state` ASC) VISIBLE,
  CONSTRAINT `FK_ZIPLOCATIONS_idCities`
    FOREIGN KEY (`id_city`)
    REFERENCES `mydb`.`cities` (`id_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ZIPLOCATIONS_idStates`
    FOREIGN KEY (`id_state`)
    REFERENCES `mydb`.`states` (`id_state`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customers` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(25) NULL,
  `last_name` VARCHAR(25) NULL,
  `street` VARCHAR(45) NULL,
  `zipcode` INT NULL,
  PRIMARY KEY (`id_customer`),
  INDEX `FK_zipCode_idx` (`zipcode` ASC) VISIBLE,
  CONSTRAINT `FK_CUSTOMERS_zipCode`
    FOREIGN KEY (`zipcode`)
    REFERENCES `mydb`.`ziplocations` (`zipcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer_phonenumbers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer_phonenumbers` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `phone_type` VARCHAR(20) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_customer`, `phone_type`, `phone_number`),
  CONSTRAINT `FK_CUSTOMERPHONENUMBERS_idCustomers`
    FOREIGN KEY (`id_customer`)
    REFERENCES `mydb`.`customers` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`shops` (
  `id_shop` INT NOT NULL AUTO_INCREMENT,
  `zipcode` INT NOT NULL,
  PRIMARY KEY (`id_shop`, `zipcode`),
  INDEX `FK_zipCode_idx` (`zipcode` ASC) VISIBLE,
  CONSTRAINT `FK_SHOPS_zipCode`
    FOREIGN KEY (`zipcode`)
    REFERENCES `mydb`.`ziplocations` (`zipcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`manufacturers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`manufacturers` (
  `id_manufacturer` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `year` INT NULL,
  PRIMARY KEY (`id_manufacturer`, `name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`countries` (
  `id_country` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id_country`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`products` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `id_manufacturer` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NULL,
  `amount` INT NULL,
  `id_country` INT NULL,
  PRIMARY KEY (`id_manufacturer`, `name`),
  INDEX `FK_idManufacturers_idx` (`id_manufacturer` ASC) VISIBLE,
  UNIQUE INDEX `idProducts_UNIQUE` (`id_product` ASC) VISIBLE,
  INDEX `FK_idCountries_idx` (`id_country` ASC) VISIBLE,
  CONSTRAINT `FK_PRODUCTS_idManufacturers`
    FOREIGN KEY (`id_manufacturer`)
    REFERENCES `mydb`.`manufacturers` (`id_manufacturer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRODUCTS_idCountries`
    FOREIGN KEY (`id_country`)
    REFERENCES `mydb`.`countries` (`id_country`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `id_shop` INT NULL,
  `id_customer` INT NULL,
  `id_product` INT NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  PRIMARY KEY (`id_order`),
  INDEX `FK_idCustomers_idx` (`id_customer` ASC) VISIBLE,
  INDEX `FK_idShops_idx` (`id_shop` ASC) VISIBLE,
  INDEX `FK_idProducts_idx` (`id_product` ASC) VISIBLE,
  CONSTRAINT `FK_ORDERS_idCustomers`
    FOREIGN KEY (`id_customer`)
    REFERENCES `mydb`.`customers` (`id_customer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ORDERS_idShops`
    FOREIGN KEY (`id_shop`)
    REFERENCES `mydb`.`shops` (`id_shop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ORDERS_dProducts`
    FOREIGN KEY (`id_product`)
    REFERENCES `mydb`.`products` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employees` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `id_shop` INT NULL,
  `first_name` VARCHAR(25) NULL,
  `last_name` VARCHAR(25) NULL,
  `address` VARCHAR(25) NULL,
  `zipcode` INT NULL,
  PRIMARY KEY (`id_employee`),
  INDEX `FK_zipCode_idx` (`zipcode` ASC) VISIBLE,
  INDEX `FK_idShops_idx` (`id_shop` ASC) VISIBLE,
  CONSTRAINT `FK_EMPLOYEES_idShops`
    FOREIGN KEY (`id_shop`)
    REFERENCES `mydb`.`shops` (`id_shop`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_EMPLOYEES_zipCode`
    FOREIGN KEY (`zipcode`)
    REFERENCES `mydb`.`ziplocations` (`zipcode`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee_phonenumbers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee_phonenumbers` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `phone_type` VARCHAR(20) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_employee`, `phone_type`, `phone_number`),
  CONSTRAINT `FK_EMPLOYEEPHONENUMBERS_idEmployees`
    FOREIGN KEY (`id_employee`)
    REFERENCES `mydb`.`employees` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
