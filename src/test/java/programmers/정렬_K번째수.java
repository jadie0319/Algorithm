package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 정렬_K번째수 {

    @Test
    void test() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {
                {2,5,3},
                {4,4,1},
                {1,7,3}
        };
        int[] solution = solution(array, commands);
        assertThat(solution).containsExactly(5,6,3);
    }

    // 2~5 까지 잘라서 정렬 후 3번째 숫자 반환
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            List<Integer> list = subArray(array, command[0]-1, command[1]-1);
            Collections.sort(list);
            answer.add(list.get(command[2]-1));
        }

        return answer.stream().mapToInt(k -> k).toArray();
    }

    private List<Integer> subArray(int[] array, int startIndex, int endIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i=startIndex ; i <= endIndex ; i++ ) {
            list.add(array[i]);
        }
        return list;
    }
}
