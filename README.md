# leanlo-backend
The backend application for the LearnLo LMS project of Software Dev Methods and Tools Course. Intial

# User Stories

As a service, I want to be able to create new users on LearnIO, so that the users can be able to login using the provided credentials.

As a service, I want to be able to update the user password, so that the user can use the new password to login when reset.

As a service, I should be able to login a user on the system and return a JWT token, so that the user can login on the UI.

As a service, I should be able to logout a user on the system, so that the JWT token can be set to expired.

As a service, I should be able to create new courses, so that students can be able to enrol for the courses.

As a service I should be able to edit course information, so that the course content can be updated.

As a service, I should be able to return a list of courses that a teacher has created, so that the teacher can view them.

As a service, I should be able to return a list of courses on the system, so that the student can view them and decide to enrol.

As a service, I should be able to assign a course to a student, so that he can be successfully enrolled in it.

As a service I should be able to return a list of courses that the student has enrolled in, so that the student can view them.

As a service, I should be able to get a course, so that the course details can be rendered to the user.

As a task, I should setup CI CD Pipeline, so that any changes done on the system can be deployed incrementally.

As a task, I should deploy the backend service on Google Cloud, so that the service can be accessible via the internet.

As a task, I should create the process flow diagram for some of the features, so that the the end to end process of the features can be visualized.

As a task, I should design the database, so that all tables, columns and relationships can be visualised.





## **LogIn Test Cases**

1. Test Case: Valid Login
   Test ID: TC01
   Test Description: Verify that a user can log in with valid credentials.
   Preconditions: User is registered with a valid username and password.
   Steps:
   Enter a valid username.
   Enter a valid password.
   Click the "Sign In" button.
   Expected Result: User should be successfully logged in and redirected to the dashboard.

2. Test Case: Invalid Login (Incorrect Username)
   Test ID: TC02
   Test Description: Verify that login fails when an incorrect username is entered.
   Preconditions: User is registered but uses an incorrect username.
   Steps:
   Enter an incorrect username.
   Enter a valid password.
   Click the "Sign In" button.
   Expected Result: Error message "Invalid username or password" should be displayed.

3. Test Case: Invalid Login (Incorrect Password)
   Test ID: TC03
   Test Description: Verify that login fails when an incorrect password is entered.
   Preconditions: User is registered but uses an incorrect password.
   Steps:
   Enter a valid username.
   Enter an incorrect password.
   Click the "Sign In" button.
   Expected Result: Error message "Invalid username or password" should be displayed.

4. Test Case: Blank Username and Password
   Test ID: TC04
   Test Description: Verify that login fails when both username and password fields are left blank.
   Steps:
   Leave the username field blank.
   Leave the password field blank.
   Click the "Sign In" button.
   Expected Result: Error message "Username and password are required" should be displayed.

5. Test Case: Blank Username
   Test ID: TC05
   Test Description: Verify that login fails when the username is left blank.
   Steps:
   Leave the username field blank.
   Enter a valid password.
   Click the "Sign In" button.
   Expected Result: Error message "Username is required" should be displayed.

6. Test Case: Blank Password
   Test ID: TC06
   Test Description: Verify that login fails when the password is left blank.
   Steps:
   Enter a valid username.
   Leave the password field blank.
   Click the "Sign In" button.
   Expected Result: Error message "Password is required" should be displayed.

7. Test Case: Forgot Password Link
   Test ID: TC07
   Test Description: Verify that the "Forgot Password" link redirects to the password recovery page.
   Steps:
   Click the "Forgot Password" link.
   Expected Result: User should be redirected to the "Forgot Password" or password recovery page.


10. Test Case: Login Button Disabled (Without Input)
    Test ID: TC10
    Test Description: Verify that the "Sign In" button is disabled when the username and password fields are empty.
    Steps:
    Ensure both username and password fields are empty.
    Expected Result: The "Sign In" button should be disabled until valid input is provided in both fields.
