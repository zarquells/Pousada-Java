create database pousada;

use pousada;

-- tabela de clientes
create table tbl_client(
	pk_IDclient		INT PRIMARY KEY AUTO_INCREMENT,
    name_client		VARCHAR(60)  NOT NULL,
    cpf_client 		CHAR(11)     NOT NULL,
    ddd_client		INT(2)		 NOT NULL,
    phone_client	INT(11)		 NOT NULL,
    adress_client	INT(8)		 NOT NULL,
    email_client	VARCHAR(120) NOT NULL,
    password_client VARCHAR(30)  NOT NULL
    
);

-- tabela de 30 quartos
create table tbl_room(
	pk_IDroom			INT PRIMARY KEY AUTO_INCREMENT,
    description_room	VARCHAR(120)  NOT NULL,
    price_room			DOUBLE(12, 2) NOT NULL
    
);

-- tabela de registros de entrada e saída, cancelamento, etc...
create table tbl_ticket(
	pk_IDticket		INT PRIMARY KEY AUTO_INCREMENT,
    fk_IDroom		INT  NOT NULL,
    fk_IDclient		INT  NOT NULL,
    checkin_ticket	DATE NOT NULL,
    checkout_ticket	DATE NOT NULL,
	
    FOREIGN KEY(fk_IDroom)   REFERENCES tbl_room  (pk_IDroom),
    FOREIGN KEY(fk_IDclient) REFERENCES tbl_client(pk_IDclient)
);

-- log de relatórios para novos registros
create table tbl_report(
	pk_IDreport		INT PRIMARY KEY AUTO_INCREMENT,
	fk_IDroom		INT,
    fk_IDclient		INT,
    new_checkin		DATE NOT NULL,
    new_checkout	DATE NOT NULL,
    date_time		DATETIME
    
);

DELIMITER //
create trigger report_update
after insert on tbl_ticket
for each row
begin
	INSERT INTO tbl_report(fk_IDroom, fk_IDclient, new_checkin, new_checkout, date_time)
    VALUES (NEW.fk_IDroom, NEW.fk_IDclient, NEW.checkin_ticket, NEW.checkout_ticket, NOW());
end;
// DELIMITER ;


-- log de relatórios para registrar cancelamentos 
create table tbl_report_cancel(
	pk_IDreport_cancel	INT PRIMARY KEY AUTO_INCREMENT,
	fk_IDroom			INT,
    fk_IDclient			INT,
    old_checkin			DATE NOT NULL,
    old_checkout		DATE NOT NULL,
    date_time			DATETIME
    
);

DELIMITER //
create trigger report_delete
after delete on tbl_ticket
for each row
begin
	INSERT INTO tbl_report_cancel(fk_IDroom, fk_IDclient, old_checkin, old_checkout, date_time)
    VALUES (OLD.fk_IDroom, OLD.fk_IDclient, OLD.checkin_ticket, OLD.checkout_ticket, NOW());
end;
// DELIMITER ;


-- query de registro de quartos
INSERT INTO tbl_room (description_room, price_room) VALUES
('Quarto Standard com vista para o mar', 180.00),
('Quarto Deluxe com varanda', 250.00),
('Suíte Executiva com jacuzzi', 400.00),
('Quarto Familiar com duas camas de solteiro', 220.00),
('Quarto Duplo com vista para o centro histórico', 160.00),
('Suíte Master com terraço privativo', 600.00),
('Quarto Econômico com banheiro privativo', 120.00),
('Quarto Triplo com vista para a cidade', 280.00),
('Suíte Presidencial com piscina privativa', 800.00),
('Quarto Standard com decoração regional', 150.00),
('Quarto Duplo com ar-condicionado', 170.00),
('Suíte Luxo com sala de estar', 500.00),
('Quarto Familiar com área de convivência', 300.00),
('Quarto Single com vista panorâmica', 130.00),
('Suíte Júnior com minibar', 350.00),
('Quarto Triplo com acesso para cadeirantes', 260.00),
('Quarto Deluxe com serviço de quarto 24 horas', 380.00),
('Suíte Premium com vista para o rio', 700.00),
('Quarto Standard com decoração contemporânea', 140.00),
('Quarto Duplo com café da manhã incluso', 200.00),
('Suíte Real com área de lazer privativa', 750.00),
('Quarto Familiar com espaço kids', 320.00),
('Quarto Single com escritório', 110.00),
('Suíte Presidencial com vista para o mar', 750.00),
('Quarto Triplo com banheira de hidromassagem', 380.00),
('Quarto Duplo com vista para o pátio interno', 190.00),
('Suíte Executiva com sala de reuniões', 450.00),
('Quarto Standard com varanda privativa', 170.00),
('Quarto Econômico com vista para o jardim', 110.00),
('Suíte Master com academia particular', 700.00);


INSERT INTO tbl_client (name_client, cpf_client, ddd_client, phone_client, adress_client, email_client, password_client) VALUES
('Ana Silva', 		52259381081, 11, 987654321, 12345678, 'ana.silva@email.com', 		'ana'   	  ),
('Carlos Oliveira', 06978051071, 21, 876543210, 23456789, 'carlos.oliveira@email.com',  'carlos'	  ),
('Maria Santos', 	45430565075, 31, 765432109, 34567890, 'maria.santos@email.com', 	'maria'		  ),
('João Pereira', 	68939786009, 41, 654321098, 45678901, 'joao.pereira@email.com', 	'joao'		  ),
('Juliana Lima', 	06584163083, 51, 543210987, 56789012, 'juliana.lima@email.com', 	'juliana'	  ),
('Pedro Souza', 	05486033087, 61, 432109876, 67890123, 'pedro.souza@email.com', 		'pedro' 	  ),
('Luciana Costa',   38812538070, 71, 321098765, 78901234, 'luciana.costa@email.com', 	'luciana'	  ),
('Felipe Oliveira', 23235995005, 81, 210987654, 89012345, 'felipe.oliveira@email.com', 	'felipe'      );