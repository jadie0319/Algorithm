package etc.Study3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author choijaeyong on 23/02/2019.
 * @project Algorithm
 * @description
 *
 */
public class Solution3 {
  public static void main(String[] args) {
    int[] healths = {200,120,150};
    int[] healths2 = {300,200,500};

    int[][] items = {{30,100},{500,30},{100,400}};
    int[][] items2 = {{1000, 600}, {400, 500}, {300, 100}};

    System.out.println(solution(healths2,items2));

  }

  public static int[] solution(int[] healths, int[][] items) {

    List<User> userList = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();

    List<Item> usedItems = new ArrayList<>();

    for(int health : healths) {
      userList.add(new User(health));
    }

    int itemLength = items.length;

    for(int i=0; i < itemLength ; i++) {
      itemList.add(new Item(i+1,items[i][0],items[i][1]));
    }

//    for(User user : userList) {
//      System.out.println(user.getHealth());
//    }
//    for(Item item : itemList) {
//      System.out.println(item.getUpAttack() + "   " + item.getDownHealth());
//    }

    userList.sort(Comparator.comparing(User::getHealth).reversed());
    itemList.sort(Comparator.comparing(Item::getUpAttack));


    for(User user : userList) {
      System.out.println(user.getHealth());
    }
    for(Item item : itemList) {
      System.out.println(item.getUpAttack() + "   " + item.getDownHealth());
    }


    for(Item item : itemList) {
      for(User user : userList) {
        if(user.isUsingItem()) {
          continue;
        }

        if(user.getHealth() - item.getDownHealth() >= 100) {
          usedItems.add(item);
          user.setUsingItem(true);
          break;
        }

      }
    }

    int[] answer = new int[usedItems.size()];

    usedItems.sort(Comparator.comparing(Item::getIdx));

    for(int i=0; i < answer.length ; i++) {
      answer[i] = usedItems.get(i).getIdx();
    }

    System.out.println(Arrays.toString(answer));

    return answer;
  }

}

class User {
  private int health;
  private boolean usingItem;

  public User(int health) {
    this.health = health;
    this.usingItem = false;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public boolean isUsingItem() {
    return usingItem;
  }

  public void setUsingItem(boolean usingItem) {
    this.usingItem = usingItem;
  }
}

class Item {
  private int upAttack;
  private int downHealth;
  private int idx;

  public Item(int idx, int upAttack, int downHealth) {
    this.idx = idx;
    this.upAttack = upAttack;
    this.downHealth = downHealth;
  }

  public int getUpAttack() {
    return upAttack;
  }

  public int getDownHealth() {
    return downHealth;
  }

  public int getIdx() {
    return idx;
  }

}