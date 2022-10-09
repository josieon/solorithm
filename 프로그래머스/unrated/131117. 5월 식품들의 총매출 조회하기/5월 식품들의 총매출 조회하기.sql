-- 코드를 입력하세요
SELECT p.product_id, p.product_name, sum(amount)*price as total
from food_product as p join food_order as o on p.product_id = o.product_id
where date_format(o.produce_date, "%Y-%m") = "2022-05"
group by p.product_id
order by total desc