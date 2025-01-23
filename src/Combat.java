import javax.swing.*;

public class Combat{


    boolean playerTurn(int turn) {
        if (turn % 2 == 1) {
            return true;
        } else return false;
    }

    public static void fight(Player hero, Player enemy) {
        int turn = 1;

        Main.label2.setText("\nIt's turn number " + turn);
        Main.label1.setText(String.format(
                "Your: Str:%d Dex:%d Int:%d HP:%d MP:%d Enemy: Str:%d Dex:%d Int:%d HP:%d MP:%d",
                hero.GetStrength(),
                hero.GetDexterity(),
                hero.GetIntelligence(),
                hero.currentHealth,
                hero.currentMana,
                enemy.GetStrength(),
                enemy.GetDexterity(),
                enemy.GetIntelligence(),
                enemy.currentHealth,
                enemy.currentMana));

//        while (hero.currentHealth > 0 && enemy.currentHealth > 0) {
//            Main.label2.setText("\nIt's turn number " + turn);
//            Main.label1.setText(String.format(
//                    "Your: Str:%d Dex:%d Int:%d HP:%d MP:%d Enemy: Str:%d Dex:%d Int:%d HP:%d MP:%d",
//                    hero.GetStrength(),
//                    hero.GetDexterity(),
//                    hero.GetIntelligence(),
//                    hero.currentHealth,
//                    hero.currentMana,
//                    enemy.GetStrength(),
//                    enemy.GetDexterity(),
//                    enemy.GetIntelligence(),
//                    enemy.currentHealth,
//                    enemy.currentMana
//            ));

/*            if (playerTurn(turn))
            {
                label3.setText("Your Turn: ");
                //Console.Write("1:Attack, 2:Spellbook, 3:LevelUp ... ");
                int opt = int.Parse(Console.ReadLine());
                switch (opt)
                {
                    case 1:
                        hero.Attack(enemy);
                        break;

                    case 2:
                        hero.SpellBook(enemy);
                        break;

                    case 3:
                        hero.LevelUp();
                        break;
                }
            }
            else
            {
                switch (enemy.classID)
                {
                    case 0: enemy.Attack(hero); break;
                    case 1: enemy.Attack(hero); break;
                    case 2: enemy.Attack(hero); break;
                    case 3: enemy.Flare(hero, enemy.MP); break;
                }
            }

            Console.WriteLine();
            turn++;
        }*/
            // TODO: Win


        //}

    }
    public static void main(String []args){
        //fight(Player.listaStworzen.get(0), Player.listaStworzen.get(1));
    }
}
