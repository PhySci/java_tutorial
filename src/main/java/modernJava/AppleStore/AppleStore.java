package modernJava.AppleStore;

import java.util.List;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

enum Color {
    RED,
    GREEN,
    YELLOW,
    BLACK,
    WHITE
}

class Apple {
    private Color color;
    private Integer weight;

    public Apple(Color color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return this.color.toString();
    }

    public Integer getWeight() {
        return this.weight;
    }
}

public class AppleStore {

    private static List<Apple> shelf = new ArrayList<>();

    public static void main(String[] args) {

        shelf.add(new Apple(Color.RED, 500));
        shelf.add(new Apple(Color.GREEN, 100));

        for (Apple app: shelf) {
            System.out.println("Color: " + app.getColor() + ". Weight: " + app.getWeight().toString()); ;
        }

        List<Apple> heavyApple =
                shelf.stream()
                     .filter((Apple app) -> app.getWeight() > 150)
                     .collect(toList());

        for (Apple app: heavyApple) {
            System.out.println(app.getWeight());
        }
    }

}
