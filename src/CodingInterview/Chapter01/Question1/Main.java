package CodingInterview.Chapter01.Question1;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author choijaeyong on 10/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-1 : 중복이 없는가? 문자열이 주어졌을 때 , 이 문자열에 같은 문자가 중복되어 등장하는지
 * 확인하는 알고리즘을 작성하라. 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한
 * 고민하라.
 */

public class Main {
  public static void main(String[] args) {

    String str = "abcdefghijklmn";
    String str2 = "abcdefghijklamn";

    // str --> false  , str2 --> true
    //System.out.println(isDuplicated(str2));
    System.out.println(isDuplicatedWithoutDataStructure(str2));

  }

  public static boolean isDuplicated(String str) {

    Hashtable table = new Hashtable();

    int length = str.length();

    for(int i=0; i < length ; i++ ) {
      if(table.containsKey(str.charAt(i))) {
        return true;
      }else {
        table.put(str.charAt(i),1);
      }
    }


    return false;
  }

  public static boolean isDuplicatedWithoutDataStructure(String str) {
    System.out.println(str);
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    System.out.println(chars);

    int length = chars.length;

    for(int i=0; i < length - 1 ; i++) {
      if(chars[i] == chars[i+1]) {
        return true;
      }
    }

    return false;
  }

}


/*
    1. Hashtable 을 이용해 검색한다
    2. 문자열을 어떠한 기준으로 정렬한다 --> 같은 문자들끼리 옆에 있게 된다 --> 비교한다.

 */