package codility.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CyclicRotation {

    @Test
    void case1() {
        int[] A = {3, 8, 9, 7, 6};
        int[] solution = solution(A, 1);
        assertThat(solution).containsExactly(6, 3, 8, 9, 7);
    }

    @Test
    void case2() {
        int[] A = {3, 8, 9, 7, 6};
        int[] solution = solution(A, 2);
        assertThat(solution).containsExactly(7, 6, 3, 8, 9);
    }

    @Test
    void case3() {
        int[] A = {3, 8, 9, 7, 6};
        int[] solution = solution(A, 3);
        assertThat(solution).containsExactly(9, 7, 6, 3, 8);
    }

    public static int[] solution(int[] A, int K) {
        if (Arrays.stream(A).sum() == 0) {
            return A;
        }

        for (int tryCount = 0; tryCount < K; tryCount++) {
            A = rotate(A);
        }

        return A;
    }

    private static int[] rotate(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            if (i + 1 == arr.length) {
                result[0] = k;
            } else {
                result[i + 1] = k;
            }
        }
        return result;
    }
}
