SET @itemId = (SELECT item_id
               FROM items
               WHERE name = 'apple juice' LIMIT 1);

UPDATE items
SET quantity = quantity - 10
WHERE item_id = @itemId;
