package org.example;

import java.util.Random;

public class Monster extends Entity {
    private double health;


    public Monster(String name, int attackPower, int blockPower, double maxHealth) {
        super(name, attackPower, blockPower, maxHealth);
        this.health = super.getMaxHealth();
    }


    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }


    public void attack(Hero hero) {
        if (diceRoll(Math.abs(super.getAttackPower() - hero.getBlockPower() + 1)) != 0) {
            double damageValue = super.getDAMAGE()[new Random().nextInt(super.getDAMAGE().length)];
            hero.setHealth(hero.getHealth() - damageValue);
            System.out.println("Здоровье " + hero.getName()
                    + " уменьшилось на " + damageValue
                    + " ед. Здоровье: " + hero.getHealth());
        } else {
            System.out.println(this.getName() + " провёл неудачную попытку атаки!");
        }
    }
}

