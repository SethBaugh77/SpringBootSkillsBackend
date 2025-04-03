CREATE TABLE users (
                       user_id INT PRIMARY KEY,
                       name VARCHAR(255)
);

ALTER TABLE skills
    ADD CONSTRAINT fk_user_id
        FOREIGN KEY (user_id) REFERENCES users(user_id);
