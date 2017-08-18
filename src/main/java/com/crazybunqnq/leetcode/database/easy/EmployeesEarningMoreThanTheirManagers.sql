# The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.
#
# +----+-------+--------+-----------+
# | Id | Name  | Salary | ManagerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | NULL      |
# | 4  | Max   | 90000  | NULL      |
# +----+-------+--------+-----------+
# Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.
#
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
#
# SQL Schema
DROP TABLE IF EXISTS Employee;
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int);
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', 'None');
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', 'None');

# My SQL Statement 2274ms
SELECT e.Name Employee FROM Employee e WHERE e.Salary > (SELECT salary FROM Employee c WHERE c.Id = e.ManagerId);

# 1952ms
select E1.Name Employee
from Employee as E1, Employee as E2
where E1.ManagerId = E2.Id and E1.Salary > E2.Salary

# 1746ms
select a.Name Employee
from Employee a inner join Employee b on a.ManagerId=b.Id
where a.Salary>b.Salary