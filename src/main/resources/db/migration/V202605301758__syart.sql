CREATE TABLE leave_requests
(
    leave_id      BIGINT NOT NULL,
    start_date    date NULL,
    end_date      date NULL,
    reason        VARCHAR(255) NULL,
    status        VARCHAR(255) NULL,
    user_id       BIGINT NOT NULL,
    leave_type_id BIGINT NOT NULL,
    CONSTRAINT pk_leave_requests PRIMARY KEY (leave_id)
);

ALTER TABLE leave_requests
    ADD CONSTRAINT FK_LEAVE_REQUESTS_ON_LEAVE_TYPE FOREIGN KEY (leave_type_id) REFERENCES leave_types (id);

ALTER TABLE leave_requests
    ADD CONSTRAINT FK_LEAVE_REQUESTS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);