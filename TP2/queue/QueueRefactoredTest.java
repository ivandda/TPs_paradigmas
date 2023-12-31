package queue.queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class QueueRefactoredTest {
    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(queueWith(ceroElements).isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queueWith(oneElement).isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(firstElement, queueWith(oneElement).head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = queueWith(oneElement);
        queue.take();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        Queue queue = queueWith(oneElement);
        assertEquals(firstElement, queue.take());
    }

    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = queueWith(twoElements);
        assertEquals(queue.take(), firstElement);
        assertEquals(queue.take(), secondElement);
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
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        assertThrowsLike(() -> queue.take(), message_empty_queue);
    }

    @Test
    public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = queueWith(oneElement);
        queue.take();
        assertThrowsLike(() -> queue.take(), message_empty_queue);
    }

    @Test
    public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        Queue queue = new Queue();
        assertThrowsLike(() -> queue.head(), message_empty_queue);
    }


    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Error.class, executable).getMessage());
    }

    private Queue queueWith(Object[] elements) {
        Queue queue = new Queue();
        Arrays.stream(elements).forEach((e)->queue.add(e));
        return queue;
    }

    public static String message_empty_queue = EmptyWrapper.message_empty_queue;
    private String firstElement = "First";
    private String secondElement = "Second";
    private String[] ceroElements = new String[]{};
    private String[] oneElement = new String[]{firstElement};
    private String[] twoElements = new String[]{firstElement, secondElement};

}