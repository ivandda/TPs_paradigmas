package queue.queue;

import java.util.ArrayList;

public class Queue {
    private ArrayList<Wrapper> listOfWrappers = new ArrayList<>();

    public Queue() {listOfWrappers.add(new EmptyWrapper());}

    public boolean isEmpty() {return firstNonEmptyWrapper().isEmpty();}

    public Queue add(Object cargo) {
        listOfWrappers.add(indexLastElemOfQueue(), newWrapperWithElement(cargo));
        return this;
    }

    public Object take() {
        Object toBeRemovedElement = this.head();
        listOfWrappers.remove(indexFirstElemOfQueue());
        return toBeRemovedElement;
    }

    public Object head() {return firstNonEmptyWrapper().getElement();}

    public int size() {return listOfWrappers.size() - 1;}

    private int indexFirstElemOfQueue() {return listOfWrappers.size() - 1;}

    private int indexLastElemOfQueue() {return 1;}

    private Wrapper firstNonEmptyWrapper() {return listOfWrappers.get(indexFirstElemOfQueue());}

    private WrapperWithElement newWrapperWithElement(Object cargo) {return new WrapperWithElement(cargo);}

}
