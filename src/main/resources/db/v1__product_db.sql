-- testdb.product_tbl definition

CREATE TABLE `product_tbl` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO testdb.product_tbl
(id, name, price, quantity)
VALUES(1, 'product1', 1.0, 0);

INSERT INTO testdb.product_tbl
(id, name, price, quantity)
VALUES(2, 'product1', 2.0, 0);

INSERT INTO testdb.product_tbl
(id, name, price, quantity)
VALUES(3, 'product1', 3.0, 0);
