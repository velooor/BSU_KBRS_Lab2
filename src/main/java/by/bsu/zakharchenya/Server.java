package by.bsu.zakharchenya;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server extends Thread {
    static final Logger LOGGER = LogManager.getLogger(Server.class);

    private static Server instance;
    private static AtomicBoolean flag = new AtomicBoolean();
    private static Lock locker = new ReentrantLock();

    private List<Client> clients;

    private Server() {
        clients = new ArrayList<>();
    }

    public static Server getInstance() {
        if (!flag.get()) {
            locker.lock();
            try {
                if (instance == null) {
                    instance = new Server();
                }
            } finally {
                locker.unlock();
            }
        }
        return instance;
    }


    @Override
    public void run(){
        try {
            LService uber = LService.getInstance();


            TimeUnit.MILLISECONDS.sleep((long)(50000));
            LOGGER.log(Level.INFO, " started the trip");



        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "");
        }
    }
}
