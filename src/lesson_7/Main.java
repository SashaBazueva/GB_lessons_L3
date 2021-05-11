package lesson_7;

public class Main {
    public static void main(String[] args) {
        TestRunner.start(Main.class);
    }

    @BeforeSuite
    public void printArray(int[] arrayOfNumbers) {
        System.out.print("{ ");
        for (int i = 0; i < arrayOfNumbers.length - 1; i++) {
            System.out.print(arrayOfNumbers[i] + ", ");
        }
        System.out.print(arrayOfNumbers[arrayOfNumbers.length - 1] + " } ");
    }

    @Test
    public void countQuantity(int[] arrayOfNumbers) {
        System.out.println("Длина тестируемого массива: " + arrayOfNumbers.length);
    }

    @Test
    public void checkIfContainTwo(int[] arrayOfNumbers) {
        boolean hasTwo = false;
        for (int number : arrayOfNumbers) {
            if (number == 2) {
                hasTwo = true;
                System.out.println("Содержит двойку: " + hasTwo);
                break;
            }
        }
        if (!hasTwo) {
            System.out.println("Содержит двойку: " + hasTwo);
        }
    }

    @AfterSuite
    public void calculateSum(int[] arrayOfNumbers) {
        int sum = 0;
        for (int number : arrayOfNumbers) {
            sum += number;
        }
        System.out.println("Сумма чисел массива: " + sum);
    }

}
