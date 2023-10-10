# Write your MySQL query statement below

# Solution 2
select max(salary) as SecondHighestSalary
from Employee 
where salary not in (select max(salary) from Employee)

/*
#Solution 1:

select max(salary) as SecondHighestSalary
from Employee 
where salary < (select max(salary) from Employee);
*/