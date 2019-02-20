package etc.Question2;

/**
 * @author choijaeyong on 20/02/2019.
 * @project Algorithm
 * @description
 */
public class CheckEat {
  public static void main(String[] args) {
    String[] B = {"..X..." , "......" , "....X." , ".X...." , "..X.X." , "...O.."};
    for(String b : B) {
      System.out.println(b);
    }

    System.out.println(solution(B));
  }

  public static int solution(String[] B) {

    CheckGame game = new CheckGame(B);
    game.findMaxBeatCount();

    return game.getMaxBeatCount();
  }

}

class CheckGame {
  private char[][] board;
  private int whiteY;
  private int whiteX;
  private int maxBeatCount;
  private final char BLACK = 'X';
  private final char EMPTY = '.';
  private final char WHITE = 'O';

  public CheckGame(String[] B) {
    maxBeatCount = 0;
    setBoard(B);
  }

  public void setBoard(String[] B) {
    int length = B.length;
    board = new char[length][length];
    for(int i=0; i < length ; i++) {
      for(int j=0; j < length ; j++) {
        board[i][j] = B[i].charAt(j);
        if(board[i][j] == WHITE) {
          whiteY = i;
          whiteX = j;
        }
      }
    }
  }

  public void findMaxBeatCount() {
    moveUL(whiteY-1 , whiteX -1 , 0);
    moveUR(whiteY-1 , whiteX + 1 , 0);
  }

  public void moveUL(int y,int x , int beatCount) {
    if(!isPossible(y,x,BLACK)) {
      this.maxBeatCount = Math.max(maxBeatCount , beatCount);
      return;
    }

    if(!isPossible(y-1,x-1,EMPTY)) {
      this.maxBeatCount = Math.max(maxBeatCount , beatCount);
      return;
    }

    y = y -1;
    x = x -1;

    moveUL(y-1,x-1,beatCount+1);
    moveUR(y-1,x-1,beatCount+1);
  }

  public void moveUR(int y,int x , int beatCount) {
    if(!isPossible(y,x,BLACK)) {
      this.maxBeatCount = Math.max(maxBeatCount , beatCount);
      return;
    }

    if(!isPossible(y-1,x+1,EMPTY)) {
      this.maxBeatCount = Math.max(maxBeatCount,beatCount);
      return;
    }

    y= y-1;
    x=x+1;

    moveUL(y-1,x-1,beatCount+1);
    moveUR(y-1,x+1,beatCount+1);

  }


  public boolean isPossible(int y, int x, char c) {
    char field;
    try{
      field = board[y][x];
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
    return field == c;
  }

  public int getMaxBeatCount() {
    return this.maxBeatCount;
  }
}


