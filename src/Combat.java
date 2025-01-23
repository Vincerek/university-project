import javax.swing.*;

public class Combat{
    static boolean actionTaken;

//    boolean playerTurn(int turn) {
//        if (turn % 2 == 1) {
//            return true;
//        } else return false;
//    }

    public static void fight(Player hero, Player enemy) {
        int turn = 0;
        boolean playerTurn = true;


        do{
            turn++;
            Main.label1.setText("\nIt's turn number " + turn);
            Main.label2.setText(String.format(
                    "%s: Str:%d Int:%d HP:%d MP:%d %s: Str:%d Int:%d HP:%d MP:%d",
                    hero.GetName(),
                    hero.GetStrength(),
                    hero.GetIntelligence(),
                    hero.currentHealth,
                    hero.currentMana,
                    enemy.GetName(),
                    enemy.GetStrength(),
                    enemy.GetIntelligence(),
                    enemy.currentHealth,
                    enemy.currentMana));
            if (playerTurn) {
                Main.label3.setText("Your Turn: " + hero.GetName());

//                do{
//                    try {
//                        Thread.sleep(1000); // Check periodically
//                        System.out.println("Czekam na akcje");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }while(!actionTaken);
//                System.out.println("Akcja została użyta");
//                actionTaken = false;
            }

        }while (hero.currentHealth > 0 && enemy.currentHealth > 0);

    // Combat skills



    }
    public static void setCombatButtonsNames(){
        System.out.println("Działa");
        Main.b1.setText("Walka wręcz");
        Main.b2.setText("Aura miecza");
        Main.b3.setText("Odpocznij");
        Main.b4.setText("Kula ognia");
        Main.b5.setText("");
        Main.b6.setText("Medytuj");
        Main.b7.setText("Zwiększ siłę");
        Main.b8.setText("Zwiększ inteligencję");
        Main.b9.setText("Uciekaj");

    }
    //combat abilities
    public static void meleeAttack(Player hero, Player enemy) {
        int damage = hero.GetStrength();
        enemy.currentHealth -= damage;
        Main.label3.setText(hero.GetName() + " attacks " + enemy.GetName() + " for " + damage + " damage!");
        actionTaken = true; // Signal that action is completed
    }

    public static void swordAura(Player hero) {
        int auraCost = 20;
        if (hero.currentMana >= auraCost) {
            hero.currentMana -= auraCost;
            hero.UpStrength(5);
            Main.label3.setText(hero.GetName() + " activates Sword Aura, increasing strength!");
        } else {
            Main.label3.setText(hero.GetName() + " doesn't have enough mana!");
        }
        actionTaken = true; // Signal that action is completed
    }

    public static void rest(Player hero) {
        hero.currentHealth += 20;
        Main.label3.setText(hero.GetName() + " rests and recovers 10 HP and 10 MP.");
        actionTaken = true; // Signal that action is completed
    }

    public static void fireball(Player hero, Player enemy) {
        int manaCost = 10;
        int damage = 20;
        if (hero.currentMana >= manaCost) {
            hero.currentMana -= manaCost;
            enemy.currentHealth -= damage;
            Main.label3.setText(hero.GetName() + " casts Fireball at " + enemy.GetName() + " for " + damage + " damage!");
        } else {
            Main.label3.setText(hero.GetName() + " doesn't have enough mana to cast Fireball!");
        }
        actionTaken = true; // Signal that action is completed
    }

    public static void meditate(Player hero) {
        hero.currentMana += 20;
        Main.label3.setText(hero.GetName() + " meditates and recovers 20 MP.");
        actionTaken = true; // Signal that action is completed
    }

    public static void increaseStrength(Player hero) {
        hero.UpStrength(2);
        Main.label3.setText(hero.GetName() + " increases strength by 3!");
        actionTaken = true; // Signal that action is completed
    }

    public static void increaseIntelligence(Player hero) {
        hero.UpIntelligence(2);
        Main.label3.setText(hero.GetName() + " increases intelligence by 3!");
        actionTaken = true; // Signal that action is completed
    }

    public static void flee(Player hero) {
        Main.label3.setText(hero.GetName() + " decides to flee from the battle!");
        hero.currentHealth = 0;
        actionTaken = true; // Signal that action is completed
        // Logic to end the combat can be implemented here
    }



    public static void main(String []args){
        //fight(Player.listaStworzen.get(0), Player.listaStworzen.get(1));
    }
}
