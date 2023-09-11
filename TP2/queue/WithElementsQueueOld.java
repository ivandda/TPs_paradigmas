package queue.queue;

public class WithElementsQueueOld extends BuildQueue {
    //CHANGE TO PRIVATE
    public Object headElement;
    public BuildQueue tailElements;

    public WithElementsQueueOld(Object headElement, BuildQueue tailElements){
        this.headElement = headElement;
        this.tailElements = tailElements;
    }

    public boolean isEmpty() {
        return false;
    }

    public BuildQueue add( Object  cargo ) {
        return new WithElementsQueueOld(cargo, this);
    }

    public Object take() {
        return new WithElementsQueueOld(null,this);
    }

    public Object head() {
        return this.headElement;
    }

    public int size() {
        return tailElements.size() + 1;
    }
}
