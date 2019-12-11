CREATE DATABASE  IF NOT EXISTS `nology_staff`;
USE `nology_staff`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES
	(1,'Ollie','Holden','ollie@holden.io'),
	(2,'Shea','Murphy','shea@murphy.com'),
	(3,'Craig','Livings','craig@livings.com'),
	(4,'Peter','Anstey','peter@anstey.com'),
	(5,'Jemima','Bodrington','jemima@bodrington.com'),
    (6,'Samuel','Pepys','sammy@pips.com');
