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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proposition`
--

LOCK TABLES `proposition` WRITE;
/*!40000 ALTER TABLE `proposition` DISABLE KEYS */;
INSERT INTO `proposition` VALUES (17,'m2i',9),(18,'IT-Training',9),(19,'m2i',12),(20,'IT-Training',12),(21,'m2i',13),(22,'IT-Training',13),(23,'m2i',14),(24,'IT-Training',14),(25,'this',15),(26,'new',15),(27,'class',15),(28,'instance',15),(29,'extends',16),(30,'implements',16),(31,'inherits',16),(32,'super',16);
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (9,'IT-Training','quel est le nom du centre de formation?',9),(12,'IT-Training','quel est le nom du centre de formation?',12),(13,'IT-Training','quel est le nom du centre de formation?',13),(14,'IT-Training','Quel est le nom du centre de formation?',14),(15,'new','Quel mot-clé en Java est utilisé pour créer une nouvelle instance d’un objet ?',14),(16,'extends','Quel mot-clé est utilisé pour hériter d\'une classe en Java ?',14);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'2025-02-01',_binary '\0',_binary '\0',21,_binary '\0','2025-01-01',_binary '\0',_binary '\0',6,10),(2,'2025-03-01',_binary '\0',_binary '\0',3,_binary '\0','2025-02-01',_binary '\0',_binary '\0',10,10),(3,'2025-04-01',_binary '\0',_binary '\0',8,_binary '\0','2025-03-01',_binary '\0',_binary '\0',5,13),(4,'2025-05-01',_binary '\0',_binary '\0',23,_binary '\0','2025-04-01',_binary '\0',_binary '\0',2,1),(5,'2025-06-01',_binary '\0',_binary '\0',18,_binary '\0','2025-05-01',_binary '\0',_binary '\0',7,8),(6,'2025-02-01',_binary '\0',_binary '\0',29,_binary '\0','2025-01-01',_binary '\0',_binary '\0',5,15),(7,'2025-03-01',_binary '\0',_binary '\0',11,_binary '\0','2025-02-01',_binary '\0',_binary '\0',5,3),(8,'2025-04-01',_binary '\0',_binary '\0',4,_binary '\0','2025-03-01',_binary '\0',_binary '\0',2,4),(9,'2025-05-01',_binary '\0',_binary '\0',9,_binary '\0','2025-04-01',_binary '\0',_binary '\0',4,14),(10,'2025-06-01',_binary '\0',_binary '\0',16,_binary '\0','2025-05-01',_binary '\0',_binary '\0',9,2),(11,'2025-02-01',_binary '\0',_binary '\0',24,_binary '\0','2025-01-01',_binary '\0',_binary '\0',5,15),(12,'2025-03-01',_binary '\0',_binary '\0',20,_binary '\0','2025-02-01',_binary '\0',_binary '\0',9,13),(13,'2025-04-01',_binary '\0',_binary '\0',29,_binary '\0','2025-03-01',_binary '\0',_binary '\0',6,6),(14,'2025-05-01',_binary '\0',_binary '\0',12,_binary '\0','2025-04-01',_binary '\0',_binary '\0',9,5),(15,'2025-06-01',_binary '\0',_binary '\0',13,_binary '\0','2025-05-01',_binary '\0',_binary '\0',8,5),(16,'2025-02-01',_binary '\0',_binary '\0',12,_binary '\0','2025-01-01',_binary '\0',_binary '\0',1,3),(17,'2025-03-01',_binary '\0',_binary '\0',15,_binary '\0','2025-02-01',_binary '\0',_binary '\0',3,2),(18,'2025-04-01',_binary '\0',_binary '\0',17,_binary '\0','2025-03-01',_binary '\0',_binary '\0',3,1),(19,'2025-05-01',_binary '\0',_binary '\0',14,_binary '\0','2025-04-01',_binary '\0',_binary '\0',6,13),(20,'2025-06-01',_binary '\0',_binary '\0',11,_binary '\0','2025-05-01',_binary '\0',_binary '\0',6,8),(21,'2025-02-01',_binary '\0',_binary '\0',5,_binary '\0','2025-01-01',_binary '\0',_binary '\0',1,8),(22,'2025-03-01',_binary '\0',_binary '\0',19,_binary '\0','2025-02-01',_binary '\0',_binary '\0',3,4),(23,'2025-04-01',_binary '\0',_binary '\0',14,_binary '\0','2025-03-01',_binary '\0',_binary '\0',7,9),(24,'2025-05-01',_binary '\0',_binary '\0',21,_binary '\0','2025-04-01',_binary '\0',_binary '\0',6,8),(25,'2025-06-01',_binary '\0',_binary '\0',22,_binary '\0','2025-05-01',_binary '\0',_binary '\0',6,12),(26,'2025-02-01',_binary '\0',_binary '\0',13,_binary '\0','2025-01-01',_binary '\0',_binary '\0',5,6),(27,'2025-03-01',_binary '\0',_binary '\0',24,_binary '\0','2025-02-01',_binary '\0',_binary '\0',2,14),(28,'2025-04-01',_binary '\0',_binary '\0',26,_binary '\0','2025-03-01',_binary '\0',_binary '\0',7,10),(29,'2025-05-01',_binary '\0',_binary '\0',26,_binary '\0','2025-04-01',_binary '\0',_binary '\0',4,2),(30,'2025-06-01',_binary '\0',_binary '\0',6,_binary '\0','2025-05-01',_binary '\0',_binary '\0',3,13);
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
INSERT INTO `sub_theme` VALUES (1,'test','Java'),(2,'./assert/images/non.png','Dr Jacoby'),(3,'./assert/images/at.png','Andy Brennan'),(4,'./assert/images/et.png','Killer BOB'),(5,'./assert/images/est.png','Audrey Horne'),(6,'./assert/images/assumenda.png','Dale Cooper'),(7,'/images/nisi.png','Laura Palmer'),(8,'/images/pariatur.png','Jacques Renault'),(9,'/images/illum.png','Phillip Jeffries'),(10,'/images/laboriosam.png','Pete Martell');
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_user`
--

LOCK TABLES `test_user` WRITE;
/*!40000 ALTER TABLE `test_user` DISABLE KEYS */;
INSERT INTO `test_user` VALUES (9,5),(12,5),(13,5),(14,2);
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
INSERT INTO `theme` VALUES (4,'/images/java-logo.png','Languages de développement'),(23,'/images/java-logo.png','In Dubious Battle'),(24,'/images/java-logo.png','This Lime Tree Bower'),(25,'/images/java-logo.png','Little Hands Clapping'),(26,'/images/java-logo.png','Let Us Now Praise Famous Men'),(27,'/images/java-logo.png','For a Breath I Tarry');
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
INSERT INTO `theme_subtheme` VALUES (4,1),(4,2),(27,3),(25,4),(24,5),(4,6),(23,7),(4,8),(24,9),(26,10);
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,'# Laboriosam quod at qui voluptatem non exercitationem. \n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.\n- Quam vel nam. Consequatur cum pariatur harum quo et fuga. Est dicta ratione consequatur at.','/images/quis.png',_binary '',3415,'Thufir Hawat',14),(2,'Voluptatem omnis dolorem quaerat omnis omnis. Tenetur ut consequatur. Et et neque quisquam cumque quo. Et voluptatem est perspiciatis. Omnis corporis quia nobis consequatur vitae et ea.','/images/a.png',_binary '',8535.52,'Murbella',NULL),(3,'Expedita cum facere impedit doloribus. Nobis ea numquam vero enim pariatur. Minus non est alias omnis nam.','/images/sit.png',_binary '',7471.42,'Shaddam Corrino IV',NULL),(4,'Tenetur quam libero qui. Asperiores earum autem sed. Nam qui error voluptas itaque hic. Accusantium explicabo in. Qui assumenda omnis aspernatur sit consequuntur aliquam quasi.','/images/dignissimos.png',_binary '',785.2,'Hasimir Fenring',NULL),(5,'Consequuntur a vero adipisci et unde. Ut est quia natus debitis. Labore eum tempore. Dolorem ex autem tempore. Rem esse officia voluptas.','/images/repellendus.png',_binary '',7338.63,'Shadout Mapes',NULL),(6,'Dolorem ad placeat ea omnis ullam quis unde. Et et iure aliquam. Molestiae qui id dolores.','/images/excepturi.png',_binary '',3589.3,'Leto II Atreides',NULL),(7,'Error est maxime. Id quisquam dolor assumenda. Et consequatur sit molestias.','/images/necessitatibus.png',_binary '',5306.61,'Murbella',NULL),(8,'Ut culpa officiis ut quis. Numquam libero sed excepturi. Cum perspiciatis doloremque et cumque adipisci aut.','/images/tempore.png',_binary '',1619.9,'Siona Atreides',NULL),(9,'Adipisci perferendis ea culpa est porro aliquid. Nesciunt sed nihil soluta enim velit. Ea ipsa eaque est aut. Molestiae quis expedita ut velit.','/images/asperiores.png',_binary '',888.08,'Hasimir Fenring',NULL),(10,'Esse sint facere nostrum pariatur ea. Laudantium id tempore exercitationem qui aperiam eaque reiciendis. Deleniti et corporis consequatur sunt quia expedita rem. Delectus a vero possimus consequatur aliquid tempora corrupti.','/images/rem.png',_binary '',2179.88,'Thufir Hawat',NULL),(11,'Aut nemo delectus nihil esse consequatur commodi aperiam. Sit aut ut et. Est velit alias eveniet. Voluptatem necessitatibus ut. Aliquid est mollitia.','/images/et.png',_binary '',4452.85,'Miles Teg',NULL),(12,'Sequi recusandae laboriosam. Itaque in consequatur eveniet consectetur. Ut facere officia iure voluptatum. Voluptatem necessitatibus qui. Est quo ut ab hic.','/images/repellendus.png',_binary '',6715.88,'Miles Teg',NULL),(13,'Repellat in nihil eligendi. Tenetur rerum vel placeat quo quisquam illum. Laudantium vel voluptate. Repellendus fugit iste vero voluptatem quam distinctio voluptatum. At quisquam est iure corrupti.','/images/maxime.png',_binary '',1367.18,'Ilban Richese',NULL),(14,'Non quas fugiat perspiciatis ad esse ut. Quia recusandae rerum eum odit. Explicabo ut est laborum iure doloremque voluptate. Dignissimos molestiae at praesentium adipisci aut consequatur. Facilis molestiae adipisci asperiores.','/images/deleniti.png',_binary '',849.87,'Thufir Hawat',NULL),(15,'Dicta id nam aut quae voluptas. Corrupti velit ut. Laborum et necessitatibus. Veniam laboriosam laborum quasi aliquam voluptate.','/images/vel.png',_binary '',8023.8,'Wellington Yueh',NULL),(18,'# Vous pouvez écrire avec la syntaxe markdown.','/images/6c8b667d-8b69-4558-940e-0fde1d03e060.png',_binary '',5,'test image',14),(19,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n- test','/images/5fa0c401-3efe-4d6a-b1b3-948b63f21f05.png',_binary '',10000,'formation CDA Java',NULL),(39,'# Vous pouvez écrire avec la syntaxe markdown.\n\n- test\n',NULL,_binary '',0,'le css c\'est fini',NULL);
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
INSERT INTO `training_subtheme` VALUES (1,1),(2,10),(3,5),(4,4),(5,3),(6,6),(7,2),(8,9),(9,8),(10,5),(11,2),(12,10),(13,1),(14,5),(15,10),(1,10),(19,1),(19,2),(19,3),(19,4),(39,7);
/*!40000 ALTER TABLE `training_subtheme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-19 14:17:54
