# Write a SQL query to find all duplicate emails in a table named Person.
#
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
#
# For example, your query should return the following for the above table:
#
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+
#
# Note: All emails are in lowercase.

# 标准查询 1246 ms
SELECT Email
FROM Person
GROUP BY Email
HAVING count(Id) > 1;

# 使用自连接 1240 ms
SELECT DISTINCT a.Email
FROM Person a
  JOIN Person b
    ON (a.Email = b.Email)
WHERE a.Id <> b.Id;

# 使用 EXISTS 子查询 1243 ms
SELECT DISTINCT a.Email
FROM Person a
WHERE EXISTS(
    SELECT 1
    FROM Person b
    WHERE a.Email = b.Email
    LIMIT 1, 1
);

# 使用左外连接 1220 ms
# SELECT DISTINCT Email FROM Person
#  MINUS
#  (SELECT Id, Email FROM Person GROUP BY Email)
SELECT DISTINCT a.Email
FROM Person a
  LEFT JOIN (SELECT
               Id,
               Email
             FROM Person
             GROUP BY Email) b
    ON (a.email = b.email) AND (a.Id = b.Id)
WHERE b.Email IS NULL;
