select *
	from usuario;
    
select *
	from mascota;
    
delete
	from usuario
    where id = 5 and 6;
    
delete
	from mascota
    where id = 2;
    
drop table mascota;
drop table usuario;

CREATE TABLE `perros`.`usuario` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `correoElectronico` VARCHAR(45) NULL,
  `clave` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE `perros`.`mascota` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `apodo` VARCHAR(45) NULL,
  `raza` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  `idUsuario` INT UNSIGNED NULL,
  FOREIGN KEY (idUsuario) REFERENCES usuario(id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

