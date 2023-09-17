package queue.queue;

public class EmptyWrapper extends Wrapper {

    public static String message_empty_queue = "Queue is empty";

    public Object getElement() {
        throw new Error(message_empty_queue);
    }

}
