# Write your MySQL query statement below

WITH cte AS(
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
)


SELECT 
(CASE 
    WHEN COUNT(num) > 0 THEN max(num)
    ELSE NULL 
END)
AS num
FROM cte

