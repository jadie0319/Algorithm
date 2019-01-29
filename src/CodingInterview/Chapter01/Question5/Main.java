package CodingInterview.Chapter01.Question5;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author choijaeyong on 29/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-5. 하나 빼기: 문자열을 편집하는 방법에는 세 가지 종류가 있다. 문자 삽입, 문자 삭제, 문자 교체.
 * 문자열 두 개가 주어졌을 때, 문자열을 같게 만들기 위한 편집 횟수가 1회 이내인지 확인하는 함수를 작성하라.
 */
public class Main {
  public static void main(String[] args) {
    //String str1 = "pale";
    String str1 = "paaaek";
    String str2 = "pek";

    System.out.println(isEdit(str1,str2));

  }

  public static boolean isEdit(String str1, String str2) {

    String longStr="";
    String shortStr="";

    if(str1.length() >= str2.length()) {
      longStr = str1;
      shortStr = str2;
    }

    char[] longChars = longStr.toCharArray();
    char[] shortChars = shortStr.toCharArray();

    Hashtable<Character,Integer> table = new Hashtable<>();

    for(char ch : longChars) {
      if(table.containsKey(ch)) {
        table.put(ch,table.get(ch)+1);
      } else {
        table.put(ch,1);
      }
    }

    // 다른 문자 카운트하는 변수
    int count = 0;

    for(char ch : shortChars) {
      if(table.containsKey(ch)) {
        table.put(ch,table.get(ch) - 1);
      } else {
        count++;
        // 다른 문자가 2개 되면 false 리턴.
        if(count == 2) {
          return false;
        }
      }
    }

    // Hashtable 에서 value 를 sum에 더해주다가 sum 이 2가 되면 중지. false 리턴.
    int sum = 0;
    for(char ch : table.keySet()) {
      sum += table.get(ch);
      if(sum >= 2) {
        return false;
      }
    }

    return true;
  }

}

/*
Hashtable
 */