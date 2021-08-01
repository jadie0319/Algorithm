package codility.timeComplexity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 정확도 100, 성능 0

public class TapeEquilibrium {

    @Test
    void case1() {
        int[] A = {3,1,2,4,3};
        assertThat(solution(A)).isEqualTo(1);
    }

    @Test
    void copyTest() {
        int[] A = {3,1,2,4,3};
        int[] ints1 = Arrays.copyOfRange(A, 0, 1);
        int[] ints2 = Arrays.copyOfRange(A, 0, 2);
        int[] ints3 = Arrays.copyOfRange(A, 1, 3);
    }

    public static int solution(int[] A) {
        CalculatedArray calculatedArray = new CalculatedArray();
        for (int i=0; i < A.length - 1 ; i++) {
            int position = i;
            calculatedArray.calculate(
                    () -> {
                        int[] first = Arrays.copyOfRange(A, 0, position+1);
                        int[] second = Arrays.copyOfRange(A, position + 1, A.length);
                        return new SplittedArray(first,second);
                    }
            );
        }
        return calculatedArray.min();
    }

    public interface ArraySplitter {
        SplittedArray split();
    }

    public static class SplittedArray {
        private final int[] first;
        private final int[] second;

        public SplittedArray(int[] first, int[] second) {
            this.first = first;
            this.second = second;
        }

        public int calculate() {
            return Math.abs(Arrays.stream(first).sum() - Arrays.stream(second).sum());
        }
    }

    public static class CalculatedArray {

        private final List<Integer> resultList;

        public CalculatedArray() {
            resultList = new ArrayList<Integer>();
        }

        public void calculate(ArraySplitter splitter) {
            SplittedArray splittedArray = splitter.split();
            resultList.add(splittedArray.calculate());
        }

        public int min() {
            return resultList.stream().min(Comparator.comparingInt( (i) -> i)).get();
        }

    }


}
