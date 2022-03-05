package programmers;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 힙_더맵게_다시 {

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    // 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
    // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

    @Test
    void case1() {
        int[] scovile = {1,2,3,9,10,12};
        int k = 7;
        int result = solution(scovile, k);
        assertThat(result).isEqualTo(2);
    }

    public static int solution(int[] scoville, int K) {
        ScovilleCalculator scovilleCalculator = new ScovilleCalculator(scoville, K);
        return scovilleCalculator.calculate();
    }

    static class ScovilleCalculator {
        private PriorityQueue<Integer> queue = new PriorityQueue<>();
        private Integer targetScovile;

        public ScovilleCalculator(int[] scovilles, int k) {
            for (int scoville : scovilles) {
                queue.offer(scoville);
            }
            this.targetScovile = k;
        }

        public boolean hasLowerThanTargetScoville() {
            Integer lowestScoville = queue.peek();
            return lowestScoville < targetScovile;
        }

        public int calculate() {
            int tryCount = 0;
            while (hasLowerThanTargetScoville()) {
                if (queue.size() == 1) {
                    return -1;
                }

                Integer firstLowerScoville = queue.poll();
                Integer secondLowerScoville = queue.poll();

                int newScoville = calculateScoville(firstLowerScoville, secondLowerScoville);
                queue.add(newScoville);
                tryCount++;
            }

            return tryCount;
        }

        private int calculateScoville(Integer firstLowerScoville, Integer secondLowerScoville) {
            return firstLowerScoville + (secondLowerScoville * 2);
        }
    }
}
