package main;
/**
 * Created by Madhuri on 2/18/17.
 */
public class Driver {
    public static void main(String args[]) throws InterruptedException{

        PiechartObserver piechartObserver = new PiechartObserver();
        TableObserver tableObserver = new TableObserver();
        ThreeDObserver threeDObserver = new ThreeDObserver();
        StockQuoteObservable stock = new StockQuoteObservable();

        stock.addObserver(piechartObserver);
        stock.addObserver(threeDObserver);
        stock.addObserver(tableObserver);

        StockRunnable stockRunnable = new StockRunnable(stock);

        Thread t1=new Thread(stockRunnable);
        Thread t2=new Thread(stockRunnable);
        Thread t3=new Thread(stockRunnable);

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(10);
        //Two Step Thread Termination: 
	// 1. Interrupt the thread 
	// 2. Set Done which terminates thread
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

        stockRunnable.setDone();

	// First Check if thread is terminated then only exit(get back into main thread)
        t1.join();
        t2.join();
        t3.join();

        System.out.println("_________Done__________");
    }

}
