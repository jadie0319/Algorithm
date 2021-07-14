package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 탐욕법_조이스틱 {

    @Test
    void case1() {
        String name = "JEROEN";
        int solution = solution(name);
        assertThat(solution).isEqualTo(56);
    }

    @Test
    void case2() {
        String name = "JAN";
        int solution = solution(name);
        assertThat(solution).isEqualTo(23);
    }

    @Test
    void tt() {
        int k = 'A' - 'B';
        System.out.println(k);
    }

    @Test
    void transform() {
        char ch1 = 'A';
        char ch2 = 'D';
        assertThat(ch2 - ch1).isEqualTo(3);
    }

    public int solution(String name) {
        int answer = 0;

        // 문자열 변환에 필요한 조이스틱 조작 횟수
        // 이동에 필요한 조이스틱 조작 횟수

        JoyStick joyStick = new JoyStick(name);
        joyStick.countTransform();


        System.out.println();


        return answer;
    }


    static class JoyStick {
        private String word;
        private int count;

        public JoyStick(String word) {
            this.word = word;
        }

        public void countTransform() {
            for (int i=0 ; i < word.length() ; i++) {
                char letter = word.charAt(i);
                if (letter <= 'M') {
                    count = count + letter - 'A';
                }else {
                    count = count + 'Z' - letter + 1;
                }

                int nextIndex = i + 1;


            }
        }
    }
}
