CREATE TABLE cart_products (
                               code BIGINT PRIMARY KEY AUTO_INCREMENT,
                                product_code BIGINT NOT NULL,
                                cart_code BIGINT NOT NULL,
                               FOREIGN KEY (cart_code) REFERENCES shopping_cart(code),
                               FOREIGN KEY (product_code) REFERENCES products(code)

) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;