package dongbinna.part02.chapter09;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exam01 {

    @Test
    void case1() {
        int solution = solution();
    }

    private static int solution() {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node node1 = new Node(1, 10);
        Node node2 = new Node(2, 20);
        Node node3 = new Node(3, 30);
        Node node4 = new Node(4, 10);
        Node node5 = new Node(5, 20);

        queue.add(node1);
        queue.add(node2);
        queue.add(node3);
        queue.add(node4);
        queue.add(node5);

        System.out.println(queue.poll().toString());
        System.out.println(queue.poll().toString());
        System.out.println(queue.poll().toString());
        System.out.println(queue.poll().toString());
        System.out.println(queue.poll().toString());




        return 1;
    }

    static class Node implements Comparable {
        private int number;
        private int value;

        public Node(int number, int value) {
            this.number = number;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            return this.value - ((Node) o).value;
        }
    }
}
