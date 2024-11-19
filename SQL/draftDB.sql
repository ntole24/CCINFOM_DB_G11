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
);

DROP TABLE IF EXISTS `draftDB`.`suppliers`;
CREATE TABLE `draftDB`.`suppliers` (
  `SUPPLIER_ID` varchar(45) NOT NULL,
  `ITEM_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CONTACT_NO` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SUPPLIER_ID`,`ITEM_ID`)
);

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
  
  DROP TABLE IF EXISTS `draftDB`,`staff`;
  CREATE TABLE `draftDB`.`staff` (
  `STAFF_ID` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DATE_EMPLOYED` date NOT NULL,
  `DATE_RELEASED` date DEFAULT NULL,
  `POSITION` varchar(45) NOT NULL,
  `SALARY` decimal(18,2) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  PRIMARY KEY (`STAFF_ID`));


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

INSERT INTO `draftDB`.`customers` (`CUSTOMER_ID`, `ITEM_ID`, `QUANTITY`, `PURCHASE_DATE`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('C100', 'I102', '20', '2019-09-11', 'Carlos Gomez Villanueva', '+63-922-4848', 'carlosVill@gmail.com', 'Davao');
INSERT INTO `draftDB`.`customers` (`CUSTOMER_ID`, `ITEM_ID`, `QUANTITY`, `PURCHASE_DATE`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('C101', 'I104', '20', '2019-02-13', 'Liam Santos Rodriguez', '+63-924-39351', 'liamSR129@gmail.com', 'Pasay');
INSERT INTO `draftDB`.`customers` (`CUSTOMER_ID`, `ITEM_ID`, `QUANTITY`, `PURCHASE_DATE`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('C102', 'I104', '25', '2021-12-01', 'Samuel Cruz Bautista', '+63-917-321-1239', 'samBautista088@gmail.com', 'Naga');
INSERT INTO `draftDB`.`customers` (`CUSTOMER_ID`, `ITEM_ID`, `QUANTITY`, `PURCHASE_DATE`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('C103', 'I100', '60', '2019-05-11', 'Enrico Morales Fernandez', '+63-926-095-3950', 'emf2302@gmail.com', 'Vigan');
INSERT INTO `draftDB`.`customers` (`CUSTOMER_ID`, `ITEM_ID`, `QUANTITY`, `PURCHASE_DATE`, `NAME`, `CONTACT_NO`, `EMAIL`, `CITY`) VALUES ('C104', 'I103', '10', '2020-08-29', 'Jonas Lopez Martinez', '+63-956-493-5911', 'jomartinez@gmail.com', 'Dasmariñas');

INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST100', 'Emma de la Cruz', '2022-06-01', 'Pharmacist', '25000', 'Employed');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST101', 'Liam Nelson', '2023-11-04', 'Pharmacist', '25000', 'On Leave');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `DATE_RELEASED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST102', 'Ava Basco', '2019-11-07', '2021-04-07', 'Inventory Manager', '28000', 'Terminated/Fired');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST103', 'Noah David', '2020-08-03', 'Inventory Manager', '32000', 'Employed');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST104', 'David Liwanag', '2020-11-11', 'Inventory Manager', '32000', 'Employed');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST105', 'Garry Ermita', '2022-09-07', 'Security Guard', '22000', 'Employed');
INSERT INTO `draftDB`.`staff` (`STAFF_ID`, `NAME`, `DATE_EMPLOYED`, `POSITION`, `SALARY`, `STATUS`) VALUES ('ST106', 'Olivia de Guzman', '2021-02-04', 'Store Manager', '50000', 'Employed');