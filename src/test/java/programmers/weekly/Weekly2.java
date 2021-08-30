package programmers.weekly;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Weekly2 {

    @Test
    void case1() {
        int[][] scores = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        String solution = solution(scores);
        assertThat(solution).isEqualTo("FBABD");
    }

    @Test
    void case2() {
        int[][] scores = {{50,90},{50 ,87}};
        String solution = solution(scores);
        assertThat(solution).isEqualTo("DA");
    }

    public static String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        int studentCount = scores.length;

        //ready
        List<Student> studentList = new ArrayList<>();
        for (int i=0; i < studentCount ; i++) {
            studentList.add(new Student(i));
        }

        //input
        for (int i=0; i < studentCount ; i++) {
            int[] score = scores[i];
            for (int j=0 ; j < studentCount ; j++) {
                Student student = studentList.get(j);
                student.updateScore(score[j]);
            }
        }

        // calculate
        for (int i=0; i < studentCount ; i++) {
            Student student = studentList.get(i);
            sb.append(student.calculateGrade());
        }

        return sb.toString();
    }

    public static class Student {
        private List<Integer> scores = new ArrayList<>();
        private int studentNo;

        public Student(int studentNo) {
            this.studentNo = studentNo;
        }

        public void updateScore(int score) {
            scores.add(score);
        }

        public String calculateGrade() {
            Integer max = Collections.max(scores);
            Integer min = Collections.min(scores);
            if (!isIncludedSelfScore(max, min)) {
                scores.remove(studentNo);
            }
            double avgScore = scores.stream().mapToInt(k -> k).average().getAsDouble();
            return GradeCalculator.calculate(avgScore);
        }

        private boolean isIncludedSelfScore(int max, int min) {
            int selfScore = scores.get(studentNo);
            int count = 0;
            if (selfScore == max || selfScore == min) {
                for (int i=0; i < scores.size() ; i++) {
                    if (selfScore == scores.get(i)) {
                        count++;
                    }

                    if (count >= 2) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
    }

    public static class GradeCalculator {
        public static String calculate(double score) {
            if (score >= 90) {
                return "A";
            }

            if (score >= 80) {
                return "B";
            }

            if (score >= 70) {
                return "C";
            }

            if (score >= 50) {
                return "D";
            }

            return "F";
        }
    }
}
