CREATE TABLE user_table (
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(300) NOT NULL DEFAULT '',
    last_name VARCHAR(300) NOT NULL DEFAULT '',
    email VARCHAR(300) NOT NULL DEFAULT '',
    age INT NOT NULL,
    address VARCHAR(300) NOT NULL DEFAULT '',
    status BOOLEAN DEFAULT FALSE,
    joining_date DATE,
    PRIMARY KEY (user_id)
);

