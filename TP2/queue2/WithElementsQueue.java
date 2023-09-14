package queue.queue2;

import queue.queue.EmptyQueue;

import java.util.LinkedList;

public class WithElementsQueue extends BuildQueue {
    private LinkedList<Object> elements = new LinkedList<>();

    public WithElementsQueue(Object headElement) {

        this.elements.add(headElement);

    }

    public boolean isEmpty() {
        return false;
    }

    public BuildQueue add(Object cargo) {
        elements.addFirst(cargo);
        return this;
    }

    public Object take() {
        return elements.removeLast();
    }

    public Object head() {
        return elements.getLast();
    }

    public int size() {
        return this.elements.size();
    }

}
