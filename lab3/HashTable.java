import java.util.LinkedList;

class HashTable<K, V> { //внутренний класс, представляет одну запись в таблице
    private class Entry<K, V> {
        K key; //ключ
        V value; //значение

        public Entry(K key, V value) {  //создает новый объект записи
            this.key = key;
            this.value = value;
        }

        public K getKey() { //возвращают
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) { //обновляет
            this.value = value;
        }
    } //класс хранит пары ключ-значение

    private LinkedList<Entry<K, V>>[] table; //массив где хранятся записи
    private int size; //хранит кол-во элементов, важно для размера

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) { //
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(K key) { //функция хеширования, принимает ключ и возвращает индекс
        //использование Math.abs для получения положительного индекса
        return Math.abs(key.hashCode()) % table.length; //индекс всегда положительный и не выходит за пределы
    }

    public void put(K key, V value) { //добавляет новую запись или обновляет
        int index = hash(key);
        if (table[index] == null) { //новый
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) { //проверка
            if (entry.getKey().equals(key)) {
                entry.setValue(value); //если такой ключ есть, то значение обновляется
                return;
            }
        }

        table[index].add(new Entry<>(key, value)); //если ключ новый, то новая запись и увеличивается счетчик
        size++;
    }

    public V get(K key) { //возвращает значение по ключу
        int index = hash(key);
        if (table[index] == null) return null; //проверка

        for (Entry<K, V> entry : table[index]) { //если список сущ, поиск по ключу
            if (entry.getKey().equals(key)) {
                return entry.getValue(); //если найдена
            }
        }

        return null; //если не найдена
    }

    public void remove(K key) { //удаляет запись с указанным ключом
        int index = hash(key);
        if (table[index] == null) return; //если по индексу нашли список, то выполняется его обход

        for (Entry<K, V> entry : table[index]) { //запись найдена и удаляется, размер уменьшается
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() { //возвращает кол-во элементов в таблице
        return size;
    }

    public boolean isEmpty() { //проверяет пуста ли таблица
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10); //создаем экземпляр таблицы с размером 10

        //добавляем записи
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);

        // Получаем элементы
        System.out.println("Значение по ключу 'apple': " + hashTable.get("apple"));

        // Удаляем элемент
        hashTable.remove("banana");

        // Проверяем, существует ли элемент
        System.out.println("Значение по ключу 'banana': " + hashTable.get("banana"));

        // Размер таблицы
        System.out.println("Размер таблицы: " + hashTable.size());

        // Проверка, пуста ли таблица
        System.out.println("Пуста ли таблица? " + hashTable.isEmpty());
    }
}
