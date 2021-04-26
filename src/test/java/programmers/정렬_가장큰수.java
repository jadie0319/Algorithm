package programmers;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 정렬_가장큰수 {

    @Test
    void case1() {
        int[] numbers = {6,10,2};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("6210");
    }

    @Test
    void case2() {
        int[] numbers = {3,30,34,5,9};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("9534330");
        // 3 , 30 의 순서는 어떻게??...
    }

    public String solution2(int[] numbers) {
        Map<Integer, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            int k;
            if (10 <= number && number <= 99) {
                k = number % 10;
            } else if (100 <= number && number <= 999) {
                k = number % 100;
            } else if (number == 1000) {
                k = 1;
            } else {
                k = number;
            }

            if (map.containsKey(k)) {
                List<String> strings = map.get(k);
                strings.add(String.valueOf(number));
            } else {
                map.putIfAbsent(k, Arrays.asList(String.valueOf(number)));
            }

        }

        StringBuilder stringBuilder = new StringBuilder();

        if (map.size() == numbers.length) {
            Set<Integer> intSet = map.keySet();
            ArrayList<Integer> intList = new ArrayList<>(intSet);
            Collections.sort(intList, Comparator.reverseOrder());
            for (Integer number : intList) {
                List<String> strings = map.get(number);
                stringBuilder.append(map.get(number));
            }
        }

        return stringBuilder.toString();
    }


    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();

        for (int number : numbers) {
            numberList.add(String.valueOf(number));
        }
        Collections.sort(numberList, (s1,s2) -> (s2+s1).compareTo(s1+s2));

        if (numberList.get(0).equals("0")) {
            return "0";
        }
        String answer = "";
        for (String number : numberList) {
            answer += number;
        }
        return answer;
    }

}
