public class OrderedPrinting {

    private final Object lock;
    private int count;

    public OrderedPrinting() {
        lock = new Object();
        count = 0;
    }
    public void printFirst() {
        System.out.print("First");
        synchronized (lock) {
            ++count;
            lock.notifyAll();
        }
    }

    public void printSecond() {
        synchronized (lock) {
            while (count != 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
            System.out.print("Second");
            ++count;
            lock.notify();
        }
    }

    public void printThird() {
        synchronized (lock) {
            while (count != 2) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
            System.out.print("Third");
        }
    }
}
