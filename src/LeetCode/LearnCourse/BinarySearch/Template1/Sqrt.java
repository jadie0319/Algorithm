package LeetCode.LearnCourse.BinarySearch.Template1;

/**
 * @author choijaeyong on 15/03/2019.
 * @project Algorithm
 * @description
 * https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
 */
public class Sqrt {
  public static void main(String[] args) {

    int x = 9;
    System.out.println(mySqrt2(x));

  }

  public static int mySqrt(int x) {

    double root = Math.sqrt(x);
    System.out.println(root);

    return (int)root;
  }

  public static int mySqrt2(int x) {

    long l = 1;
    long r = x;
    long mid=0;

    while(l < r) {
      System.out.println("1. l : " + l + "  r : " + r + "  mid : " + mid);
      mid = l + (r-l)/2;
      System.out.println("2. l : " + l + "  r : " + r + "  mid : " + mid + "   x/mid : " + x/mid);
      if(mid == x / mid) {
        return (int)mid;
      } else if (mid > x / mid) {
        r = mid-1;
      }else{
        l = mid+1;
      }
      System.out.println("3. l : " + l + "  r : " + r + "  mid : " + mid + "   x/mid : " + x/mid);
      System.out.println();

    }

    return l > x /l ? (int)l-1 : (int)l;
  }

}
