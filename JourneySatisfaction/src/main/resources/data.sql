-- Insert passengers
INSERT INTO passenger (id, name, email, phone_number) VALUES 
(1, 'John Doe', 'john.doe@example.com', '1234567890'),
(2, 'Jane Smith', 'jane.smith@example.com', '2345678901'),
(3, 'Alice Johnson', 'alice.johnson@example.com', '3456789012'),
(4, 'Bob Brown', 'bob.brown@example.com', '4567890123'),
(5, 'Charlie White', 'charlie.white@example.com', '5678901234');

-- Insert buses
INSERT INTO bus (id, service_provider, service_number, registration_number, capacity) VALUES 
(1, 'Provider1', 'Service123', 'REG123', 50),
(2, 'Provider2', 'Service456', 'REG456', 45),
(3, 'Provider3', 'Service789', 'REG789', 40),
(4, 'Provider1', 'Service101', 'REG101', 55),
(5, 'Provider2', 'Service202', 'REG202', 60);

-- Insert journeys
INSERT INTO journey (id, passenger_id, bus_id, date_of_journey) VALUES 
(1, 1, 1, '2024-06-02'),
(2, 2, 2, '2024-06-03'),
(3, 3, 3, '2024-06-04'),
(4, 4, 4, '2024-06-05'),
(5, 5, 5, '2024-06-06'),
(6, 1, 2, '2024-06-07'),
(7, 2, 3, '2024-06-08'),
(8, 3, 4, '2024-06-09'),
(9, 4, 5, '2024-06-10'),
(10, 5, 1, '2024-06-11');
