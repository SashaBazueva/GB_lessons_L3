package lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void shouldDeleteAllNumbersBeforeFourAndFour() {
        int[] arr1 = {5,3,4,2,7,6,4,4,3,1};
        int[] result1 = {3,1};
        Assertions.assertArrayEquals(result1, Main.returnIntArrayUnderLast4(arr1));

        int[] arr2 = {1,4,3,5,2,6,4,4,0,2,3};
        int[] result2 = {0,2,3};
        Assertions.assertArrayEquals(result2, Main.returnIntArrayUnderLast4(arr2));
    }
}
