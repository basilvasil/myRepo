import java.lang.reflect.Array;
import java.util.ArrayList;

public class Producer implements Runnable{
    private static int[] theList;


    public Producer(int[] theList) {
        this.theList=theList;
    }

    @Override
    public void run() {

        synchronized (this) {

                for (int i = 0; i < theList.length; i++) {
                    theList[i] = i;
                    System.out.println("Produced " + theList[i]);
                    notify();
                }

        }
    }
}
