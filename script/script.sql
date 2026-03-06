drop database if exists peliculas_db;
create database peliculas_db;
use peliculas_db;

create TABLE Peliculas(
	id int auto_increment primary key,
	nombre varchar(100),
	genero varchar(50),
	anio int,
	director varchar(100)
);



INSERT INTO Peliculas (nombre, genero, anio, director) VALUES
('Inception', 'Ciencia Ficcion', 2010, 'Christopher Nolan'),
('The Dark Knight', 'Accion', 2008, 'Christopher Nolan'),
('Interstellar', 'Ciencia Ficcion', 2014, 'Christopher Nolan'),
('Titanic', 'Romance', 1997, 'James Cameron'),
('Avatar', 'Ciencia Ficcion', 2009, 'James Cameron'),
('The Matrix', 'Ciencia Ficcion', 1999, 'Lana Wachowski'),
('Gladiator', 'Accion', 2000, 'Ridley Scott'),
('Jurassic Park', 'Aventura', 1993, 'Steven Spielberg'),
('The Godfather', 'Drama', 1972, 'Francis Ford Coppola'),
('Pulp Fiction', 'Crimen', 1994, 'Quentin Tarantino'),
('Fight Club', 'Drama', 1999, 'David Fincher'),
('The Shawshank Redemption', 'Drama', 1994, 'Frank Darabont'),
('Forrest Gump', 'Drama', 1994, 'Robert Zemeckis'),
('The Lord of the Rings: The Fellowship of the Ring', 'Fantasia', 2001, 'Peter Jackson'),
('The Lord of the Rings: The Two Towers', 'Fantasia', 2002, 'Peter Jackson'),
('The Lord of the Rings: The Return of the King', 'Fantasia', 2003, 'Peter Jackson'),
('Avengers: Endgame', 'Accion', 2019, 'Anthony Russo'),
('Spider-Man: No Way Home', 'Accion', 2021, 'Jon Watts'),
('The Batman', 'Accion', 2022, 'Matt Reeves'),
('Dune', 'Ciencia Ficcion', 2021, 'Denis Villeneuve');

-- select * from Peliculas limit 5 offset 10;

 -- select * from Peliculas;
 
-- select * from Peliculas where nombre like "Inception";

-- insert into Peliculas(nombre, genero, anio, director) values ('Star Wars', 'Aventura', 1970, 'George Lucas');

-- select count(*) as conteo from Peliculas;