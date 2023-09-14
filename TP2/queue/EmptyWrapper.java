package queue.queue;

public class EmptyWrapper extends Wrapper {

    public boolean isEmpty() {
        return true;
    }


    public Object getElement() {
        throw new Error("Queue is empty");
    }


}
