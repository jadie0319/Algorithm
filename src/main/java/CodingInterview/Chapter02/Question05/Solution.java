package CodingInterview.Chapter02.Question05;

import CodingInterview.Library.LinkedListNode;

/**
 * @author choijaeyong on 19/03/2019.
 * @project Algorithm
 * @description
 * 2-5 리스트의 합.
 */
public class Solution {
  public static void main(String[] args) {
    LinkedListNode<Integer> node1 = new LinkedListNode<>(7);
    LinkedListNode<Integer> node2 = new LinkedListNode<>(1);
    LinkedListNode<Integer> node3 = new LinkedListNode<>(6);

    LinkedListNode<Integer> node4 = new LinkedListNode<>(5);
    LinkedListNode<Integer> node5 = new LinkedListNode<>(9);
    LinkedListNode<Integer> node6 = new LinkedListNode<>(2);

    node1.setNext(node2);
    node2.setNext(node3);

    node4.setNext(node5);
    node5.setNext(node6);

    System.out.println(node1.printForward());
    System.out.println(node4.printForward());

    LinkedListNode<Integer> result = new LinkedListNode<>(0);

    result = listSum(node1,node4,result,0);

    System.out.println(result.printForward());

  }

  // 자릿수가 같을때라고 가정.
  public static LinkedListNode<Integer> listSum(
      LinkedListNode<Integer> head1, LinkedListNode<Integer> head2, LinkedListNode<Integer> result,
      int carry) {
    if(head1 == null && head2 == null) {
      return result;
    }

    Integer sum = head1.data + head2.data + carry;
    if(sum >= 10) {
      carry = 1;
      sum = sum % 10;
    }
    LinkedListNode<Integer> temp = new LinkedListNode<>(sum);
    System.out.println(result.data);
    result.next = temp;
    result = temp; // 주석처리하고 아래 result 를 temp로 바꾸면 최초값인 0도 출력.

    listSum(head1.next,head2.next,result,carry);

    System.out.println(result.data);

    return result;

  }

}
