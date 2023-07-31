package QuizConsoleApp.POJO;

public class Quiz {
    private int questionaireSize;
    private String title;
    private int[] questionaire;

    public Quiz(int questionaireSize, String title) {
        this.questionaireSize = questionaireSize;
        this.title = title;
    }

    public int getQuestionaireSize() {
        return questionaireSize;
    }

    public String getTitle() {
        return title;
    }

    public int[] getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(int[] questionaire) {
        this.questionaire = questionaire;
    }
}
