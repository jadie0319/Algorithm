package codility.countingElements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxCounters {
    // 정확도 100%, 효율성 0%

    @Test
    void case1() {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] solution = solution(N, A);
        assertThat(solution).containsExactly(3, 2, 2, 4, 2);
    }

    @Test
    void case2() {
        int N = 5;
        int[] A = {3};
        int[] solution = solution(N, A);
        assertThat(solution).containsExactly(0,0,1,0,0);
    }

    public static int[] solution(int N, int[] A) {
        CalculatedArray calculatedArray = new CalculatedArray(N + 1, new int[N]);
        int length = A.length;
        for (int i = 0; i < length; i++) {
            calculatedArray.calculate(A[i]);
        }
        return calculatedArray.getArr();
    }

    private static class CalculatedArray {
        private int criteria;
        private int[] arr;

        public CalculatedArray(int criteria, int[] arr) {
            this.criteria = criteria;
            this.arr = arr;
        }

        public void calculate(int number) {
            if (number != criteria) {
                increase(number - 1);
                return;
            }
            fillMaxNumber();
        }

        private void increase(int index) {
            arr[index] = arr[index] + 1;
        }

        private void fillMaxNumber() {
            int max = Arrays.stream(arr).map(k -> k).max().getAsInt();
            Arrays.fill(arr, max);
        }

        public int[] getArr() {
            return arr;
        }
    }
}