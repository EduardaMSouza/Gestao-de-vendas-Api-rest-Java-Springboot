CREATE TABLE IF NOT EXISTS users (
    code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(150) NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;