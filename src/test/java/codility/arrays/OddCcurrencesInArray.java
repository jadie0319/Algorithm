package codility.arrays;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OddCcurrencesInArray {

    @Test
    void case1() {
        int[] arr = {9,3,9,3,9,7,9};
        assertThat(solution(arr)).isEqualTo(7);
    }

    @Test
    void test() {
        int k = 5;
        
        System.out.println();
    }

    public static int solution(int[] A) {
        // 88%. 0.008 초 차이로 실패
        Set<Integer> set = new LinkedHashSet<>();
        for (int k : A) {
            if (set.contains(k)) {
                set.remove(k);
            } else {
                set.add(k);
            }
        }
        return set.stream().findAny().get();
    }

    public static int solution2(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : A) {
            map.computeIfPresent(number, (key,value) -> value + 1);
            map.putIfAbsent(number,1);
        }
        // 55%  타임아웃.
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findAny().get();
    }
}
