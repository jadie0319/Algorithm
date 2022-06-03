package dongbinna.part02.chapter06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 위에서아래로 {

    public static void main(String[] args) {
        int[] arr = {3,15,27,12};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int[] reverse = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(k -> k)
                .toArray();

        System.out.println(Arrays.toString(reverse));
    }

}
