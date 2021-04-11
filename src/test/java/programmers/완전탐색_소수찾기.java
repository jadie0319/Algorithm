package programmers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class 완전탐색_소수찾기 {

  @Test
  void test_one() {
    String number = "17";
    int solution = solution2(number);
    assertThat(solution).isEqualTo(3);
  }

  @Test
  void test_two() {
    String number = "011";
    int solution = solution2(number);
    assertThat(solution).isEqualTo(2);
  }

//  @Test
//  void test_str_to_intArr() {
//    String str = "1231";
//    Set<Integer> list = new HashSet<>();
//    permutation(list,"",str);
//    for (Integer s : list) {
//      System.out.println(s);
//    }
//  }

  @ParameterizedTest
  @CsvSource(value = {"1:false","2:true","3:true","4:false","5:true","6:false","7:true","8:false","9:false"},delimiter = ':')
  void prime(String input, String result) {
    boolean prime = isPrime(Integer.parseInt(input));
    boolean expected = Boolean.parseBoolean(result);
    assertThat(prime).isEqualTo(expected);
  }

  private boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }

    for (int i=2 ; i*i <= number ; ++i) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }


  public int solution2(String numbers) {
    int answer = 0;
    String[] num = numbers.split("");
    int length = num.length;

    Set<Integer> set = new HashSet<>();
    for (int i=1 ; i <= length ; ++i) {
      makeNumber(num,i,0,set);
    }

    for (Integer number : set) {
      if (isPrime(number)) {
        answer++;
      }
    }

    return answer;
  }

  private void makeNumber(String[] numbers, int max, int index, Set<Integer> set) {
    if (index == max) {
      StringBuilder sb = new StringBuilder();
      for(int i=0; i < max; i++) {
        sb.append(numbers[i]);
      }
      set.add(Integer.parseInt(sb.toString()));
    } else {
      for (int i=0; i + index < numbers.length; i++) {
        swap(numbers, index, index + i);
        makeNumber(numbers, max, index +1, set);
        swap(numbers, index, index + i);
      }
    }

  }

  private void swap(String[] numbers, int i, int j) {
    String s = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = s;
  }



//  public int solution(String numbers) {
//    Set<Integer> set = new HashSet<>();
//    permutation(set,"",numbers);
//
//    for (int i=0; i < numbers.length() ; i++) {
//      int number = Integer.parseInt(String.valueOf(numbers.charAt(i)));
//      if (isPrime(number)) {
//        set.add(number);
//      }
//    }
//
//    return set.size();
//  }
//
//  private void permutation(Set<Integer> set, String prefix, String str) {
//    int n = str.length();
//    if (n == 0) {
//      if (isPrime(Integer.parseInt(prefix))) {
//        set.add(Integer.parseInt(prefix));
//      }
//    } else {
//      for (int i=0 ; i < n ; i++) {
//        permutation(set,prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1,n));
//      }
//    }
//  }
}
