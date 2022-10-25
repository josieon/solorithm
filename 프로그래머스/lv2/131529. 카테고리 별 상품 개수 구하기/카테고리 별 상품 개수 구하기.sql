-- 코드를 입력하세요
SELECT SUBSTR(product_code, 1, 2), count(product_id)
from product
group by SUBSTR(product_code, 1, 2)
order by product_code