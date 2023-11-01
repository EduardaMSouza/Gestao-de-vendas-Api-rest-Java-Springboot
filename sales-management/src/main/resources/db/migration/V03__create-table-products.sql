CREATE TABLE IF NOT EXISTS products (
                         code BIGINT PRIMARY KEY AUTO_INCREMENT,
                         description VARCHAR(100) NOT NULL,
                         quantity INTEGER NOT NULL,
                         cost_price DECIMAL(10,2) NOT NULL,
                         selling_price DECIMAL(10,2) NOT NULL,
                         observation VARCHAR(500),
                         category_code BIGINT NOT NULL,
                         FOREIGN KEY (category_code) REFERENCES categories(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;