import java.util.concurrent.CyclicBarrier;

public class WarehouseTask {
    public static void main(String[] args) {
        //Массив, котрый содержит веса
        int[] itemWeights = {20, 30, 50, 40, 60, 30, 20, 10, 80, 40, 50, 30};
        //Максимальный вес для одного переноса
        final int MAX_WEIGHT = 150;
        //Количество грузчиков
        final int NUM_OF_WORKERS = 3;

        // Барьер для синхронизации 3 грузчиков
        CyclicBarrier barrier = new CyclicBarrier(NUM_OF_WORKERS, () -> {
            System.out.println("Все грузчики собрали 150 кг. Отправка товаров на другой склад...");
        });

        // Создаем и запускаем потоки для грузчиков
        Thread[] workers = new Thread[NUM_OF_WORKERS]; //Размер равен кол-ву грузчиков
        //Создается объект класса Worker, которому передаются:
        //Номер грузчика.
        //Массив с товарами.
        //Максимальный вес для загрузки.
        //Барьер для синхронизации.
        for (int i = 0; i < NUM_OF_WORKERS; i++) {
            workers[i] = new Thread(new Worker(i, itemWeights, MAX_WEIGHT, barrier));
            workers[i].start();//Запускается поток для грузчика.
        }

        // Ожидаем завершения всех потоков
        for (Thread worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все товары перенесены.");
    }
}

// Класс, описывающий работу грузчика
class Worker implements Runnable { //Интерфейс Runnable, чтобы можно было запускать его в потоке.
    private final int workerId; //Номер
    private final int[] itemWeights; //Массив с товарами
    private final int maxWeight; //Максимальный вес
    private final CyclicBarrier barrier; //Барьер для синхронизации
    private static int currentItemIndex = 0; //Индекс текущего обрабатываемого товара
    private static final Object lock = new Object(); //Для синхронизации доступа к товарам

    //Конструктор. При создании грузчика передаются его идентификатор, массив товаров, максимальный вес и барьер
    public Worker(int workerId, int[] itemWeights, int maxWeight, CyclicBarrier barrier) {
        this.workerId = workerId;
        this.itemWeights = itemWeights;
        this.maxWeight = maxWeight;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        //Цикл для работы грузчика
        int currentWeight = 0; //Текущий вес

        while (true) {
            int itemWeight = 0;

            // Синхронизируем доступ к массиву товаров
            synchronized (lock) { //Только 1 грузчик работает с индексом
                if (currentItemIndex < itemWeights.length) { //Проверка есть ли еще товары
                    itemWeight = itemWeights[currentItemIndex];
                    currentItemIndex++;
                    System.out.println("Грузчик " + workerId + " взял товар весом " + itemWeight + " кг.");
                } else {
                    // Если все товары перенесены, выходим из цикла
                    break;
                }
            }

            currentWeight += itemWeight;//Добавляем вес товара к текущему весу

            // Если грузчик превысил лимит веса
            if (currentWeight >= maxWeight) {
                System.out.println("Грузчик " + workerId + " собрал " + currentWeight + " кг и готов к отправке.");
                try {
                    barrier.await(); // Ждем других грузчиков
                } catch (Exception e) {
                    e.printStackTrace();
                }
                currentWeight = 0; // Сбрасываем текущий вес для следующей загрузки
            }
        }

        // Завершаем последний цикл, если остались товары, но лимит не достигнут
        if (currentWeight > 0) {
            System.out.println("Грузчик " + workerId + " завершает с весом " + currentWeight + " кг.");
            try {
                barrier.await(); // Ждем других грузчиков
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}