-- 코드를 입력하세요
select user_id, product_id
from (SELECT *, sum(sales_amount) as sum
    from online_sale
    group by user_id, product_id) as p
where p.sales_amount != p.sum
order by user_id, product_id desc