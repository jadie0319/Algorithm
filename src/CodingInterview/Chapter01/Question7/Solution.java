package CodingInterview.Chapter01.Question7;

/**
 * @author choijaeyong on 31/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-7 행렬 회전 : 이미지를 표현하는 N * X 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
 * 이때, 이미지를 90도 회전시키는 메서드를 작성하라. 행렬을 추가로 사용하지 않고서도 할 수 있겠는가?
 */
public class Solution {

  public static void main(String[] args) {

    int[][] intArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

    for(int[] k : intArray) {
      System.out.println(k[0] + " " + k[1] + " " + k[2] + " " + k[3]);
    }

    intArray = rotate(intArray);

    for(int[] k : intArray) {
      System.out.println(k[0] + " " + k[1] + " " + k[2] + " " + k[3]);
    }


  }


  public static int[][] rotate(int[][] intArray) {

    int size = intArray.length;

    // 4*4 일때 가장자리 사각형과 안쪽 사각형.총 2번 회전시켜야 한다.
    for(int layer = 0 ; layer < size /2 ; layer++) {

      int first = layer;
      int last = size - 1 - layer;

      // for 문 한번에 4개의 숫자 위치를 바꾼다.
      for(int i=first ; i < last ; i++ ) {

        int offset = i-first;
        int top = intArray[first][i];

        // 13,9,5 를 (위쪽)1,2,3으로 옮기는 작업.
        intArray[first][i] = intArray[last-offset][first];

        // 16,15,14 를 (왼쪽)13,9,5로 옮기는 작업
        intArray[last-offset][first] = intArray[last][last-offset];

        // 4,8,12를 (아래로)16,15,14로 옮기는 작업.
        intArray[last][last-offset] = intArray[i][last];

        // 1,2,3을 (오른쪽)4,8,12 로 옮기는 작업.
        intArray[i][last] = top;


      }

    }




    return intArray;
  }

}
