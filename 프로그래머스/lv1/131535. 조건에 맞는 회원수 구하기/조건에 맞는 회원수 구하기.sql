-- 코드를 입력하세요
SELECT count(*)
from user_info
where year(joined) = year('2021-00-00') and age between 20 and 29