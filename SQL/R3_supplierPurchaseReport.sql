-- user input: email of supplier
Select count(p.quantity) AS num_of_purchases, sum(unit_cost * p.quantity) AS total_cost  
from suppliers s join supplier_item_cost si on s.supplier_id = si.supplier_id
join items i on i.item_id = si.item_id
join purchases p on p.item_id = i.item_id
where s.email = 'orders@healthstore.com' -- the email is user input