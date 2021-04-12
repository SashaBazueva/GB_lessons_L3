package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        List<String> example = new LinkedList<>();
        example.add("first");
        example.add("second");
        example.add("third");
        System.out.println(example);

        swapElements(example, 0, 1);
        System.out.println(example);

        //Задание 2
        Integer[] numbers = {5,14,66,83,1,39};
        ArrayList<Integer> numbersCopy = makeIntoArrayList(numbers);
    }
    public static <T> void swapElements(List<T> array, int o1, int o2){
        T per1 = array.get(o1);
        T per2 = array.get(o2);
        array.set(o1,per2);
        array.set(o2,per1);
    }
    public static <T> ArrayList<T> makeIntoArrayList (T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
