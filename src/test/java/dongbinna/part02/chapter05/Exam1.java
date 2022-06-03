package dongbinna.part02.chapter05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam1 {

    @Test
    void case1() {
        int[][] arr = {{0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
        assertThat(solution(arr)).isEqualTo(3);
    }

    private static int solution(int[][] arr) {
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        int answer = 0;
        for (int i=0; i < arr.length ; i++) {
            for (int j=0 ; j < arr[0].length ; j++) {
                if (dfs(i,j,arr,visit)) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    private static boolean dfs(int y, int x, int[][] arr, boolean[][] visit) {
        if (x <= -1 || y <= -1 || x >= visit[0].length || y >= visit.length) {
            return false;
        }

        if (arr[y][x] == 0 && !visit[y][x]) {
            visit[y][x] = true;
            dfs(y-1,x, arr, visit);
            dfs(y,x-1, arr, visit);
            dfs(y+1,x, arr, visit);
            dfs(y,x+1, arr, visit);
            return true;
        }
        return false;
    }

}
