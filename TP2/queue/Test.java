package queue.queue;

import java.util.LinkedList;

public class Test {


    public static void main(String[] args){

        Queue q1 = new Queue();
//        q1.add("Como Estas");
//        System.out.println(q1.queue.getClass());
        System.out.println(q1.queue.getClass());
        q1.add("Hola");
        q1.add("Como");
        q1.add("Estas");
        q1.add("todo");
        q1.add("bien");
        System.out.println(q1.queue.getClass());
        System.out.println(q1.queue.head());
        System.out.println(q1.size());

        System.out.println(q1.take());
        System.out.println(q1.queue.head());
        System.out.println(q1.size());

//        LinkedList<Object> elements = new LinkedList<>();
//        elements.add("hola");
//        elements.add("como");
//        System.out.println(elements.get(0));





//        System.out.println(q1.queue.tail());


//        Queue queue = new Queue();
//        String firstAddedObject = "First";
//
//        queue.add( firstAddedObject );
//        queue.add( "Second" );
//
//        System.out.println(queue.head());
//        System.out.println(firstAddedObject);

    }
}
