package codility.iterations;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryGap {

    // 9 -> 1001  result: 2
    // 529 -> 1000010001 binary gap: 4,3  result: 4
    // 20 -> 10100 result: 1
    // 15 -> 1111 0
    // 32 -> 100000 0
    // 1041 -> 10000010001 binary gap: 5,3 result: 5

    // 정규표현식.... 사용해보고 싶었는데 실패.

    @Test
    void case1() {
        int solution = solution(9);
        assertThat(solution).isEqualTo(2);
    }

    public static  int solution(int N) {
        String binaryString = Integer.toBinaryString(N);

        List<Integer> onePositionList = new ArrayList<>();
        for (int i = 0 ; i < binaryString.length() ; i++) {
            if (binaryString.charAt(i) == '1') {
                onePositionList.add(i);
            }
        }

        int max = 0;
        if (onePositionList.size() > 1) {
            for (int i=0; i < onePositionList.size() - 1 ; i++) {
                max = Math.max(onePositionList.get(i + 1) - onePositionList.get(i), max);
            }
        } else {
            return 0;
        }

        return max-1;
    }

}
