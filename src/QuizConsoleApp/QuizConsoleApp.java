package QuizConsoleApp;

import QuizConsoleApp.POJO.Quiz;
import QuizConsoleApp.ServiceLayer.QuizServiceLayer;

import java.util.Scanner;

public class QuizConsoleApp {
    public static void main(String[] args) {
        QuizServiceLayer quizServiceLayer = new QuizServiceLayer();
        quizServiceLayer.displayMenu();
    }

}
