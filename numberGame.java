import java.util.Scanner;
import java.util.Random;

class Game {
    int randomNo;
    int guessedNo;
    int noOfGuesses;
    int maxAttempts = 5;
    Scanner sc = new Scanner(System.in);
    public Game() {
        Random random = new Random();
        randomNo = random.nextInt(100) + 1;
        noOfGuesses = 0;
    }
    public void guessNo() {
        System.out.print("Enter a number: ");
        guessedNo = sc.nextInt();
        noOfGuesses++;
    }
    public boolean checkNo() {
        if (guessedNo == randomNo) {
            System.out.printf("You guessed it right in %d attempt(s)! The number was %d\n", noOfGuesses, randomNo);
            return true;
        } else if (guessedNo > randomNo) {
            System.out.printf("Too High\n");
        } else{
            System.out.printf("Too Low\n");
        }
        if (noOfGuesses >= maxAttempts) {
            System.out.printf("Maximum attempts reached! The correct number was: %d\n",randomNo);
            return true; // Game over due to attempts
        }
        return false;
    }
}

public class numberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playAgain = true;
        int score = 0;
        int rounds = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have 5 attempts to guess the number (1 to 100).");
        while (playAgain) {
            Game g = new Game();
            boolean isOver = false;
            while (!isOver) {
                g.guessNo();
                isOver = g.checkNo();
            }
            if (g.guessedNo == g.randomNo && g.noOfGuesses <= g.maxAttempts) {
                score++;
            }
            rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = input.next().toLowerCase();
            playAgain = response.equals("yes");
        }
        System.out.println("Game Summary:");
        System.out.println("Rounds Played: " + rounds);
        System.out.println("Rounds Won: " + score);
        System.out.println("Thanks for playing!");
        input.close();
    }
}
