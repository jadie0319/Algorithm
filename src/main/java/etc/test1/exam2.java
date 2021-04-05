package etc.test1;

/**
 * @author choijaeyong on 18/02/2019.
 * @project Algorithm
 * @description
 */
public class exam2 {
  public static void main(String[] args) {
    int U = 3;
    int L = 2;
    int[] C = {2,1,1,0,1};

    exam2 ex = new exam2();
    System.out.println(ex.solution(U,L,C));

  }

  public String solution(int U, int L, int[] C) {

    int length = C.length;
    int[][] array = new int[2][length];

    for(int i=0; i < length ; i++) {
      if(C[i] == 2) {
        array[0][i] = 1;
        U--;
        array[1][i] = 2;
        L--;
        C[i] = 0;
      }
    }

    for(int i=0; i < length ; i++) {
      if(array[0][i] != 1) {
        if(U <= 0 || C[i] <= 0) {
          break;
        }
        array[0][i] = 1;
        U--;
        C[i]--;
      }
    }


    for(int i=0; i < length ; i++) {
      if(array[1][i] != 1) {
        if(L <= 0 || C[i] <= 0) {
          continue;
        }
        array[1][i] = 1;
        L--;
        C[i]--;
      }
    }

    if(!(U==0 && L==0)) {
      return "IMPOSSIBLE";
    } else {
      for(int i=0; i < 2 ; i++) {
        for(int j=0; j < length ; j++) {
          if(array[i][j] == -1)
            array[i][j] = 0;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i < 2 ; i++) {
      for(int j=0; j < length ; j++) {
        sb.append(array[i][j]);
      }
      sb.append(",");
    }
    sb.setLength(sb.length()-1);

    return sb.toString();





//    for(int i=0; i < array.length ; i++) {
//      for(int j=0; j < array[0].length ; j++) {
//        System.out.print(array[i][j] + " ");
//      }
//      System.out.println();
//    }

  }
}
