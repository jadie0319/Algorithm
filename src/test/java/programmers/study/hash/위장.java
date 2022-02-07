package programmers.study.hash;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;

public class 위장 {

    @Test
    void case1() {
        String[][] input = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int solution = solution(input);
        assertThat(solution).isEqualTo(5);
    }


    public int solution(String[][] clothes) {
        Hashtable<String,Integer> table = new Hashtable<String,Integer>();
        createClothMap(clothes, table);

        int answer = 1;
        Collection<Integer> values = table.values();
        for (Integer value : values) {
            answer = answer * (value + 1);
        }
        // 아무것도 안입은경우
        answer = answer -1;
        return answer;
    }

    private void createClothMap(String[][] clothes, Hashtable<String, Integer> table) {
        for(int i = 0; i < clothes.length ; i++) {
            if(table.containsKey(clothes[i][1])) {
                table.replace(clothes[i][1], table.get(clothes[i][1]) + 1);
            } else {
                table.put(clothes[i][1], 1);
            }
        }
    }
}
