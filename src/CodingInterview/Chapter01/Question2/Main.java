package CodingInterview.Chapter01.Question2;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author choijaeyong on 21/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-2. 순열 확인 : 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확인하는
 * 메서드를 작성하라.
 */
public class Main {

  public static void main(String[] args) {
    String str1 = "abcde";
    String str2 = "acbed";
    String str5 = "aqcdb";
    String str3 = "abe";
    String str4 = "abq";

//    System.out.println(isPermutaionSameLength(str1,str5));
//    System.out.println(isPermutaionSameLength2(str1,str2));

    System.out.println(isPermutationDifferentLength(str1,str4));


  }

  public static boolean isPermutaionSameLength(String str1, String str2) {
    // 문자열의 길이가 같을 경우.
    Hashtable<Character,Integer> table = new Hashtable();
    int size = str1.length();

    // 먼저 문자열1을 해쉬테이블에 넣는다.
    for(int i=0; i < size ; i++) {
      if(table.containsKey(str1.charAt(i))) {
        table.put(str1.charAt(i), (table.get(str1.charAt(i))+1));
      }else {
        table.put(str1.charAt(i),1);
      }
    }

    for(int i=0; i < size ; i++) {
      if(table.containsKey(str2.charAt(i))) {
        table.put(str2.charAt(i), (table.get(str2.charAt(i))-1));
        if(table.get(str2.charAt(i)) < 0) {
          return false;
        }
      } else {
        System.out.println("str1은 str2의 알파벳을 가지고 있지 않다. 실패");
        return false;
      }
    }
    return true;
  }


  public static boolean isPermutaionSameLength2(String str1, String str2) {
    // 문자열의 길이가 같을 경우.

    System.out.println("처음 문자열, str1 = " + str1 + "  str2 = " + str2);

    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();

    Arrays.sort(chars1);
    Arrays.sort(chars2);

    System.out.println("정렬 후 문자열, str1 = " + str1 + "  str2 = " + str2);

    int size = chars1.length;

    for(int i=0; i < size ; i++) {
      if(chars1[i] != chars2[i]) {
        System.out.println("문자가 다르네요!?");
        return false;
      }
    }
    return true;
  }

  public static boolean isPermutationDifferentLength(String str1, String str2) {
    String longStr="";
    String shortStr="";

    if(str1.length() > str2.length()) {
      longStr = str1;
      shortStr = str2;
    }

    System.out.println("long : " + longStr + "    short : " + shortStr);


    Hashtable<Character, Integer> table = new Hashtable<>();

    int longSize = longStr.length();

    // 먼저 긴문자열을 해쉬테이블에 넣는다.
    for(int i=0; i < longSize ; i++) {
      if(table.containsKey(longStr.charAt(i))) {
        table.put(longStr.charAt(i), (table.get(longStr.charAt(i))+1));
      }else {
        table.put(longStr.charAt(i),1);
      }
    }

    int shortSize = shortStr.length();

    for(int i=0; i < shortSize ; i++) {
      if(table.containsKey(shortStr.charAt(i))) {
        table.put(shortStr.charAt(i), (table.get(shortStr.charAt(i))-1));
        if(table.get(shortStr.charAt(i)) < 0) {
          return false;
        }
      }else {
        // 긴 문자열은. 짧은 문자열의 알파벳을 가지고 있지 않다.
        return false;
      }
    }
    return true;
  }




}


/*
  문자열의 길이가 같을 경우와 다를 경우를 따로 생각해야 하는 것 같다.
  같을 경우 --> 모든 문자의 갯수가 같으면 끝! or 문자열을 알파벳순으로 정렬후 두 문자열의
  문자 순서가 다르면 false!

  다를 경우 --> 긴 문자열의 문자 해쉬테이블이. 짧은 쪽의 문자 해쉬테이블을 포함하고 있으면 된다.
       즉 긴쪽의 문자열을 해쉬테이블에 넣은 다음에. 짧은 쪽의 문자와 비교하면서
       0보다 작은 값이 없으면 true. 있으면 false.
 */