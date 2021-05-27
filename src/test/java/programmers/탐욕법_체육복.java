package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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


    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Student> studentList = new ArrayList<>();
        Map<Integer, Student> map = new HashMap<>();

        for (int i=1 ; i <= n ; i++) {
            //studentList.add(new Student(i));
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





        return answer;
    }

    static class Students {
        private List<Student> studentList;
        public Students(List<Student> students) {
            this.studentList = students;
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
    }
}
