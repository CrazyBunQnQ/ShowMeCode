CREATE TABLE LeetCode.Address
(
    AddressId int(11),
    PersonId int(11),
    City varchar(255),
    State varchar(255)
);
INSERT INTO LeetCode.Address (AddressId, PersonId, City, State) VALUES (1, 2, 'New York City', 'New York');
CREATE TABLE LeetCode.Employee
(
    Id int(11),
    Name varchar(255),
    Salary int(11),
    ManagerId int(11)
);
INSERT INTO LeetCode.Employee (Id, Name, Salary, ManagerId) VALUES (1, 'Joe', 70000, 3);
INSERT INTO LeetCode.Employee (Id, Name, Salary, ManagerId) VALUES (2, 'Henry', 80000, 4);
INSERT INTO LeetCode.Employee (Id, Name, Salary, ManagerId) VALUES (3, 'Sam', 60000, 0);
INSERT INTO LeetCode.Employee (Id, Name, Salary, ManagerId) VALUES (4, 'Max', 90000, 0);
CREATE TABLE LeetCode.Person
(
    PersonId int(11),
    FirstName varchar(255),
    LastName varchar(255)
);
INSERT INTO LeetCode.Person (PersonId, FirstName, LastName) VALUES (1, 'Allen', 'Wang');
CREATE TABLE LeetCode.salary
(
    id int(11),
    name varchar(100),
    sex char(1),
    salary int(11)
);
INSERT INTO LeetCode.salary (id, name, sex, salary) VALUES (1, 'A', 'f', 2500);
INSERT INTO LeetCode.salary (id, name, sex, salary) VALUES (2, 'B', 'm', 1500);
INSERT INTO LeetCode.salary (id, name, sex, salary) VALUES (3, 'C', 'f', 5500);
INSERT INTO LeetCode.salary (id, name, sex, salary) VALUES (4, 'D', 'm', 500);