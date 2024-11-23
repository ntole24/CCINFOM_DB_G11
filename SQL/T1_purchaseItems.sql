-- user input: supplier email, item, quantity, other info

-- if supplier email exixts:
-- 		get supplier id
select supplier_id
from suppliers 
where email = 'saleDept@LifeLineMD.com' -- supplier email user input
limit 1;

-- if item exists: get id
select item_id
from items 
where name = 'VitA-Pills'  -- item name user input
limit 1;


-- assuming supplier and item both exist
insert into supplier_item_cost (item_id, supplier_id, unit_cost)
values('I100', 'S101' , 3131.00); -- id taken from previous statements

-- update item quantity
UPDATE items
SET quantity = quantity + 50 -- the 50 is a user input
WHERE item_id = 'I100'; -- taken from previous statements

-- ------------------------------------------------------
-- if the item doesnt exixt, do this 
-- Generate the next item_id
SET @next_id = (
    SELECT CONCAT('I', LPAD(SUBSTRING(MAX(item_id), 2) + 1, 3, '0'))
    FROM items
);
-- Insert the new item
INSERT INTO items (item_id, name, description, quantity, selling_price)
VALUES (@next_id, 'Orange Juice', 'Fresh, 500 mL, Bottle', 60, 150.00); -- user inputs

-- if supplier doesnt exist 
-- generate id
SET @next_idS = (
    SELECT CONCAT('S', LPAD(SUBSTRING(MAX(supplier_id), 2) + 1, 3, '0'))
    FROM suppliers
);

-- insert
insert into suppliers (supplier_id, assigned_staff_id, name, contact_number, email, city)
values(@next_idS, 'ST102', 'nathaniel arnoldo', 30193091, 'fnoie@gmail.com', 'atlantis'); -- user inputs