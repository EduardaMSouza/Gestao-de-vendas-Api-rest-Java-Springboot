CREATE TABLE shopping_cart (
                           code BIGINT PRIMARY KEY AUTO_INCREMENT,
                           quantity INTEGER NOT NULL,
                           cart_price DECIMAL(10,2) NOT NULL,
                           date DATE NOT NULL,
                           user_code BIGINT NOT NULL,
                           FOREIGN KEY (user_code) REFERENCES users(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;