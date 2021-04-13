package CodingInterview.Chapter02.Question01;

import CodingInterview.Library.LinkedListNode;

/**
 * @author choijaeyong on 15/02/2019.
 * @project Algorithm
 * @description
 * 2-1 중복 없애기 : 정렬되어 있지 않은 연결리스트가 주어졌을 때, 이 리스트에서 중복되는 원소를 제거하는
 * 코드를 작성하라.
 */
public class Solution {

  public static void main(String[] args) {
    LinkedListNode<Character> node1 = new LinkedListNode<Character>('a');
    LinkedListNode<Character> node2 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node3 = new LinkedListNode<Character>('a');
    LinkedListNode<Character> node4 = new LinkedListNode<Character>('d');
    LinkedListNode<Character> node5 = new LinkedListNode<Character>('b');
    LinkedListNode<Character> node6 = new LinkedListNode<Character>('f');

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);

    System.out.println(node1.printForward());

    //deleteDuplicate(node1);
    deleteDuplicateWithoutBuffer(node1);

    System.out.println(node1.printForward());


  }

  public static void deleteDuplicate(LinkedListNode<Character> node1) {
    int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a') + 1];
    System.out.println(table.length);

    // 0~25 인덱스가 a~z 로 대응된다고 생각하면 된다.
    // List 에 알파벳이 있으면 그에 해당하는 인덱스에 +1.

    // 값을 넣어준다는게 아니라.
    // node.next 가 node1을 가리키는게 아니라 node.next 가 node1.next 를 가리키게 함 으로써
    // node1 을 참조 안하게 만든다? 고로 제거된다??
    LinkedListNode node = null;

    while(node1 != null) {
      int temp = Character.getNumericValue(node1.getData());
      if(table[temp] >= 1) {
        //table[temp] = table[temp] + 1;
        node.next = node1.next;
        System.out.println("if 안에서 node : "+node.printForward());
        System.out.println("if 안에서 node1 : "+node1.printForward());
        System.out.println();
      } else {
        table[temp] = 1;
        node = node1;
        System.out.println("else 안에서 : "+node.printForward());
        System.out.println("else 안에서 node1 : "+node1.printForward());
        System.out.println();
      }
      node1 = node1.next;
    }

  }

  // Runner 포인터 를 사용한다!
  public static void deleteDuplicateWithoutBuffer(LinkedListNode<Character> head) {
    LinkedListNode<Character> current = head;
    while(current != null) {
      LinkedListNode<Character> runner = current;
      while(runner.next != null) {
        if(current.data == runner.next.data) {
          runner.next = runner.next.next;
        }else {
          runner = runner.next;
        }
      }
      current = current.next;
    }


  }

}
