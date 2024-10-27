public class one { //объявляем класс
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 0, 100}; // Массив целых чисел
        int sum = 0; //хранение суммы элементов массива

        try { //обработка ошибок
            // Вычисление суммы элементов массива
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            // Вычисление среднего арифметического
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива.");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль.");
        }
    }
}
