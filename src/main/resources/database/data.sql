INSERT INTO m_user ( user_id, password, user_name, birthday, age, gender, department_id, role )
VALUES ('aaa', '{bcrypt}$2a$10$2NWHjmuaKe3tz3UIXjIh.uxXof/S8Lu8grS9JVJMGYCgzt9ftuJl.', 'システム管理者', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN'),
('bbb', '{bcrypt}$2a$10$2NWHjmuaKe3tz3UIXjIh.uxXof/S8Lu8grS9JVJMGYCgzt9ftuJl.', 'ユーザー1', '2000-01-01', 21, 2, 2, 'ROLE_GENERAL');
