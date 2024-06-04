-- Insert passengers
INSERT INTO passenger (name, email, phone_number)
SELECT 'John Doe', 'john.doe@example.com', '1234567890'
UNION ALL
SELECT 'Jane Smith', 'jane.smith@example.com', '2345678901'
UNION ALL
SELECT 'Alice Johnson', 'alice.johnson@example.com', '3456789012'
UNION ALL
SELECT 'Bob Brown', 'bob.brown@example.com', '4567890123'
UNION ALL
SELECT 'Charlie White', 'charlie.white@example.com', '5678901234';

-- Insert buses
INSERT INTO bus (service_provider, service_number, registration_number, origin, destination, capacity)
SELECT 'KSRTC', 'Service123', 'KS 12 QA 1234', 'Bangalore', 'Mysore', 50
UNION ALL
SELECT 'TNRTC', 'Service456', 'TM 12 BA 1234', 'Chennai', 'Madurai', 45
UNION ALL
SELECT 'KRTC', 'Service789', 'KR 13 RQ 5766', 'Kochi', 'Trivandrum', 40
UNION ALL
SELECT 'APSRTC', 'Service456', 'AP 31 EQ 3443', 'Hyderabad', 'Vijayawada', 55
UNION ALL
SELECT 'TGSRTC', 'Service0123', 'TG 09 WQ 3243', 'Warangal', 'Hyderabad', 60;


-- Insert journeys
INSERT INTO journey (passenger_id, bus_id, date_of_journey)
SELECT passenger.id, bus.id, '2024-06-02'
FROM passenger, bus
WHERE passenger.name = 'John Doe' AND bus.service_provider = 'KSRTC'  -- Assuming John Doe uses KSRTC Service123 on 2024-06-02 (Adjust conditions as needed)
UNION ALL
SELECT passenger.id, bus.id, '2024-06-03'
FROM passenger, bus
WHERE passenger.name = 'Jane Smith' AND bus.service_provider = 'TNRTC'