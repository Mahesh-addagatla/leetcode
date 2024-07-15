DELETE p1
FROM Person p1
JOIN (
    SELECT MIN(id) as id, email
    FROM Person
    GROUP BY email
    HAVING COUNT(email) > 1
) p2 ON p1.email = p2.email AND p1.id <> p2.id;
