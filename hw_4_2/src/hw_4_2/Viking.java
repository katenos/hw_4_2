/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_4_2;

import java.util.Random;

/**
 *
 * @author kate_
 */
public class Viking implements Warrior, Cloneable {

    protected int health;
    protected int damage;
    protected String squadName;
    protected String warriorName;

    public Viking() {
        Random rand = new Random();
        this.health = 100;
        this.damage = 30;
        this.warriorName = "Viking " + (rand.nextInt(20) + 1);
    }

    @Override
    public int attack() {
        return damage;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public void setSquadName(String name) {
        this.squadName = name;
    }

    @Override
    public String toString() {
        String str = "Имя: " + this.warriorName + ", " + this.squadName + ", "
                + "здоровье " + this.health + ", урон " + this.damage;
        return str;
    }

    @Override
    public Viking clone() throws CloneNotSupportedException {
        return (Viking) super.clone();
    }
}
