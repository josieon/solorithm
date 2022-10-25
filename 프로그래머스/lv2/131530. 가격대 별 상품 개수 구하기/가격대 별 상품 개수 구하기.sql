-- 코드를 입력하세요
# SELECT 10000*cast(price/10000 as unsigned) as PRICE_GROUP, count(product_code) as PRODUCTS
# from product//
# group by cast(price/10000 as unsigned)
# order by cast(price/10000 as unsigned)
select 10000*floor(price/10000) as PRICE_GROUP, count(product_code) as PRODUCTS
from product
group by floor(price/10000)
order by floor(price/10000)