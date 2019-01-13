package Programmers.Hashing.Question2;

/**
 * @author choijaeyong on 13/01/2019.
 * @project Algorithm
 * @description
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 *
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 입출력 예제
 * phone_book	return
 * [119, 97674223, 1195524421]	false
 * [123,456,789]	true
 * [12,123,1235,567,88]	false
 * 입출력 예 설명
 * 입출력 예 #1
 * 앞에서 설명한 예와 같습니다.
 *
 * 입출력 예 #2
 * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
 *
 * 입출력 예 #3
 * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
 */
public class Solution {
  public static void main(String[] args) {
    String[] phone_book = {"119","97674223","1195524421"};

    System.out.println(solution(phone_book));



  }

  public static boolean solution(String[] phone_book) {
    // 접두어가 없으면 true
    boolean answer = true;
    int size = phone_book.length;

    for(int i=0; i < size-1 ; i++) {

      word:for(int j=i+1 ; j < size ; j++) {

        String prefix="";
        String word="";

        if(phone_book[i].length() > phone_book[j].length()) {
          prefix = phone_book[j];
          word = phone_book[i];
        } else {
          prefix = phone_book[i];
          word = phone_book[j];
        }

        int prefixLength = prefix.length();

        for(int k=0; k < prefixLength ; k++) {
          if(prefix.charAt(k) != word.charAt(k)) {
            // 접두어랑 단어 앞부분이 다르면 다음 단어 검색
            //System.out.println("prefix : " + prefix + "    word : " + word + "   continue");
            continue word;
          }
        }

        //System.out.println("prefix : " + prefix + "    word : " + word + "   return false");
        // 접두어랑 단어 앞부분이 같을 경우에만 여기를 읽게됨.
        return false;
      }

    }




    return answer;
  }

}
