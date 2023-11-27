--- Setup Journal DB
CREATE USER journal WITH PASSWORD 'journal@123';
CREATE DATABASE journal WITH OWNER = journal;
GRANT ALL PRIVILEGES ON DATABASE journal TO journal;

--- Setup Category DB
CREATE USER category WITH PASSWORD 'category@123';
CREATE DATABASE category WITH OWNER = category ;
GRANT ALL PRIVILEGES ON DATABASE category TO category;
