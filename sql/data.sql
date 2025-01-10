CREATE DATABASE  IF NOT EXISTS `projet_cda_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projet_cda_db`;
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
) ENGINE=InnoDB AUTO_INCREMENT=717 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (377,'2025-02-03','17:30:00.000000','14:30:00.000000',64),(378,'2025-02-10','17:30:00.000000','14:30:00.000000',64),(379,'2025-02-17','17:30:00.000000','14:30:00.000000',64),(380,'2025-02-24','17:30:00.000000','14:30:00.000000',64),(381,'2025-03-03','17:30:00.000000','14:30:00.000000',64),(382,'2025-03-10','17:30:00.000000','14:30:00.000000',64),(383,'2025-02-04','17:30:00.000000','13:30:00.000000',64),(384,'2025-02-11','17:30:00.000000','13:30:00.000000',64),(385,'2025-02-18','17:30:00.000000','13:30:00.000000',64),(386,'2025-02-25','17:30:00.000000','13:30:00.000000',64),(387,'2025-03-04','17:30:00.000000','13:30:00.000000',64),(388,'2025-03-11','17:30:00.000000','13:30:00.000000',64),(389,'2025-03-03','17:30:00.000000','14:30:00.000000',65),(390,'2025-03-10','17:30:00.000000','14:30:00.000000',65),(391,'2025-03-17','17:30:00.000000','14:30:00.000000',65),(392,'2025-03-24','17:30:00.000000','14:30:00.000000',65),(393,'2025-03-31','17:30:00.000000','14:30:00.000000',65),(394,'2025-04-07','17:30:00.000000','14:30:00.000000',65),(395,'2025-04-14','17:30:00.000000','14:30:00.000000',65),(396,'2025-03-04','17:30:00.000000','13:30:00.000000',65),(397,'2025-03-11','17:30:00.000000','13:30:00.000000',65),(398,'2025-03-18','17:30:00.000000','13:30:00.000000',65),(399,'2025-03-25','17:30:00.000000','13:30:00.000000',65),(400,'2025-04-01','17:30:00.000000','13:30:00.000000',65),(401,'2025-04-08','17:30:00.000000','13:30:00.000000',65),(402,'2025-04-15','17:30:00.000000','13:30:00.000000',65),(403,'2025-04-07','17:30:00.000000','14:30:00.000000',66),(404,'2025-04-14','17:30:00.000000','14:30:00.000000',66),(405,'2025-04-21','17:30:00.000000','14:30:00.000000',66),(406,'2025-04-28','17:30:00.000000','14:30:00.000000',66),(407,'2025-05-05','17:30:00.000000','14:30:00.000000',66),(408,'2025-05-12','17:30:00.000000','14:30:00.000000',66),(409,'2025-04-01','17:30:00.000000','13:30:00.000000',66),(410,'2025-04-08','17:30:00.000000','13:30:00.000000',66),(411,'2025-04-15','17:30:00.000000','13:30:00.000000',66),(412,'2025-04-22','17:30:00.000000','13:30:00.000000',66),(413,'2025-04-29','17:30:00.000000','13:30:00.000000',66),(414,'2025-05-06','17:30:00.000000','13:30:00.000000',66),(415,'2025-05-13','17:30:00.000000','13:30:00.000000',66),(416,'2025-05-05','17:30:00.000000','14:30:00.000000',67),(417,'2025-05-12','17:30:00.000000','14:30:00.000000',67),(418,'2025-05-19','17:30:00.000000','14:30:00.000000',67),(419,'2025-05-26','17:30:00.000000','14:30:00.000000',67),(420,'2025-06-02','17:30:00.000000','14:30:00.000000',67),(421,'2025-06-09','17:30:00.000000','14:30:00.000000',67),(422,'2025-05-06','17:30:00.000000','13:30:00.000000',67),(423,'2025-05-13','17:30:00.000000','13:30:00.000000',67),(424,'2025-05-20','17:30:00.000000','13:30:00.000000',67),(425,'2025-05-27','17:30:00.000000','13:30:00.000000',67),(426,'2025-06-03','17:30:00.000000','13:30:00.000000',67),(427,'2025-06-10','17:30:00.000000','13:30:00.000000',67),(428,'2025-06-02','17:30:00.000000','14:30:00.000000',68),(429,'2025-06-09','17:30:00.000000','14:30:00.000000',68),(430,'2025-06-16','17:30:00.000000','14:30:00.000000',68),(431,'2025-06-23','17:30:00.000000','14:30:00.000000',68),(432,'2025-06-30','17:30:00.000000','14:30:00.000000',68),(433,'2025-07-07','17:30:00.000000','14:30:00.000000',68),(434,'2025-07-14','17:30:00.000000','14:30:00.000000',68),(435,'2025-06-03','17:30:00.000000','13:30:00.000000',68),(436,'2025-06-10','17:30:00.000000','13:30:00.000000',68),(437,'2025-06-17','17:30:00.000000','13:30:00.000000',68),(438,'2025-06-24','17:30:00.000000','13:30:00.000000',68),(439,'2025-07-01','17:30:00.000000','13:30:00.000000',68),(440,'2025-07-08','17:30:00.000000','13:30:00.000000',68),(441,'2025-07-15','17:30:00.000000','13:30:00.000000',68),(442,'2025-02-03','17:30:00.000000','14:30:00.000000',69),(443,'2025-02-10','17:30:00.000000','14:30:00.000000',69),(444,'2025-02-17','17:30:00.000000','14:30:00.000000',69),(445,'2025-02-24','17:30:00.000000','14:30:00.000000',69),(446,'2025-03-03','17:30:00.000000','14:30:00.000000',69),(447,'2025-03-10','17:30:00.000000','14:30:00.000000',69),(448,'2025-02-04','17:30:00.000000','13:30:00.000000',69),(449,'2025-02-11','17:30:00.000000','13:30:00.000000',69),(450,'2025-02-18','17:30:00.000000','13:30:00.000000',69),(451,'2025-02-25','17:30:00.000000','13:30:00.000000',69),(452,'2025-03-04','17:30:00.000000','13:30:00.000000',69),(453,'2025-03-11','17:30:00.000000','13:30:00.000000',69),(454,'2025-03-03','17:30:00.000000','14:30:00.000000',70),(455,'2025-03-10','17:30:00.000000','14:30:00.000000',70),(456,'2025-03-17','17:30:00.000000','14:30:00.000000',70),(457,'2025-03-24','17:30:00.000000','14:30:00.000000',70),(458,'2025-03-31','17:30:00.000000','14:30:00.000000',70),(459,'2025-04-07','17:30:00.000000','14:30:00.000000',70),(460,'2025-04-14','17:30:00.000000','14:30:00.000000',70),(461,'2025-03-04','17:30:00.000000','13:30:00.000000',70),(462,'2025-03-11','17:30:00.000000','13:30:00.000000',70),(463,'2025-03-18','17:30:00.000000','13:30:00.000000',70),(464,'2025-03-25','17:30:00.000000','13:30:00.000000',70),(465,'2025-04-01','17:30:00.000000','13:30:00.000000',70),(466,'2025-04-08','17:30:00.000000','13:30:00.000000',70),(467,'2025-04-15','17:30:00.000000','13:30:00.000000',70),(468,'2025-04-07','17:30:00.000000','14:30:00.000000',71),(469,'2025-04-14','17:30:00.000000','14:30:00.000000',71),(470,'2025-04-21','17:30:00.000000','14:30:00.000000',71),(471,'2025-04-28','17:30:00.000000','14:30:00.000000',71),(472,'2025-05-05','17:30:00.000000','14:30:00.000000',71),(473,'2025-05-12','17:30:00.000000','14:30:00.000000',71),(474,'2025-04-01','17:30:00.000000','13:30:00.000000',71),(475,'2025-04-08','17:30:00.000000','13:30:00.000000',71),(476,'2025-04-15','17:30:00.000000','13:30:00.000000',71),(477,'2025-04-22','17:30:00.000000','13:30:00.000000',71),(478,'2025-04-29','17:30:00.000000','13:30:00.000000',71),(479,'2025-05-06','17:30:00.000000','13:30:00.000000',71),(480,'2025-05-13','17:30:00.000000','13:30:00.000000',71),(481,'2025-05-05','17:30:00.000000','14:30:00.000000',72),(482,'2025-05-12','17:30:00.000000','14:30:00.000000',72),(483,'2025-05-19','17:30:00.000000','14:30:00.000000',72),(484,'2025-05-26','17:30:00.000000','14:30:00.000000',72),(485,'2025-06-02','17:30:00.000000','14:30:00.000000',72),(486,'2025-06-09','17:30:00.000000','14:30:00.000000',72),(487,'2025-05-06','17:30:00.000000','13:30:00.000000',72),(488,'2025-05-13','17:30:00.000000','13:30:00.000000',72),(489,'2025-05-20','17:30:00.000000','13:30:00.000000',72),(490,'2025-05-27','17:30:00.000000','13:30:00.000000',72),(491,'2025-06-03','17:30:00.000000','13:30:00.000000',72),(492,'2025-06-10','17:30:00.000000','13:30:00.000000',72),(493,'2025-06-02','17:30:00.000000','14:30:00.000000',73),(494,'2025-06-09','17:30:00.000000','14:30:00.000000',73),(495,'2025-06-16','17:30:00.000000','14:30:00.000000',73),(496,'2025-06-23','17:30:00.000000','14:30:00.000000',73),(497,'2025-06-30','17:30:00.000000','14:30:00.000000',73),(498,'2025-07-07','17:30:00.000000','14:30:00.000000',73),(499,'2025-07-14','17:30:00.000000','14:30:00.000000',73),(500,'2025-06-03','17:30:00.000000','13:30:00.000000',73),(501,'2025-06-10','17:30:00.000000','13:30:00.000000',73),(502,'2025-06-17','17:30:00.000000','13:30:00.000000',73),(503,'2025-06-24','17:30:00.000000','13:30:00.000000',73),(504,'2025-07-01','17:30:00.000000','13:30:00.000000',73),(505,'2025-07-08','17:30:00.000000','13:30:00.000000',73),(506,'2025-07-15','17:30:00.000000','13:30:00.000000',73),(507,'2024-01-01','17:30:00.000000','14:30:00.000000',74),(508,'2024-01-08','17:30:00.000000','14:30:00.000000',74),(509,'2024-01-15','17:30:00.000000','14:30:00.000000',74),(510,'2024-01-22','17:30:00.000000','14:30:00.000000',74),(511,'2024-01-29','17:30:00.000000','14:30:00.000000',74),(512,'2024-02-05','17:30:00.000000','14:30:00.000000',74),(513,'2024-02-12','17:30:00.000000','14:30:00.000000',74),(514,'2024-02-19','17:30:00.000000','14:30:00.000000',74),(515,'2024-02-26','17:30:00.000000','14:30:00.000000',74),(516,'2024-03-04','17:30:00.000000','14:30:00.000000',74),(517,'2024-03-11','17:30:00.000000','14:30:00.000000',74),(518,'2024-03-18','17:30:00.000000','14:30:00.000000',74),(519,'2024-03-25','17:30:00.000000','14:30:00.000000',74),(520,'2024-04-01','17:30:00.000000','14:30:00.000000',74),(521,'2024-04-08','17:30:00.000000','14:30:00.000000',74),(522,'2024-04-15','17:30:00.000000','14:30:00.000000',74),(523,'2024-04-22','17:30:00.000000','14:30:00.000000',74),(524,'2024-04-29','17:30:00.000000','14:30:00.000000',74),(525,'2024-05-06','17:30:00.000000','14:30:00.000000',74),(526,'2024-05-13','17:30:00.000000','14:30:00.000000',74),(527,'2024-05-20','17:30:00.000000','14:30:00.000000',74),(528,'2024-05-27','17:30:00.000000','14:30:00.000000',74),(529,'2024-06-03','17:30:00.000000','14:30:00.000000',74),(530,'2024-06-10','17:30:00.000000','14:30:00.000000',74),(531,'2024-06-17','17:30:00.000000','14:30:00.000000',74),(532,'2024-06-24','17:30:00.000000','14:30:00.000000',74),(533,'2024-07-01','17:30:00.000000','14:30:00.000000',74),(534,'2024-07-08','17:30:00.000000','14:30:00.000000',74),(535,'2024-07-15','17:30:00.000000','14:30:00.000000',74),(536,'2024-07-22','17:30:00.000000','14:30:00.000000',74),(537,'2024-07-29','17:30:00.000000','14:30:00.000000',74),(538,'2024-08-05','17:30:00.000000','14:30:00.000000',74),(539,'2024-08-12','17:30:00.000000','14:30:00.000000',74),(540,'2024-08-19','17:30:00.000000','14:30:00.000000',74),(541,'2024-08-26','17:30:00.000000','14:30:00.000000',74),(542,'2024-09-02','17:30:00.000000','14:30:00.000000',74),(543,'2024-09-09','17:30:00.000000','14:30:00.000000',74),(544,'2024-09-16','17:30:00.000000','14:30:00.000000',74),(545,'2024-09-23','17:30:00.000000','14:30:00.000000',74),(546,'2024-09-30','17:30:00.000000','14:30:00.000000',74),(547,'2024-10-07','17:30:00.000000','14:30:00.000000',74),(548,'2024-10-14','17:30:00.000000','14:30:00.000000',74),(549,'2024-10-21','17:30:00.000000','14:30:00.000000',74),(550,'2024-10-28','17:30:00.000000','14:30:00.000000',74),(551,'2024-11-04','17:30:00.000000','14:30:00.000000',74),(552,'2024-11-11','17:30:00.000000','14:30:00.000000',74),(553,'2024-11-18','17:30:00.000000','14:30:00.000000',74),(554,'2024-11-25','17:30:00.000000','14:30:00.000000',74),(555,'2024-12-02','17:30:00.000000','14:30:00.000000',74),(556,'2024-12-09','17:30:00.000000','14:30:00.000000',74),(557,'2024-12-16','17:30:00.000000','14:30:00.000000',74),(558,'2024-12-23','17:30:00.000000','14:30:00.000000',74),(559,'2024-12-30','17:30:00.000000','14:30:00.000000',74),(560,'2025-01-06','17:30:00.000000','14:30:00.000000',74),(561,'2025-01-13','17:30:00.000000','14:30:00.000000',74),(562,'2025-01-20','17:30:00.000000','14:30:00.000000',74),(563,'2025-01-27','17:30:00.000000','14:30:00.000000',74),(564,'2024-01-02','17:30:00.000000','13:30:00.000000',74),(565,'2024-01-09','17:30:00.000000','13:30:00.000000',74),(566,'2024-01-16','17:30:00.000000','13:30:00.000000',74),(567,'2024-01-23','17:30:00.000000','13:30:00.000000',74),(568,'2024-01-30','17:30:00.000000','13:30:00.000000',74),(569,'2024-02-06','17:30:00.000000','13:30:00.000000',74),(570,'2024-02-13','17:30:00.000000','13:30:00.000000',74),(571,'2024-02-20','17:30:00.000000','13:30:00.000000',74),(572,'2024-02-27','17:30:00.000000','13:30:00.000000',74),(573,'2024-03-05','17:30:00.000000','13:30:00.000000',74),(574,'2024-03-12','17:30:00.000000','13:30:00.000000',74),(575,'2024-03-19','17:30:00.000000','13:30:00.000000',74),(576,'2024-03-26','17:30:00.000000','13:30:00.000000',74),(577,'2024-04-02','17:30:00.000000','13:30:00.000000',74),(578,'2024-04-09','17:30:00.000000','13:30:00.000000',74),(579,'2024-04-16','17:30:00.000000','13:30:00.000000',74),(580,'2024-04-23','17:30:00.000000','13:30:00.000000',74),(581,'2024-04-30','17:30:00.000000','13:30:00.000000',74),(582,'2024-05-07','17:30:00.000000','13:30:00.000000',74),(583,'2024-05-14','17:30:00.000000','13:30:00.000000',74),(584,'2024-05-21','17:30:00.000000','13:30:00.000000',74),(585,'2024-05-28','17:30:00.000000','13:30:00.000000',74),(586,'2024-06-04','17:30:00.000000','13:30:00.000000',74),(587,'2024-06-11','17:30:00.000000','13:30:00.000000',74),(588,'2024-06-18','17:30:00.000000','13:30:00.000000',74),(589,'2024-06-25','17:30:00.000000','13:30:00.000000',74),(590,'2024-07-02','17:30:00.000000','13:30:00.000000',74),(591,'2024-07-09','17:30:00.000000','13:30:00.000000',74),(592,'2024-07-16','17:30:00.000000','13:30:00.000000',74),(593,'2024-07-23','17:30:00.000000','13:30:00.000000',74),(594,'2024-07-30','17:30:00.000000','13:30:00.000000',74),(595,'2024-08-06','17:30:00.000000','13:30:00.000000',74),(596,'2024-08-13','17:30:00.000000','13:30:00.000000',74),(597,'2024-08-20','17:30:00.000000','13:30:00.000000',74),(598,'2024-08-27','17:30:00.000000','13:30:00.000000',74),(599,'2024-09-03','17:30:00.000000','13:30:00.000000',74),(600,'2024-09-10','17:30:00.000000','13:30:00.000000',74),(601,'2024-09-17','17:30:00.000000','13:30:00.000000',74),(602,'2024-09-24','17:30:00.000000','13:30:00.000000',74),(603,'2024-10-01','17:30:00.000000','13:30:00.000000',74),(604,'2024-10-08','17:30:00.000000','13:30:00.000000',74),(605,'2024-10-15','17:30:00.000000','13:30:00.000000',74),(606,'2024-10-22','17:30:00.000000','13:30:00.000000',74),(607,'2024-10-29','17:30:00.000000','13:30:00.000000',74),(608,'2024-11-05','17:30:00.000000','13:30:00.000000',74),(609,'2024-11-12','17:30:00.000000','13:30:00.000000',74),(610,'2024-11-19','17:30:00.000000','13:30:00.000000',74),(611,'2024-11-26','17:30:00.000000','13:30:00.000000',74),(612,'2024-12-03','17:30:00.000000','13:30:00.000000',74),(613,'2024-12-10','17:30:00.000000','13:30:00.000000',74),(614,'2024-12-17','17:30:00.000000','13:30:00.000000',74),(615,'2024-12-24','17:30:00.000000','13:30:00.000000',74),(616,'2024-12-31','17:30:00.000000','13:30:00.000000',74),(617,'2025-01-07','17:30:00.000000','13:30:00.000000',74),(618,'2025-01-14','17:30:00.000000','13:30:00.000000',74),(619,'2025-01-21','17:30:00.000000','13:30:00.000000',74),(620,'2025-01-28','17:30:00.000000','13:30:00.000000',74);
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `note`
--

LOCK TABLES `note` WRITE;
/*!40000 ALTER TABLE `note` DISABLE KEYS */;
INSERT INTO `note` VALUES (11,2,_binary '',14,1),(12,3,_binary '',14,2),(13,3,_binary '',14,5),(31,3,_binary '',14,11),(32,3,_binary '',14,12);
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
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presence`
--

LOCK TABLES `presence` WRITE;
/*!40000 ALTER TABLE `presence` DISABLE KEYS */;
INSERT INTO `presence` VALUES (81,_binary '\0',507,1),(82,_binary '\0',508,1),(83,_binary '\0',509,1),(84,_binary '\0',510,1),(85,_binary '\0',511,1),(86,_binary '\0',512,1),(87,_binary '\0',513,1),(88,_binary '\0',514,1),(89,_binary '\0',515,1),(90,_binary '\0',516,1),(91,_binary '\0',517,1),(92,_binary '\0',518,1),(93,_binary '\0',519,1),(94,_binary '\0',520,1),(95,_binary '\0',521,1),(96,_binary '\0',522,1),(97,_binary '\0',523,1),(98,_binary '\0',524,1),(99,_binary '\0',525,1),(100,_binary '\0',526,1),(101,_binary '\0',527,1),(102,_binary '\0',528,1),(103,_binary '\0',529,1),(104,_binary '\0',530,1),(105,_binary '\0',531,1),(106,_binary '\0',532,1),(107,_binary '\0',533,1),(108,_binary '\0',534,1),(109,_binary '\0',535,1),(110,_binary '\0',536,1),(111,_binary '\0',537,1),(112,_binary '\0',538,1),(113,_binary '\0',539,1),(114,_binary '\0',540,1),(115,_binary '\0',541,1),(116,_binary '\0',542,1),(117,_binary '\0',543,1),(118,_binary '\0',544,1),(119,_binary '\0',545,1),(120,_binary '\0',546,1),(121,_binary '\0',547,1),(122,_binary '\0',548,1),(123,_binary '\0',549,1),(124,_binary '\0',550,1),(125,_binary '\0',551,1),(126,_binary '\0',552,1),(127,_binary '\0',553,1),(128,_binary '\0',554,1),(129,_binary '\0',555,1),(130,_binary '\0',556,1),(131,_binary '\0',557,1),(132,_binary '\0',558,1),(133,_binary '\0',559,1),(134,_binary '\0',560,1),(135,_binary '\0',561,1),(136,_binary '\0',562,1),(137,_binary '\0',563,1),(138,_binary '\0',564,1),(139,_binary '\0',565,1),(140,_binary '\0',566,1),(141,_binary '\0',567,1),(142,_binary '\0',568,1),(143,_binary '\0',569,1),(144,_binary '\0',570,1),(145,_binary '\0',571,1),(146,_binary '\0',572,1),(147,_binary '\0',573,1),(148,_binary '\0',574,1),(149,_binary '\0',575,1),(150,_binary '\0',576,1),(151,_binary '\0',577,1),(152,_binary '\0',578,1),(153,_binary '\0',579,1),(154,_binary '\0',580,1),(155,_binary '\0',581,1),(156,_binary '\0',582,1),(157,_binary '\0',583,1),(158,_binary '\0',584,1),(159,_binary '\0',585,1),(160,_binary '\0',586,1),(161,_binary '\0',587,1),(162,_binary '\0',588,1),(163,_binary '\0',589,1),(164,_binary '\0',590,1),(165,_binary '\0',591,1),(166,_binary '\0',592,1),(167,_binary '\0',593,1),(168,_binary '\0',594,1),(169,_binary '\0',595,1),(170,_binary '\0',596,1),(171,_binary '\0',597,1),(172,_binary '\0',598,1),(173,_binary '\0',599,1),(174,_binary '\0',600,1),(175,_binary '\0',601,1),(176,_binary '\0',602,1),(177,_binary '\0',603,1),(178,_binary '\0',604,1),(179,_binary '\0',605,1),(180,_binary '\0',606,1),(181,_binary '\0',607,1),(182,_binary '\0',608,1),(183,_binary '\0',609,1),(184,_binary '\0',610,1),(185,_binary '\0',611,1),(186,_binary '\0',612,1),(187,_binary '\0',613,1),(188,_binary '\0',614,1),(189,_binary '\0',615,1),(190,_binary '\0',616,1),(191,_binary '\0',617,1),(192,_binary '\0',618,1),(193,_binary '\0',619,1),(194,_binary '\0',620,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (64,'2025-03-15',_binary '\0',_binary '\0',17,_binary '\0','2025-02-01',_binary '\0',_binary '\0',9,3),(65,'2025-04-15',_binary '\0',_binary '\0',18,_binary '\0','2025-03-01',_binary '\0',_binary '\0',10,18),(66,'2025-05-15',_binary '\0',_binary '\0',12,_binary '\0','2025-04-01',_binary '\0',_binary '\0',4,43),(67,'2025-06-15',_binary '\0',_binary '\0',15,_binary '\0','2025-05-01',_binary '\0',_binary '\0',10,10),(68,'2025-07-15',_binary '\0',_binary '\0',26,_binary '\0','2025-06-01',_binary '\0',_binary '\0',5,11),(69,'2025-03-15',_binary '\0',_binary '\0',10,_binary '\0','2025-02-01',_binary '\0',_binary '\0',2,11),(70,'2025-04-15',_binary '\0',_binary '\0',29,_binary '\0','2025-03-01',_binary '\0',_binary '\0',4,42),(71,'2025-05-15',_binary '\0',_binary '\0',14,_binary '\0','2025-04-01',_binary '\0',_binary '\0',1,5),(72,'2025-06-15',_binary '\0',_binary '\0',23,_binary '\0','2025-05-01',_binary '\0',_binary '\0',4,39),(73,'2025-07-15',_binary '\0',_binary '\0',9,_binary '\0','2025-06-01',_binary '\0',_binary '\0',7,10),(74,'2025-02-01',_binary '\0',_binary '\0',10,_binary '\0','2024-01-01',_binary '\0',_binary '\0',1,1);
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
INSERT INTO `training` VALUES (1,'# Laboriosam quod at qui voluptatem non exercitationem. \n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.\n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',3415,'CDA Java/Js',14),(2,'Voluptatem omnis dolorem quaerat omnis omnis. Tenetur ut consequatur. Et et neque quisquam cumque quo. Et voluptatem est perspiciatis. Omnis corporis quia nobis consequatur vitae et ea.','/images/javascript-logo-png.png',_binary '',8535.52,'fomation javascript',NULL),(3,'Expedita cum facere impedit doloribus. Nobis ea numquam vero enim pariatur. Minus non est alias omnis nam.','/images/Gestion-de-projet-3658866287.jpg',_binary '',7471.42,'formation chef de projet',NULL),(4,'Tenetur quam libero qui. Asperiores earum autem sed. Nam qui error voluptas itaque hic. Accusantium explicabo in. Qui assumenda omnis aspernatur sit consequuntur aliquam quasi.','/images/system-3810164661.jpg',_binary '',785.2,'formation linux',NULL),(5,'Consequuntur a vero adipisci et unde. Ut est quia natus debitis. Labore eum tempore. Dolorem ex autem tempore. Rem esse officia voluptas.','/images/logiciels-gratuits.jpg',_binary '',7338.63,'excel',NULL),(6,'Dolorem ad placeat ea omnis ullam quis unde. Et et iure aliquam. Molestiae qui id dolores.','/images/403-4039227_c-language-logo-png-transparent-png-2443893358.png',_binary '',3589.3,'formation C#',NULL),(7,'Error est maxime. Id quisquam dolor assumenda. Et consequatur sit molestias.','/images/python-logo.png',_binary '',5306.61,'formation python',NULL),(8,'Ut culpa officiis ut quis. Numquam libero sed excepturi. Cum perspiciatis doloremque et cumque adipisci aut.','/images/Gestion-de-projet-3658866287.jpg',_binary '',1619.9,'formation agile',NULL),(9,'Adipisci perferendis ea culpa est porro aliquid. Nesciunt sed nihil soluta enim velit. Ea ipsa eaque est aut. Molestiae quis expedita ut velit.','/images/php_PNG18-1060352843.png',_binary '',888.08,'formation PHP',NULL),(10,'Esse sint facere nostrum pariatur ea. Laudantium id tempore exercitationem qui aperiam eaque reiciendis. Deleniti et corporis consequatur sunt quia expedita rem. Delectus a vero possimus consequatur aliquid tempora corrupti.','/images/Gestion-de-projet-3658866287.jpg',_binary '',2179.88,'chef de projet 2',NULL),(11,'Aut nemo delectus nihil esse consequatur commodi aperiam. Sit aut ut et. Est velit alias eveniet. Voluptatem necessitatibus ut. Aliquid est mollitia.','/images/python-logo.png',_binary '',4452.85,'initiation python',NULL),(12,'Sequi recusandae laboriosam. Itaque in consequatur eveniet consectetur. Ut facere officia iure voluptatum. Voluptatem necessitatibus qui. Est quo ut ab hic.','/images/javascript-logo-png.png',_binary '',6715.88,'initiation js',NULL),(13,'Repellat in nihil eligendi. Tenetur rerum vel placeat quo quisquam illum. Laudantium vel voluptate. Repellendus fugit iste vero voluptatem quam distinctio voluptatum. At quisquam est iure corrupti.','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',1367.18,'formation Java',14),(14,'Non quas fugiat perspiciatis ad esse ut. Quia recusandae rerum eum odit. Explicabo ut est laborum iure doloremque voluptate. Dignissimos molestiae at praesentium adipisci aut consequatur. Facilis molestiae adipisci asperiores.','/images/Gestion-de-projet-3658866287.jpg',_binary '',849.87,'chef de projet 3',NULL),(15,'Dicta id nam aut quae voluptas. Corrupti velit ut. Laborum et necessitatibus. Veniam laboriosam laborum quasi aliquam voluptate.','/images/logiciels-gratuits.jpg',_binary '',8023.8,'suite adobe',NULL),(18,'# Vous pouvez écrire avec la syntaxe markdown.','/images/6c8b667d-8b69-4558-940e-0fde1d03e060.png',_binary '',5,'test image',14),(19,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n- test','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',10000,'CDA Java-python',14),(39,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n','/images/telecomm-1733645639.jpg',_binary '',0,'formation sécurité',NULL),(41,'# Vous pouvez écrire avec la syntaxe markdown.','/images/bc2e5dd0-58c3-4f31-ac43-b294c149cbd7.png',_binary '',5,'test docker',15),(42,'# Vous pouvez écrire avec la syntaxe markdown.','/images/python-logo.png',_binary '',0,'python dwwm',NULL),(43,'# Vous pouvez écrire avec la syntaxe markdown.\n- j écris en md\n','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',5,'initiation Java',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user@user.com','user','user',0,'$2a$10$p.b6gUKfC0x6.FkXMq7y/eKuyq5euaDDGNZHqFsXr6OcS5V4w.8p.',''),(2,'user2@user.com','user','user',0,'$2a$10$no7I4FdDUb553WoZ8gCWueoHCU3UXUV1gTyOFQYZjy6D.cyzm9Mxa',NULL),(3,'admin@admin.com','admin','admin',0,'$2a$10$YVjbIL4SdwotEgwOKlKQPeHqcxzVvWlnvZ9jj79QGCQRNeAEh1WES',NULL),(5,'user3@user.com','user','user',0,'$2a$10$CKNDJG.ChvXET5WNw7HBWeHrk1YhurpD9hbf3RmpUyvNy5LpmC8fa',NULL),(8,'user4@user.com','user','user',0,'$2a$10$iPUKD6B.fKVnquho.kYFJeO2/.OH32543E0s2XQtABID9ZLL4TO6i',NULL),(11,'user5@user.com','user','user',0,'$2a$10$w81E/ARr6f.YRdAJH/XEE.5KiHYovQQKCAddOK5KlxvXPugNOeY/a',NULL),(12,'user6@user.com','user','user',0,'$2a$10$ZGYwAryiSgrYpDayDMaseumX/QAgJvbwaMSmYd9njLxymsgXvfKlu',NULL);
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
INSERT INTO `user_role` VALUES (1,1),(2,1),(3,1),(3,3),(5,1),(8,1),(11,1),(12,1);
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
INSERT INTO `user_session` VALUES (74,1);
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

-- Dump completed on 2025-01-10 10:13:22
