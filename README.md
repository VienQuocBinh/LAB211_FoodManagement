# java
This is a Food Mangement
Program Specifications
You are required to develop a Java program that shows the following menu:
Welcome to Food Management - @ 2021 by <Student ID - Student Name >
Select the options below:
1. Add a new food
2. Search a food by name
3. Remove the food by ID
4. Print the food list in the descending order of expired date
5. Quit
Each menu choice should invoke an appropriate function to perform the selected menu item. Your program must display
the menu after each task and wait for the user to select another option until the user chooses to quit the program. Each
food has the following information: ID (cannot be modified, cannot be duplicated), name, weight, type, place (where your
put this food in refrigerator), expired date. Use collection to food the phones.
Function details
 
  Function 1: Show menu – 50 LOC
The program displays a menu and asks users to input an option from 1 to 5.
  
 Function 2: Build the data structure – 50 LOC
o Classes, abstract classes, interfaces.
o Use only one collection to store food.
  
 Function 3: Add a food to the list – 50 LOC
o User inputs new food’s information
o Remember to check the id cannot be duplicated. Other information must be validating.
o Add the new a food to the collection.
o After adding, the program asks whether you want to continue adding another food or return to the menu.
 
  Function 4: Search a phone by name – 50 LOC
o User inputs the key word want to search. The program returns all food that has name contain the search
string.
o If the food is not existed, the screen shows message “This food does not exist”. Otherwise, the screen shows
the foods information.
o After searching, the program asks if the user wants to continue searching for another food or return to the
menu.
 
  Function 5: Remove the food by ID – 100 LOC
o User can remove any food in the refrigerator by ID.
o Before the remove, the program must show confirm message.o Show the result of the remove: success or fail.
o After removing, the program returns to the menu.
 
  Function 6: Print the food – 50 LOC
o The program will print the food list in the descending order of expired date.
o After printing, the program returns to the menu.
 
  Function 7: Store the food list to binary file – 50 LOC
o The user enters the file name (<<file_name>>.dat) you want to save.
o The program will save all information of the phone in the store to the file.
o After save, the program returns to the menu.
