package dongbinna.part02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam02 {

    @Test
    void case1() {
        int[] condition = {5,8,3};
        int[] numbers = {2,4,5,4,6};
        assertThat(solution(condition,numbers)).isEqualTo(46);
        // 6 + 6 + 6 + 5 + 6 + 6 + + 5 + 6
    }

    private static int solution(int[] condition, int[] numbers) {
        int answer = 0;

        int m = condition[1]; // m은 숫자가 더해지는 횟수
        int k = condition[2]; // k는 연속해서 더할 수 있는 횟수

        List<Integer> list = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int first = list.get(0);
        int second = list.get(1);

        while(m > 0) {
            for (int i = 0 ; i < k ; i++) {
                if (m == 0) {
                    break;
                }
                answer = answer + first;
                m -= 1;
            }
            if (m == 0) {
                break;
            }
            answer = answer + second;
            m -= 1;
        }
        return answer;
    }
}
