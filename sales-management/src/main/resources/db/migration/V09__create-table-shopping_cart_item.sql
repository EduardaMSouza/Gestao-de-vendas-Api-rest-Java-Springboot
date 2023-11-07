CREATE TABLE shopping_cart_item (
                           code BIGINT PRIMARY KEY AUTO_INCREMENT,
                           product_code BIGINT NOT NULL,
                           cart_code BIGINT NOT NULL,
                           quantity INTEGER NOT NULL,
                           cart_price DECIMAL(10,2) NOT NULL,
                           FOREIGN KEY (product_code) REFERENCES products(code),
                           FOREIGN KEY (cart_code) REFERENCES shopping_cart(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;