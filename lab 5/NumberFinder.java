import java.util.regex.Pattern;
import java.util.regex.Matcher; //поиск и проверки

public class NumberFinder {

    public static void main(String[] args) {
        String text = "1";
        findNumbersInText(text); //передается строка для поиска чисел
    }

    public static void findNumbersInText(String text) { //ищет числа в строке
        // Регулярное выражение:
        // - необязательному знаку минус
        // - обозначаем границу слова
        // - последовательность из одной или более цифр
        // - десятичная точка и одна или более цифры после нее
        // - граница слова
        String regex = "-?\\b\\d+(\\.\\d+)?\\b"; //шаблон поиска чисел
        Pattern pattern = Pattern.compile(regex); //компиляция
        Matcher matcher = pattern.matcher(text); //выполнение операций и извлечение совпадений

        System.out.println("Найденные числа в тексте:");

        try {
            while (matcher.find()) { //выполняется пока есть совпадения
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при обработке текста: " + e.getMessage());
        }
    }
}


