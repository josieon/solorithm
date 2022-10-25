-- 코드를 입력하세요
select p.product_code, amount * price as total
from product p join (
    SELECT product_id, sum(sales_amount) as amount
    from offline_sale
    group by product_id) a
where p.product_id = a.product_id
order by total desc, p.product_code