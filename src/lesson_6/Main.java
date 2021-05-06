package lesson_6;

import java.util.*;

public class Main {
    private Main(){

    }

    public static void main(String[] args) {
        int[] arr1 = {5,3,4,2,7,6,4,4,3,1};
        int[] result1 = {3,1};
        int[] array1 = returnIntArrayUnderLast4(arr1);
        for (int numb: array1) {
            System.out.print(numb);
        }
    }

    /*
    Метод возвращает массив, полученный путем удаления чисел перед последней четверкой включительно.
     */

    public static int[] returnIntArrayUnderLast4 (int[] arrayOfNumbers){
        List<Integer> copy = new ArrayList<>();

        byte count = 0;
        for (int numb: arrayOfNumbers) {
            if (numb==4){
                count++;
            }
            copy.add(numb);
        }

        for (int i = 0; count!=1; i++) {
            if(copy.get(i)==4){
                count--;
            }
            copy.remove(i);
        }

        int[] result = new int[copy.size()];
        for (int i = 0; i < copy.size()-1; i++) {
            result[i] = copy.get(i);
        }

        return result;
    }
}
