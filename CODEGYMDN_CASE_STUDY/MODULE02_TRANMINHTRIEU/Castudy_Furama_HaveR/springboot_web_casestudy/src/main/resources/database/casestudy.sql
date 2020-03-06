-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: db_furama_resort
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accompanied_services`
--

DROP TABLE IF EXISTS `accompanied_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accompanied_services` (
  `accompanied_service_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `accompanied_service_name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `accompanied_service_status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`accompanied_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accompanied_services`
--

LOCK TABLES `accompanied_services` WRITE;
/*!40000 ALTER TABLE `accompanied_services` DISABLE KEYS */;
INSERT INTO `accompanied_services` VALUES (1,'Massage',500000,'1','good'),(2,'Car',400000,'1','good'),(3,'foods',150000,'2','good'),(4,'drinks',100000,'2','good'),(5,'Karaoke',5000000,'5','good');
/*!40000 ALTER TABLE `accompanied_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_details`
--

DROP TABLE IF EXISTS `contract_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_details` (
  `contract_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `contract_id` int(10) unsigned DEFAULT NULL,
  `accompanied_service_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`contract_detail_id`),
  KEY `fk_contract` (`contract_id`),
  KEY `fk_accompanied_service` (`accompanied_service_id`),
  CONSTRAINT `fk_accompanied_service` FOREIGN KEY (`accompanied_service_id`) REFERENCES `accompanied_services` (`accompanied_service_id`),
  CONSTRAINT `fk_contract` FOREIGN KEY (`contract_id`) REFERENCES `contracts` (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_details`
--

LOCK TABLES `contract_details` WRITE;
/*!40000 ALTER TABLE `contract_details` DISABLE KEYS */;
INSERT INTO `contract_details` VALUES (1,3,1,3),(2,4,6,3),(3,2,3,2),(4,5,4,4),(5,2,1,1),(6,2,2,1),(7,2,7,2),(8,1,7,3),(9,2,8,1);
/*!40000 ALTER TABLE `contract_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contracts`
--

DROP TABLE IF EXISTS `contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contracts` (
  `contract_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `contract_date` date DEFAULT NULL,
  `contract_date_end` date DEFAULT NULL,
  `deposit` decimal(18,2) DEFAULT NULL,
  `total` decimal(18,2) DEFAULT NULL,
  `employee_id` int(10) unsigned DEFAULT NULL,
  `customer_id` int(10) unsigned DEFAULT NULL,
  `service_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `fk_employee` (`employee_id`),
  KEY `fk_customer` (`customer_id`),
  KEY `fk_service` (`service_id`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contracts`
--

LOCK TABLES `contracts` WRITE;
/*!40000 ALTER TABLE `contracts` DISABLE KEYS */;
INSERT INTO `contracts` VALUES (1,'2019-09-24','2019-10-01',5000000.00,25000000.00,1,3,1),(2,'2019-10-24','2019-10-30',2000000.00,12000000.00,1,2,1),(3,'2019-01-31','2019-02-24',1000000.00,9000000.00,3,3,1),(4,'2015-05-12','2019-02-20',2000000.00,15000000.00,2,6,1),(5,'2019-04-12','2019-04-15',1000000.00,12000000.00,5,4,5),(6,'2016-01-12','2019-01-15',1000000.00,13000000.00,1,1,2),(7,'2019-06-20','2019-03-01',2000000.00,14000000.00,7,7,8),(8,'2020-02-06','2020-02-29',120.00,200.00,1,1,1),(9,'2020-03-20','2020-03-21',120.00,1200.00,1,1,1),(10,'2020-03-19','2020-03-12',-12.00,-12.00,1,1,1),(11,NULL,NULL,NULL,NULL,1,1,1),(12,NULL,NULL,NULL,NULL,1,1,1),(13,NULL,NULL,NULL,NULL,1,1,1),(14,NULL,NULL,NULL,NULL,1,1,1),(15,NULL,NULL,NULL,NULL,1,1,1),(16,NULL,NULL,NULL,NULL,1,1,1),(17,NULL,NULL,NULL,NULL,1,1,1),(18,NULL,NULL,NULL,NULL,1,1,1),(19,NULL,NULL,NULL,1200.00,1,1,1),(20,'2020-03-01','2020-03-21',120.00,1200.00,1,1,1),(21,'2020-03-13','2020-03-14',NULL,NULL,1,1,1),(22,'2020-03-21','2020-03-28',12.00,14.00,1,1,1),(23,'2020-03-20',NULL,12.00,12.00,1,1,1),(24,'2020-03-28','2020-03-01',NULL,NULL,1,1,1),(25,'2020-03-12',NULL,NULL,NULL,1,1,1);
/*!40000 ALTER TABLE `contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `id_card` varchar(45) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type_customer_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_type_customer` (`type_customer_id`),
  CONSTRAINT `fk_type_customer` FOREIGN KEY (`type_customer_id`) REFERENCES `type_customers` (`type_customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Đoàn D','1970-03-15','098765432','023567344','zxcs@gmail.com','Quảng Trị',1),(2,'B','1968-09-15','098712322','023567865','zxwqe232cs@gmail.com','Đà Nẵng',1),(3,'C','1990-07-15','06755432','023567432','zx23cs@gmail.com','Quảng Trị',3),(4,'Doàn C','1969-06-15','098734534','023567423','5asd6@gmail.com','Quảng Trị',5),(5,'E','1983-05-15','09886652','023549676','zxmkucs@gmail.com','Đà Nẵng',2),(6,'Hoàng Văn C','1985-11-25','094355432','023565624','zxqwecs@gmail.com','Vinh',1),(7,'Trần B','1995-04-25','098765232','023567631','zxcs@gmail.com','Quảng Ngãi',1),(8,'Doàn A','1993-06-24','098765412','023567231','fdsd@gmail.com','Quảng Trị',2),(9,'Đoàn B','1982-01-23','098767332','023847324','zghghgxcs@gmail.com','Đà Nẵng',1),(10,'Lê Văn K','1965-02-04','097123132','098367344','zxwewcs@gmail.com','Quảng Ngãi',2),(12,'Triều Trần ','2020-05-12','42156458','12345678','trieutm1205@gmail.com','DaNang',2),(13,'Hoàng Long Long','2020-03-11','123454343456','12345678','tranminhtrieudn@gmail.com','DaNang',1),(14,'Hoàng Long Long','2020-03-13','421564583','0905123456','tmt@gmal.com','Nam Ô',1),(15,'Kiến Đen Đen Đen','2020-03-28','123456789','0905123456','tmt@gmal.com','Da Nang',1),(16,'tmt','2020-03-20','123456789','0905123456','tmt@gmail.com','DN',5);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birthday` date DEFAULT NULL,
  `id_card` varchar(45) DEFAULT NULL,
  `salary` decimal(18,2) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Hoàng Văn Khanh','1990-01-24','012312345',7000000.00,'076121212','abc1@gamil.com','Quảng Trị'),(2,'Đặng Văn B','1970-07-12','012312346',20000000.00,'0932121234','abc2@gamil.com','Đà Nẵng'),(3,'Trần C','1991-02-14','012312347',9000000.00,'033121256','abc3@gamil.com','Quảng Bình'),(4,'Khánh Trang','1994-10-12','012312348',7000000.00,'044121278','Trang@gamil.com','Quảng Trị'),(5,'Nguyễn Thị Trang','1992-11-11','012312398',15000000.00,'0231213412','ab23@gamil.com','Đà Nẵng'),(6,'Hoàng Thị Ngọc Quỳnh','1994-08-06','012312432',15000000.00,'012123434','abewq4@gamil.com','Huế'),(7,'Trần Thị Thu Út','1980-06-19',' 012312567',9000000.00,'02324356','abqwe@gamil.com','Đà Nẵng'),(8,'Lê Văn C','1982-05-21','012845743',7000000.00,'0821212345','abqq223@gamil.com','Quảng Nam'),(9,'Hoàng Ngọc G','1981-04-14','012324183',15000000.00,'094121278','abcwqe224@gamil.com','Hà Nội'),(10,'Trần Long Hoàng Ngọc','1979-02-15','012324179',15000000.00,'0541212986','abdsad4@gamil.com','Quảng Trị');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `service_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `service_status` varchar(30) DEFAULT NULL,
  `service_name` varchar(50) DEFAULT NULL,
  `area_used` int(11) DEFAULT NULL,
  `number_floors` int(11) DEFAULT NULL,
  `number_max_people` int(11) DEFAULT NULL,
  `rental_costs` decimal(18,2) DEFAULT NULL,
  `accompanied_service_status` varchar(30) DEFAULT NULL,
  `type_rent_id` int(10) unsigned DEFAULT NULL,
  `type_service_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `fk_type_rent` (`type_rent_id`),
  KEY `fk_type_service` (`type_service_id`),
  CONSTRAINT `fk_type_rent` FOREIGN KEY (`type_rent_id`) REFERENCES `type_rents` (`type_rent_id`),
  CONSTRAINT `fk_type_service` FOREIGN KEY (`type_service_id`) REFERENCES `type_services` (`type_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'a','Villa1',100,3,3,1000000.00,'f',2,1),(2,'b','House1',50,2,3,750000.00,'u',3,2),(3,'c','House2',60,2,5,850000.00,'c',4,2),(4,'d','Room1',30,1,3,300000.00,'k',3,3),(5,'e','Villa2',150,4,5,1500000.00,'y',3,1),(6,'f','House3',50,1,3,5000000.00,'o',2,2),(7,'g','Romm2',25,1,2,1500000.00,'u',4,3),(8,'k','Villa3',100,2,2,6000000.00,'e',2,1);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_customers`
--

DROP TABLE IF EXISTS `type_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_customers` (
  `type_customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type_customer_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`type_customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_customers`
--

LOCK TABLES `type_customers` WRITE;
/*!40000 ALTER TABLE `type_customers` DISABLE KEYS */;
INSERT INTO `type_customers` VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
/*!40000 ALTER TABLE `type_customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_rents`
--

DROP TABLE IF EXISTS `type_rents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_rents` (
  `type_rent_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type_rent_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`type_rent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_rents`
--

LOCK TABLES `type_rents` WRITE;
/*!40000 ALTER TABLE `type_rents` DISABLE KEYS */;
INSERT INTO `type_rents` VALUES (1,'Năm',100000000),(2,'Tháng',15000000),(3,'Ngày',1000000),(4,'Gio',200000);
/*!40000 ALTER TABLE `type_rents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_services`
--

DROP TABLE IF EXISTS `type_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_services` (
  `type_service_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type_services_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_services`
--

LOCK TABLES `type_services` WRITE;
/*!40000 ALTER TABLE `type_services` DISABLE KEYS */;
INSERT INTO `type_services` VALUES (1,'Villa'),(2,'House'),(3,'Room');
/*!40000 ALTER TABLE `type_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tmt@gmail.com','$2a$10$mEIbCMGnV5g2ws3YlxsiM.JoIkV5fPZ6y1mDqi3qUsI42wCzPQP.C'),(2,'user@gmail.com','$2a$10$mEIbCMGnV5g2ws3YlxsiM.JoIkV5fPZ6y1mDqi3qUsI42wCzPQP.C');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned DEFAULT NULL,
  `user_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-06 15:02:53
