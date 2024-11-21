CREATE DATABASE IF NOT EXISTS `draftDB`;
USE draftDB;

DROP TABLE IF EXISTS `draftDB`.`supplier_item_cost`;
DROP TABLE IF EXISTS `draftDB`.`suppliers`;
DROP TABLE IF EXISTS `draftDB`.`items`;

CREATE TABLE `draftDB`.`items` (
  `item_id` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `quantity` int NOT NULL,
  `selling_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`suppliers` (
  `supplier_id` varchar(5) NOT NULL,
  `assigned_staff_id` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `contact_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`supplier_item_cost` (
  `supplier_id` varchar(4) NOT NULL,
  `item_id` varchar(4) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`supplier_id`,`item_id`),
  FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
  FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I100', 'VitA-Pills', 'Vitamin A, 500 mg Tablets', '125', '1000');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I101', 'VitB-Pills', 'Vitamin B, 500 mg Tablets', '150', '1200');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I102', 'VitC-Pills', 'Vitamin C, 500 mg Tablets', '175', '1200');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I103', 'Apple Juice', 'Organic, 500 mL, Bottle', '50', '120');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I104', 'Almond Milk', 'Unsweetened, 1000 mL, Carton', '25', '300');

INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S100', 'ST104', 'Health Store Corp.', '+63-931-136-7892', 'orders@healthstore.com', 'Manila');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S101', 'ST103', 'PrimeSource Inc.', '+63-937-492 8493', 'sales@primesource.inc', 'San Pablo');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S102', 'ST102', 'MediSupplyPro', '+63-932-834-4389', 'ordersOffice@MediSupply.com', 'Mandaluyong');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S103', 'ST103', 'LifeLine Med Distributors', ' +63-917-586-0450', 'salesDept@LifeLineMD.com', 'Muntinlupa');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S104', 'ST102', 'Allied Pharma Solutions', '+63-926-903-3944', 'salesOffice@AlliedPharma.com', 'Muntinlupa');

INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I100', 'S100', '800.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I101', 'S100', '1100.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I102', 'S100', '1100.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I103', 'S101', '80.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I104', 'S101', '180.00');
