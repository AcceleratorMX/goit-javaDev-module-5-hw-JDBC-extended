
INSERT INTO worker (name, birthday, level, salary)
VALUES ('John Doe', '1995-02-10', 'Trainee', 800),
       ('Jane Doe', '1990-08-20', 'Junior', 1200),
       ('Bob Johnson', '1985-05-15', 'Middle', 3000),
       ('Alice Lee', '1980-03-25', 'Senior', 5000),
       ('John Karmak', '1992-12-01', 'Middle', 3000),
       ('Emily Brown', '1988-07-12', 'Junior', 1500),
       ('Gabe Newell', '1983-01-05', 'Senior', 6000),
       ('Linda Chen', '1998-06-30', 'Trainee', 900),
       ('David Kim', '1991-09-03', 'Middle', 2800),
       ('Lisa Su', '1986-11-22', 'Senior', 6000);

INSERT INTO client (name)
VALUES ('Arasaka Corporation'),
       ('Militech International Armaments'),
       ('Night Corp'),
       ('Biotechnica'),
       ('Trauma Team'); 

INSERT INTO project (client_id, start_date, finish_date)
VALUES (1, '2022-01-01', '2022-05-01'),
       (2, '2022-02-01', '2024-06-01'),
       (3, '2022-03-01', '2022-05-01'),
       (4, '2022-04-01', '2023-07-01'),
       (5, '2022-05-01', '2022-09-01'),
       (1, '2022-06-01', '2022-10-01'),
       (2, '2022-07-01', '2025-12-01'),
       (3, '2022-08-01', '2023-01-01'),
       (4, '2022-09-01', '2023-03-01'),
       (5, '2022-10-01', '2024-04-01'),
       (3, '2022-07-01', '2025-12-01');  

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (4, 9),
       (5, 10),
       (5, 1),
       (5, 2),
       (6, 3),
       (6, 4),
       (7, 5),
       (7, 6),
       (7, 7),
       (7, 8),
       (8, 9),
       (8, 10),
       (9, 1),
       (9, 2),
       (9, 3),
       (10, 4),
       (10, 5),
       (10, 6);