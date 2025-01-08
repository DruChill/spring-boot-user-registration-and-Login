# spring-boot-user-registration-and-Login

What we have to build?

We have build two main functionalities:

Register user (stored data into MySQL database). 
Login Authentication - validate user login credentials with database email and password. 
We will secure the Registered Users Page with role-based Spring Security.


por el momento solo tenemos 3 productos o prendas:


- vestido:

INSERT INTO products (id, name, brand, size, price) VALUES
(69, 'vestido', 'classylady', 'M', 47.0),
(70, 'vestido', 'classylady', 'L', 52.0),
(71, 'vestido', 'elegantwear', 'M', 55.0),
(72, 'vestido', 'elegantwear', 'L', 60.0),
(73, 'vestido', 'vintagechic', 'M', 58.0);

- polos:

INSERT INTO products (id, name, brand, size, price) VALUES
(47, 'polo', 'topiitop', 'S', 12.0),
(48, 'polo', 'topiitop', 'M', 14.0),
(49, 'polo', 'topiitop', 'L', 16.0),
(50, 'polo', 'topiitop', 'XL', 18.0),
(51, 'polo', 'topiitop', 'XXL', 20.0);

- pantalones:

INSERT INTO products (id, name, brand, size, price) VALUES
(55, 'pantalon', 'stylemax', 'XS', 25.0),
(56, 'pantalon', 'stylemax', 'S', 28.0),
(57, 'pantalon', 'stylemax', 'M', 30.0),
(58, 'pantalon', 'stylemax', 'L', 32.0),
(59, 'pantalon', 'stylemax', 'XL', 35.0),

(60, 'pantalon', 'trendsetter', 'XS', 22.0),
(61, 'pantalon', 'trendsetter', 'S', 24.0),
(62, 'pantalon', 'trendsetter', 'M', 26.0),
(63, 'pantalon', 'trendsetter', 'L', 28.0),
(64, 'pantalon', 'trendsetter', 'XL', 30.0);
