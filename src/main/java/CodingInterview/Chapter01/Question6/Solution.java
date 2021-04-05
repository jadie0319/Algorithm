package CodingInterview.Chapter01.Question6;

/**
 * @author choijaeyong on 31/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-6 문자열 압축 : 반복되는 문자의 개수를 세는 방식의 기본적인 문자열 압축 메서드를 작성하라.
 * 예를 들어 문자열 aabcccccaaa를 압축하면 a2b1c5a3이 된다. 만약 '압축된' 문자열의 길이가 기존 문자열의
 * 길이보다 길다면 기존 문자열을 반환한다. 문자열은 대소문자 알파벳(a~z)로만 이루어져 있다.
 *
 */
public class Solution {

  public static void main(String[] args) {
    String str = "aabcccccaaa";

    System.out.println(compressedString(str));

  }

  public static String compressedString(String str) {

    char[] chars = str.toCharArray();
    int strLength = str.length();
    int strCount = 0;
    StringBuilder sb = new StringBuilder();

    for(int i=0; i < strLength ; i++) {

      strCount++;

      if(i+1 >= strLength || chars[i] != chars[i+1]) {
        sb.append(chars[i]);
        sb.append(strCount);
        strCount=0;
      }
    }


    return sb.length() >= strLength ? str : sb.toString();
  }

}

// 만약 if 안의 두 조건이. 순서가 반대로 되어 있으면 arrayOutOfBound?? 이런 뭐 오류가 난다.
// 생각해서 배치하자.