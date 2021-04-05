package ProgrammersNew.kakao2018.question1;

/**
 * @author choijaeyong on 2020/08/25.
 * @project Algorithm
 * @description
 * 비밀지도
 */
public class Question1 {

  public static void main(String[] args) {
    int n = 6;
    int[] arr1 = {46,33,33,22,31,50};
    int[] arr2 = {27,56,19,14,14,10};
    String[] strings = solution(n, arr1, arr2);
    for (String str : strings) {
      System.out.println(str);
    }
  }

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i=0 ; i < n ; i++) {
      StringBuilder sb = new StringBuilder();
      int num1 = arr1[i];
      int num2 = arr2[i];
      int k = num1 | num2;
      //String str = Integer.toBinaryString(k);
      // %0 + n + d 로 하면 안되고, % + n + s 로 하면 된다. 이게 뭐냐....
      String str = String.format("%"+n+"s", Integer.toBinaryString(k));
      System.out.println("===" + str);

      for (int j = 0 ; j < n ; j++) {
        if (str.charAt(j) == '1') {
          sb.append("#");
        } else {
          sb.append(" ");
        }
      }
      answer[i] = sb.toString();
//      answer[i] = sb.toString().replaceAll("( )+", " ");
    }
    return answer;
  }

}

//String[] result = new String[n];
//        for (int i = 0; i < n; i++) {
//            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            result[i] = String.format("%" + n + "s", result[i]);
//            result[i] = result[i].replaceAll("1", "#");
//            result[i] = result[i].replaceAll("0", " ");
//        }
//
//        return result;