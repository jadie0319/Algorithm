package etc.threadExam;

/**
 * @author choijaeyong on 09/03/2019.
 * @project Algorithm
 * @description
 */
public class exam {
  public static void main(String[] args) {

    Counter counterA = new Counter();
    Counter counterB = new Counter();
    Thread  threadA = new CounterThread(counterA);
    Thread  threadB = new CounterThread(counterB);

    threadA.start();
    threadB.start();



//    Counter counter = new Counter();
//    Thread  threadA = new CounterThread(counter);
//    Thread  threadB = new CounterThread(counter);
//
//    threadA.start();
//    threadB.start();

  }

}

class Counter{

  long count = 0;

  public synchronized void add(long value){
    this.count += value;
  }
}

class CounterThread extends Thread{

  protected Counter counter = null;

  public CounterThread(Counter counter){
    this.counter = counter;
  }

  public void run() {
    for(int i=0; i<100; i++){
      counter.add(i);
    }
    System.out.println(this.getName() + "   " + counter.count);
  }
}