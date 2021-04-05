package CodingInterview.Chapter02.Question08;

import CodingInterview.Library.LinkedListNode;
import sun.awt.image.ImageWatched.Link;

/**
 * @author choijaeyong on 19/03/2019.
 * @project Algorithm
 * @description
 * 2-8. 루프발견.
 */
public class Solution {
  public static void main(String[] args) {
    LinkedListNode<Character> node1 = new LinkedListNode<>('A');
    LinkedListNode<Character> node2 = new LinkedListNode<>('B');
    LinkedListNode<Character> node3 = new LinkedListNode<>('C');
    LinkedListNode<Character> node4 = new LinkedListNode<>('D');
    LinkedListNode<Character> node5 = new LinkedListNode<>('E');


    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node3);

    LinkedListNode<Character> result = findRoof(node1);
    System.out.println(result.data);

  }

  public static LinkedListNode<Character> findRoof(LinkedListNode<Character> head) {

    LinkedListNode<Character> slow = head;
    LinkedListNode<Character> fast = head;

    // 만나는 지점을 찾는다. fast 는 루프 사이즈 - k(slow가 이동한 크기) 만큼 들어간 상태
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        break;
      }
    }

    // 에러체크. 만나는 지점이 없다면 루프도 없다
    if(fast == null || fast.next == null) {
      return null;
    }

    // slow를 head로 옮기고 fast는 그대로 둔다. 이 둘은 루프 시작 지점에서 k만큼
    // 떨어져 있다.
    // 이 둘이 같은 속도 만큼 움직인다면?? 루프 시작지점에서 만난다.
    slow = head;
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }

}
