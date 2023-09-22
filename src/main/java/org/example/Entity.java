package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entity {
    private final int[] DAMAGE;
    private final String name;
    private final int attackPower;
    private final int blockPower;
    private final double maxHealth;

    public Entity(String name, int attackPower, int blockPower, double maxHealth) {
        this.name = name;
        this.attackPower = attackPower;
        this.blockPower = blockPower;
        this.maxHealth = maxHealth;
        DAMAGE = new int[]{1, 2, 3, 4, 5, 6};
    }

    public int[] getDAMAGE() {
        return DAMAGE;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getBlockPower() {
        return blockPower;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public long diceRoll(int attackModifier) {
        List<Integer> listOfNumber = new ArrayList<>();
        for (int i = 0; i < attackModifier; i++) {
            listOfNumber.add(DAMAGE[new Random().nextInt(DAMAGE.length)]);
        }
        return listOfNumber.stream().filter(x -> x == 5 || x == 6).count();
    }

    @Override
    public String toString() {
        return "\t" + "Имя: " +
                name + "\n" +
                "\t" + "Здоровье: " +
                maxHealth + "\n" +
                "\t" + "Сила атаки: " +
                attackPower + "\n" +
                "\t" + "Сила блока: " +
                blockPower + "\n";
    }
}
