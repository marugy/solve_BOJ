# 물고기 종류별 이름과 잡은 수, 잡은 수 기준 내림차순
-- 코드를 작성해주세요

# SELECT FISH_COUNT, FISH_NAME
# FROM FISH_NAME_INFO AS INFO
#     LEFT JOIN (
#         SELECT COUNT(ID) AS FISH_COUNT, FISH_TYPE
#         FROM FISH_INFO
#         GROUP BY FISH_INFO.FISH_TYPE
#         ) AS CNT
#     ON INFO.FISH_TYPE = CNT.FISH_TYPE
# ORDER BY 1 DESC

SELECT COUNT(ID) AS FISH_COUNT, FISH_NAME
FROM FISH_NAME_INFO AS NAME, FISH_INFO AS INFO
WHERE NAME.FISH_TYPE = INFO.FISH_TYPE
GROUP BY FISH_NAME
ORDER BY 1 DESC