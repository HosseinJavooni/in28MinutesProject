CREATE TABLE PERSON
(
    id         integer        not null,
    name       NVARCHAR2(255) not null,
    location   NVARCHAR2(255),
    birth_date timestamp,
    primary key (id)
);
INSERT INTO PERSON (id, name, location, birth_date)
VALUES (10001, 'Mahan', 'Tehran', SYSDATE);
INSERT INTO PERSON (id, name, location, birth_date)
VALUES (10002, 'Mahan2', 'Tehran', SYSDATE);
INSERT INTO PERSON (id, name, location, birth_date)
VALUES (10003, 'Mahan3', 'Tehran', SYSDATE);
SELECT * FROM PERSON;
