package org.example;

import java.util.Scanner;


public class Main {
    private static final String NAME_HERO = "Герой";
    private static final String NAME_MONSTER = "Монстер";
    private static final int BATTLE_PARAMETERS = 30;
    private static final int HEALTH_PARAMETERS = 30;
    public static Hero hero = new Hero(NAME_HERO,
            getRandomParam(BATTLE_PARAMETERS),
            getRandomParam(BATTLE_PARAMETERS),
            getRandomParam(HEALTH_PARAMETERS));
    public static Monster monster = new Monster(NAME_MONSTER,
            getRandomParam(BATTLE_PARAMETERS),
            getRandomParam(BATTLE_PARAMETERS),
            getRandomParam(HEALTH_PARAMETERS));
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Герой: %n%s%n", hero);
        System.out.printf("Монстр: %n%s%n", monster);
        startGame();
        System.out.println("БИТВА ЗАВЕРШЕНА!");
    }

    public static void startGame() {
        while (true) {

            System.out.println("Введите команду на исполнение: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            if (input.equals("ударить")) {
                hero.attack(monster);
                if (monster.getHealth() <= 0) {
                    System.out.println(hero.getName() + " победил " + monster.getName());
                    break;
                }
            } else if (input.equals("лечить")) {
                hero.healing();
            } else {
                System.out.println("УПС!!! Miss click...");
            }

            System.out.println("Ход монстра");
            monster.attack(hero);
            if (hero.getHealth() <= 0) {
                System.out.println(monster.getName() + " победил " + hero.getName());
                break;
            }
        }
    }

    private static int getRandomParam(int number) {
        return (int) (Math.random() * number) + 1;
    }
}