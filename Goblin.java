class Goblin extends Monster {
    // Поля
    private String typeSN; //хранит тип гоблина
    private int mobCountSN; //хранит количество мобов
    private static int GoblinMonsterCount = 0; //статическая переменная, отслеживает количество созданных объектов  // Статическая переменная для счетчика объектов

    // Конструктор с параметрами, вызывает конструктор родительского класса
    public Goblin(String name, String strength, String anger, String type, int mobCount) {
        super(name, strength, anger);
        this.typeSN = type;
        this.mobCountSN = mobCount;
        GoblinMonsterCount++;  // Увеличевает значение статической переменной при создании объекта
    }

    // Конструктор по умолчанию, который вызывает конструктор с параметрами, передавая пустые строки и нулевое значение в качестве аргументов
    public Goblin() {
        this("", "", "", "", 0);
    }

    // Геттеры и сеттеры
    public String getType() {
        return typeSN;
    }

    public void setType(String typeSN) {
        this.typeSN = typeSN;
    }

    public int getMobCount() {
        return mobCountSN;
    }

    public void setMobCount(int mobCountSN) {
        this.mobCountSN = mobCountSN;
    }

    // Реализация абстрактного метода run()
    @Override //переопределяет абстрактный метод из родительского класса
    public void run() { //выводит информацию о типе и количестве
        System.out.println("Гоблин");
    }

    // Переопределение метода для вывода информации
    @Override
    public void displayInfo() { //выводит информацию о полях, унаследованных от Monster
        super.displayInfo();
        System.out.println("Goblin Type:" + typeSN);
        System.out.println("Mob Count:" + mobCountSN);
    }

    // Статический метод для получения количества созданных гоблинов
    public static int getGoblinMonsterCount() {
        return GoblinMonsterCount;
    }
}
