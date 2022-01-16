import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {
    static void byeGoods() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Сейчас есть только зелье жизни, цена - 30");
        System.out.println("1. Купить");
        System.out.println("2. Выход");

        switch (br.readLine()) {
            case "1" -> bye();

            case "2" -> {
                System.out.println("До встречи!");
                Realm.printNavigation();
                Realm.command(br.readLine());
            }
        }
    }
    static void bye() throws IOException {
        Player.health = 100;
        Player.gold = Player.getGold() - 30;
        System.out.println("Ваше здоровье!");
        System.out.println("Здоровье = 100%");
        System.out.println("Золото = " + Player.getGold());
        Realm.printNavigation();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Realm.command(br.readLine());
    }
}

