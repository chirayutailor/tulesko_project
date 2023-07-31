package QuizConsoleApp.ServiceLayer;

import QuizConsoleApp.POJO.Participant;
import QuizConsoleApp.POJO.Quiz;

import java.util.Scanner;

public class QuizServiceLayer {
    private Scanner scanner;
    private Quiz[] quizzes;
    private Participant[] participants;

    public QuizServiceLayer() {
        scanner = new Scanner( System.in );
    }

    public void displayMenu() {
        System.out.println("""
                Please select one of the below options:
                1. Create a Quiz
                2. Modify a Quiz
                3. Delete a Quiz
                4. Start a Quiz
                5. Exit the program
                
                """);

        System.out.print( "Please provide your input : " );
        var optionSelected = scanner.nextInt();
        processUserInput( optionSelected );
    }

    private void processUserInput( int optionProvided ) {

        switch( optionProvided ) {
            case 1:
                createQuiz();
                System.out.println( "" );
                displayMenu();
                break;

            case 2:
                modifyQuiz();
                System.out.println( "" );
                displayMenu();
                break;

            case 3:
                deleteQuiz();
                System.out.println( "" );
                displayMenu();
                break;

            case 4:
                startQuiz();
                System.out.println( "" );
                displayMenu();
                break;

            case 5:
                System.out.println( "Exiting the program. Thank you for using our application");
                return;

            default:
                System.out.println( "\n!!! Provided wrong input. Please select from mentioned options only.\n" );
                displayMenu();
        }
    }

    private void createQuiz() {

    }

    private void modifyQuiz() {

    }

    private void deleteQuiz() {

    }

    private void startQuiz() {

    }

}
