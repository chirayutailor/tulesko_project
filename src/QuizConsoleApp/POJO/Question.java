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
        System.out.println( "Question: " + question );
        printOptions();
    }

    public void printOptions() {
        int index = 1;

        System.out.println( "Options:");
        for ( Answer answer: answers ) {
            System.out.println( index++ + ". " + answer.getAnswer() );
        }
        System.out.println( index + ". Skip the question" );
    }

    public Answer getAnswer( int index ) {
        return answers[index];
    }

    public int getAnswerSize() {
        return answers.length;
    }
}
