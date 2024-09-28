public class Main {
    public static void main(String[] args) {
        String[] features = {"Цвет", "Опасность", "Сила"};

        Dragon dragonMonster1 = new Dragon("Пурпурный дракон", "100", "безопасный", "1");
        dragonMonster1.run();
        dragonMonster1.displayInfo();

        Dragon dragonMonster2 = new Dragon("Боевой дракон", "10000", "опасный", "3");
        dragonMonster2.run();
        dragonMonster2.displayInfo();

        Dragon dragonMonster3 = new Dragon("Каменный дракон", "10", "безопасный", "1");
        dragonMonster3.run();
        dragonMonster3.displayInfo();

        Goblin goblinMonster1 = new Goblin("Грум", "50", "безопасный", "земной", 3000);
        goblinMonster1.run();
        goblinMonster1.displayInfo();

        Goblin goblinMonster2 = new Goblin("Хрикс", "70", "опасный", "кусачий", 100);
        goblinMonster2.run();
        goblinMonster2.displayInfo();

        Mermaid mermaid1 = new Mermaid("Ариста", "200", "опасная", "розовая", features);
        mermaid1.run();
        mermaid1.displayInfo();

        TypesOfMermaid typesOfMermaid1 = new TypesOfMermaid("Анита", "3000", "опасная", "красная", new String[]{"Злая", "Лучше не встречать"}, true);
        typesOfMermaid1.run();
        typesOfMermaid1.displayInfo();



        System.out.println("О каком количестве драконов известно?" + Dragon.getDragonMonsterCount());
        System.out.println("О каком количестве гоблинов известно?" + Goblin.getGoblinMonsterCount());
        System.out.println("О каком количестве русалок известно?" + Mermaid.getMermaidCount());
    }
}