CREATE TABLE `recurso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `reserva` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_inicio` DATE NOT NULL,
  `data_fim` DATE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `usuario_id` BIGINT(20) NOT NULL,
  `recurso_id` BIGINT(20) NOT NULL,
  FOREIGN KEY (recurso_id) REFERENCES recurso(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
