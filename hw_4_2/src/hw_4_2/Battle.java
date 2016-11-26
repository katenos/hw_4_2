/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_4_2;

/**
 *
 * @author kate_
 */
public class Battle {

    /**
     * @param args the command line arguments
     */
    private static Squad ot1, ot2;
    private static DateHelper d;

    public static void main(String[] args) {
        prapareForBattle();
        System.out.println("Список бойцов");
        for (int i = 0; i < ot1.getSquad().size(); i++) {
            System.out.println(ot1.getSquad().get(i).toString());
        }
        System.out.println("");
        for (int i = 0; i < ot2.getSquad().size(); i++) {
            System.out.println(ot2.getSquad().get(i).toString());
        }
        String nameWinner = battle();
        System.out.println("\nПобедил " + nameWinner);
        System.out.println("Общее время поединка " + d.getFormattedDiff());
    }

    public static void prapareForBattle() {
        d = new DateHelper();
        ot1 = new Squad("1-й отряд");
        ot2 = new Squad("2-й отряд");
        ot1.addWarrior(new Archer());
        ot1.addWarrior(new Archer());
        ot1.addWarrior(new Viking());
        ot1.addWarrior(new Viking());
        ot2.addWarrior(new Archer());
        ot2.addWarrior(new Archer());
        ot2.addWarrior(new Viking());
    }

    public static String battle() {
        int i = 0;
        System.out.println("\nСражение началось!");
        System.out.println(d.getFormattedStartDate());
        String nameWinner = "";
        while (nameWinner.equals("")) {
            System.out.println("\nРаунд " + (++i));

            Warrior w1 = ot1.getRandomWarrior();
            Warrior w2 = ot2.getRandomWarrior();
            System.out.println("Боец - " + w1.toString() + " атакует бойца\n       " + w2.toString());
            w2.takeDamage(w1.attack());
            d.skipTime();
            if (!ot2.hasAliveWarriors()) {
                nameWinner = ot1.toString();
                break;
            }
            w1 = ot1.getRandomWarrior();
            w2 = ot2.getRandomWarrior();
            System.out.println("Боец - " + w2.toString() + " атакует бойца\n       " + w1.toString());
            w1.takeDamage(w2.attack());
            d.skipTime();
            if (!ot1.hasAliveWarriors()) {
                nameWinner = ot2.toString();
                break;
            }
        }
        return nameWinner;
    }

}
