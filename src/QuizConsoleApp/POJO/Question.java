package QuizConsoleApp.POJO;

public class Question {
    private String question;
    private Answer[] answers;

    public Question(String question, Answer[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void printQuestionWithOptions() {
        System.out.println( question );
        printOptions();
    }

    public void printOptions() {
        int index = 0;

        System.out.println( "Options:");
        for ( Answer answer: answers ) {
            System.out.println( ( index + 1 ) + ". " + answer.getAnswer() );
        }
    }
}
