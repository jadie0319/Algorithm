package dongbinna.part02.chapter06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 성적이낮은순서로학생출력 {

    public static void main(String[] args) {
        String[] inputs ={"홍길동 95", "이순신 77", "장영실 89"};
        List<Student> studentList = new ArrayList<>();
        for (String input : inputs) {
            String[] studentString = input.split(" ");
            studentList.add(new Student(studentString[0], Integer.parseInt(studentString[1])));
        }

        Collections.sort(studentList);

        System.out.println(studentList.toString());

    }

    static class Student implements Comparable {
        private String name;
        private Integer score;

        public Student(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Object o) {
            Student other = (Student) o;
            return this.score - other.score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
