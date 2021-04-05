package Topcoder.Chapter05.Question04;

/*
P 112

존과 브루스는 대학에서 문자열 이론을 공부하고 싶습니다. 브루스는 회문을 아주 좋아합니다?
회문은 앞에부터 읽으나, 뒤에서부터 일으나 같은 단어를 말합니다. 존은 부르스를 임의의 문자열 s로
회문을 만들어 브루스를 깜짝 놀래켜주고 싶습니다. 이때 존은 문자열 s 뒤에 0개 이상의 숫자를
추가해 회문을 생성하려고 합니다. 존이 생성할 수 있는 가장 짧은 회문의 길이를 리턴하세요.

 */


public class Main {
  public static void main(String[] args) {
    String s = "abdfhdyrbdbsdfghjkllkjhgfds";

    StringBuffer sb = new StringBuffer(s);
    StringBuffer reverse = reverseString(s);

    System.out.println(isPalindrome(sb));
    System.out.println(sb.append(reverse));
    System.out.println(removeFirstChar(reverse));

    System.out.println(find(s));

  }

  public static int find(String s) {
    StringBuffer sb = new StringBuffer(s);
    int result = Integer.MAX_VALUE;

    if(!isPalindrome(sb)) {
      // 회문이 아니라면!??
      System.out.println("회문이 아니라면!");

      StringBuffer reverseSb = reverseString(s);

      // 글자수만큼 반복한다.
      for(int i=0; i < sb.length() ; i++) {
        StringBuffer temp = new StringBuffer();
        temp.append(sb);
        temp.append(reverseSb);

        if(isPalindrome(temp) && temp.length() < result) {

          result = temp.length();
        }
        reverseSb = removeFirstChar(reverseSb);
      }
      return result;
    } else {
      // 회문이면 주어진 문자열 길이를 리턴해준다.
      return s.length();
    }

  }

  // 이미 회문인가?
  public static boolean isPalindrome(StringBuffer sb) {

    // abacaba
    String s = sb.toString();

    char[] chars = s.toCharArray();
    int indexLength = chars.length-1;  // 마지막 인덱스

    for(int i=0; i < chars.length ; i++) {
      if(chars[i] != chars[indexLength-i]) {
        return false;
      }
    }
    return true;
  }


  // 글자 뒤집기
  public static StringBuffer reverseString(String s) {
    StringBuffer sb = new StringBuffer();
    for(int i=s.length()-1; i >= 0 ; i--) {
      sb.append(s.charAt(i));
    }
    return sb;
  }

  // 앞에 한글자 빼기
  public static StringBuffer removeFirstChar(StringBuffer sb) {
    StringBuffer newSb = new StringBuffer();
    for(int i=1; i < sb.length() ; i++) {
      newSb.append(sb.charAt(i));
    }
    return newSb;
  }


}
