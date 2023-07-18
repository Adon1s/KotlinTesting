CREATE DATABASE HealthData;

USE HealthData;

CREATE TABLE Patients (
                          patientID INT AUTO_INCREMENT,
                          firstName VARCHAR(50),
                          lastName VARCHAR(50),
                          DOB DATE,
                          gender ENUM('M', 'F'),
                          PRIMARY KEY (patientID)
);

CREATE TABLE HealthRecords (
                               recordID INT AUTO_INCREMENT,
                               patientID INT,
                               dateOfRecord DATE,
                               bloodPressure VARCHAR(7),
                               pulse INT,
                               O2Sat DECIMAL(3, 2),
                               PRIMARY KEY (recordID),
                               FOREIGN KEY (patientID) REFERENCES Patients(patientID)
);
