package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static ArrayList<String> dishTypesForCombo;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        dishTypesForCombo = new ArrayList<>();


        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        // добавьте новое блюдо
        dc.saveNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        dishTypesForCombo.clear();
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        System.out.println("Доступные типы блюд: ");
        System.out.println();
        dc.printDishTypes();
        String nextItem;

        //реализуйте ввод типов блюд
        while (true) {
            nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            } else if (!dc.checkType(nextItem)) {
                System.out.println("Такого типа блюда не существует. Введите другой тип");
            } else {
                dishTypesForCombo.add(nextItem);
            }
        }

        // сгенерируйте комбинации блюд и выведите на экран
        dc.printCombo(numberOfCombos, dishTypesForCombo);


    }
}
