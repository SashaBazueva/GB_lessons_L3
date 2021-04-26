package lesson_4;

public class Printer implements Runnable {
    char letter;

    public Printer(char letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print(letter);
        }
    }

}
