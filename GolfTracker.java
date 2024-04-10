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

    public static void main(String[] args) {

        System.out.println("\n<<<<<***** Golf Tracker *****>>>>>\n");
        System.out.println("Welcome to Golf Tracker! Just enter your scores, followed by " +
                "par for the course. \nYou will continue to be prompted to add more scores, " +
                "or to quit. Your scoring average and handicap will be calculated when you " +
                "finish. \nHappy scoring!");

        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<Integer> parList = new ArrayList<>();

        boolean run = true;
        while(run) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your total score: ");
            int score = Integer.parseInt(scanner.nextLine());
            scores.add(score);
            System.out.println("What was par for the course?: ");
            int par = Integer.parseInt(scanner.nextLine());
            parList.add(par);
            System.out.println("Would you like to enter another score? (Y/N): ");
            String choice = scanner.nextLine();
            if(choice.toUpperCase().equals("N")) {
                run = false;
            }
        }

        System.out.println(scores);
        System.out.println(parList);

    }
}
