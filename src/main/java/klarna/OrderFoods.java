package klarna;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class OrderFoods {
    private static int MENU_INDEX = 0;
    private static String EXCLUSION_SYMBOL = "-";
    static HashMap<String, TreeSet<String>> menu = new HashMap<>();

    public static String ingredients(String order) {
        initialiseMenu();

        List<String> line = Arrays.asList(order.split(","));
        List<String> ingredientList = line.subList(1, line.size());
        TreeSet<String> ingredients = menu.get(line.get(MENU_INDEX));
        if(Objects.nonNull(ingredients)) {
            for(String ingredient : ingredientList) {
                if(StringUtils.isEmpty(ingredient)) {
                    continue;
                }

                if(isToExclude(ingredient)) {
                    ingredients.remove(ingredient.substring(1));
                } else if (!ingredients.contains(ingredient)) {
                    throw new IllegalArgumentException("Ingredient=" + ingredient + " is invalid for Menu=" + line.get(MENU_INDEX) + "!");
                }
            }

        } else {
            throw new IllegalArgumentException("Menu=" + line.get(MENU_INDEX) + " is invalid!");
        }

        return ingredients.stream()
            .collect(Collectors.joining(","));
    }

    private static boolean isToExclude(String ingredient) {
        return EXCLUSION_SYMBOL.equals(Character.toString(ingredient.charAt(0)));
    }

    private static void initialiseMenu() {
        menu.put("Classic", new TreeSet<>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
        menu.put("Freezie", new TreeSet<>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
        menu.put("Greenie", new TreeSet<>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
        menu.put("Just Desserts", new TreeSet<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));
    }
}
