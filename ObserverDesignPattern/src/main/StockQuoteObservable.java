package main;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madhuri on 5/11/17.
 */
public class StockQuoteObservable extends Observable {

    private StockEvent stockEvent;
    private ReentrantLock lockTQ;

    public StockQuoteObservable(){
        this.lockTQ=new ReentrantLock();
    }

    public void changeQuote(String t, float q) {
        lockTQ.lock();
        try {
            this.stockEvent = new StockEvent(t,q);
            this.setChanged();
        }finally {
            lockTQ.unlock();
        }
        this.notifyObserver(stockEvent);     //Open call

    }
}
