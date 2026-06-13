CREATE TABLE users
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fullName  TEXT        NOT NULL,
    email      TEXT unique NOT NULL,
    department varchar(100)
);
CREATE TABLE leave_types
(
    id       BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    leave_name     TEXT    NOT NULL,
    max_days_per_year INTEGER NOT NULL,
    is_paid   boolean
);

CREATE TABLE leave_requests
(
    leave_id      BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    start_date    DATE NOT NULL ,
    end_date      DATE NOT NULL ,
    reason        TEXT,
    status        TEXT DEFAULT 'PENDING',
    user_id       BIGINT NOT NULL,
    leave_type_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (leave_type_id) REFERENCES leave_types (id)
);