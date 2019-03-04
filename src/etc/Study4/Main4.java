package etc.Study4;

/**
 * @author choijaeyong on 04/03/2019.
 * @project Algorithm
 * @description
 */
public class Main4 {

  int biggestPath = 0;
  int[][] board;
  boolean[][] visited;


  public static void main(String[] args) {
    int[][] inputs = {{9,1,1,0,7},{1,0,2,1,0},{1,9,1,1,0}};

    Main4 main = new Main4();
    System.out.println(main.solution(inputs));



  }

  public int solution(int[][] Board) {

    int rowLength = Board.length;
    int colLength = Board[0].length;

    this.board = Board;
    this.visited = new boolean[rowLength][colLength];

    for(int i =0 ; i < rowLength ; i++) {
      for(int j=0 ; j < colLength ; j++) {
        findBiggestPath(i,j,new StringBuilder());
      }
    }
    return biggestPath;
  }

  public void findBiggestPath(int y, int x, StringBuilder path) {

    boolean flag;

    try {
      flag = visited[y][x];
    } catch(ArrayIndexOutOfBoundsException e) {
      return;
    }

    if(!flag) {
      path.append(board[y][x]);
    }else {
      // flag is true
      return;
    }

    if(path.toString().length() == 4) {
      biggestPath = Math.max(biggestPath , Integer.parseInt(path.toString()));
      // 맨 끝에 있는 숫자를 없애라.
      path.delete(path.toString().length()-1 , path.toString().length());
      return;
    }

    visited[y][x] = true;

    findBiggestPath(y+1 , x , path);
    findBiggestPath(y , x+1 , path);
    findBiggestPath(y-1 , x , path);
    findBiggestPath(y , x-1 , path);

//    String temp = path.toString();
//    System.out.println(temp);
    path.delete(path.length()-1 , path.length());
    visited[y][x] = false;


  }

}
