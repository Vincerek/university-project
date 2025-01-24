import javax.swing.*;

import static java.lang.System.exit;

public class Combat{
    static boolean actionTaken;

    public static void fight(Player hero, Player enemy) {
        SwingWorker<Void, Void> combatWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                int turn = 0;
                boolean playerTurn = true;

                Main.picture1.setIcon(Main.heroIdle);
                switch (Player.listaStworzen.get(1).GetName()) {
                    case "bandit":
                        Main.picture2.setIcon(Main.bandit);
                        break;
                    case "skeleton":
                        Main.picture2.setIcon(Main.skeleton);
                        break;
                    case "slime":
                        Main.picture2.setIcon(Main.slime);
                        break;
                    case "wolf":
                        Main.picture2.setIcon(Main.wolf);
                        break;
                }
                setCombatButtonsNames();
                Main.setCombatActions(BetterButtons.getButtonList(), Main.combatActions);
                while (hero.currentHealth > 0 && enemy.currentHealth > 0) {
                    turn++;
                    final int currentTurn = turn;
                    final boolean isPlayerTurn = playerTurn;

                    // Update UI safely on the event dispatch thread
                    SwingUtilities.invokeLater(() -> {
                        Main.label1.setText("It's turn number " + currentTurn);
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
                        Main.label3.setText(isPlayerTurn ? "Your Turn: " + hero.GetName() : enemy.GetName() + "'s Turn");
                    });


                    if (playerTurn) {
                        // Wait for player action via event listeners
                        while (!actionTaken) {
                            try {
                                Thread.sleep(100); // Check periodically
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        actionTaken = false; // Reset after action
                    } else {
                        enemyAttack(hero, enemy);
                    }

                    playerTurn = !playerTurn;
                    if (enemy.currentHealth <= 0) {
                        System.out.println("Wygrales");
                        JOptionPane.showMessageDialog(null, "Wygrałeś, koniec gry!", "Koniec Gry", JOptionPane.ERROR_MESSAGE);
                        exit(0);
                    }
                    if (hero.currentHealth <= 0) {
                        System.out.println("Przegrales");
                        JOptionPane.showMessageDialog(null, "Przegrałeś, koniec gry!", "Koniec Gry", JOptionPane.ERROR_MESSAGE);
                        exit(0);
                    }


                }
                return null;

            }

        };



        combatWorker.execute();
    }

    // Example enemy attack
    private static void enemyAttack(Player hero, Player enemy) {
        int damage = enemy.GetStrength();
        hero.currentHealth -= damage;
        Main.label5.setText(enemy.GetName() + " attacks " + hero.GetName() + " for " + damage + " damage!");
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
        Main.label4.setText(hero.GetName() + " attacks " + enemy.GetName() + " for " + damage + " damage!");
        Main.picture1.setIcon(Main.heroAttack);
        actionTaken = true;
    }

    public static void swordAura(Player hero) {
        int auraCost = 20;
        if (hero.currentMana >= auraCost) {
            hero.currentMana -= auraCost;
            hero.UpStrength(5);
            Main.label4.setText(hero.GetName() + " activates Sword Aura, increasing strength!");
            Main.picture1.setIcon(Main.heroAura);
            actionTaken = true;
        } else {
            Main.label4.setText(hero.GetName() + " doesn't have enough mana!");
        }

    }

    public static void rest(Player hero) {
        hero.currentHealth += 20;
        Main.label4.setText(hero.GetName() + " rests and recovers 10 HP and 10 MP.");
        Main.picture1.setIcon(Main.heroIdle);
        actionTaken = true;
    }

    public static void fireball(Player hero, Player enemy) {
        int manaCost = 10;
        int damage = 20;
        if (hero.currentMana >= manaCost) {
            hero.currentMana -= manaCost;
            enemy.currentHealth -= damage;
            Main.label4.setText(hero.GetName() + " casts Fireball at " + enemy.GetName() + " for " + damage + " damage!");
            Main.picture1.setIcon(Main.heroFireball);
            actionTaken = true;
        } else {
            Main.label4.setText(hero.GetName() + " doesn't have enough mana to cast Fireball!");
        }
    }

    public static void meditate(Player hero) {
        hero.currentMana += 20;
        Main.label4.setText(hero.GetName() + " meditates and recovers 20 MP.");
        Main.picture1.setIcon(Main.heroIdle);
        actionTaken = true;
    }

    public static void increaseStrength(Player hero) {
        hero.UpStrength(2);
        Main.label4.setText(hero.GetName() + " increases strength by 3!");
        Main.picture1.setIcon(Main.heroIdle);
        actionTaken = true;
    }

    public static void increaseIntelligence(Player hero) {
        hero.UpIntelligence(2);
        Main.label4.setText(hero.GetName() + " increases intelligence by 3!");
        Main.picture1.setIcon(Main.heroIdle);
        actionTaken = true;
    }

    public static void flee(Player hero) {
        Main.label4.setText(hero.GetName() + " decides to flee from the battle!");
        Main.picture1.setIcon(Main.initialImage);
        Main.picture2.setIcon(Main.initialImage);
        hero.currentHealth = 0;
        actionTaken = true;
        System.out.println("Przegrales");
        JOptionPane.showMessageDialog(null, "Przegrałeś, koniec gry!", "Koniec Gry", JOptionPane.ERROR_MESSAGE);
        exit(0);
    }



    public static void main(String []args){
    }
}
