package LeetCode.Question242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author choijaeyong on 16/01/2019.
 * @project Algorithm
 * @description
 */
public class Question {
  public static void main(String[] args) {

    String str1 = "anagram";
    String str2 = "nagaram";

    System.out.println(isAnagram(str1,str2));

  }
  public static boolean isAnagram1(String str1, String str2) {
    Hashtable<Character,Integer> table = new Hashtable();

    char[] charsStr1 = str1.toCharArray();
    char[] charsStr2 = str2.toCharArray();

    int size1 = charsStr1.length;
    int size2 = charsStr2.length;

    if(size1 != size2) {
      return false;
    }

    for(int i=0; i < size1 ; i++) {
      if(table.containsKey(charsStr1[i])) {
        table.put(charsStr1[i],table.get(charsStr1[i]) + 1);
      } else {
        table.put(charsStr1[i],1);
      }
    }

    //System.out.println(table);


    for(int i=0; i < size2 ; i++) {
      if(table.containsKey(charsStr2[i])) {
        //System.out.println("----- charStr2[i] : " + charsStr2[i]);
        table.put(charsStr2[i],table.get(charsStr2[i]) -1);
        if(table.get(charsStr2[i]) < 0 ) {
          return false;
        }
      } else {
        //System.out.println("일치하는게 없다.");
        return false;
      }
    }
    return true;
  }


  public static boolean isAnagram2(String str1, String str2) {
    Map<Character,Integer> table = new HashMap();

    char[] charsStr1 = str1.toCharArray();
    char[] charsStr2 = str2.toCharArray();

    int size1 = charsStr1.length;
    int size2 = charsStr2.length;

    if(size1 != size2) {
      return false;
    }
    for(char ch : charsStr1) {
      if(table.containsKey(ch)) {
        table.put(ch,table.get(ch) + 1);
      } else {
        table.put(ch,1);
      }

    }
    //System.out.println(table);
    for(char ch : charsStr2) {
      if(table.containsKey(ch)) {
        //System.out.println("----- charStr2[i] : " + charsStr2[i]);
        table.put(ch,table.get(ch) -1);
        if(table.get(ch) < 0 ) {
          return false;
        }
      } else {
        //System.out.println("일치하는게 없다.");
        return false;
      }
    }
    return true;
  }



  public static boolean isAnagram(String str1, String str2) {
    if(str1.length() != str2.length()) {
      return false;
    }

    char[] char1 = str1.toCharArray();
    char[] char2 = str2.toCharArray();

    Arrays.sort(char1);
    Arrays.sort(char2);

    for(int i=0; i < char1.length ; i++) {
      if(char1[i] != char2[i]) {
        return false;
      }
    }


    return true;
  }

}
