package programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class 완전탐색_모의고사 {

  @Test
  void test_one() {
    int[] answers = {1,2,3,4,5};
    int[] answer = solution(answers);
    assertThat(answer).containsExactly(1);
  }

  @Test
  void test_two() {
    int[] answers = {1,3,2,4,2};
    int[] answer = solution(answers);
    assertThat(answer).containsExactly(1,2,3);
  }

  @Test
  void test_three() {
    int[] answers = {1,2,5,5,2};
    int[] answer = solution(answers);
    assertThat(answer).containsExactly(1);
  }

  @Test
  void test_four() {
    int[] answers = {3,3,1,1,1,1,2,3,4,5};
    int[] answer = solution(answers);
    assertThat(answer).containsExactly(1,3);
  }

  public int[] solution(int[] answers) {
    int[] first = {1,2,3,4,5};
    int[] second = {2,1,2,3,2,4,2,5};
    int[] third = {3,3,1,1,2,2,4,4,5,5};

    Map<Integer, Integer> resultMap = new HashMap<>();

    for (int i=0; i < answers.length ; i++) {
      if (answers[i] == first[i % 5]) {
        resultMap.putIfAbsent(1,0);
        resultMap.computeIfPresent(1, (key,value) -> value + 1);
      }
      if (answers[i] == second[i % 8]) {
        resultMap.putIfAbsent(2,0);
        resultMap.computeIfPresent(2, (key,value) -> value + 1);
      }
      if (answers[i] == third[i % 10]) {
        resultMap.putIfAbsent(3,0);
        resultMap.computeIfPresent(3, (key,value) -> value + 1);
      }
    }

    int max = resultMap.values().stream().mapToInt(number -> number).max().getAsInt();

    return resultMap.entrySet()
        .stream()
        .filter(entry -> entry.getValue() == max)
        .sorted(Entry.comparingByValue(Comparator.naturalOrder()))
        .mapToInt(entry -> entry.getKey())
        .toArray();
  }

  //Stream.of(firstAnswerCount, secondAnswerCount, thirdAnswerCount)
  //        .mapToInt(num -> num)
  //        .filter(number -> number != 0)
  //        .sorted()
  //        .toArray();


  @Test
  void first() {
    int[] answers = {1,2,3,4,5,1,2,3,4,5};
    int[] first = {1,2,3,4,5};
    int collect = 0;
    for (int i=0; i < answers.length ; i++) {
      if (answers[i] == first[i % 5]) {
        //0 0
        //1 1
        //2 2
        //3 3
        //4 4
        //5 0
        //6 1
        //7 2
        collect++;
      }
    }
    assertThat(collect).isEqualTo(10);
  }

}
