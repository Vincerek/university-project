public class Player extends Main{
    // primary stats
    private int level;
    private int maxHealth;
    public int currentHealth;
    private int maxMana;
    public int currentMana;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int speed;
    private int defense;
    private int criticalChance;


    Player(){
        level = 1;
        maxHealth = 100;
        currentHealth = maxHealth;
        maxMana = 100;
        currentMana = maxMana;
        strength = 10;
        dexterity = 10;
        intelligence = 10;
        speed = 10;
        defense = 0;
        criticalChance = 10;
    }
    Player(int baseLevel, int str, int dex, int intel){
        level = baseLevel;
        maxHealth =baseLevel*10 + str*10 -10;
        currentHealth = maxHealth;
        maxMana =baseLevel*10 + intel*10 - 10;
        currentMana = maxMana;
        strength = str;
        dexterity = dex;
        intelligence = intel;
        speed = dex;
        defense = 0;
        criticalChance = 10;
    }

    public int GetStrength() { return this.strength; }
    public int GetDexterity() { return this.dexterity; }
    public int GetIntelligence() { return this.intelligence; }

    public void UpStrength() { this.strength += 5; this.maxHealth += 50; }
    public void UpDexterity() { this.dexterity += 5; this.speed = dexterity;}
    public void UpIntelligence() { this.intelligence += 5; this.maxMana += 50; }
}
