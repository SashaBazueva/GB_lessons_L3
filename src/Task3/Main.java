package Task3;

import Task3.Fruit.Apple;
import Task3.Fruit.Orange;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>(7, new Apple());
        Box<Orange> box2 = new Box<>(4, new Orange());

        System.out.println("box with oranges: " + box2.getWeight());  //вывод веса коробок
        System.out.println("box with apples: " + box1.getWeight());   //

        System.out.println("Equals? " + box1.compare(box2));          //сравнение веса коробок

        Box<Orange> forMerge = new Box<>(3, new Orange());
        box2.merge(forMerge);                                                    //пересыпать фрукты в одну коробку с удалением второй коробки
        System.out.println("box with oranges after merge: " + box2.getWeight()); //

        box1.add(new Apple());                                                          //добавление фрукта
        System.out.println("box with apples after adding apple: " + box1.getWeight());  //
    }
}