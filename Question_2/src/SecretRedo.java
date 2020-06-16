/*
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Module 3 Question 2
 * 
 * 
 * Application Requirements:
 * Write a program that asks a user to guess a secret number between 1 and N, where N is 
 * a positive number that the user is prompted for. The program should also prompt the user
 * for the maximum number of guesses they would like to make. Each time the player makes a 
 * guess, the program shall respond with “correct”, “too low”, or “too high”. The program 
 * should keep track of the number of guesses the user made to discover the secret number. 
 * The program should continue execution until the user has discovered the secret number or
 * has exceeded the maximum number of guesses. The program shall also allow the user to play
 * the game again until the user declines. The program should generate the magic number randomly,
 * using the built-in Java method Math.random().
*/

import java.util.Scanner;

public class SecretRedo {

	/*
     * Here is the main block of my code. Use the Office Hours as a basis to redo Question 2.
     * 1. I will initialize all of my variables 
     * 2. I will ask the user to guess a number and I will save it to a variable
     * 3. conduct error handling 
     * 4. I will ask the user for the maximum number of guesses they want and save it to a variable.
     * 5. conduct error handling
     * 6. I need to randomize a number and save it to a variable using: 
     * 	  randomNumber = (int) ( N * Math.random() ) + 1;
     * 7. i will have a do while for them being equal or not equal (default)
     * 8. i will use an if-else if for when the number is guesses right, or if the guess is to high or low.
     * 
     * Assumptions:
     * 1. Generally the user will not guess the right number on the first guess -> use do-while and set
     *    isEqual to false
     * 2. Generally the user wants to play the game so set quit to false, unless they select to quit -> use switch case
     *    to play or not to play, default for error catching.
     * 3. When guesses = 0 game should quit
     */
	
	public static void main(String[] args) {
		
		int userNum, randNum, guesses, userGuess, secondChoice = 0, choice = 0;
		boolean quit = false;
		
		do {
			
			
			HeaderMessage();
			System.out.println("\nWould you like to play guess the secret number? Choice (0) for yes, (1) for no.\n");
			
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			
			if ((choice == 0) || (choice < 0) || (choice > 1)){
				quit = true;
			} else {
				System.out.println("\nEnter the your number: \n");
				userNum = input.nextInt();
				
				randNum =  (int) ( userNum * Math.random() ) + 1;
				
				System.out.println("\nEnter how many quesses you'd like: \n");
				guesses = input.nextInt();
				
			
				do {
					System.out.println("\nEnter your guess: \n");
					userGuess = input.nextInt();
					guesses--;
				
					if(userGuess == randNum) {
						guesses = 0;
						System.out.println("\nCorrect! Your are super lucky! The secret number was " + randNum + " and you guessed " + userGuess +  "\nYou have " + guesses + " guesses left.\n");
						
					} else if (userGuess > randNum) {
						guesses--;
						
						System.out.println("\nYou've guessed too high! Guess again...\n");
						userGuess = input.nextInt();
						
					} else if (userGuess < randNum) {
						guesses--;
						System.out.println("\nYou've guessed too low! Guess again...\n");
						userGuess = input.nextInt();
					}
				
				} while ((guesses != 0) && (userNum != randNum) && (choice != 0));
			}
		}  while (secondChoice != 0);
	}	
			
	private static void HeaderMessage() {
		System.out.println("\n");
		System.out.println("+------------------------------------------------------------+");
		System.out.println("|                     Hello User!                            |");
		System.out.println("|   Please start by entering a number you'd like to guess.   |");
		System.out.println("|    Next enter the maximum number of guesses you'd like.    |");
		System.out.println("| If you'd like to quit the game enter 0 when prompted to do |");
		System.out.println("| so. If you'd like to play again enter 1. The game will     |");
		System.out.println("|    automatically quit when you have run out of guesses.    |");
		System.out.println("|                    Let's start!                            |");
		System.out.println("+------------------------------------------------------------+");
		System.out.println("\n");
	}
}

