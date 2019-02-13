package etc.Study2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author choijaeyong on 13/02/2019.
 * @project Algorithm
 * @description
 *
 * Set Map 예제
 */
public class SetMapExam {

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    int[] soldires = {3,4,3,100,2,2,3,0,0};

    System.out.println(solution(soldires));


  }

//  public static int solution(int[] ranks) {
//    // write your code in Java SE 8
//    int result = 0;
//
//    Arrays.sort(ranks);
//
//    int[] uniqueRanks = Arrays.stream(ranks).distinct().toArray();
//
//    List<Integer> uniqueRanksList = new ArrayList<>();
//
//    int uniqueRanksLength = uniqueRanks.length;
//
//    for(int i=0; i < uniqueRanksLength -1  ; i++) {
//      if(uniqueRanks[i] + 1 == uniqueRanks[i+1]) {
//        uniqueRanksList.add(uniqueRanks[i]);
//      }
//    }
//
//    int ranksLength = ranks.length;
//    int uniqueRanksListSize = uniqueRanksList.size();
//
//    for(int i=0; i < ranksLength ; i++) {
//      for(int j=0 ; j < uniqueRanksListSize ; j++) {
//        if(ranks[i] == uniqueRanksList.get(j)) {
//          result++;
//        }
//      }
//    }
//
//    return result;
//  }

  public static int solution(int[] ranks) {
    // write your code in Java SE 8
    int cnt =0;
    Set<Integer> set = new HashSet<>();

    Map<Integer, Integer> map = new HashMap<>();

    for(int rank : ranks) {
      map.put(rank, map.get(rank) == null ? 1 : map.get(rank) +1);
      set.add(rank);
    }

    Iterator<Integer> itr = set.iterator();

    while(itr.hasNext()) {
      int num = itr.next();
      if(map.get(num) != null && map.get(num+1) != null) {
        cnt += map.get(num);
      }

    }

    return cnt;
  }

}
