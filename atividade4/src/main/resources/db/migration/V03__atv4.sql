CREATE TABLE `servico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(120) NOT NULL,
  `data_emissao` date NOT NULL,
  `data_finalizacao` date NOT NULL,
  `valor` DOUBLE NOT NULL,
  `status` varchar(30) NOT NULL,
  `observacoes` varchar(120) NOT NULL,
  pagamento_id BIGINT(20) NOT NULL,
	FOREIGN KEY (pagamento_id) REFERENCES pagamento(id),
  user_id BIGINT(20) NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user(id),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;