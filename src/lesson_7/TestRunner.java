package lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    //Массив чисел для тестирования, используется для выполнения методов тестируемого класса
    static int[] testArray = {1, 2, 3, 4, 6, 1, 4, 8, 9, 5};

    public static void start(Class testClass) {

        final Method[] methods = testClass.getDeclaredMethods();

        int count = 0;//счетчик для @BeforeSuite и @AfterSuite

        //Сначала обрабатываю все методы с аннотацией @BeforeSuite
        for (Method method : methods) {

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation.annotationType().equals(BeforeSuite.class)) {
                    count++;
                    if (count > 1)
                        throw new RuntimeException(String.format("@BeforeSuite must be only one in test Class (You have: %d)", count));

                    try {
                        method.invoke(testClass.getDeclaredConstructor().newInstance(), TestRunner.testArray);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        //Обрабатываю все метды с аннотацией @Test
        for (Method method : methods) {

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation.annotationType().equals(Test.class)) {

                    try {
                        method.invoke(testClass.getDeclaredConstructor().newInstance(), TestRunner.testArray);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        //сбрасываю счетчик до 0 для подсчета аннотаций @AfterSuite
        count = 0;

        //Обрабатываю все метды с аннотацией @AfterSuite
        for (Method method : methods) {

            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {

                if (annotation.annotationType().equals(AfterSuite.class)) {
                    count++;
                    if (count > 1)
                        throw new RuntimeException(String.format("@AfterSuite must be only one in test Class (You have: %d)", count));

                    try {
                        method.invoke(testClass.getDeclaredConstructor().newInstance(), TestRunner.testArray);
                    } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}