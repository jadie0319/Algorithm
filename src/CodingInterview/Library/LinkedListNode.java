package CodingInterview.Library;

import java.util.LinkedList;
import sun.awt.image.ImageWatched.Link;

/**
 * @author choijaeyong on 15/02/2019.
 * @project Algorithm
 * @description
 */
public class LinkedListNode<T> {
  public LinkedListNode<T> next;
  public LinkedListNode<T> prev;
  public LinkedListNode<T> last;
  public T data;
  public LinkedListNode(T d, LinkedListNode n, LinkedListNode p) {
    data = d;

  }

  public LinkedListNode(T data) {
    this.data = data;
  }

  public LinkedListNode() {}

  public void setNext(LinkedListNode n) {
    next = n;
    if(this == last) {
      last = n;
    }
    if(n != null && n.prev == this) {
      n.setPrevious(this);
    }
  }

  public void setPrevious(LinkedListNode p) {
    prev = p;
    if(p != null && p.next != this) {
      p.setNext(this);
    }
  }

  public String printForward() {
    if(next != null) {
      return data + "->" + next.printForward();
    } else {
      return data.toString();
    }
  }
  public T getData() {
    return data;
  }

  public LinkedListNode clone() {
//    LinkedListNode next2 = null;
//
//    if(next != null) {
//      System.out.println(next.data);
//      next2 = next.clone();
//    }
//    LinkedListNode head2 = new LinkedListNode(data,next2,null);

    LinkedListNode neww = new LinkedListNode(this.data);
    return neww;
  }

}
