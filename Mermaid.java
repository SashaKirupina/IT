class Mermaid extends Monster {
    // Поля
    private String colorMermaid;
    private String[] featuresMermaid;
    private static int mermaidCount = 0; // Статическая переменная для счетчика объектов

    // Конструктор с параметрами
    public Mermaid(String name, String strength, String anger, String color, String[] features) {
        super(name, strength, anger);
        this.colorMermaid = color;
        this.featuresMermaid = features;
        mermaidCount++;
    }

    // Конструктор по умолчанию
    public Mermaid() {
        this("", "", "", "", null);
    }

    // Геттеры и сеттеры
    public String getType() {
        return colorMermaid;
    }

    public void setType(String type) {
        this.colorMermaid = type;
    }

    public String[] getFeatures() {
        return featuresMermaid;
    }

    public void setFeatures(String[] features) {
        this.featuresMermaid = features;
    }

    // Реализация абстрактного метода run()
    @Override
    public void run() {
        System.out.println("Русалка");
    }

    // Метод для вывода информации
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Цвет русалки: " + colorMermaid);
        System.out.println("Особенности русалки: " + String.join(", ", featuresMermaid));
    }

    // Статический метод для получения количества русалок
    public static int getMermaidCount() {
        return mermaidCount;
    }
}