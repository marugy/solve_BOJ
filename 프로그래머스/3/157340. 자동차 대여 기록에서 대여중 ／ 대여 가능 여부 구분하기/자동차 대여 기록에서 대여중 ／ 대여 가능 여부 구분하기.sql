-- 코드를 입력하세요
SELECT CAR_ID, 
    MAX(IF(START_DATE <= "2022-10-16" && "2022-10-16" <= END_DATE, "대여중", "대여 가능")) AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC