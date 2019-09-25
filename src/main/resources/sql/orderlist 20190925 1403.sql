--
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Установить режим SQL (SQL mode)
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

SET NAMES 'utf8';

DROP DATABASE IF EXISTS orderlist;

CREATE DATABASE IF NOT EXISTS orderlist
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE orderlist;

CREATE TABLE IF NOT EXISTS product (
  serial_number varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  description varchar(255) DEFAULT NULL,
  date_production date NOT NULL,
  id int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 4,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS orders (
  id int(11) NOT NULL AUTO_INCREMENT,
  name_customer varchar(50) NOT NULL,
  address_customer varchar(255) NOT NULL,
  sum_order int(11) NOT NULL,
  date_creation date NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 4,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS order_detail (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_product int(11) NOT NULL,
  quantity int(11) NOT NULL,
  id_order int(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 4,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE order_detail
ADD CONSTRAINT FK_order_detail_id_order FOREIGN KEY (id_order)
REFERENCES orders (id);

ALTER TABLE order_detail
ADD CONSTRAINT FK_order_detail_id_product FOREIGN KEY (id_product)
REFERENCES product (id);

INSERT INTO product VALUES
('234KJ56UY8', 'monitor', 'bla-bla-bla', '2019-09-04', 1),
('12FFD452H', 'refrigerator', 'bla-bla', '2019-09-11', 2),
('23IO78UY6', 'cooling chamber', 'used to store perishable foods', '2019-07-09', 3);

INSERT INTO orders VALUES
(1, 'Siemens AG', 'Germany,  Berlin', 123, '2019-09-24'),
(2, 'Lenovo Group Limited', 'Chine', 1302, '2019-08-14'),
(3, 'Samsung Group ', 'Republic of Korea, Suwon', 114, '2019-08-05');

INSERT INTO order_detail VALUES
(1, 1, 25, 1),
(2, 2, 41, 2),
(3, 3, 35, 3);

-- 
-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;