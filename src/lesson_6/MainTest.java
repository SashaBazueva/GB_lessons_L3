package lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void shouldDeleteAllNumbersInArrayExceptNumbersAfterLastFour() {
        int[] arr1 = {5, 3, 4, 2, 7, 6, 4, 4, 3, 1};
        int[] result1 = {3, 1};
        Assertions.assertArrayEquals(result1, Main.returnIntArrayAfterLast4(arr1));

        int[] arr2 = {1, 4, 3, 5, 2, 6, 4, 4, 0, 2, 3};
        int[] result2 = {0, 2, 3};
        Assertions.assertArrayEquals(result2, Main.returnIntArrayAfterLast4(arr2));

        int[] arr3 = {4, 4, 2, 5, 4, 3, 6, 4, 0, 8, 1};
        int[] result3 = {0, 8, 1};
        Assertions.assertArrayEquals(result3, Main.returnIntArrayAfterLast4(arr3));

        int[] arr4 = {4, 4, 4, 4, 4, 4};
        int[] result4 = new int[0];
        Assertions.assertArrayEquals(result4, Main.returnIntArrayAfterLast4(arr4));
    }

    @Test
    public void shouldThrowRunTimeExceptionIfArrayDoesNotContainNumberFour() {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 0};
        Assertions.assertThrows(RuntimeException.class, () -> Main.returnIntArrayAfterLast4(arr));
    }

    @Test
    public void shouldCheckIfArrayHasNumbersOneAndFour() {
        int[] arr1 = {5, 3, 4, 2, 7, 6, 4, 4, 3, 1};
        Assertions.assertTrue(Main.checkIntArrayOnPresence1And4(arr1));

        int[] arr2 = {1, 4, 3, 5, 2, 6, 4, 4, 0, 2, 3};
        Assertions.assertTrue(Main.checkIntArrayOnPresence1And4(arr2));

        int[] arr3 = {4, 4, 2, 5, 4, 3, 6, 4, 0, 8};
        Assertions.assertFalse(Main.checkIntArrayOnPresence1And4(arr3));

        int[] arr4 = {4, 4, 4, 4, 4, 4};
        Assertions.assertFalse(Main.checkIntArrayOnPresence1And4(arr4));
    }
}
