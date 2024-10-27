package zad3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionLogger {
    private static final String pathToFile = "D://university//Jawa//Lab 4//out//production//Lab 4//zad3";
    private static final String logFile = "exceptions.log";

    public static void logException(Exception e) {

        FileWriter writeFile = null;

        try {
            writeFile = new FileWriter(pathToFile + logFile, true);

        } catch (IOException e1) {
            System.err.println("ОШИБКА ОТКРЫТИЯ ФАЙЛА");
            try {
                writeFile = new FileWriter(pathToFile + logFile);
            } catch (IOException e2) {
                System.err.println("ОШИБКА ПРИ ОТКРЫТИИ ФАЙЛА");
            }

        } finally {

            try {
                writeFile.write("ERROR: " + e.toString() + "\n");
                writeFile.close();
                System.out.println("ОШИБКА '" + e.getMessage() +"' УСПЕШНО ЗАПИСАНА");

            } catch (Exception e3) {
                System.err.println("ОШИБКА ПРИ ЗАКРЫТИИ ФАЙЛА");
            }

        }
    }
}