package CodingInterview.Chapter01.Question3;

import java.util.Arrays;

/**
 * @author choijaeyong on 21/01/2019.
 * @project Algorithm
 * @description
 *
 * 1-3. URL화 : 문자열에 들어 있는 모든 공백을 '%20'으로 바꿔 주는 메서드를 작성하라. 최종적으로 모든 문자를
 * 다 담을 수 있을 만큼 충분한 공간이 이미 확보되어 있으며 문자열의 최종 길이가 함께 주어진다고 가정해도 된다.
 * (자바로 구현한다면 배열 안에서 작업할 수 있도록 문자배열을 이용하길 바란다.)
 */
public class Main {

  public static void main(String[] args) {
    String str = "Mr John Smith";

    char[] chars = str.toCharArray();
    int length = chars.length;

    char[] newChars = Arrays.copyOf(chars,100);
    System.out.println("처음 문자열 길이 : " +  length);

    // 문제에서 최종 공간이 충분히 확보되어 있다고 하기에 만들어 놓은 것.
    System.out.println("newChars 길이 : " + newChars.length);

    int space=0;
    for(int i=0; i < length ; i++) {
      if(chars[i] == ' ') {
        space++;
      }
    }

    int index = str.length() + space * 2;
    for(int i=length -1 ; i >=0 ; i--) {
      if(chars[i] == ' ') {
        newChars[index-1] = '0';
        newChars[index-2] = '2';
        newChars[index-3] = '%';
        index = index - 3;
      }else {
        newChars[index-1] = newChars[i];
        index--;
      }
    }

    System.out.println(newChars);


  }


}