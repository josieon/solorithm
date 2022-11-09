-- 코드를 입력하세요
select *
from places
where host_id in (
    SELECT host_id as 'heavy'
    from places
    group by host_id
    having count(host_id) > 1)
order by id