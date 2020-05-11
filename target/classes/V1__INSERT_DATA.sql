INSERT INTO author
(first_name,last_name)
VALUES
('George','Martin'),
('Francis','Fitzgerald'),
('Hiroshi','Sakurazaka'),
('Lian','Banks'),
('H.P','Lovecraft'),
('Neil','Gaiman'),
('William','Shakespeare'),
('Mikhail','Bulgakov'),
('Robin','Hobb'),
('C.S','Friedman'),
('Brent','Weeks'),
('Blake', 'Crouch'),
('Ian', 'McGuire'),
('Agatha', 'Christie'),
('Jon','Wang');

INSERT INTO address
(country, region, street, apartment)
VALUES
('Jordan','Amman','King Abdullah',21),
('Palestine','Gaza','Al-Nafda', 22),
('Egypt','Cairo','Al-Haram',23),
('Saudi Arabia','Tabuk','M. bin Khalid', 10),
('Iraq','Bagdad','Al-Quds', 25),
('Syria','Damascus','Al-Tahrer', 27),
('Lebanon','Bayrut','Al-Dayha', 13),
('Qatar','Al-Dayha','Mohammad bin suliem', 113),
('UAE','Dubai','Khalid bin Al-Walied', 92),
('USA','California','Krenshaw', 313),
('Netherlands','Amsterdam','Marcantilaan',76),
('UK','Scotland','something', 45),
('Russia','Moscow','anything', 76),
('Belarus','Minsk','v. l. biady', 205),
('Poland','Warsaw','a street', 457);

INSERT INTO users
(first_name, last_name, phone_number, address_id)
VALUES
('Jon', 'Snow', '+1-202-555-0148', 1),
('Jay', 'Gatsby', '+1-202-555-0159', 2),
('Keiji', 'Kiriya', '+1-202-555-0192', 3),
('Francis', 'Cauldhame', '+1-202-555-0155', 4),
('Francis W.', 'Thurston', '+1-202-555-0137', 5),
('Shadow', 'Moon', '+1-202-555-0184', 6),
('prince', 'Hamlet', '+1-202-555-0140', 7),
('Master', 'Margarita', '+1-202-555-0170', 8),
('FitzChivalry', 'Farseer', '+1-202-555-0127', 9),
('Damien', 'Vryce', '+1-202-555-0172', 10),
('Durzo', 'Blint', '+1-202-555-0167', 11),
('Jason', 'Dessen', '+1-202-555-0164', 12),
('Patrick', 'Sumner', '+1-202-555-0142', 13),
('Jerry', 'Burton', '+1-202-555-0150', 14),
('Michiel', 'Tristien', '+1-202-555-0101', 15);

INSERT INTO category
(category)
VALUES
('fantasy'),
('tragedy'),
('sci-fi'),
('psychological thriller'),
('Lovercraftian horror'),
('fantasy'),
('Shakespearian tragedy'),
('satire fantasy'),
('fantasy'),
('sci-fi fantasy'),
('fantasy'),
('sci-fi'),
('dark fiction'),
('mystery'),
('horror');

INSERT INTO book
(tittle, number_of_pages, author_id, category_id)
VALUES
('ASOIAF', 5035, 1, 1),
('The Great Gatsby', 218, 2, 2),
('All you need is kill', 550, 3, 3),
('The Wasp Factory', 184, 4, 4),
('The call of Cthulhu', 420, 5, 5),
('AmericaGods', 465, 6, 6),
('Hamlet', 500, 7, 7),
('Master and margarita', 392, 8, 8),
('The Farseer', 1722, 9, 9),
('Coldfire', 1479, 10, 10),
('The Night Angel', 2208, 11, 11),
('Dark Matter', 496, 12, 12),
('The North Water', 315, 13, 13),
('The moving finger', 229, 14, 14),
('Ages', 600, 15, 15);

INSERT INTO transactions
(date, price, user_id, book_id)
VALUES
('4/04/2020', 50, 1, 1),
('4/04/2020', 51, 2, 2),
('4/04/2020', 52, 3, 3),
('4/04/2020', 53, 4, 4),
('4/04/2020', 54, 5, 5),
('4/04/2020', 55, 6, 6),
('4/04/2020', 56, 7, 7),
('4/04/2020', 57, 8, 8),
('4/04/2020', 58, 9, 9),
('4/04/2020', 89, 10, 10),
('4/04/2020', 60, 11, 11),
('4/04/2020', 61, 12, 12),
('4/04/2020', 62, 13, 13),
('4/04/2020', 63, 14, 14),
('4/04/2020', 64, 15, 15);

INSERT INTO shelf
(book_id)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15);

INSERT INTO orders
(book_id, transactions_id)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15);

INSERT INTO closet
(shelf_id)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15);

INSERT INTO library
(closet_id)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15);

INSERT INTO basket
(book_id)
VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15);

INSERT INTO account
(username, password, role, user_id)
VALUES
('user1', '12345', 'guest', 1),
('user2', '12345', 'guest', 2),
('user3', '12345', 'guest', 3),
('user4', '12345', 'guest', 4),
('user5', '12345', 'guest', 5),
('user6', '12345', 'guest', 6),
('user7', '12345', 'guest', 7),
('user8', '12345', 'guest', 8),
('user9', '12345', 'guest', 9),
('user10', '12345', 'guest', 10),
('user11', '12345', 'guest', 11),
('user12', '12345', 'guest', 12),
('user13', '12345', 'guest', 13),
('user14', '12345', 'guest', 14),
('user15', '12345', 'guest', 15);