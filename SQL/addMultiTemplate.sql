-- Inserting into customers table
INSERT INTO customers (customer_id, name, contact_number, email, city)
SELECT 
    CONCAT('C', LPAD(CAST(SUBSTRING(IFNULL(MAX(customer_id), 'C000'), 2) AS UNSIGNED) + 1, 3, '0')),
    'John Doe',
    '1234567890',
    'john.doe@example.com',
    'New York'
FROM customers;

-- Inserting into items table
INSERT INTO items (item_id, name, description, quantity, selling_price)
SELECT 
    CONCAT('I', LPAD(SUBSTRING(IFNULL(MAX(item_id), 'I000'), 2) + 1, 3, '0')),
    'VitX-Pills',
    'Vitamin X, 1000 mg Tablets',
    '10',
    '2000'
FROM items;

-- Inserting into suppliers table
INSERT INTO suppliers (supplier_id, name, contact_info, email, address)
SELECT
    CONCAT('S', LPAD(SUBSTRING(IFNULL(MAX(supplier_id), 'S000'), 2) + 1, 3, '0')),
    'OnlyLabs Inc.',
    '+63-969-420-6869',
    'sales@OnlyLabs.com',
    'Muntinlupa City' 
FROM suppliers;

-- Inserting into supplier_item_cost table
INSERT INTO supplier_item_cost (item_id, supplier_id, unit_cost)
SELECT 
    'I105', 'S100', '1500.00'
FROM supplier_item_cost;

-- Inserting another row into customers table
INSERT INTO customers (customer_id, purchase_date, name, contact_number, email, city)
SELECT 
    CONCAT('C', LPAD(CAST(SUBSTRING(IFNULL(MAX(customer_id), 'C000'), 2) AS UNSIGNED) + 1, 3, '0')), 
    '2024-11-21', 
    'Emma Rosa Garcia', 
    '+63-999-888-7766', 
    'emma.rosa@example.com', 
    'Cebu'
FROM customers;

-- Inserting into staff table
INSERT INTO staff (staff_id, name, date_employed, job_id, status)
SELECT 
    CONCAT('ST', LPAD(SUBSTRING(IFNULL(MAX(staff_id), 'ST000'), 3) + 1, 3, '0')), 
    'Mark Santiago', 
    '2024-11-21', 
    'J104', 
    'Employed'
FROM staff;

-- Inserting into purchases table
INSERT INTO purchases (purchase_id, item_id, purchase_date, quantity, expiration_date)
SELECT 
    CONCAT('PU', LPAD(SUBSTRING(IFNULL(MAX(purchase_id), 'PU000'), 2) + 1, 3, '0')),
    'I105',
    '2024-11-21',
    '50',
    '2026-11-21'
FROM purchases;

-- Inserting into sales table
INSERT INTO sales (sale_id, customer_id, item_id, quantity, sale_date)
SELECT 
    CONCAT('SA', LPAD(SUBSTRING(IFNULL(MAX(sale_id), 'SA000'), 2) + 1, 3, '0')), 
    'C105', 
    'I105', 
    '10', 
    '2024-11-21'
FROM sales;

-- Inserting into payrolls table
INSERT INTO payrolls (payroll_id, staff_id, payment_id)
SELECT 
    CONCAT('PA', LPAD(SUBSTRING(IFNULL(MAX(payroll_id), 'PA000'), 2) + 1, 3, '0')), 
    'ST100', 
    'PM100'
FROM payrolls;

-- Inserting into returns table
INSERT INTO returns (return_id, pharmacist_id, sale_id, return_reason, return_date)
SELECT 
    CONCAT('R', LPAD(SUBSTRING(IFNULL(MAX(return_id), 'R000'), 2) + 1, 3, '0')), 
    'ST102', 
    'SA106', 
    'Damaged packaging',
    '2024-11-22'
FROM returns;
