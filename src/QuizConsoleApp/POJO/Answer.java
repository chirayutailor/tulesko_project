package QuizConsoleApp.POJO;

public class Answer {
    private String answer;
    private boolean isTrueAnswer = false;

    public Answer(String answer, boolean isTrueAnswer) {
        this.answer = answer;
        this.isTrueAnswer = isTrueAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrueAnswer() {
        return isTrueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        isTrueAnswer = trueAnswer;
    }
}
