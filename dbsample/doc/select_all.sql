-- 
-- 結合表
-- 

SELECT
  e.id AS eid,
  e.name AS ename,
  g.id AS gid,
  g.name AS gname,
  e.birthday AS birthday,
  d.id AS did,
  d.name AS dname
FROM employee e
INNER JOIN gender g
  ON e.gender_id = g.id
INNER JOIN dept d
  ON e.dept_id = d.id
ORDER BY e.id ASC
