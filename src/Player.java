import java.util.ArrayList;
import java.util.List;

public class Player extends Main{

    public static List<Player> listaStworzen = new ArrayList<>();
    private String name;
    // primary stats
    private int level;
    private int maxHealth;
    public int currentHealth;
    private int maxMana;
    public int currentMana;
    private int strength;
    private int intelligence;


    Player(){
        name = "Nameless";
        level = 1;
        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        strength = 10;
        intelligence = 10;
        listaStworzen.add(this);
    }
    Player(String name){
        this.name = name;
        level = 1;
        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        strength = 10;
        intelligence = 10;
        listaStworzen.add(this);
    }
    Player(String name, int baseLevel, int str, int intel){
        this.name = name;
        level = baseLevel;
        maxHealth =baseLevel*10 + str*10 -10;
        currentHealth = maxHealth;
        maxMana =baseLevel*10 + intel*10 - 10;
        currentMana = maxMana;
        strength = str;
        intelligence = intel;
        listaStworzen.add(this);
    }
    public String GetName() { return this.name; }
    public int GetStrength() { return this.strength; }
    public int GetIntelligence() { return this.intelligence; }

    public void UpStrength(int x) { this.strength += x; this.maxHealth += 10*x; }
    public void UpIntelligence(int x) { this.intelligence += x; this.maxMana += 10*x; }

    public static void main(String []args){

    }
}
