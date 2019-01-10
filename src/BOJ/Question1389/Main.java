package BOJ.Question1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author choijaeyong on 10/01/2019.
 * @project Algorithm
 * @description
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    String[] lineArr = line.split(" ");

    int userNums = Integer.parseInt(lineArr[0]);
    int relationNums = Integer.parseInt(lineArr[1]);

    int[][] relations = new int[relationNums][2];
    for(int i=0; i < relationNums ; i++) {
      String relation = br.readLine();
      String[] relationArray = relation.split(" ");

      relations[i][0] = Integer.parseInt(relationArray[0]);
      relations[i][1] = Integer.parseInt(relationArray[1]);
    }

    // 유저생성
    Graph graph = new Graph(userNums);
    // 관계생성
    for(int[] relation : relations) {
      graph.setFriends(relation[0],relation[1]);
    }
    graph.calcKevinNum();
    System.out.println(graph.getWinner());



  }


}


class User {
  private List<User> friends;
  private int name;
  private int kevinNum;
  private int pathCount;
  private boolean visited;

  public User(int name) {
    this.name = name;
    friends = new ArrayList<>();
    this.kevinNum = 0;
    this.pathCount=0;
    this.visited = false;
  }

  public void addFriend(User user) {
    this.friends.add(user);
  }

  public void addKevinNum(int pathCount) {
    kevinNum += pathCount;
  }


  public List<User> getFriends() {
    return friends;
  }


  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  public int getKevinNum() {
    return kevinNum;
  }

  public void setKevinNum(int kevinNum) {
    this.kevinNum = kevinNum;
  }

  public int getPathCount() {
    return pathCount;
  }

  public void setPathCount(int pathCount) {
    this.pathCount = pathCount;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}

class Graph {
  private List<User> userList;

  public Graph(int size) {
    userList = new ArrayList<>(size);
    for(int i=0; i < size ; i++) {
      userList.add(new User(i+1));
    }
  }

  public void setFriends(int userName1, int userName2) {
    User user1 = userList.get(userName1 - 1);
    User user2 = userList.get(userName2 - 1);

    if(!user1.getFriends().contains(user2)) {
      user1.addFriend(user2);
    }
    if(!user2.getFriends().contains(user1)) {
      user2.addFriend(user1);
    }
  }

  // 사람 한명의 케빈베이컨 수를 조회.
  // 사람 한명 조사하고 다음 사람 조회할 때. 매번 방문여부랑. pathCount 초기화 해줘야해.
  public int calcKevinNum(User user) {
    resetVisited();
    resetPathcount();


    Queue<User> queue = new LinkedList<>();
    user.setVisited(true);
    queue.add(user);

    while(!queue.isEmpty()){
      User root = queue.peek();
      List<User> rootFriends = root.getFriends();

      // user 의 친구들 검사.
      for(User friend : rootFriends) {
        if(friend.isVisited() == false) {
          friend.setVisited(true);
          friend.setPathCount(root.getPathCount() + 1);
          queue.add(friend);
        }
      }
      user.addKevinNum(queue.poll().getPathCount());
    }
    return user.getKevinNum();
  }

  public void resetPathcount() {
    for(User user : userList) {
      user.setPathCount(0);
    }
  }

  public void resetVisited() {
    for(User user : userList) {
      user.setVisited(false);
    }
  }

  public void calcKevinNum() {
    for(User user : userList) {
      calcKevinNum(user);

    }
  }

  // 앞에서부터 검색하면... 케빈베이컨 수가 최저인 사람이 2명이상일 경우
  // 맨 뒤에 유저가 출력된다. 해서 뒤에서부터 검색하면 맨 앞의 유저가 결과로 나올것이다.
  public int getWinner() {
    int size = userList.size();
    int min = userList.get(size-1).getKevinNum();
    int winner = userList.get(size-1).getName();

    for(int i=size-1; i >= 0 ; i--) {
      User user = userList.get(i);
      if(user.getKevinNum() <= min) {
        min = user.getKevinNum();
        winner = user.getName();
      }
    }

    return winner;

  }




}
