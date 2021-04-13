package Task3;

import Task3.Fruit.*;

import java.util.ArrayList;

public class Box<F> {
    private int size;
    private double weight;
    private ArrayList<Fruit> box;
    private Fruit fruit;

    public Box (int size, F fruit) {
        String classInfo = fruit.getClass().toString();
        try {
            this.fruit = (Fruit) fruit;
            this.size = size;
            box = new ArrayList(this.size);
            int count = 0;
            while(count<size){
                box.add(this.fruit);
                count++;
            }
        }catch(ClassCastException e){
            throw new RuntimeException(String.format("Can't pull this object in the box: %s", classInfo), e);
        }
    }

    public double getWeight() {
        weight = box.size() * fruit.getWeight();
        return weight;
    }
}
