CREATE DATABASE IF NOT EXISTS `draftDB`;
USE draftDB;

DROP TABLE IF EXISTS `draftDB`.`returns`;
DROP TABLE IF EXISTS `draftDB`.`payrolls`;
DROP TABLE IF EXISTS `draftDB`.`payment_details`;
DROP TABLE IF EXISTS `draftDB`.`staff`;
DROP TABLE IF EXISTS `draftDB`.`jobs`;
DROP TABLE IF EXISTS `draftDB`.`sales`;
DROP TABLE IF EXISTS `draftDB`.`supplier_item_cost`;
DROP TABLE IF EXISTS `draftDB`.`purchases`;
DROP TABLE IF EXISTS `draftDB`.`customers`;
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

CREATE TABLE `draftDB`.`customers` (
  `customer_id` varchar(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `contact_number` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`purchases` (
  `purchase_id` varchar(5) NOT NULL,
  `item_id` varchar(5) NOT NULL,
  `purchase_date` date NOT NULL,
  `quantity` int NOT NULL,
  `expiration_date` date DEFAULT NULL,
  PRIMARY KEY (`purchase_id`),
  FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`supplier_item_cost` (
  `item_id` varchar(4) NOT NULL,
  `supplier_id` varchar(4) NOT NULL,
  `unit_cost` decimal(10,2) NOT NULL,
  PRIMARY KEY (`item_id`,`supplier_id`),
  FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`),
  FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`sales` (
  `sale_id` varchar(5) NOT NULL,
  `customer_id` varchar(5) NOT NULL,
  `item_id` varchar(5) NOT NULL,
  `quantity` int NOT NULL,
  `sale_date` date NOT NULL,
  PRIMARY KEY (`sale_id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  FOREIGN KEY (`item_id`) REFERENCES `items` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`jobs` (
  `job_id` varchar(5) NOT NULL,
  `job_title` varchar(45) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`staff` (
  `staff_id` varchar(5) NOT NULL,
  `name` varchar(45) NOT NULL,
  `date_employed` date NOT NULL,
  `date_released` date DEFAULT NULL,
  `job_id` varchar(5) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`staff_id`),
  FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`payment_details` (
  `payment_id` varchar(5) NOT NULL,
  `payment_date` date NOT NULL,
  `bonus_penalty` varchar(45) NOT NULL,
  `percentage` decimal(10,2) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`payrolls` (
  `payroll_id` varchar(5) NOT NULL,
  `staff_id` varchar(5) NOT NULL,
  `payment_id` varchar(5) NOT NULL,
  PRIMARY KEY (`payroll_id`),
  FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  FOREIGN KEY (`payment_id`) REFERENCES `payment_details` (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `draftDB`.`returns` (
  `return_id` varchar(5) NOT NULL,
  `pharmacist_id` varchar(5) NOT NULL,
  `sale_id` varchar(5) NOT NULL,
  `return_reason` varchar(45) DEFAULT NULL,
  `return_date` varchar(45) NOT NULL,
  PRIMARY KEY (`return_id`),
  FOREIGN KEY (`pharmacist_id`) REFERENCES `staff` (`staff_id`),
  FOREIGN KEY (`sale_id`) REFERENCES `sales` (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I100', 'VitA-Pills', 'Vitamin A, 500 mg Tablets', '125', '1000');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I101', 'VitB-Pills', 'Vitamin B, 500 mg Tablets', '150', '1200');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I102', 'VitC-Pills', 'Vitamin C, 500 mg Tablets', '175', '1200');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I103', 'Apple Juice', 'Organic, 500 mL, Bottle', '50', '120');
INSERT INTO `draftDB`.`items` (`item_id`, `name`, `description`, `quantity`, `selling_price`) VALUES ('I104', 'Almond Milk', 'Unsweetened, 1000 mL, Carton', '25', '300');

INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S100', 'ST104', 'Health Store Corp.', '+63-931-136-7892', 'orders@healthstore.com', 'Manila');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S101', 'ST103', 'PrimeSource Inc.', '+63-937-492 8493', 'sale@primesource.inc', 'San Pablo');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S102', 'ST102', 'MediSupplyPro', '+63-932-834-4389', 'ordersOffice@MediSupply.com', 'Mandaluyong');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S103', 'ST103', 'LifeLine Med Distributors', ' +63-917-586-0450', 'saleDept@LifeLineMD.com', 'Muntinlupa');
INSERT INTO `draftDB`.`suppliers` (`supplier_id`, `assigned_staff_id`, `name`, `contact_number`, `email`, `city`) VALUES ('S104', 'ST102', 'Allied Pharma Solutions', '+63-926-903-3944', 'saleOffice@AlliedPharma.com', 'Muntinlupa');

INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I100', 'S100', '800.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I101', 'S100', '1100.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I102', 'S100', '1100.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I103', 'S101', '80.00');
INSERT INTO `draftDB`.`supplier_item_cost` (`item_id`, `supplier_id`, `unit_cost`) VALUES ('I104', 'S101', '180.00');

INSERT INTO `draftDB`.`customers` (`customer_id`, `name`, `contact_number`, `email`, `city`) VALUES ('C100', 'Carlos Gomez Villanueva', '+63-922-4848', 'carlosVill@gmail.com', 'Davao');
INSERT INTO `draftDB`.`customers` (`customer_id`, `name`, `contact_number`, `email`, `city`) VALUES ('C101', 'Liam Santos Rodrigue', '+63-924-39351', 'liamSR129@gmail.com', 'Pasay');
INSERT INTO `draftDB`.`customers` (`customer_id`, `name`, `contact_number`, `email`, `city`) VALUES ('C102', 'Samuel Cruz Bautista', '+63-917-321-1239', 'samBautista088@gmail.com', 'Naga');
INSERT INTO `draftDB`.`customers` (`customer_id`, `name`, `contact_number`, `email`, `city`) VALUES ('C103', 'Enrico Morales Fernandez', '+63-926-095-3950', 'emf2302@gmail.com', 'Vigan');
INSERT INTO `draftDB`.`customers` (`customer_id`, `name`, `contact_number`, `email`, `city`) VALUES ('C104', 'Jonas Lopez Martinez', '+63-956-493-5911', 'jomartinez@gmail.com', 'Dasmariñas');

INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU100', 'I101', '2023-06-20', '70', '2026-01-13');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU101', 'I100', '2023-06-20', '70', '2026-01-13');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU102', 'I104', '2023-06-20', '30', '2026-01-13');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU103', 'I104', '2024-02-11', '50', '2026-01-25');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU104', 'I103', '2024-02-11', '100', '2026-01-25');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU105', 'I100', '2024-02-11', '100', '2026-01-25');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU106', 'I102', '2024-02-15', '100', '2026-01-20');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU107', 'I103', '2024-02-15', '60', '2026-01-20');
INSERT INTO `draftDB`.`purchases` (`purchase_id`, `item_id`, `purchase_date`, `quantity`, `expiration_date`) VALUES ('PU108', 'I104', '2024-02-23', '60', '2026-01-20');

INSERT INTO `draftDB`.`jobs` (`job_id`, `job_title`, `salary`) VALUES ('J100', 'Pharmacist', '25000');
INSERT INTO `draftDB`.`jobs` (`job_id`, `job_title`, `salary`) VALUES ('J101', 'Inventory Manager', '28000');
INSERT INTO `draftDB`.`jobs` (`job_id`, `job_title`, `salary`) VALUES ('J102', 'Security Guard', '22000');
INSERT INTO `draftDB`.`jobs` (`job_id`, `job_title`, `salary`) VALUES ('J103', 'Store Manager', '50000');
INSERT INTO `draftDB`.`jobs` (`job_id`, `job_title`, `salary`) VALUES ('J104', 'Pharmacy Assistant', '23000');

INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST100', 'Emma de la Cruz', '2022-06-01', 'J100', 'Employed');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST101', 'Liam Nelson', '2023-11-04', 'J100', 'On Leave');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `date_released`, `job_id`, `status`) VALUES ('ST102', 'Ava Basco', '2019-11-07', '2021-04-07', 'J101', 'Fired');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST103', 'Noah David', '2020-08-03', 'J101', 'Employed');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST104', 'David Liwanag', '2020-11-11', 'J101', 'Employed');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST105', 'Gary Ermita', '2022-09-07', 'J102', 'Employed');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST106', 'Olivia de Guzman', '2021-02-04', 'J103', 'Employed');
INSERT INTO `draftDB`.`staff` (`staff_id`, `name`, `date_employed`, `job_id`, `status`) VALUES ('ST107', 'Nathaniel Tolentino', '2024-10-10', 'J104', 'Employed');

INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA100', 'C103', 'I100', '10', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA101', 'C101', 'I102', '8', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA102', 'C100', 'I104', '12', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA103', 'C104', 'I103', '3', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA104', 'C102', 'I100', '34', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA105', 'C102', 'I101', '6', '2024-03-12');
INSERT INTO `draftDB`.`sales` (`sale_id`, `customer_id`, `item_id`, `quantity`, `sale_date`) VALUES ('SA106', 'C104', 'I100', '30', '2024-03-12');

INSERT INTO `draftDB`.`payment_details` (`payment_id`, `payment_date`, `bonus_penalty`, `percentage`) VALUES ('PM100', '2023-06-04', 'None', '0');
INSERT INTO `draftDB`.`payment_details` (`payment_id`, `payment_date`, `bonus_penalty`, `percentage`) VALUES ('PM101', '2023-12-04', 'Bonus', '0.05');

INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA100', 'ST100', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA101', 'ST102', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA102', 'ST103', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA103', 'ST104', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA104', 'ST105', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA105', 'ST106', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA106', 'ST100', 'PM100');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA107', 'ST101', 'PM101');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA108', 'ST102', 'PM101');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA109', 'ST103', 'PM101');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA110', 'ST104', 'PM101');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA111', 'ST105', 'PM101');
INSERT INTO `draftDB`.`payrolls` (`payroll_id`, `staff_id`, `payment_id`) VALUES ('PA112', 'ST106', 'PM101');

INSERT INTO `draftDB`.`returns` (`return_id`, `pharmacist_id`, `sale_id`, `return_reason`, `return_date`) VALUES ('R100', 'ST101', 'SA100', 'Wrong product', '2024-03-13');
INSERT INTO `draftDB`.`returns` (`return_id`, `pharmacist_id`, `sale_id`, `return_reason`, `return_date`) VALUES ('R101', 'ST100', 'SA103', 'Juice canister is broken', '2024-03-13');
INSERT INTO `draftDB`.`returns` (`return_id`, `pharmacist_id`, `sale_id`, `return_reason`, `return_date`) VALUES ('R102', 'ST101', 'SA104', 'Wrong product', '2024-03-13');
INSERT INTO `draftDB`.`returns` (`return_id`, `pharmacist_id`, `sale_id`, `return_reason`, `return_date`) VALUES ('R103', 'ST101', 'SA102', 'Wrong product', '2024-03-14');
INSERT INTO `draftDB`.`returns` (`return_id`, `pharmacist_id`, `sale_id`, `return_reason`, `return_date`) VALUES ('R104', 'ST100', 'SA101', 'Wrong product', '2024-03-14');