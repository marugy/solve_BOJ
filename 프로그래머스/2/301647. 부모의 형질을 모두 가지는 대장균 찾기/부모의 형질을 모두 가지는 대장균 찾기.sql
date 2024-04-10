-- 코드를 작성해주세요
SELECT CHILD.ID AS ID, CHILD.GENOTYPE AS GENOTYPE, PARENT.GENOTYPE AS PARENT_GENOTYPE
FROM ECOLI_DATA AS CHILD, ECOLI_DATA AS PARENT
WHERE CHILD.PARENT_ID = PARENT.ID AND PARENT.GENOTYPE & CHILD.GENOTYPE = PARENT.GENOTYPE
ORDER BY 1