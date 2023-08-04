package QuizConsoleApp.ServiceLayer;

import QuizConsoleApp.POJO.Participant;
import QuizConsoleApp.POJO.Quiz;
import QuizConsoleApp.Questionaire;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class QuizServiceLayer {
    private Scanner scanner;
    private Quiz[] quizzes;
//    private Participant[] participants;

    public QuizServiceLayer() {
        scanner = new Scanner( System.in );
    }

    public void displayMenu() {
        System.out.println("""
                *************************************************************************
                                                  MENU
                *************************************************************************
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
        var quizSize = getQuizSize();
        quizzes = new Quiz[quizSize];
        prepareEachQuiz();
    }

    private void modifyQuiz() {
        System.out.println( "Sorry, functionality pending to be implemented. Please try later on.");
    }

    private void deleteQuiz() {
        System.out.println( "Sorry, functionality pending to be implemented. Please try later on.");
    }

    private void startQuiz() {
        listQuizzes();
        int quizId;

        do {
            System.out.print( "Please select the quiz: ");
            quizId = scanner.nextInt();
        } while( quizId <= 0 );

        ParticipantServiceLayer participantServiceLayer = new ParticipantServiceLayer( quizzes[(quizId - 1)].getQuestionId(), scanner );
        participantServiceLayer.startQuiz();
    }

    private int getQuizSize() {
        System.out.print( "Please mention the number of quiz you wish you create: ");
        var quizSize = scanner.nextInt();

        if( quizSize < 1 ) {
            System.out.println( "Please mention a value greater than 0" );
            getQuizSize();
        }

        // Code to check non-numeric value missing
        return quizSize;
    }

    private void prepareEachQuiz() {
        var quizSize = quizzes.length;

        for( int index = 0; index < quizSize; index++ ) {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("           Quiz #" + ( index + 1 ) );
            System.out.println("-------------------------------------------------------------------------" );

            var quizTitle = getQuizTitle();
            scanner.next();
            var questionaireSize = getQuestionaireSize();

            Questionaire.displayQuestions();
            System.out.println( "" );
            int[] questionIds = getQuestionList( questionaireSize );

            quizzes[index] = new Quiz( questionaireSize, quizTitle, questionIds );

        }
    }

    private @NotNull String getQuizTitle() {

        // TODO : Facing issue when providing string of multiple words. Accepting only the first word

        System.out.print( "Please provide the Quiz Title: " );
        var quizTitle = scanner.next();

        if( quizTitle.strip().length() == 0 ) {
            System.out.println( "Please provide a valid title" );
            getQuizTitle();
        }

        return quizTitle;
    }

    private int getQuestionaireSize() {
        System.out.print( "Please mention the number of questions you wish to ask: ");
        var questionaireSize = scanner.nextInt();

        /*
         * Validations:
         * 1. Size of question array cannot be less than 1
         * 2. Size of question array cannot be greater than total number of questions. This is because we do not allow question duplication within quiz
         */
        if( questionaireSize < 1 ) {
            System.out.println( "Please mention a value greater than 0" );
            getQuestionaireSize();
        } else if( questionaireSize > Questionaire.getQuestionsSize() ) {
            System.out.println( "Maximum questions allowed to be asked cannot be more than " + Questionaire.getQuestionsSize() );
            getQuestionaireSize();
        }

        // Code to check non-numeric value missing
        return questionaireSize;
    }

    private @NotNull int[] getQuestionList( int numberOfQuestions ) {

        System.out.println( "Please select " + numberOfQuestions + " questions for above. Please separate the question number by ',' ( For example: 1,2,3 )" );

        // TODO : Facing issue when providing space between comma "," and the number
        String questionList = scanner.next();
        String[] questionStringIds = questionList.split(",");

        if( questionStringIds.length != numberOfQuestions ) {
            System.out.println( "Please select exactly " + numberOfQuestions + " of questions only" );
        }

        int[] questionIds = new int[numberOfQuestions];
        for( int index = 0; index < numberOfQuestions; index++ ) {
            int qId = Integer.parseInt( questionStringIds[index].strip() );

            // -1 is added since our questions array begins from index 0. But our display list starts from 1.
            // Thus, if a user wants to select 1st question, he/she will enter 1 but for program it should be 0.
            questionIds[index] = ( qId - 1 );
        }

        var questionIdsClone = questionIds.clone();
        Arrays.sort(questionIdsClone);

        var duplicateQuestionExists = false;
        for( int index = 0; index < ( numberOfQuestions - 2 ); index++ ) {
            if( questionIdsClone[index] == questionIdsClone[index + 1] ) {
                System.out.println( "You have selected question " + questionIdsClone[index] + " more than once. Please ensure unique questions" );
                duplicateQuestionExists = true;
                break;

            } else if( questionIdsClone[index] < 0 || questionIdsClone[index + 1] < 0 ) {
                System.out.println( "You have provided invalid question list. Please try once again." );
                duplicateQuestionExists = true;
                break;
            }
        }

        if( duplicateQuestionExists ) {
            getQuestionList( numberOfQuestions );
        }

        return questionIds;
    }

    private void listQuizzes() {
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();

        if( quizzes == null || quizzes.length == 0 ) {
            System.out.println( "No quiz has been created yet. Returning back to Menu\n\n");
            displayMenu();
        }

        for( Quiz quiz : quizzes ) {
            if( quiz == null ) {
                continue;
            }

            stringBuilder.append( "\n" + ++counter + ". " + quiz.getTitle() );
        }

        if( stringBuilder.length() == 0 ) {
            System.out.println( "No quiz entry found. Returning back to Menu\n\n");
            displayMenu();
        }

        System.out.println( "List of quiz is as follows:" + stringBuilder );
    }
}
