
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.StatUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * MyStatsApp is a simple console application which computes
 * basic statistics of a series of data values. The application takes
 * a file of data as its single argument.
 *
 * @author janbodnar
 */
public class MyStatsApp {

    /**
     * Runs the application
     *
     * @param args an array of String arguments to be parsed
     */
    private static void printDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        writeFile("Current Date time: " + dtf.format(now).toString());
    }
    private static void createFile() {
        try {
            File myObj = new File("NhiChung_Calculation.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private static void writeFile(String text) {
        try {
            FileWriter myWriter = new FileWriter("NhiChung_Calculation.txt", true);
            myWriter.write(text+ "\r\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void run(String[] args) {

        CommandLine line = parseArguments(args);

        if (line.hasOption("filename")) {

            System.out.println(line.getOptionValue("filename"));
            String fileName = line.getOptionValue("filename");

            double[] data = readData(fileName);

            createFile();
            printDateTime();
            calculateAndPrintStats(data);

            System.out.println("Write results to a file successfully");
        } else {
            printAppHelp();
        }
    }

    /**
     * Parses application arguments
     *
     * @param args application arguments
     * @return <code>CommandLine</code> which represents a list of application
     * arguments.
     */
    private CommandLine parseArguments(String[] args) {

        Options options = getOptions();
        CommandLine line = null;

        CommandLineParser parser = new DefaultParser();

        try {
            line = parser.parse(options, args);

        } catch (ParseException ex) {

            System.err.println("Failed to parse command line arguments");
            System.err.println(ex.toString());
            printAppHelp();

            System.exit(1);
        }

        return line;
    }

    /**
     * Reads application data from a file
     *
     * @param fileName file of application data
     * @return array of double values
     */
    private boolean isValid (double number) {
        return number<=20 && number >=-20;
    }
    private static void showWarningMessage() {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "Please enter numbers from -20 to 20.",
                "Alert", JOptionPane.WARNING_MESSAGE);
    }
    private double[] readData(String fileName) {

        var data = new ArrayList<Double>();
        double[] mydata = null;

        try (var reader = Files.newBufferedReader(Paths.get(fileName));
             var csvReader = new CSVReaderBuilder(reader).build()) {

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {

                for (String e : nextLine) {
                    if (isValid(Double.parseDouble(e))) {
                        data.add(Double.parseDouble(e));
                    } else {
                        showWarningMessage();
                        break;
                    }
                }
            }

            mydata = ArrayUtils.toPrimitive(data.toArray(new Double[0]));

        } catch (IOException ex) {

            System.err.println("Failed to read file");
            System.err.println(ex.toString());
            System.exit(1);
        }

        return mydata;
    }

    /**
     * Generates application command line options
     *
     * @return application <code>Options</code>
     */
    private Options getOptions() {

        var options = new Options();

        options.addOption("f", "filename", true, "file name to load data from");
        return options;
    }

    /**
     * Prints application help
     */
    private void printAppHelp() {

        Options options = getOptions();

        var formatter = new HelpFormatter();
        formatter.printHelp("JavaStatsEx", options, true);
    }

    /**
     * Calculates and prints data statistics
     *
     * @param data input data
     */
    private void calculateAndPrintStats(double[] data) {

        writeFile("Geometric mean: " + StatUtils.geometricMean(data));
        writeFile("Arithmetic mean: " + StatUtils.mean(data));
        writeFile("Max: " + StatUtils.max(data));
        writeFile("Min: " + StatUtils.min(data));
        writeFile("Sum: " + StatUtils.sum(data));
        writeFile("Variance: " + StatUtils.variance(data) + "\r\n");
    }
}