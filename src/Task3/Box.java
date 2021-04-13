package Task3;

import Task3.Fruit.Fruit;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private final ArrayList<F> box;
    private final F fruit;

    public Box(int size, F fruit) {
        box = new ArrayList<>(size);
        this.fruit = fruit;
        for (int i = 0; i < size; i++) {
            box.add(fruit);
        }
    }

    public double getWeight() {
        return box.size() * fruit.getWeight();
    }

    public boolean compare(Box<? extends Fruit> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    public void merge(Box<F> anotherBox){
        int count = anotherBox.getBox().size();
        for (int i = 0; i < count; i++) {
            box.add(anotherBox.getBox().get(0));
            anotherBox.getBox().remove(0);
        }
    }

    public void add(F fruit) {
        box.add(fruit);
    }

    public ArrayList<F> getBox() {
        return box;
    }
}
