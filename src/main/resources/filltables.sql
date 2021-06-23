insert into task242db.users (name, lastName, username, password)
values ('Gekk', 'Finn' , 'ADMIN', /* password- ADMIN */ '$2y$12$udUeuYBEUq2QaC48C7Q/SeLBEB7E9297GY1ti7ivCIu0gccqchNs6');
insert into task242db.users (name, lastName, username, password)
values ('Tom', 'Soyer' , 'USER', /* password- USER*/ '$2y$12$/bEyI66Qp2lItCMsu97er.BnVcWLed0rzgFsSQYLWeCgh.claDbqO');
insert into task242db.users (name, lastName, username, password)
values ('Mark', 'TVEN' , 'MARK', /* password- USER*/ '$2y$12$/bEyI66Qp2lItCMsu97er.BnVcWLed0rzgFsSQYLWeCgh.claDbqO');
insert into task242db.roles (name) value ('ROLE_USER');
insert into task242db.roles (name) value ('ROLE_ADMIN');
insert into task242db.users_roles (user_id, role_id) values (1,1);
insert into task242db.users_roles (user_id, role_id) values (2,2);
insert into task242db.users_roles (user_id, role_id) values (3,1);
insert into task242db.users_roles (user_id, role_id) values (3,2);

