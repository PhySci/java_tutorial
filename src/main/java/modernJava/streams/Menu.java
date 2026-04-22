package modernJava.streams;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;


class Dish {
    private Integer id;
    private Integer calories;
    private String name;
    private Boolean isVegeterian;
    private Type type;

    public Dish(Integer id, Integer calories, boolean vegeterian, Type type) {
        this.id = id;
        this.setCalories(calories);
        this.name = UUID.randomUUID().toString();
        this.isVegeterian = vegeterian;
        this.type = type;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getName() {
        return "Dish " + this.id.toString() + ". Name: " + this.name;
    }

    public Boolean isVegeterian() {
        return this.isVegeterian;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return name + " " + this.getCalories().toString();
    }

    public enum Type {MEAT, OTHER, FISH}
}


public class Menu {

    public static void main(String[] args) {

        Random rnd = new Random();
        ArrayList<Dish> menu = new ArrayList<>();

        for (int i=0; i <= 100; i++) {
            Integer cal = rnd.nextInt(1000);
            menu.add(new Dish(i, cal, false, Dish.Type.MEAT));
        }

//        for (Dish dish: menu) {
//            System.out.println(dish.getName() + " " + dish.getCalories().toString());
//        }

        // sort low calories dishes

//        List<String> lowCaloriesDishesName =
//                menu.stream()
//                        .filter(d -> d.getCalories() < 400)
//                        .sorted(comparing(Dish::getCalories))
//                        .map(Dish::getName)
//                        .collect(toList());
//        for (String dishName: lowCaloriesDishesName) {
//            System.out.println(dishName);
//        }



//        List<Dish> threeHighCaloricDishNames =
//                menu.stream();
//                        .sorted(comparing(Dish::getCalories))
                        //.map(Dish::getName)
//                        .limit(3)
//                        .collect(toList());

//        for (Dish dishName: threeHighCaloricDishNames) {
//            System.out.println(dishName);
//        }
//        Stream<Dish> dishStream = menu.stream();
//        Iterator<Dish> iterator = dishStream.iterator();
//
//        while (iterator.hasNext()) {
//            Dish nextDish = iterator.next();
//            System.out.println(nextDish.getName());
//        }

        List<String> testList = menu.stream()
                .filter(dish -> {
                    System.out.println("Filtering :" + dish.getId().toString());
                    return dish.getCalories() > 0;
                })
                .map(dish -> {
                    System.out.println("Mapping: " + dish.getId().toString());
                    return dish.getName();
                })
                .limit(5)
                .collect(toList());

        for (String dishName: testList) {
            System.out.println(dishName);
        }
    }
}
