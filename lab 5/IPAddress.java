import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddress {

    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        validateIPAddress(ipAddress); //передается в метод, который сделает проверку
    }

    public static void validateIPAddress(String ipAddress) {
        // Регулярное выражение для адреса:
        // - начало строки
        // - проверка первых трех сегментов IP-адреса:
        // 25[0-5] — от 250 до 255.
        // 2[0-4]\\d — от 200 до 249.
        // 1\\d{2} — от 100 до 199.
        // [1-9]?\\d — от 0 до 99 (с учетом возможного пропуска первой цифры).
        // - разделитель между сегментами.
        // - повторение этой группы для трех сегментов.
        // - конец строки
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex); //компилирование
        Matcher matcher = pattern.matcher(ipAddress); //поиск совпадений

        try {
            if (matcher.matches()) { //проверяет существует ли строка
                System.out.println("IP-адрес корректен.");
            } else {
                System.out.println(
                        "IP-адрес некорректен. Убедитесь, что он состоит из четырёх чисел от 0 до 255, разделённых точками.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке IP-адреса: " + e.getMessage());
        }
    }
}