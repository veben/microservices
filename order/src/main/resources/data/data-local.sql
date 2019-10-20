TRUNCATE TABLE passed_order CASCADE;
TRUNCATE TABLE line_order CASCADE;

INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('ad5a7b50-8885-4311-bbb4-815e0251f344', 'Bike', 1);
INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('e819b7f9-87aa-4420-bf8e-01b24897cd53', 'Bag', 1);
INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('dc2ec561-0828-4be4-b650-ac105e3a9017', 'Tyre', 2);
INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('3b2daa22-000b-4ea6-9594-19820d4a2723', 'Beer', 10);

INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('f1d121c9-7d57-42cd-8dc5-7ce20cdd8ee3', 'Cheeseburger', 2);
INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('e45e7dab-280a-4955-85ca-f37e1ccc1150', 'Soda', 1);
INSERT INTO line_order (ID, PRODUCT, NUMBER)
VALUES ('7d99e1bc-46bf-4937-b5cd-c660b47cb68a', 'French fries', 1);

INSERT INTO passed_order (id, city, country, number, street, email, nom, prenom, date)
VALUES ('c5a659c3-5ba1-42bb-b1fb-b35d4f589f34',	'Clermont-Ferrand', 'France', 19, 'Boussingault', 'bernard@gmail.com', 'Vaillant', 'Bernard', '2017-03-12 14:18:58.000000');
INSERT INTO passed_order (id, city, country, number, street, email, nom, prenom, date)
VALUES ('ae4bfe14-b889-4c49-b35f-e89e39f9c31c',	'Paris', 'France', 46, 'Saint Antoine', 'jean-michel@gmail.com', 'Dupont', 'Jean-Michel', '2019-10-20 14:18:58.000000');


INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('c5a659c3-5ba1-42bb-b1fb-b35d4f589f34', 'ad5a7b50-8885-4311-bbb4-815e0251f344');
INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('c5a659c3-5ba1-42bb-b1fb-b35d4f589f34', 'e819b7f9-87aa-4420-bf8e-01b24897cd53');
INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('c5a659c3-5ba1-42bb-b1fb-b35d4f589f34', 'dc2ec561-0828-4be4-b650-ac105e3a9017');
INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('c5a659c3-5ba1-42bb-b1fb-b35d4f589f34', '3b2daa22-000b-4ea6-9594-19820d4a2723');

INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('ae4bfe14-b889-4c49-b35f-e89e39f9c31c', 'f1d121c9-7d57-42cd-8dc5-7ce20cdd8ee3');
INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('ae4bfe14-b889-4c49-b35f-e89e39f9c31c', 'e45e7dab-280a-4955-85ca-f37e1ccc1150');
INSERT INTO passed_order_line_orders (order_id, line_orders_id)
VALUES ('ae4bfe14-b889-4c49-b35f-e89e39f9c31c', '7d99e1bc-46bf-4937-b5cd-c660b47cb68a');