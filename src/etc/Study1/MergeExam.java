package etc.Study1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author choijaeyong on 12/02/2019.
 * @project Algorithm
 * @description
 */
public class MergeExam {
  public static void main(String[] args) throws java.lang.Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input1 = Integer.parseInt(br.readLine());
    String arrayString = br.readLine();
    String[] arrayStrings1 = arrayString.split(" ");
    int[] arrayIntegers1 = new int[input1];

    for(int i=0; i < input1 ; i++) {
      arrayIntegers1[i] = Integer.parseInt(arrayStrings1[i]);
    }

    int input2 = Integer.parseInt(br.readLine());
    String arrayString2 = br.readLine();
    String[] arrayStrings2 = arrayString2.split(" ");
    int[] arrayIntegers2 = new int[input2];

    for(int i=0; i < input2 ; i++) {
      arrayIntegers2[i] = Integer.parseInt(arrayStrings2[i]);
    }

    // 작은 배열이 앞에 앞에 파라미터로.
    int[] result;
    if(arrayIntegers1.length < arrayIntegers2.length) {
      result = sort(arrayIntegers1,arrayIntegers2);
    } else {
      result = sort(arrayIntegers2,arrayIntegers1);
    }

    System.out.println(Arrays.toString(result));

    // 19 21 31 42 44
    // 1 2 3 4 15 16 17 28 29 30 41 43



  }

  public static int[] sort(int[] arr1 , int[] arr2) {

    int startPointer1 = 0;
    int startPointer2 = 0;
    int end1 = arr1.length-1;
    int end2 = arr2.length-1;

    int resultPointer = 0;

    int[] result = new int[arr1.length + arr2.length];

    while(startPointer1 <= end1 && startPointer2 <= end2) {
      System.out.println("startPointer1 : " + startPointer1 + " startPointer2 : " + startPointer2 + " resultPointer : " + resultPointer + "     arr : " + Arrays.toString(result));
      if(arr1[startPointer1] < arr2[startPointer2]) {
        result[resultPointer] = arr1[startPointer1];
        startPointer1++;
        resultPointer++;
      } else {
        result[resultPointer] = arr2[startPointer2];
        startPointer2++;
        resultPointer++;
      }
    }

    while(startPointer1 <= end1) {
      result[resultPointer] = arr1[startPointer1];
      startPointer1++;
      resultPointer++;
      System.out.println("result :  " + Arrays.toString(result));
    }

    while(startPointer2 <= end2) {
      result[resultPointer] = arr2[startPointer2];
      startPointer2++;
      resultPointer++;
      System.out.println("result :  " + Arrays.toString(result));
    }

    return result;
  }


}
