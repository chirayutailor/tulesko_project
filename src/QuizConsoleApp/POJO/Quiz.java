package QuizConsoleApp.POJO;

public class Quiz {
    private int questionaireSize;
    private String title;
    private int[] questionId;

    public Quiz(int questionaireSize, String title, int[] questionId) {
        this.questionaireSize = questionaireSize;
        this.title = title;
        this.questionId = questionId;
    }

    public int getQuestionaireSize() {
        return questionaireSize;
    }

    public String getTitle() {
        return title;
    }

    public int[] getQuestionId() {
        return questionId;
    }

}
