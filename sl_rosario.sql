-- MySQL dump 10.13  Distrib 5.5.44, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: sl_rosario
-- ------------------------------------------------------
-- Server version	5.5.44-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eventos`
--

DROP TABLE IF EXISTS `eventos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_evento` int(11) NOT NULL,
  `id_formato` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `fb_url` text NOT NULL,
  `timestamp_alta` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_tipo_evento` (`id_tipo_evento`),
  KEY `id_formato` (`id_formato`),
  CONSTRAINT `FK_5vejpyxn3bgmvwy7k2e45ss2r` FOREIGN KEY (`id_formato`) REFERENCES `formatos` (`id`),
  CONSTRAINT `FK_991ag10xfvhqeshax6wwqmhcw` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipos_evento` (`id`),
  CONSTRAINT `fk_eventos_formato` FOREIGN KEY (`id_formato`) REFERENCES `formatos` (`id`),
  CONSTRAINT `fk_eventos_tipos_evento` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipos_evento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventos`
--

LOCK TABLES `eventos` WRITE;
/*!40000 ALTER TABLE `eventos` DISABLE KEYS */;
INSERT INTO `eventos` VALUES (1,1,1,'Commandmartes Torneo 1v1','2016-07-05','00:00:00','','2016-08-03 19:41:04'),(2,2,2,'PPTQ Rosario','2016-07-09','00:00:00','','2016-08-03 19:41:04'),(3,1,1,'Evento Agosto 1','2016-08-01','00:00:00','','2016-08-03 21:02:33'),(4,2,1,'Evento Agosto 2','2016-08-02','00:00:00','','2016-08-03 21:02:33'),(5,1,1,'adawdawd','2016-08-17','00:00:00','http://localhost:8080/SuperLigaWeb/eventos/new','2016-08-04 23:42:09'),(6,2,1,'awdawd','2016-08-19','00:00:00','awdawdawd','2016-08-04 23:46:01'),(7,1,1,'Nuevo evento hora','2016-08-26','16:00:00','http://localhost:8080/SuperLigaWeb/eventos/new;jsessionid=4DF51903DCECBFBE6AE81EDFC0A9A691','2016-08-06 03:56:08'),(8,1,1,'Evento horaaaa','2016-08-31','20:00:00','awdawdawdawdaw','2016-08-06 03:57:23'),(9,2,2,'Prueba Fecha y hora','2016-08-26','20:50:00','http://localhost:8080/SuperLigaWeb/eventos/new','2016-08-07 03:28:42');
/*!40000 ALTER TABLE `eventos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formatos`
--

DROP TABLE IF EXISTS `formatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formatos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formatos`
--

LOCK TABLES `formatos` WRITE;
/*!40000 ALTER TABLE `formatos` DISABLE KEYS */;
INSERT INTO `formatos` VALUES (1,'Standard'),(2,'Commander'),(3,'Pauper'),(4,'Modern'),(5,'Sealed'),(6,'Draft'),(7,'Prerelease'),(8,'Block Party'),(9,'Tiny Leaders');
/*!40000 ALTER TABLE `formatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugadores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dci` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dci` (`dci`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'4082608853','Julian','Pagano'),(2,'2145852369','Facundo','Gamero'),(3,'8541789632','Matias','Gil'),(4,'39806558','Pedro','Daffunchio'),(5,'9113338805','Valentin','Cocconi'),(6,'62602181','Agustin','Perna'),(7,'4115208197','Mauro','Zara'),(8,'6102040934','Bruno','Pasquetta'),(9,'6114972116','Jhon','Garcia'),(10,'1425462','Enrique','Piedfort'),(11,'1200470002','Carlos','Beltramini'),(12,'6102033853','Maximiliano','Jaimes'),(13,'1201991136','Gonzalo','Calvano'),(14,'11427016','Leandro','Esperanza'),(15,'7103608818','Cristian','Monti'),(16,'7103615008','Maximo','Bindelli'),(17,'21427370','Cristian','Tapia');
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntos_jugadores_evento`
--

DROP TABLE IF EXISTS `puntos_jugadores_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntos_jugadores_evento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `puntos` int(11) DEFAULT NULL,
  `id_evento` bigint(20) DEFAULT NULL,
  `id_jugador` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntos_jugadores_evento`
--

LOCK TABLES `puntos_jugadores_evento` WRITE;
/*!40000 ALTER TABLE `puntos_jugadores_evento` DISABLE KEYS */;
INSERT INTO `puntos_jugadores_evento` VALUES (1,9,1,1),(2,12,2,1),(3,7,1,2),(4,3,1,3),(5,3,3,1),(6,6,4,2);
/*!40000 ALTER TABLE `puntos_jugadores_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_evento`
--

DROP TABLE IF EXISTS `tipos_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_evento`
--

LOCK TABLES `tipos_evento` WRITE;
/*!40000 ALTER TABLE `tipos_evento` DISABLE KEYS */;
INSERT INTO `tipos_evento` VALUES (1,'Commandmartes'),(2,'PPTQ');
/*!40000 ALTER TABLE `tipos_evento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-26  7:41:15
