package gadd.FindNumber;

public class NumberFinderThreads extends NumberFinderNoThreads implements Runnable {
    private long startNumber, stopNumber;
    public NumberFinderThreads(long startNumber, long stopNumber) {
        this.startNumber = startNumber;
        this.stopNumber = stopNumber;
    }

    public void run() {
        super.go(startNumber, stopNumber);
        System.out.println("Stop time " + System.currentTimeMillis());
    }
}
