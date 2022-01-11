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
      VALUES ("1", "1234", "1234", "2022.09.01", "Post1", "1");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
      VALUES ("2", "1234", "1234", "2022.09.01", "Post2", "2");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
      VALUES ("3", "123", "123", "2022.09.01", "Post3", "1");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
      VALUES ("4", "123", "123", "2022.09.01", "Post4", "2");