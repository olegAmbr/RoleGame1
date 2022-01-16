import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {
    //Класс для чтения введенных строк из консоли
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //Игрок должен храниться на протяжении всей игры
    private static Character player = null;
    //Класс для битвы можно не создавать каждый раз, а переиспользовать
    private static Battle battle = null;

    public static void main(String[] args) {
        //Инициализируем класс для боя
        battle = new Battle();
        //Первое, что нужно сделать при запуске игры, это создать персонажа, поэтому мы предлагаем ввести его имя
        System.out.println("Введите имя персонажа:");
        //Далее ждем ввод от пользователя
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    public static void command(String string) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (player == null) {
            player = new Player(
                    string,
                    100,
                    20,
                    20,
                    0,
                    0
            );
            System.out.printf("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!%n", player.getName());
            //Метод для вывода меню
            printNavigation();
        }

        //Варианты для команд
        switch (string) {
            case "1" -> {
                Shop.byeGoods();
            }
            case "2" -> commitFight();
            case "3" -> System.exit(1);
            case "да" -> command("2");
            case "нет" -> {
                printNavigation();
                command(br.readLine());
            }
        }
        //Снова ждем команды от пользователя
        command(br.readLine());
    }

    public static void commitFight() {
        battle.fight(player, createMonster(), new Realm.FightCallback() {
            @Override
            public void fightWin() {
                System.out.printf("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.%n", player.getName(), player.getExperience(), player.getGold(), player.getHealth());
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }

    public static Character createMonster() {
        //Рандомайзер
        int random = (int) (Math.random() * 10);
        //С вероятностью 50% создается или скелет, или гоблин
        if (random % 2 == 0) return new Goblin("Гоблин",50,10,10,100,20);
        else return new Skeleton("Скелет",25,20,20,100,10);
    }

    public interface FightCallback {
        default void fightWin() {
           System.out.println("Победа!");
        }
        default void fightLost() {
           System.out.println("Поражение");
        }
    }
}

