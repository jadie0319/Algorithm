package programmers;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class 정렬_가장큰수_다시 {

    @Test
    void case1() {
        int[] numbers = {6, 10, 2};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("6210");
    }

    @Test
    void case2() {
        int[] numbers = {3, 30, 34, 5, 9};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("9534330");
    }

    @Test
    void case3() {
        int[] numbers = {6, 10, 2, 0};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("62100");
    }

    @Test
    void case4() {
        int[] numbers = {0, 0, 0};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("0");
    }

    @Test
    void case5() {
        int[] numbers = {0, 0, 0, 70};
        String solution = solution(numbers);
        assertThat(solution).isEqualTo("70000");
    }



    private static StringBuilder SB = new StringBuilder();
    private static String MAXSTR = "0";

    public String solution(int[] numbers) {
        MAXSTR = "0";
        permutation(numbers, 0, numbers.length);
        if (Character.getNumericValue(MAXSTR.charAt(0)) == 0) {
            return "0";
        }
        return MAXSTR;
    }

    static void permutation(int[] numbers, int depth, int numberLength) {
        if (depth == numberLength) {
            String mergedNumber = merge(numbers, numberLength);
            //Long result = Long.valueOf(mergedNumber);
            compareNumber(mergedNumber);
            return;
        }

        for (int i = depth; i < numberLength; i++) {
            swap(numbers, depth, i);
            permutation(numbers, depth + 1, numberLength);
            swap(numbers, depth, i);
        }
    }

    private static void compareNumber(String mergedNumber) {
        if (mergedNumber.equals(MAXSTR)) {
            return;
        }

        if (MAXSTR.equals("0")) {
            MAXSTR = mergedNumber;
            return;
        }

        if (mergedNumber.length() > MAXSTR.length()) {
            MAXSTR = mergedNumber;
            return;
        }

        for (int i=0 ; i < mergedNumber.length() ; i++ ) {
            int targetFirstNumber = Character.getNumericValue(mergedNumber.charAt(i));
            int maxStrFirstNumber = Character.getNumericValue(MAXSTR.charAt(i));
            if (targetFirstNumber > maxStrFirstNumber) {
                MAXSTR = mergedNumber;
                return;
            } else if (targetFirstNumber < maxStrFirstNumber) {
                return;
            }
        }

        BigInteger result = new BigInteger(mergedNumber);
        if (result.compareTo(new BigInteger(MAXSTR)) == 1) {
            MAXSTR = mergedNumber;
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static String merge(int[] arr, int r) {
        SB.setLength(0);
        for (int number : arr) {
            SB.append(number);
        }
        return SB.toString();
    }

    @Test
    void parseTest() {
        String str = "12345";
        System.out.println(Character.getNumericValue(str.charAt(0)));
    }
}
