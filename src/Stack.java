// Стек — это абстрактный тип данных, который представляет собой коллекцию элементов. Последним добавлен — первым извлечён.
// <T> позволяет использовать стек с любой типом данных(int или str)
public class Stack<T> {
    private T[] data; // Массив (основной контейнер) для хранения элементов стека
    private int size; // Текущий размер стека, указывает, где свободный слот в массиве

    // Конструктор для создания стека с заданной емкостью
    // Нельзя создать массив типа T напрямую (ограничение Java).
    // Поэтому создаётся массив Object и приводится к типу T[].
    // Аннотация @SuppressWarnings("unchecked") скрывает это предупреждение.

    @SuppressWarnings("unchecked")
    // Создаёт массив data указанного размера (capacity - максимальное кол-во элементов в стеке).
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        //стек пустой
        size = 0;
    }

    // Метод добавления элемента в стек
    public void push(T element) {
        // проверка, заполнен ли стек
        if (size == data.length) {
            throw new StackOverflowError("Стек переполнен");
        }
        // помещаем элемент в массив (увеличиваем на 1 после добавления)
        data[size++] = element;
    }

    // Метод удаления элемента из стека
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        // Уменьшаем size на 1 (перед удалением элемента). Получаем верхний элемент массива.
        T element = data[--size];
        // Убираем ссылку на удалённый элемент
        data[size] = null; //Освобождаем память
        return element; //Возвращаем удалённый элемент:
    }

    // Метод получения верхнего элемента стека без удаления
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        // Возвращаем элемент из массива по индексу size - 1 (верхний элемент). Не меняем size
        return data[size - 1];
    }

    // Метод проверки пустоты стека (true - стек пуст, false - есть элементы)
    public boolean isEmpty() {
        return size == 0;
    }

    // Пример использования
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10); // Создаем стек на 10 элементов

        // Добавляем элементы в стек
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Текущий верхний элемент: " + stack.peek()); // Вывод: 3
        System.out.println("Удалённый элемент: " + stack.pop()); // Удаляем 3
        System.out.println("Текущий верхний элемент: " + stack.peek()); // Вывод: 2

        stack.push(4); // Добавляем 4
        System.out.println("Текущий верхний элемент: " + stack.peek()); // Вывод: 4

        // Удаляем все элементы
        while (!stack.isEmpty()) {
            System.out.println("Удаляем: " + stack.pop());
        }
    }
}

