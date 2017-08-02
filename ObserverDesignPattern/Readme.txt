Thread safe Observer Design Pattern

I have created three threads in the main method.Build file to execute.
Per thread 3 notification (Piechart, threeD, Table)

Added open call in
1) StockQuoteObservable class to call notifyObserver() method
2) Observable class to call update() method
