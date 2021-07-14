package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class 탐욕법_체육복 {

    @Test
    void case1() {
        int n = 5;
        int[] list = {2,4};
        int[] reserve = {1,3,5};
        int solution = solution(n, list, reserve);
        assertThat(solution).isEqualTo(5);
    }

    @Test
    void case2() {
        int n = 5;
        int[] list = {2,4};
        int[] reserve = {3};
        int solution = solution(n, list, reserve);
        assertThat(solution).isEqualTo(4);
    }

    @Test
    void case3() {
        int n = 3;
        int[] list = {3};
        int[] reserve = {1};
        int solution = solution(n, list, reserve);
        assertThat(solution).isEqualTo(2);
    }

    @Test
    void case4() {
        int n = 3;
        int[] list = {3};
        int[] reserve = {3};
        int solution = solution(n, list, reserve);
        assertThat(solution).isEqualTo(3);
    }

    @Test
    void case5() {
        int n = 12;
        int[] list = {1, 2, 3, 4, 8, 9, 10, 11};
        int[] reserve = {9, 10};
        int solution = solution(n, list, reserve);
        assertThat(solution).isEqualTo(6);
    }


    public int solution(int n, int[] lost, int[] reserve) {
        Map<Integer, Student> map = new HashMap<>();

        for (int i=1 ; i <= n ; i++) {
            map.put(i, new Student(i));
        }

        for (int i=0; i < lost.length ; i++) {
            Student student = map.get(lost[i]);
            student.loseCloth();
        }

        for (int i=0; i < reserve.length ; i++) {
            Student student = map.get(reserve[i]);
            student.hasManyCloth();
        }

        Students students = new Students(map);
        int answer = students.calculate(reserve);


        return answer;
    }

    static class Students {
        private Map<Integer, Student> map;
        public Students(Map<Integer, Student> map) {
            this.map = map;
        }

        public int calculate(int[] reserve) {
            for (int reserverNumber : reserve) {
                Student student = map.get(reserverNumber);
                if (!student.isGiveCloth()) {
                    continue;
                }

                if (checkLeftStudent(reserverNumber - 1, student)) {
                    continue;
                }

                if (checkRightStudent(reserverNumber + 1, student)) {
                    continue;
                }

            }

            int result =0;
            for(Student stu : map.values()) {
                if(stu.isPossibleStudy()) {
                    result++;
                }
            }
            return result;
        }

        private boolean checkLeftStudent(int leftNumber, Student giver) {
            if (leftNumber <= 0 || !giver.isGiveCloth()) {
                return false;
            }
            Student receiver = map.get(leftNumber);
            if (receiver.isReceiveCloth()) {
                receiver.receiveCloth();
                giver.giveCloth();
            }

            return true;
        }
        private boolean checkRightStudent(int rightNumber, Student giver) {
            if (rightNumber > map.size() || !giver.isGiveCloth()) {
                return false;
            }
            Student receiver = map.get(rightNumber);
            if (receiver.isReceiveCloth()) {
                receiver.receiveCloth();
                giver.giveCloth();
            }
            return true;
        }
    }

    static class Student {
        private int number;
        private boolean isLostCloth;
        private boolean hasMoreCloth;

        public Student(int number) {
            this.number = number;
        }

        public void loseCloth() {
            this.isLostCloth = true;
        }

        public void hasManyCloth() {
            this.hasMoreCloth = true;
        }

        public boolean isGiveCloth() {
            return !isLostCloth && hasMoreCloth;
        }

        public boolean isReceiveCloth() {
            return isLostCloth;
        }

        public boolean isPossibleStudy() {
            return !isLostCloth;
            //return !isLostCloth || (isLostCloth && !hasMoreCloth);
        }

        public void receiveCloth() {
            this.isLostCloth = false;
        }

        public void giveCloth() {
            this.hasMoreCloth = false;
        }
    }
}
