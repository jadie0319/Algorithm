package programmers;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 힙_더맵게 {
    /*
    섞은 음식의 스코빌 지수 =
     가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */

    @Test
    void case1() {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        int solution = solution(scoville, k);
        assertThat(solution).isEqualTo(2);
    }

    @Test
    void case2() {
        int[] scoville = {1,2,3,4,5};
        // 1 + (2*2) = 5
        // 3 + (5*2) = 13
        // 4 + (13*2) = 30
        // 5 + (30*2) = 65
        int k = 66;
        int solution = solution(scoville, k);
        assertThat(solution).isEqualTo(-1);
    }

    @Test
    void case3() {
        int[] scoville = {6,7,12,18,19,20};
        // 1 + (2*2) = 5
        // 3 + (5*2) = 13
        // 4 + (13*2) = 30
        // 5 + (30*2) = 65
        int k = 5;
        int solution = solution(scoville, k);
        assertThat(solution).isEqualTo(0);
    }

    public int solution(int[] scoville, int K) {
        Foods foods = new Foods(scoville, K);
        return foods.calculate();
    }


    static class Foods {
        private PriorityQueue<Integer> queue;
        private int targetScoville;

        public Foods(int[] scoville, int targetScoville) {
            queue = new PriorityQueue<>();
            for (int scovileNumber : scoville) {
                queue.add(scovileNumber);
            }
            this.targetScoville = targetScoville;
        }

        public boolean isOverTargetScoville() {
            int lowestScoville = queue.peek();
            return lowestScoville >= targetScoville;
        }

        public int calculateScoville(int first, int second) {
            return first + (second * 2);
        }

        public int calculate() {
            int tryNo = 0;
            while (!isOverTargetScoville()) {
                if (queue.size() == 1) {
                    return -1;
                }
                Integer first = queue.poll();
                Integer second = queue.poll();

                int newScovilleNumber = calculateScoville(first, second);
                queue.add(newScovilleNumber);
                tryNo++;
            }
            return tryNo;
        }
    }



}
