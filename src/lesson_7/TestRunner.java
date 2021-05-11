package lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    static int[] testArray = {1, 2, 3, 4, 6, 1, 4, 8, 9, 5};

    public static void start(Class testClass) {

        new Thread(new Clazz(testClass)).start();
//        new Thread(new Clazz(testClass)).start();
//        new Thread(new Clazz(testClass)).start();
    }
}
class Clazz implements Runnable{

    Class testClass;

    public Clazz(Class testClass) {
        this.testClass = testClass;
    }

    @Override
    public void run() {
        final Method[] methods = testClass.getDeclaredMethods();

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
    }
}
