SELECT
	i.name,
    si.unit_cost,
    s.assigned_staff_id
FROM 
	items i
JOIN
	supplier_item_cost si on i.item_id = si.item_id
JOIN
	suppliers s ON si.supplier_id = s.supplier_id
WHERE 
	i.quantity > 100
ORDER BY
	i.item_id;
    
SELECT
	i.name,
    si.unit_cost,
    c.name as company_name
FROM 
	items i
JOIN
	supplier_item_cost si on i.item_id = si.item_id
JOIN
	customers c ON i.item_id = c.item_id
ORDER BY
	i.item_id;

SELECT * FROM items;
SELECT * FROM suppliers;
SELECT * FROM supplier_item_cost;
SELECT * FROM customers;

