package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu;
    ArrayList<String> dishes;

    DinnerConstructor() {
        menu = new HashMap<>();
    }

    public void saveNewDish(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        } else {
            if (menu.get(dishType).contains(dishName)) {
                System.out.println("Блюдо уже есть в этой категории меню");
            } else {
                menu.get(dishType).add(dishName);
            }
        }
    }
}
