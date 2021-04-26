package lesson_4;

//Создать три потока, каждый из которых выводит определенную букву (A, B и C)
//5 раз (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        final Thread a = new Thread(() -> {
            printer.print('A', 5);
        });

        final Thread b = new Thread(() -> {
            printer.print('B', 5);
        });

        a.start();
        b.start();

    }
}
