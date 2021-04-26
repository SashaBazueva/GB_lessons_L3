package lesson_4;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int count = 5;

        final Thread a = new Thread(() -> printer.print('A', count));

        final Thread b = new Thread(() -> printer.print('B', count));

        final Thread c = new Thread(() -> printer.print('C', count));

        a.start();
        b.start();
        c.start();

    }
}
