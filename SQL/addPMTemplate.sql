INSERT INTO payment_details (payment_id, payment_date, bonus_penalty, percentage)
SELECT 
    CONCAT('PM', LPAD(SUBSTRING(IFNULL(MAX(payment_id), 'PM000'), 3) + 1, 3, '0')),
    '2024-11-21',
    'Penalty',
    '0.05'
FROM payment_details;