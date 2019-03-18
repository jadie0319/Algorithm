package CodingInterview.Chapter02.Question04;

import CodingInterview.Library.LinkedListNode;
import sun.awt.image.ImageWatched.Link;

/**
 * @author choijaeyong on 18/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution2 {
  public static void main(String[] args) {
    LinkedListNode<Integer> node1 = new LinkedListNode<>(3);
    LinkedListNode<Integer> node2 = new LinkedListNode<>(5);
    LinkedListNode<Integer> node3 = new LinkedListNode<>(8);
    LinkedListNode<Integer> node4 = new LinkedListNode<>(5);
    LinkedListNode<Integer> node5 = new LinkedListNode<>(10);
    LinkedListNode<Integer> node6 = new LinkedListNode<>(2);
    LinkedListNode<Integer> node7 = new LinkedListNode<>(1);

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);

    System.out.println(node1.printForward());

    partitioning(node1,5);

    System.out.println(node1.printForward());


  }

  public static LinkedListNode<Integer> partitioning(LinkedListNode<Integer> node, Integer target) {

    LinkedListNode<Integer> beforeStart = null;
    LinkedListNode<Integer> beforeEnd = null;
    LinkedListNode<Integer> afterStart = null;
    LinkedListNode<Integer> afterEnd = null;

    while(node != null) {
      LinkedListNode<Integer> next = node.next;
      node.next = null;
      if(node.data < target) {
        if(beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }

    if(beforeStart == null) {
      return afterStart;
    }

    beforeEnd.next = afterStart;
    return beforeStart;
  }

}
