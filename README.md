# Todo List Application
This is a simple command-line Todo List application built in Java. The goal of this project is to demonstrate basic file handling, object-oriented design, and clean code structure while keeping the application easy to run and understand.
The app allows users to:

1. Add new tasks
2. List all tasks
3. Remove tasks
4. Classify tasks by category
5. Store all tasks in a local file (tasks.txt)

No database or UI was required, as mentioned in the task description.

**1. Approach and Design**

I wanted to build the application in a way that is simple, readable, and easy to maintain.
I divided the project into three small classes, each with a clear responsibility:

## Task.java

Represents a single task

Contains task name, category, and completion status

Stores information in a format that can be saved to a file

## TodoApp.java

Handles reading from and writing to the file

Manages the list of tasks (add, remove, list)

Takes care of parsing file data into Task objects

## Main.java

Provides the command-line menu

Interacts with the user and triggers operations in TodoApp

This structure keeps the code modular, making each part easier to test and understand.

**2. Project Structure**
`todo-app/
│
├── Main.java          → Runs the menu and user interface
├── TodoApp.java       → Handles file operations and task management
├── Task.java          → Defines the Task model
├── tasks.txt          → Stores all saved tasks
└── README.md          → Project documentation`

**3. System Overview (Simple Class Diagram)**
Class Diagram – High Level
+------------+         +------------+          +-------------+
|   Main     | ----->  |  TodoApp   | ----->   |    Task     |
+------------+         +------------+          +-------------+
         |                    |                        |
   User Input           File Handling           Task Details

## Responsibilities Diagram
Task:
 - name
 - category
 - completed (true/false)

TodoApp:
 - loadTasks()
 - saveTasks()
 - addTask()
 - removeTask()
 - listTasks()

Main:
 - showMenu()
 - connect user actions to TodoApp

** 4. How to Run the Application**
Prerequisites

Java installed (Java 17 or above recommended)
VS Code or any Java IDE

Steps

Clone the repository

Open the folder in VS Code

Open the terminal inside VS Code

Compile the program:

`javac Main.java TodoApp.java Task.java`

Run the application:

`java Main`

A menu will appear allowing you to:
1. Add tasks
2. Remove tasks
3. List tasks
4. Exit the app

**5. Testing and Verification
Test Data Used**

I added a few sample tasks manually to validate:

Adding multiple tasks
Removing tasks by number
Handling missing tasks
File saving and loading
Category-based classification

Verification Steps
1. Add test tasks
2. Restart the app to ensure tasks persist
3. Remove a task and re-list to confirm
4. Check the tasks.txt file to see updated data

**6. Key Learnings**
While building this app, I practiced:
Working with Java file I/O
Designing small object-oriented classes
Handling user input
Managing lists and parsing data
Keeping code simple and readable

**7. Conclusion**
This project meets all the requirements from the assignment. It is lightweight, modular, and demonstrates clear understanding of Java basics, file handling, and simple application design.