DROP TABLE `alkfejl`.`rec_ing`;
DROP TABLE `alkfejl`.`recipes`;
DROP TABLE `alkfejl`.`ingredients`;
DROP TABLE `alkfejl`.`users`;

CREATE OR REPLACE SCHEMA `alkfejl` ;

CREATE OR REPLACE TABLE `alkfejl`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

CREATE OR REPLACE TABLE `alkfejl`.`recipes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `directions` VARCHAR(1000) NOT NULL,
  `preptime` TIME NULL,
  `cooktime` TIME NULL,
  `owner_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `owner_idx` (`owner_id` ASC),
  CONSTRAINT `owner_id`
    FOREIGN KEY (`owner_id`)
    REFERENCES `alkfejl`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE OR REPLACE TABLE `alkfejl`.`ingredients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC));

CREATE OR REPLACE TABLE `alkfejl`.`rec_ing` (
  `rec_id` INT NOT NULL,
  `ing_id` INT NOT NULL,
  PRIMARY KEY (`rec_id`, `ing_id`),
  INDEX `ing_id_idx` (`ing_id` ASC),
  CONSTRAINT `rec_id`
    FOREIGN KEY (`rec_id`)
    REFERENCES `alkfejl`.`recipes` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `ing_id`
    FOREIGN KEY (`ing_id`)
    REFERENCES `alkfejl`.`ingredients` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

