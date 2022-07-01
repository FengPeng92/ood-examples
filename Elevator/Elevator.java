package Elevator;

import java.util.PriorityQueue;

enum Location {
    INSIDE, 
    OUTSIDE
}

enum Direction {
    UP, 
    DOWN, 
    IDLE
}

class Request {
    int curFloor;
    int desireFloor;
    Direction dir;
    Location location;

    public Request(int curFloor, int desireFloor, Direction dir, Location location) {
        this.curFloor = curFloor;
        this.desireFloor = desireFloor;
        this.dir = dir;
        this.location = location;
    }
}

class Elevator {
    int currentFloor;
    Direction dir;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int curFloor) {
        this.currentFloor = curFloor;
        this.dir = Direction.IDLE;
        upQueue = new PriorityQueue<>((a, b) -> a.desireFloor - b.desireFloor);
        downQueue = new PriorityQueue<>((a, b) -> b.desireFloor - a.desireFloor);
    }

    public void sendUpRequest(Request up) {

    }

    public void sendDownRequest(Request down) {

    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }
        this.dir = Direction.IDLE;
    }

    public void processRequests() {
        if (this.dir == Direction.UP|| this.dir == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    public void processUpRequest() {
        while(!upQueue.isEmpty()) {
            Request up = upQueue.poll();
            this.currentFloor = up.desireFloor;

        }

        if (!downQueue.isEmpty()) {
            this.dir = Direction.DOWN;
        } else {
            this.dir = Direction.IDLE;
        }

    }

    public void processDownRequest() {
        while(!downQueue.isEmpty()) {
            Request down = downQueue.poll();
            this.currentFloor = down.desireFloor;

        }

        if (!upQueue.isEmpty()) {
            this.dir = Direction.UP;
        } else {
            this.dir = Direction.IDLE;
        }
    }
}

