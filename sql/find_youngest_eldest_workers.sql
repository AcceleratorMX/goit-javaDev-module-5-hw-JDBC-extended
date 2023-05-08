SELECT 'YOUNGEST' AS TYPE, name, birthday FROM worker 
WHERE birthday = (SELECT MAX(birthday) FROM worker)
UNION ALL
SELECT 'ELDEST' AS TYPE, name, birthday FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker);