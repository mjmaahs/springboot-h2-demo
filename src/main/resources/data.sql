INSERT INTO customer (username, customer_type, customer_since) 
VALUES      ('clark.kent', 1, To_date('2-DEC-2020', 'DD-MON-YYYY')),
            ('bruce.wayne', 2, To_date('2-DEC-2019', 'DD-MON-YYYY')),
            ('arthur.curry', 3, To_date('2-DEC-2018', 'DD-MON-YYYY')),
            ('hal.gordan', 1, To_date('2-DEC-2017', 'DD-MON-YYYY')),
            ('barry.allen', 2, To_date('2-DEC-2016', 'DD-MON-YYYY'));
            
            
INSERT INTO segment (name_en, name_ar)
VALUES      ('Staff', 'موظف'),
            ('Affiliate', 'منتسب'),
            ('Regular', 'عادي');
            
            
INSERT INTO segment_discount (segment_id, percentage_discount)
VALUES      (1, 20),
            (2, 15),
            (3, 10); 
			
			
INSERT INTO shopping_cart_item_group (name_en, name_ar)
VALUES      ('Grocery', 'محتويات بقالة'),
            ('Electronics', 'إلكترونيات'),
            ('Clothes', 'ملابس');	


INSERT INTO shopping_cart_item (user_id, price, quantity, shopping_cart_item_group_id)
VALUES      (2, 50, 2, 1),
			(2, 50, 2, 1),
            (2, 60, 3, 2),
            (3, 70, 4, 3);			