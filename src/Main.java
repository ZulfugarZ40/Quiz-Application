import quizapp.Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    int correctAnsCount = 0;
    int wrongAnsCount = 0;
    public static void main(String[] args) {

        Main quiz = new Main();
    quiz.logic();
    }
    public void logic() {
        Questions q1 = new Questions("Which statement is true about Java?",
                "a) Java is a sequence-dependent programming language.",
                "b) Java is a code dependent programming language.",
                "c) Java is a platform-dependent programming language.",
                "d) Java is a platform-independent programming language.");
        Questions q2 = new Questions("Which of the following is not a java primitive type?",
                "a) Byte", "b) Float", "c) Character", "d) Long double");
        Questions q3 = new Questions("What would happen if 'String[] args' is not included as an argument" +
                " in the main method?", "a) No error", "b) Compilation error", "c) The program won't run",
                "d) Program exit");
        Questions q4 = new Questions("In java variables, if first increment of the variable takes place and then " +
                "\nthe assignment occurs, this operation is also called...", "a) pre-increment",
                "b) post-increment", "c) incrementation", "d) pre incrementation");

        Map<Questions, Character> hashmap = new HashMap<>();
        hashmap.put(q1, 'd');
        hashmap.put(q2, 'd');
        hashmap.put(q3, 'c');
        hashmap.put(q4, 'a');
        for (Map.Entry<Questions, Character> map : hashmap.entrySet()) {
            System.out.println(map.getKey().getQuestion());
            System.out.println(map.getKey().getOption1());
            System.out.println(map.getKey().getOption2());
            System.out.println(map.getKey().getOption3());
            System.out.println(map.getKey().getOption4());

            System.out.print("Enter your answer: ");
            Character answer = scan.next().charAt(0);
            int correctAns = Character.compare(answer, map.getValue());
            if (correctAns == 0) {
                System.out.println("Correct");
                correctAnsCount++;
            } else {
                System.out.println("Wrong");
                wrongAnsCount++;
            }
        }
        System.out.println("-------Result-------");
        System.out.println("Total questions: " + hashmap.size());
        System.out.println(correctAnsCount + " correct answer(s)\n" +
                wrongAnsCount + " wrong answer(s)");
        int percentage = 100 * correctAnsCount / hashmap.size();
        System.out.println("Percentage: " + percentage);
        if (percentage > 90) {
            System.out.println("Very good");
        } else if (percentage < 50) {
            System.out.println("Very weak");
        } else {
            System.out.println("Normal");
        }
    }
    }