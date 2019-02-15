package BOJ.Question1966;

/* https://www.acmicpc.net/problem/1966

여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int testNums = Integer.parseInt(br.readLine());

    for(int i=0; i < testNums ; i++) {
      String line = br.readLine();
      String[] lines = line.split(" ");

      int documentNum = Integer.parseInt(lines[0]);
      int position = Integer.parseInt(lines[1]);

      int result = solution(documentNum,position);
      System.out.println(result);
    }


  }

  public static int solution(int documentNum, int position) {
    Scanner sc = new Scanner(System.in);
    Queue<Document> queue = new LinkedList<Document>();
    int[] nums = new int[documentNum];
    for(int i=0; i < documentNum ; i++) {
      //nums[i] = sc.nextInt();
      queue.add(new Document(sc.nextInt(),0));
    }
    //int result = ((LinkedListNode<Document>) queue).get(position).getNum();
    Document result = ((LinkedList<Document>) queue).get(position);
    ((LinkedList<Document>) queue).get(position).setValue(1);
    // value 가 1로 표기.

    int printCount =0;

    while(true) {
      int max = isMax(queue);
      if( queue.peek().getNum() == max) {
        queue.poll(); // print
        printCount++;
      } else {
        // 미출력.
        //((LinkedListNode<Integer>) queue).addLast(((LinkedListNode<Integer>) queue).removeFirst());
        ((LinkedList<Document>) queue).addLast(((LinkedList<Document>) queue).removeFirst());

      }

      if(!queue.contains(result) ) {
        break;
      }
    }


    return printCount;
  }

  public static int isMax(Queue<Document> queue) {
    int max= Integer.MIN_VALUE;
    for(Document doc : queue) {
      max =  doc.getNum() > max ? doc.getNum() : max;
    }
//    Iterator itr = queue.iterator();
//    while(itr.hasNext()) {
//      int temp = (Integer)itr.next();
//
//    }
    return max;
  }



}

class Document {
  private int num;
  private int value;
  public Document(int num, int value) {
    this.num = num; this.value= value;
  }

  public int getNum() {
    return num;
  }
  public void setValue(int value) {
    this.value = value;
  }
}
