SELECT client.name, COUNT(project.id) AS project_count
FROM project
INNER JOIN client ON project.client_id = client.id
GROUP BY project.client_id
HAVING COUNT(project.id) = (
  SELECT MAX(project_count)
  FROM (
    SELECT COUNT(*) AS project_count
    FROM project
    GROUP BY client_id
  ) AS project_counts
);