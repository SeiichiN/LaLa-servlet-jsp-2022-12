-- 初期データ

DROP TABLE IF EXISTS mutter;

CREATE TABLE mutter (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  text VARCHAR(255) NOT NULL
);

INSERT INTO mutter (name, text) VALUES
('湊', '今日は休みだ'),
('綾部', 'いいな～');
