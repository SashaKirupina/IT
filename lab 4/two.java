import java.io.*;

public class two {
    public static void main(String[] args) {
        String firstFilePath = "firstString.txt";
        String secondFilePath = "dublicate.txt";

        copyFile(firstFilePath, secondFilePath);

    }

    static void copyFile(String firstFilePath, String secondFilePath) {
        FileReader firstFile = null;
        FileWriter secondFile = null;
        try {
            firstFile = new FileReader(firstFilePath);
            secondFile = new FileWriter(secondFilePath);

            int data;

            while ((data = firstFile.read()) != -1) {
                secondFile.write(data);
            }

            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода при обработке файлов");
        } finally {
            try {
                if (firstFile != null) {
                    firstFile.close();
                }
                if (secondFile != null) {
                    secondFile.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии файла: " + e.getMessage());

            }
        }
    }

}
