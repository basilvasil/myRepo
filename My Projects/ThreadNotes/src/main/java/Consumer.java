import java.util.ArrayList;

public class Consumer implements Runnable {

    private static int[] theList;

    public Consumer(int[] theList) {
        this.theList = theList;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < theList.length; i++) {
                System.out.println("Consumed " + theList[i]);
                notify();
            }

        }

    }
}