import javax.swing.*;
import java.util.Random;

public class QuizGame {

   static double userAnswer, correctAnswer;
  static  String displayProblem = "";

  JPanel panel;
  JButton createProblem, checkAnswer;
  JLabel showProblem, resultLabel;
  JTextField answerInput;
  JRadioButton addition, subtraction, multiplication, division;
  ButtonGroup ratios = new ButtonGroup();

    public static void main(String[] args) {

        new QuizGame();
        int choice = Integer.parseInt(JOptionPane.showInputDialog("choose Addition(1), Subtraction(2), Multiplication(3), Division(4)"));

        createProblem(choice);
        getUserAnswer();
        checkAnswer();


    }
    public QuizGame(){
        JFrame frame = new JFrame("Quiz Game");
        frame.setSize(300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        panel = new JPanel();

        addition = new JRadioButton("Addition");
        subtraction = new JRadioButton("Subtraction");
        multiplication = new JRadioButton("Multiplication");
        division = new JRadioButton("Division");

        createProblem = new JButton("Make a problem");
        showProblem = new JLabel("PLACE HOLDER");
        answerInput = new JTextField(10);
        checkAnswer = new JButton("Check Answer");
        resultLabel = new JLabel("ANSWER RESULTS");




        addition.setBounds(100, 25, 100, 25);
        subtraction.setBounds(100, 50, 100, 25);
        multiplication.setBounds(100, 75, 100, 25);
        division.setBounds(100, 100, 100, 25);

        ratios.add(addition);
        ratios.add(subtraction);
        ratios.add(multiplication);
        ratios.add(division);

        panel.setLayout(null);
        panel.add(addition);
        panel.add(subtraction);
        panel.add(multiplication);
        panel.add(division);


        frame.add(panel);
        frame.setVisible(true);




    }
    public static void checkAnswer() {
        if (userAnswer == correctAnswer) {
            JOptionPane.showMessageDialog(null, "Your are correct");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect, please try again");
        }
    }
    public static void getUserAnswer(){
        userAnswer = input(displayProblem);
    }

    public static void createProblem(int choice){


            if (choice >= 1) {
                if (choice < 5) {
                    if (choice == 1) {
                        addProblem();
                    }
                    if (choice == 2) {
                        subProblem();
                    }
                    if (choice == 3) {
                        multiProblem();
                    }
                    if (choice == 4) {
                        divProblem();
                    }
                }else {
                        System.out.println("Wrong input, restart program, try again");
                        System.exit(0);
                    }


            }
        }


    public static void addProblem(){

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 + number2;
        displayProblem = number1 + " +" + number2;


    }

    public static void subProblem() {

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 - number2;
        displayProblem = number1 + " - " + number2;
    }
    public static void multiProblem() {

        int number1 = random();
        int number2 = random();

        correctAnswer = number1 * number2;
        displayProblem = number1 + " X " + number2;
    }
    public static void divProblem() {

        int number1 = random();
        int number2 = random();

        correctAnswer = (number1/number2);

        correctAnswer = Math.round(correctAnswer * 100.00)/100.00;

        displayProblem = number1 + " / " + number2;
    }

        //HELPER METHODS
    public static int random(){
        Random random = new Random();

        return random.nextInt(20)+1;

    }

    public static double input(String message){
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }
}
