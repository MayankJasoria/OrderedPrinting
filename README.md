# Problem Statement
Suppose there are 3 threads: t1, t2, t3. t1 prints "First", t2 prints "Second", t3 prints "Third" using the respective
methods of the `OrderedPrinter` class shown below:
```java
public class OrderedPrinter {
    
    public void printFirst() {
        System.out.print("First");
    }
    
    public void printSecond() {
        System.out.print("Second");
    }
    
    public void printThird() {
        System.out.print("Third");
    }
}
```
The threads can run in any order. Synchronize the threads so that methods `printFirst()`, `printSecond()`, 
`printThird()` are executed in this order.

## Solution Approach
1. Instantiate a `Object` variable to use as a lock. Also keep a variable count.
2. synchronize on `lock` in each method.
3. The first method simply prints "First", increments count, and runs `notifyAll()`.
4. In the second method, the thread waits till count reaches 1. Thereafter, it prints "Second", increments count, and
invokes `notify()` to awaken t3.
5. In the third method, the thread waits till count reaches 2. Thereafter, it prints "Third".

## Sample output
```
FirstSecondThird
```