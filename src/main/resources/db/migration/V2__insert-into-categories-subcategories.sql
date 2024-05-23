INSERT INTO categories (name) VALUES ('Tecnologia');
INSERT INTO categories (name) VALUES ('Esportes');

INSERT INTO subcategories (name) VALUES ('Programação');
INSERT INTO subcategories (name) VALUES ('Banco de Dadoss');
INSERT INTO subcategories (name) VALUES ('Futebol');
INSERT INTO subcategories (name) VALUES ('Tênis');

INSERT INTO category_subcategory (category_id, subcategory_id) VALUES (1, 1);
INSERT INTO category_subcategory (category_id, subcategory_id) VALUES (1, 2);
INSERT INTO category_subcategory (category_id, subcategory_id) VALUES (2, 3);
INSERT INTO category_subcategory (category_id, subcategory_id) VALUES (2, 4);
