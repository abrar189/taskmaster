# Taskmaster

# lab 26:
## Building an Android app that contains:

1. Homepage it should have a heading at the top of the page, an image to mock the “my tasks” view,
and buttons at the bottom of the page to allow going to the “add tasks” and “all tasks” page.

![image description](screenshots/task.PNG)


2. Add a Task allow users to type in details about a new task, specifically a title and a body. When users click the “submit” button, show a “submitted!” label on the page.

![image description](screenshots/task0.PNG)

3. All Tasks should just be an image with a back button

![image description](screenshots/task1.PNG)

## lab 27 :

1. Home page contain three different buttons with hardcoded task titles. When a user taps one of the titles, it goes to the
Task Detail page, and the title at the top of the page match the task title that was tapped on the previous page.
The homepage also contain a button to visit the Settings page, and once the user has entered their username,
it displays “{username}’s tasks” above the three task buttons.

![image description](screenshots/homepage.PNG)

2. Task Detail Page have a title at the top of the page, and a Lorem Ipsum description.

![image description](screenshots/details.PNG)

3. Settings Page allow users to enter their username and hit save.

![image description](screenshots/setting.PNG)

## lab 28 :

1. Refactor homepage to use a RecyclerView for displaying Task data. This have hardcoded Task data for now.

![image description](screenshots/lab28.PNG)

2. you can tap on any one of the Tasks in the RecyclerView, and it will appropriately launch the detail page with the correct Task title displayed and body and state.

![image description](screenshots/1lab28.PNG)
![image description](screenshots/2lab28.PNG)

## lab 29 :

1. Task Model and Room Following the directions provided in the Android documentation, set up Room in your application, and modify your Task class to be an Entity.

   Add Task Form Modify your Add Task form to save the data entered in as a Task in your local database.

   Homepage Refactor your homepage’s RecyclerView to display all Task entities in your database.

![image description](screenshots/lab29.PNG)
![image description](screenshots/1lab29.PNG)
![image description](screenshots/2lab29.PNG)

2. Detail Page Ensure that the description and status of a tapped task are also displayed on the detail page, in addition to the title

![image description](screenshots/3lab29.PNG)

## Lab: 31 - Espresso and Polish:

1. Espresso Testing : Add Espresso to your application, and use it to test basic functionality of the main components of your application

2. Polish : Complete any remaining feature tasks from previous days’ labs.