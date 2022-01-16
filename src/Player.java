import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player extends Character {
    public static int health;
    public static int gold;

    public Player(String name, int health, int power, int skill, int experience, int gold) {
        super(name, health, power, skill, experience, gold);
    }

}
