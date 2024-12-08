public class ArraySum { //основной класс
    public static void main(String[] args) { //основной метод
        // массив целых чисел
        int[] array = new int[30];
        // цикл для заполнения
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Используем массив, чтобы его можно было менять внутри потока. для хранения суммы
        final int[] result1 = {0};
        final int[] result2 = {0};

        Thread thread1 = new Thread(() -> { //Создаем поток, который вычисляет сумму элементов 1 половины массива.
            for (int i = 0; i < array.length / 2; i++) { //Перебираем 1 половину
                result1[0] += array[i];
            }
        });

        Thread thread2 = new Thread(() -> { //Создаем поток, который вычисляет сумму элементов 2 половины массива.
            for (int i = array.length / 2; i < array.length; i++) {
                result2[0] += array[i];
            }
        });

        // Запускаем потоки для параллельного выполнения
        thread1.start();
        thread2.start();

        // Ожидаем завершения потоков
        try {
            //Главный поток ожидает завершения потоков thread1 и thread2
            thread1.join();
            thread2.join();
            //Если поток был прерван
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Суммируем результаты
        int totalSum = result1[0] + result2[0];
        System.out.println("Итоговая сумма: " + totalSum);
    }
}
