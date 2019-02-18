package etc.test1;

/**
 * @author choijaeyong on 18/02/2019.
 * @project Algorithm
 * @description
 */
public class exam4 {

  int biggestPath = 0;
  int[][] board;
  boolean[][] marked;

  public static void main(String[] args) {
    int[][] inputs = {{9,1,1,0,7},{1,0,2,1,0},{1,9,1,1,0}};

    exam4 ex = new exam4();
    System.out.println(ex.solution(inputs));

  }

  public int solution(int[][] Board) {

    int rowLength = Board.length;
    int colLength = Board[0].length;

    this.board = Board;
    this.marked = new boolean[rowLength][colLength];

    for(int i=0; i < rowLength ; i++) {
      for(int j=0; j < colLength ; j++) {
        // start point
        findBiggestPath(i,j,new StringBuilder());
      }
    }
    return biggestPath;
  }

  public void findBiggestPath(int y , int x , StringBuilder path) {
    boolean flag;

    try {
      flag =  marked[y][x];
    }catch(Exception e) {
      return;
    }


    if(!flag) {
      // flag == false , add path
      path.append(board[y][x]);
    } else {
      return;
    }

    if(path.toString().length() >= 4) {
      biggestPath = Math.max(biggestPath , Integer.parseInt(path.toString()));
      path.delete(path.toString().length() - 1 , path.toString().length());
      return;
    }

    marked[y][x] = true;

    findBiggestPath(y+1 , x , path);
    findBiggestPath(y , x+1 , path);
    findBiggestPath(y-1 , x , path);
    findBiggestPath(y , x-1 , path);

    path.delete(path.toString().length()-1, path.toString().length());
    marked[y][x] = false;

  }

}
