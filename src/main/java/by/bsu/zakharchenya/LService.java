package by.bsu.zakharchenya;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LService {
    private static LService instance;
    private static AtomicBoolean flag = new AtomicBoolean();
    private static Lock locker = new ReentrantLock();
    static final String INPUT = "input/carsData.txt";


    private LService() {
    }

    public static LService getInstance() {
        if (!flag.get()) {
            locker.lock();
            try {
                if (instance == null) {
                    instance = new LService();
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }

    public static void launch(){
        Server.getInstance().start();
    }

}
