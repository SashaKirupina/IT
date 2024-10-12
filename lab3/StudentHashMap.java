import java.util.HashMap;

class Student {
    String name;
    String surname;
    int age;
    double gpa;

    public Student(String name, String surname, int age, double gpa) { //конструктор для создания объекта
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() { //перепроверяет при выводе нужный вид
        return name + " " + surname + ", возраст: " + age + ", средний балл: " + gpa;
    }
}

public class StudentHashMap {
    private HashMap<String, Student> studentMap; //объект ключ-значение, позволяет сохранять и быстро искать

    public StudentHashMap() { //конструктор, пустая хэш карта, для хранения
        studentMap = new HashMap<>();
    }

    public void addStudent(String recordBookNumber, Student student) { //добавляет нового студента по зачетке
        studentMap.put(recordBookNumber, student); //для добавляения пары зачетка-студент
    }

    public Student getStudent(String recordBookNumber) { //возвращает объект
        return studentMap.get(recordBookNumber);
    }

    public void removeStudent(String recordBookNumber) { //удаляет
        studentMap.remove(recordBookNumber);
    }

    public static void main(String[] args) {
        StudentHashMap students = new StudentHashMap();

        // Добавление студентов
        students.addStudent("1", new Student("Петр", "Петров", 20, 4.5));
        students.addStudent("2", new Student("Игорь", "Смирнов", 22, 4.8));

        // Поиск студента
        System.out.println(students.getStudent("1"));

        // Удаление студента
        students.removeStudent("2");

        // Попытка найти удаленного студента
        System.out.println(students.getStudent("2")); // Вернет null
    }
}