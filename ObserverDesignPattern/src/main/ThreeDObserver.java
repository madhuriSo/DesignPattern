package main;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madhuri on 5/11/17.
 */
public class ThreeDObserver implements Observer {

    private StockEvent arg;
    private ReentrantLock lock3D;

    public ThreeDObserver(){
        this.lock3D=new ReentrantLock();
    }

    @Override
    public void update(Observable o, Object arg) {
        lock3D.lock();
        try {
            this.arg = (StockEvent) arg;
            System.out.println(Thread.currentThread().getName()+" 3 D   : "+ this.arg.getTicker() + "  " + this.arg.getQuote());
        }finally {
            lock3D.unlock();
        }

    }
}
