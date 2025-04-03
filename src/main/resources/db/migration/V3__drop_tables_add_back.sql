DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       user_id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE skills (
                        user_id INT PRIMARY KEY,
                        guitar INT,
                        rocketleague INT,
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);
