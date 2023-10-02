CREATE TABLE Healthcare (
                            HealthcareID SERIAL PRIMARY KEY,
                            Name VARCHAR(40),
                            Address VARCHAR(40),
                            Phone VARCHAR(30),
                            Email VARCHAR(30),
                            Type VARCHAR(20),
                            VaccineAvailability BOOLEAN,
                            TestAvailability BOOLEAN,
                            MapID INTEGER REFERENCES Map(MapID)
);

CREATE TABLE Appointment (
                             AppointmentID SERIAL PRIMARY KEY,
                             Date DATE,
                             DoseType VARCHAR(10),
                             Notes VARCHAR(255),
                             HealthcareID INTEGER REFERENCES Healthcare(HealthcareID)
);

CREATE TABLE Map (
                     MapID SERIAL PRIMARY KEY,
                     Latitude DECIMAL(9,6),
                     Longitude DECIMAL(9,6)
);