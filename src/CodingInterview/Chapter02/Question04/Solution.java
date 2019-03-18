package CodingInterview.Chapter02.Question04;

import CodingInterview.Library.LinkedListNode;

/**
 * @author choijaeyong on 18/03/2019.
 * @project Algorithm
 * @description
 * 2-4 분할
 */
public class Solution {
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

    LinkedListNode<Integer> result = partitionList(node1,5);

    System.out.println(result.printForward());

  }

  public static LinkedListNode<Integer> partitionList(LinkedListNode<Integer> node , Integer target) {
    LinkedListNode<Integer> head = node;
    LinkedListNode<Integer> tail = node;

    while(node != null) {
      System.out.println("node.data : "+node.data);
      LinkedListNode<Integer> next = node.next;
      if(node.data < target) {
        node.next = head;
        head = node;
        System.out.println("node.next = " + node.next.data + "  head : " + head.data);
      } else {
        tail.next = node;
        tail = node;
        System.out.println("tail.next = " + node.data + "   tail : " + tail.data);
      }

      node = next;

      System.out.println();

    }

    tail.next = null;
    return head;

  }

}
