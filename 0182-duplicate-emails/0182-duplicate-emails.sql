# Write your MySQL query statement bel
SELECT p.email
FROM Person p
GROUP BY p.email
HAVING COUNT(p.email) > 1