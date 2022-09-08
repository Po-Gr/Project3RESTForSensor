CREATE TABLE sensor (
    name varchar(30) PRIMARY KEY);


CREATE TABLE measurement (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    value decimal CHECK(value <= 100 AND value >= -100),
    raining BOOLEAN NOT NULL,
    sensor_name int REFERENCES sensor(name) ON DELETE CASCADE,
    measured_at TIMESTAMP);