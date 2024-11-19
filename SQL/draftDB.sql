CREATE DATABASE IF NOT EXISTS `draftDB`;
USE draftDB;

DROP TABLE IF EXISTS `draftDB`.`items`;
CREATE TABLE `draftDB`.`items` (
  `ITEM_ID` varchar(45) NOT NULL,
  `SUPPLIER_ID` varchar(45) NOT NULL,
  `STAFF_ID` varchar(45) DEFAULT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `QUANTITY` int NOT NULL,
  `EXPIRY_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `draftDB`.`suppliers`;
CREATE TABLE `draftDB`.`suppliers` (
  `SUPPLIER_ID` varchar(45) NOT NULL,
  `ITEM_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CONTACT_NO` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SUPPLIER_ID`,`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `draftDB`.`customers`;
CREATE TABLE `draftDB`.`customers` (
  `CUSTOMER_ID` VARCHAR(45) NOT NULL,
  `ITEM_ID` VARCHAR(45) NOT NULL,
  `QUANTITY` INT NULL,
  `PURCHASE_DATE` DATE NULL,
  `NAME` VARCHAR(45) NULL,
  `CONTACT_NO` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `CITY` VARCHAR(45) NULL,
  PRIMARY KEY (`CUSTOMER_ID`));

INSERT INTO `draftDB`.`items` (`ITEM_ID`, `SUPPLIER_ID`, `STAFF_ID`, `NAME`, `DESCRIPTION`, `QUANTITY`, `EXPIRY_DATE`) VALUES ('I100', 'S100', 'ST04', 'VitA-Pills', 'Vitamin A, 500 mg Tablets', '125', '2025-11-07 00:00:00');
INSERT INTO `draftDB`.`items` (`ITEM_ID`, `SUPPLIER_ID`, `STAFF_ID`, `NAME`, `DESCRIPTION`, `QUANTITY`, `EXPIRY_DATE`) VALUES ('I101', 'S100', 'ST04', 'VitB-Pills', 'Vitamin B, 500 mg Tablets', '150', '2025-11-07 00:00:00');
INSERT INTO `draftDB`.`items` (`ITEM_ID`, `SUPPLIER_ID`, `STAFF_ID`, `NAME`, `DESCRIPTION`, `QUANTITY`, `EXPIRY_DATE`) VALUES ('I102', 'S100', 'ST04', 'VitC-Pills', 'Vitamin C, 500 mg Tablets', '175', '2025-11-07 00:00:00');
INSERT INTO `draftDB`.`items` (`ITEM_ID`, `SUPPLIER_ID`, `STAFF_ID`, `NAME`, `DESCRIPTION`, `QUANTITY`, `EXPIRY_DATE`) VALUES ('I103', 'S101', 'ST05', 'Apple Juice', 'Organic, 500 mL, Bottle', '50', '2024-12-07 00:00:00');
INSERT INTO `draftDB`.`items` (`ITEM_ID`, `SUPPLIER_ID`, `STAFF_ID`, `NAME`, `DESCRIPTION`, `QUANTITY`, `EXPIRY_DATE`) VALUES ('I104', 'S101', 'ST05', 'Almond Milk', 'Unsweetened, 1000 mL, Carton', '25', '2024-11-28 00:00:00');

INSERT INTO `draftDB`.`suppliers` (`SUPPLIER_ID`, `ITEM_ID`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('S100', 'I100', 'Health Store Corp.', '+63-931-136-7892', 'orders@healthstore.com', 'Manila');
INSERT INTO `draftDB`.`suppliers` (`SUPPLIER_ID`, `ITEM_ID`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('S100', 'I101', 'Health Store Corp.', '+63-931-136-7892', 'orders@healthstore.com', 'Manila');
INSERT INTO `draftDB`.`suppliers` (`SUPPLIER_ID`, `ITEM_ID`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('S100', 'I102', 'Health Store Corp.', '+63-931-136-7892', 'orders@healthstore.com', 'Manila');
INSERT INTO `draftDB`.`suppliers` (`SUPPLIER_ID`, `ITEM_ID`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('S101', 'I103', 'PrimeSource Inc.', '+63-937-492 8493', 'sales@primesource.inc', 'San Pablo');
INSERT INTO `draftDB`.`suppliers` (`SUPPLIER_ID`, `ITEM_ID`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('S102', 'I103', 'PrimeSource Inc.', '+63-937-492 8493', 'sales@primesource.inc', 'San Pablo');