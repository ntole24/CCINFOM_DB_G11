-- quantity of items sold and returned per item 
-- user input: year and month

select s.item_id, sum(s.quantity) AS 'total quantity in sales', COUNT(r.return_id) AS 'number of times returns'
from sales s left join returns r on s.sale_id = r.sale_id
group by s.item_id
order by s.item_id;