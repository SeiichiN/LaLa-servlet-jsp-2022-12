--
-- user_table.sql
--

DROP TABLE IF EXISTS dbuser;

CREATE TABLE dbuser (
  id CHAR(6) PRIMARY KEY,
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

