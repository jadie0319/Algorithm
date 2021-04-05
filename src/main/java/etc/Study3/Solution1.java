package etc.Study3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 23/02/2019.
 * @project Algorithm
 * @description
 *
 */
public class Solution1 {
  public static void main(String[] args) {


    System.out.println(solution(33));
  }

  public static int solution(int n) {
    int answer = 0;
    List<Integer> primes = new ArrayList<>();

    // n 보다 작은 소수를 구하기.
    primes = primes(n);



//    for(Integer k  : primes) {
//      System.out.println(k);
//    }

    answer = threePrimes(primes,n);


    return answer;
  }

  public static List<Integer> primes(int n) {
    List<Integer> list = new ArrayList<>();
    for(int i=2 ; i < n ; i++) {

      boolean isPrime = true;

      for(int j=2 ; j*j <= i ; j++ ) {
        if(i % j == 0) {
          // 소수가 아니다.
          isPrime = false;
          break;
        }
      }

      if(isPrime) {
        list.add(i);
      }

    }

    return list;
  }

  public static int threePrimes(List<Integer> primes, int n) {

    int size = primes.size();
    int num1=0;
    int num2=0;
    int num3=0;
    int sum=0;
    int count=0;

    for(int i=0; i < size ; i++) {
      // 초기화
      sum=0;
      num1 = primes.get(i);
      loop2:for(int j=i+1 ; j < size ; j++) {
        num2 = primes.get(j);
        loop3:for(int k=j+1 ; k < size ; k++) {
          num3 = primes.get(k);
          sum = num1 + num2+ num3;
          System.out.println("sum : " + sum + "  num1,num2,num3 = " + num1 + " " + num2 + " " + num3);
          if(sum == n) {
            count++;
            continue loop2;
          }
        }
      }

    }

    return count;
  }

}
