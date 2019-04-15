package etc.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choijaeyong on 15/04/2019.
 * @project Algorithm
 * @description
 */
public class Solution1 {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("we promptly judged antique ivory buckles for the next prize");
    list.add("we promptly judged antique ivory buckles for the prize");

    System.out.println(isPangram(list));
  }

  public static String isPangram(List<String> strings) {

    StringBuilder sb = new StringBuilder();

    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');

    // table index 0->a, 1->b  ...
    for(String sentence : strings) {
      int[] table = new int[z-a+1];
      createTable(table,sentence);
      String pangram = verifyTable(table);
      sb.append(pangram);
    }

    return sb.toString();
  }

  public static int[] createTable(int[] table , String sentence) {
    int a = Character.getNumericValue('a');
    for(int i=0; i < sentence.length() ; i++) {
      if(sentence.charAt(i) == ' ') {
        continue;
      }
      int index = Character.getNumericValue(sentence.charAt(i)) - a;
      table[index]++;
    }
    return table;
  }

  public static String verifyTable(int[] table) {

    for(int index : table) {
      if(index == 0) {
        return "0";
      }
    }

    return "1";
  }

}
