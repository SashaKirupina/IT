import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalLetter {

    public static void main(String[] args) {
        String text = "jkYHJMmnb";
        String result = highlightCases(text); //вызывает текст в качестве параметра
        System.out.println(result);
    }

    public static String highlightCases(String text) {
        // Регулярное выражение для текста:
        // - за строчной латинской буквой сразу следует заглавная буква
        String regex = "([a-z])([A-Z])";
        Pattern pattern = Pattern.compile(regex); //компилирует регулярное выражение
        Matcher matcher = pattern.matcher(text); //создает объект который ищет в строке текст
        StringBuffer highlightedText = new StringBuffer(); //Создается для хранения текста с изменениями

        try {
            while (matcher.find()) {
                matcher.appendReplacement(highlightedText, matcher.group(1) + "!" + matcher.group(2) + "!"); //Заменяет текущее найденное совпадение на новый текст
            }
            matcher.appendTail(highlightedText); // Добавляем остаток текста
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
        }

        return highlightedText.toString();
    }
}

