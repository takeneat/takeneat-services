-- Password = test
INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (1,'test@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','A firstname','A lastname',null);


INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (2,'cook@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Cook firstname','Cook lastname',null);
INSERT INTO T_PRODUCT (ID,NAME,PRICE,CREATION_DATE,COOK_ID) VALUES (21,'Lasagna',5.50,'2015-01-01 01:00:00',2);
INSERT INTO T_PRODUCT (ID,NAME,PRICE,CREATION_DATE,COOK_ID) VALUES (22,'Sushis',7.55,'2015-01-02 02:00:00',2);


INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (3,'consumer@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','A firstname','A lastname',null);

INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME) VALUES (4,'consumer2@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Consumer 2 firstname','Consumer 2 lastname');
INSERT INTO T_ORDER (ID,CONSUMER_ID,PRODUCT_ID,CREATION_DATE) VALUES (1,4,22,'2015-01-02 02:00:00');


INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (5,'cook2@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Cook firstname','Cook lastname',null);


INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (6,'cook3@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Cook firstname','Cook lastname',null);
INSERT INTO T_PRODUCT (ID,NAME,PRICE,CREATION_DATE,COOK_ID) VALUES (61,'Tortilla',5.50,'2015-01-01 01:00:00',6);
INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (7,'consumer3@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Cook firstname','Cook lastname',null);
INSERT INTO T_ORDER (ID,CONSUMER_ID,PRODUCT_ID,CREATION_DATE) VALUES (71,7,61,'2015-01-02 02:00:00');
