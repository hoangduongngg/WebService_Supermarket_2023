CREATE DATABASE  IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `products`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: products
-- ------------------------------------------------------
-- Server version	8.0.32

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
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `img` varchar(300) DEFAULT NULL,
  `price` int NOT NULL DEFAULT '0',
  `units` int NOT NULL DEFAULT '0',
  `description` varchar(600) DEFAULT NULL,
  `expiration_date` varchar(255) NOT NULL,
  `id_supplier` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idt_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'Kem que sữa rừa','https://kemtrangtien.vn/upload/product/thumb_800x0/kem-que-sua-dua-1596013396.png',12000,1000,'Kem que vị sữa dừa','6 tháng',1),(4,'Mì tôm hào hảo','http://res.cloudinary.com/dne2tjjym/image/upload/v1682485194/products/product_4.jpg',120000,100,'Sợi mì vàng dai ngon hòa quyện trong nước súp tôm chua cay Hảo Hảo, đậm đà thấm đẫm từng sợi sóng sánh cùng hương thơm quyến rũ ngất ngây. Mì Hảo Hảo tôm chua cay gói 75g là lựa chọn hấp dẫn không thể bỏ qua đặc biệt là những ngày bận rộn cần bổ sung năng lượng nhanh chóng đơn giản mà vẫn đủ chất','3 tháng',0),(5,'Nước mắm đầu bếp tôm','https://cdn.tgdd.vn/Products/Images/2289/260185/bhx/nuoc-cham-dau-bep-tom-chai-900ml-202211040839259637.jpg',18000,1000,'Nước mắm của thương hiệu nước mắm Đầu Bếp Tôm được chế biến từ những con tôm tươi được tuyển chọn. Nước chấm Đầu Bếp Tôm chai 900ml được làm từ cốt tôm thật, với vị mặn dịu và ngọt nhẹ, giúp tăng thêm hương vị cho các món ăn hằng ngày.','10 tháng',0),(6,'Nước giặt Ariel','https://cdn.tgdd.vn/Products/Images/2464/237563/bhx/nuoc-giat-ariel-matic-cua-truoc-tuoi-mat-ruc-ro-tui-32kg-202206031636559276.jpg',195000,100,'Với công thức tiên tiến hàng đầu, nước giặt Ariel đánh bay vết bẩn cứng đầu cực nhanh, xài cực bền cho máy giặt của bạn nên là loại nước giặt được các chị em nội trợ ưa chuộng hàng đầu. Nước giặt Ariel hương Downy nắng sớm túi 3.1 lít giúp quần áo sạch nhanh, hương thơm tươi mát dễ chịu.','1 năm',0),(7,'6 lon nước ngọt pepsi','https://cdn.tgdd.vn/Products/Images/2443/227313/bhx/loc-6-lon-nuoc-ngot-pepsi-khong-calo-330ml-202103162336336531.jpg',60000,1000,'Là loại nước ngọt được nhiều người yêu thích đến từ thương hiệu nước ngọt Pepsi nổi tiếng thế giớivới hương vị thơm ngon, sảng khoái. 6 lon nước ngọt Pepsi không calo lon 320ml với lượng gas lớn sẽ giúp bạn xua tan mọi cảm giác mệt mỏi, căng thẳng, sản phẩm không calo lành mạnh, tốt cho sức khỏe','2 tháng',0),(8,'Nước ngọt 7 Up vị chanh chai 1.5 lít','https://cdn.tgdd.vn/Products/Images/2443/83599/bhx/nuoc-ngot-co-gas-7up-pet-15l-2-org.jpg',20000,1000,'Nước ngọt chính hãng nước ngọt 7Up uy tín được nhiều người ưa chuộng. Nước ngọt 7 Up hương chanh 1.5 lít có vị ngọt vừa phải và hương vị gas the mát, giúp bạn xua tan nhanh chóng cơn khát, giảm cảm giác ngấy, kích thích vị giác giúp ăn ngon hơn, cung cấp năng lượng cho tinh thần tươi vui mỗi ngày','4 tháng',0),(9,'Nước dừa tươi Vietcoco Organic 330ml','https://cdn.tgdd.vn/Products/Images/3265/282986/bhx/nuoc-dua-tuoi-vietcoco-organic-330ml-202206211109563095.jpg',20000,1000,'Một trong những loại nước trái cây thơm ngon hấp dẫn, tươi mát giúp giải nhiệt hiệu quả, nước dừa Vietcoco là lựa chọn chất lượng, nhiều công dụng, nhiều dinh dưỡng phù hợp cho mọi đối tượng. Nước dừa tươi Vietcoco Organic 330ml đảm bảo nguyên chất 100%, an toàn và tốt cho sức khỏe cả nhà','7 tháng',0),(10,'Bim bim oisi pho mát miếng','https://cdn.tgdd.vn/Products/Images/3364/303931/bhx/snack-pho-mat-mieng-oishi-goi-39g-202303071115144214.jpg',5000,10000,'snack pho mát miếng Oishi 39g là loại bánh snack giòn ngon, thơm thơm vị phô mát kích thích vị giác vô cùng hấp dẫn, phù hợp vừa xem phim, vừa nghe nhạc vừa nhâm nhi thưởng thức. Snack Oishi tiện lợi, nhỏ gọn, dễ mang theo cho các buổi hoạt động ngoài trời.','4 tháng',0),(11,'Thùng 12 lon bia Tiger 500ml','https://cdn.tgdd.vn/Products/Images/2282/285976/bhx/thung-12-lon-bia-tiger-500ml-202208161004109553.jpg',210000,100,'Hương vị bia truyền thống thơm ngon từ năm 1932, được nhiều người yêu thích tại Việt Nam. Thùng 12 lon bia Tiger 500ml chính hãng bia Tiger lon lớn cực đã, uống sảng khoái hơn cho bạn những giây phút thư giãn thoải mái cùng gia đình, bạn bè, đồng nghiệp','7 tháng',0),(12,'Dầu gội Sunsilk óng mượt rạng ngời 874ml','https://cdn.tgdd.vn/Products/Images/2483/81008/bhx/sunsilk-dg-den-ong-muot-rang-ngoi-900g-8-chai-2-org.jpg',192000,100,'Dầu gội Sunsilk bồ kết óng mượt rạng ngời 874ml chứa tinh chất bồ kết tái tạo cấu trúc tóc bị phá vỡ, cho mái tóc óng mượt. Dầu gội Sunsilk giúp bảo vệ tóc trước tia UV, cùng mức giá phải chăng so với sản phẩm dầu gội khác trên thị trường.','2 năm',0),(14,'Nước hoa nam Laura Anne Allure 50ml','http://res.cloudinary.com/dne2tjjym/image/upload/v1683557881/products/product_14.jpg',249000,1000,'Nước hoa Laura Anne chất lượng, mang đến hương thơm nam tính đầy mê hoặc. Nước hoa nam Laura Anne Allure 50ml nhỏ gọn, tiện lợi để mang theo bên người khi đi chơi xa, mang đến cảm giác tự tin, sảng khoải và tràn đầy năng lượng. Nước hoa là một vật không thể thiếu của nhiều người','1 năm',0),(15,'Trứng gà Happy Egg hộp 10 quả','https://res.cloudinary.com/dne2tjjym/image/upload/v1683533068/products/istockphoto-1055079680-612x612_u1guwi.jpg',32000,1000,'Hộp 10 trứng gà Happy Egg được đóng gói và bảo quản theo những tiêu chuẩn nghiêm ngặt về vệ sinh và an toàn thực phẩm, đảm bảo về chất lượng của thực phẩm. Trứng gà to tròn, đều. Trứng gà Happy Egg có thể luộc chín chế biến thành một số món ăn khác như: thịt kho trứng, cơm chiên trứng,...','1 tháng',0),(16,'Thùng 30 gói mì khoai tây','https://res.cloudinary.com/dne2tjjym/image/upload/v1683533068/products/istockphoto-1055079680-612x612_u1guwi.jpg',252000,100,'Sợi mì từ trứng và khoai tây vàng dai ngon hòa trong nước súp Omachi xốt bò hầm đậm đà cùng hương thơm nứt mũi tạo ra siêu phẩm mì với sự kết hợp hương vị hài hòa, độc đáo. 30 gói mì khoai tây Omachi xốt bò hầm 80g tiện lợi, thơm ngon hấp dẫn không thể chối từ','76 ngày',0),(26,'Sáp thơm Ambi Pur hương hoa downy 180g','http://res.cloudinary.com/dne2tjjym/image/upload/v1683561807/products/product_26.jpg',46000,11,'Thương hiệu sáp thơm Ambi Pur của Tây Ban Nha, với những công thức cải tiến trong việc lưu hương và toả hương, sáp thơm Ambi Pur giúp cả căn nhà bạn luôn thơm ngát, thoải mái. Sáp thơm Ambi Pur hương hoa downy 180g hương hoa downy dễ chịu cho cả căn nhà','1 năm',0),(27,'Sáp thơm Ambi Pur hương hoa tươi mát 180g','https://res.cloudinary.com/dne2tjjym/image/upload/v1683533068/products/istockphoto-1055079680-612x612_u1guwi.jpg',46000,11,'Thương hiệu sáp thơm Ambi Pur của Tây Ban Nha, với những công thức cải tiến trong việc lưu hương và toả hương, sáp thơm Ambi Pur giúp cả căn nhà bạn luôn thơm ngát, thoải mái. Sáp thơm Ambi Pur hương hoa tươi mát 180g mang tới hương hoa tươi mát cho cả căn nhà','1 năm',0);
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

-- Dump completed on 2023-05-10  2:23:54
