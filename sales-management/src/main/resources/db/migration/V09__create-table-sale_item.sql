CREATE TABLE sale_item (
                           code BIGINT PRIMARY KEY AUTO_INCREMENT,
                           product_code BIGINT NOT NULL,
                           sale_code BIGINT NOT NULL,
                           quantity INTEGER NOT NULL,
                           sale_price DECIMAL(10,2) NOT NULL,
                           FOREIGN KEY (product_code) REFERENCES products(code),
                           FOREIGN KEY (sale_code) REFERENCES sale(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;