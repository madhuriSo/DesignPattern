package main;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madhuri on 5/11/17.
 */
public class TableObserver  implements Observer{

    private StockEvent arg;
    private ReentrantLock lockT;

    public TableObserver(){
        this.lockT=new ReentrantLock();
    }

    @Override
    public void update(Observable o, Object arg) {
        lockT.lock();
        try {
            this.arg = (StockEvent) arg;
            System.out.println(Thread.currentThread().getName()+" Table :  "+ this.arg.getTicker() + "  " + this.arg.getQuote());
        }finally {
            lockT.unlock();
        }

    }
}
