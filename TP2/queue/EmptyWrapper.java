package queue.queue;

public class EmptyWrapper extends Wrapper {

    public boolean isEmpty() {
        return true;
    }

//    public Queue add(Object cargo) {return true;}

    public Object take() {
        throw new Error("Queue is empty");
    }

    public Object head() {
        throw new Error("Queue is empty");
    }

//    public int size() {return 0;}
}
