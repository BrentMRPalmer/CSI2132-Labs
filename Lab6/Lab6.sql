CREATE TABLE Sailors (
	sid INT PRIMARY KEY,
    sname VARCHAR(50),
    rating INT,
    age INT );
    
CREATE TABLE Boats (
	bid INT PRIMARY KEY,
    bname VARCHAR(50),
    color VARCHAR(20) );
    
CREATE TABLE Reserves ( 
	sid INT,
    bid INT,
    day DATE,
    FOREIGN KEY (sid) REFERENCES Sailors(sid),
    FOREIGN KEY (bid) REFERENCES Boats(bid) );
    
INSERT INTO Sailors (sid, sname, rating, age) VALUES
	(1, 'John', 8, 25),
	(2, 'Mike', 7, 26),
	(3, 'Kate', 6, 22),
	(4, 'Sarah', 9, 30);
    
INSERT INTO Boats (bid, bname, color) VALUES
	(101, 'Sailboat', 'Red'),
	(102, 'Yacht', 'Blue'),
	(103, 'Canoe', 'Green'),
	(104, 'Kayak', 'Yellow');
    
INSERT INTO Reserves (sid, bid, day) VALUES
	(1, 101, '2022-10-01'),
	(2, 103, '2022-10-03'),
	(1, 102, '2022-10-05'),
	(4, 101, '2022-10-06');
    
INSERT INTO Sailors (sid, sname, rating, age) VALUES
	(5, 'Alex', 10, 17),
	(6, 'George', 5, 76);
    
INSERT INTO Boats (bid, bname, color) VALUES
	(105, 'Big Boat', 'Orange'),
	(106, 'Tiny boat', 'Black');
    
INSERT INTO Reserves (sid, bid, day) VALUES
	(5, 101, '2022-10-05'),
	(6, 106, '2022-10-08');

-- Find the average age of sailors grouped by their ratings and only including ratings that have 
-- an average age greater than 23

SELECT rating, AVG(age) AS avg_age
FROM Sailors
GROUP BY rating
HAVING AVG(age) > 23;

-- Using the Sailors, Reserves, and Boats tables, write a 
-- query to find the names of all boats that have never
-- been reserved  

SELECT bname
FROM Boats
WHERE NOT EXISTS (
	SELECT *
    FROM Reserves
    WHERE Boats.bid = Reserves.bid
);

-- Find all boats reserved only by someone older than 25

Select bname 
FROM Boats
WHERE NOT EXISTS (
	SELECT * 
    FROM Sailors, Reserves
    WHERE Boats.bid = Reserves.bid 
		AND Reserves.sid = Sailors.sid
        AND Sailors.age <= 25 );


    
    