package etc.Study5;

import java.util.Calendar;

/**
 * @author choijaeyong on 16/03/2019.
 * @project Algorithm
 * @description
 */
public class Solution6 {

  public static void main(String[] args){
    int totalTicket = 2000;
    String[] logs = {
        "woni request 09:12:29",
        "brown request 09:23:11",
        "brown leave 09:23:44",
        "jason request 09:33:51",
        "jun request 09:33:56",
        "cu request 09:34:02"};

    Solution6 solution6 = new Solution6();
    solution6.solution(totalTicket,logs);
  }

  public String[] solution(int totalTicket, String[] logs) {
    String[] answer = {};
    boolean access = false;

    String firstId="";
    String firstStatus="";
    String firstTime="";

    int logsLength = logs.length;

    for(int i=0 ; i < logsLength ; i++) {
      String[] log = logs[i].split(" ");
      if(i==0) {
        firstId = log[0];
        firstStatus = log[1];
        firstTime = log[2];
        int time = Integer.parseInt(firstTime.split(":")[1])*60 + Integer.parseInt(firstTime.split(":")[2]);
        System.out.println(time);
        continue;
      }

      String userId = log[0];
      String userStatus = log[1];
      String userTime = log[2];





    }




    return answer;
  }
}
