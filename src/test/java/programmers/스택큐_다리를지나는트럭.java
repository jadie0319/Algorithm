package programmers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 스택큐_다리를지나는트럭 {

    @Test
    void case1() {
        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7,4,5,6};
        int solution = solution(bridgeLength, weight, truckWeights);
        assertThat(solution).isEqualTo(8);
    }

    @Test
    void case2() {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10};
        int solution = solution(bridgeLength, weight, truckWeights);
        assertThat(solution).isEqualTo(101);
    }

    @Test
    void case3() {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};
        int solution = solution(bridgeLength, weight, truckWeights);
        assertThat(solution).isEqualTo(110);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(bridge_length, weight);

        Queue<Truck> waitingTruck = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            Truck truck = new Truck(truckWeight);
            waitingTruck.add(truck);
        }

        int seconds = 0;
        while(!waitingTruck.isEmpty() || !bridge.isEmpty()) {
            seconds++;
            Truck truck = waitingTruck.peek();
            bridge.moveTrucks();

            if (truck == null) {
                continue;
            }

            if (bridge.availableStart(truck)) {
                bridge.add(truck);
                waitingTruck.poll();
            }
        }
        return seconds;
    }

    static class Bridge {
        private Queue<Truck> queue;
        private int length;
        private int maxWeight;
        private int currentWeight;

        public Bridge(int length, int maxWeight) {
            this.length = length;
            this.maxWeight = maxWeight;
            queue = new LinkedList<>();
        }

        public boolean availableStart(Truck truck) {
            if (currentWeight + truck.getWeight() <= maxWeight) {
                return true;
            }
            return false;
        }

        public void add(Truck truck) {
            truck.start();
            queue.add(truck);
            currentWeight += truck.getWeight();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void moveTrucks() {
            // while 로 변경
            int i=0;

            for (Truck truck : queue) {
                if (truck.getCurrentPosition() >= length) {
                    Truck movedTruck = queue.poll();
                    currentWeight = currentWeight - movedTruck.getWeight();
                } else {
                    truck.move();
                }
            }
        }
    }

    static class Truck {
        private int weight;
        private int currentPosition;

        public Truck(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public int getCurrentPosition() {
            return currentPosition;
        }

        public void move() {
            currentPosition++;
        }

        public void start() {
            currentPosition = 1;
        }
    }

}
