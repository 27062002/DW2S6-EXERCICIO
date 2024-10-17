CREATE TABLE `user` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50),
  `email` varchar(50),
  `telefone` varchar(50),
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
