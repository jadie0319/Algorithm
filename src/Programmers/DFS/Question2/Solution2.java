package Programmers.DFS.Question2;

/*   https://programmers.co.kr/learn/courses/30/lessons/43163
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

제한사항
각 단어는 알파벳 소문자로만 이루어져 있습니다.
각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
begin과 target은 같지 않습니다.
변환할 수 없는 경우에는 0를 return 합니다.
입출력 예
begin	target	words	return
hit	cog	[hot, dot, dog, lot, log, cog]	4
hit	cog	[hot, dot, dog, lot, log]	0
입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    StringBuffer begin = new StringBuffer();
    StringBuffer target = new StringBuffer();
    String[] words = {"hot", "dot", "dog", "lot", "log","cog"};
    //String[] words ={"aaa","bbb","ccc"};

    begin.append("hit");
    target.append("cog");

    System.out.println(solution(begin.toString(), target.toString(), words));

  }


  public static int solution(String begin, String target, String[] words) {
    int answer = 0;

    Queue<String> queue = new LinkedList<>();
    for (String word : words) {
      queue.add(word);
    }

    int count = 0;
    int queueSize = queue.size();
    while(!queue.isEmpty()) {
      count++;
      System.out.println("큐 들오아자마자  begin : " + begin + "  queue.peek() : " + queue.peek() + "   answer : " + answer);
      if(checkCountingAlphabet(target,queue.peek()) == 0) {
        System.out.println("성공.  begin : " + begin + "  queue.peek() : " + queue.peek() + "   answer : " + answer);
        answer++;
        return answer;
      }

      if(checkCountingAlphabet(begin,queue.peek()) == 1) {
        System.out.println("차이가 1 일때.  begin : " + begin + "  queue.peek() : " + queue.peek() + "   answer : " + answer);
        begin = queue.poll();
        answer++;
      }else {
        System.out.println("차이가 2 이상.  begin : " + begin + "  queue.peek() : " + queue.peek() + "   answer : " + answer);
        ((LinkedList<String>) queue).add(queue.poll());
      }

      if(count > queueSize) {
        break;
      }
    }

    //return solutioning(begin,target,queue,answer);
    return 0;
  }


  public static int checkCountingAlphabet(String word, String queueWord) {
    char[] chars = word.toCharArray();
    char[] temp = queueWord.toCharArray();
    int wordLength = chars.length;
    int count = 0;
    // 모든 단어의 길이는 같다는 전제가 있다. 때문에 chars 와 temp 중 어떤 단어가 더 긴지 비교 nono.
    for (int i = 0; i < wordLength; i++) {
      if (chars[i] != temp[i]) {
        count++;
      }
    }
    return count;
  }

}