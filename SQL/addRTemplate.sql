INSERT INTO returns (return_id, pharmacist_id, sale_id, return_reason, return_date)
SELECT 
    CONCAT('R', LPAD(SUBSTRING(IFNULL(MAX(return_id), 'R000'), 2) + 1, 3, '0')),
    'ST100',
    'SA100',
    'Wrong purchase',
    '2024-03-14'
FROM returns;

SELECT * FROM returns;