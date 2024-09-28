abstract class Monster {
    // Поля, доступные в этом классе и в классах-наследниках
    protected String name;
    protected String strength;
    protected String anger;

    // Конструктор с параметрами, позволяет сразу задать значения для этих полей в дочерних классах
    public Monster(String name, String strength, String anger) {
        this.name = name;
        this.strength = strength;
        this.anger = anger;
    }

    // Конструктор по умолчанию, устанавливает значения полей в пустый строки
    public Monster() {
        this("", "", "");
    }

    // Абстрактный метод (должен быть реализован в дочерних классах)
    public abstract void run();

    // Геттеры и сеттеры, гет- возвращает текущее значение поля, сет- позволяет установить новое
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getAnger() {
        return anger;
    }

    public void setAnger(String anger) {
        this.anger = anger;
    }

    // Метод для вывода информации
    public void displayInfo() {
        System.out.println("Имя монстра: " + name);
        System.out.println("Сила монстра: " + strength);
        System.out.println("Уровень злости: " + anger);
    }
}
