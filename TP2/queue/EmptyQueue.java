package queue.queue;

public class EmptyQueue extends BuildQueue {
    public boolean isEmpty() {
        return true;
    }

    public BuildQueue add(Object cargo) {
        return new WithElementsQueue(cargo);
    }

    public Object take() {
        throw new RuntimeException("Queue is empty");
    }

    public Object head() {
        throw new RuntimeException("Queue is empty");
    }

    public int size() {
        return 0;
    }


}