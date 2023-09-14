package queue.queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class QueueAdditionalTest {

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(queueWith(ceroElements).isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queueWith(oneElement).isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue2() {
        assertFalse(queueWith(fourElements).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(firstElement, queueWith(oneElement).head());
    }

    @Test
    public void test03AddedElementsIsAtHead2() {
        assertEquals(firstElement, queueWith(fourElements).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = queueWith(oneElement);
        queue.take();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue2() {
        Queue queue = queueWith(fourElements);
        queue.take();
        queue.take();
        queue.take();
        assertFalse(queueWith(fourElements).isEmpty());
        queue.take();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        Queue queue = queueWith(oneElement);
        assertEquals(firstElement, queue.take());
    }

    @Test
    public void test05TakeReturnsLastAddedObject2() {
        Queue queue = queueWith(fourElements);
        assertEquals(firstElement, queue.take());
        assertEquals(secondElement, queue.take());
        assertEquals(thirdElement, queue.take());
        assertEquals(fourthElement, queue.take());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = queueWith(twoElements);
        assertEquals(queue.take(), firstElement);
        assertEquals(queue.take(), secondElement);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test06QueueBehavesFIFO2() {
        Queue queue = queueWith(fourElements);
        assertEquals(queue.take(), firstElement);
        assertEquals(queue.take(), secondElement);
        assertEquals(queue.take(), thirdElement);
        assertEquals(queue.take(), fourthElement);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test07HeadReturnsFirstAddedObject() {
        Queue queue = queueWith(twoElements);
        assertEquals(queue.head(), firstElement);
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        Queue queue = queueWith(oneElement);
        assertEquals(1, queue.size());
        queue.head();
        assertEquals(1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(2, queueWith(twoElements).size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue2() {
        assertEquals(4, queueWith(fourElements).size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        assertThrowsLike(() -> queue.take(), MESSAGE_EMPTY_QUEUE);
    }

    @Test
    public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = queueWith(oneElement);
        queue.take();
        assertThrowsLike(() -> queue.take(), MESSAGE_EMPTY_QUEUE);
    }

    @Test
    public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects2() {
        Queue queue = queueWith(fourElements);
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        assertThrowsLike(() -> queue.take(), MESSAGE_EMPTY_QUEUE);
    }

    @Test
    public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue1() {
        Queue queue = new Queue();
        assertThrowsLike(() -> queue.head(), MESSAGE_EMPTY_QUEUE);
    }

    @Test
    public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue2() {
        Queue queue = queueWith(fourElements);
        queue.take();
        queue.take();
        queue.take();
        queue.take();
        assertThrowsLike(() -> queue.head(), MESSAGE_EMPTY_QUEUE);
    }


    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Error.class, executable).getMessage());
    }

    private Queue queueWith(Object[] elements) {
        Queue queue = new Queue();
        for (Object element : elements) {
            queue.add(element);
        }
        return queue;
    }

    public static String MESSAGE_EMPTY_QUEUE = "Queue is empty";
    private String firstElement = "First";
    private String secondElement = "Second";
    private String thirdElement = "Third";
    private String fourthElement = "Fourth";
    private String[] ceroElements = new String[]{};
    private String[] oneElement = new String[]{firstElement};
    private String[] twoElements = new String[]{firstElement, secondElement};
    private String[] fourElements = new String[]{firstElement, secondElement, thirdElement, fourthElement};

}