INSERT INTO USER(id, name, email, cpf, pis, password) VALUES(5, 'Gabriel', 'email@email.com.br', '000.000.000-00', '00.00000.00-0', '123456');
INSERT INTO ADDRESS(id, country, county, zip_code, street, street_number, extra) VALUES (6, 'Brazil', 'São Paulo', '00000-000', 'Minha rua', null, null);
INSERT INTO USER_ADDRESS(user_id, address_id) VALUES (5, 6)