import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Password {

    public static void main(String[] args) {
        String password = "1234775894um";
        validatePassword(password);
    }

    public static void validatePassword(String password) { //принимает строку
        // Регулярное выражение для пароля:
        // - начало строки
        // - наличие хотя бы одной заглавной буквы
        // - наличие хотя бы одной цифры
        // - длина от 8 до 16 символов, которые могут быть только латинскими буквами (A-Z, a-z) и цифрами (0-9)
        // - конец строки
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
        Pattern pattern = Pattern.compile(regex); //предоставляет выражение
        Matcher matcher = pattern.matcher(password); //связывает регулярное выражение с паролем для выполнения проверки

        try {
            if (matcher.matches()) { //проверяет, соответствует ли пароль регулярному выражению
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль некорректен. Пароль должен содержать от 8 до 16 символов, включать хотя бы одну заглавную букву и одну цифру, и состоять только из латинских букв и цифр.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке пароля: " + e.getMessage());
        }
    }
}
