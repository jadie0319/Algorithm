package etc.Study4;

import java.util.Arrays;

/**
 * @author choijaeyong on 03/03/2019.
 * @project Algorithm
 * @description
 */
public class Main2 {
  public static void main(String[] args) {
    int U = 2;
    int L = 3;
    int[] C = {0,0,1,2,2};

    System.out.println(solution(U,L,C));
  }

  public static String solution(int U, int L, int[] C) {

    int length = C.length;
    int[][] arr = new int[2][length];

    System.out.println("C : " + Arrays.toString(C));
    for(int i=0; i < length ; i++) {
      if(C[i] == 2) {
        arr[0][i] = 1;
        U--;
        arr[1][i] = 1;
        L--;
        C[i] = 0;
      }
    }
    for(int i=0; i < 2 ; i++) {
      for(int j=0 ; j < length ; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
    System.out.println("U : " + U + "   L : " + L);
    System.out.println();

    System.out.println("C : " + Arrays.toString(C));
    for(int i=0; i < length ; i++) {
      if(arr[0][i] != 1) {
        if(U <= 0 || C[i] <= 0) {
          break;
        }
        arr[0][i] = 1;
        U--;
        C[i]--;
      }
    }

    for(int i=0; i < 2 ; i++) {
      for(int j=0 ; j < length ; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
    System.out.println("U : " + U + "   L : " + L);
    System.out.println();

    System.out.println("C : " + Arrays.toString(C));
    for(int i=0 ; i < length ; i ++) {
      if(arr[1][i] != 1) {
        if(L <=0 || C[i] <= 0 ) {
          continue;
        }
        arr[1][i] =1;
        L--;
        C[i]--;
      }
    }

    for(int i=0; i < 2 ; i++) {
      for(int j=0 ; j < length ; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

    System.out.println("U : " + U + "   L : " + L);

    if(U != 0 || L != 0) {
      return "IMPOSSIBLE";
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i < 2 ; i++) {
      for(int j=0 ; j < length ; j++) {
        sb.append(arr[i][j]);
      }
      sb.append(",");
    }
    // 마지막 컴마 짜르기
    sb.setLength(sb.length()-1);
    return sb.toString();
  }

}
