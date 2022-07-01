package AmazonLocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// one locker
class Locker {
    int code;
    int size;
    boolean status; 

    public Locker(int code, int size) {
        this.code = code;
        this.size = size;
        this.status = false;
    }
}

// a group of lockers with the same size
class LockerCollection {
    Queue<Locker> queue;
    List<Locker> list;

    public LockerCollection(int numbers, int size) {
        list = new ArrayList<>();
        for (int i = 0; i < numbers; i++) {
            list.add(new Locker(i, size));
        }
        queue = new LinkedList<>(list);
    }

    public boolean hasLocker() {
        return queue.size() > 0;
    }

    public Locker getLocker() {
        return queue.poll();
    }

    public void addToQueue(Locker locker) {
        queue.add(locker);
    }
    
}

public class AmazonLocker {

    LockerCollection[] lockers;
    Map<Integer, Locker> map;

    public AmazonLocker() {
        lockers = new LockerCollection[3];
        lockers[0] = new LockerCollection(10, 1);
        lockers[1] = new LockerCollection(10, 2);
        lockers[2] = new LockerCollection(10, 3);
        map = new HashMap<>();
    }    
    public int findOptimalLocker(int size) {
        for (int i = size; i <= 3; i++) {
            if (lockers[i - 1].hasLocker()) {
                Locker newLocker = lockers[i].getLocker();
                newLocker.status = true;
                map.put(newLocker.code, newLocker);
                return newLocker.code;
            }
        }

        return -1;
    }

    public void pickUp(int code) {
        if (map.containsKey(code)) {
            Locker pickBox = map.get(code);
            pickBox.status = false;
            map.remove(code);
            lockers[pickBox.size - 1].addToQueue(pickBox);
        }

    }

    class Package {
        int size;
    }
    
}
