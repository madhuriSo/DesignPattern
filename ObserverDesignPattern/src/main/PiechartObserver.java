package main;


import java.util.concurrent.locks.ReentrantLock;

public class PiechartObserver implements Observer {
    private StockEvent arg;
    private ReentrantLock lockP;

    public PiechartObserver(){
        lockP=new ReentrantLock();
    }

    @Override
    public void update(Observable o, Object arg) {
        lockP.lock();
        try {
            this.arg = (StockEvent) arg;
            System.out.println(Thread.currentThread().getName()+" P Chart: "+ this.arg.getTicker() + "  " + this.arg.getQuote());
        }finally {
            lockP.unlock();
        }
    }
}