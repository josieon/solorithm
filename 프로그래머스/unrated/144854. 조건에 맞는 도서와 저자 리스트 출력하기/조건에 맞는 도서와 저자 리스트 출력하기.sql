-- 코드를 입력하세요
select b.book_id, a.author_name, DATE_FORMAT(b.published_date,'%Y-%m-%d')
from author a join (SELECT *
    from book
    where category = '경제') b
where a.author_id = b.author_id
order by b.published_date