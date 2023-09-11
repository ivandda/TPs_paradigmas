package queue.queue;

public abstract class BuildQueue {
    public abstract boolean isEmpty();

    public abstract BuildQueue add(Object cargo);

    public abstract Object take();

    public abstract Object head();

    public abstract int size();

}
