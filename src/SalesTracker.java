import java.util.ArrayList;
import java.util.Scanner;

public class SalesTracker {
    public static void main(String[] args) {
        // Хранит список продаж. Каждый объект в списке представляет отдельную запись о продаже
        ArrayList<Sale> sales = new ArrayList<>();
        // Используется для чтения ввода пользователя.
        Scanner scanner = new Scanner(System.in);

        //бесконечный цикл меню
        while (true) {
            // \n — это специальный символ новой строки в Java.
            // без \n текст "Меню:" будет прилеплен сразу после:
            System.out.println("\nМеню:");
            System.out.println("1. Добавить продажу");
            System.out.println("2. Показать список продаж");
            System.out.println("3. Общая сумма продаж");
            System.out.println("4. Наиболее популярный товар");
            System.out.println("5. Выйти");
            System.out.print("Выберите пункт меню: ");

            int choice = scanner.nextInt(); // Считывает число
            scanner.nextLine(); // Очистка буфера, Если его не очистить, следующий ввод строки может пропустить ввод и сразу завершиться.

            // обработка выбора
            switch (choice) {
                //  Добавить продажу
                case 1:
                    addSale(sales, scanner);
                    break;
                // Показать список продаж
                case 2:
                    showSales(sales);
                    break;
                // Общая сумма продаж
                case 3:
                    showTotalRevenue(sales);
                    break;
                // Наиболее популярный товар
                case 4:
                    showMostPopularProduct(sales);
                    break;
                // Выход
                case 5:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод добавления продаж
    private static void addSale(ArrayList<Sale> sales, Scanner scanner) {
        System.out.print("Введите название товара: ");
        // читает строку и сохраняет результат
        String productName = scanner.nextLine();
        System.out.print("Введите количество: ");
        // читает целое число и сохраняет результат
        int quantity = scanner.nextInt();
        System.out.print("Введите цену за единицу: ");
        // читает число с точкой и сохраняет результат
        double price = scanner.nextDouble();

        // Проверяем, существует ли товар(Цикл for-each перебирает все элементы списка sales)
        for (Sale sale : sales) {
            // получаем название товара и сравниваем название товара в продаже с названием, введённым пользователем.(так же игнорируем регистр)
            if (sale.getProductName().equalsIgnoreCase(productName)) {
                // Если такой товар уже существует, увеличивает его количество и общую стоимость
                sale.addQuantity(quantity, price);
                System.out.println("Продажа обновлена!");
                return;
            }
        }

        // Если товара нет, добавляем новый
        sales.add(new Sale(productName, quantity, price));
        System.out.println("Продажа добавлена!");
    }

    // Метод показывающий список продаж
    private static void showSales(ArrayList<Sale> sales) {
        // проверяем, пуст ли список
        if (sales.isEmpty()) {
            System.out.println("Список продаж пуст.");
        // если список не пуст, выводим заголовок
        } else {
            System.out.println("Список продаж:");
            // Цикл for-each перебирает все элементы списка sales и выводит каждую продажу.
            for (Sale sale : sales) {
                System.out.println(sale);
            }
        }
    }

    // Метод общей суммы продаж
    private static void showTotalRevenue(ArrayList<Sale> sales) {
        // хранит общую сумму продаж
        double totalRevenue = 0;
        // Цикл for-each перебирает все продажи
        for (Sale sale : sales) {
            // Получаем общую стоимость текущей продажи и добавляем стоимость к общей сумме
            totalRevenue += sale.getTotalPrice();
        }
        System.out.println("Общая сумма продаж: " + totalRevenue);
    }

    // Метод наиболее популярный товар
    private static void showMostPopularProduct(ArrayList<Sale> sales) {
        // Проверяем, пуст ли список
        if (sales.isEmpty()) {
            System.out.println("Продажи отсутствуют.");
            return;
        }

        // Изначально предполагаем, что самый популярный товар — это первый элемент списка.
        Sale mostPopular = sales.get(0);
        // Цикл for-each перебирает все элементы списка sales
        for (Sale sale : sales) {
            // Если количество текущего товара (sale) больше, чем у текущего лидера, выполняется тело if.
            if (sale.getQuantity() > mostPopular.getQuantity()) {
                // обновление лидера
                mostPopular = sale;
            }
        }

        System.out.println("Наиболее популярный товар: " + mostPopular.getProductName() +
                " (продано " + mostPopular.getQuantity() + " единиц)");
    }
}

class Sale {
    // название товара
    private final String productName;
    // кол-во проданных единиц
    private int quantity;
    // сумма за проданный товар
    private double totalPrice;

    // конструктор для наших полей
    public Sale(String productName, int quantity, double pricePerUnit) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = quantity * pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // метод для обновления кол-во проданных единиц и общей стоимости
    public void addQuantity(int quantity, double pricePerUnit) {
        this.quantity += quantity;
        this.totalPrice += quantity * pricePerUnit;
    }

    @Override
    //определяет, как объект Sale будет выглядеть при выводе.
    public String toString() {
        return productName + " - " + quantity + " шт., общая сумма: " + totalPrice;
    }
}

