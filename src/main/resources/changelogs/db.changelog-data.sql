--liquibase formatted sql

-- changeset drymlj:1
-- comment: data 1 - insert request types
INSERT INTO request_type
    (name)
VALUES ('Contract Adjustment'),
       ('Damage Case'),
       ('Complaint');
