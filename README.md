# Project: SJSU Foodie
#### Team #2: Elena Ilic, Manasi Nekkar, Robert Veloya

## Team members working on the propsal and their contributions in detail:
During the project proposal, all three team members collaborated together to brainstorm different features and use-cases of the application. For example, Robert suggested creating a PC application. Elena identified certain classes that could be implemented. Manasi suggested different features that the application should contain. 

For the diagrams, Elena created the Sequence diagrams and Use Case diagrams.
Robert worked on Class diagram. 
Manasi created the state diagram. After the project was finished, Manasi went back and updated the diagrams. 

## Team members working on the project (code) and report:
For the project, Elena worked on both the front end and back end of the application. She implemented numerous classes and frames. She also worked on ensuring that the backend complied with the front end.

For the project, Robert worked on different wireframes, color schemes, and fonts which would fall under front-end development with the use of Java Swing that is used later in the application. He also constructed the skeleton class that would be later developed further by Elena.

For the project, Manasi worked on implementing various methods to support the backend. For the report, she worked on the several parts, including the operations, functionality, intended usage, and the diagrams.

## Team members working on the project presentation and their contributions to details:
For the project presentation, Elena talked about the technical details covered in the presentation. She explained the different Object Oriented Design concepts that we implemented in the program. 

Robert spoke about different frames and designs that can be used for the application.

Manasi was responsible for introducing the project during the presentation. She talked about the intentions of the application and the reasoning behind the project. Additionally, she talked about the functionality, operations of the project, and the environment that we chose and the basis of choosing these environment.

## Problem/Issues:
One of the problems that the team faced is updating the user information. We created a txt file to include the user information, specifically the 

## Solution:
The issue stated beforehand was solved by using <Insert method used to resolve problem above>.

## Assumptions / Operating Environments / Intended Usage

Assumptions: Before running the program, please download and install the Helvettica Nueue font. 

Operating Evnironment: For the front-end, we utilized Java Swing and we used Java for the back-end. We chose to use Java Swing because Java Swing is part of the Java foundation class; thus, it was easy to connect the front-end to the back-end. 

Intended Usage: 
- Login and register
- Choose dietary preferences and criteria
- Show restaurants in the area that fit your criteria
- Show specific menu items that fit your criteria
- View and leave reviews for the restaurant

## Diagrams:
For the project proposal, Elena worked on the UseCase and the Sequence diagram. Robert drew out the  Class diagram. Manasi created the State diagram. 
Diagram | Class | State | Sequence | Use Case 
--- | --- | --- | --- |--- 
Link | [![CLASS](0.jpg)](https://github.com/eilici/CS151-Foodie/blob/c637d41d4c9bf9fc756d2b75fba097d0004e6880/diagrams/ClassDiagram_Foodie%20(2).jpg) | [![STATE](0.jpg)](https://github.com/eilici/CS151-Foodie/blob/c637d41d4c9bf9fc756d2b75fba097d0004e6880/diagrams/State%20Diagram%20Foodie.jpg) | [![SEQUENCE](0.jpg)](https://github.com/eilici/CS151-Foodie/blob/c637d41d4c9bf9fc756d2b75fba097d0004e6880/diagrams/Sequence_Foodie.drawio.png) | [![USE CASE](0.jpg)](https://github.com/eilici/CS151-Foodie/blob/c637d41d4c9bf9fc756d2b75fba097d0004e6880/diagrams/UseCase_Foodie.drawio.png)
Desc | Diagram showing structure of project | Diagram showing behavior of classes | Diagram showing order of objects working together | Diagram showing user actions

## Functionality:
- Our project helps users find restaurants close to campus that have food items for their specific diet (i.e, vegetarian, vegan, halal, etc)
- Once the user creates their account, they are immediately asked for their food preferences. There is a button on the homepage, where they can edit their preferences. 
- In the homepage, we have a list of several different restaurants that fit their criteria. The user can also see specific menu items that fit their dietary restrictions. Users can view other people's reviews as well as leave the reviews for the restaurants. 
- For the safety of our users, we have implemented several password requirements that must be met. For example, passwords must be at least 8 characters, contain at least 1 uppercase letter and lowercase letter, and must have a special character. <br />

## Operations: 
- First, the user should run the LoginFrame page. This page greets the user with our Welcome Page. Here, the user should be able to login in, if they already have an account, or sign up, if this is their first time. 
- In the SignUp Page, the user should enter their username and password. The password must be at least eight characters, contain at least one number, special character, uppercase letter, and lowercase letter. Error messages will pop if these conditions are not met. Once the username and password is entered in and accepted, the user is guided to the next page.
- The next page allows the user to input their dietary preferences. For example, they want to find restaurants with keto and vegetarians. Once they have chosen all options that are applicable, they press the done button, leading them to the Foodie homepage. 
- The homepage welcomes the user and lists their dietary preferences. Additionally, the homepage shows the restaurants that fit the criteria. 
- The user can select the restaruant to see the reviews and menu. Also, the user can add their own review of the restuarant.

## Steps to run the code:
To run the code in a way that is intended by the developers, a font that is included in the src/resource folder should be installed on the terminal first. This will allow the program to be in its aesthetic expectation.

After installing the Helvettica Nueue font, navigate to the main page of the C151-Foodie repository. Click the Code button at the top right hand side of the page and copy the HTTPS link given to clone the repository. Using the Command Prompt or Terminal to clone the project onto your local device. Then, open up any IDE that runs Java into the folder that holds the cloned code. We used Eclipse to run our application. 

Once the repository is cloned and downladed, the main method under the Foodie class is to be run. This will bring the user to the login page where they can enter their credentials if they are an existing user; if they are not an existing user, they can click the sign up button to enter their username and password which will be saved to the .txt file that stores user information.

## Snapshot of the running program:
<img width="565" alt="filter_change" src="https://user-images.githubusercontent.com/19766430/236347564-2297c20f-475b-4d11-be3b-aaf75b015b0a.png">
<img width="560" alt="write_review" src="https://user-images.githubusercontent.com/19766430/236347544-0aecc4fd-dac9-41b6-86be-c50b944a4bfc.png">
<img width="665" alt="sign_up_screen" src="https://user-images.githubusercontent.com/19766430/236347548-1605119f-3925-48de-84b7-4a8aaf339731.png">
<img width="667" alt="sign_up_screen_pwerror" src="https://user-images.githubusercontent.com/19766430/236347551-e2993c20-e540-4cd1-9928-1766f8bc6d83.png">
<img width="551" alt="see_more" src="https://user-images.githubusercontent.com/19766430/236347552-0cebf715-c243-4317-85d5-92748f53fa77.png">
<img width="641" alt="see_more_prefs" src="https://user-images.githubusercontent.com/19766430/236347553-feec45d2-58d0-486c-bbdb-5f8bd2313e72.png">
<img width="563" alt="review_included" src="https://user-images.githubusercontent.com/19766430/236347555-f2c32c49-7b75-49ad-be3b-e2790d6fac38.png">
<img width="562" alt="restaurant page" src="https://user-images.githubusercontent.com/19766430/236347556-236da3ff-ee83-4f23-9bfc-1d228519f4ae.png">
<img width="557" alt="menu_page" src="https://user-images.githubusercontent.com/19766430/236347560-4d722c44-fa86-4a82-a697-213d360bda1c.png">
<img width="560" alt="login_screen" src="https://user-images.githubusercontent.com/19766430/236347562-fa7afa05-5166-473c-826b-ea5233c5bcbd.png">
<img width="561" alt="filter_update" src="https://user-images.githubusercontent.com/19766430/236347563-7e43e7ef-e9b5-4efc-be6f-9242ca4d4f7c.png">
