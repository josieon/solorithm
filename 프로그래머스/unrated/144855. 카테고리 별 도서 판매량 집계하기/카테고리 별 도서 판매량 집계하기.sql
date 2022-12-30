-- 코드를 입력하세요
select b.category, sum(bs.sales) total_sales
from book b join book_sales bs on b.book_id = bs.book_id
where date_format(bs.sales_date, '%Y%m') = '202201'
group by b.category
order by b.category
# select *, date_format(sales_date, '%Y')
# from book_sales