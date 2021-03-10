# p1lobos | Spring Project: Forum Board & Easter Egg Games

## Important Links
- [Website Link](https://apcsa-lobos-spring.azurewebsites.net) — hosted on [Microsoft Azure](https://azure.microsoft.com/en-us/)
- [Project planning board](https://github.com/sanvi1855544/springproject/projects/1)

## Project Overview
- Our spring project is a simple, stripped-down version of a forum board (along with an experimental page for testing features).
- We have 2 easter eggs:
  1) a web version of our old, semi-completed Doodle Jump Swing app
  2) a block-based version of the Google offline-mode dinosaur game
  
### [Home/Landing Page](https://apcsa-lobos-spring.azurewebsites.net/)
- Overview:
  - Serves as a hub for the major parts of the website
- Technicals involved (also used throughout all the other pages):
  - [Bootstrap](https://getbootstrap.com/): Used for CSS styling & some JS functions
    - Bootstrap was imported [here](https://github.com/sanvi1855544/springproject/tree/main/src/main/resources/static)
  - [Thymeleaf](https://www.thymeleaf.org/): Templates/fragments were used for common elements like the header bar
- Relevant code:
  - [index.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/index.html): The bulk of the landing page
  - Thymeleaf fragments: [body.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/fragments/body.html), [header.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/fragments/header.html) — incorporated in all pages

<img src="https://rtx.azurewebsites.net/bf60ec71b76c8edaed8d08cc2c642d92.png" width="500"/>

### Login/Register/Logout Functionality
- Overview:
  - Allows clients to login and register with a unique username and password
  - Usernames and passwords have requirements for length
  - Passwords are encrypted
  - Duplicate usernames are not allowed
  - All pages are updated to reflect when a client logs in (login/register buttons disappear and are replaced with a drop-down menu to log out)
  - Usernames are essential for the forum board feature (discussed later)
- Technicals involved:
  - [Lombok](https://projectlombok.org/): Helped speed up model code (by automating getter/setter code)
  - [JPA](https://spring.io/projects/spring-data-jpa): Allowed for the easy saving/loading (persistence) of Java objects
  - [Spring security](https://spring.io/projects/spring-security): Used to handle login/logout authentication
  - [Thymeleaf](https://www.thymeleaf.org/): Handled data transfer between server and client (HTML)
- Relevant code:
  - Server-end: [models for Role and User](https://github.com/sanvi1855544/springproject/tree/main/src/main/java/com/example/lobosspring/model), [corresponding repositories](https://github.com/sanvi1855544/springproject/tree/main/src/main/java/com/example/lobosspring/repository), [service implementations](https://github.com/sanvi1855544/springproject/tree/main/src/main/java/com/example/lobosspring/service), [new credentials validator](https://github.com/sanvi1855544/springproject/blob/main/src/main/java/com/example/lobosspring/validator/UserValidator.java), [GET/POST mappings](https://github.com/sanvi1855544/springproject/blob/main/src/main/java/com/example/lobosspring/web/UserController.java)
  - Client-end: [login.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/login.html), [register.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/register.html)
- Relevant runtime links:
  - [Login page](https://apcsa-lobos-spring.azurewebsites.net/login), [Register page](https://apcsa-lobos-spring.azurewebsites.net/register)

<img src="https://rtx.azurewebsites.net/df01c58cd34c984b37ba292d21d3ec5b.png" width="500"/>

### [Forum Board](https://apcsa-lobos-spring.azurewebsites.net/forumboard)
- Overview:
  - Clients can view posts made by others and make their own if they are logged in
  - Posts are sorted by date
  - All posts have a name and date
  - You can delete your posts (and only your posts)  
  - There is a link to an [experimental page](https://apcsa-lobos-spring.azurewebsites.net/experimental), which showcases new technologies to be incoporated (e.g. reply feature)
- Technicals involved:
  - [Thymeleaf](https://www.thymeleaf.org/): Thymeleaf was heavily used as a data transfer medium between the server and client (used to retrieve/pass post data and determine if a user is logged in or not)
  - [JS — DOM interface](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model): (Experimental) Client-sided replying feature (used to format buttons and dynamically create posts)
- Relevant code:
  - [UserController.java](https://github.com/sanvi1855544/springproject/blob/main/src/main/java/com/example/lobosspring/web/UserController.java): Consists of all the GET/POST mappings and the logic behind how posts are saved and shown
  - [forumboard.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/forumboard.html): Contains a lot of embedded thymeleaf statements

<img src="https://rtx.azurewebsites.net/64c41fec9aa2d96df65a2f2ab84e89d7.png" width="500"/>

### [Doodle Jump Game / Easter Egg](https://apcsa-lobos-spring.azurewebsites.net/doodlejump)
- Overview:
  - A remake of our old Swing Doodle Jump remake
  - Players can move left/right using the arrow keys
  - Basic physics (velocity/acceleration calculations) for smooth jumps
  - Shooting functionality
  - Monsters (affected by shooting)
  - Platforms (for player to jump on)
- Technicals involved:
  - [JS — DOM interface](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model); [class creation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes): Much of the Java code in our Swing project had to be ported over to JS, so a lot of features (classes, event listeners) were mimicked in JS
- Relevant code:
  - [doodlejump.js](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/static/js/doodlejump.js): Bulk of the game code
  - [doodlejump.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/doodlejump.html)

<img src="https://rtx.azurewebsites.net/2f4b204bccfc03254b594a6e0a089ec0.png" width="500"/>

### [Running Block Game / Easter Egg](https://apcsa-lobos-spring.azurewebsites.net/runningblock)
- Overview:
  - A block-based rendition of the Google Chrome offline-mode dinosaur game
  - Features jumping and score-keeping
- Technicals involved:
  - JS — DOM interface: see above (similar technicals as the Doodle Jump game)
- Relevant code:
  - [runningblock.js](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/static/js/runningblock.js): Bulk of the game code
  - [runningblock.html](https://github.com/sanvi1855544/springproject/blob/main/src/main/resources/templates/runningblock.html)

<img src="https://rtx.azurewebsites.net/37e5d28b71f999db00cd9a631a746b45.png" width="500"/>

## Runtime Guidelines
- Pull from the main branch
- Run main method in src/main/java/com/example/lobosspring/LobosSpringApplication.java
- Visit [localhost:8080](localhost:8080) in your browser

## Changelog (Ticket items)
- Some items/changes refer to the same ticket if multiple weeks' worth of progress was done for one feature/component (in this case, the ticket should clarify what work was done each week)
- Links to code and runtime evidence are found in the linked tickets.

Date | Changes |
----------- | ----------- |
3/9 | - [[Done] Integrate user & forum post data @Dominic](https://github.com/sanvi1855544/springproject/issues/1) <br> - [[Done] Better, more functional home/landing page @Dominic](https://github.com/sanvi1855544/springproject/issues/12) <br> - [[Done] Add the second easter egg game @Sanvi](https://github.com/sanvi1855544/springproject/issues/11) <br> - [[Done] Finished the Doodle Jump easter egg @Sean](https://github.com/sanvi1855544/springproject/issues/3) <br> - [[Done] Finished experimental version of the reply to posts feature @Jason](https://github.com/sanvi1855544/springproject/issues/2)
2/18 | - [[Done] Design website hub & stylize each page (w/ Bootstrap) @Dominic](https://github.com/sanvi1855544/springproject/issues/9) <br> - [[Done] Design of login/register page @Dominic](https://github.com/sanvi1855544/springproject/issues/10) <br> - [[Done] Delete button now works. @Jason](https://github.com/sanvi1855544/springproject/issues/2) <br> - [[Done] Add basic animation to easter egg game @Sean](https://github.com/sanvi1855544/springproject/issues/8) <br> 
2/5 | - [[Done] Easter Egg initial site commit @Sean](https://github.com/sanvi1855544/springproject/issues/7) <br> - [[WIP] Integrate Swing easter egg into browser @Sean](https://github.com/sanvi1855544/springproject/issues/3) <br> - [[Done] Website pushed to internet @Dominic](https://github.com/sanvi1855544/springproject/issues/6) <br> - [[WIP] Set up demo users database using JPA @Dominic](https://github.com/sanvi1855544/springproject/issues/1) <br> - [[Done] Created page for upvoting and inserting upvoting icon @Sanvi](https://apcsa-lobos-spring.azurewebsites.net/upvote.html) <br> - [[Done] Posting, textbox and button are done @Jason](https://github.com/sanvi1855544/springproject/issues/2)

## Contributors
Contributor | GitHub Link |
----------- | ----------- |
Dominic Phung | [@domph](https://github.com/domph) |
Sanvi Pal | [@sanvi1855544](https://github.com/sanvi1855544) |
Jason Chang | [@Dragon0344](https://github.com/Dragon0344) |
Sean Rollins | [@banditcat12](https://github.com/banditcat12) |

## Adapted Open-Source Code
- Website uses a modified version of [Bootstrap 4 Login Page](https://github.com/nauvalazhar/bootstrap-4-login-page)
- Website uses a heavily modified version of (Thymeleaf instead of JSP) [registration/login tutorial](https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/)