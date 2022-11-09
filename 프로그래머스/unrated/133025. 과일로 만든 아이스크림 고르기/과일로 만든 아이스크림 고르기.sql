-- 코드를 입력하세요
SELECT f.flavor
from icecream_info i join first_half f
where i.flavor = f.flavor && i.ingredient_type = 'fruit_based' && f.total_order >= 3000
order by f.total_order desc