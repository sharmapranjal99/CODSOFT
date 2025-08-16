# Number Guessing Game in Java

This repository contains a simple Number Guessing Game built using Java. It was created as part of my internship at CodSoft and serves as a beginner-level project to strengthen core Java programming concepts.

## 1. Project Overview

The game allows a user to guess a randomly generated number within a specified range. After each guess, the program provides hints to help the user arrive at the correct number. Once guessed correctly, it displays the total number of attempts made.

## 2. Features

1. Random number generation using Java's `Random` class.
2. User input handling through the `Scanner` class.
3. Conditional feedback — whether the guessed number is too high or too low.
4. Looping mechanism to allow repeated attempts.
5. Displays the number of guesses taken once the correct number is entered.

## 3. How the Game Works

1. The program generates a random number between 1 and 100.
2. The user is prompted to enter a guess.
3. Based on the guess, the program provides feedback:
   - If the guess is lower than the target number, it asks the user to guess higher.
   - If the guess is higher, it asks to guess lower.
4. This continues until the correct number is guessed.
5. Once correct, the game ends by showing the total number of attempts.

## 4. Technologies Used

- Java Development Kit (JDK)
- Scanner and Random classes from Java standard library
- IntelliJ IDEA or any Java IDE (optional)

## 5. How to Run

Run in an IDE

1. Download or clone the repository.


2. Open the project in any Java IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans, or VS Code with Java extension).


3. Locate the file containing the main method (e.g., atmInterface.java).


4. Run the program from the IDE.
