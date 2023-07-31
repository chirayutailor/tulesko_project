package QuizConsoleApp.POJO;

public class Participant {
    private String name;
    private short score;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public short getScore() {
        return score;
    }

    public void updateScore( boolean correctAnswer ) {
        if (correctAnswer) {
            ++score;
        } else {
            if (0 < score) {
                --score;
            }
        }
    }
}
