package LeetCode.LearnCourse.BinarySearch.Template2;

/**
 * @author choijaeyong on 19/03/2019.
 * @project Algorithm
 * @description
 * https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
 */
public class FirstBadVersion {

  public int firstBadVersion(int n) {
    int left = 1;
    int right = n;

    while(left < right) {
      int mid = left + (right-left)/2;
      if(!isBadVersion(mid)) { // false 일때   // true 면 bad version, 왼쪽을 조사해봐야 한다.
        if(isBadVersion(mid+1)) {
          return mid+1;
        }
        left = mid+1;
      } else { // true 일때
        if(!isBadVersion(mid-1)) {
          return mid;
        }
        right = mid-1;
      }
    }

    if(left != n && isBadVersion(left) == true) {
      return left;
    }

    return n;

  }


  // LeetCode 에서 제공해주는 메소드.
  // 컴파일 오류 나는게 보기 싫어서 임시로 넣어둔 것!
  boolean isBadVersion(int version) {
    return true;
  }

}
