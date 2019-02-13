package etc.Study2;

/**
 * @author choijaeyong on 13/02/2019.
 * @project Algorithm
 * @description
 * 말 최대로 몇개 먹는지 체크하는 문제.
 */
public class CheckGame2 {

  public static void main(String[] args) {

    String[] B = {"..X..." , "......" , "....X." , ".X...." , "..X.X." , "...O.."};

    for(String b : B) {
      System.out.println(b);
    }

    System.out.println(solution(B));


  }

  public static int solution(String[] B) {
    // write your code in Java SE 8

    CheckGame1 checkGame = new CheckGame1(B);
    checkGame.findMaxBeatCount();
    return checkGame.getMaxBeatCount();
  }

}


class CheckGame1 {
  private char[][] board;
  private int whiteX;
  private int whiteY;
  private int maxBeatCount;
  private final char BLACK_PAWN = 'X';
  private final char EMPTY = '.';
  private final char WHITE_PAWN = 'O';

  public CheckGame1(String[] B) {
    maxBeatCount = 0;
    setBoard(B);
  }

  private void setBoard(String[] B) {
    int length = B.length;
    board = new char[length][length];
    for(int i=0; i < length ; i++) {
      for(int j=0 ; j < length ; j++) {
        board[i][j] = B[i].charAt(j);
        if(B[i].charAt(j) == WHITE_PAWN) {
          whiteY = i;
          whiteX = j;
        }
      }
    }
  }

  public void findMaxBeatCount() {
    moveUL(whiteY-1 , whiteX-1, 0);
    moveUR(whiteY-1, whiteX+1, 0);
  }

  public void moveUL(int y, int x, int beatCount) {
    if(!isPossible(y,x,BLACK_PAWN)) {
      this.maxBeatCount = Math.max(maxBeatCount , beatCount);
      return;
    }
    if(!isPossible(y-1,x-1,EMPTY)) {
      this.maxBeatCount = Math.max(maxBeatCount,beatCount);
      return;
    }

    y -= 1;
    x -= 1;

    moveUL(y-1, x-1,beatCount+1);
    moveUR(y-1, x+1,beatCount+1);
  }

  public void moveUR(int y, int x, int beatCount) {
    if(!isPossible(y,x,BLACK_PAWN)) {
      this.maxBeatCount = Math.max(maxBeatCount , beatCount);
      return;
    }
    if(!isPossible(y-1,x+1,EMPTY)) {
      this.maxBeatCount = Math.max(maxBeatCount,beatCount);
      return;
    }

    y -= 1;
    x += 1;

    moveUL(y-1, x-1,beatCount+1);
    moveUR(y-1, x+1, beatCount+1);
  }



  public boolean isPossible(int y, int x, char c) {
    char field;

    try {
      field = board[y][x];
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
    return field == c;
  }

  public int getMaxBeatCount() {
    return maxBeatCount;
  }


}