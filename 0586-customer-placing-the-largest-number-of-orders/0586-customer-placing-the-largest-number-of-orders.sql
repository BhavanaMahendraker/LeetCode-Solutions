# Write your MySQL query statement below

WITH cte AS
(SELECT customer_number, COUNT(order_number) AS num_of_orders
FROM Orders
GROUP BY customer_number)

SELECT customer_number
FROM cte
WHERE num_of_orders = (SELECT MAX(num_of_orders) FROM CTE)