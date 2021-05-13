package programmers;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class 스택큐_주식가격 {

    @Test
    void case1() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] solution = solution(prices);
        assertThat(solution).containsExactly(4, 3, 1, 1, 0);
    }

    public int[] solution(int[] prices) {
        //List<Integer> answerList = new ArrayList<>(prices.length);
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                //answerList.add(stack.peek(), i - stack.peek());
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            //answerList.add(stack.peek(), prices.length - stack.peek() -1);
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        //return answerList.stream().mapToInt(k -> k).toArray();
        return answer;
    }


}
