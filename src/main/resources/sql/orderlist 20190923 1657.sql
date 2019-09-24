
-- Отключение внешних ключей
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

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
  descriprion varchar(255) DEFAULT NULL,
  date_production date NOT NULL,
  PRIMARY KEY (serial_number)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci,
COMMENT = 'product description ';

ALTER TABLE product
ADD UNIQUE INDEX serial_number (serial_number);

CREATE TABLE IF NOT EXISTS `order` (
  id int(11) NOT NULL AUTO_INCREMENT,
  name_customer varchar(50) NOT NULL,
  address_customer varchar(255) NOT NULL,
  sum_order int(11) NOT NULL,
  date_creation date NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS order_details (
  id int(11) NOT NULL AUTO_INCREMENT,
  serial_number varchar(255) NOT NULL,
  quantity int(11) NOT NULL,
  id_order int(11) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

ALTER TABLE order_details
ADD UNIQUE INDEX id_product (id_order);

ALTER TABLE order_details
ADD UNIQUE INDEX serial_number (serial_number);

ALTER TABLE order_details
ADD CONSTRAINT FK_order_details_to_order FOREIGN KEY (id_order)
REFERENCES `order` (id);

ALTER TABLE order_details
ADD CONSTRAINT FK_order_details_to_product FOREIGN KEY (serial_number)
REFERENCES product (serial_number);

-- Восстановить предыдущий режим SQL (SQL mode)
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- Включение внешних ключей
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;