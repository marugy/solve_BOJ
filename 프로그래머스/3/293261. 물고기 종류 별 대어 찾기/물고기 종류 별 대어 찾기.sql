-- 코드를 작성해주세요

# SELECT MAX(LENGTH) AS LENGTH, FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE

# SELECT ID, LENGTH, FISH_TYPE
# FROM FISH_INFO
# WHERE LENGTH IN(
#     SELECT MAX(LENGTH) AS LENGTH
#     FROM FISH_INFO
#     GROUP BY FISH_TYPE)

SELECT ID, FISH_NAME, LENGTH
FROM FISH_NAME_INFO
    JOIN (SELECT ID, LENGTH, FISH_TYPE
        FROM FISH_INFO
        WHERE (FISH_TYPE, LENGTH) IN(
            SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
            FROM FISH_INFO
            GROUP BY FISH_TYPE)) AS B
    ON FISH_NAME_INFO.FISH_TYPE = B.FISH_TYPE
ORDER BY ID