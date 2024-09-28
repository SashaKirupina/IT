class Dragon extends Monster {
    // Поля
    private String headsDragon; //хранит количество голов дракона
    private static int dragonMonsterCount = 0; // Статическая переменная для счетчика объектов

    // Конструктор с параметрами, вызывает конструктор родительского класса
    public Dragon(String name, String strength, String anger, String heads) {
        super(name, strength, anger);
        this.headsDragon = heads;
        dragonMonsterCount++;  // Увеличение счетчика при создании объекта
    }

    // Конструктор по умолчанию, который вызывает конструктор с параметрами, передавая пустые строки и нулевое значение в качестве аргументов
    public Dragon() {
        this("", "", "", "");
    }

    // Геттеры и сеттеры
    public String getHeads() {
        return headsDragon;
    }

    public void setHeads(String headsDragon) {
        this.headsDragon = headsDragon;
    }

    // Реализация абстрактного метода run()
    @Override //переопределяет абстрактный метод из родительского класса
    public void run() {
        System.out.println("Дракон");
    }

    // Переопределение метода для вывода информации
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Головы: " + headsDragon);
    }

    // Статический метод для получения количества созданных приложений
    public static int getDragonMonsterCount() {
        return dragonMonsterCount;
    }
}
