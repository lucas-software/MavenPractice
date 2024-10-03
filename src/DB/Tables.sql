CREATE DATABASE sportDB;
DROP DATABASE sportDB;

CREATE TABLE Coach(
    id int(3),
    age int(3),
    name varchar(40)
);

CREATE TABLE Coordinator(
    id int(3),
    age int(3),
    name varchar(40),
    role varchar(15)
);

CREATE TABLE Intern(
    id int(3),
    internshipDuration int(2)
);

CREATE TABLE Worker(
    id int(2),
    role varchar(15)
);

CREATE TABLE NbaTeam(
    name varchar(25),
    conference varchar(3),
    id int(2)
);

CREATE TABLE NflTeam(
    name varchar(25),
    conference varchar(3),
    id int(2)
);

CREATE TABLE Player(
    number int(2),
    nationality varchar(15),
    position varchar(10)
);

CREATE TABLE Nba(
    id int(2),
    sport varchar(15),
    numberOfTeams int(2)
);

CREATE TABLE Nba(
    id int(2),
    sport varchar(15),
    numberOfTeams int(2)
);