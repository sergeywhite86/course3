-- liquibase formatted sql

-- changeset sergey_white:1

CREATE INDEX student_name_index ON student (name);
CREATE INDEX faculty_color_index ON faculty (color);