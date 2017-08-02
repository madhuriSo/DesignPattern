package main;

@FunctionalInterface
public interface Observer {

    public void update(Observable o, Object arg);

}
