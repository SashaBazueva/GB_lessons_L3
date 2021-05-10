package lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private Main() {

    }

    /*
    Метод возвращает массив, полученный путем удаления чисел перед последней четверкой включительно.
     */

    public static int[] returnIntArrayAfterLast4(int[] arrayOfNumbers) {
        List<Integer> copy = new ArrayList<>();

        byte count = 0;
        for (int numb : arrayOfNumbers) {
            if (numb == 4) {
                count++;
            }
            copy.add(numb);
        }
        if (count == 0) {
            throw new RuntimeException("Array doesn't contain number 4");
        }

        int ind = 0;
        do {
            if (copy.get(ind) == 4) {
                count--;
            }
            copy.remove(ind);
        } while (count > 0);

        int[] result = new int[copy.size()];
        for (int i = 0; i < copy.size(); i++) {
            result[i] = copy.get(i);
        }

        return result;
    }

    /*
    Метод возвращает:
    true - если в массиве есть минимум одна еденица и одна четверка,
    false - если в массиве нет хоть одной четверки или единицы.
     */
    public static boolean checkIntArrayOnPresence1And4(int[] arrayOfNumbers) {
        boolean hasOne = false;
        boolean hasFour = false;
        for (int numb : arrayOfNumbers) {
            if (numb == 1) {
                hasOne = true;
            }
            if (numb == 4) {
                hasFour = true;
            }
        }

        return hasOne && hasFour;
    }
}
