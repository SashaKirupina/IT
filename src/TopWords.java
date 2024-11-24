import java.io.File; //работа с файлами
import java.io.FileNotFoundException; //исключение для файлов, которых не существует
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "D:\\university\\Java\\lab 6\\text.txt";

        //Создаем объект File
        File file = new File(filePath);

        //Создаем объект Map для хранения слов и их количества повторений
        Map<String, Integer> wordCountMap = new HashMap<>(); //быстрый доступ к данным через ключи

        // Считываем файл по словам и добавляем их в Map
        try (Scanner scanner = new Scanner(file)) { //класс для построчного или пословного чтения текста из файла
            while (scanner.hasNext()) { //проверяет, есть ли в файле еще слова
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я]", "");//читает следующее слово из файла.//приводит слово к нижнему регистру.//удаляет из слова все символы, кроме букв.
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1); //проверяет, есть ли слово в Map //добавляет слово в Map или обновляет его значение, увеличивая счетчик на 1
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();//стек вызовов для диагностики ошибки
        }

        // Создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCountMap.entrySet());

        // Сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() { //сортирует список. анонимный класс для задания правила сортировки
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue()); //сортировка по убыванию значений
            }
        });

        // Выводим топ-10 слов
        System.out.println("Топ-10 самых часто встречающихся слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) { //гарантирует, что программа выведет максимум 10 слов, даже если их меньше
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}
