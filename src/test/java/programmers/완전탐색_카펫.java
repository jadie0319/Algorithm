package programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

public class 완전탐색_카펫 {

  @Test
  void test1() {
    int brown = 10;
    int yellow = 2;
    int[] solution = solution(brown, yellow);
    assertThat(solution).containsExactly(4,3);
  }

  @Test
  void test2() {
    int brown = 50;
    int yellow = 22;
    int[] solution = solution(brown, yellow);
    assertThat(solution).containsExactly(24,3);
  }

  public int[] solution(int brown, int yellow) {
    // brown + yellow = return 된 두수의 곱
    // 가로의 길이가 더 길다.

    List<Integer> yaks = yak(brown + yellow);
    return minSum(yaks,yellow);
  }


  @Test
  void 약수구하기() {
    int number = 12;
    List<Integer> list = yak(number);
    System.out.println(list);
    assertThat(list).containsExactly(1,2,3,4,6,12);
  }

  @Test
  void 약수구하기2() {
    int number = 72;
    List<Integer> list = yak(number);
    System.out.println(list);
    assertThat(list).containsExactly(1,2,3,4,6,8,9,12,18,24,36,72);
  }

  @Test
  void 약수의합중최소값구하기1() {
    int number = 12;
    List<Integer> list = yak(number);
    int[] result = minSum(list, 0);
    assertThat(result).containsExactly(4,3);
  }

  @Test
  void 약수의합중최소값구하기2() {
    int number = 9;
    List<Integer> list = yak(number);
    int[] result = minSum(list, 0);
    assertThat(result).containsExactly(3,3);
  }

  private int[] minSum(List<Integer> list, int yellow) {
    List<Integer> result = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    if (list.size() % 2 == 0) {
      for (int i = 0; i < list.size() / 2 ; i++) {
        int num1 = list.get(i); // 세로
        int num2 = list.get(list.size() - 1 - i); // 가로

        // 안쪽 사각형(노랑색사각형) 개수 확인
        if ( (num1 - 2) * (num2 -2) != yellow) {
          continue;
        }

        if (num1 + num2 < min) {
          min = num1 + num2;
          result.clear();
          result.add(num1);
          result.add(num2);
        }
      }
    } else {
      result.add(list.get( (list.size() - 1) / 2 ));
      result.add(list.get( (list.size() - 1) / 2 ));
    }

    return result.stream()
        .sorted(Comparator.reverseOrder())
        .mapToInt(k -> k)
        .toArray();
  }


  private List<Integer> yak(int number) {
    List<Integer> list = new ArrayList<>();
    for (int i=1 ; i <= number ; i++) {
      if (number % i == 0) {
        list.add(i);
      }
    }
    return list;
  }

}
