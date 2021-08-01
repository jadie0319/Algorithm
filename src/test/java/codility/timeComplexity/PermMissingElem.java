package codility.timeComplexity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PermMissingElem {

    @Test
    void case1() {
        int[] A = {2,3,1,5};
        assertThat(solution(A)).isEqualTo(4);
    }

    @Test
    void case2() {
        int[] A = {1};
        assertThat(solution(A)).isEqualTo(2);
    }

    @Test
    void case3() {
        int[] A = {2,3,4,5};
        assertThat(solution(A)).isEqualTo(1);
    }


    public static int solution(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int i=0; i < length ; i++) {
            if (i+1 != A[i]) {
                return i+1;
            }
        }

        return length+1;
    }
}
