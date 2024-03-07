-- 코드를 입력하세요
-- 차종 세단 OR SUV,
-- 2022-11-01~2022-11-30까지 대여 가능
-- 30일간 대여 금액 50만~200만 미만
-- 대여금액 기준 내림, 자종 기준 오름, 아이디 내림

SELECT CAR.CAR_ID, CAR.CAR_TYPE, FLOOR(CAR.DAILY_FEE * (100-PLAN.DISCOUNT_RATE) / 100 * 30) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS CAR, CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS PLAN
WHERE CAR.CAR_TYPE IN ("세단", "SUV") AND CAR.CAR_TYPE = PLAN.CAR_TYPE AND PLAN.DURATION_TYPE = "30일 이상" AND
    CAR.CAR_ID NOT IN
        (SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY  AS HISTORY
        WHERE "2022-11-01" BETWEEN START_DATE AND END_DATE OR "2022-11-30" BETWEEN START_DATE AND END_DATE
        )
    AND ROUND(CAR.DAILY_FEE * (100-PLAN.DISCOUNT_RATE) / 100 * 30, 0) BETWEEN 500000 AND 2000000
ORDER BY 3 DESC, 2 ASC, 1 DESC

# SELECT *
# FROM CAR_RENTAL_COMPANY_CAR
# WHERE CAR_ID NOT IN
#     (SELECT CAR_ID
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY  AS HISTORY
#     WHERE START_DATE BETWEEN "2022-11-01" AND "2022-11-30" OR END_DATE BETWEEN "2022-11-01" AND "2022-11-30") AND CAR_TYPE IN ("세단", "SUV")