package org.example;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Hero extends Entity {
    private static int NUMBER_OF_HEAL;
    private static final int MAX_HEALING = 4;
    private double health;


    public Hero(String name, int attackPower, int blockPower, double maxHealth) {
        super(name, attackPower, blockPower, maxHealth);
        this.health = super.getMaxHealth();
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void attack(Monster monster) {
        if (diceRoll(Math.abs(super.getAttackPower() - monster.getBlockPower()) + 1) != 0) {
            double damageValue = super.getDAMAGE()[new Random().nextInt(super.getDAMAGE().length)];
            monster.setHealth(monster.getHealth() - damageValue);
            System.out.println("Здоровье " + monster.getName()
                    + " уменьшилось на " + damageValue
                    + " ед. Здоровье: " + monster.getHealth());
        } else {
            System.out.println(super.getName() + " провёл неудачную попытку атаки!");
        }
    }

    public void healing() {
        if (NUMBER_OF_HEAL < MAX_HEALING) {
            double addHealth = BigDecimal.valueOf(this.getMaxHealth() * 0.3)
                    .setScale(1, RoundingMode.UP)
                    .doubleValue();
            this.setHealth(this.getHealth() + addHealth);
            if (this.getHealth() > this.getMaxHealth()) {
                this.setHealth(this.getMaxHealth());
            }
            System.out.println("Вы увеличили здоровье "
                    + super.getName()
                    + " на " + addHealth
                    + " ед. Здоровье: " + this.getHealth());
            NUMBER_OF_HEAL++;
        } else {
            System.out.println("Мы израсходовали все попытки исцеления!");
        }
    }
}
