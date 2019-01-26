package CodingInterview.Chapter01.Question4;

import java.util.Hashtable;
import java.util.Set;

/**
 * @author choijaeyong on 24/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-4. 회문순열 : 주어진 문자열이 회문의 순열인지 아닌지 확인하는 함수를 작성하라. 회문이란 앞으로 읽으나
 * 뒤로 읽으나 같은 단어 혹은 구절을 의미하며, 순열이란 문자열을 재배치하는 것을 뜻한다. 회문이 꼭 사전에
 * 등장하는 단어로 제한될 필요는 없다.
 * input  : Tact Coa
 * output : true(taco cat, atco cta)
 */
public class Main {
  public static void main(String[] args) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');

    System.out.println(a);
    System.out.println(z);

    String str = "Tact Coa";


    selectMethod(str);


  }

  public static void selectMethod(String str) {
    // 문자열 소문자로 바꾸고 공백 없애기
    str = setString(str);
    Hashtable<Character,Integer> table = setTable(str);

    if(str.length() % 2 == 1) {
      // 문자열 길이가 홀수
      System.out.println("길이가 홀수인 회문순열, " + isPalindromeOdd(table));
    } else {
      System.out.println("길이가 짝수인 회문순열, " + isPalindrome(table));
    }

  }

  public static boolean isPalindrome(Hashtable<Character,Integer> table) {

    // 전체 길이가 짝수인 경우
    // 문자 개수가 홀수인게 하나라도 있으면? 회문순열이 안된다.

    Set<Character> set = table.keySet();

    for(Character key : set) {
      if(table.get(key) % 2 == 1) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPalindromeOdd(Hashtable<Character,Integer> table) {
    // 전체 길이가 홀수인 경우
    // 개수가 홀수인 문자가 한개만 있으면 회문순열이 된다.
    Set<Character> set = table.keySet();

    boolean hasOdd=false;

    for(Character key : set) {
      if(table.get(key) % 2 == 1) {
        if(hasOdd) {
          // hasOdd 가 true인 상태에서 개수가 홀수인 문자가 하나 더 나오면 회문순열이 아니다.
          return false;
        }
        hasOdd = true;
      }
    }
    return true;

  }

  public static String setString(String str) {
    str = str.toLowerCase();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i < str.length() ; i++) {
      if(str.charAt(i) == ' ') {
        continue;
      }
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  public static Hashtable setTable(String str) {
    Hashtable<Character,Integer> table = new Hashtable<>();


    char[] chars = str.toCharArray();

    for(char ch : chars) {
      if(table.containsKey(ch)) {
        table.put(ch, (table.get(ch)+1));
      } else {
        table.put(ch,1);
      }
    }

    return table;
  }

}



/*
  순열을 다 구하는 문제가 아니다... 
  총 문자열의 길이가 홀수면 한문자는 홀수? 나머진 짝수
  총 문자열의 길이가 짝수면  모두 짝수.
 */