package queue.queue;

import java.util.ArrayList;
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
        elements.add(cargo);
        return this;
    }

    public Object take() {
        return elements.remove(0);
    }

    public Object head() {
        return elements.get(0);
    }

    public int size() {
        return this.elements.size();
    }

}
