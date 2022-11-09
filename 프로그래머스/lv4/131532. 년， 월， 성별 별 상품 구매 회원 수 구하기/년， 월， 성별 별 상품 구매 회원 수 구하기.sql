-- 코드를 입력하세요
# SELECT year(s.sales_date) as 'YEAR', month(s.sales_date) as 'MONTH', u.gender as 'GENDER', count(u.user_id) as 'USERS'
# from user_info u join online_sale s
# where s.user_id = u.user_id && u.gender in (0, 1)
# group by year(s.sales_date), month(s.sales_date), u.gender
# order by year(s.sales_date), month(s.sales_date), u.gender
select year(sales_date), month(sales_date), gender, count(distinct u.user_id)
from online_sale s join user_info u
where s.user_id = u.user_id && gender is not null
group by year(sales_date), month(sales_date), gender