SELECT 
	i.item_id,
    i.name,
	SUM(i.selling_price * s.quantity), 
    AVG(i.selling_price * s.quantity)
FROM 
	sales s 
JOIN 
	items i on s.item_id = i.item_id
WHERE 
	YEAR(s.sale_date) = 2024 AND MONTH(s.sale_date) = 3
GROUP BY
	i.item_id;
    
SELECT * FROM items;
SELECT * FROM sales;