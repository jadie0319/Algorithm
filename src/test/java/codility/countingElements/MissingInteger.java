package codility.countingElements;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MissingInteger {

    @Test
    void case1() {
        int[] A = {1,3,6,4,1,2};
        assertThat(solution(A)).isEqualTo(5);
    }

    @Test
    void case2() {
        int[] A = {1,2,3};
        assertThat(solution(A)).isEqualTo(4);
    }

    @Test
    void case3() {
        int[] A = {-1,-3};
        assertThat(solution(A)).isEqualTo(1);
    }


    public static int solution(int[] A) {
        // Arrays 이용시 88%
        // foreach 사용시 100%

        //Set<Integer> set2 = Arrays.stream(A).boxed().collect(Collectors.toSet());
        Set set = new HashSet();
        for (int number : A) {
            set.add(number);
        }

        for (int i=1 ; i < Integer.MAX_VALUE ; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
