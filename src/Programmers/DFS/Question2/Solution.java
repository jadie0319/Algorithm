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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

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

    Queue<Node> queue = new LinkedList<>();
    //List<Node> lists = new ArrayList<>();

    for(String word : words) {
      ((LinkedList<Node>) queue).add(new Node(word,false));
      //lists.add(new Node(word,false));
    }

    // queue 에 있는 모든 단어들이. target 과 차이가 1이하인 것이 하나도 없으면.
    // 결과는 0 리턴!

    // words 를 큐에 넣지 말고...? 정답 큐를 하나 만들어서?
    // 매번


    int wordsSize = words.length;
    Queue<Node> answerQueue = new LinkedList<>();

    boolean end = true;
    for(Node node : queue) {
      if(node.getWord().equals(target)) {
        end = false;
      }
    }
    if(end == true) {
      return 0;
    }





    // 첫 번째 경우만 먼저. 계산해준다.
    for(int i=0; i < wordsSize ; i++) {
      int gap = checkCountingAlphabet(begin,words[i]);
      if( gap == 1) {
        ((LinkedList<Node>) answerQueue).add(((LinkedList<Node>) queue).get(i));
        ((LinkedList<Node>) queue).get(i).setVisited(true);

      }
    }

    if(answerQueue.isEmpty()) {
      System.out.println("첫 번째 테스트에서 끝!.정답후보가 없다!");
      return 0;
    }

    answer=1;


    while(!answerQueue.isEmpty()) {
      Node root = answerQueue.poll();
      System.out.println("root.getWord() : " + root.getWord());
      root.setVisited(true);

      if(root.getWord().equals(target)) {
        System.out.println("root == target!! 끝");
        return answer;
      }

      for(Node node : queue) {
        System.out.println("node : " + node.getWord() +"");
        if(node.isVisited() == true) {
          System.out.println("node가 " + node.getWord() +"임. continue");
          node.setVisited(true);
          continue;
        }

        int gap = checkCountingAlphabet(node.getWord(),root.getWord());
        if(gap == 1 && node.getWord().equals(target)) {
          System.out.println("정답!");
          answer++;
          return answer;
        }else if(gap == 1) {
          System.out.println(node.getWord() + " answerQueue에 add.");
          ((LinkedList<Node>) answerQueue).add(node);
        }

      }
      answer++; // answer 가 여기있으면 모든 root 별로 카운트 되기 때문에 안된다. 다른게 필요.
      System.out.println(answer);
      System.out.println();
      System.out.println();
      // false 인 것들의 리스트를 가져와서
      // node 와 비교하고. 차이가 1인것들은 answerQueue 에 넣고
      // 차이가 0이면 answer+1 해서 리턴해버리고!
  }




    return 0;
  }


  public static List<String> falseList(Queue<Node> queue) {

    int size = queue.size();
    List<String> falseList = new ArrayList<>();

    for(Node node : queue) {
      if(!node.isVisited()) {
        falseList.add(node.getWord());
      }
    }
    return falseList;
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

class Node {
  private String word;
  private boolean visited;

  public Node(String word, boolean visited) {
    this.word = word;
    this.visited = visited;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}