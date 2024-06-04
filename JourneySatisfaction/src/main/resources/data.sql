-- Insert passengers
INSERT INTO passenger (id, name, email, phone_number) VALUES 
(1, 'John Doe', 'john.doe@example.com', '1234567890'),
(2, 'Jane Smith', 'jane.smith@example.com', '2345678901'),
(3, 'Alice Johnson', 'alice.johnson@example.com', '3456789012'),
(4, 'Bob Brown', 'bob.brown@example.com', '4567890123'),
(5, 'Charlie White', 'charlie.white@example.com', '5678901234');

-- Insert buses
INSERT INTO bus (id, service_provider, service_number, registration_number, capacity) VALUES 
(1, 'KSRTC', 'Service123', 'KS 12 QA 1234', 50),
(2, 'TNRTC', 'Service456', 'TM 12 BA 1234', 45),
(3, 'KRTC', 'Service789', 'KR 13 RQ 5766', 40),
(4, 'APSRTCovider1', 'AP 31 EQ 3443', 'REG101', 55),
(5, 'TGSRTC', 'TG 09 WQ 3243', 'REG202', 60);

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
