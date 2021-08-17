import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProducerConsumer {

    static int[] theList = new int[5];
    public static void main(String[] args) {


        Thread p = new Thread(new Producer(theList));
        Thread c = new Thread(new Consumer(theList));


        c.start();
        p.start();

    }


}



