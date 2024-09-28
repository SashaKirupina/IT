class TypesOfMermaid extends Mermaid {
    // Поля
    private boolean isitDangerous; //да или нет

    // Конструктор с параметрами
    public TypesOfMermaid(String name, String strength, String anger, String color, String[] features, boolean isitDangerous) {
        super(name, strength, anger, color, features);
        this.isitDangerous = isitDangerous;
    }

    // Конструктор по умолчанию
    public TypesOfMermaid() {
        this("", "", "", "", null, true);
    }

    // Геттеры и сеттеры
    public boolean isitDangerous() {
        return isitDangerous;
    }

    public void isitDangerous(boolean isitDangerous) {
        this.isitDangerous = isitDangerous;
    }

    // Переопределение метода run()
    @Override
    public void run() {
        System.out.println("Эта русалка " + getAnger() + (isitDangerous ? " (Русалка опасна?)" : ""));
    }

    // Переопределение метода displayInfo()
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Опасная русалка: " + (isitDangerous ? "да" : "нет"));
    }
}