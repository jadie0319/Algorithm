package LeetCode.LearnCourse.Recursion.RecurrenceRelation;

/**
 * @author choijaeyong on 07/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution3 {

  static ListNode result;

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode head2 = new ListNode(2);
    ListNode head3 = new ListNode(3);
    ListNode head4 = new ListNode(4);
    ListNode head5 = new ListNode(5);
    head.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;


//    while(head != null) {
//      System.out.println(head.val);
//      head = head.next;
//    }
    ListNode newNode = reverseList(head);

    System.out.println(newNode.val);
    System.out.println(newNode.next.val);
//    System.out.println(newNode.next.next.val);
//    System.out.println(newNode.next.next.next.val);
//    System.out.println(newNode.next.next.next.next.val);
//    System.out.println(newNode.next.next.next.next.next.val);


  }

  public static ListNode reverseList(ListNode head) {
    if(head == null) {
      return null;
    }
    ListNode next = head.next;
    // 1 -> 2 의 연결을 끊어준다.이전 내 코드는 이걸 안해줘서 ... 안됐나보다.
    head.next = null;
    if (next != null) {
      ListNode root = reverseList(next);
      next.next = head;
      return root;
    }
    System.out.println("여기로 안오지??" + "  head : " + head.val);
    return head;
  }

  // Iterative 답안.
  public static ListNode reverseList2(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp; // temp = 2, curr.next = null , prev = 1, curr = 2
                   // temp = null , curr.next = 1, prev = 2, curr = null
    }

    return prev;
  }

  // Recursive 답안.모르겠다 이건.
  public static ListNode reverseList3(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }

    ListNode p = reverseList3(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }


}


//Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
