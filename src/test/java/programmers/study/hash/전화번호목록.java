package programmers.study.hash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 전화번호목록 {

    @Test
    void case1() {
        String[] input = {"119", "97674223", "1195524421"};
        boolean result = solution(input);
        assertThat(result).isFalse();
    }

    @Test
    void case2() {
        String[] input = {"123", "456", "789"};
        boolean result = solution(input);
        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        String[] input = {"12", "123", "1235", "567", "88"};
        boolean result = solution(input);
        assertThat(result).isFalse();
    }

    public boolean solution(String[] phone_book) {
        if (phone_book.length == 1) {
            return false;
        }

        for (int i = 0; i < phone_book.length - 1; i++) {
            String prefix = phone_book[i];

            for (int j = i + 1; j < phone_book.length; j++) {
                String target = phone_book[j];
//                if (equalsPhoneNumber(prefix, target)) {
//                    return false;
//                }
                if (target.length() < prefix.length()) {
                    continue;
                }

                if (target.startsWith(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean equalsPhoneNumber(String prefix, String target) {
        if (prefix.length() > target.length()) {
            return false;
        }

        for (int i=0 ; i < prefix.length() ; i++) {
            if (prefix.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
