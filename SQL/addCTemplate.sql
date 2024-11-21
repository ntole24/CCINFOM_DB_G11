INSERT INTO customers (customer_id, name, contact_number, email, city)
SELECT 
    CONCAT('C', LPAD(SUBSTRING(IFNULL(MAX(customer_id), 'C000'), 2) + 1, 3, '0')),
    'John Doe',
    '1234567890',
    'john.doe@example.com',
    'New York'
FROM customers;