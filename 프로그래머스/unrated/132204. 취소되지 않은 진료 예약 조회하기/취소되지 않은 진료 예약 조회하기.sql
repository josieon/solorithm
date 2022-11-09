-- 코드를 입력하세요
select apnt_no, pt_name, p.pt_no, d.mcdp_cd, dr_name, apnt_ymd
from patient p join appointment a on p.pt_no = a.pt_no join doctor d on a.mddr_id = d.dr_id
where apnt_cncl_yn not in ('Y') && a.mcdp_cd = 'CS' && date_format(apnt_ymd,'%y-%m-%d') = date_format('2022-04-13', '%y-%m-%d')
order by apnt_ymd
# SELECT apnt_no, pt_no, mcdp_cd, mddr_id, apnt_ymd
# from appointment
# where apnt_cncl_yn not in ('Y') && date_format(apnt_ymd,'%y-%m-%d') = date_format('2022-04-13', '%y-%m-%d') && MCDP_CD = 'CS'