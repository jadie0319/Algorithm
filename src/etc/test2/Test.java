package etc.test2;

/**
 * @author choijaeyong on 17/04/2019.
 * @project Algorithm
 * @description
 */

class Order {

}
public class Test {
  public static void main(String[] args) {
    Order order = new Order();

    String a = "abc";
    String b = new String("abc");
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    if(a.equals(b)) {
      System.out.println("haha");
    }

  }

}
