public class PrintCaller {
    public static void main(String[] args) {
        OrderedPrinting orderedPrinting = new OrderedPrinting();
        Thread t1 = new Thread(orderedPrinting::printFirst);
        Thread t2 = new Thread(orderedPrinting::printSecond);
        Thread t3 = new Thread(orderedPrinting::printThird);
    }
}
