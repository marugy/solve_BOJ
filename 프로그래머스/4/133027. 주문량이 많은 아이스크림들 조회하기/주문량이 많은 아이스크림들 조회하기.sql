# 7월 아이스크림 총 주문량, 상반기 아이스크림 총 주문량 더한 값이 큰 순서대로 상위 3개
SELECT HALF.FLAVOR
FROM FIRST_HALF AS HALF
    JOIN 
        (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
        FROM JULY
        GROUP BY FLAVOR) AS JULY
    ON HALF.FLAVOR = JULY.FLAVOR
ORDER BY HALF.TOTAL_ORDER+JULY.TOTAL_ORDER DESC
LIMIT 3

