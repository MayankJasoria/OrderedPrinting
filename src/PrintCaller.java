public class PrintCaller {
    public static void main(String[] args) throws InterruptedException {
        OrderedPrinting orderedPrinting = new OrderedPrinting();
        Thread t1 = new Thread(orderedPrinting::printFirst);
        Thread t2 = new Thread(orderedPrinting::printSecond);
        Thread t3 = new Thread(orderedPrinting::printThird);
        t3.start();
        t2.start();
        t1.start();

        t3.join();
        t2.join();
        t1.join();
    }
}
