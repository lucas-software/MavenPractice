CREATE DATABASE sportDB;
USE sportDB;

CREATE TABLE League
(
    league_id int AUTO_INCREMENT PRIMARY KEY NOT NULL
);

CREATE TABLE Staff
(
    staff_id int AUTO_INCREMENT PRIMARY KEY NOT NULL
);

CREATE TABLE Team
(
    team_id    int AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name       varchar(25)                    NOT NULL,
    conference varchar(3)                     NOT NULL
);

CREATE TABLE Coach
(
    coach_id int(3) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    age      int(3)                            NOT NULL,
    name     varchar(40)                       NOT NULL,
    staff_id int UNIQUE,
    FOREIGN KEY (staff_id) REFERENCES Staff (staff_id)
);

CREATE TABLE Coordinator
(
    coord_id int(3) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    age      int(3)                            NOT NULL,
    name     varchar(40)                       NOT NULL,
    role     varchar(15),
    staff_id int UNIQUE,
    FOREIGN KEY (staff_id) REFERENCES Staff (staff_id)
);

CREATE TABLE Intern
(
    intern_id          int(3) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    internshipDuration int(2)                            NOT NULL,
    staff_id           int UNIQUE,
    FOREIGN KEY (staff_id) REFERENCES Staff (staff_id)
);

CREATE TABLE Worker
(
    worker_id int(2) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    role      varchar(15),
    staff_id  int UNIQUE,
    FOREIGN KEY (staff_id) REFERENCES Staff (staff_id)
);

CREATE TABLE NbaTeam
(
    nbaTeam_id int(2) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name       varchar(25)                       NOT NULL,
    conference varchar(3)                        NOT NULL,
    team_id    int UNIQUE,
    FOREIGN KEY (team_id) REFERENCES Team (team_id)
);

CREATE TABLE NflTeam
(
    nflTeam_id int(2) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name       varchar(25)                       NOT NULL,
    conference varchar(3)                        NOT NULL,
    team_id    int UNIQUE,
    FOREIGN KEY (team_id) REFERENCES Team (team_id)
);

CREATE TABLE Player
(
    number      int(2) PRIMARY KEY NOT NULL,
    nationality varchar(15)        NOT NULL,
    position    varchar(10)
);

CREATE TABLE Nba
(
    nba_id        int(2) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sport         varchar(15)                       NOT NULL,
    numberOfTeams int(2)                            NOT NULL,
    league_id    int UNIQUE,
    FOREIGN KEY (league_id) REFERENCES League (league_id)
);

CREATE TABLE Nfl
(
    nfl_id        int(2) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    sport         varchar(15)                       NOT NULL,
    numberOfTeams int(2)                            NOT NULL,
    league_id    int UNIQUE,
    FOREIGN KEY (league_id) REFERENCES League (league_id)
);

-- Inserts
INSERT INTO League (league_id) VALUES (1);
INSERT INTO League (league_id) VALUES (2);
INSERT INTO Team (name, conference) VALUES ('Lakers', 'NBA');
INSERT INTO Team (name, conference) VALUES ('Patriots', 'NFL');
INSERT INTO Staff (staff_id) VALUES (1);
INSERT INTO Staff (staff_id) VALUES (2);
INSERT INTO Staff (staff_id) VALUES (3);
INSERT INTO Staff (staff_id) VALUES (4);
INSERT INTO Staff (staff_id) VALUES (5);

INSERT INTO Coach (age, name, staff_id) VALUES (55, 'Gregg Popovich', 1);
INSERT INTO Coordinator (age, name, role, staff_id) VALUES (45, 'Josh McDaniels', 'Offensive', 2);
INSERT INTO Intern (internshipDuration, staff_id) VALUES (12, 3);
INSERT INTO Worker (role, staff_id) VALUES ('Trainer', 4);
INSERT INTO NbaTeam (name, conference, team_id) VALUES ('Golden State Warriors', 'NBA', 1);
INSERT INTO NflTeam (name, conference, team_id) VALUES ('New England Patriots', 'NFL', 2);
INSERT INTO Player (number, nationality, position) VALUES (23, 'American', 'Forward');
INSERT INTO Nba (sport, numberOfTeams, league_id) VALUES ('Basketball', 30, 1);
INSERT INTO Nfl (sport, numberOfTeams, league_id) VALUES ('Football', 32, 2);

-- Deletes
DELETE FROM League WHERE league_id = 2;
DELETE FROM Team WHERE name = 'Patriots';
DELETE FROM Staff WHERE staff_id = 3;
DELETE FROM Coach WHERE staff_id = 1;
DELETE FROM Coordinator WHERE staff_id = 2;
DELETE FROM Intern WHERE staff_id = 3;
DELETE FROM Worker WHERE staff_id = 4;
DELETE FROM NbaTeam WHERE team_id = 1;
DELETE FROM NflTeam WHERE team_id = 2;
DELETE FROM Player WHERE number = 23;

-- Alter Table
ALTER TABLE Team ADD COLUMN founded_year INT(4);
ALTER TABLE Worker MODIFY role VARCHAR(20);
ALTER TABLE Coach ADD COLUMN salary DECIMAL(10, 2);
ALTER TABLE Player DROP COLUMN position;
ALTER TABLE Intern CHANGE internshipDuration duration_in_months INT(2);

-- Big Join in all tables
SELECT
    L.league_id,
    N.nba_id,
    Nl.nfl_id,
    T.team_id,
    T.name AS team_name,
    T.conference AS team_conference,
    NT.name AS nba_team_name,
    NF.name AS nfl_team_name,
    S.staff_id,
    C.coach_id,
    C.name AS coach_name,
    C.age AS coach_age,
    C.salary AS coach_salary,
    CO.coord_id,
    CO.name AS coordinator_name,
    CO.age AS coordinator_age,
    CO.role AS coordinator_role,
    I.intern_id,
    I.duration_in_months AS internship_duration,
    W.worker_id,
    W.role AS worker_role,
    P.number AS player_number,
    P.nationality AS player_nationality
FROM
    League L
        LEFT JOIN Nba N ON L.league_id = N.league_id
        LEFT JOIN Nfl Nl ON L.league_id = Nl.league_id
        LEFT JOIN Team T ON (N.nba_id IS NOT NULL AND T.team_id = N.nba_id) OR (Nl.nfl_id IS NOT NULL AND T.team_id = Nl.nfl_id)
        LEFT JOIN NbaTeam NT ON NT.team_id = T.team_id
        LEFT JOIN NflTeam NF ON NF.team_id = T.team_id
        LEFT JOIN Staff S ON S.staff_id = C.staff_id OR S.staff_id = CO.staff_id OR S.staff_id = I.staff_id OR S.staff_id = W.staff_id
        LEFT JOIN Coach C ON S.staff_id = C.staff_id
        LEFT JOIN Coordinator CO ON S.staff_id = CO.staff_id
        LEFT JOIN Intern I ON S.staff_id = I.staff_id
        LEFT JOIN Worker W ON S.staff_id = W.staff_id
        LEFT JOIN Player P ON P.number = C.coach_id;

-- Selects
SELECT
    T.team_id,
    T.name AS team_name,
    C.name AS coach_name
FROM
    Team T
        LEFT JOIN Coach C ON T.team_id = C.coach_id;


SELECT
    C.coach_id,
    C.name AS coach_name,
    T.name AS team_name
FROM
    Coach C
        RIGHT JOIN Team T ON C.coach_id = T.team_id;


SELECT
    P.number,
    P.nationality,
    T.name AS team_name
FROM
    Player P
        INNER JOIN Team T ON P.number = T.team_id;


SELECT
    NT.name AS nba_team_name,
    NF.name AS nfl_team_name
FROM
    NbaTeam NT
        LEFT JOIN NflTeam NF ON NT.team_id = NF.team_id
UNION
SELECT
    NT.name AS nba_team_name,
    NF.name AS nfl_team_name
FROM
    NbaTeam NT
        RIGHT JOIN NflTeam NF ON NT.team_id = NF.team_id;


-- Aggregate functions without having
-- 1
SELECT
    conference,
    COUNT(team_id) AS total_teams
FROM
    Team
GROUP BY
    conference;

-- 2
SELECT
    T.conference,
    AVG(C.age) AS avg_coach_age
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference;

-- 3
SELECT
    T.conference,
    SUM(C.salary) AS total_salary
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference;

-- 4
SELECT
    P.nationality,
    COUNT(P.number) AS total_players
FROM
    Player P
GROUP BY
    P.nationality;

-- 5
SELECT
    CO.role,
    AVG(I.duration_in_months) AS avg_internship_duration
FROM
    Coordinator CO
        LEFT JOIN
    Intern I ON CO.staff_id = I.staff_id
GROUP BY
    CO.role;

-- 6
SELECT
    CASE
        WHEN N.nba_id IS NOT NULL THEN 'NBA'
        WHEN Nl.nfl_id IS NOT NULL THEN 'NFL'
        END AS league_name,
    COUNT(T.team_id) AS total_teams
FROM
    Team T
        LEFT JOIN
    Nba N ON T.team_id = N.nba_id
        LEFT JOIN
    Nfl Nl ON T.team_id = Nl.nfl_id
GROUP BY
    league_name;

-- 7
SELECT
    T.conference,
    MAX(C.salary) AS max_salary,
    MIN(C.salary) AS min_salary
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference;


-- Aggregate functions with having
-- 1
SELECT
    conference,
    COUNT(team_id) AS total_teams
FROM
    Team
GROUP BY
    conference
HAVING
    COUNT(team_id) > 2;


-- 2
SELECT
    T.conference,
    AVG(C.age) AS avg_coach_age
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference
HAVING
    AVG(C.age) > 45;


-- 3
SELECT
    T.conference,
    SUM(C.salary) AS total_salary
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference
HAVING
    SUM(C.salary) > 500000;


-- 4
SELECT
    P.nationality,
    COUNT(P.number) AS total_players
FROM
    Player P
GROUP BY
    P.nationality
HAVING
    COUNT(P.number) > 5;


-- 5
SELECT
    CO.role,
    AVG(I.duration_in_months) AS avg_internship_duration
FROM
    Coordinator CO
        LEFT JOIN
    Intern I ON CO.staff_id = I.staff_id
GROUP BY
    CO.role
HAVING
    AVG(I.duration_in_months) > 6;


-- 6
SELECT
    CASE
        WHEN N.nba_id IS NOT NULL THEN 'NBA'
        WHEN Nl.nfl_id IS NOT NULL THEN 'NFL'
        END AS league_name,
    COUNT(T.team_id) AS total_teams
FROM
    Team T
        LEFT JOIN
    Nba N ON T.team_id = N.nba_id
        LEFT JOIN
    Nfl Nl ON T.team_id = Nl.nfl_id
GROUP BY
    league_name
HAVING
    COUNT(T.team_id) > 2;


-- 7
SELECT
    T.conference,
    MAX(C.salary) AS max_salary
FROM
    Team T
        LEFT JOIN
    Coach C ON T.team_id = C.coach_id
GROUP BY
    T.conference
HAVING
    MAX(C.salary) > 300000;
