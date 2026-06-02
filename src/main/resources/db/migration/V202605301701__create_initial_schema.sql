CREATE TABLE users
(
    id         BIGINT PRIMARY KEY AUTOINCREMENT,
    fullName  TEXT        NOT NULL,
    email      TEXT unique NOT NULL,
    department varchar(100)
);
CREATE TABLE leave_types
(
    id       BIGINT PRIMARY KEY AUTOINCREMENT,
    leave_name     TEXT    NOT NULL,
    max_days_per_year INTEGER NOT NULL,
    is_paid   boolean
);

CREATE TABLE leave_requests
(
    leave_id      BIGINT PRIMARY KEY AUTOINCREMENT,
    start_date    TEXT,
    end_date      TEXT,
    reason        TEXT,
    status        TEXT DEFAULT 'PENDING',
    user_id       BIGINT NOT NULL,
    leave_type_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (leave_type_id) REFERENCES leave_types (id)
);