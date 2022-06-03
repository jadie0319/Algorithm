package dongbinna.part02.chapter03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam01 {

    @Test
    void case1() {
        int money = 1260;
        assertThat(count(money)).isEqualTo(6);
    }

    private static int count(int money) {
        int answer = 0;
        int[] coinTypes = {500,100,50,10};
        for (int coin : coinTypes) {
            int count = money / coin;
            money = money % coin;
            answer += count;
        }

        return answer;
    }
}
