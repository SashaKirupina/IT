public class MatrixMax {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 7, 4},
                {3, 8, 7, 8},
                {9, 1, 9, 7}
        };

        //Размер массива равен числу строк матрицы.
        int[] maxInRows = new int[matrix.length]; //Одномерный массив для хранения максимальных значений.

        Thread[] threads = new Thread[matrix.length];//Массив для хранения потоков, каждый поток будет обрабатывать одну строку матрицы.

        for (int i = 0; i < matrix.length; i++) { //Перебираем строки.
            final int row = i; //Передаем строки в поток.

            threads[i] = new Thread(() -> { //Создаем поток, который выполняет код внутри лямбда-выражения.
                int maxInRow = matrix[row][0]; // Находим максимальное значение в строке.

                for (int j = 1; j < matrix[row].length; j++) { //Цикл перебирает элементы.
                    if (matrix[row][j] > maxInRow) { //Если текущий элемент больше.
                        maxInRow = matrix[row][j]; //Обновляем максимальное значение.
                    }
                }
                maxInRows[row] = maxInRow; //Сохраняем максимальный элемент строки.
            });
            threads[i].start(); //Запускаем поток для обработки строки матрицы.
        }
        try {
            for (int i = 0; i < threads.length; i++) { //Перебираем массив.
                threads[i].join(); //Ждем завершения каждого потока.
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Находим наибольшее значение среди максимальных элементов строк
        int overallMax = maxInRows[0];
        for (int i = 1; i < maxInRows.length; i++) {
            if (maxInRows[i] > overallMax) {
                overallMax = maxInRows[i];
            }
        }

        System.out.println("Наибольший элемент в матрице: " + overallMax);
    }
}

