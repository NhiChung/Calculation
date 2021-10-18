import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CalculatorApp {
    static ArrayList<String> calculationCharList = new ArrayList<String>(Arrays.asList("+", "-", "*", "/"));
    public static void main(String[] args) {
        Calculator app = new Calculator(input("first operand"),calculateInput() ,input("second operand"));
        writeFile(app.result());
    }

    public static String calculateInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your calculation (+, -, *, /): ");
        String calculate = input.nextLine();
        while (calculationCharList.indexOf(calculate)<0) {
            System.out.print("Please enter valid calculation (+, -, *, /): ");
            calculate = input.nextLine();
        }

        return calculate;
    }
    public static double input(String str) {
        Scanner input = new Scanner(System.in);
        double number = -50;
        try {
            System.out.print("Enter your " + str +": ");
            number = input.nextDouble();

            while (number < -20 || number > 20){
                System.out.print("Please enter a number from -20 to 20! ");
                System.out.print("Enter your " + str + ": ");
                number = input.nextDouble();
            }
        } catch (Exception e) {
            System.out.println("The operand is invalid. Please try again! ");
            System.exit(0);
        }
        return number;
    }
    private static String printDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "Current Date time: " + dtf.format(now).toString();
    }
    private static void createFile() {
        try {
            File myObj = new File("NhiChung_Calculation.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void writeFile(String text) {
        createFile();
        try {
            FileWriter myWriter = new FileWriter("NhiChung_Calculation.txt", true);

            myWriter.write(printDateTime() + "\r\n");
            myWriter.write(text+ "\r\n");
            myWriter.close();
            System.out.println("Write results to a file successfully!");
        } catch (IOException e) {
            System.out.println("Some errors happen when write file. Please try again!");
            e.printStackTrace();
        }
    }
}
