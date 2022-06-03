package dongbinna.part02.chapter05;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam02 {

    @Test
    void case1() {
        String input = "5 6";
        int[][] arr = {{1,0,1,0,1,0},{1,1,1,1,1,1},{0,0,0,0,0,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};
        assertThat(solution(input,arr)).isEqualTo(10);
    }

    @Test
    void case2() {
        String input = "3 3";
        int[][] arr = {{1,1,0},{0,1,0},{0,1,1}};
        assertThat(solution(input,arr)).isEqualTo(5);
    }

    private static int solution(String input, int[][] arr) {
        Board board = new Board(arr);
        int result = board.start();
        return result;
    }

    static class Board {
        private Queue<Point> queue;
        private int[][] arr;
        private boolean[][] visit;

        public Board(int[][] arr) {
            this.arr = arr;
            this.visit = new boolean[arr.length][arr[0].length];
            queue = new LinkedList<>();
        }

        public int start() {
            int answer = 1;
            queue.add(new Point(0,0));
            while(!queue.isEmpty()) {
                Point point = queue.poll();
                visit[point.getY()][point.getX()] = true;
                for (Direction direction : Direction.values()) {
                    if(movableDirection(point,direction,visit)) {
                        Point moveablePoint = new Point(point.getX() + direction.x, point.getY() + direction.y);
                        if (moveablePoint.getY() == arr.length-1 && moveablePoint.getX() == arr[0].length-1) {
                            System.out.println("x : " + moveablePoint.getX() + " y: " + moveablePoint.getY());
                            return ++answer;
                        }
                        queue.add(moveablePoint);
                    }
                }
                answer++;
            }

            return answer;
        }

        private boolean movableDirection(Point point, Direction direction, boolean[][] visit) {
            int movedX = point.getX() + direction.x;
            int movedY = point.getY() + direction.y;
            if (movedX < 0 || movedX >= arr[0].length || movedY < 0 || movedY >= arr.length) {
                return false;
            }
            if (visit[movedY][movedX]) {
                return false;
            }

            if (direction == Direction.DOWN && arr[movedY][point.getX()] == 1) {
                return true;
            } else if (direction == Direction.RIGHT && arr[point.getY()][movedX] == 1) {
                return true;
            }

            return false;
        }
    }

    enum Direction {
        UP(0,-1),
        DOWN(0,+1),
        LEFT(-1,0),
        RIGHT(1,0)
        ;
        private int x;
        private int y;
        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void getMovablePoints() {

        }
    }
}
