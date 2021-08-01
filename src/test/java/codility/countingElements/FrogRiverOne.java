package codility.countingElements;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogRiverOne {
    @Test
    void test() {
        int sum = IntStream.rangeClosed(1, 10).sum();
        assertThat(55);
    }

    @Test
    void case1() {
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int solution = solution(X, A);
        assertThat(solution).isEqualTo(6);
    }

    public static int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if (set.size() == X) {
                return i;
            }
        }

        return -1;
    }


}
