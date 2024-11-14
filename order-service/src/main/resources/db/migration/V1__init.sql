CREATE TABLE `orders`
(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    order_number VARCHAR(255) NOT NULL,
    sku_code VARCHAR(255) NOT NULL,
    price decimal(19,2),
    quantity int(11),
    PRIMARY KEY (id)
);