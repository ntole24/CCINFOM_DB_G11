-- user input: customers email, return or sales
select c.name, i.name, s.quantity, (s.quantity * i.selling_price) as 'total spent on an item', sale_date -- return date if user asking for return
from customers c left join  sales s on s.customer_id = c.customer_id 
join items i on i.item_id = s.item_id
left join returns r on r.sale_id = s.sale_id
where c.email = 'samBautista088@gmail.com' and return_id is null -- null or not null depending on user, and email is also depending on user