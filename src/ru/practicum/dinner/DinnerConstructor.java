package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    ArrayList<String> dishes;
    Random random = new Random();
    HashMap<Integer, ArrayList<String>> combo = new HashMap<>();
    ArrayList<String> dishesForCombo = new ArrayList<>();

    DinnerConstructor() {
        menu = new HashMap<>();
    }

    public void saveNewDish(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        } else {
            menu.get(dishType).add(dishName);
        }
    }

    public void printDishTypes() {
        for (String category : menu.keySet()) {
            System.out.println(category);
        }
    }

    public void printCombo(int numberOfCombos, ArrayList<String> dishTypesForCombo) {
        int randomNumberOfDish;
        combo.clear();
        for (int i = 0; i < numberOfCombos; i++) {
            dishesForCombo.clear();
            for (String type : dishTypesForCombo) {
                randomNumberOfDish = random.nextInt(menu.get(type).size());
                dishesForCombo.add(menu.get(type).get(randomNumberOfDish));
            }
            combo.put(i, dishesForCombo);
            System.out.println("Комбо " + (i+1));
            System.out.println(combo.get(i));
        }
    }
}

