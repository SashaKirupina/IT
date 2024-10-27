package zad3 ;

public class three {
    public static void main(String[] args) {
        var1(10, 0);
    }

    static void var1(int a, int b) {
        try {
            if (b == 0) {
                throw new CustomDivisionException("ДЕЛЕНИЕ НА НОЛЬ");
            }
            System.out.println("Полученное значение: " + a / b);
        } catch (CustomDivisionException e) {
            System.out.println(e.getMessage());}
    }
}

// Обработка деления на ноль
class CustomDivisionException extends Exception {
    public CustomDivisionException(String message) {
        super(message);
        ExceptionLogger.logException(this);
    }
}

