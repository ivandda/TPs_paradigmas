package queue.queue;

public class EmptyWrapper extends Wrapper {

    public static String MESSAGE_EMPTY_QUEUE = "Queue is empty";
    public boolean isEmpty() {
        return true;
    }

    public Object getElement() {
        throw new Error(MESSAGE_EMPTY_QUEUE);
    }

}
