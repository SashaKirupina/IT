import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecifiedLetter {

    public static void main(String[] args) {
        String text = "Exdskadsj eckckckckalsdkfj dfffj.";
        char letter = 'e'; //буква с которой должны начинаться слова
        findWordsStartingWithLetter(text, letter); //Вызывается метод передается в него текст и буква для поиска
    }

    public static void findWordsStartingWithLetter(String text, char letter) {

        String regex = "\\b" + letter + "[a-zA-Zа-яА-ЯёЁ]*\\b";
        // Регулярное выражение для буквы:
        // - граница слова
        // - буква, с которой должно начинаться слово
        // - ноль или более букв (латинских и кириллических, включая ё/Ё)
        // - граница слова
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE); //слова, начинающиеся как с маленькой, так и с заглавной буквы будут совпадать
        Matcher matcher = pattern.matcher(text);

        System.out.println("Слова, начинающиеся с буквы '" + letter + "':");

        try {
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
        }
    }
}