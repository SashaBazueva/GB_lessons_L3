package lesson_4;

public class Printer {
    private boolean isA = true;
    private boolean isB = false;

    public void print(char ch, int count) {
        synchronized (this) {

            for (int i = 0; i < count; i++) {
                while (isA) {
                    if (ch == 'A') {
                        System.out.print(ch);
                        isA = false;
                        isB = true;
                        notify();
                    }
                    if (ch != 'A') {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                while (isB) {
                    if (ch == 'B') {
                        System.out.print(ch);
                        isA = true;
                        isB = false;
                        notify();
                    }
                    if (ch != 'B') {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }

}
