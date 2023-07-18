# CodeKeeper
This is a program that generates cryptic and secure passwords for other applications.

## Preparation:

### Quesitons:

* How do I get a random item from a list of character?

* How do I add the random item to a new list?

* How do I convert new list into a string? 

* Should I create multiple lists of characters for the random item to be selected?

* How can I connect to SQL database and add username and password to table?

### Steps:

1. Create method that creates unique password string
   - Have multiple ways of creating password (w/ special characters, w/o special characters)
   - Create logic on when to use certain characters (capitals, lowercase, specials, numbers)
2. Establish SQL DB Connection
   - Create sql db
   - Create username and password file to store DB credentials
   - Connect to DB through Java through username and password.
3. Create Query that inserts website, username, and password into DB
   - first see if you can access table from DB (SELECT * FROM /...)
   - Try test insert of deafult values
   - Insert values with produced password
4. Integrate with ADO
   - Create yaml file that runs java program succesfully
   - Incorporate parameters for user to input website and username
   - Create text file in Java app that includes user and pwd
   - publish text file as artifact