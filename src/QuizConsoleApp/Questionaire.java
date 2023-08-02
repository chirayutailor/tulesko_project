package QuizConsoleApp;

import QuizConsoleApp.POJO.Answer;
import QuizConsoleApp.POJO.Question;

public class Questionaire {
    static Question[] questions = new Question[20];

    static {
        System.out.println( "" );
        System.out.println( "" );
        Answer[] answers = new Answer[4];
        answers[0] = new Answer("JRE", false);
        answers[1] = new Answer("JIT", false);
        answers[2] = new Answer("JDK", true);
        answers[3] = new Answer("JVM", false);
        questions[0] = new Question( "Which component is used to compile, debug and execute the java programs?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("identifier & keyword", false);
        answers[1] = new Answer("identifier", false);
        answers[2] = new Answer("keyword", true);
        answers[3] = new Answer("none of the mentioned", false );
        questions[1] = new Question( "Which of these cannot be used for a variable name in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer(".js", false);
        answers[1] = new Answer(".txt", false);
        answers[2] = new Answer(".class", false );
        answers[3] = new Answer(".java", true );
        questions[2] = new Question( "What is the extension of java code files?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Polymorphism", false);
        answers[1] = new Answer("Inheritance", false);
        answers[2] = new Answer("Compilation", true );
        answers[3] = new Answer("Encapsulation", false );
        questions[3] = new Question( "Which of the following is not an OOPS concept in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Referring to the instance variable when a local variable has the same name", false);
        answers[1] = new Answer("Passing itself to the method of the same class", true);
        answers[2] = new Answer("Passing itself to another method", false );
        answers[3] = new Answer("Calling another constructor in constructor chaining", false );
        questions[4] = new Question( "What is not the use of “this” keyword in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer(".js", false);
        answers[1] = new Answer(".txt", false);
        answers[2] = new Answer(".class", true );
        answers[3] = new Answer(".java", false );
        questions[5] = new Question( "What is the extension of compiled java classes?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("if()", true);
        answers[1] = new Answer("for()", false);
        answers[2] = new Answer("continue", false );
        answers[3] = new Answer("break", false );
        questions[6] = new Question( "Which of these are selection statements in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Interface", false);
        answers[1] = new Answer("interface", true);
        answers[2] = new Answer("Intf", false );
        answers[3] = new Answer("intf", false );
        questions[7] = new Question( "Which of these keywords is used to define interfaces in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("ArrayList", false);
        answers[1] = new Answer("Object class", true);
        answers[2] = new Answer("Abstract class", false );
        answers[3] = new Answer("String", false );
        questions[8] = new Question( "Which of the following is a superclass of every class in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Protected", false);
        answers[1] = new Answer("Void", true);
        answers[2] = new Answer("Public", false );
        answers[3] = new Answer("Private", false );
        questions[9] = new Question( "Which one of the following is not an access modifier?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("0 to 32767", false);
        answers[1] = new Answer("0 to 65535", false);
        answers[2] = new Answer("0 to 256", false );
        answers[3] = new Answer("-128 to 127", true );
        questions[10] = new Question( "What is the numerical range of a char data type in Java?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("super", false);
        answers[1] = new Answer("this", false);
        answers[2] = new Answer("extend", false );
        answers[3] = new Answer("extends", true );
        questions[11] = new Question( "Which of this keyword must be used to inherit a class?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("abst", false);
        answers[1] = new Answer("abstract", true);
        answers[2] = new Answer("Abstract", false );
        answers[3] = new Answer("abstract class", false );
        questions[12] = new Question( "Which of these keywords are used to define an abstract class?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Abstract", true);
        answers[1] = new Answer("A simple class", false);
        answers[2] = new Answer("Static class", false );
        answers[3] = new Answer("None of the mentioned", false );
        questions[13] = new Question( "If a class inheriting an abstract class does not define all of its function then it will be known as?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("Every class containing abstract method must be declared abstract", false );
        answers[1] = new Answer("Abstract class defines only the structure of the class not its implementation", false);
        answers[2] = new Answer("Abstract class can be initiated by new operator", true );
        answers[3] = new Answer("Abstract class can be inherited", false );
        questions[14] = new Question( "Which of these is not a correct statement?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("0", false );
        answers[1] = new Answer("Not a Number", false);
        answers[2] = new Answer("Infinity", true );
        answers[3] = new Answer("Run time exception", false );
        questions[15] = new Question( "What does the expression float a = 35 / 0 return?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("for ( int i = 99; i >= 0; i / 9 )", true );
        answers[1] = new Answer("for ( int i = 7; i <= 77; i += 7 )", false);
        answers[2] = new Answer("for ( int i = 20; i >= 2; - -i )", false );
        answers[3] = new Answer("for ( int i = 2; i <= 20; i = 2* i )", false );
        questions[16] = new Question( "Which of the following for loop declaration is not valid?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("getClass()", false );
        answers[1] = new Answer("intern()", false);
        answers[2] = new Answer("getName()", true );
        answers[3] = new Answer("toString()", false );
        questions[17] = new Question( "Which method of the Class.class is used to determine the name of a class represented by the class object as a String?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("It has only methods", false );
        answers[1] = new Answer("Objects can't be created", false);
        answers[2] = new Answer("It has a fixed class name", false );
        answers[3] = new Answer("It has no class name", true );
        questions[18] = new Question( "Which of the following is true about the anonymous inner class?", answers );

        answers = new Answer[4];
        answers[0] = new Answer("A final method cannot be overridden in its subclasses.", false );
        answers[1] = new Answer("A final class cannot be extended.", false);
        answers[2] = new Answer("A final class cannot extend other classes.", true );
        answers[3] = new Answer("A final method can be inherited.", false );
        questions[19] = new Question( "Which option is false about the final keyword?", answers );
    }

    public static void displayQuestions() {
        var counter = 1;
        for ( Question question : questions ) {
            System.out.println( counter++ + ". " + question.getQuestion() );
        }
    }

    public static int getQuestionsSize() {
        return questions.length;
    }

    public static Question getQuestion( int questionId ) {
        return questions[questionId];
    }
}
