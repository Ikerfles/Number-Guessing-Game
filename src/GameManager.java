import java.util.Random;
import java.util.Scanner;

public class DifficultyManager {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private int randomNumber;
    String welcomeMessage = """
            Welcome to the Number Guessing Game!
            I'm thinking of a number between 1 and 100.
            You have certain chances to guess the correct number.
            """;

    String difficultyMenu = """
            Choose a difficulty level:
            1. Easy
            2. Medium
            3. Hard
            Enter your choice:
            """;

    public void difficultyManager() {
        System.out.println(welcomeMessage);
        while (true){
            System.out.println(difficultyMenu);
            int difficulty = scanner.nextInt();
            switch (difficulty){
                case 1:
                    System.out.println("Difficulty set to easy.");
                    this.randomNumber = random.nextInt(1,101);
                    System.out.println("Guess a number between 1 and 100 in 10 attempts.");
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Attempt " + (i + 1) + ": ");
                        int guess = scanner.nextInt();
                        if (guess == randomNumber) {
                            System.out.println("Congratulations! You guessed the correct number.");
                            return;
                        } else if (guess < randomNumber) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Difficulty set to medium.");
                    this.randomNumber = random.nextInt(1,101);
                    System.out.println("Guess a number between 1 and 100 in 5 attempts.");

                    for (int i = 1; i <= 5; i++) {
                        System.out.print("Attempt " + (i) + ": ");
                        int guess = scanner.nextInt();

                        if (guess == randomNumber) {
                            System.out.println("Congratulations! You guessed the correct number.");
                            playAgain();
                            return;
                        }

                        if (i == 5){
                            System.out.println("Sorry, you ran out of attempts. The correct number was " + randomNumber + ".");
                        } else if (guess < randomNumber) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }
                    playAgain();
                    break;
                case 3:
                    System.out.println("Difficulty set to hard.");
                    this.randomNumber = random.nextInt(1,101);
                    System.out.println("Guess a number between 1 and 100 in 3 attempts.");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Attempt " + (i + 1) + ": ");
                        int guess = scanner.nextInt();
                        if (guess == randomNumber) {
                            System.out.println("Congratulations! You guessed the correct number.");
                            return;
                        } else if (guess < randomNumber) {
                            System.out.println("Too low! Try again.");
                        } else {
                            System.out.println("Too high! Try again.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid difficulty level. Please enter a valid number (1-3):");
            }
        }
    }

    public void playAgain() {
        System.out.println("You would like to continue?");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            difficultyManager();
        }
        else if (playAgain.equalsIgnoreCase("no")) {
            System.out.println("Goodbye!");
            scanner.close();
        }
    }
}
