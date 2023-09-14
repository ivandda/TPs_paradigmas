package queue.queue;

import java.util.ArrayList;

public class Queue {
    // Change name of queue to queueOfWrappers?
    private ArrayList<Wrapper> queue = new ArrayList<>();

    public Queue() {
        queue.add(new EmptyWrapper());
    }

    public boolean isEmpty() {
        return firstWrapper().isEmpty();
    }

    public Queue add(Object cargo) {
        queue.add(indexLastElement(), newWrapperWithElement(cargo));
        return this;
    }

    public Object take() {
        Object removedElement = this.head();
        queue.remove(indexFirstElement());
        return removedElement;
    }

    public Object head() {
        return firstWrapper().head();
    }

    public int size() {return queue.size() - 1;}

    private int indexFirstElement() {return queue.size() - 1;}

    private int indexLastElement() {return 1;}

    private Wrapper firstWrapper() {return queue.get(indexFirstElement());}

    private WrapperWithElement newWrapperWithElement(Object cargo) {return new WrapperWithElement(cargo);}

}
