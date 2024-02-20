## SkillsMania : Documentation
**About SkillsMania**

<details><summary>Click to expand</summary>
SkillsMania is a Spring Boot Web Application, which gamifies elements of IBM SkillsBuild to create a more attractive and engaging learning environment. SkillsMania has not been officially deployed to a live domain as of yet, and is still going through iterations of development, hence there are some additional running instructions to get SkillsMania up and running on your machine.
</details>

**Running & Setting Up Requirements**

1. A stable internet connection
2. Any IDE which can run MVC Spring Applications. We will be including instructions for IntelliJ Idea (latest version)
3. The installation of Git
4. Installation of MySQL with the succesful running of a local server

**Running & Setting Up Instructions**

1. Open IntelliJ, or your relevant IDE. (Note the following instructions are applicable to IntelliJ).
2. Head to the top right corner, and perform the following operations

`Click : File > New > Project from Version Control > Repository URL > Version Control = Git`

3. You are now ready to clone the Gitlab Repository in which the main project is contained. Where URL is stated, paste the following link :

`https://campus.cs.le.ac.uk/gitlab/co2201-2024/group-16.git`

4. Now, locate the directory that the project that is about to be created in.

5. Grea, now the project has been cloned! Now allow the project some time to build.

6. Configuring the database to ensure no errors : 

A) Open the project directory on the right hand side of IntelliJ, or where it is in your IDE. 

B) Open the **src > main > resources** folder. Locate the **application.properties** file. 

C) Now, either create a new local SQL Server with the **username : co2103**, **password : password** and **database name : co2103db**, or edit the following code in application properties with your server details : 

```
spring.datasource.url=jdbc:mysql://localhost:3306/co2103db

spring.datasource.username=co2103

spring.datasource.password=password
```
7. Run the application & head to http://localhost:8080/ where hopefully you will see the SkillsMania landing page.

**_Steps didn't go correctly? Programme not running? Don't worry, it happens everyone at some point, just check the troubleshooting steps below which might help._**

------------------------------

**Troubleshooting for some common issues**

| Issue    | Possible Resolution |
| ------ | ------ |
|    Gradle fails to build    | The most common issue here is the Java SDK not being set to the project SDK, hence the Gradle fails to build. The project **SDK is 17**, adjust this in the project settings, download if needed, and this should work now.       |
|   Database errors showing in project build causing the crash of programme     |  Ensure **application.properties** details are correct as shown in the running/setting up instructions above for the database.      |
I cannot run the project, as the classes are showing as 'teacups' and the programme run icon is grayed out / unclickable. | There can be many reasons to this, and you might want to refer to your IDE Documentation for more in depth case by case details. Our developer team faced this a few times during the course of intial development, and our simple fix was to ensure the folder that is at the top of the root project directory is **java_mvc_base**, not a folder which contains java_mvc_base.

---------------------------------------
### Feature by Feature Documentation
---------------------------------------

**Login & Register Page**
1. After succesfully starting the Spring Boot Application, head over to any web browser and in the search/URL bar,
insert 'http://localhost:8080'.



