-- Some initial data
INSERT INTO TUSER (id, username, password) 
       VALUES ("1", "Ausername", "Apassword");
INSERT INTO TUSER (id, username, password)
       VALUES ("2", "Busername", "Bpassword");

INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("1", "123", "123", "2022.09.01", "1. Test Comment User 1", "1", "1");
INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("2", "123", "123", "2022.09.01", "2. Test Comment User 1", "2", "2");
INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("3", "123", "123", "2022.09.01", "1. Test Comment User 2", "2", "3");
INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("4", "123", "123", "2022.09.01", "2. Test Comment User 2", "2", "4");

INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("1", "123", "123", "2022.09.01", "Das ist ein Post", "1");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("2", "123", "123", "2022.09.01", "Und das ist der zweite Post", "2");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("3", "123", "123", "2020.09.01", "Ich habe keine lust mehr", "1");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("4", "123", "123", "2020.09.01", "Das ist eaber schönes wetter", "2");