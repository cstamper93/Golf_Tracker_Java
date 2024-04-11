import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GolfTracker {

    /*
    Flow:
    > Intro
    > Ask user to input one score at a time, followed by par for the course
    > Prompt user to enter more scores or quit
    > When they do quit, perform operations on input and return scoring average and handicap
     */

    /*
    Competencies Demonstrated:
    > Knowledge and application of variables, data types, and collections
    > Handling exceptions
    > Application of conditionals and loops
    > Casting data types into other types
    > How to concatenate strings
    > User input
     */

    public static void main(String[] args) {

        System.out.println("\n<<<<<***** Golf Tracker *****>>>>>\n");
        System.out.println("Welcome to Golf Tracker! Just enter your scores, followed by " +
                "par for the course. \nYou will continue to be prompted to add more scores, " +
                "or to quit. Your scoring average and handicap will be calculated when you " +
                "finish. \nHappy scoring!");

        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> scoreToParList = new ArrayList<>();

        int score = 0;

        boolean run = true;
        while(run) {
            Scanner scanner = new Scanner(System.in);
            boolean completedScoreInput = false;
            while (!completedScoreInput) {
                try {
                    System.out.println("Please enter your total score: ");
                    score = Integer.parseInt(scanner.nextLine());
                    scores.add(score);
                    completedScoreInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                }
            }
            boolean completedParInput = false;
            while(!completedParInput) {
                try {
                    System.out.println("What was par for the course?: ");
                    int par = Integer.parseInt(scanner.nextLine());
                    int scoreToPar = score - par;
                    scoreToParList.add(scoreToPar);
                    completedParInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                }
            }
            boolean continueAdding = true;
            while (continueAdding) {
                System.out.println("Would you like to enter another score? (Y/N): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    continueAdding = false;
                    run = false;
                } else if (!choice.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid input. Please enter the letter Y for yes or N for no.");
                } else {
                    continueAdding = false;
                }
            }
        }

        int scoresSum = 0;
        for (int i = 0; i < scores.size(); i++) {
            scoresSum += scores.get(i);
        }
        int scoringAvg = scoresSum / scores.size();

        int scoresToParSum = 0;
        for (int i = 0; i < scoreToParList.size(); i++) {
            scoresToParSum += scoreToParList.get(i);
        }
        int handicap = scoresToParSum / scoreToParList.size();

        System.out.println("\n*************************");
        System.out.println("Scoring Average: " + scoringAvg);
        if (handicap >= 0) {
            System.out.println("Handicap: " + handicap);
        } else {
            System.out.println("Handicap: +" + Math.abs(handicap));
        }
        System.out.println("*************************");

    }
}
