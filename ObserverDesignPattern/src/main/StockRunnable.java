package main;

import java.util.Random;

/**
 * Created by Madhuri on 5/11/17.
 */
public class StockRunnable implements Runnable {
    private StockQuoteObservable stock;
    private boolean done;
    public StockRunnable(StockQuoteObservable stock){
        this.stock=stock;
        this.done=false;
    }

    @Override
    public void run() {
        float quote;
        Random r = new Random(5);
        while (!done) {

            quote = r.nextFloat() * 30;
            stock.changeQuote("Tesla",quote );

        }
    }


    public void setDone(){
        this.done=true;
    }
}
