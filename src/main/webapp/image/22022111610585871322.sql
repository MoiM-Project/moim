CREATE DATABASE  IF NOT EXISTS `bitcamp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bitcamp`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bitcamp
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `num` smallint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `bookday` varchar(30) DEFAULT NULL,
  `inwon` smallint DEFAULT NULL,
  `foodphoto` varchar(200) DEFAULT NULL,
  `foodprice` varchar(200) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'송혜교','m','2022-08-27T12:21',5,'똠양꿍.jpg,알밥.jpg,초밥.jpg','17000,13000,30000','예약이요\r\n예약이요','2022-08-25 12:30:10'),(2,'정지훈','m','2022-08-24T12:21',6,'떡볶이.jpg,돼지갈비.jpg,똠양꿍.jpg','9000,23000,17000','예약합니다','2022-08-24 12:22:40'),(3,'강호동','m','2022-08-24T12:21',2,'치즈샌드위치.jpg,똠양꿍.jpg,초밥.jpg','12000,17000,30000','두명이요','2022-08-24 12:23:31'),(4,'한소희','f','2022-08-24T12:21',3,'떡볶이.jpg,똠양꿍.jpg,알밥.jpg','9000,17000,13000','세명이요','2022-08-24 12:24:07'),(5,'정해인','m','2022-08-24T12:21',5,'치즈샌드위치.jpg,떡볶이.jpg,돼지갈비.jpg,똠양꿍.jpg,알밥.jpg,초밥.jpg','12000,9000,23000,17000,13000,30000','회식합니다','2022-08-24 12:24:28'),(6,'송강','m','2022-08-24T18:00',2,'똠양꿍.jpg,알밥.jpg,초밥.jpg','17000,13000,30000','확인좀요','2022-08-24 12:25:18'),(7,'테스형','f','2022-09-02T17:12',2,'치즈샌드위치.jpg,떡볶이.jpg,돼지갈비.jpg','12000,9000,23000','치즈샌드위치\r\n떡볶이\r\n돼지갈비\r\npre 테스트중','2022-08-24 17:13:14');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carseller`
--

DROP TABLE IF EXISTS `carseller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carseller` (
  `num` int NOT NULL AUTO_INCREMENT,
  `chkbox` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0',
  `writer` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `carname` varchar(100) DEFAULT NULL,
  `carcolor` varchar(100) DEFAULT NULL,
  `caryear` varchar(20) DEFAULT NULL,
  `carprice` int DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `readcount` int DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carseller`
--

LOCK TABLES `carseller` WRITE;
/*!40000 ALTER TABLE `carseller` DISABLE KEYS */;
INSERT INTO `carseller` VALUES (1,'1','원종환','1234','아반떼','gray','2017',3000,'야무지게 침수돼서 판매합니다',12,'2022-08-28 22:38:50'),(2,'0','원종환','1234','소나타','white','2019',3400,'판매합니다',15,'2022-08-28 23:10:26'),(3,'0','이호진','1234','K7','black','2022',4000,'다른 차량을 구매하게되어 판매합니다\r\n한달 정도 운영했어요',1,'2022-08-28 23:24:30'),(4,'0','임강혁','1234','K7','purple','2021',4000,'다른 차량을 구매하게되어 판매합니다\r\n한달 정도 운영했어요',1,'2022-08-28 23:27:59'),(5,'0','홍길동','1234','G80','red','2012',12650,'다른 차량을 구매하게되어 판매합니다\r\n한달 정도 운영했어요',0,'2022-08-28 23:28:15'),(6,'0','이건희','1234','G90','black','2020',9000,'다른 차량을 구매하게되어 판매합니다\r\n한달 정도 운영했어요',1,'2022-08-28 23:28:42'),(7,'0','고길동','1234','그랜저','black','2002',5000,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',0,'2022-08-28 23:31:34'),(8,'0','한지우','1234','EV6','yellow','2019',2400,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',1,'2022-08-28 23:38:13'),(9,'1','김국진','1234','니로','blue','2018',2500,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',2,'2022-08-28 23:39:49'),(10,'1','김상욱','1234','쏘렌토','gray','2007',2200,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',1,'2022-08-29 01:18:43'),(11,'1','한효주','1234','스포티지','white','2022',2300,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',1,'2022-08-29 01:18:47'),(12,'1','송강호','1234','K3','yellow','1997',8000,'1개월 사용한 차량 판매합니다\r\n댓글 남겨주세요',16,'2022-08-29 01:19:19'),(13,'1','석모씨','1234','아이오닉6','white','2022',4500,'fasdf',1,'2022-08-30 00:07:42'),(14,'0','테스트','1234','셀토스','white','2022',3100,'테스트중입니다',0,'2022-08-30 00:11:07'),(17,'1','테스트3','1234','그랜저','#f3e444','2019',3400,'carname 재확인',2,'2022-08-30 00:27:41'),(18,'1','확인','1234','아반떼','#cccccc','2017',2400,'detailview 확인용도',4,'2022-08-30 00:30:54'),(19,'1','재확인','1234','아반떼','#cccccc','2020',2750,'testetst',7,'2022-08-30 00:33:10');
/*!40000 ALTER TABLE `carseller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companycar`
--

DROP TABLE IF EXISTS `companycar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companycar` (
  `num` smallint NOT NULL AUTO_INCREMENT,
  `company` varchar(20) DEFAULT NULL,
  `carname` varchar(20) DEFAULT NULL,
  `carcolor` varchar(20) DEFAULT NULL,
  `carprice` int DEFAULT NULL,
  `carguip` date DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companycar`
--

LOCK TABLES `companycar` WRITE;
/*!40000 ALTER TABLE `companycar` DISABLE KEYS */;
INSERT INTO `companycar` VALUES (1,'현대','쏘렌토','흰색',3000,'2022-08-04'),(2,'쌍용','토레스','회색',2500,'2022-08-04'),(3,'현대','포터','파란색',2700,'2022-08-04'),(5,'기아','스포티지','검은색',2600,'2022-08-04'),(6,'기아','K5','흰색',2300,'2022-08-04'),(8,'기아','K9','검은색',3800,'2022-08-04');
/*!40000 ALTER TABLE `companycar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `num` int NOT NULL AUTO_INCREMENT,
  `loginid` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `hp` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `gaipday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'bbb','1111','명국','20220819022808540.PNG','010-2222-2222','ccc@naver.com','테스트주소','2022-09-16 14:15:17'),(3,'ddd','1111','테스트','20220819030055380.PNG','01011113333','ccc@naver.com','테스트주소','2022-09-19 15:00:55'),(4,'eee','1111','테스트','20220819030141526.jpg','01011111111','ccc@naver.com','테스트주소','2022-09-19 15:01:41'),(5,'fff','1111','테스트','20220819030223982.jpg','01022223333','ccc@naver.com','테스트주소','2022-09-19 15:02:23'),(6,'ggg','1111','테스트','20220819030323823.jpg','01033335555','ccc@naver.com','테스트주소','2022-09-19 15:03:23'),(8,'aaa','1111','세경씨','20220820023215710.JPG','0103333','jewely@highkick.com','지붕킥','2022-09-19 17:28:34'),(9,'ccc','1111','종환','20220822090645104.com-gif-maker.gif','01011111111','ccc@naver.com','테스트주소','2022-09-20 11:07:48'),(10,'goongye','1234','궁예','20220820023130215.gif','010-1111-2222','goongye@goguryeo.com','후고구려','2022-09-20 14:31:30'),(11,'칭얼칭얼','1231','123','2022082002440565.jpeg','adfa','123@naaaf.com','adfa','2022-09-20 14:44:05'),(12,'karina','1234','카리나여신','20220820024907983.jpg','010','only@karina','서울','2022-09-20 14:49:07');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mycar`
--

DROP TABLE IF EXISTS `mycar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mycar` (
  `num` bigint NOT NULL AUTO_INCREMENT,
  `carcolor` varchar(255) DEFAULT NULL,
  `carguip` varchar(255) DEFAULT NULL,
  `carname` varchar(255) DEFAULT NULL,
  `carphoto` varchar(255) DEFAULT NULL,
  `carprice` int DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mycar`
--

LOCK TABLES `mycar` WRITE;
/*!40000 ALTER TABLE `mycar` DISABLE KEYS */;
INSERT INTO `mycar` VALUES (1,'#c4bee2','2022-10-10','싼타페','car6.png',35000000,'2022-10-18 15:26:39'),(3,'#ededed','2022-10-03','넥쏘','car9.png',43000000,'2022-10-18 17:44:43'),(4,'#f50000','2022-10-19','투싼','car8.png',42000000,'2022-10-18 17:45:01'),(5,'#feecec','2022-10-10','소나타','car1.png',32000000,'2022-10-18 19:03:07'),(6,'#d5cdfe','2022-10-10','그랜져','car2.png',36000000,'2022-10-18 19:03:59'),(7,'#ff0000','2022-10-03','아반떼','car5.png',28000000,'2022-10-18 19:18:32');
/*!40000 ALTER TABLE `mycar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myfood`
--

DROP TABLE IF EXISTS `myfood`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myfood` (
  `num` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) DEFAULT NULL,
  `fphoto` varchar(1000) DEFAULT NULL,
  `fhp` varchar(20) DEFAULT NULL,
  `fcontent` varchar(1000) DEFAULT NULL,
  `bookingday` varchar(20) DEFAULT NULL,
  `orderday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myfood`
--

LOCK TABLES `myfood` WRITE;
/*!40000 ALTER TABLE `myfood` DISABLE KEYS */;
INSERT INTO `myfood` VALUES (2,'ㅁㄴㅇㄹㅁㄴㄹㅇ','hiworks_20220210_939.PNG,hiworks_20220318_1258.PNG,IMG_1941.JPG,IMG_7825.JPG','ㅁㄴㄹㅇㅁㄹㅇㄴ','ㅁㄴㅇㄹㅁㄹㄴㅇ','2022-10-13','2022-10-28 17:03:35'),(3,'asdf','무니쌤.gif','1111','asdf','2022-10-31','2022-10-31 10:28:42'),(4,'갓주아','naver_com_20180618_171737.jpg','010-11111111','ㅁㄴㅇㄹㄴㅁㅇㄹ','2022-10-31','2022-10-31 11:13:36'),(5,'gif 껄껄','20210226＿004211.gif,나무늘보.gif,냐.gif','010-222-2222','나무늘보','2022-10-31','2022-10-31 16:28:36');
/*!40000 ALTER TABLE `myfood` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myphoto`
--

DROP TABLE IF EXISTS `myphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myphoto` (
  `num` int NOT NULL AUTO_INCREMENT,
  `photo` varchar(50) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myphoto`
--

LOCK TABLES `myphoto` WRITE;
/*!40000 ALTER TABLE `myphoto` DISABLE KEYS */;
INSERT INTO `myphoto` VALUES (1,'i15379695514.gif','빨간차2ㅎㅎ','2022-10-27 10:32:51'),(2,'hiworks_20220318_1258.PNG','ㅎㅇㅎㅇ','2022-10-27 10:33:23'),(3,'naver_com_20180618_171523.jpg','ㄹㄹ','2022-10-27 11:09:12'),(12,'개허탈.PNG','빨간차','2022-10-27 16:43:08'),(13,'IMG_7825.JPG','황금 도비','2022-10-27 16:43:14'),(14,'car6.png','붕붕이','2022-10-27 16:43:20'),(16,'car4.png','쏘나타지롱','2022-10-27 16:45:45'),(17,'car7.png','파란색','2022-10-28 11:20:37'),(18,'car3.png','황금소나타','2022-10-28 13:57:16'),(19,'car4.png','소나롸','2022-10-28 13:57:37'),(20,'car9.png','넥쏘','2022-10-28 13:57:51'),(21,'car5.png','뤠드','2022-10-28 13:58:01');
/*!40000 ALTER TABLE `myphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myshop`
--

DROP TABLE IF EXISTS `myshop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myshop` (
  `num` smallint NOT NULL AUTO_INCREMENT,
  `sangpum` varchar(30) DEFAULT NULL,
  `photo` varchar(30) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `ipgoday` varchar(20) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myshop`
--

LOCK TABLES `myshop` WRITE;
/*!40000 ALTER TABLE `myshop` DISABLE KEYS */;
INSERT INTO `myshop` VALUES (24,'하늘색자켓','car7.png','#8ac6ff',52000,'2022-10-12','2022-10-19 15:20:56'),(25,'화이트자켓2','car2.png','#7c769e',42000,'2022-10-10','2022-10-19 15:21:06');
/*!40000 ALTER TABLE `myshop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reactboard`
--

DROP TABLE IF EXISTS `reactboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reactboard` (
  `num` int NOT NULL AUTO_INCREMENT,
  `myid` varchar(20) DEFAULT NULL,
  `myname` varchar(20) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `subject` varchar(300) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `readcount` int DEFAULT '0',
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reactboard`
--

LOCK TABLES `reactboard` WRITE;
/*!40000 ALTER TABLE `reactboard` DISABLE KEYS */;
INSERT INTO `reactboard` VALUES (1,'mija','이미자','20221102114750881.jpg','빙글빙글','subject',0,'2022-11-02 11:47:51'),(2,'sungmin9844','성민','20221102115333444.jpg','ㅎㅎ..','ㅎㅎ..',0,'2022-11-02 11:53:39'),(3,'sungmin9844','성민','20221102115346256.jpg','ㅎ..ㅎ','ㅎ..ㅎ',0,'2022-11-02 11:53:50'),(4,'mija','이미자','20221102115418838.jpg','괄괄괄괄','괄괄',1,'2022-11-02 11:54:19'),(5,'aa','aaa','20221102115502315.jpg','둠칫','둠칫',1,'2022-11-02 11:55:07'),(6,'aa','aaa','20221102115512554.PNG','아 싫어','아 싫어',0,'2022-11-02 11:55:16'),(7,'aa','aaa','20221102115523269.jpg','잘가','잘가',0,'2022-11-02 11:55:27'),(8,'a','a','2022110211555017.PNG','일어나','일어나',0,'2022-11-02 11:55:53'),(9,'a','a','20221102115558677.PNG','허탈','허탈',1,'2022-11-02 11:56:04'),(10,'a','a','20221102115617422.png','디뽈트','디뽈트',0,'2022-11-02 11:56:22'),(11,'a','a','2022110211563579.jpg','우와아','우와아',0,'2022-11-02 11:56:39'),(12,'a','a','20221102115644112.JPG','세경씨','무서운사람이네~',0,'2022-11-02 11:56:48'),(13,'b','b','2022110211570844.png','안녕히계세요','안녕히계세요',0,'2022-11-02 11:57:13'),(14,'b','b','20221102115717125.jpg','탈주각','탈주각',3,'2022-11-02 11:57:22'),(15,'b','b','20221102115727233.jpg','제가해요?','제가해요?',0,'2022-11-02 11:57:31'),(16,'b','b','20221102115735606.png','호예~','호예~',0,'2022-11-02 11:57:39'),(17,'b','b','2022110211574334.jpg','이것도 제가?','이것도 제가?',1,'2022-11-02 11:57:46'),(18,'b','b','20221102115755414.jpg','뿌엥','뿌엥',0,'2022-11-02 11:57:57'),(19,'bb','bb','20221102115824250.jpg','돈벌어야지','돈벌어야지',0,'2022-11-02 11:58:28'),(20,'bb','bb','2022110211583368.jpg','재롱','재롱',3,'2022-11-02 11:58:36'),(21,'bb','bb','20221102002543880.png','왜 나만 갈구는데','스바스키야~',7,'2022-11-02 12:25:53'),(22,'sunhye','선혜','20221102051630498.PNG','집에가고싶다','ㅋㅋㅋ',0,'2022-11-02 17:16:44'),(23,'mija','이미자','20221102075202743.gif','날아라 ..어?','둘기야',0,'2022-11-02 19:52:06'),(24,'mija','이미자','20221102075238975.gif','화염방사','방사금지염',0,'2022-11-02 19:52:55'),(25,'mija','이미자','20221102075310336.JPG','실례가 안된다면','아이스크림 하나만 사주십시오',0,'2022-11-02 19:53:36');
/*!40000 ALTER TABLE `reactboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reactmember`
--

DROP TABLE IF EXISTS `reactmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reactmember` (
  `num` int NOT NULL AUTO_INCREMENT,
  `myname` varchar(20) DEFAULT NULL,
  `myid` varchar(20) DEFAULT NULL,
  `mypass` varchar(20) DEFAULT NULL,
  `gaipday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reactmember`
--

LOCK TABLES `reactmember` WRITE;
/*!40000 ALTER TABLE `reactmember` DISABLE KEYS */;
INSERT INTO `reactmember` VALUES (1,'이미자','mija','1234','2022-11-01 10:47:28'),(4,'성민','sungmin9844','aaaa@1234','2022-11-01 15:18:00'),(5,'asdfasdf','asdfasdfsa','asdfasdf','2022-11-01 15:37:48'),(7,'aaa','aa','1','2022-11-02 11:54:45'),(8,'a','a','1','2022-11-02 11:55:42'),(9,'b','b','1','2022-11-02 11:56:55'),(10,'bb','bb','1','2022-11-02 11:58:16'),(11,'선혜','sunhye','1','2022-11-02 17:16:04');
/*!40000 ALTER TABLE `reactmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reboard`
--

DROP TABLE IF EXISTS `reboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reboard` (
  `num` int NOT NULL AUTO_INCREMENT,
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `subject` varchar(1000) DEFAULT NULL,
  `photo` varchar(1000) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `readcount` int DEFAULT '0',
  `likes` int DEFAULT '0',
  `regroup` int DEFAULT NULL,
  `restep` int DEFAULT NULL,
  `relevel` int DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reboard`
--

LOCK TABLES `reboard` WRITE;
/*!40000 ALTER TABLE `reboard` DISABLE KEYS */;
INSERT INTO `reboard` VALUES (2,'bbb','테스트','테스트 게시글','20220822102531283.PNG','		ㄹㄹㄹ			',11,0,2,0,0,'2022-09-22 10:25:31'),(3,'aaa','세경씨','테스트 게시글1','20220822102727217.jpg','ㄹㄹㄹㄹ		',34,0,3,0,0,'2022-09-22 10:27:27'),(4,'ccc','테스트','썸네일 테스트','1_20220822104618562.gif','숏ㅁㄷㅈㅅㄷㄴㅅ',9,0,4,0,0,'2022-09-22 10:46:18'),(5,'ccc','테스트','tttt','1_20220822104831406.gif','	fasdf				',17,0,5,0,0,'2022-09-22 10:48:31'),(6,'ccc','테스트','썸네일 테스트','1_20220822112611746.jpg','뿌엥',73,0,6,0,0,'2022-09-22 11:26:11'),(7,'ccc','테스트','test','1_20220822114903239.gif','ㅌㅅㅁㅅㄷㅅ',8,0,7,0,0,'2022-09-22 11:49:03'),(8,'ccc','테스트','ㄻㄷㅅ','1_2022082211513488.JPG','ㅁㄴㅇㄹㄴ',42,14,8,0,0,'2022-09-22 11:51:34'),(9,'ccc','테스트','테스트','1_20220822002449661.JPG','테스트',92,0,9,0,0,'2022-09-22 12:24:49'),(10,'','','답글 테스트','1_20220822004331165.jpg','ㄻㄴㅇㄻㄴㅇ',11,0,10,0,0,'2022-09-22 12:43:31'),(11,'ccc','테스트','테스트','1_20220822004634735.gif','asdf',3,0,9,1,1,'2022-09-22 12:46:34'),(12,'ccc','테스트','테스트','1_20220822004835724.gif','ffweaf',3,0,9,2,2,'2022-09-22 12:48:35'),(13,'ccc','테스트','RE: 답글 테스트','1_20220822015134337.gif','뿌엥',2,0,10,1,1,'2022-09-22 13:51:34'),(15,'ccc','테스트','파이리답글','1_20220822020720211.gif','ㅍㄹㄴㅁㅇㄹ',20,0,14,1,1,'2022-09-22 14:07:20'),(16,'ccc','테스트','첨부파일 없읍니다','no','ㅎㅎㅎㅎㅎㅎ',46,6,16,0,0,'2022-09-22 14:23:29'),(17,'ccc','테스트','asdf','no','asdfas',97,0,17,0,0,'2022-09-22 14:31:30'),(18,'bbb','명국','수정폼 테스트ㅎㅎasdfasd','no','ㄹㅇㄴㅁㄴㄹㅇafsdasd',17,0,18,0,0,'2022-09-23 14:51:44');
/*!40000 ALTER TABLE `reboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reboardanswer`
--

DROP TABLE IF EXISTS `reboardanswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reboardanswer` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  `num` int DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `num` (`num`),
  CONSTRAINT `reboardanswer_ibfk_1` FOREIGN KEY (`num`) REFERENCES `reboard` (`num`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reboardanswer`
--

LOCK TABLES `reboardanswer` WRITE;
/*!40000 ALTER TABLE `reboardanswer` DISABLE KEYS */;
INSERT INTO `reboardanswer` VALUES (2,'bbb','테스트','20220823103928148.JPG','fasfse','2022-09-23 10:39:29',17),(5,'bbb','테스트','no','asfddasfs','2022-09-23 10:39:56',17),(6,'bbb','테스트','no','ffff','2022-09-23 10:44:43',17),(7,'bbb','테스트','no','asdfdsfa','2022-09-23 10:46:25',17),(8,'ccc','테스트','no','zzz','2022-09-23 11:04:42',16),(9,'ccc','테스트','no','ffff','2022-09-23 11:17:02',17),(11,'ccc','테스트','no','댓글 테스트','2022-09-23 11:18:10',9),(13,'bbb','테스트','no','껄껄','2022-09-23 11:35:00',7),(15,'bbb','명국','no','asdf','2022-09-23 14:33:15',17);
/*!40000 ALTER TABLE `reboardanswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop` (
  `num` smallint NOT NULL AUTO_INCREMENT,
  `category` varchar(20) DEFAULT NULL,
  `sang` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `ssize` varchar(10) DEFAULT '95',
  `ipgoday` date DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'top','레이스조끼','red',35000,'95','2022-08-05'),(2,'outer','체크자켓','blue',125000,'95','2022-10-10'),(3,'onepiece','롱원피스','pink',263500,'95','2022-08-10'),(5,'bottom','린넨 반바지','yellow',23000,'100','2022-08-05'),(6,'onepiece','야외용끈원피스','green',55000,'66','2022-08-05'),(7,'top','고래티셔츠','blue',19000,'95','2022-08-05'),(8,'top','상어티셔츠','white',19000,'90','2022-08-05'),(9,'top','브이넥티셔츠','gray',20000,'95','2022-08-05'),(10,'outer','라이더자켓','black',120000,'55','2022-08-05'),(11,'outer','가죽자켓','brown',90000,'77','2022-08-05'),(12,'bottom','연청바지','skyblue',80000,'55','2022-08-05'),(13,'bottom','진청바지','blue',95000,'66','2022-08-05'),(14,'bottom','블랙진','black',120000,'90','2022-08-05'),(15,'onepiece','흰원피스','white',50000,'55','2022-08-05'),(16,'onepiece','빨간원피스','red',75000,'66','2022-08-05');
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simpleboard`
--

DROP TABLE IF EXISTS `simpleboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `simpleboard` (
  `num` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  `subject` varchar(300) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `readcount` int DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simpleboard`
--

LOCK TABLES `simpleboard` WRITE;
/*!40000 ALTER TABLE `simpleboard` DISABLE KEYS */;
INSERT INTO `simpleboard` VALUES (1,'이진우','1234','게시판','안녕하세요',0,'2022-08-25 16:54:59'),(2,'강호동','1234','오늘 수업 끝','반가워요',0,'2022-08-25 16:55:21'),(3,'이효리','1234','출력은 각자','열심히 해봐요',1,'2022-08-25 16:55:56'),(4,'유재석','1234','조회수도 줄까요','일단 100으로 시작',101,'2022-08-25 16:56:16'),(5,'캔디','1234','안녕하세요 캔디입니다','테스트입니다\r\n테스트입니다테스트입니다\r\n\r\n테스트입니다테스트입니다테스트입니다',1,'2022-08-26 11:11:26'),(6,'테스형','1234','테스트 - 작성 시 view화면으로','테스트 - 작성 시 view화면으로\r\n테스트 - 작성 시 view화면으로\r\n테스트 - 작성 시 view화면으로',3,'2022-08-26 14:39:17'),(7,'테스트','1234','테스트 테스형','하나\r\n둘 셋\r\n넷다섯여섯',2,'2022-08-26 14:41:18'),(11,'가나다','1234','추석 얼마 안남음','추석 얼마 안남음\r\n추석 얼마 안남음',3,'2022-08-26 17:12:02'),(13,'라마바','1234','하낫둘셋넷','하낫둘셋넷\r\n라마바',1,'2022-08-26 17:47:17'),(14,'사아자','1234','사아자차카','사아자차카\r\n사아자차카',4,'2022-08-26 17:47:37');
/*!40000 ALTER TABLE `simpleboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smartanswer`
--

DROP TABLE IF EXISTS `smartanswer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smartanswer` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `num` int DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `num` (`num`),
  CONSTRAINT `smartanswer_ibfk_1` FOREIGN KEY (`num`) REFERENCES `smartbbs` (`num`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smartanswer`
--

LOCK TABLES `smartanswer` WRITE;
/*!40000 ALTER TABLE `smartanswer` DISABLE KEYS */;
INSERT INTO `smartanswer` VALUES (3,24,'test','test','2022-09-06 14:56:31'),(4,24,'관리자','신고합니다','2022-09-06 15:54:01'),(5,17,'무니','포도먹고찌뿐뎅','2022-09-06 16:10:51'),(6,16,'무니','무니는 포도가 먹고찌뽀','2022-09-06 16:11:04'),(7,24,'댓글 작성자','댓글 메시지','2022-09-07 09:45:56'),(8,14,'ㅋㅋ','무플방지','2022-09-07 10:06:09'),(9,24,'ㄹㄹㄹ','ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ','2022-09-07 10:08:49'),(10,24,'ㅎㅎ','ㅎㅎㅎㅎ','2022-09-07 11:07:23');
/*!40000 ALTER TABLE `smartanswer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smartbbs`
--

DROP TABLE IF EXISTS `smartbbs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smartbbs` (
  `num` int NOT NULL AUTO_INCREMENT,
  `writer` varchar(20) DEFAULT NULL,
  `subject` varchar(300) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `mainphoto` varchar(100) DEFAULT NULL,
  `readcount` int DEFAULT '0',
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smartbbs`
--

LOCK TABLES `smartbbs` WRITE;
/*!40000 ALTER TABLE `smartbbs` DISABLE KEYS */;
INSERT INTO `smartbbs` VALUES (2,'종환','치돈먹고싶다','<p>치돈 존맛 ㅇㅈ?&nbsp;</p><p>&nbsp;</p><p><img src=\"../save/2022_08_29_163455.jpg\">&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>','치즈돈까스.jpg',3,'2022-08-29 16:35:07'),(6,'민성','끝나고 치킨ㄱ?','<p>맥주에 싸악 !</p><p>&nbsp;</p><p><img src=\"../save/2022_08_29_164142.jpg\"></p>','치킨2.jpg',4,'2022-08-29 16:41:55'),(7,'성민','피자나 먹자','<p>마 어떤데?</p><p>&nbsp;</p><p><img src=\"../save/2022_08_29_164238.jpg\"></p>','피자.jpg',3,'2022-08-29 16:42:47'),(8,'병찬','닭갈비에 쐬주 어떠신가요','<p>닭갈비에 쐬주 어떠신가요</p><p>&nbsp;</p><p>다른 의견은 받지않습니다 ㅅㄱ</p>','닭갈비.jpg',2,'2022-08-29 16:43:26'),(9,'명국','점심 안먹어서 힘들다','족발에 쏘주 싸악! ㅎㅎ','독일족발.jpg',2,'2022-08-29 16:44:37'),(10,'선혜','저는 떡순튀 한표','저는 떡튀순 한표줍니돠','떡볶이.jpg',2,'2022-08-29 16:45:06'),(11,'투표봇','투표해주세요','<div style=\"text-align: justify;\" align=\"justify\">응 구라야</div>','계란말이.jpg',4,'2022-08-29 16:45:50'),(12,'매니저','공지 - 다들 조용히해주세요','응 나도 배고파','된장찌개.jpg',6,'2022-08-29 16:46:38'),(13,'학원장','내부에서 식사 금지입니다 여러분','돼지갈비는 어떤데','돼지갈비.jpg',4,'2022-08-29 16:47:18'),(14,'석모씨','나도 껴주세요','ㅈㅅ','짜장라면.jpg',5,'2022-08-29 16:47:40'),(15,'개발자','혁명음식 개발함','짬짜면 이번에 개발했다','041.png',8,'2022-08-29 16:48:24'),(16,'정육점','여뤄분 육회 어떠세요','정육점 여기 잘하던데ㅎㅎ','육회.jpg',26,'2022-08-29 16:49:05'),(17,'수정','여윽시 닭꼬치','<p>역시 닭ffffff</p><p>&nbsp;<img src=\"../save/2022_08_30_121724.jpg\" style=\"max-width:490px;\"></p><p><img src=\"../save/2022_08_29_175708.jpg\"></p>','닭꼬치.jpg',26,'2022-08-29 17:57:16'),(24,'hi','제목 글자수 줄임표시제목 글자수 줄임표시','<p>글자수 테스트입니다</p><p>&nbsp;</p><p>글자수 테스트입니다 글자수 테스트입니다</p><p>&nbsp;</p><p>글자수 테스트입니다 글자수 테스트입니다 글자수 테스트입니다&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;<img src=\"../save/2022_09_07_101417.PNG\" style=\"max-width:490px;\"></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;<img src=\"../save/2022_09_07_101424.png\" style=\"max-width:490px;\"></p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>ㄹㄹㄹㄹ</p>','새우볶음밥.jpg',367,'2022-08-30 15:06:24');
/*!40000 ALTER TABLE `smartbbs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `num` smallint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `addr` varchar(30) DEFAULT NULL,
  `writeday` datetime DEFAULT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'이진','강남구','2022-08-03 16:12:28'),(2,'한지혜','도곡동','2022-08-03 16:13:26'),(4,'유재석','제주도','2022-08-03 16:14:03'),(5,'이영자','부산 해운대','2022-08-03 16:14:11'),(6,'김모씨','강서구','2022-08-04 14:57:04'),(7,'강호남','강서구','2022-08-04 15:40:29');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bitcamp'
--

--
-- Dumping routines for database 'bitcamp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-03  1:40:31
