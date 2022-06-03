package dongbinna.part02.chapter04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam01 {

    @Test
    void case1() {
        int input = 5;
        String[] commands = {"R","R","R","U","D","D"};
        assertThat(solution(input,commands)).isEqualTo("3 4");
    }

    private static String solution(int input, String[] commands) {
        Point point = new Point(1,1);
        for (String command : commands) {
            if (!point.movable(Direction.valueOf(command), input)) {
                continue;
            }
            point.move(Direction.valueOf(command));
        }
        return point.print();
    }

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
           this.x = x;
           this.y = y;
        }

        public void move(Direction command) {
            if (command == Direction.L) {
                this.y = y - 1;
            } else if (command == Direction.R) {
                this.y = y + 1;
            } else if (command == Direction.U) {
                this.x = x - 1;
            } else if (command == Direction.D) {
                this.x = x + 1;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean movable(Direction command, int size) {
            if (command == Direction.L && this.y - 1 <= 0) {
                return false;
            }
            if (command == Direction.R && this.y + 1 > size) {
                return false;
            }
            if (command == Direction.U && this.x - 1 <= 0) {
                return false;
            }
            if (command == Direction.D && this.x + 1 > size) {
                return false;
            }
            return true;
        }

        private void checkPosition(int size) {
            if (this.x <= 0 || this.x > size || this.y <= 0 || this.y > size) {
                throw new RuntimeException();
            }
        }

        public String print() {
            return x + " " + y;
        }
    }

    enum Direction {
        L,
        R,
        U,
        D
        ;
    }


}
