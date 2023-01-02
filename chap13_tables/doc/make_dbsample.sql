--
-- make_employee.sql
--

CREATE USER IF NOT EXISTS "SA" SALT '5d54047a594b0370' HASH '35d640dce4afc2fb62a6f1b96ca95083f3eb5784d7f0719c93b077180ece7386' ADMIN;

--
-- genderテーブル
--
DROP TABLE IF EXISTS gender;

CREATE TABLE gender (
  id CHAR(1) PRIMARY KEY,
  name VARCHAR(10)
);

INSERT INTO gender
  (id, name)
VALUES
  ('0', '不明'),
  ('1', '男性'),
  ('2', '女性'),
  ('3', 'その他');

--
-- departmentテーブル
--
DROP TABLE IF EXISTS department;

CREATE TABLE department (
  id CHAR(3) PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO department
  (id, name)
VALUES
  ('d01', '総務部'),
  ('d02', '経理部'),
  ('d03', '第一営業部'),
  ('d04', '開発部'),
  ('d05', '第二営業部');


--
-- employeeテーブル
--
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  gender CHAR(1),
  birthday DATE,
  dept_id CHAR(3)
);

-- genderカラムとdept_idカラムには
-- 外部キー制約をつけるべきだけど、
-- 平易化のため今回はパス。

INSERT INTO employee
  (name, gender, birthday, dept_id)
VALUES
  ('二階堂 ふみ', '2', '1994-09-21', 'd05'),
  ('染谷 翔太', '1', '1992-09-03', 'd04'),
  ('吉高 由里子', '2', '1988-07-22', 'd02'),
  ('窪塚 洋介', '1', '1979-05-07', 'd04');

  

-- 修正時刻: Mon 2023/01/02 07:29:26
