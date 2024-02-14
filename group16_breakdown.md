Software Engineering Project : Group 16 

Meeting 1

18/01/2024
3-4PM. David Wilson Library.
Everyone is present except for Yiming.

Task 1: Get to know your group members
We met up at David Wilson Library and got to know each other and everyone's names, after an initial conversation on a WhatsApp group chat.
It went smoothly with almost everyone turning up on time which is excellent for the first meeting.
Everyone present except for : Yiming Peng. We have not heard from this person even after sending a few emails. Everyone else has agreed to the rules below.


Task 2: Group Rules
Everyone show up at least 5 minutes before meeting time 
Initials: HA, IJ, MBWB,SF, RYA, RK,SS

The person responsible for booking the meeting room every time is picked on rotation 
Initials: HA, IJ, MBWB, SF, RYA, RK ,SS

Everyone must have some input for the weekly meetings(come with ideas)
Initials: HA, IJ, MBWB,SS, RK, SF, RYA

Should complete all assigned work on time.
Initials: HA, IJ, MBWB, SF,SS, RK, RYA

The person who does not come to the meeting should inform everyone in advance via the WhatsApp group chat with their reason.
Initials: HA, IJ, SF, MBWB,SS, RK, RYA


Everyone should communicate with the group.
Initials: HA, IJ, SF,SS, MBWB, RK, RYA

If absent try to still contribute remotely if possible if not notify group + reason
Initials: HA, IJ,SS, MBWB, RK, RYA, RM

Decisions decided should have majority vote before being undertaken 
Initials:SS, SF, MBWB, RK, RYA, RM, HA

Everyone should agree on the meeting time and date before a booking is made. It should be suitable for all. 
Initials : RK,SS, SF, MBWB, RK, RYA, HA, RM

Sachvir: everyone should behave in a responsible and professional manner.
Initials:SF,SS, MBWB, RK, RYA, HA, RM

Each member print name & then sign:
Date: 18/01/2024
Print Name: Richard Yaya-Abatan Signature: Richard Yaya-Abatan
Print Name: Sultan Fahad Signature: Sultan Fahad
Print Name: Sachvir Singh  Signature: SS
Print Name: Isaiah Jones Signature: Isaiah Jones
Print Name: Rheon Mais Signature: Rheon Mais
Print Name: Hammed Agboluaje Signature: 
Print Name: Marcel Beya-Wa-Beya Signature: Marcel Beya-Wa-Beya
Print Name: Raza Khalid -  Signature: RazaK

Meeting 2

22/01/2024
2-3PM. David Wilson Library.

Things already mentioned:
Some sample features that the web app should include the ability for students to:
Login securely to their account.
View links to IBM SkillsBuild courses and resources.
Build a history of completed courses (with integration to SkillsBuild simulated).
Earn badges that progress as more courses are completed.
View a global leaderboard.
View a friends-only leaderboard.

Thinking of ideas for gamification(our ideas):
Daily score streak
Avatar could have clothes or facial features that are unlockable wut
Leaderboard - Top best this week, top best monthly.
Bronze, silver and gold badges depending on score on quiz
Customize character/avatar with unlocking’s ( coins,xp)
Coin system after quiz completed, can buy new avatars, clothing etc.
Highest person on leaderboard wears a crown
League system.
Profile - public username, etc.


User Stories List (we can shortlist the best ones) Bold are the ones we are doing
As a student I would like a crown for the #1 place on the leaderboard motivates me to strive to be the best.*****
As a student I would like a leaderboard so that I can compare my results to my peers and show that I’m him. **
As a student, and I would like an avatar so that I can publicly display myself and show off my progress ****** (set avatars that the user can choose, unlock and buy with coins) RAZA
As a student, I want to have access to a personal profile so that I can see past and present course activities and status (Hammed).**
As a student, i want a streak system, so that i can stay motivated to do the course everyday (Marcel)********
As a student, I want to have a league system, so that i can compare my progress to everyone (Marcel)(Isaiah)******
As a student, I want there to be a badge system for each module so I can monitor my strengths and weaknesses(Richard).******
As a student I want their to be a coin reward system for completing activities so that thier is an incentive(Sultan) ******





Definition of Done (DoD) Brainstorm List (Bold the ones we will keep)
Scrum board is updated, change has been reviewed within 2 days.(Sachvir)
At least 2 other people reviewing the update 
Bug tested, so all user stories have gone through testing and identifying for bugs.(Sultan)
Have a majority vote on any big changes for it to be approved (big change being defined as anything that adds a new feature, or further complications)
Remove issue from scrum board.
Pushed to review branch to be reviewed
All testing being completed, systematic and accessibility 
User stories reviewed by the team
Every week have one group meeting where we review all changes and commits
Code/task is finished


(updated) Definition of Done:

Definition of Done:
-          Scrum Board is updated with at least 1 other person reviewing the change.
-          Browser/device compatibility tested, to ensure it will work on a variety of machines and web browsers.
-          Code submitted is robust; has been stress tested, bug tested and can handle exceptions.
-          Code accurately represents the user story or meets the acceptance criteria.
-          All documentation updated.








Meeting 3 (With supervisor)

31/01/2024
11-1PM. PGB.01-02.

Isaiah is ill. Lance has a fever. Ree not present. Sach not present.
Do 8 if we can actually manage it, otherwise we can lower it to 6. Add a product backlog onto scrum board so that we don't have to do all 8 in the first sprint. - Done by Raza.
Most likely going with spring mvc to code.
The supervisor is saying to include the ‘avatar display as part of the dashboard’.

EXTRA USER STORIES                            BASIC USER STORIES

Sprint 1 stories finalised above.


ERM diagram link: https://drive.google.com/file/d/1yPgZ55j-vAlCmwf17IeBybqLL8gZIYkk/view?usp=sharing



Meeting - 05/02/2024
2-3PM. Lance, Ree not present. (Lance ill)

Ree was scrum master last week.
Hameed scrum master this week.

Meeting - 08/02/2024
2-3PM. Lance, Ree, not present.

Made decisions on how to sort out 

Here's an outline of the model structures, view structures, and details you'll need for the 7 user stories in your Java Spring and HTML project using the Model-View-Controller (MVC) architecture.

Model Structures:

User Model:

Fields: ID, username, password, email, badges, completion history, avatar, streak count, league(LeagueTable) etc.
Relationships: One-to-Many with completion history, One-to-One with avatar, Many-to-Many with badges.
Needs a user repository (Hammed)

Course Model:

Fields: ID, title, description, start time, completion time, etc.
Relationships: Many-to-Many with users (as completed courses).

Badge Model:

Fields: ID, name, description, image, etc.
Relationships: Many-to-Many with users.

Avatar Model:

Fields: ID, image, name, description, etc.
Relationships: One-to-One with users.
(done Sultan)

LeagueTable Model:
Fields: league_id (int), tier_name (String), members (List<User>)

View Structures:

Login and Register View:

Fields: Username, password, email, registration form, login form.
Features: Error messages for invalid credentials, registration success message, etc.

Dashboard View:

Features: User's completion history, badges earned, streak count, avatar display, course progress, etc.

Course View:

Features: Start time, completion time, progress bar, course description, etc.

LeagueTable View:

Features: List of users ranked by completion count, streak count, etc.

Avatar Selection View:

Features: List of available avatars, selection option, preview, etc.

Controller Structures:

User Controller:

Methods: Register, Login, Update Profile, Get Badges, Get Avatar, etc.

Course Controller:

Methods: Start Course, Complete Course, Get Course History, etc.

Badge Controller:

Methods: Get Badges, Assign Badge, etc.

Avatar Controller:

Methods: Select Avatar, Preview Avatar, Get Available Avatars, etc.
(Done Sultan)

Leaderboard Controller:

Methods: Get Leaderboard, Update Streak, etc.

JSP Breakdown:

Login and Register JSP:

login.jsp:
Input fields for username and password.
Submit button to authenticate the user.
Link to the registration page.

register.jsp:
Registration form with fields for username, email, password, and confirmation.
Submit button to create a new user account.

Dashboard JSP:

dashboard.jsp:
Display user's completion history with course details and completion times.
Show badges earned with descriptions and images.
Avatar display and selection option.
Streak count and progress visualization.

Record Start and Completion Times JSP:

courseDetails.jsp:
Display course details including start time, completion time, and description.
Button to start the course.
Indicator for course completion.

leagueTable.jsp:
List of users with completion counts and streak counts.
Highlight current user's position.
Visual indication of league levels or rankings.

Streak System JSP:

streak.jsp:
Display the current streak count for the user.
Visual representation of the streak, e.g., a progress bar or a streak badge.

Avatar Display JSP:

avatarSelection.jsp:
List of available avatars with images and names.
Selection option to choose the avatar.
Preview of the selected avatar.
(Done Sultan)


