package Task3;

import Task3.Fruit.Apple;
import Task3.Fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        Box box = new Box(4, apple);
        System.out.println(box.getWeight());
    }
}
