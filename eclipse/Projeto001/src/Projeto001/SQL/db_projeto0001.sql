-- MySQL Script generated by MySQL Workbench
-- Thu Jul 26 14:36:45 2018
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
-- Table `mydb`.`tb_cadastro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_cadastro` (
  `id_tb_cadastro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `sobrenome` VARCHAR(100) NULL,
  `idade` INT NULL,
  `data_nascimento` DATE NULL,
  `sexo` CHAR(2) NULL,
  `cpf` VARCHAR(45) NULL,
  `codigo_cliente` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tb_cadastro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_login` (
  `id_tb_login` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tb_login`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;