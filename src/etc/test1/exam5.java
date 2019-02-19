package etc.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * @author choijaeyong on 19/02/2019.
 * @project Algorithm
 * @description
 */
public class exam5 {
  public static void main (String[] args) throws java.lang.Exception
  {

    /*
    5
    19 21 31 42 44
    12
    1 2 3 4 15 16 17 28 29 30 41 43
    * */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    Integer input = Integer.parseInt(br.readLine());
    int[] a = new int[input];

    String line = br.readLine();
    String[] lines = line.split(" ");

    for(int i=0; i < lines.length ; i++) {
      a[i] = Integer.parseInt(lines[i]);
    }


    Integer input2 = Integer.parseInt(br.readLine());
    int[] b = new int[input2];

    String line2 = br.readLine();
    String[] lines2 = line2.split(" ");

    for(int i=0; i < lines2.length ; i++) {
      b[i] = Integer.parseInt(lines2[i]);
    }

    Integer input3 = Integer.parseInt(br.readLine());

    kthElement(a,b,input3);


  }

  public static void kthElement(int[] a , int[] b , int k) {

    int result[] = new int[a.length + b.length];
    int idx=0;

    int ptr1 = 0;
    int ptr2 = 0;

    while(ptr1 <= ptr2 && ptr1 < a.length && ptr2 < b.length) {
      if(a[ptr1] <= b[ptr2]) {
        result[idx] = a[ptr1];
        // k 번째 숫자를 찾아야 하니까. 원하는 인덱스는 -1!
        if(idx == k-1) {
          System.out.println(result[idx]);
          return;
        }
        ptr1++;
        idx++;
      }else {
        result[idx] = b[ptr2];
        if(idx == k-1) {
          System.out.println(result[idx]);
          return;
        }
        ptr2++;
        idx++;
      }
    }

    while(ptr1 <= a.length-1) {
      result[idx] = a[ptr1];
      ptr1++;
    }

    while(ptr2 <= b.length-1) {
      result[idx] = b[ptr2];
      idx++;
    }


    //두개의 배열을 합친 배열
    //System.out.println(Arrays.toString(result));


  }


}
