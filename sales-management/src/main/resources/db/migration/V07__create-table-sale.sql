CREATE TABLE sale (
                      code BIGINT PRIMARY KEY AUTO_INCREMENT,
                      date DATE NOT NULL,
                      user_code BIGINT NOT NULL,
                      FOREIGN KEY (user_code) REFERENCES users(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;