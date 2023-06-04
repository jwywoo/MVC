package org.example;

import java.util.List;
import java.util.Objects;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    public MenuItem choose(String chosenMenu) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(chosenMenu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("N/A menu item"));
    }
}
