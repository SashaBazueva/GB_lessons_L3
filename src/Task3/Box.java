package Task3;

import Task3.Fruit.*;

import java.util.ArrayList;

public class Box {
    private int size;
    private double weight;
    private ArrayList<Fruit> box;

    public Box(int size, Apple apple) {
        this.size = size;
        box = new ArrayList(this.size);
        box.stream().forEach(fruit -> box.add(new Apple()));
    }

    public Box(int size, Orange orange) {
        this.size = size;
        box = new ArrayList(this.size);
        box.stream().forEach(fruit -> box.add(new Orange()));
    }


    public double getWeight() {
        weight = box.size() * box.get(0).getWeight();
        return weight;
    }
}
