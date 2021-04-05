package BOJ.Question1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author choijaeyong on 09/01/2019.
 * @project Algorithm
 * @description
 */

/*

https://www.acmicpc.net/problem/1389

케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다. 케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.

예를 들면, 전혀 상관없을 것 같은 인하대학교의 이강호와 서강대학교의 민세희는 몇 단계만에 이어질 수 있을까?

천민호는 이강호와 같은 학교에 다니는 사이이다. 천민호와 최백준은 Baekjoon Online Judge를 통해 알게 되었다. 최백준과 김선영은 같이 Startlink를 창업했다. 김선영과 김도현은 같은 학교 동아리 소속이다. 김도현과 민세희는 같은 학교에 다니는 사이로 서로 알고 있다. 즉, 이강호-천민호-최백준-김선영-김도현-민세희 와 같이 5단계만 거치면 된다.

케빈 베이컨은 미국 헐리우드 영화배우들 끼리 케빈 베이컨 게임을 했을때 나오는 단계의 총 합이 가장 적은 사람이라고 한다.

오늘은 Baekjoon Online Judge의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 찾으려고 한다. 케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합이다.

예를 들어, BOJ의 유저가 5명이고, 1과 3, 1과 4, 2와 3, 3과 4, 4와 5가 친구인 경우를 생각해보자.

1은 2까지 3을 통해 2단계 만에, 3까지 1단계, 4까지 1단계, 5까지 4를 통해서 2단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 2+1+1+2 = 6이다.

2는 1까지 3을 통해서 2단계 만에, 3까지 1단계 만에, 4까지 3을 통해서 2단계 만에, 5까지 3과 4를 통해서 3단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 2+1+2+3 = 8이다.

3은 1까지 1단계, 2까지 1단계, 4까지 1단계, 5까지 4를 통해 2단계 만에 알 수 있다. 따라서, 케빈 베이컨의 수는 1+1+1+2 = 5이다.

4는 1까지 1단계, 2까지 3을 통해 2단계, 3까지 1단계, 5까지 1단계 만에 알 수 있다. 4의 케빈 베이컨의 수는 1+2+1+1 = 5가 된다.

마지막으로 5는 1까지 4를 통해 2단계, 2까지 4와 3을 통해 3단계, 3까지 4를 통해 2단계, 4까지 1단계 만에 알 수 있다. 5의 케빈 베이컨의 수는 2+3+2+1 = 8이다.

5명의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람은 3과 4이다.

BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램을 작성하시오.

 */

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    String[] humansAndRelations = line.split(" ");

    int humans = Integer.parseInt(humansAndRelations[0]);
    int relations = Integer.parseInt(humansAndRelations[1]);

    // 사람 생성.
    List<Human> humanList = new ArrayList<>();
    for(int i=0 ; i < humans ; i++) {
      humanList.add(new Human(i));
    }
    //System.out.println(humanList.size());


    // 관계 생성.
    for(int i=0; i < relations ; i++) {
      String inputRelation = br.readLine();
      String[] humansInRelation = inputRelation.split(" ");

      // 휴먼의 인덱스.
      int human1 = Integer.parseInt(humansInRelation[0]) - 1;
      int human2 = Integer.parseInt(humansInRelation[1]) - 1;

      // 양방향 관계!
      humanList.get(human1).setHumanRelation(humanList.get(human2));
      humanList.get(human2).setHumanRelation(humanList.get(human1));
    }
    // 관계설정 끝.

//    for(Human human : humanList) {
//      System.out.println("이름 : "+human.getHumanNum() + "   관계수 : " + human.getHumanList().size());
//    }



    // 케빈베이컨의 수 구하는 메소드

    int min=Integer.MAX_VALUE;
    for(int i=0; i < humans ; i++) {
      int temp = getKevinNum(humanList.get(i), humanList);
      min = min > temp ? temp : min;
    }

    for(int i=0; i < humans ; i++) {
      if(humanList.get(i).getKevinNum() == min) {
        System.out.println(humanList.get(i).getHumanNum()+1);
        return;
      }
    }

//    System.out.println(human.getHumanNum());

  }

  public static int getKevinNum(Human human, List<Human> humanList) {

    // 본인을 제외하고 한바퀴 돌아야혀.
    int counting = humanList.size();
    int result=0;
    int pathsCount =0;

    for(int i=0; i < counting ; i++) {

      if(i ==  human.getHumanNum()) {
        //System.out.println("i : " + i + " human.getHumanNum() :  " + human.getHumanNum() + "  넘어가");
        continue;
      }

      Queue<Human> queue = new LinkedList<>();

      // 본인 먼저 넣기.
      queue.add(human);
      queue.add(new Human(-1));

      // 1번 휴먼의. 2,3,4,5 사람과의 관계 케빈 수 찾는 while
      relation:while(!queue.isEmpty()) {
        if(queue.peek().getHumanNum() == -1) {
          pathsCount++;
          queue.poll();
          //System.out.println("pathsCount 를 더해준다. 현재값 ?  "+pathsCount);
          continue relation;
        }


        Human root = queue.poll();
        //System.out.println("root num : " + root.getHumanNum());
        int relationNums = root.getHumanList().size();
        //System.out.println("root relationNums : " + root.getHumanList().size());
        if(root.getHumanList().size() == 1 && root.getHumanList().get(0).getHumanNum() == i) {
          //System.out.println("관계리스트 크기가 1이고 이게 목표 값과 같다면 continue~");
          pathsCount++;
          continue  relation;
        }


        // root 가 가진 관계들을 생각!


        // 관계가 있으면?

        // 그 관계들을 큐에 넣어라.근데? 만약 찾으려는 인간이면? break!!

        for(int j=0 ; j < relationNums ; j++) {

          //System.out.println("i : " + i + " j : "+ j + "  root.getHumanList().get(j).getHumanNum() : " + root.getHumanList().get(j).getHumanNum());
          if(human.getHumanNum() == root.getHumanList().get(j).getHumanNum()) {
            //System.out.println("중복!");
            continue;
          }
          // i 번째 사람 == root의 친구관계들에 i 사람이 있으면.?
          if(i == root.getHumanList().get(j).getHumanNum()) {
            //System.out.println("i : " + i + "   root.getHumanList().get(j).getHumanNum() : " + root.getHumanList().get(j).getHumanNum() + " 이면?");
            pathsCount++;
            //System.out.println("break!!!!     path : " + pathsCount);
            break relation;
          } else {
            //System.out.println("queue add : " + root.getHumanList().get(j).getHumanNum());
            queue.add(root.getHumanList().get(j));
          }

        }// 관계 검색 끝.


//        pathsCount++;
//        System.out.println("pathsCount 를 더해준다. 현재값 ?  "+pathsCount);


      } // while 끝.




    }
    result = pathsCount;


    human.setKevinNum(result);

    return human.getKevinNum();
  }

}

class Human {
  private List<Human> humanList;
  private int kevinNum=0;
  private int humanNum;

  public Human(int humanNum) {
    this.humanNum = humanNum;
    this.humanList  = new ArrayList<>();
  }

  public void setHumanRelation(Human human2) {
    // 중복 막아라.
    if(this.humanList.contains(human2)) {
      return;
    } else {
      this.humanList.add(human2);
    }

  }

  public List<Human> getHumanList() {
    return humanList;
  }

  public void setHumanList(List<Human> humanList) {
    this.humanList = humanList;
  }

  public int getHumanNum() {
    return humanNum;
  }

  public int getKevinNum() {
    return kevinNum;
  }

  public void setKevinNum(int kevinNum) {
    this.kevinNum = kevinNum;
  }
}
