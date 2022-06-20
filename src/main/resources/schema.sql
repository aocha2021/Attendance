DROP TABLE IF EXISTS "user";


CREATE TABLE "user"
(
   "id" INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
   "name" VARCHAR(100) NOT NULL,
   "mail" VARCHAR(100) NOT NULL,
   "password" VARCHAR(100) NOT NULL,
   "authority" VARCHAR(100)
);


DROP TABLE IF EXISTS "attendance";


CREATE TABLE "attendance"
(
   "id" INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
   "userID" INTEGER NOT NULL,
   "aday" DATE,
   "atime" TIME(7),
   "lday" DATE,
   "ltime" TIME(7),
   "breaktime" TIME(7)
);