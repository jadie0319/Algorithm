package codility.timeComplexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TapeEquilibrium2 {

    @Test
    void case1() {
        int[] A = {3,1,2,4,3};
        assertThat(solution2(A)).isEqualTo(1);
    }

    public static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i=0 ; i < A.length ; i++) {
            int[] first = Arrays.copyOfRange(A, 0, i+1);
            int[] second = Arrays.copyOfRange(A, i + 1, A.length);
            int abs = Math.abs(Arrays.stream(first).sum() - Arrays.stream(second).sum());
            if (abs < min) {
                min = abs;
            }
        }
        return min;
    }

    public static int solution2(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i=0 ; i < A.length ; i++) {
            int first = 0;
            int second = 0;
            for (int j = 0 ; j < A.length ; j++) {
                if (j <= i) {
                    first += A[j];
                }else {
                    second += A[j];
                }
            }
            int abs = Math.abs(first - second);
            if (abs < min) {
                min = abs;
            }
        }
        return min;
    }


}
