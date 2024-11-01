CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	id_user BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_user, id_permission),
	FOREIGN KEY (id_user) REFERENCES user(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, name, email, telefone, password, cpf, active, logradouro, numero, complemento, bairro, cidade, estado, cep) 
values (3, 'Administrador', 'admin@ifsp.edu.br', '555555', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.',  '525.210.358-58', '1', 'aaaa', '11111', '11111', '111', '1111', '1111', 'ooooooo');

-- user
INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_REMOVE_USER');
INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');

-- activity
INSERT INTO permission (id, description) values (4, 'ROLE_REGISTER_SERVICO');
INSERT INTO permission (id, description) values (5, 'ROLE_REMOVE_SERVICO');
INSERT INTO permission (id, description) values (6, 'ROLE_SEARCH_SERVICO');

-- admin
INSERT INTO user_permission (id_user, id_permission) values (3, 1);
INSERT INTO user_permission (id_user, id_permission) values (3, 2);
INSERT INTO user_permission (id_user, id_permission) values (3, 3);
INSERT INTO user_permission (id_user, id_permission) values (3, 4);
INSERT INTO user_permission (id_user, id_permission) values (3, 5);
INSERT INTO user_permission (id_user, id_permission) values (3, 6);

