-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (x86_64)
--
-- Host: localhost    Database: budgetplanner
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `benefits_and_tax_credits`
--

DROP TABLE IF EXISTS `benefits_and_tax_credits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benefits_and_tax_credits` (
  `attendance_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `carers_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `child_benefit_by_id` decimal(38,2) DEFAULT NULL,
  `child_tax_credit_by_id` decimal(38,2) DEFAULT NULL,
  `disability_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `employment_support_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `housing_benefit_by_id` decimal(38,2) DEFAULT NULL,
  `job_seekers_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `maternity_allowance_by_id` decimal(38,2) DEFAULT NULL,
  `universal_credit_by_id` decimal(38,2) DEFAULT NULL,
  `working_tax_credit_by_id` decimal(38,2) DEFAULT NULL,
  `benefits_and_tax_credits` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`benefits_and_tax_credits`),
  KEY `FKjcy8wf4eauqdygkk7ijxbemux` (`user_id`),
  CONSTRAINT `FKjcy8wf4eauqdygkk7ijxbemux` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benefits_and_tax_credits`
--

LOCK TABLES `benefits_and_tax_credits` WRITE;
/*!40000 ALTER TABLE `benefits_and_tax_credits` DISABLE KEYS */;
INSERT INTO `benefits_and_tax_credits` VALUES (80.00,90.00,20.00,30.00,0.00,40.00,110.00,0.00,130.00,0.00,50.00,_binary '\'√†TÜf@S∑s8Çe ',NULL,'monthly'),(80.00,100.00,60.00,60.00,0.00,30.00,150.00,0.00,100.00,0.00,40.00,_binary '+\Ã\Â\ÛE<ïikA˛3¯',NULL,'monthly'),(80.00,90.00,80.00,80.00,0.00,30.00,10.00,0.00,150.00,0.00,50.00,_binary '<\Î:ô\Á\·@àõT∫W:ö%>',NULL,'monthly');
/*!40000 ALTER TABLE `benefits_and_tax_credits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `council_tax_by_id` decimal(38,2) DEFAULT NULL,
  `groceries_by_id` decimal(38,2) DEFAULT NULL,
  `insurance_by_id` decimal(38,2) DEFAULT NULL,
  `mortgage_by_id` decimal(38,2) DEFAULT NULL,
  `mortgage_endowment_by_id` decimal(38,2) DEFAULT NULL,
  `rent_by_id` decimal(38,2) DEFAULT NULL,
  `utilities_by_id` decimal(38,2) DEFAULT NULL,
  `bills_id` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bills_id`),
  KEY `FKecwqta9n5jvflyf9br1tpu68d` (`user_id`),
  CONSTRAINT `FKecwqta9n5jvflyf9br1tpu68d` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (100.00,400.00,200.00,500.00,600.00,1400.00,800.00,_binary '\"*\Ï\˜CÀÜ:)ò∏,\‡\◊',NULL,'monthly'),(1200.00,400.00,1100.00,11400.00,1500.00,11300.00,1700.00,_binary 'pÀ∂u\–\ZM[è\»\‘$\\\Ôù',NULL,'monthly'),(1100.00,500.00,1200.00,11500.00,1600.00,11400.00,1800.00,_binary 'Å-˙\‡VLù)(nîQªµ',NULL,'monthly');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income` (
  `salary_after_taxes_by_id` decimal(38,2) DEFAULT NULL,
  `self_employment_income_by_id` decimal(38,2) DEFAULT NULL,
  `statutory_maternity_pay_by_id` decimal(38,2) DEFAULT NULL,
  `statutory_sick_pay_by_id` decimal(38,2) DEFAULT NULL,
  `income_id` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`income_id`),
  KEY `FK8qxqvv9oy66uuotjtfvqu1fxy` (`user_id`),
  CONSTRAINT `FK8qxqvv9oy66uuotjtfvqu1fxy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES (15000.00,450.00,100.00,560.00,_binary 'a\'B\ÊµJpåQa∂ÜçT',NULL,'monthly'),(20000.00,500.00,500.00,500.00,_binary '£\"vv\˜êGßü\œ\“/ô@\Â',NULL,'monthly'),(440000.00,1400.00,0.00,50.00,_binary '¡Rÿ¨k≤A≠\–UèΩ÷¨',NULL,'monthly'),(10000.00,400.00,100.00,100.00,_binary '\‚q\ÎC™N§ù˚\÷-Ñ\\\”6',NULL,'monthly');
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leisure`
--

DROP TABLE IF EXISTS `leisure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leisure` (
  `dining_out_by_id` decimal(38,2) DEFAULT NULL,
  `entertainment_by_id` decimal(38,2) DEFAULT NULL,
  `sports_membership_by_id` decimal(38,2) DEFAULT NULL,
  `travel_by_id` decimal(38,2) DEFAULT NULL,
  `leisure_id` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`leisure_id`),
  KEY `FK5j2kl1vxv3os3xbwu1ggmhv6b` (`user_id`),
  CONSTRAINT `FK5j2kl1vxv3os3xbwu1ggmhv6b` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leisure`
--

LOCK TABLES `leisure` WRITE;
/*!40000 ALTER TABLE `leisure` DISABLE KEYS */;
INSERT INTO `leisure` VALUES (100.00,150.00,70.00,1500.00,_binary '^\Ï‹∫@ª\–\Ïû|\÷â',NULL,'monthly'),(200.00,160.00,60.00,2500.00,_binary '|Grv¶MoØ\‹i\≈`\ıR',NULL,'monthly'),(100.00,150.00,70.00,1500.00,_binary '\—\ÏI\Í\«mClë\Â1\‚)óå',NULL,'monthly');
/*!40000 ALTER TABLE `leisure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otherincome`
--

DROP TABLE IF EXISTS `otherincome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otherincome` (
  `investment_income_by_id` decimal(38,2) DEFAULT NULL,
  `rental_income_by_id` decimal(38,2) DEFAULT NULL,
  `otherincome_id` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`otherincome_id`),
  KEY `FKnwb6noao2dw7jw83x0hy91n96` (`user_id`),
  CONSTRAINT `FKnwb6noao2dw7jw83x0hy91n96` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otherincome`
--

LOCK TABLES `otherincome` WRITE;
/*!40000 ALTER TABLE `otherincome` DISABLE KEYS */;
INSERT INTO `otherincome` VALUES (200.00,300.00,_binary '.¢@.\ÌL\Ëå&CºS˝ät',NULL,'monthly'),(1200.00,1300.00,_binary '>\“sºˇJç¨L°P£\–\»',NULL,'monthly'),(1250.00,1250.00,_binary 'Q<°¨K(´ëÑà|Iyu',NULL,'monthly');
/*!40000 ALTER TABLE `otherincome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pensions`
--

DROP TABLE IF EXISTS `pensions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pensions` (
  `private_pension_by_id` decimal(38,2) DEFAULT NULL,
  `state_pension_by_id` decimal(38,2) DEFAULT NULL,
  `pensions_id` binary(16) NOT NULL,
  `user_id` binary(16) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pensions_id`),
  KEY `FKn3jprlm2ac417hhf7wwrxk2xa` (`user_id`),
  CONSTRAINT `FKn3jprlm2ac417hhf7wwrxk2xa` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pensions`
--

LOCK TABLES `pensions` WRITE;
/*!40000 ALTER TABLE `pensions` DISABLE KEYS */;
INSERT INTO `pensions` VALUES (500.00,100.00,_binary 'D`äê[xO*πhÏú®ÉÑô',NULL,'monthly'),(300.00,100.00,_binary 'V∏à\ÙøHèÑµ\'xl°\Á:',NULL,'monthly');
/*!40000 ALTER TABLE `pensions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_percentage` decimal(38,2) DEFAULT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `id` binary(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (20.00,'2024-06-29 08:04:47.132718',_binary '?E2ãd:L\Ù±ë\Ã6!ª©\–','miski19@abc.com','Miski Hassan'),(20.00,'2024-07-01 18:41:57.021252',_binary 'i∫(`™ªJ˙ùd¶ÿØ\À¯','miski19@abc.com','Miski Hassan'),(15.00,'2024-06-29 08:05:04.904699',_binary 'æÑÜãCï°nŒÆ¢¶ßE','milesdavis14@abc.com','Miles Davis');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-20 22:40:10
