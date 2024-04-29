-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: db_helpme_test
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','create table tb permissao','SQL','V1__create_table_tb_permissao.sql',572355523,'root','2024-04-24 19:01:09',95,1),(2,'2','create table tb garcom','SQL','V2__create_table_tb_garcom.sql',2068513255,'root','2024-04-24 19:01:09',99,1),(3,'3','create table tb comandas','SQL','V3__create_table_tb_comandas.sql',1811829938,'root','2024-04-24 19:01:09',135,1),(4,'4','create table tb mesa','SQL','V4__create_table_tb_mesa.sql',-573838963,'root','2024-04-24 19:01:09',120,1),(5,'5','inster in table permisaao','SQL','V5__inster_in_table_permisaao.sql',1516537147,'root','2024-04-24 19:01:10',21,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comandas`
--

DROP TABLE IF EXISTS `tb_comandas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comandas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `em_aberto` tinyint(1) DEFAULT NULL,
  `valor_comanda` decimal(38,2) DEFAULT NULL,
  `garcom_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comandas_garcom` (`garcom_id`),
  CONSTRAINT `fk_comandas_garcom` FOREIGN KEY (`garcom_id`) REFERENCES `tb_garcom` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comandas`
--

LOCK TABLES `tb_comandas` WRITE;
/*!40000 ALTER TABLE `tb_comandas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comandas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_garcom`
--

DROP TABLE IF EXISTS `tb_garcom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_garcom` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `permissao_id` bigint NOT NULL,
  `horario_entrada_dia` datetime NOT NULL,
  `horario_saida_dia` datetime NOT NULL,
  `total_horas_trabalhadas_mes` bigint NOT NULL,
  `salario_funcionario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `permissao_id` (`permissao_id`),
  CONSTRAINT `tb_garcom_ibfk_1` FOREIGN KEY (`permissao_id`) REFERENCES `tb_permissao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_garcom`
--

LOCK TABLES `tb_garcom` WRITE;
/*!40000 ALTER TABLE `tb_garcom` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_garcom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mesa`
--

DROP TABLE IF EXISTS `tb_mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mesa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `desocupacao` datetime DEFAULT NULL,
  `inicio_ocupacao` datetime DEFAULT NULL,
  `numero_ocupantes` int DEFAULT NULL,
  `status` enum('LIVRE','OCUPADA','RESERVADA') DEFAULT NULL,
  `comanda_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comanda_id` (`comanda_id`),
  CONSTRAINT `fk_mesa_comanda` FOREIGN KEY (`comanda_id`) REFERENCES `tb_comandas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mesa`
--

LOCK TABLES `tb_mesa` WRITE;
/*!40000 ALTER TABLE `tb_mesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_permissao`
--

DROP TABLE IF EXISTS `tb_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_permissao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tipo_de_usuario` enum('ADMINISTRADOR','GERENTE','CLIENTE','COMUM','GARCOM') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_permissao`
--

LOCK TABLES `tb_permissao` WRITE;
/*!40000 ALTER TABLE `tb_permissao` DISABLE KEYS */;
INSERT INTO `tb_permissao` VALUES (1,'ADMINISTRADOR'),(2,'GERENTE'),(3,'CLIENTE'),(4,'COMUM'),(5,'GARCOM');
/*!40000 ALTER TABLE `tb_permissao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-24 16:02:18
