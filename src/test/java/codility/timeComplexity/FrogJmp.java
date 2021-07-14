package codility.timeComplexity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrogJmp {

    @Test
    void case1() {
        int solution = solution(10, 85, 30);
        assertThat(solution).isEqualTo(3);
    }

    public static int solution(int X, int Y, int D) {
        double distance = Y-X;
        double result = Math.ceil(distance / D);
        return (int)result;
    }

}
