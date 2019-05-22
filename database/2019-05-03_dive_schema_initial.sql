CREATE TABLE `dive_schema`.`dives` (
  `d_id` INT NOT NULL AUTO_INCREMENT,
  `d_date` DATETIME NOT NULL,
  `d_location` VARCHAR(45) NOT NULL,
  `d_duration_in_minutes` DECIMAL(2,0) NULL,
  `d_depth_in_meters` DECIMAL(2,0) NULL,
  `d_water_condition` VARCHAR(45) NULL,
  `d_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`d_id`));

CREATE TABLE `dive_schema`.`role` (
  `r_id` INT NOT NULL AUTO_INCREMENT,
  `r_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`r_id`));

CREATE TABLE `dive_schema`.`token` (
  `t_id` INT(11) NOT NULL AUTO_INCREMENT,
  `t_value` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`));

CREATE TABLE `dive_schema`.`user` (
  `u_id` INT(11) NOT NULL AUTO_INCREMENT,
  `u_name` VARCHAR(45) NOT NULL,
  `u_password` VARCHAR(45) NOT NULL,
  `u_active` TINYINT(4) NOT NULL,
  PRIMARY KEY (`u_id`));

CREATE TABLE `dive_schema`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `u_id` INT(11) NOT NULL,
  `r_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`));      