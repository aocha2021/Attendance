INSERT INTO "user"("name","mail", "password", "authority")
VALUES('yama1','yama@co.jp', '$2a$10$8Cob0VZ4QpJUaoF9u83cK..8QXWvDKIPE.aSqEIV3gZgfVfLBDFoS', 'ROLE_USER');

INSERT INTO "user"("name","mail", "password", "authority")
VALUES('kama2','kama@co.jp', '$2a$10$8Cob0VZ4QpJUaoF9u83cK..8QXWvDKIPE.aSqEIV3gZgfVfLBDFoS', 'ROLE_USER');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('2','2022-06-06','09:00:00', '2022-06-06','18:00:00', '01:00:00');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('2','2022-06-07','09:00:00', '2022-06-07','18:00:00', '01:00:00');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('2','2022-06-08','09:00:00', '2022-06-08','18:00:00', '01:00:00');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('1','2022-06-06','09:00:00', '2022-06-06','18:00:00', '01:00:00');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('1','2022-06-07','09:00:00', '2022-06-07','18:00:00', '01:00:00');

INSERT INTO "attendance"("userID","aday", "atime", "lday","ltime", "breaktime")
VALUES('1','2022-06-08','09:00:00', '2022-06-08','18:00:00', '01:00:00');