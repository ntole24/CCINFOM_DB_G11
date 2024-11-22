-- transaction 3
-- user input is staff id, payment type (bonus or no bonus)
-- increment id
SET @next_idPA = (
    SELECT CONCAT('PA', LPAD(SUBSTRING(MAX(payroll_id), 3) + 1, 3, '0'))
    FROM payrolls
);

-- add into payrolls
insert into payrolls (payroll_id, staff_id, payment_id)
values (@next_idPA, 'ST103', 'PM100'); -- staff id from input, PM100 or PM101 depending on user payment type