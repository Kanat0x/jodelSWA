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