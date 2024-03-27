## SkillsMania : Documentation
**About SkillsMania**

<details><summary>Click to expand</summary>
SkillsMania is a Spring Boot Web Application, which gamifies elements of IBM SkillsBuild to create a more attractive and engaging learning environment. SkillsMania has not been officially deployed to a live domain as of yet, and is still going through iterations of development, hence there are some additional running instructions to get SkillsMania up and running on your machine.
</details>

**Running & Setting Up Requirements**

1. A stable internet connection
2. Any IDE which can run MVC Spring Applications. We will be including instructions for IntelliJ Idea (We will be using 2023.2.2, but recommend the latest version.) You cannot use the community edition, as it does not have the capability to run Spring Boot MVC Applications.
3. The installation of Git
4. Installation of MySQL with the succesful running of a local server (we recommed using MySQL Workbench 8.0CE and later versions )

**Running & Setting Up Instructions**

1. Open IntelliJ, or your relevant IDE. (Note the following instructions are applicable to IntelliJ).
2. Head to the top right corner, and perform the following operations

`Click : File > New > Project from Version Control > Repository URL > Version Control = Git`

3. You are now ready to clone the Gitlab Repository in which the main project is contained. Where URL is stated, paste the following link :

`https://campus.cs.le.ac.uk/gitlab/co2201-2024/group-16.git`

4. Now, locate the directory that the project that is about to be created in.

5. Great, now the project has been cloned! Now allow the project some time to build.

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

_**If the steps didn't go correctly or the programme is not running, below is some common issues with fixes.**_

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
2. You will now be on the landing page, and you will not be able to access the dashboard or any features until logging in or registering your new profile.
3. Cick the login link which will take you to the secure OAuth2 login/register page.
4. If you have an account already, then sign in, and skip to **instruction 7**. Otheriwse, to register your account, click the 'Sign Up' link at the bottom of the centre module. Follow the instructions and enter your desired username to be used in SkillsMania, your first and last name, as well as your email address, which can be used to reset your password if need be.
5. If you realised you do have an account, there is a link that will take you back to the login page at the bottom left centre of the centre module.
6. After succesfully filling in your details and setting up your password according to the requirements stated, you will be shown an option to enter a security question (optional).
7. Now that you have been logged in succesfully, you will be redirected to the securedPage, which will verify your details and then automatically redirect you to your dashboard within seconds!

**Forgotten your password?** Launch the application and click login to navigate to the OAuth2 Login page. Underneath the 'Sign In' button is a link which states 'Forgot Password?'. Click this button and follow the steps to reset your password.

**Log Out :** To logout from your account, click this link : http://localhost:8080/logout, which is also in the dashboard header formatted as the 'Log-Out' button.

**Dashboard**
1. After logging in/registering, you will now have access to the dashboard where you can access the rest of the web application
2. On the navigation bar at the top, there are links to the avatar selection page and the League table page.
3. In addition to this there is a welcome message with your username and the number of days you have used the system consecutively  in the form of a "streak".
4. Underneath the navigation bar, there are links to each cocurse, the link will direct you to 'http:localhost:8080/startCourse'.

**Avatar Selection Page**
1. On the dashboard navigation bar there is a button to navigate to 'http:localhost:8080/avatars'.
2. Upon arrival at the Avatar Selection page, you will see your current avatar displayed alongside available avatars for selection.
3. Here you can select an avatar if you have not already and it will appear as the current avatar and will be linked to your user.
4. if you wish to change your avatar, all you have to do is navigate back to the avatar selection and select a diffrent avatar.
5. If you encounter any issues while selecting an avatar, please ensure you are logged in and have a stable internet connection.

**Start time and completion time**
1. On the dashboard select a course from the available courses, clicking any of these will direct you to 'http:localhost:8080/startCourse'.
2. On this page there is a  start button, upon clicking that button you are redirected to the appropiate SkillsBuild course page in a new tab, simultaneously you are also redirected 'http:localhost:8080/endCourse'.
3. This page is for tracking course completetion, when you finish the course on skillbuild, return to this page click the end button, it will store your end time in the session.
4. Upon clicking the end button you are redirected to 'http:localhost:8080/show-druation', here the time you started the course, finished the course, course name, and duration is displayed.
5. In the event that you run into any errors during this workflow you will be redirected to 'http:localhost:8080/error-page', here you're notified you encountered an error. 

**League Tables system**
1. On the dashboard, the button labelled "Leaderboard" redirects the user to 'http:localhost:8080/leaderboard'.
2. League tables hold a maximum of 24 users, and every league has a lifespan of seven days. The remaining days are highlighted at the top
3. At the end of the lifespan, the top 6 users get promoted to the next tier up if any, and the bottom 6 get relegated vice-versa and accordingly.
4. There are 3 tiers namely in order: "Kings Intelligence", "Artificial Champions", and "Bronze". This is also highlighted at the top of the page
5. If the user is new, they get added to a league of "Bronze" tier – the lowest tier league. If no leagues of Bronze tier that are currently within capacity of 24 users exist, a new one is created and added to the database with the current user included as a member.
6. If the user has not visited the leaderboard endpoint since their league ended, they're presented with "notification.jsp" with informs them of their outcome. They can go on to their new league from that page by clicking the button labelled "LET'S GO" at the bottom.

**Streak system**
1. when a user first logs in they have a streak of 0
2. for every consecutive day they log in there streek increases by 1 e.g. if you log in monday, tuesday and wednesday there streak will be 3
3. if there user misses a day e.g. logs in monday and then wednesday there streek will reset to 0
4. on the dashboard the streak is in the top left after you log in


**Completion Goals**
1. On the Dashboard, there is a button labeled Availabe Goals that directs to available goals on the menu.
2. Here the user is able to choose from 3 predetermined goals and can also choose to either go back to the dashboard or look at current goals.
3. Once a goal is selected, It is then assigned to the user and the user is redirected to a page that outlines their current goals.
4. Once a Goal has been selected it cannot be selected again, and the user is made aware of this via an error message.
5. Once a Goal has been completed the user is then awarded the corresponding XP(Reward).

**Coin Reward System**
1. When a user joins the system they start off with a total coin count of 0.
2. By starting a course from the available course on the dashboard and successfully completing the task by returning to click the end course button they are rewarded 50 coins.
3. The more courses they complete the more coins they are rewarded and can gather.
4. This serves as an incentivite for users to complete more tasks.

**Crown Reward System**
1. This system indicates who is at the top of the leaderboard.
2. If the user has selected an avatar it will appear on the leaderboard page.
3. If the user has the highest amount of xp when compared to other users they will be at the top of the leaderboard and a crown will appear at the top of their avatar.
4. If the user does not have an avatar, a crown will not appear. 

**Popular Courses Filter**
1. This feature allows for filtering the course options based on popularity (How many users are taking or took the course)
2. Every time a user starts a new course the popularity count for the course increments by 1.
3. When the filter button on the dashboard is clicked, the course cards are re-arranged such that the most popular ones are listed first.

**Earn Badges**
1. When a user first logins and selects "badges" from the dashboard they will be redirected to the userProfile page containing username and the badges they have earned 
2. If the user has not completed any course available on the dashboard, they will have no badges
3. When a user completes a course, a badge will be assigned to them which they can view on the userProfile page

**The Progress Bar**

The progress bar has been created and positioned just underneath the main header menu on the application. The progress bar allows the user to have a visual reference of how much of the total courses they have completed.

- There are 5 courses available to complete in SkillsMania. The progress bar displays the percentage of how many courses have been completed.
- As there are 5 courses in total that can be completed, each course holds a weight of 20%.

A new user will start with 0% completion on the progress bar, and it will be completely grayed out, as they have not completed any courses yet. A succesful completion of a course will lead to the green incrementing of the progress bar on the dashboard once refreshed.

_If a user completes a single course 5 times, will they achieve 100% on the progress bar?_

- The progress bar will only increment based on the first attempt on a course a user has done. This has been done to prevent any misuse and also provides a better user experience. If a user completes one course for example, 5 times, the progress bar will only increment once.
- The progress bar has a maximum percentage of 100.


---------------------------------------
