/*All User's gets stored in APP_USER table*/
DROP TABLE IF exists USERS;
create table USERS (
  id SERIAL,
   ssoid VARCHAR(30) NOT NULL,
   password VARCHAR(100) NOT NULL,
   lastName  VARCHAR(30) NOT NULL,
   firstName VARCHAR(30) NOT NULL,
   age int NOT NULL,
   email VARCHAR(30) NOT NULL,
   date_inscription TIMESTAMP NOT NULL,
   country VARCHAR(30) NOT NULL,
   latitude decimal NOT NULL,
   longitude decimal NOT NULL,
   state VARCHAR(30) NOT NULL,  
   PRIMARY KEY (id),
   UNIQUE (ssoid)
);

  
/* USER_PROFILE table contains all possible roles */ 
create table PROFILES(
   id SERIAL,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);
  
/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE USERS_PROFILES (
    user_id integer,
    user_profile_id integer,
    PRIMARY KEY (user_id, user_profile_id),
    CONSTRAINT FK_USERS FOREIGN KEY (user_id) REFERENCES USERS (id),
    CONSTRAINT FK_PROFILES FOREIGN KEY (user_profile_id) REFERENCES PROFILES (id)
);
 
/* Populate USER_PROFILE Table */
INSERT INTO PROFILES(type)
VALUES ('USER');
 
INSERT INTO PROFILES(type)
VALUES ('ADMIN');
 
INSERT INTO PROFILES(type)
VALUES ('DBA');
 
 
/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO USERS(ssoId, password, firstName, lastName, age, email, date_inscription, country, latitude, longitude, state)
VALUES ('sam','sam', 'Abdoul','DIALLO', 29, 'abdoul@email.com', now(), 'FRANCE', 50.640266, 3.074592, 'Active');
 
 
/* Populate JOIN Table */
INSERT INTO USERS_PROFILES (user_id, user_profile_id)
  SELECT util.id, profile.id FROM USERS util, PROFILES profile
  where util.ssoId ='sam' and profile.type='ADMIN';
  
