
CREATE DATABASE IF NOT EXISTS busBookingDB;
USE busBookingDB;

CREATE TABLE buses (
    busId VARCHAR(10) PRIMARY KEY,
    busName VARCHAR(100) NOT NULL,
    source VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departureTime TIME NOT NULL,
    arrivalTime TIME NOT NULL,
    totalSeats INT NOT NULL,
    availableSeats INT NOT NULL,
    fare DECIMAL(10,2) NOT NULL,
    busType VARCHAR(50) NOT NULL
);

Select * from buses;

CREATE TABLE users (
    userId VARCHAR(10) PRIMARY KEY,
    userName VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    password VARCHAR(100) NOT NULL,
    createdDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

Select * from users;


CREATE TABLE tickets (
    ticketId VARCHAR(10) PRIMARY KEY,
    userId VARCHAR(10) NOT NULL,
    busId VARCHAR(10) NOT NULL,
    passengerName VARCHAR(100) NOT NULL,
    seatNumber INT NOT NULL,
    bookingDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    travelDate DATE NOT NULL,
    totalAmount DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'BOOKED',
    FOREIGN KEY (userId) REFERENCES users(userId) ON DELETE CASCADE,
    FOREIGN KEY (busId) REFERENCES buses(busId) ON DELETE CASCADE
);

Select * from tickets;


INSERT INTO buses VALUES 
('B001', 'Volvo Express', 'Chennai', 'Bangalore', '06:00:00', '12:00:00', 40, 40, 800.00, 'AC Sleeper'),
('B002', 'KPN Travels', 'Chennai', 'Coimbatore', '22:00:00', '05:00:00', 35, 35, 600.00, 'AC Semi Sleeper'),
('B003', 'Red Bus', 'Bangalore', 'Mumbai', '20:00:00', '12:00:00', 45, 45, 1200.00, 'AC Sleeper'),
('B004', 'SRS Travels', 'Chennai', 'Madurai', '07:30:00', '13:30:00', 30, 30, 500.00, 'Non-AC Seater');


