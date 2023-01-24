DROP SCHEMA IF EXISTS `customer_food_directory`;

CREATE SCHEMA `customer_food_directory`;

use `customer_food_directory`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `customer_food`;

CREATE TABLE `customer_food` (
  `customer_id` int(11) NOT NULL,
  `food_id` int(11) NOT NULL,
  
  PRIMARY KEY (`customer_id`,`food_id`),
  
  KEY `FK_CUSTOMER_idx` (`customer_id`),
  
  CONSTRAINT `FK_FOOD_05` FOREIGN KEY (`food_id`) 
  REFERENCES `food` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_CUSTOMER` FOREIGN KEY (`customer_id`) 
  REFERENCES `customer` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

--
-- Data for table `food` and `customer`	
--

INSERT INTO `food` VALUES 
	(1,'Banana',10),
    (2,'Apple',10),
    (3,'Milk',12),
    (4,'Bread',13),
    (6,'Meat',9),
    (5,'Eggs',14);

INSERT INTO `customer` VALUES 
	(1,'John'),
    (2,'Fred'),
    (3,'Jennifer'),
    (4,'Jerry'),
    (5,'Rachel');
    
INSERT INTO `customer_food` VALUES 
	(1,1),
    (2,1),
    (3,1),
    (4,1),
    (1,2),
    (2,2),
    (3,2),
    (4,2),
    (5,2),
    (1,3),
    (2,3),
    (3,3),
    (1,4);
    

    
