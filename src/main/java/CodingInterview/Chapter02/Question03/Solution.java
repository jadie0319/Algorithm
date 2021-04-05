package CodingInterview.Chapter02.Question03;

import CodingInterview.Library.LinkedListNode;

/**
 * @author choijaeyong on 18/03/2019.
 * @project Algorithm
 * @description
 * 2-3 중간노드삭제.
 */
public class Solution {
  public static void main(String[] args) {
    // 단방향 리스트라고 생각하고 풀자. prev 사용 x
    LinkedListNode<Character> node1 = new LinkedListNode<Character>('a');
    LinkedListNode<Character> node2 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node3 = new LinkedListNode<Character>('c');
    LinkedListNode<Character> node4 = new LinkedListNode<Character>('d');
    LinkedListNode<Character> node5 = new LinkedListNode<Character>('e');

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    System.out.println(node1.printForward());

    // c를 삭제해보자
    deleteNode(node1,node3);


  }

  public static void deleteNode(LinkedListNode<Character> node, LinkedListNode<Character> node3) {

    LinkedListNode<Character> nextNode = node3.next;

    node3.data = nextNode.data;
    node3.setNext(nextNode.next);

    System.out.println(node.printForward());

  }

}
