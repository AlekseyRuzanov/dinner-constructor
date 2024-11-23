package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> listOfDishTypes = new HashMap<>();
    HashMap<Integer, ArrayList<String>> combo = new HashMap<>();
    ArrayList<String> listOfDishesForCombo = new ArrayList<>();
    ArrayList<String> listOfDishes;
    Random random = new Random();

    public void saveNewDish(String dishType, String dishName) {
        if (!listOfDishTypes.containsKey(dishType)) {
            listOfDishes = new ArrayList<>();
            listOfDishes.add(dishName);
            listOfDishTypes.put(dishType, listOfDishes);
        } else {
            listOfDishTypes.get(dishType).add(dishName);
        }
    }

    public void printDishTypes() {
        for (String category : listOfDishTypes.keySet()) {
            System.out.println(category);
        }
    }

    public void printCombo(int numberOfCombos, ArrayList<String> dishTypesForCombo) {
        int randomNumberOfDish;
        combo.clear();
        for (int i = 0; i < numberOfCombos; i++) {
            listOfDishesForCombo.clear();
            for (String type : dishTypesForCombo) {
                randomNumberOfDish = random.nextInt(listOfDishTypes.get(type).size());
                listOfDishesForCombo.add(listOfDishTypes.get(type).get(randomNumberOfDish));
            }
            combo.put(i, listOfDishesForCombo);
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo.get(i));
        }
    }
}

