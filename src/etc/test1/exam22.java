package etc.test1;

/**
 * @author choijaeyong on 18/02/2019.
 * @project Algorithm
 * @description
 */
public class exam22 {

  public static void main(String[] args) {
    exam22 ex = new exam22();

    int[] tt = {0,0,0,0,0};
    System.out.println(ex.solution(0,0, tt));
  }


  public String solution(int U, int L, int[] C) {
    int sum =0;
    StringBuilder up = new StringBuilder();
    StringBuilder down = new StringBuilder();

    int length = C.length;

    for(int i=0; i < length ; i++) {
      sum += C[i];
    }

    if(U+L != sum) {
      return "IMPOSSIBLE";
    }

    for(int i=0 ; i < length ; i++){
      if(C[i] == 2) {
        up.append(1);
        down.append(1);
        U--; L--;
      } else if(C[i] == 0) {
        up.append(0);
        down.append(0);
      } else if(C[i] == 1) {
        if(U > L) {
          up.append(1);
          down.append(0);
          U--;
        } else {
          up.append(0);
          down.append(1);
          L--;
        }
      }
    }

    up.append("," + down.toString());
    return up.toString();

  }
}
