-- 코드를 입력하세요
SELECT USER.USER_ID, USER.NICKNAME, SUM(BOARD.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD AS BOARD, USED_GOODS_USER AS USER
WHERE BOARD.WRITER_ID = USER.USER_ID AND BOARD.STATUS = "DONE"
GROUP BY BOARD.WRITER_ID
HAVING SUM(BOARD.PRICE) >= 700000
ORDER BY SUM(BOARD.PRICE) ASC