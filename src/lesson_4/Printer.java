package lesson_4;

public class Printer {
    private boolean isA = true;
    private boolean isB = false;
    private boolean isC = false;

    public void print(char ch, int count) {
        synchronized (this) {
            for (int i = 0; i < count; i++) {
                while (isA) {
                    if (ch == 'A') {
                        System.out.print(ch);
                        isA = false;
                        isB = true;
                        notifyAll();
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
                        isB = false;
                        isC = true;
                        notifyAll();
                    }
                    if (ch != 'B') {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                while (isC) {
                    if (ch == 'C') {
                        System.out.print(ch);
                        isC = false;
                        isA = true;
                        notifyAll();
                    }
                    if (ch != 'C') {
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
