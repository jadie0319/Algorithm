package LeetCode.LearnCourse.Recursion;

import CodingInterview.Library.LinkedListNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author choijaeyong on 16/02/2019.
 * @project Algorithm
 * @description
 */
public class SwapNodesInPairs {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
//    node4.next = node5;
//    node5.next = node6;

    System.out.println(node1.print());
    node1 = swapPairs(node1);
    System.out.println("result : " + node1.print());

//    ListNode temp = new ListNode(node1.val);
//    ListNode temp = node1.next;
//    node1.next = node1.next.next;
//    temp.next = node1;


  }

  public static ListNode swapPairs(ListNode head) {
//    if(head.next == null) {
//      return head;
//    }
//
//    head = swapPairs(head,0);
//    return head;
    if (head == null || head.next == null) return head;

    ListNode n1 = head;
    ListNode n2 = head.next;

    n1.next = n2.next;
    n2.next = n1;

    n1.next = swapPairs(n1.next);

    return n2;

  }

//  public static ListNode swapPairs(ListNode head,int index) {
//    if(head == null) {
//      return null;
//    }
//    ListNode temp = head.next;
//    head.next = head.next.next;
//    temp.next = head;
//
//    System.out.println(temp.print() + "    temp : " + temp.val  + "  temp.next.next = " + temp.next.next.val +  "   head : " + head.val);
//
//    head.next = swapPairs(temp.next.next,index);
//
//    System.out.println(temp.print());
//    return temp;
//  }

}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x;}

  public String print() {
    if(next != null) {
      return val + "->" + next.print();
    } else {
      return String.valueOf(val);
    }
  }
}
