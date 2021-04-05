package CodingInterview.Chapter02.Question01;

import CodingInterview.Library.LinkedListNode;
import java.util.LinkedList;

/**
 * @author choijaeyong on 16/02/2019.
 * @project Algorithm
 * @description
 *
 * Wrapper 클래스 구현해서 재귀로 구하기.
 */
public class Solution2 {

  public static void main(String[] args) {
    LinkedListNode<Character> node1 = new LinkedListNode<Character>('a');
    node1 = init(node1);
    System.out.println(node1.printForward());

    LinkedListNode<Character> result = kthToLast(node1,3);
    System.out.println(result.data);


  }

  public static LinkedListNode<Character> kthToLast(LinkedListNode<Character> head, int k) {
    Index idx = new Index();
    return kthToLast(head,k,idx);
  }
  public static LinkedListNode<Character> kthToLast(LinkedListNode<Character> head, int k, Index idx) {
    if(head == null) {
      return null;
    }
    LinkedListNode<Character> current = kthToLast(head.next,k,idx);
    // 재귀로 맨 마지막 노드까지 간다. 끝까지 가서 첫번째로 current 가 가지는 값은 null
    idx.value = idx.value + 1;
    if(idx.value == k) {
      return head;
    }
    return current;
  }



  public static LinkedListNode<Character> init(LinkedListNode<Character> head) {
    LinkedListNode<Character> node2 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node3 = new LinkedListNode<Character>('a');
    LinkedListNode<Character> node4 = new LinkedListNode<Character>('d');
    LinkedListNode<Character> node5 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node6 = new LinkedListNode<Character>('f');

    head.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);

    return head;

  }
}

class Index {
  public int value=0;
}