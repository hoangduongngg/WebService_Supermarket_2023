CREATE DATABASE  IF NOT EXISTS `accounts` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `accounts`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: accounts
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role` varchar(45) NOT NULL,
  `id_user` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'ben','123','customer',1),(2,'hoangduong','123456','customer',2),(3,'bennn','123','customer',1),(5,'benabc','123','customer',16),(6,'1','123','customer',17),(7,'2','123','customer',18),(8,'manager','manager','manager',1),(9,'adfhgvah','123','customer',20),(10,'hoangduongngg','123456','customer',21),(11,'warehouse','warehouse','warehouse',22);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(14) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguyễn Văn Bến','Gia Bình - Bắc Ninh','nguyenvanben02001@gmail.com','0963778407','https://scontent.fhan5-10.fna.fbcdn.net/v/t39.30808-1/324346157_573092641003089_8994177206377802673_n.jpg?stp=dst-jpg_p240x240&_nc_cat=101&ccb=1-7&_nc_sid=7206a8&_nc_ohc=7CEX1x39facAX-dLmAs&_nc_ht=scontent.fhan5-10.fna&oh=00_AfAP5Cncvdbdb2BIdv6pxL4a9ZEyefqcu5nWgoJ7_UFZrw&oe=644A863A','2001-04-14'),(2,'Hoàng Dương Nguyễn','Quế Võ - Bắc Ninh','hoangduongnguyen.ptit@gmail.com','092342343','https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/278534687_3198224627133355_3470095109332184846_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=174925&_nc_ohc=MJsE-MQBEKIAX-0YwxY&_nc_ht=scontent.fhan5-11.fna&oh=00_AfAk79q8zNl-d-PoVueKb0F1hoIStcF79Mk-dxhgWYMIzA&oe=644A123C','2001-04-14'),(3,'Nguyễn Văn Bến','Gia Bình - Bắc Ninh','bennv14@gmail.com','092342342','https://scontent.fhan5-2.fna.fbcdn.net/v/t1.6435-9/110175814_2701368460152310_6513542925692273288_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=174925&_nc_ohc=m7uJnobF15IAX-g7e2H&_nc_ht=scontent.fhan5-2.fna&oh=00_AfD5sptaQXVzpaZi54QNqq9FeyvIP9Y5vScj-bT0knB26w&oe=646C44C4','2001-04-14'),(17,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','09727642874',NULL,'2023-05-01'),(18,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','09727642871',NULL,'2023-05-01'),(19,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','0963778434',NULL,'2023-05-04'),(20,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','825945205',NULL,'2023-05-15');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:17
CREATE DATABASE  IF NOT EXISTS `msv_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `msv_user`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: msv_user
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_type` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('MANAGER',1,NULL,'Manager 1','tk',NULL,'tk'),('CUSTOMER',2,NULL,'Customer 1','customer',NULL,'customer'),('WAREHOUSE_WORKER',3,NULL,'WWorker 1','kho',NULL,'kho');
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

-- Dump completed on 2023-05-17 14:01:18
CREATE DATABASE  IF NOT EXISTS `msv_supplier` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `msv_supplier`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: msv_supplier
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (29,'sup1','sup1','0000000001'),(30,'sup2','sup2','0000000002'),(33,'sup4','sup4','sup4');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:18
CREATE DATABASE  IF NOT EXISTS `msv_import_detail` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `msv_import_detail`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: msv_import_detail
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `import_detail`
--

DROP TABLE IF EXISTS `import_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` date NOT NULL,
  `import_bill_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `supplier_id` bigint NOT NULL,
  `unit_price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_detail`
--

LOCK TABLES `import_detail` WRITE;
/*!40000 ALTER TABLE `import_detail` DISABLE KEYS */;
INSERT INTO `import_detail` VALUES (23,'2023-05-05',24,10,100,29,100),(24,'2023-05-05',24,11,100,29,100),(25,'2023-05-05',24,12,100,29,100),(26,'2023-05-12',25,10,200,30,200),(27,'2023-05-12',25,11,200,30,200),(28,'2023-05-12',25,12,200,30,200),(29,'2023-05-12',26,10,10,29,10),(30,'2023-05-12',26,11,10,29,10),(31,'2023-05-12',27,11,12,29,2.6),(32,'2023-05-15',28,10,100,29,1000);
/*!40000 ALTER TABLE `import_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:19
CREATE DATABASE  IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `products`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: products
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `price` int NOT NULL DEFAULT '0',
  `units` int NOT NULL DEFAULT '0',
  `description` varchar(600) DEFAULT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `id_supplier` int NOT NULL DEFAULT '0',
  `quantity` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idt_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'Nike Air Force 1 React','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a6bce3ef-bc25-4e3d-b45b-db8223745a49/air-force-1-react-shoes-g9MPSs.png',100,100,'From hoops staple to urban street legend, the Nike AF-1 React takes another step forward into shoe iconography. Amplified features from the outsole to the branding add dramatic expression to the storied look while Nike React tech assists with a smooth ride. Stand out to fit in.','6 tháng',0,100),(4,'Nike Air Huarache','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3306d0ec-5d7c-4d2e-9d09-543f41e478b0/air-huarache-shoes-fg69qQ.png',100,100,'Built to fit your foot and designed for comfort, the Nike Air Huarache brings back a street-level favourite. Soft leather accents on the upper are mixed with super-breathable, perfectly shined neoprene-like fabric for easy styling. The low-cut collar and bootie-like construction keep it sleek. Its iconic heel clip and stripped away branding keep the early-90s look you love.','3 tháng',0,100),(5,'Nike Air Presto','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/08e369ae-fa2f-4097-9b46-d226428c1738/air-presto-shoes-QdhgZW.png',100,100,'With a sleek design that\'s more comfortable than your favourite T-shirt, the Nike Air Presto is made to feel good and look fast. Its stretchy sleeve creates a cosy, sock-like fit while the super-soft foam adds spring to your step. Put them on and you\'ll never want to take them off.','10 tháng',0,100),(6,'Nike Free Run 5.0','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3b27eb2b-da90-4a12-bb43-a093ca26b4a3/free-run-5-road-running-shoes-m8L9mr.png',100,100,'Made from at least 20% recycled material by weight, the sock-like boot of this Nike Free is designed to transition from running to training to your everyday routine. With a breathable knit upper, it combines the flexibility you love with a secure design that will help keep you close to the ground for that barefoot feeling. New cushioning is lighter, softer and more responsive than previous versions so you can keep moving in comfort whether you\'re on the tarmac or track.','1 năm',0,100),(7,'Nike Revolution 6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/7df57edf-bdc6-4320-a956-8ce37228cd1d/revolution-6-road-running-shoes-NC0P7k.png',100,1000,'Là loại nước ngọt được nhiều người yêu thích đến từ thương hiệu nước ngọt Pepsi nổi tiếng thế giớivới hương vị thơm ngon, sảng khoái. 6 lon nước ngọt Pepsi không calo lon 320ml với lượng gas lớn sẽ giúp bạn xua tan mọi cảm giác mệt mỏi, căng thẳng, sản phẩm không calo lành mạnh, tốt cho sức khỏe','2 tháng',0,1000),(8,'Nike Revolution 6 FlyEase','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4144c92b-0558-448c-aaa1-31f475a45b9f/revolution-6-flyease-easy-on-off-road-running-shoes-XvR99K.png',100,1000,'Here\'s to new beginnings between you and the pavement. We know comfort is key to a successful run, so we made sure your steps are cushioned and flexible for a soft ride. A strap and wraparound zip makes these shoes super-easy to get on and off. It\'s an evolution of a favourite, with a breathable design made with at least 20% recycled content by weight.','4 tháng',0,100),(9,'Nike City Rep TR','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/a917d6ad-3b8a-4c89-93fd-6751aeb8801e/city-rep-tr-training-shoes-djC0DF.png',100,1000,'The Nike City Rep TR is a versatile shoe that brings durability and flexibility to your active urban lifestyle. Rubber tread gives you grip on a range of surfaces, while foam cushioning keeps your foot comfortable—during outdoor workouts and through the rest of your day.','7 tháng',0,100),(10,'Nike MC Trainer','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/3e85cebb-b631-4c33-9fd6-dc13eae442d4/mc-trainer-training-shoe-T9vmbZ.png',100,100,'The Nike MC Trainer helps you transition from heavy lifting in the weight room to agility drills on the turf without skipping a beat. It packs stability, durability and flexibility into a versatile design that supports all the ways you move while you train for your sport.','4 tháng',0,100),(11,'Nike SuperRep Go 3 Next Nature Flyknit','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/029cab7f-8f28-4a33-b09c-536a47607f03/superrep-go-3-next-nature-flyknit-training-shoes-mxKptW.png',100,100,'The new Nike SuperRep Go 3 Flyknit Shoe is a radical design story rooted in sustainability and innovation. The zoned Flyknit construction wraps your foot in 360 degrees of comfort and support. A finely ground, reclaimed foam midsole gives you responsive cushioning for high-impact training. The lightweight, packable design lets you keep them close, no matter where your next workout takes you.','7 tháng',0,100),(12,'Nike Zoom Metcon Turbo 2','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/d646b481-eece-4618-83b6-2aef6bb85047/zoom-metcon-turbo-2-training-shoes-jPvmwl.png',100,100,'The Nike Zoom Metcon Turbo 2 puts a shot of adrenalizing speed into your everyday workout. It combines stability and responsiveness in a lightweight package to help you move quickly during circuit training, high-intensity intervals on the treadmill, a cardio workout you\'ve squeezed in on the way home—whatever you choose. From the Zoom Air cushioning underfoot to the rope wrap at the instep, every detail is pared down to minimise weight while maximising function and durability. Lighter, stronger materials are built for speed and strength.','2 năm',0,100),(14,'Nike Metcon 8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/4f34abbb-70df-44bf-8cad-137cca108d49/metcon-8-training-shoes-p9rQzn.png',100,10,'You chase the clock, challenging and encouraging each other all in the name of achieving goals and making gains. Our go-to model for training relies on a lighter, more breathable upper than our previous edition to complement our standards of durability and comfort, so that you can float through your cardio, power through your lifts and dominate your workouts.','1 năm',0,10),(26,'Nike Metcon 8 AMP','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/8f11d52e-2a1e-4e8b-afd1-0eadf8341d00/metcon-8-amp-training-shoes-KkzKHZ.png',100,100,'We\'re here to help get you moving! Regardless of whether your pace is snail-like or lickety-split, the Nike Metcon 8 AMP helps keep you on the go. Expressive, playful graphics remind your fun can be found in every workout, no matter how tough. The upper is lighter and more breathable than our previous edition to complement our standards of durability and comfort so that you can float through your cardio and power through your lifts. So go ahead, put 1 foot in front of the other, we\'ve got you, from your friends at the Moving Co.','1 năm',0,100),(58,'Nike Metcon 8 Premium','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/63e4acc1-d963-4231-907f-e3243e19b2fd/metcon-8-training-shoes-DNz7Sg.png',100,100,'You chase the clock, challenging and encouraging each other all in the name of achieving goals and making gains. Our go-to model for training relies on a lighter, more breathable upper than our previous iteration to complement our standards of durability and comfort, so that you can float through your cardio, power through your lifts and dominate your workouts.','39 ngày',0,100),(66,'Nike Free Metcon 4 Premium','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/5f896a2b-5f33-4552-9780-a84f991447d2/free-metcon-4-training-shoes-WK9VZ7.png',100,100,'The Nike Free Metcon 4 Premium combines flexibility with stability to help you get the most out of your training programme. Updated \"chain-link\" mesh cools and flexes as you speed through agility drills, while support at the midfoot and heel braces you for your heaviest sets in the weight room.','10 tháng',0,100);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:19
CREATE DATABASE  IF NOT EXISTS `msv_product` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `msv_product`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: msv_product
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (10,'t','t','t','product1',1,1438),(11,'t','t','t','product2',2,344),(12,'t','t','t','product3',3,1319);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:20
CREATE DATABASE  IF NOT EXISTS `msv_import_bill` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `msv_import_bill`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: msv_import_bill
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `import_bill`
--

DROP TABLE IF EXISTS `import_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` date DEFAULT NULL,
  `creator_id` bigint DEFAULT NULL,
  `supplier_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_bill`
--

LOCK TABLES `import_bill` WRITE;
/*!40000 ALTER TABLE `import_bill` DISABLE KEYS */;
INSERT INTO `import_bill` VALUES (24,'2023-05-05',3,29),(25,'2023-05-12',3,30),(26,'2023-05-12',3,29),(27,'2023-05-12',3,29),(28,'2023-05-15',3,29);
/*!40000 ALTER TABLE `import_bill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:21
CREATE DATABASE  IF NOT EXISTS `customers` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `customers`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: customers
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(14) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Nguyễn Hoàng Duong','Gia Bình - Bắc Ninh','nguyenvanben02001@gmail.com','0963778407','https://scontent.fhan5-10.fna.fbcdn.net/v/t39.30808-1/324346157_573092641003089_8994177206377802673_n.jpg?stp=dst-jpg_p240x240&_nc_cat=101&ccb=1-7&_nc_sid=7206a8&_nc_ohc=7CEX1x39facAX-dLmAs&_nc_ht=scontent.fhan5-10.fna&oh=00_AfAP5Cncvdbdb2BIdv6pxL4a9ZEyefqcu5nWgoJ7_UFZrw&oe=644A863A','2001-04-14'),(2,'Nguyễn Hoàng Duong','Gia Bình - Bắc Ninh','hoangduongnguyen.ptit@gmail.com','092342343','https://scontent.fhan5-11.fna.fbcdn.net/v/t39.30808-6/278534687_3198224627133355_3470095109332184846_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=174925&_nc_ohc=MJsE-MQBEKIAX-0YwxY&_nc_ht=scontent.fhan5-11.fna&oh=00_AfAk79q8zNl-d-PoVueKb0F1hoIStcF79Mk-dxhgWYMIzA&oe=644A123C','2001-04-14'),(3,'Nguyễn Hoàng Duong','Gia Bình - Bắc Ninh','bennv14@gmail.com','092342342','https://scontent.fhan5-2.fna.fbcdn.net/v/t1.6435-9/110175814_2701368460152310_6513542925692273288_n.jpg?_nc_cat=102&ccb=1-7&_nc_sid=174925&_nc_ohc=m7uJnobF15IAX-g7e2H&_nc_ht=scontent.fhan5-2.fna&oh=00_AfD5sptaQXVzpaZi54QNqq9FeyvIP9Y5vScj-bT0knB26w&oe=646C44C4','2001-04-14'),(17,'Nguyễn Hoàng Duong','Bắc Ninh','ben@gmail.com','09727642874',NULL,'2023-05-01'),(18,'Nguyễn Hoàng Duong','Bắc Ninh','ben@gmail.com','09727642871',NULL,'2023-05-01'),(19,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','0963778434',NULL,'2023-05-04'),(20,'Nguyễn Bến','Bắc Ninh','ben@gmail.com','825945205',NULL,'2023-05-15'),(21,'Nguyen Hoang Duong','NC2-A Khu đô thị Cầu Bươu','hoangduong212121photo5@gmail.com','0123456789',NULL,'2023-05-17');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:22
CREATE DATABASE  IF NOT EXISTS `supermarket_ws` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `supermarket_ws`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket_ws
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `id_supplier` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblcustomer`
--

DROP TABLE IF EXISTS `tblcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcustomer` (
  `id` int NOT NULL,
  `tbl_payment_cardid` int DEFAULT NULL,
  `tbl_memberid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKg6qv21muh4287d7agb9ms1jew` FOREIGN KEY (`id`) REFERENCES `tblmember` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcustomer`
--

LOCK TABLES `tblcustomer` WRITE;
/*!40000 ALTER TABLE `tblcustomer` DISABLE KEYS */;
INSERT INTO `tblcustomer` VALUES (1,NULL,NULL),(29,NULL,NULL),(32,NULL,NULL),(33,NULL,NULL),(34,NULL,NULL),(35,NULL,NULL),(36,NULL,NULL),(37,NULL,NULL),(38,NULL,NULL);
/*!40000 ALTER TABLE `tblcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmember`
--

DROP TABLE IF EXISTS `tblmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmember` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin NOT NULL,
  `tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmember`
--

LOCK TABLES `tblmember` WRITE;
/*!40000 ALTER TABLE `tblmember` DISABLE KEYS */;
INSERT INTO `tblmember` VALUES (1,'customer','customer','Nguyễn Hoàng Dương','Bac Ninh','0123456789','2001-01-01','abc@gmail.com'),(2,'warehousestaff','warehousestaff','WareHouse Staff A','Ha Noi','0123456987','2001-01-01','abc@gmail.com'),(3,'shipper3','shipper3','Nguyen Van Anh','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(4,'shipper4','shipper4','Tran Van An','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(5,'shipper5','shipper5','Shipper 5','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(6,'shipper6','shipper6','Shipper 6','Ha Noi','0123456879','2001-01-01','abc@gmail.com'),(29,'hoangduongngg','hoangduongngg','Nguyễn Bến','Ha Noi','0123456789','2022-10-19','hoangduongngg@gmail.com'),(32,'nguyenvanb','nguyenvanb','Nguyen Van B','HaNoi','0123456789','2022-11-03','duongnh.b19cn153@stu.ptit.edu.vn'),(33,'nguyenvanc','nguyenvana','Nguyen Van C','HaNoi','0123456789','2022-11-30','duongnh.b19cn153@stu.ptit.edu.vn'),(34,'hoanglynamduong','hoanglynamduong','Hoang Ly Nam Duong','Ha Noi','0123456789','2022-10-19','hoangduongngg@gmail.com'),(35,'nguyenvand','nguyenvand','Nguyễn Hoàng Dương','Ha Noi','0123456789','2022-12-08','hoangduong212121photo5@gmail.com'),(36,'nguyenvana','nguyenvana','Nguyễn Hoàng Dương','Thanh Tri, Ha Noi','0123456789','2022-11-24','hoangduong212121photo5@gmail.com'),(37,'nguyenvane','nguyenvane','Nguyen Van E','Ha Noi','0123456789','2022-12-08','hoangduong212121photo5@gmail.com'),(38,'helios.graphic','helios.graphic','Nguyễn Hoàng Dương','NC2-A Khu &#273;� th&#7883; C&#7847;u B&#432;&#417;u','0123456789','2022-11-03','hoangduong212121photo5@gmail.com');
/*!40000 ALTER TABLE `tblmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorder`
--

DROP TABLE IF EXISTS `tblorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `reason_cancel` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status_delivery` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status_order` varchar(255) COLLATE utf8_bin NOT NULL,
  `note` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tbl_customerid` int DEFAULT NULL,
  `tbl_shipperid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5w1evcjabydklxa57w8o1h54u` (`tbl_customerid`),
  CONSTRAINT `FK5w1evcjabydklxa57w8o1h54u` FOREIGN KEY (`tbl_customerid`) REFERENCES `tblcustomer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorder`
--

LOCK TABLES `tblorder` WRITE;
/*!40000 ALTER TABLE `tblorder` DISABLE KEYS */;
INSERT INTO `tblorder` VALUES (1,'online','2023-03-01','2023-03-01',NULL,'2023-05-01',NULL,'delivered','bill',NULL,1,3),(5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cart',NULL,29,5),(6,NULL,'2023-03-01',NULL,NULL,NULL,NULL,NULL,'order',NULL,1,NULL),(7,'online','2023-03-01','2023-03-01',NULL,NULL,NULL,'delivering','bill',NULL,29,6),(8,'online','2023-03-01','2023-03-01','2023-03-01',NULL,'Khong nghe may','cancel','bill',NULL,29,3),(9,'online','2023-03-01','2023-03-01','2023-03-01',NULL,'Khong nhan hang','cancel','bill',NULL,29,NULL),(10,'online','2023-04-01','2023-04-01',NULL,NULL,NULL,'delivered','bill',NULL,29,3),(11,'online','2023-05-01','2023-05-01',NULL,NULL,NULL,'delivering','bill',NULL,29,2),(12,NULL,'2023-05-01',NULL,NULL,NULL,NULL,NULL,'waitingforpayment',NULL,29,NULL),(13,'online','2023-05-01','2023-05-01',NULL,NULL,NULL,'delivering','bill',NULL,29,3),(14,'online','2023-05-01','2023-05-01',NULL,NULL,NULL,'preparing','bill',NULL,35,NULL),(15,'online','2023-05-01','2023-05-01',NULL,NULL,NULL,'preparing','bill',NULL,36,NULL),(16,'online','2023-05-16','2023-05-16',NULL,NULL,NULL,'delivered','bill',NULL,29,3),(17,'online','2023-05-16','2023-05-16',NULL,NULL,NULL,'preparing','bill',NULL,29,NULL),(18,'online','2023-05-16','2023-05-16',NULL,NULL,NULL,'preparing','bill',NULL,29,NULL),(19,NULL,'2023-05-16',NULL,NULL,NULL,NULL,NULL,'order',NULL,29,NULL),(21,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cart',NULL,1,NULL),(22,NULL,'2023-05-17',NULL,NULL,NULL,NULL,NULL,'order',NULL,2,NULL),(23,NULL,'2023-05-17',NULL,NULL,NULL,NULL,NULL,'order',NULL,2,NULL),(24,NULL,'2023-05-17',NULL,NULL,NULL,NULL,NULL,'order',NULL,2,NULL),(25,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cart',NULL,2,NULL);
/*!40000 ALTER TABLE `tblorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblorderdetail`
--

DROP TABLE IF EXISTS `tblorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblorderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `tbl_productid` int NOT NULL,
  `tbl_orderid` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5jly2mehmqhqlpf2ord5j7qvh` (`tbl_orderid`),
  CONSTRAINT `FK5jly2mehmqhqlpf2ord5j7qvh` FOREIGN KEY (`tbl_orderid`) REFERENCES `tblorder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblorderdetail`
--

LOCK TABLES `tblorderdetail` WRITE;
/*!40000 ALTER TABLE `tblorderdetail` DISABLE KEYS */;
INSERT INTO `tblorderdetail` VALUES (1,1,100,1,1),(12,9,100,1,5),(14,2,100,2,5),(15,3,100,1,7),(16,1,100,2,7),(17,1,100,1,8),(18,3,100,1,9),(19,3,100,2,10),(21,1,100,1,10),(22,2,100,1,11),(23,2,100,1,12),(25,2,100,2,13),(26,1,100,2,9),(28,2,100,1,14),(29,3,100,1,15),(31,3,100,1,16),(32,3,100,1,17),(33,3,100,1,18),(34,1,100,1,19),(35,8,100,1,6),(36,1,12000,2,6),(37,1,12000,3,6),(38,1,100,10,6),(41,2,100,1,21),(42,2,100,1,22),(43,2,100,1,23),(44,1,100,5,24);
/*!40000 ALTER TABLE `tblorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblpaymentcard`
--

DROP TABLE IF EXISTS `tblpaymentcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblpaymentcard` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cardNumber` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardCVV` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardName` varchar(45) COLLATE utf8_bin NOT NULL,
  `cardOutDate` date NOT NULL,
  `card_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_number` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `card_out_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblpaymentcard`
--

LOCK TABLES `tblpaymentcard` WRITE;
/*!40000 ALTER TABLE `tblpaymentcard` DISABLE KEYS */;
INSERT INTO `tblpaymentcard` VALUES (1,'123456789','123','NGUYEN HOANG DUONG','2025-01-01',NULL,NULL,NULL),(29,'215645452315615','123','NGUYEN HOANG DUONG','2022-10-06',NULL,NULL,NULL),(30,'123456789','123','NGUYEN VAN A','2022-11-10',NULL,NULL,NULL),(31,'123456789','123','NGUYEN VAN A','2022-11-25',NULL,NULL,NULL),(32,'12345789','235','NGUYEN VAN A','2022-11-17',NULL,NULL,NULL),(33,'123456789','123','NGUYEN VAN A','2022-11-16',NULL,NULL,NULL),(34,'3545345345','123','Nguyen Hoang Duong','2022-11-10',NULL,NULL,NULL),(35,'1234568223','123','NGUYEN VAN A','2022-11-03',NULL,NULL,NULL),(36,'545465','123','NGUYEN VAN A','2022-11-09',NULL,NULL,NULL),(37,'152364','123','NGUYEN VAN A','2022-11-02',NULL,NULL,NULL),(38,'123642566','123','NGUYEN VAN A','2022-11-22',NULL,NULL,NULL);
/*!40000 ALTER TABLE `tblpaymentcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproduct` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `img` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` int NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `mfg_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` VALUES (1,'Nike 1 \'071','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(2,'Nike Air 1','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(3,'Nike Air 3','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(4,'Nike Air 4','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(5,'Nike Air 5','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(6,'Nike Air 6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(7,'Nike Air 7','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL),(8,'Nike Air 8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',10,NULL);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-17 14:01:22
CREATE DATABASE  IF NOT EXISTS `microsv_supplier` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `microsv_supplier`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: microsv_supplier
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `import_bill`
--

DROP TABLE IF EXISTS `import_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_time` date DEFAULT NULL,
  `creator_id` bigint DEFAULT NULL,
  `supplier_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_bill`
--

LOCK TABLES `import_bill` WRITE;
/*!40000 ALTER TABLE `import_bill` DISABLE KEYS */;
INSERT INTO `import_bill` VALUES (24,'2023-05-05',3,29),(25,'2023-05-12',3,30),(26,'2023-05-12',3,29),(27,'2023-05-12',3,29);
/*!40000 ALTER TABLE `import_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `import_detail`
--

DROP TABLE IF EXISTS `import_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `import_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_time` date NOT NULL,
  `import_bill_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `quantity` int NOT NULL,
  `supplier_id` bigint NOT NULL,
  `unit_price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `import_detail`
--

LOCK TABLES `import_detail` WRITE;
/*!40000 ALTER TABLE `import_detail` DISABLE KEYS */;
INSERT INTO `import_detail` VALUES (23,'2023-05-05',24,10,100,29,100),(24,'2023-05-05',24,11,100,29,100),(25,'2023-05-05',24,12,100,29,100),(26,'2023-05-12',25,10,200,30,200),(27,'2023-05-12',25,11,200,30,200),(28,'2023-05-12',25,12,200,30,200),(29,'2023-05-12',26,10,10,29,10),(30,'2023-05-12',26,11,10,29,10),(31,'2023-05-12',27,11,12,29,2.6);
/*!40000 ALTER TABLE `import_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (10,'t','t','t','product1',1,1338),(11,'t','t','t','product2',2,344),(12,'t','t','t','product3',3,1319);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (29,'sup1','sup1','0000000001'),(30,'sup2','sup2','0000000002'),(33,'sup4','sup4','sup4');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproduct` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `img` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` float NOT NULL,
  `quantity` int DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` VALUES (1,'Nike 1 \'071','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/aee23c65-5ed1-4a07-aeff-180b2ad74c00/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(2,'Nike Air 1','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(3,'Nike Air 3','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(4,'Nike Air 4','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(5,'Nike Air 5','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(6,'Nike Air 6','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(7,'Nike Air 7','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL),(8,'Nike Air 8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/f094af40-f82f-4fb9-a246-e031bf6fc411/air-force-1-07-shoe-NMmm1B.png',100,10,'The radiance lives on in the Nike Air Force 1 \'07, the b-ball icon that puts a fresh spin on what you know best: crisp leather, bold colours and the perfect amount of flash to make you shine.',NULL);
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblshipper`
--

DROP TABLE IF EXISTS `tblshipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblshipper` (
  `tblMemberid` int NOT NULL,
  `tbl_memberid` int NOT NULL,
  PRIMARY KEY (`tblMemberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblshipper`
--

LOCK TABLES `tblshipper` WRITE;
/*!40000 ALTER TABLE `tblshipper` DISABLE KEYS */;
INSERT INTO `tblshipper` VALUES (3,0),(4,0),(5,0),(6,0);
/*!40000 ALTER TABLE `tblshipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstaff`
--

DROP TABLE IF EXISTS `tblstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblstaff` (
  `tblMemberid` int NOT NULL,
  `position` varchar(255) COLLATE utf8_bin NOT NULL,
  `tbl_memberid` int NOT NULL,
  PRIMARY KEY (`tblMemberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstaff`
--

LOCK TABLES `tblstaff` WRITE;
/*!40000 ALTER TABLE `tblstaff` DISABLE KEYS */;
INSERT INTO `tblstaff` VALUES (2,'warehousestaff',0),(3,'shipper',0);
/*!40000 ALTER TABLE `tblstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsupplier`
--

DROP TABLE IF EXISTS `tblsupplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblsupplier` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `des` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsupplier`
--

LOCK TABLES `tblsupplier` WRITE;
/*!40000 ALTER TABLE `tblsupplier` DISABLE KEYS */;
INSERT INTO `tblsupplier` VALUES (1,'APPLE',NULL),(2,'DANISA',NULL),(3,'NIKE',NULL);
/*!40000 ALTER TABLE `tblsupplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblwarehousestaff`
--

DROP TABLE IF EXISTS `tblwarehousestaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblwarehousestaff` (
  `tblMemberid` int NOT NULL,
  `tbl_memberid` int NOT NULL,
  PRIMARY KEY (`tblMemberid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblwarehousestaff`
--

LOCK TABLES `tblwarehousestaff` WRITE;
/*!40000 ALTER TABLE `tblwarehousestaff` DISABLE KEYS */;
INSERT INTO `tblwarehousestaff` VALUES (2,0);
/*!40000 ALTER TABLE `tblwarehousestaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_type` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('MANAGER',1,NULL,'Manager 1','tk',NULL,'tk'),('CUSTOMER',2,NULL,'Customer 1','customer',NULL,'customer'),('WAREHOUSE_WORKER',3,NULL,'WWorker 1','kho',NULL,'kho');
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

-- Dump completed on 2023-05-17 14:01:23
