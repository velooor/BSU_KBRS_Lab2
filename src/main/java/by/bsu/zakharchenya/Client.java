package by.bsu.zakharchenya;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by Linaelias Velore on 20.10.2017.
 */
public class Client extends Thread {
    static final Logger LOGGER = LogManager.getLogger(Server.class);

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
