
insert into tipo_insumo (id, descricao) values (1, 'Veículo');
insert into tipo_insumo (id, descricao) values (2, 'Máquina');
insert into tipo_insumo (id, descricao) values (3, 'Instrumento topografia');
insert into tipo_insumo (id, descricao) values (4, 'Instrumento geotecnia');
insert into tipo_insumo (id, descricao) values (5, 'Equipamento segurança');
insert into tipo_insumo (id, descricao) values (6, 'Tecnologia da informação');

insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (1, 'Escavadeira', 1);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (2, 'Retroescavadeira', 1);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (3, 'Caminhão',1);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (4, 'Trator',1);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (5, 'Carro',1);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (6, 'Britador de impacto',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (7, 'Britador mandíbula',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (8, 'Peneira vibratória',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (9, 'Peneira desaguadora',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (10,'Triturador',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (11, 'Moinho de martelo',2);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (12, 'Nivelador óptico',3);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (13, 'Teodolito eletrônico',3);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (14, 'Baliza topográfica',3);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (15, 'Crackmeter',4);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (16, 'Sismógrafo',4);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (17, 'Capacete',5);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (18, 'Óculos de proteção',5);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (19, 'Protetor auditivo',5);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (20, 'Luvas anticorte',5);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (21, 'Computador', 6);
insert into sub_tipo_insumo (id,descricao, tipo_insumo_id) values (22, 'Software', 6);


insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (1,'Jcb','4CXECO', 1);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (2,'Hyundai','R220LC-9S',2);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (3,'Volkswagen','Constellation',3); 
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (4,'Komatsu','D575A',4); 
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (5,'Toyota','Hilux',5);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (6,'Ford','Ranger',5); 
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (7,'Hazemag','Hpi-H',6);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (8,'Metso', 'C130',7);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (9,'Mecmining do Brasil', 'MMB-3X1200',8);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (10,'Inbras','RS-24/01W',9);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (11,'Jiuchang','4PGS0809PT(Y)',10);    
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (12,'RG MAQ','RGM75C',11);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (13,'Xpex','AT-32',12);  
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (14,'Kolida','Kt-02',13);   
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (15,'Geogex','GX-BG33',14);
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (16,'Geokon','4420',15);
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (17,'Dell','Inspiron',21);
insert into tipo_marca_modelo (id, marca, modelo, sub_tipo_insumo_id) values (18,'Autocad','1.0',22);

insert into insumo (id, tipo_insumo_id, sub_tipo_insumo_id, tipo_marca_modelo_id, data_cadastro, quantidade, link_informacoes_tecnicas_fornecedor) values (70,1,1,1, now(), 1,'http://www.google.com');
insert into insumo (id, tipo_insumo_id, sub_tipo_insumo_id, tipo_marca_modelo_id, data_cadastro, quantidade, link_informacoes_tecnicas_fornecedor) values (80,2,6,7, now(), 1,'http://www.gmail.com');
