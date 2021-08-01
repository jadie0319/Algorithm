package codility.countingElements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermCheck {

    @Test
    void case1() {
        int[] A = {4,1,3,2};
        assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    void case2() {
        int[] A = {4,1,3};
        assertThat(solution(A)).isEqualTo(0);
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i=0 ; i < A.length ; i++) {
            if (A[i] != i +1 ) {
                return 0;
            }
        }
        return 1;
    }
}
