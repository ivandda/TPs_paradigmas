package queue.queue;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Wrapper> listOfWrappers = new ArrayList<>();

    public Queue() {
        listOfWrappers.add(new EmptyWrapper());
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Queue add(Object cargo) {
        listOfWrappers.add(indexLastElemOfQueue(), newWrapperWithElement(cargo));
        return this;
    }

    public Object take() {
        Object toBeRemovedElement = this.head();
        listOfWrappers.remove(size());
        return toBeRemovedElement;
    }

    public Object head() {
        return listOfWrappers.get(size()).getElement();
    }

    public int size() {
        return listOfWrappers.size() - 1;
    }

    private int indexLastElemOfQueue() {return 1;}

    private Wrapper newWrapperWithElement(Object cargo) {return new Wrapper(cargo);}

}
