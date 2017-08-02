package main;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madhuri on 2/18/17.
 */
public class Observable {
    private ArrayList<Observer> observers;
    private boolean changed;
    private ReentrantLock lockObs;

    public Observable(){
        observers = new ArrayList<Observer>();
        changed = false;
        lockObs = new ReentrantLock();
    }

    public void addObserver(Observer observer) {
        lockObs.lock();
        try {
            if (observer == null)
                throw new NullPointerException();
            if (!observers.contains(observer)) {
                this.observers.add(observer);
            }
        }finally {
            lockObs.unlock();
        }

    }

    public void deleteObserver(Observer observer){
        this.observers.remove(observer);
    }

    protected void setChanged(){
        lockObs.lock();
        this.changed=true;
        lockObs.unlock();

    }
    protected void clearChanged()
    {
        lockObs.lock();
        this.changed=false;
        lockObs.unlock();

    }
    public boolean hasChanged(){
        return this.changed;
    }

    public void notifyObserver(Object object) {
        lockObs.lock();
        Object[] arrLocal;
        try {
            if (!changed)
                return;
            arrLocal = observers.toArray();
            clearChanged();
        }finally {
            lockObs.unlock();
        }

            for (int i = arrLocal.length - 1; i >= 0; i--)
                ((Observer) arrLocal[i]).update(this, object); // Open call


    }
    }


