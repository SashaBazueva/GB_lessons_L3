import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch count;
    private CyclicBarrier barrierForStarting;
    static volatile boolean isWinner = true;//to check winner of the race
    private Lock lock;

    public Car(Race race, int speed, CountDownLatch count, CyclicBarrier barrierForStarting, Lock lock) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

        //initialize CountDownLatch and CycleBarrier and ReentrantLock
        this.count = count;
        this.barrierForStarting = barrierForStarting;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrierForStarting.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        lock.lock();//set lock to check only one thread in time
        if (isWinner){
            System.out.println("WINNER: " + name);
            isWinner = false;
        }
        lock.unlock();
        //Decrement CountDownLatch
        count.countDown();
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}