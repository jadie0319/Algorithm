package CodingInterview.Chapter02.Question02;

import CodingInterview.Library.LinkedListNode;

/**
 * @author choijaeyong on 16/02/2019.
 * @project Algorithm
 * @description
 * 2-2 뒤에서 k번째 원소 구하기 : 단방향 연결리스트가 주어졌을 때 뒤에서 k번째 원소를 찾는
 * 알고리즘을 구현하라.
 *
 * LinkedListNode 의 사이즈를 구하고 index 를 이용해 구하기.
 */
public class Solution {
  public static void main(String[] args) {
    LinkedListNode<Character> node1 = new LinkedListNode<Character>('a');
    node1 = init(node1);
    System.out.println(node1.printForward());

    System.out.println("Answer : "+lastKthValue(node1,3));
  }

  public static Character lastKthValue(LinkedListNode<Character> head,int k) {

    LinkedListNode<Character> current = head;
    int size = getSize(head);
    if(size == 1) {
      return current.data;
    }
    int index = 1;
    // 만약 List 의 사이즈를 알 수 있다면? 사이즈 - (k-1) 만큼 next 하면 된다.
    while(current != null && index != size-k+1) {
      current = current.next;
      index++;
      System.out.println(current.data + "    " + index);
    }

    return current.data;
  }




  public static int getSize(LinkedListNode<Character> head) {
    int size = 0;
    LinkedListNode<Character> node = head;
    while(node != null) {
      node = node.next;
      size++;
    }

    return size;
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
