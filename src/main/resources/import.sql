-- Password = test
INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (1,'paoesco@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Paolo','Escobar',null);
INSERT INTO T_USER (ID,EMAIL,PASSWORD,FIRSTNAME,LASTNAME,MOBILE_ID) VALUES (2,'romgar@takeneat.com','$2a$10$DvJ/I8uhGNIoqOOEmEeT4OHWghIsgVbOrGmVVsFLxzVe85fpFY2PC','Romain','Garrigues',null);

INSERT INTO T_PRODUCT (ID,NAME,PRICE,CREATION_DATE,COOK_ID) VALUES (1,'Sushis',7.55,'2015-01-01 01:00:00',1);
INSERT INTO T_PRODUCT (ID,NAME,PRICE,CREATION_DATE,COOK_ID) VALUES (2,'Eggs',3.50,'2015-01-02 02:00:00',2);