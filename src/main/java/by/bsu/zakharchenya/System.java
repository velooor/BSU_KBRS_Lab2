package by.bsu.zakharchenya;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class System {
    private static System instance;
    private static AtomicBoolean flag = new AtomicBoolean();
    private static Lock locker = new ReentrantLock();
    static final String INPUT = "input/carsData.txt";


    private System() {
    }

    public static System getInstance() {
        if (!flag.get()) {
            locker.lock();
            try {
                if (instance == null) {
                    instance = new UberSevice();
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

}
