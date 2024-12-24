-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: projet_cda_db
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id_course` bigint NOT NULL AUTO_INCREMENT,
  `date_course` date NOT NULL,
  `end_hour` time(6) NOT NULL,
  `start_hour` time(6) NOT NULL,
  `session_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_course`),
  KEY `FKlake7yd6w21k9r7qd45r65lyg` (`session_id`),
  CONSTRAINT `FKlake7yd6w21k9r7qd45r65lyg` FOREIGN KEY (`session_id`) REFERENCES `session` (`id_session`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (9,'2025-01-06','17:30:00.000000','14:30:00.000000',32),(10,'2025-01-13','17:30:00.000000','14:30:00.000000',32),(11,'2025-01-20','17:30:00.000000','14:30:00.000000',32),(12,'2025-01-27','17:30:00.000000','14:30:00.000000',32),(13,'2025-01-07','17:30:00.000000','13:30:00.000000',32),(14,'2025-01-14','17:30:00.000000','13:30:00.000000',32),(15,'2025-01-21','17:30:00.000000','13:30:00.000000',32),(16,'2025-01-28','17:30:00.000000','13:30:00.000000',32),(17,'2025-02-03','17:30:00.000000','14:30:00.000000',33),(18,'2025-02-10','17:30:00.000000','14:30:00.000000',33),(19,'2025-02-17','17:30:00.000000','14:30:00.000000',33),(20,'2025-02-24','17:30:00.000000','14:30:00.000000',33),(21,'2025-02-04','17:30:00.000000','13:30:00.000000',33),(22,'2025-02-11','17:30:00.000000','13:30:00.000000',33),(23,'2025-02-18','17:30:00.000000','13:30:00.000000',33),(24,'2025-02-25','17:30:00.000000','13:30:00.000000',33),(25,'2025-03-03','17:30:00.000000','14:30:00.000000',34),(26,'2025-03-10','17:30:00.000000','14:30:00.000000',34),(27,'2025-03-17','17:30:00.000000','14:30:00.000000',34),(28,'2025-03-24','17:30:00.000000','14:30:00.000000',34),(29,'2025-03-31','17:30:00.000000','14:30:00.000000',34),(30,'2025-03-04','17:30:00.000000','13:30:00.000000',34),(31,'2025-03-11','17:30:00.000000','13:30:00.000000',34),(32,'2025-03-18','17:30:00.000000','13:30:00.000000',34),(33,'2025-03-25','17:30:00.000000','13:30:00.000000',34),(34,'2025-04-01','17:30:00.000000','13:30:00.000000',34),(35,'2025-04-07','17:30:00.000000','14:30:00.000000',35),(36,'2025-04-14','17:30:00.000000','14:30:00.000000',35),(37,'2025-04-21','17:30:00.000000','14:30:00.000000',35),(38,'2025-04-28','17:30:00.000000','14:30:00.000000',35),(39,'2025-04-01','17:30:00.000000','13:30:00.000000',35),(40,'2025-04-08','17:30:00.000000','13:30:00.000000',35),(41,'2025-04-15','17:30:00.000000','13:30:00.000000',35),(42,'2025-04-22','17:30:00.000000','13:30:00.000000',35),(43,'2025-04-29','17:30:00.000000','13:30:00.000000',35),(44,'2025-05-05','17:30:00.000000','14:30:00.000000',36),(45,'2025-05-12','17:30:00.000000','14:30:00.000000',36),(46,'2025-05-19','17:30:00.000000','14:30:00.000000',36),(47,'2025-05-26','17:30:00.000000','14:30:00.000000',36),(48,'2025-05-06','17:30:00.000000','13:30:00.000000',36),(49,'2025-05-13','17:30:00.000000','13:30:00.000000',36),(50,'2025-05-20','17:30:00.000000','13:30:00.000000',36),(51,'2025-05-27','17:30:00.000000','13:30:00.000000',36),(52,'2025-01-06','17:30:00.000000','14:30:00.000000',37),(53,'2025-01-13','17:30:00.000000','14:30:00.000000',37),(54,'2025-01-20','17:30:00.000000','14:30:00.000000',37),(55,'2025-01-27','17:30:00.000000','14:30:00.000000',37),(56,'2025-01-07','17:30:00.000000','13:30:00.000000',37),(57,'2025-01-14','17:30:00.000000','13:30:00.000000',37),(58,'2025-01-21','17:30:00.000000','13:30:00.000000',37),(59,'2025-01-28','17:30:00.000000','13:30:00.000000',37),(60,'2025-02-03','17:30:00.000000','14:30:00.000000',38),(61,'2025-02-10','17:30:00.000000','14:30:00.000000',38),(62,'2025-02-17','17:30:00.000000','14:30:00.000000',38),(63,'2025-02-24','17:30:00.000000','14:30:00.000000',38),(64,'2025-02-04','17:30:00.000000','13:30:00.000000',38),(65,'2025-02-11','17:30:00.000000','13:30:00.000000',38),(66,'2025-02-18','17:30:00.000000','13:30:00.000000',38),(67,'2025-02-25','17:30:00.000000','13:30:00.000000',38),(68,'2025-03-03','17:30:00.000000','14:30:00.000000',39),(69,'2025-03-10','17:30:00.000000','14:30:00.000000',39),(70,'2025-03-17','17:30:00.000000','14:30:00.000000',39),(71,'2025-03-24','17:30:00.000000','14:30:00.000000',39),(72,'2025-03-31','17:30:00.000000','14:30:00.000000',39),(73,'2025-03-04','17:30:00.000000','13:30:00.000000',39),(74,'2025-03-11','17:30:00.000000','13:30:00.000000',39),(75,'2025-03-18','17:30:00.000000','13:30:00.000000',39),(76,'2025-03-25','17:30:00.000000','13:30:00.000000',39),(77,'2025-04-01','17:30:00.000000','13:30:00.000000',39),(78,'2025-04-07','17:30:00.000000','14:30:00.000000',40),(79,'2025-04-14','17:30:00.000000','14:30:00.000000',40),(80,'2025-04-21','17:30:00.000000','14:30:00.000000',40),(81,'2025-04-28','17:30:00.000000','14:30:00.000000',40),(82,'2025-04-01','17:30:00.000000','13:30:00.000000',40),(83,'2025-04-08','17:30:00.000000','13:30:00.000000',40),(84,'2025-04-15','17:30:00.000000','13:30:00.000000',40),(85,'2025-04-22','17:30:00.000000','13:30:00.000000',40),(86,'2025-04-29','17:30:00.000000','13:30:00.000000',40),(87,'2025-05-05','17:30:00.000000','14:30:00.000000',41),(88,'2025-05-12','17:30:00.000000','14:30:00.000000',41),(89,'2025-05-19','17:30:00.000000','14:30:00.000000',41),(90,'2025-05-26','17:30:00.000000','14:30:00.000000',41),(91,'2025-05-06','17:30:00.000000','13:30:00.000000',41),(92,'2025-05-13','17:30:00.000000','13:30:00.000000',41),(93,'2025-05-20','17:30:00.000000','13:30:00.000000',41),(94,'2025-05-27','17:30:00.000000','13:30:00.000000',41),(95,'2025-01-06','17:30:00.000000','14:30:00.000000',42),(96,'2025-01-13','17:30:00.000000','14:30:00.000000',42),(97,'2025-01-20','17:30:00.000000','14:30:00.000000',42),(98,'2025-01-27','17:30:00.000000','14:30:00.000000',42),(99,'2025-01-07','17:30:00.000000','13:30:00.000000',42),(100,'2025-01-14','17:30:00.000000','13:30:00.000000',42),(101,'2025-01-21','17:30:00.000000','13:30:00.000000',42),(102,'2025-01-28','17:30:00.000000','13:30:00.000000',42),(103,'2025-02-03','17:30:00.000000','14:30:00.000000',43),(104,'2025-02-10','17:30:00.000000','14:30:00.000000',43),(105,'2025-02-17','17:30:00.000000','14:30:00.000000',43),(106,'2025-02-24','17:30:00.000000','14:30:00.000000',43),(107,'2025-02-04','17:30:00.000000','13:30:00.000000',43),(108,'2025-02-11','17:30:00.000000','13:30:00.000000',43),(109,'2025-02-18','17:30:00.000000','13:30:00.000000',43),(110,'2025-02-25','17:30:00.000000','13:30:00.000000',43),(111,'2025-03-03','17:30:00.000000','14:30:00.000000',44),(112,'2025-03-10','17:30:00.000000','14:30:00.000000',44),(113,'2025-03-17','17:30:00.000000','14:30:00.000000',44),(114,'2025-03-24','17:30:00.000000','14:30:00.000000',44),(115,'2025-03-31','17:30:00.000000','14:30:00.000000',44),(116,'2025-03-04','17:30:00.000000','13:30:00.000000',44),(117,'2025-03-11','17:30:00.000000','13:30:00.000000',44),(118,'2025-03-18','17:30:00.000000','13:30:00.000000',44),(119,'2025-03-25','17:30:00.000000','13:30:00.000000',44),(120,'2025-04-01','17:30:00.000000','13:30:00.000000',44),(121,'2025-04-07','17:30:00.000000','14:30:00.000000',45),(122,'2025-04-14','17:30:00.000000','14:30:00.000000',45),(123,'2025-04-21','17:30:00.000000','14:30:00.000000',45),(124,'2025-04-28','17:30:00.000000','14:30:00.000000',45),(125,'2025-04-01','17:30:00.000000','13:30:00.000000',45),(126,'2025-04-08','17:30:00.000000','13:30:00.000000',45),(127,'2025-04-15','17:30:00.000000','13:30:00.000000',45),(128,'2025-04-22','17:30:00.000000','13:30:00.000000',45),(129,'2025-04-29','17:30:00.000000','13:30:00.000000',45),(130,'2025-05-05','17:30:00.000000','14:30:00.000000',46),(131,'2025-05-12','17:30:00.000000','14:30:00.000000',46),(132,'2025-05-19','17:30:00.000000','14:30:00.000000',46),(133,'2025-05-26','17:30:00.000000','14:30:00.000000',46),(134,'2025-05-06','17:30:00.000000','13:30:00.000000',46),(135,'2025-05-13','17:30:00.000000','13:30:00.000000',46),(136,'2025-05-20','17:30:00.000000','13:30:00.000000',46),(137,'2025-05-27','17:30:00.000000','13:30:00.000000',46),(138,'2025-01-06','17:30:00.000000','14:30:00.000000',47),(139,'2025-01-13','17:30:00.000000','14:30:00.000000',47),(140,'2025-01-20','17:30:00.000000','14:30:00.000000',47),(141,'2025-01-27','17:30:00.000000','14:30:00.000000',47),(142,'2025-01-07','17:30:00.000000','13:30:00.000000',47),(143,'2025-01-14','17:30:00.000000','13:30:00.000000',47),(144,'2025-01-21','17:30:00.000000','13:30:00.000000',47),(145,'2025-01-28','17:30:00.000000','13:30:00.000000',47),(146,'2025-02-03','17:30:00.000000','14:30:00.000000',48),(147,'2025-02-10','17:30:00.000000','14:30:00.000000',48),(148,'2025-02-17','17:30:00.000000','14:30:00.000000',48),(149,'2025-02-24','17:30:00.000000','14:30:00.000000',48),(150,'2025-02-04','17:30:00.000000','13:30:00.000000',48),(151,'2025-02-11','17:30:00.000000','13:30:00.000000',48),(152,'2025-02-18','17:30:00.000000','13:30:00.000000',48),(153,'2025-02-25','17:30:00.000000','13:30:00.000000',48),(154,'2025-03-03','17:30:00.000000','14:30:00.000000',49),(155,'2025-03-10','17:30:00.000000','14:30:00.000000',49),(156,'2025-03-17','17:30:00.000000','14:30:00.000000',49),(157,'2025-03-24','17:30:00.000000','14:30:00.000000',49),(158,'2025-03-31','17:30:00.000000','14:30:00.000000',49),(159,'2025-03-04','17:30:00.000000','13:30:00.000000',49),(160,'2025-03-11','17:30:00.000000','13:30:00.000000',49),(161,'2025-03-18','17:30:00.000000','13:30:00.000000',49),(162,'2025-03-25','17:30:00.000000','13:30:00.000000',49),(163,'2025-04-01','17:30:00.000000','13:30:00.000000',49),(164,'2025-04-07','17:30:00.000000','14:30:00.000000',50),(165,'2025-04-14','17:30:00.000000','14:30:00.000000',50),(166,'2025-04-21','17:30:00.000000','14:30:00.000000',50),(167,'2025-04-28','17:30:00.000000','14:30:00.000000',50),(168,'2025-04-01','17:30:00.000000','13:30:00.000000',50),(169,'2025-04-08','17:30:00.000000','13:30:00.000000',50),(170,'2025-04-15','17:30:00.000000','13:30:00.000000',50),(171,'2025-04-22','17:30:00.000000','13:30:00.000000',50),(172,'2025-04-29','17:30:00.000000','13:30:00.000000',50),(173,'2025-05-05','17:30:00.000000','14:30:00.000000',51),(174,'2025-05-12','17:30:00.000000','14:30:00.000000',51),(175,'2025-05-19','17:30:00.000000','14:30:00.000000',51),(176,'2025-05-26','17:30:00.000000','14:30:00.000000',51),(177,'2025-05-06','17:30:00.000000','13:30:00.000000',51),(178,'2025-05-13','17:30:00.000000','13:30:00.000000',51),(179,'2025-05-20','17:30:00.000000','13:30:00.000000',51),(180,'2025-05-27','17:30:00.000000','13:30:00.000000',51),(181,'2025-01-06','17:30:00.000000','14:30:00.000000',52),(182,'2025-01-13','17:30:00.000000','14:30:00.000000',52),(183,'2025-01-20','17:30:00.000000','14:30:00.000000',52),(184,'2025-01-27','17:30:00.000000','14:30:00.000000',52),(185,'2025-01-07','17:30:00.000000','13:30:00.000000',52),(186,'2025-01-14','17:30:00.000000','13:30:00.000000',52),(187,'2025-01-21','17:30:00.000000','13:30:00.000000',52),(188,'2025-01-28','17:30:00.000000','13:30:00.000000',52),(189,'2025-02-03','17:30:00.000000','14:30:00.000000',53),(190,'2025-02-10','17:30:00.000000','14:30:00.000000',53),(191,'2025-02-17','17:30:00.000000','14:30:00.000000',53),(192,'2025-02-24','17:30:00.000000','14:30:00.000000',53),(193,'2025-02-04','17:30:00.000000','13:30:00.000000',53),(194,'2025-02-11','17:30:00.000000','13:30:00.000000',53),(195,'2025-02-18','17:30:00.000000','13:30:00.000000',53),(196,'2025-02-25','17:30:00.000000','13:30:00.000000',53),(197,'2025-03-03','17:30:00.000000','14:30:00.000000',54),(198,'2025-03-10','17:30:00.000000','14:30:00.000000',54),(199,'2025-03-17','17:30:00.000000','14:30:00.000000',54),(200,'2025-03-24','17:30:00.000000','14:30:00.000000',54),(201,'2025-03-31','17:30:00.000000','14:30:00.000000',54),(202,'2025-03-04','17:30:00.000000','13:30:00.000000',54),(203,'2025-03-11','17:30:00.000000','13:30:00.000000',54),(204,'2025-03-18','17:30:00.000000','13:30:00.000000',54),(205,'2025-03-25','17:30:00.000000','13:30:00.000000',54),(206,'2025-04-01','17:30:00.000000','13:30:00.000000',54),(207,'2025-04-07','17:30:00.000000','14:30:00.000000',55),(208,'2025-04-14','17:30:00.000000','14:30:00.000000',55),(209,'2025-04-21','17:30:00.000000','14:30:00.000000',55),(210,'2025-04-28','17:30:00.000000','14:30:00.000000',55),(211,'2025-04-01','17:30:00.000000','13:30:00.000000',55),(212,'2025-04-08','17:30:00.000000','13:30:00.000000',55),(213,'2025-04-15','17:30:00.000000','13:30:00.000000',55),(214,'2025-04-22','17:30:00.000000','13:30:00.000000',55),(215,'2025-04-29','17:30:00.000000','13:30:00.000000',55),(216,'2025-05-05','17:30:00.000000','14:30:00.000000',56),(217,'2025-05-12','17:30:00.000000','14:30:00.000000',56),(218,'2025-05-19','17:30:00.000000','14:30:00.000000',56),(219,'2025-05-26','17:30:00.000000','14:30:00.000000',56),(220,'2025-05-06','17:30:00.000000','13:30:00.000000',56),(221,'2025-05-13','17:30:00.000000','13:30:00.000000',56),(222,'2025-05-20','17:30:00.000000','13:30:00.000000',56),(223,'2025-05-27','17:30:00.000000','13:30:00.000000',56),(224,'2025-01-06','17:30:00.000000','14:30:00.000000',57),(225,'2025-01-13','17:30:00.000000','14:30:00.000000',57),(226,'2025-01-20','17:30:00.000000','14:30:00.000000',57),(227,'2025-01-27','17:30:00.000000','14:30:00.000000',57),(228,'2025-01-07','17:30:00.000000','13:30:00.000000',57),(229,'2025-01-14','17:30:00.000000','13:30:00.000000',57),(230,'2025-01-21','17:30:00.000000','13:30:00.000000',57),(231,'2025-01-28','17:30:00.000000','13:30:00.000000',57),(232,'2025-02-03','17:30:00.000000','14:30:00.000000',58),(233,'2025-02-10','17:30:00.000000','14:30:00.000000',58),(234,'2025-02-17','17:30:00.000000','14:30:00.000000',58),(235,'2025-02-24','17:30:00.000000','14:30:00.000000',58),(236,'2025-02-04','17:30:00.000000','13:30:00.000000',58),(237,'2025-02-11','17:30:00.000000','13:30:00.000000',58),(238,'2025-02-18','17:30:00.000000','13:30:00.000000',58),(239,'2025-02-25','17:30:00.000000','13:30:00.000000',58),(240,'2025-03-03','17:30:00.000000','14:30:00.000000',59),(241,'2025-03-10','17:30:00.000000','14:30:00.000000',59),(242,'2025-03-17','17:30:00.000000','14:30:00.000000',59),(243,'2025-03-24','17:30:00.000000','14:30:00.000000',59),(244,'2025-03-31','17:30:00.000000','14:30:00.000000',59),(245,'2025-03-04','17:30:00.000000','13:30:00.000000',59),(246,'2025-03-11','17:30:00.000000','13:30:00.000000',59),(247,'2025-03-18','17:30:00.000000','13:30:00.000000',59),(248,'2025-03-25','17:30:00.000000','13:30:00.000000',59),(249,'2025-04-01','17:30:00.000000','13:30:00.000000',59),(250,'2025-04-07','17:30:00.000000','14:30:00.000000',60),(251,'2025-04-14','17:30:00.000000','14:30:00.000000',60),(252,'2025-04-21','17:30:00.000000','14:30:00.000000',60),(253,'2025-04-28','17:30:00.000000','14:30:00.000000',60),(254,'2025-04-01','17:30:00.000000','13:30:00.000000',60),(255,'2025-04-08','17:30:00.000000','13:30:00.000000',60),(256,'2025-04-15','17:30:00.000000','13:30:00.000000',60),(257,'2025-04-22','17:30:00.000000','13:30:00.000000',60),(258,'2025-04-29','17:30:00.000000','13:30:00.000000',60),(259,'2025-05-05','17:30:00.000000','14:30:00.000000',61),(260,'2025-05-12','17:30:00.000000','14:30:00.000000',61),(261,'2025-05-19','17:30:00.000000','14:30:00.000000',61),(262,'2025-05-26','17:30:00.000000','14:30:00.000000',61),(263,'2025-05-06','17:30:00.000000','13:30:00.000000',61),(264,'2025-05-13','17:30:00.000000','13:30:00.000000',61),(265,'2025-05-20','17:30:00.000000','13:30:00.000000',61),(266,'2025-05-27','17:30:00.000000','13:30:00.000000',61),(267,'2024-12-23','17:30:00.000000','14:30:00.000000',62),(268,'2024-12-30','17:30:00.000000','14:30:00.000000',62),(269,'2024-12-24','17:30:00.000000','13:30:00.000000',62),(270,'2024-12-31','17:30:00.000000','13:30:00.000000',62);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id_location` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `zip_code` int NOT NULL,
  PRIMARY KEY (`id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Ramonburgh','26','34953 Langosh Dale',53659),(2,'Karleenberg','33','40527 Beahan Street',28790),(3,'East Aimeefort','2','216 Walker Forge',26760),(4,'Okunevaborough','9','177 Gislason Inlet',17646),(5,'Berniecebury','13','641 Wolff Lock',27800),(6,'Seymourview','30','6967 Romana Port',13081),(7,'Grahambury','9','549 Jerald Common',38452),(8,'Port Kennith','2','87634 Osinski Light',27192),(9,'Tessaton','11','615 Bradtke Prairie',55675),(10,'Lake Isrealhaven','23','479 Bettyann Stravenue',5207);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `note`
--

DROP TABLE IF EXISTS `note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `note` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `result_test` int NOT NULL,
  `success` bit(1) NOT NULL,
  `id_test_user` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm0sbt7mirac14ok2ujqr0xdql` (`id_test_user`),
  KEY `FK83ep238ikljeapa4b31jadem7` (`id_user`),
  CONSTRAINT `FK83ep238ikljeapa4b31jadem7` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  CONSTRAINT `FKm0sbt7mirac14ok2ujqr0xdql` FOREIGN KEY (`id_test_user`) REFERENCES `test_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (11,2,_binary '',14,1),(12,3,_binary '',14,2),(13,3,_binary '',14,5),(31,3,_binary '',14,11);
/*!40000 ALTER TABLE `note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presence`
--

DROP TABLE IF EXISTS `presence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `presence` (
  `id_presence` bigint NOT NULL AUTO_INCREMENT,
  `ispresent` bit(1) DEFAULT NULL,
  `course_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_presence`),
  KEY `FKiaxnx8ka5t7yon78sufttkp2n` (`course_id`),
  KEY `FK3txfixln9gglfukp4vdvvxiv5` (`user_id`),
  CONSTRAINT `FK3txfixln9gglfukp4vdvvxiv5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKiaxnx8ka5t7yon78sufttkp2n` FOREIGN KEY (`course_id`) REFERENCES `course` (`id_course`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presence`
--

LOCK TABLES `presence` WRITE;
/*!40000 ALTER TABLE `presence` DISABLE KEYS */;
INSERT INTO `presence` VALUES (1,_binary '\0',259,1),(2,_binary '\0',260,1),(3,_binary '\0',261,1),(4,_binary '\0',262,1),(5,_binary '\0',263,1),(6,_binary '\0',264,1),(7,_binary '\0',265,1),(8,_binary '\0',266,1),(9,_binary '\0',259,2),(10,_binary '\0',260,2),(11,_binary '\0',261,2),(12,_binary '\0',262,2),(13,_binary '\0',263,2),(14,_binary '\0',264,2),(15,_binary '\0',265,2),(16,_binary '\0',266,2),(25,_binary '\0',44,1),(26,_binary '\0',45,1),(27,_binary '\0',46,1),(28,_binary '\0',47,1),(29,_binary '\0',48,1),(30,_binary '\0',49,1),(31,_binary '\0',50,1),(32,_binary '\0',51,1),(33,_binary '\0',44,2),(34,_binary '\0',45,2),(35,_binary '\0',46,2),(36,_binary '\0',47,2),(37,_binary '\0',48,2),(38,_binary '\0',49,2),(39,_binary '\0',50,2),(40,_binary '\0',51,2),(41,_binary '\0',44,5),(42,_binary '\0',45,5),(43,_binary '\0',46,5),(44,_binary '\0',47,5),(45,_binary '\0',48,5),(46,_binary '\0',49,5),(47,_binary '\0',50,5),(48,_binary '\0',51,5),(49,_binary '\0',130,5),(50,_binary '\0',131,5),(51,_binary '\0',132,5),(52,_binary '\0',133,5),(53,_binary '\0',134,5),(54,_binary '\0',135,5),(55,_binary '\0',136,5),(56,_binary '\0',137,5),(57,_binary '\0',95,5),(58,_binary '\0',96,5),(59,_binary '\0',97,5),(60,_binary '\0',98,5),(61,_binary '\0',99,5),(62,_binary '\0',100,5),(63,_binary '\0',101,5),(64,_binary '\0',102,5),(65,_binary '\0',267,1),(66,_binary '\0',268,1),(67,_binary '\0',269,1),(68,_binary '\0',270,1),(69,_binary '\0',267,2),(70,_binary '\0',268,2),(71,_binary '\0',269,2),(72,_binary '\0',270,2),(73,_binary '\0',267,5),(74,_binary '\0',268,5),(75,_binary '\0',269,5),(76,_binary '\0',270,5);
/*!40000 ALTER TABLE `presence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proposition`
--

DROP TABLE IF EXISTS `proposition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proposition` (
  `id_proposition` bigint NOT NULL AUTO_INCREMENT,
  `option_value` varchar(255) NOT NULL,
  `id_question` bigint DEFAULT NULL,
  PRIMARY KEY (`id_proposition`),
  KEY `FKnckevhvglb35qmpd6m6ny98bu` (`id_question`),
  CONSTRAINT `FKnckevhvglb35qmpd6m6ny98bu` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
INSERT INTO `proposition` VALUES (17,'m2i',9),(18,'IT-Training',9),(19,'m2i',12),(20,'IT-Training',12),(21,'m2i',13),(22,'IT-Training',13),(23,'m2i',14),(24,'IT-Training',14),(25,'this',15),(26,'new',15),(27,'class',15),(28,'instance',15),(29,'extends',16),(30,'implements',16),(31,'inherits',16),(32,'super',16),(33,'Un système de gestion des tâches',17),(34,'Un processus de développement logiciel',17),(35,'Un outil pour rédiger de la documentation',17),(36,'Une méthode de test manuel',17),(37,'Continuous Integration',18),(38,'Code Integration',18),(39,'Continuous Improvement',18),(40,'Centralized Infrastructure',18),(41,'Éliminer les erreurs humaines',19),(42,'Livrer le code manuellement',19),(43,'Déployer les applications une fois par an',19),(44,'Éviter les tests',19);
/*!40000 ALTER TABLE `proposition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id_question` bigint NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) NOT NULL,
  `label` varchar(255) NOT NULL,
  `id_test_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id_question`),
  KEY `FKh2rhvrasgd2yr452danto2q95` (`id_test_user`),
  CONSTRAINT `FKh2rhvrasgd2yr452danto2q95` FOREIGN KEY (`id_test_user`) REFERENCES `test_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (9,'IT-Training','quel est le nom du centre de formation?',9),(12,'IT-Training','quel est le nom du centre de formation?',12),(13,'IT-Training','quel est le nom du centre de formation?',13),(14,'IT-Training','Quel est le nom du centre de formation?',14),(15,'new','Quel mot-clé en Java est utilisé pour créer une nouvelle instance d’un objet ?',14),(16,'extends','Quel mot-clé est utilisé pour hériter d\'une classe en Java ?',14),(17,'Un processus de développement logiciel','Qu’est-ce que le CI/CD ?',15),(18,'Continuous Integration','Que signifie le terme \'CI\' ?',15),(19,'Éliminer les erreurs humaines','Quel est le principal avantage du CI/CD ?',15);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKbjxn5ii7v7ygwx39et0wawu0q` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (3,'ROLE_ADMIN'),(2,'ROLE_TRAINER'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session` (
  `id_session` bigint NOT NULL AUTO_INCREMENT,
  `end_date` date NOT NULL,
  `evaluation_forms` bit(1) DEFAULT NULL,
  `machines_installed` bit(1) DEFAULT NULL,
  `place_limit` int DEFAULT NULL,
  `room_reserved` bit(1) DEFAULT NULL,
  `start_date` date NOT NULL,
  `trainees_confirmation` bit(1) DEFAULT NULL,
  `trainer_confirmation` bit(1) DEFAULT NULL,
  `location_id` int DEFAULT NULL,
  `training_id` int DEFAULT NULL,
  PRIMARY KEY (`id_session`),
  KEY `FKk9sxbgtd06ugbbullt82vbxmq` (`location_id`),
  KEY `FKrohssa00dtaqto152b65nucfc` (`training_id`),
  CONSTRAINT `FKk9sxbgtd06ugbbullt82vbxmq` FOREIGN KEY (`location_id`) REFERENCES `location` (`id_location`),
  CONSTRAINT `FKrohssa00dtaqto152b65nucfc` FOREIGN KEY (`training_id`) REFERENCES `training` (`id_training`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (32,'2025-02-01',_binary '\0',_binary '\0',18,_binary '\0','2025-01-01',_binary '\0',_binary '\0',2,5),(33,'2025-03-01',_binary '\0',_binary '\0',8,_binary '\0','2025-02-01',_binary '\0',_binary '\0',4,39),(34,'2025-04-01',_binary '\0',_binary '\0',26,_binary '\0','2025-03-01',_binary '\0',_binary '\0',5,3),(35,'2025-05-01',_binary '\0',_binary '\0',17,_binary '\0','2025-04-01',_binary '\0',_binary '\0',10,14),(36,'2025-06-01',_binary '\0',_binary '\0',3,_binary '\0','2025-05-01',_binary '\0',_binary '\0',8,18),(37,'2025-02-01',_binary '\0',_binary '\0',9,_binary '\0','2025-01-01',_binary '\0',_binary '\0',5,4),(38,'2025-03-01',_binary '\0',_binary '\0',26,_binary '\0','2025-02-01',_binary '\0',_binary '\0',5,15),(39,'2025-04-01',_binary '\0',_binary '\0',28,_binary '\0','2025-03-01',_binary '\0',_binary '\0',5,10),(40,'2025-05-01',_binary '\0',_binary '\0',28,_binary '\0','2025-04-01',_binary '\0',_binary '\0',3,7),(41,'2025-06-01',_binary '\0',_binary '\0',20,_binary '\0','2025-05-01',_binary '\0',_binary '\0',1,2),(42,'2025-02-01',_binary '\0',_binary '\0',17,_binary '\0','2025-01-01',_binary '\0',_binary '\0',5,19),(43,'2025-03-01',_binary '\0',_binary '\0',26,_binary '\0','2025-02-01',_binary '\0',_binary '\0',2,2),(44,'2025-04-01',_binary '\0',_binary '\0',17,_binary '\0','2025-03-01',_binary '\0',_binary '\0',3,4),(45,'2025-05-01',_binary '\0',_binary '\0',12,_binary '\0','2025-04-01',_binary '\0',_binary '\0',6,11),(46,'2025-06-01',_binary '\0',_binary '\0',26,_binary '\0','2025-05-01',_binary '\0',_binary '\0',8,19),(47,'2025-02-01',_binary '\0',_binary '\0',29,_binary '\0','2025-01-01',_binary '\0',_binary '\0',2,9),(48,'2025-03-01',_binary '\0',_binary '\0',4,_binary '\0','2025-02-01',_binary '\0',_binary '\0',6,2),(49,'2025-04-01',_binary '\0',_binary '\0',15,_binary '\0','2025-03-01',_binary '\0',_binary '\0',9,18),(50,'2025-05-01',_binary '\0',_binary '\0',27,_binary '\0','2025-04-01',_binary '\0',_binary '\0',7,9),(51,'2025-06-01',_binary '\0',_binary '\0',17,_binary '\0','2025-05-01',_binary '\0',_binary '\0',1,12),(52,'2025-02-01',_binary '\0',_binary '\0',27,_binary '\0','2025-01-01',_binary '\0',_binary '\0',8,18),(53,'2025-03-01',_binary '\0',_binary '\0',9,_binary '\0','2025-02-01',_binary '\0',_binary '\0',10,4),(54,'2025-04-01',_binary '\0',_binary '\0',28,_binary '\0','2025-03-01',_binary '\0',_binary '\0',4,41),(55,'2025-05-01',_binary '\0',_binary '\0',12,_binary '\0','2025-04-01',_binary '\0',_binary '\0',3,4),(56,'2025-06-01',_binary '\0',_binary '\0',14,_binary '\0','2025-05-01',_binary '\0',_binary '\0',7,3),(57,'2025-02-01',_binary '\0',_binary '\0',9,_binary '\0','2025-01-01',_binary '\0',_binary '\0',7,13),(58,'2025-03-01',_binary '\0',_binary '\0',16,_binary '\0','2025-02-01',_binary '\0',_binary '\0',10,13),(59,'2025-04-01',_binary '\0',_binary '\0',25,_binary '\0','2025-03-01',_binary '\0',_binary '\0',6,13),(60,'2025-05-01',_binary '\0',_binary '\0',15,_binary '\0','2025-04-01',_binary '\0',_binary '\0',1,14),(61,'2025-06-01',_binary '\0',_binary '\0',19,_binary '\0','2025-05-01',_binary '\0',_binary '\0',2,11),(62,'2025-01-01',_binary '\0',_binary '\0',10,_binary '\0','2024-12-18',_binary '\0',_binary '\0',1,1);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_theme`
--

DROP TABLE IF EXISTS `sub_theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_theme` (
  `id_subtheme` int NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `title_subtheme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_subtheme`),
  UNIQUE KEY `UKcow66tnrklh8lhdhwbpjy5au1` (`title_subtheme`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_theme`
--

LOCK TABLES `sub_theme` WRITE;
/*!40000 ALTER TABLE `sub_theme` DISABLE KEYS */;
INSERT INTO `sub_theme` VALUES (1,'/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png','Java'),(2,'/images/python-logo.png','python'),(3,'/images/logiciels-gratuits.jpg','Bureautique'),(4,'/images/system-3810164661.jpg','systèmes d\'exploitation'),(5,'/images/Gestion-de-projet-3658866287.jpg','chef de projet'),(6,'/images/403-4039227_c-language-logo-png-transparent-png-2443893358.png','C#'),(7,'/images/cybersecurite-pour-se-proteger-620x400.jpg','sécurité'),(8,'/images/php_PNG18-1060352843.png','PHP'),(9,'/images/Gestion-de-projet-3658866287.jpg','méthode agile'),(10,'/images/javascript-logo-png.png','javascript');
/*!40000 ALTER TABLE `sub_theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_user`
--

DROP TABLE IF EXISTS `test_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expected_result` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_user`
--

LOCK TABLES `test_user` WRITE;
/*!40000 ALTER TABLE `test_user` DISABLE KEYS */;
INSERT INTO `test_user` VALUES (9,5),(12,5),(13,5),(14,2),(15,2);
/*!40000 ALTER TABLE `test_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theme` (
  `id_theme` int NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_theme`),
  UNIQUE KEY `UKfeggm1nydbqdfei65evpvxw7o` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (4,'/images/java-logo.png','Languages de développement'),(23,'/images/telecomm-1733645639.jpg','réseau'),(24,'/images/Gestion-de-projet-3658866287.jpg','gestion de projets'),(25,'/images/system-3810164661.jpg','systèmes d\'exploitation'),(27,'/images/logiciels-gratuits.jpg','logiciels');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme_subtheme`
--

DROP TABLE IF EXISTS `theme_subtheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theme_subtheme` (
  `id_theme` int NOT NULL,
  `id_subtheme` int NOT NULL,
  KEY `FKq3rk78m2m834ufi9qkuinkn38` (`id_subtheme`),
  KEY `FK7w26lyy942crfxo543bewk0al` (`id_theme`),
  CONSTRAINT `FK7w26lyy942crfxo543bewk0al` FOREIGN KEY (`id_theme`) REFERENCES `theme` (`id_theme`),
  CONSTRAINT `FKq3rk78m2m834ufi9qkuinkn38` FOREIGN KEY (`id_subtheme`) REFERENCES `sub_theme` (`id_subtheme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme_subtheme`
--

LOCK TABLES `theme_subtheme` WRITE;
/*!40000 ALTER TABLE `theme_subtheme` DISABLE KEYS */;
INSERT INTO `theme_subtheme` VALUES (4,1),(4,2),(27,3),(25,4),(24,5),(4,6),(23,7),(4,8),(24,9),(4,10);
/*!40000 ALTER TABLE `theme_subtheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `training` (
  `id_training` int NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `inter` bit(1) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  `id_test_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id_training`),
  KEY `FKa3qp1vvg230hqksxdggjejvrx` (`id_test_user`),
  CONSTRAINT `FKa3qp1vvg230hqksxdggjejvrx` FOREIGN KEY (`id_test_user`) REFERENCES `test_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'# Laboriosam quod at qui voluptatem non exercitationem. \n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.\n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',3415,'CDA Java/Js',14),(2,'Voluptatem omnis dolorem quaerat omnis omnis. Tenetur ut consequatur. Et et neque quisquam cumque quo. Et voluptatem est perspiciatis. Omnis corporis quia nobis consequatur vitae et ea.','/images/javascript-logo-png.png',_binary '',8535.52,'fomation javascript',NULL),(3,'Expedita cum facere impedit doloribus. Nobis ea numquam vero enim pariatur. Minus non est alias omnis nam.','/images/Gestion-de-projet-3658866287.jpg',_binary '',7471.42,'formation chef de projet',NULL),(4,'Tenetur quam libero qui. Asperiores earum autem sed. Nam qui error voluptas itaque hic. Accusantium explicabo in. Qui assumenda omnis aspernatur sit consequuntur aliquam quasi.','/images/system-3810164661.jpg',_binary '',785.2,'formation linux',NULL),(5,'Consequuntur a vero adipisci et unde. Ut est quia natus debitis. Labore eum tempore. Dolorem ex autem tempore. Rem esse officia voluptas.','/images/logiciels-gratuits.jpg',_binary '',7338.63,'excel',NULL),(6,'Dolorem ad placeat ea omnis ullam quis unde. Et et iure aliquam. Molestiae qui id dolores.','/images/403-4039227_c-language-logo-png-transparent-png-2443893358.png',_binary '',3589.3,'formation C#',NULL),(7,'Error est maxime. Id quisquam dolor assumenda. Et consequatur sit molestias.','/images/python-logo.png',_binary '',5306.61,'formation python',NULL),(8,'Ut culpa officiis ut quis. Numquam libero sed excepturi. Cum perspiciatis doloremque et cumque adipisci aut.','/images/Gestion-de-projet-3658866287.jpg',_binary '',1619.9,'formation agile',NULL),(9,'Adipisci perferendis ea culpa est porro aliquid. Nesciunt sed nihil soluta enim velit. Ea ipsa eaque est aut. Molestiae quis expedita ut velit.','/images/php_PNG18-1060352843.png',_binary '',888.08,'formation PHP',NULL),(10,'Esse sint facere nostrum pariatur ea. Laudantium id tempore exercitationem qui aperiam eaque reiciendis. Deleniti et corporis consequatur sunt quia expedita rem. Delectus a vero possimus consequatur aliquid tempora corrupti.','/images/Gestion-de-projet-3658866287.jpg',_binary '',2179.88,'chef de projet 2',NULL),(11,'Aut nemo delectus nihil esse consequatur commodi aperiam. Sit aut ut et. Est velit alias eveniet. Voluptatem necessitatibus ut. Aliquid est mollitia.','/images/python-logo.png',_binary '',4452.85,'initiation python',NULL),(12,'Sequi recusandae laboriosam. Itaque in consequatur eveniet consectetur. Ut facere officia iure voluptatum. Voluptatem necessitatibus qui. Est quo ut ab hic.','/images/javascript-logo-png.png',_binary '',6715.88,'initiation js',NULL),(13,'Repellat in nihil eligendi. Tenetur rerum vel placeat quo quisquam illum. Laudantium vel voluptate. Repellendus fugit iste vero voluptatem quam distinctio voluptatum. At quisquam est iure corrupti.','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',1367.18,'formation Java',NULL),(14,'Non quas fugiat perspiciatis ad esse ut. Quia recusandae rerum eum odit. Explicabo ut est laborum iure doloremque voluptate. Dignissimos molestiae at praesentium adipisci aut consequatur. Facilis molestiae adipisci asperiores.','/images/Gestion-de-projet-3658866287.jpg',_binary '',849.87,'chef de projet 3',NULL),(15,'Dicta id nam aut quae voluptas. Corrupti velit ut. Laborum et necessitatibus. Veniam laboriosam laborum quasi aliquam voluptate.','/images/logiciels-gratuits.jpg',_binary '',8023.8,'suite adobe',NULL),(18,'# Vous pouvez écrire avec la syntaxe markdown.','/images/6c8b667d-8b69-4558-940e-0fde1d03e060.png',_binary '',5,'test image',14),(19,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n- test','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',10000,'CDA Java-python',NULL),(39,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n','/images/telecomm-1733645639.jpg',_binary '',0,'formation sécurité',NULL),(41,'# Vous pouvez écrire avec la syntaxe markdown.','/images/bc2e5dd0-58c3-4f31-ac43-b294c149cbd7.png',_binary '',5,'test docker',NULL),(42,'# Vous pouvez écrire avec la syntaxe markdown.','/images/python-logo.png',_binary '',0,'python dwwm',NULL),(43,'# Vous pouvez écrire avec la syntaxe markdown.\n- j écris en md\n','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',5,'initiation Java',NULL);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_subtheme`
--

DROP TABLE IF EXISTS `training_subtheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `training_subtheme` (
  `id_training` int NOT NULL,
  `id_subtheme` int NOT NULL,
  KEY `FK4g6r94kwj0a8jnf55uww1qeee` (`id_subtheme`),
  KEY `FKrh3mpbalfuelw9o8t3ockdoou` (`id_training`),
  CONSTRAINT `FK4g6r94kwj0a8jnf55uww1qeee` FOREIGN KEY (`id_subtheme`) REFERENCES `sub_theme` (`id_subtheme`),
  CONSTRAINT `FKrh3mpbalfuelw9o8t3ockdoou` FOREIGN KEY (`id_training`) REFERENCES `training` (`id_training`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_subtheme`
--

LOCK TABLES `training_subtheme` WRITE;
/*!40000 ALTER TABLE `training_subtheme` DISABLE KEYS */;
INSERT INTO `training_subtheme` VALUES (1,1),(2,10),(3,5),(4,4),(5,3),(6,6),(7,2),(8,9),(9,8),(10,5),(11,2),(12,10),(13,1),(14,5),(1,10),(19,1),(19,2),(39,7),(42,2),(43,1),(15,3);
/*!40000 ALTER TABLE `training_subtheme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nb_blame` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user@user.com','user','user',0,'$2a$10$p.b6gUKfC0x6.FkXMq7y/eKuyq5euaDDGNZHqFsXr6OcS5V4w.8p.',''),(2,'user2@user.com','user','user',0,'$2a$10$no7I4FdDUb553WoZ8gCWueoHCU3UXUV1gTyOFQYZjy6D.cyzm9Mxa',NULL),(3,'admin@admin.com','admin','admin',0,'$2a$10$YVjbIL4SdwotEgwOKlKQPeHqcxzVvWlnvZ9jj79QGCQRNeAEh1WES',NULL),(5,'user3@user.com','user','user',0,'$2a$10$CKNDJG.ChvXET5WNw7HBWeHrk1YhurpD9hbf3RmpUyvNy5LpmC8fa',NULL),(8,'user4@user.com','user','user',0,'$2a$10$iPUKD6B.fKVnquho.kYFJeO2/.OH32543E0s2XQtABID9ZLL4TO6i',NULL),(11,'user5@user.com','user','user',0,'$2a$10$w81E/ARr6f.YRdAJH/XEE.5KiHYovQQKCAddOK5KlxvXPugNOeY/a',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `roles_id` int NOT NULL,
  KEY `FKeog8p06nu33ihk13roqnrp1y6` (`roles_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKeog8p06nu33ihk13roqnrp1y6` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,1),(3,1),(3,3),(5,1),(8,1),(11,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_session`
--

DROP TABLE IF EXISTS `user_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_session` (
  `sessions_id_session` bigint NOT NULL,
  `users_id` bigint NOT NULL,
  KEY `FKhej1pljgw3bk5x9s1lmqnfrym` (`users_id`),
  KEY `FKjtefmfxna6gvxvcfe5hshfqqd` (`sessions_id_session`),
  CONSTRAINT `FKhej1pljgw3bk5x9s1lmqnfrym` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjtefmfxna6gvxvcfe5hshfqqd` FOREIGN KEY (`sessions_id_session`) REFERENCES `session` (`id_session`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_session`
--

LOCK TABLES `user_session` WRITE;
/*!40000 ALTER TABLE `user_session` DISABLE KEYS */;
INSERT INTO `user_session` VALUES (61,1),(61,2),(36,1),(36,2),(36,5),(46,5),(42,5),(62,1),(62,2),(62,5);
/*!40000 ALTER TABLE `user_session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-24 11:42:40
