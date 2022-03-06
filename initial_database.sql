/*

*/


CREATE TABLE `rescate_de_patitas`.`tipo_documento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `desc` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

INSERT INTO `rescate_de_patitas`.`tipo_documento` (`name`, `desc`) VALUES ('DNI', 'Documento Nacional de Identidad');
INSERT INTO `rescate_de_patitas`.`tipo_documento` (`name`, `desc`) VALUES ('LC', 'Libreta Cívica');
INSERT INTO `rescate_de_patitas`.`tipo_documento` (`name`, `desc`) VALUES ('LE', 'Libreta de Enrolamiento');
INSERT INTO `rescate_de_patitas`.`tipo_documento` (`name`, `desc`) VALUES ('CE', 'Cédula de Identidad');
INSERT INTO `rescate_de_patitas`.`tipo_documento` (`name`, `desc`) VALUES ('PAS', 'Pasaporte');
