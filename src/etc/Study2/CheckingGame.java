package etc.Study2;

/**
 * @author choijaeyong on 13/02/2019.
 * @project Algorithm
 * @description
 */
public class Test3 {
  public static void main(String[] args) {
    String[] B = {"..X..." , "......" , "....X." , ".X...." , "..X.X." , "...O.."};

    for(String b : B) {
      System.out.println(b);
    }

    solution(B);

  }

  public static int solution(String[] B) {
    // write your code in Java SE 8

    int bLength = B.length;
    Jafar jafar = null;

    int length = B.length;
    char[][] chars= new char[length][length];

    for(int i=0; i < B.length ; i++) {
      String str = B[i];
      for(int j=0; j < str.length() ; j++) {
        chars[i][j] = str.charAt(j);
        if(str.charAt(j) == 'O') {
          jafar = new Jafar(i,j);
        }
      }
    }

    Board board = new Board(chars);









    System.out.println("jafar 위치 : "+jafar.getY() + "  " + jafar.getX());











    return 0;
  }


}

class Board {
  private char[][] board;

  public Board(char[][] board) {
    this.board = board;
  }

}


class Jafar {
  private int x;
  private int y;
  public Jafar(int y, int x) {
    this.y = y;
    this.x = x;
  }
  public void moveUL() {
    this.x--;
    this.y++;
  }
  public void moveUR() {
    this.x++;
    this.y++;
  }

  public boolean isMoveUL(int y, int x) {
//    if(y >= board.length || x >= board.length) {
//      return false;
//    }


    return true;
  }



  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }


}