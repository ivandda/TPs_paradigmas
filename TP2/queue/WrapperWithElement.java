package queue.queue;

public class WrapperWithElement extends Wrapper {
    public final Object element;

    public WrapperWithElement(Object element) {
        this.element = element;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object take() {
        return this.element;
    }

    public Object head() {
        return this.element;
    }

}
