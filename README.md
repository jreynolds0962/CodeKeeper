# CodeKeeper
This is a program that generates cryptic and secure passwords for other applications.

### Running the program:

Once the repo is copied to your local machine you will need one of two jar files:
- mssql-jdbc-12.2.0.jre8.jar

or

- mssql-jdbc-12.2.0.jre11.jar

Add the jar file to your referenced libraries

1. Go to the [CodeGenerator.java](./Generator/src/CodeGenerator.java) file

2. Input your "website name" and "username" in the required fields

3. Create a Cped.java file in the same package, and add (We assume you have a table created with "website", "username", and "password" as column headers):

```java
public class Cped {
    String url = "jdbc:sqlserver://{database_name}.database.windows.net:1433;database={table_name}";
    String username = "{server_user_name}";
    String password = "{server_password}";
}
```

4. Run the program either using your IDE or command line

```
javac CodeGenerator.java
java CodeGenerator
```

5. The program will add your credentials to your sql table.

6. A txt file will be added to the source directory in case you need to store this unique password somewhere local

7. DB table should look similar to this:
![Screen Shot 2023-07-18 at 4 15 43 PM](https://github.com/jreynolds0962/CodeKeeper/assets/88413989/6f009ad4-6b83-4a34-a20a-39fc7b50d276)



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

