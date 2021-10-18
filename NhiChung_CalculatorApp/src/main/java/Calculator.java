import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {
    double firstNumber;
    double secondNumber;
    String calculation;

    public Calculator(){}
    public Calculator(double operand1, String calculationChar, double operand2){
        firstNumber = operand1;
        secondNumber = operand2;
        calculation = calculationChar;
    }

    public String result() {
         double result = 0;
         switch (calculation){
             case "+":
                 result = firstNumber + secondNumber;
                 break;
             case "-":
                 result = firstNumber - secondNumber;
                 break;
             case "*":
                 result = firstNumber * secondNumber;
                 break;
             case "/":
                 if (secondNumber == 0){
                     return firstNumber + calculation + secondNumber + "\r\nYou can't divide a number by zero! \r\n";
                 } else result = firstNumber / secondNumber;
                 break;
             default:
                 JOptionPane.showMessageDialog(null, "Something went wrong. Please try again!");
         }
         return firstNumber + calculation + secondNumber + "=" + result + "\r\n";
    }
}
