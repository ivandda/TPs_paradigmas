package queue.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueRefactoredTest{

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(new Queue().isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queueWithElements(oneElement).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(firstElement, queueWithElements(oneElement).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = queueWithElements(oneElement);
        queue.take();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        Queue queue = queueWithElements(oneElement);

        assertEquals(firstElement, queue.take());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = queueWithElements(twoElements);

        assertEquals(queue.take(), firstElement);
        assertEquals(queue.take(), secondElement);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        Queue queue = queueWithElements(twoElements);

        assertEquals(queue.head(), firstElement);
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        Queue queue = queueWithElements(oneElement);
        assertEquals(1, queue.size());
        queue.head();
        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, queueWithElements(twoElements).size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        try {
            queue.take();
            fail("Expected Error was not thrown.");
        } catch (Error e) {
            assertTrue(e.getMessage().equals("Queue is empty"));
        }
    }

    @Test
    public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = queueWithElements(oneElement);
        queue.take();
        try {
            queue.take();
            fail("Expected Error was not thrown.");
        } catch (Error e) {
            assertTrue(e.getMessage().equals("Queue is empty"));
        }
    }

    @Test
    public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        try {
            queue.head();
            fail("Expected Error was not thrown.");
        } catch (Error e) {
            assertTrue(e.getMessage().equals("Queue is empty"));
        }
    }

    private Queue queueWithElements(Object[] elements) {
        Queue queue = new Queue();
//        elements.stream().forEach

        for (Object element : elements) {
            queue.add(element);
        }
        return queue;
    }

    private String firstElement = "First";
    private String secondElement = "Second";
    private String[] oneElement= new String[] {firstElement};
    private String[] twoElements= new String[] {firstElement, secondElement };


}