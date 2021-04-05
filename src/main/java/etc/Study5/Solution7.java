package etc.Study5;

/**
 * @author choijaeyong on 16/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution7 {
  public static void main(String[] args) {

    Solution7 solution7 = new Solution7();
    String word = "browoanoommnaon";
    String word2 = "zyelleyz";
    String word3 = "abcde";
    System.out.println(word3);
    System.out.println(solution7.solution(word3));
  }

  public String solution(String word) {
    String answer="";

    while(isSuccessive(word)) {
      word = decode(word);
    }

    answer = word;

    return answer;
  }

  public boolean isSuccessive(String word) {
    // 연속된 알파벳이 있다면?
    int wordLength = word.length();

    for(int i=0 ; i < wordLength-1 ; i++) {
      if(word.charAt(i) == word.charAt(i+1)) {
        return true;
      }
    }
    return false;
  }


  public String decode(String word) {

    int wordLength = word.length();
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i < wordLength-1 ; i++) {
      if(word.charAt(i) == word.charAt(i+1)) {
        if(i+2 < wordLength-1) {
          i=i+1;
        } else if(i+2 == wordLength-1) {
          sb.append(word.charAt(i+2));
          return sb.toString();
        }
      } else if(word.charAt(i) != word.charAt(i+1) && i == wordLength -2) {
        sb.append(word.charAt(i));
        sb.append(word.charAt(i+1));
      } else {
        sb.append(word.charAt(i));
      }
    }

    //System.out.println(sb.toString());
    return sb.toString();
  }

}
