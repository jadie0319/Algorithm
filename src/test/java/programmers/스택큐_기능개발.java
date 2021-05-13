package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 스택큐_기능개발 {

    @Test
    void case1() {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] solution = solution(progresses, speeds);
        assertThat(solution).containsExactly(2,1);
    }

    @Test
    void case2() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};
        int[] solution = solution(progresses, speeds);
        assertThat(solution).containsExactly(1,3,2);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> queue = new LinkedList<>();
        for (int i=0 ; i < progresses.length ; i++) {
            Task task = new Task(progresses[i], speeds[i]);
            queue.add(task);
        }

        // remainWorkDays 7,3,9
        int criteria = 0;
        if (!queue.isEmpty()) {
            criteria = queue.peek().remainWorkDays;
        }
        List<Integer> answerList = new ArrayList<>();
        int result = 0;

        while (!queue.isEmpty()) {
            Task task = queue.peek();
            if (task.getRemainWorkDays() <= criteria) {
                result++;
                queue.poll();
            } else {
                answerList.add(result);
                result = 0;
                criteria = task.getRemainWorkDays();
            }
        }
        answerList.add(result);

        return answerList.stream().mapToInt(k -> k).toArray();
    }

    public static class Task {
        private int remainWorkDays;

        public Task(int progress, int speed) {
            remainWorkDays = calculateRemainWorkDays(progress, speed);
        }

        public int getRemainWorkDays() {
            return remainWorkDays;
        }

        private int calculateRemainWorkDays(int progress, int speed) {
            int remainWorkload = 100 - progress;
            if (remainWorkload % speed == 0) {
                return (100 - progress) / speed;
            } else {
                return ((100 - progress) / speed) + 1;
            }
        }
    }
}
