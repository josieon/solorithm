-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, OUT_DATE, IF(OUT_DATE <= '2022-05-01', "출고완료", IF(OUT_DATE IS NULL, '출고미정', '출고대기')) AS 출고여부
    # CASE 
    #     WHEN OUT_DATE IS NULL THEN "출고미정"
    #     ELSE IF(DATE_FORMAT(OUT_DATE,"%m-%d") <= "05-01", "출고완료", "출고대기")
    # END AS "출고여부"
FROM FOOD_ORDER
ORDER BY ORDER_ID

# SELECT 
#     order_id, 
#     product_id, 
#     out_date, 
#     if(out_date <= '2022-05-01', '출고완료',if(out_date is null, '출고미정','출고대기')) as 출고여부
# from food_order
# order by order_id