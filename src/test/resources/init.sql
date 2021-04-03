INSERT INTO `author` (`id`, `name`)
VALUES ('A_1', 'Author_1'),
       ('A_2', 'Author_2'),
       ('A_3', 'Author_3'),
       ('A_4', 'Author_4'),
       ('A_5', 'Author_5');

INSERT INTO `review` (`id`, `score`)
VALUES ('R_1', 20),
       ('R_2', 30),
       ('R_3', 40),
       ('R_4', 50),
       ('R_5', 60),
       ('R_6', 70),
       ('R_7', 80),
       ('R_8', 90);

INSERT INTO `book` (`id`, `author_id`, `review_id`)
VALUES ('B_1', 'A_1', 'R_1'),
       ('B_2', 'A_2', 'R_2'),
       ('B_3', 'A_3', 'R_3'),
       ('B_4', 'A_4', 'R_4'),
       ('B_5', 'A_5', 'R_5'),
       ('B_6', 'A_2', 'R_6'),
       ('B_7', 'A_2', 'R_7'),
       ('B_8', 'A_3', 'R_8');

