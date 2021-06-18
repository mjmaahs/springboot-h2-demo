drop table if exists customer;
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250),
    customer_type INT,
    customer_since DATE
);

drop table if exists segment;
CREATE TABLE segment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name_en VARCHAR(250),
    name_ar VARCHAR(250)
);

drop table if exists segment_discount;
CREATE TABLE segment_discount (
    id INT AUTO_INCREMENT PRIMARY KEY,
    segment_id INT,
    percentage_discount INT,
    FOREIGN KEY (segment_id) REFERENCES segment (id)
);

drop table if exists shopping_cart_item_group;
CREATE TABLE shopping_cart_item_group (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name_en VARCHAR(250),
    name_ar VARCHAR(250)
);

drop table if exists shopping_cart_item;
CREATE TABLE shopping_cart_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
	price DECIMAL(15,2),
	quantity INT,
	user_id INT,
	shopping_cart_item_group_id INT,
    FOREIGN KEY (shopping_cart_item_group_id) REFERENCES shopping_cart_item_group (id),
	FOREIGN KEY (user_id) REFERENCES customer (id)
);