package queue.queue;

public class Queue extends BuildQueue{
    //MAKE PRIVATE
    public BuildQueue queue;

    public Queue() {
        this.queue = new EmptyQueue();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Queue add(Object cargo) {
        queue = queue.add(cargo);
        return this;
    }

    public Object take() {
        return queue.take();
    }

    public Object head() {
        return queue.head();
    }

    public int size() {
        return queue.size();
    }

}
