package etc.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 19/02/2019.
 * @project Algorithm
 * @description
 */
public class exam6 {
  public static void main (String[] args) throws java.lang.Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Integer input = Integer.parseInt(br.readLine());

    String[] strs = new String[input];
    strs[0]="coding *ing";
    strs[1]="interview in*";
    strs[2]="apple app?e";
    strs[3]="vanilla vani?a";
    strs[4]="banana ba*na";
    strs[5]="fru*its";

//    for(String str : strs) {
//      str = br.readLine();
//    }
//
//    for(String str : strs) {
//      System.out.println(str);
//    }

    isMatch("fru*its",strs[5],0,7,3);

//    isMatching(strs);
  }

  public static void isMatching(String[] strs) {
    for(String str : strs) {

      String[] s = str.split(" ");
      // s[0]    , s[1]
      String word = s[0];
      String matcher = s[1];
      List<Integer> starList = new ArrayList<>();

      for(int i=0; i < matcher.length() ; i++) {

        if(matcher.charAt(i) == '*') {
          starList.add(i);
        }
      }

      for(Integer index : starList) {
        if(index == 0) {
          isMatch(word,matcher,0,index,9);
        }
        isMatch(word,matcher,0,index,9);
      }


    }
  }

  public static void isMatch(String word, String matcher, int start, int end, int k) {
//    for(int i=0 ; i < matcher.length() ; i++) {
//      if() {
//
//      }
//    }
    String beforeStar = matcher.substring(start,k);
    String afterStar = matcher.substring(k+1,end);

    System.out.println(beforeStar);
    System.out.println(afterStar);

    System.out.println(word.contains(beforeStar));
    System.out.println(word.contains(afterStar));






  }

}
