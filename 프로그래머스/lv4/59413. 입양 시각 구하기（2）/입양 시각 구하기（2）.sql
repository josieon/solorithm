-- 코드를 입력하세요
set @HOUR = -1;
SELECT (@HOUR := @HOUR + 1) as hour, 
    (SELECT count(HOUR(DATETIME))
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME)=@HOUR) as count
FROM ANIMAL_OUTS
WHERE @HOUR < 23;