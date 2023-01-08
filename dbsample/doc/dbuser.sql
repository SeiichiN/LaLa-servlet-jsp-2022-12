--
-- user_table.sql
--

DROP TABLE IF EXISTS dbuser;

CREATE TABLE dbuser (
  id CHAR(6) PRIMARY KEY,
  name VARCHAR(100),
  pass VARCHAR(100)
);

INSERT INTO dbuser
  (id, pass)
VALUES
  ('EMP001', '1111'),
  ('EMP002', '2222'),
  ('EMP003', '3333'),
  ('EMP004', '4444'),
  ('EMP005', '5555');


UPDATE dbuser SET name = (select name from employee where id = 'EMP001')
where id = 'EMP001';

UPDATE dbuser SET name = (select name from employee where id = 'EMP002')
where id = 'EMP002';

UPDATE dbuser SET name = (select name from employee where id = 'EMP003')
where id = 'EMP003';

UPDATE dbuser SET name = (select name from employee where id = 'EMP004')
where id = 'EMP004';

UPDATE dbuser SET name = (select name from employee where id = 'EMP005')
where id = 'EMP005';
