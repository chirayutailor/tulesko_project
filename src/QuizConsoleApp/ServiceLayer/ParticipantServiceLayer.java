package QuizConsoleApp.ServiceLayer;

import QuizConsoleApp.POJO.Participant;
import QuizConsoleApp.POJO.Question;
import QuizConsoleApp.POJO.Quiz;
import QuizConsoleApp.Questionaire;

import java.util.Scanner;

public class ParticipantServiceLayer {

    private int[] questionIds;
    private Scanner scanner;
    private Participant[] participants;

    public ParticipantServiceLayer(int[] questionIds, Scanner scanner) {
        this.questionIds = questionIds;
        this.scanner = scanner;
    }

    public void startQuiz() {
        System.out.print( "Please mention the number of participants you wish to include: ");
        int participantCount = getParticipantCount();

        participants = new Participant[participantCount];
        for( int counter = 0; counter < participantCount; counter++ ) {
            participants[counter] = new Participant( "Participant #" + ( counter + 1) );
        }

        for( Participant participant : participants ) {
            playQuizForParticipant( participant );
        }

        System.out.println( "" );
        displayFinalTally();
    }

    private int getParticipantCount() {
        int participantCount;
        do {
            participantCount = scanner.nextInt();

            if (participantCount < 1) {
                System.out.println("Please provide a numeric value greater than 0");
                startQuiz();

            } else if (participantCount > 4) {
                System.out.println("Presently we allow max 4 participants per quiz");
                startQuiz();
            }
        } while( participantCount <= 0 );

        return participantCount;
    }

    private void playQuizForParticipant( Participant participant ) {
        System.out.println( "................................................." );
        System.out.println( "Lets begin quiz for participant " + participant.getName() );
        System.out.println( "................................................." );

        for ( var questionId :  questionIds) {
            Question question = Questionaire.getQuestion(questionId);

            question.printQuestionWithOptions();
            System.out.print( "\nAnswer: " );
            var answer = scanner.nextInt();

            validateAnswer( answer, question, participant );
        }
    }

    private void validateAnswer( int participantAnswer, Question question, Participant participant ) {
        var numberOfOptionsAvailable = question.getAnswerSize();

        // Say if there are 2 options defined for a question, then user will be provided 3 options
        // First 2 options will be related to the available options and third will be related to skip the question.
        // If user provides any option other than 1,2 or 3 then obviously its incorrect

        if( participantAnswer < 1 || participantAnswer > ( numberOfOptionsAvailable + 1 ) ) {
            participant.updateScore( false );
            System.out.println( "!!! Wrong answer provided" );
            displayScore( participant );

        } else if( participantAnswer == ( numberOfOptionsAvailable + 1 ) ) {
            System.out.println( "Question skipped" );

        } else {
            boolean isAnswerCorrect = ( question.getAnswer( ( participantAnswer - 1 ) ) ).isTrueAnswer();
            participant.updateScore( isAnswerCorrect );
            System.out.println( ( ( isAnswerCorrect ) ? "Correct" : "!!! Wrong" ) + " answer provided" );
            displayScore( participant );
        }

        System.out.println( "" );
    }

    private void displayScore( Participant participant ) {
        System.out.println( "Updated score: " + participant.getScore() );
    }

    private void displayFinalTally() {
        System.out.println( "-----------------------------------------------------");
        System.out.println( "Final score is has follows: " );
        System.out.println( "-----------------------------------------------------");
        int counter = 1;
        for( var participant : participants ) {
            System.out.println( counter++ + ". " + participant.getName() + "\t\t( Score : " + participant.getScore() + " )" );
        }
    }

}
