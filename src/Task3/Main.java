package Task3;

import Task3.Fruit.Apple;
import Task3.Fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Box<Apple> box = new Box<>(5, apple);

    }
}