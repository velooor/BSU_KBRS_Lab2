package by.bsu.zakharchenya;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server extends Thread {
    static final Logger LOGGER = LogManager.getLogger(Server.class);
    private Client client;


    @Override
    public void run(){
        try {
            LService uber = LService.getInstance();


            TimeUnit.MILLISECONDS.sleep((long)(50000));
            LOGGER.log(Level.INFO, client + " started the trip");



        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "");
        }
    }
}
