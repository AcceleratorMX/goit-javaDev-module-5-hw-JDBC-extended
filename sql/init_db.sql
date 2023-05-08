CREATE TABLE worker (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2),
    birthday DATE NOT NULL CHECK (birthday > '1900-01-01'),
    level ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT NOT NULL CHECK (salary >= 100 AND salary <= 100000)
);


CREATE TABLE client (
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2)
);


CREATE TABLE project (
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    client_id INTEGER,
    start_date DATE,
    finish_date DATE,
    FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT duration CHECK (DATEDIFF(MONTH, start_date, finish_date) BETWEEN 1 AND 100)
);

CREATE TABLE project_worker (
    project_id INTEGER,
    worker_id INTEGER,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(ID),
    FOREIGN KEY (worker_id) REFERENCES worker(ID)
);